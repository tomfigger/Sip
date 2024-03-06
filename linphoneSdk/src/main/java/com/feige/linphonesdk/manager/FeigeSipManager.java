package com.feige.linphonesdk.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.feige.linphonesdk.exception.FGSipException;
import com.feige.linphonesdk.utils.AccoutInfo;
import com.feige.linphonesdk.utils.SipListener;
import com.feige.linphonesdk.utils.SipStatus;
import com.feige.linphonesdk.utils.SipViewModel;
import com.voismart.crypto.BuildConfig;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.linphone.core.Account;
import org.linphone.core.AccountParams;
import org.linphone.core.Address;
import org.linphone.core.AudioDevice;
import org.linphone.core.AuthInfo;
import org.linphone.core.Call;
import org.linphone.core.CallParams;
import org.linphone.core.Core;
import org.linphone.core.CoreListenerStub;
import org.linphone.core.Factory;
import org.linphone.core.MediaEncryption;
import org.linphone.core.ProxyConfig;
import org.linphone.core.RegistrationState;
import org.linphone.core.TransportType;
import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cn.feige.apilibrary.base.LoginInfoCache;
import cn.feige.apilibrary.base.MyResourceSubscriber;
import cn.feige.apilibrary.base.exception.RxException;
import cn.feige.apilibrary.base.exception.TokenValidException;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import static org.linphone.core.Call.State.Connected;
import static org.linphone.core.Call.State.Idle;

public class FeigeSipManager {
   // public static final int NOTIFICATION_ID = 0xf88;
    private static final String TAG = "FeigeSipManager";
    private static final int WAHT_LOGIN = 2;
    public static int CAN_NOTICE = 0;
    public static int NOTICE_ING = 1;
    public static int NO_NOTICE = 2;
    private static volatile FeigeSipManager INSTANCE = null;
    public AtomicInteger noticeAtomic = new AtomicInteger(CAN_NOTICE);
    private ArrayList<SipListener> sipListeners = new ArrayList<>();
    private Context context;
    private Call.State callState = Idle;
    private boolean isMicMute = false;
    private boolean isMianti = false;
   // private int loginState = 0;
    private AtomicInteger loginState = new AtomicInteger(0);
    private String realPhone;
    //private Ringtone inCommingRingtone;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == WAHT_LOGIN) {
                if (!isLogin() && AppUtils.isAppForeground() && NetworkUtils.isConnected()) {
                    sipLogin(context,accountInfo);
                }
            }
        }
    };
    private Ringtone outgoingCallRingtone;
    private ResourceSubscriber<Long> timerSubscriber;
    private long callSeconds;
    private String errMsg = "";
    private boolean isInit = false;
    private String callCustomerId;
    private String callConcatId;
    private boolean hold = false;
    private boolean isInCommingPhone = false;
    private boolean isActivelyHangUp;
    private AccoutInfo accountInfo;
    private Factory factory;
    private Core core;
    private String custormsStr;
    private String displayPhone;

    public static FeigeSipManager getInstance() {
        if (INSTANCE == null) {
            synchronized (FeigeSipManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FeigeSipManager();
                }
            }
        }
        return INSTANCE;
    }

    public String getDisplayPhone() {
        return StringUtils.isEmpty(displayPhone) ? realPhone : displayPhone;
    }

//    public void showCommingNotify(Context context) {
//        NotificationManager manager = context.getSystemService(NotificationManager.class);
//        Notification notification = createNotificationBuilder(context).build();
//        manager.notify(NOTIFICATION_ID, notification);
////        if (callNotificationManager == null) {
////            callNotificationManager = new CallNotificationManager(context);
////        }
////        callNotificationManager.setupNotification(false);
//    }

    public AtomicInteger getAtomicLoginState() {
        if (loginState == null) {
            loginState = new AtomicInteger(0);
        }
        return loginState;
    }

    private void noticeOfflineCall() {
        //不需要请求，或者正在通话
        if (!isLogin() || isCalling())
            return;
        //是否有离线通知来电
        Flowable.just(new Object())
                .subscribeOn(Schedulers.io())
                .filter(o -> noticeAtomic.compareAndSet(CAN_NOTICE, NOTICE_ING))
//                .delay(5, TimeUnit.SECONDS)
                .doOnNext(o -> {
                    SipViewModel splashViewModel = new SipViewModel();
                    splashViewModel.offlineCallComming(accountInfo.getName()).doOnNext(baseDataBeanResponse -> {
                                if (baseDataBeanResponse.code() != 200) {
                                    throw new RxException("网络请求失败");
                                }
                            }).retryWhen(new Function<Flowable<Throwable>, Publisher<?>>() {
                                private final int maxRetries = 3;
                                private final int retryDelayMillis = 1 * 1000;
                                private int retryCount = 0;

                                @Override
                                public Publisher<?> apply(Flowable<Throwable> throwableFlowable) {
                                    return throwableFlowable
                                            .flatMap(throwable -> {
                                                throwable.printStackTrace();
                                                boolean isLogin = LoginInfoCache.getLoginInfoToken() != null;
                                                if (throwable instanceof TokenValidException || !isLogin) {
                                                    return Flowable.error(throwable);
                                                }
                                                if (++retryCount <= maxRetries) {
                                                    // When this Flowable calls onNext, the original
                                                    // Flowable will be retried (i.e. re-subscribed).
                                                    Log.d("Retry", "get error, retry again " + retryCount);
                                                    return Flowable.timer(retryDelayMillis,
                                                            TimeUnit.MILLISECONDS);
                                                }

                                                // Max retries hit. Just pass the error along.
                                                return Flowable.error(throwable);
                                            });
                                }
                            })
                            .doOnTerminate(() -> {
                                noticeAtomic.set(NO_NOTICE);
                            })
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new MyResourceSubscriber());
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyResourceSubscriber());

    }

    public boolean isInit() {
        return isInit;
    }

    public int getLoginState() {
        return getAtomicLoginState().get();
    }
    public void addSipListener(SipListener sipListener) {
        if (!sipListeners.contains(sipListener)) {
            sipListeners.add(sipListener);
        }
    }

    public void finishCall() {
        //stopIncommingPlayRing();
       // stopOutgoingPlayRing();
//        NotificationManager manager = context.getSystemService(NotificationManager.class);
//        manager.cancel(NOTIFICATION_ID);
        resetStatus();
    }

    private void resetStatus() {
        if (isMicMute) {
            getCore().setMicEnabled(true);
            isMicMute = false;
        }
        if (hold) {
            hold = false;
        }
       // stopIncommingPlayRing();
       // stopOutgoingPlayRing();
        callState = Idle;
        Call currentCall = getCurrentCall();
        if (currentCall != null) {
            currentCall.terminate();
        }
        isInCommingPhone = false;
        realPhone = null;
        callCustomerId = null;
        custormsStr = null;
        displayPhone = null;
        callConcatId = null;
        if (isMianti) {
//            changeToincall(false);
            isMianti = false;
        }
        isActivelyHangUp = false;
        errMsg = "";
        //calcelTimerCall();
    }

//    private void playIncommingRing() {
//        AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
//        if (inCommingRingtone == null) {
//            //开始振铃
//            Uri parse = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getContext().getPackageName() + "/" + R.raw.incoming);
//            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
//            if (parse != null) {
//                inCommingRingtone = RingtoneManager.getRingtone(getContext(), parse);
//            }
//        }
//        if (inCommingRingtone == null) return;
//        int ringerMode = audioManager.getRingerMode();
//        if (ringerMode == AudioManager.RINGER_MODE_NORMAL) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//                inCommingRingtone.setLooping(false);
//            }
//            inCommingRingtone.play();
//            Log.d(TAG, "inCommingplayRing start play");
//        }
//    }

//    private void stopIncommingPlayRing() {
//        if (inCommingRingtone != null) {
//            inCommingRingtone.stop();
//            inCommingRingtone = null;
//        }
//    }

    private CoreListenerStub coreListener = new CoreListenerStub() {

        @Override
        public void onRegistrationStateChanged(Core core, ProxyConfig proxyConfig, RegistrationState state, String message) {
            log("onRegistrationStateChanged " + state + " with msg:" + message);
            if (state == RegistrationState.Ok) {
                //登陆成功
                getAtomicLoginState().set(2);
                handler.removeMessages(WAHT_LOGIN);

                //设置agent状态
                SipViewModel mainDialModel = new SipViewModel();
                String agentState = getAgentState();
                if (!"Logged Out".equalsIgnoreCase(agentState)) {
                    agentState = "Available";
                    setAgentState(agentState);
                }
                mainDialModel.agentState(agentState, accountInfo.getName()).subscribe(new MyResourceSubscriber());
                noticeOfflineCall();
                for (SipListener sipListener : sipListeners) {
                    sipListener.loginSuccess();
                }

            }
            else if(state == RegistrationState.Progress){
                getAtomicLoginState().set(1);
                for (SipListener sipListener : sipListeners) {
                    sipListener.loginProgress();
                }
            }
            else if(state==RegistrationState.Failed){
                getAtomicLoginState().set(0);

                for (SipListener sipListener : sipListeners) {
                    sipListener.loginFail(new FGSipException(state.ordinal(), "登录失败"));
                }
                noticeAtomic.compareAndSet(NO_NOTICE, CAN_NOTICE);
                Log.w(TAG, "登录失败，code：" + state);
                reconnect();
            }
        }

        @Override
        public void onAudioDevicesListUpdated(@NonNull Core core) {
            log("onAudioDevicesListUpdated");
            super.onAudioDevicesListUpdated(core);
            changeToincall(isMianti);
        }

        @Override
        public void onCallStateChanged(@NonNull Core core, @NonNull Call call, Call.State state, @NonNull String message) {
            log("onCallStateChanged " + state + " with msg:" + message);
            super.onCallStateChanged(core, call, state, message);
            callState = state;

            if (state == Call.State.OutgoingInit) {
                //去电
                try {
                    //playOutgoingCallRing();
                    changeToincall(isMianti);
                    realPhone = call.getRemoteAddress().getUsername();
                    for (SipListener sipListener : sipListeners) {
                        sipListener.onOutgoingCall(realPhone);
                    }
                   // isInCommingPhone = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (state == Call.State.OutgoingRinging) {
               // playOutgoingCallRing();
                changeToincall(isMianti);
            } else if (state == Call.State.OutgoingEarlyMedia) {
               // stopOutgoingPlayRing();
               // stopIncommingPlayRing();
                changeToincall(isMianti);
            } else if (state == Call.State.IncomingReceived || state == Call.State.PushIncomingReceived) {
                //来电
                try {
                    //playIncommingRing();
                    changeToincall(isMianti);
                    realPhone = call.getRemoteAddress().getUsername();
                    isInCommingPhone = true;
                    for (SipListener sipListener : sipListeners) {
                        sipListener.onIncomingCall(realPhone);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                if (!AppUtils.isAppForeground()) {
//                    showCommingNotify(getContext());
//                }
            } else if (state == Connected) {
               // stopIncommingPlayRing();
               // stopOutgoingPlayRing();
               // confirmedTime = System.currentTimeMillis();
                //beginCallTimer();
                changeToincall(isMianti);
                for (SipListener sipListener : sipListeners) {
                    sipListener.onCallConnected();
                }
            } else if (state == Call.State.StreamsRunning) {
                //通话中, 有音视频流.
            } else if (state == Call.State.UpdatedByRemote) {
                //通话变化, 有可能变成语音, 也有可能是带视频...
            } else if (state == Call.State.Released) {
                finishCall();
            } else if (state == Call.State.Error) {
                //挂电或结束通话
                if (!isActivelyHangUp && !StringUtils.isTrimEmpty(message)) {
                    if (message.equalsIgnoreCase("Busy Here")) {
                        message = "对方忙";
                    } else if (message.equalsIgnoreCase("Call released")) {
                        message = "已挂断";
                    } else if (message.equalsIgnoreCase("Temporarily Unavailable")) {
                        message = "暂时不可用";
                    } else if (message.equalsIgnoreCase("Request Terminated")) {
                        message = "请求终止";
                    }
                }
                finishCall();
            }
            for (SipListener sipListener : sipListeners) {
                sipListener.onCallState(callState.ordinal(),message);
            }
        }
    };

//    private void playOutgoingCallRing() {
//        AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
//        if (outgoingCallRingtone == null) {
//            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
//            Uri parse = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getContext().getPackageName() + "/" + R.raw.outgoing_ring);
//            if (parse != null) {
//                outgoingCallRingtone = RingtoneManager.getRingtone(getContext(), parse);
//            }
//        }
//        if (outgoingCallRingtone == null) return;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//            outgoingCallRingtone.setLooping(false);
//        }
//        outgoingCallRingtone.play();
//        Log.d(TAG, "outGoingplayRing start play");
//    }

//    private void stopOutgoingPlayRing() {
//        if (outgoingCallRingtone != null) {
//            outgoingCallRingtone.stop();
//            outgoingCallRingtone = null;
//        }
//    }
    public String getAgentState() {
        return SPUtils.getInstance("FEIGE_SIP_SP").getString("agentState");
    }

    public void setAgentState(String agentState) {
        SPUtils.getInstance("FEIGE_SIP_SP").put("agentState", agentState);
    }
    public boolean isMicMute() {
        return isMicMute;
    }

    public boolean isMianti() {
        return isMianti;
    }

    public void init(Context context) {
        this.context = context;

        getFactory();
        getCore();
        getCore().addListener(coreListener);
//        if (!EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().register(this);
//        }
        NetworkUtils.registerNetworkStatusChangedListener(new NetworkUtils.OnNetworkStatusChangedListener() {
            @Override
            public void onDisconnected() {
                handler.removeCallbacksAndMessages(null);
//                SipServiceCommand.handleIpChange(getContext());
            }

            @Override
            public void onConnected(NetworkUtils.NetworkType networkType) {
                reconnect(3 * 1000);
//                login();
            }
        });
        isInit = true;
    }

    private Core getCore() {
        if (core == null) {
            core = getFactory().createCore(null, null, getContext());
            core.setNativeRingingEnabled(false);
        }
        return core;
    }

    public Factory getFactory() {
        if (factory == null) {
            factory = Factory.instance();
            factory.setDebugMode(BuildConfig.DEBUG ? true : false, "Linphone");
        }
        return factory;
    }

    //登录
    public void login(Context context, String apiKey, String apiSecert, String userName) {
        SipViewModel mainDialModel = new SipViewModel();
        mainDialModel.login(apiKey, apiSecert, userName).doOnNext(accoutInfo -> {
            sipLogin(context, accoutInfo);
        }).subscribe(new MyResourceSubscriber() {
            @Override
            public void onError(Throwable throwable) {
                super.onError(throwable);
                for (SipListener sipListener : sipListeners) {
                    sipListener.loginFail(throwable);
                }
            }
        });
    }

    public void sipLogin(Context context, AccoutInfo accoutInfo) {
        if(accoutInfo==null){
            for (SipListener sipListener : sipListeners) {
                sipListener.loginFail(new FGSipException(SipStatus.LOGIN_INFO_MISS.status, SipStatus.LOGIN_INFO_MISS.msg));
            }
            return;
        }
        this.accountInfo = accoutInfo;
        try {
            handler.removeCallbacksAndMessages(null);
            if (!isInit) {
                init(context);
            }
            String server = accountInfo.getIp();
            String username = accountInfo.getName();
            String password = accountInfo.getPassword();
            String port = accountInfo.getPort();
            String domain = accountInfo.getRealm();

            if (TextUtils.isEmpty(server) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(port)) {
                for (SipListener sipListener : sipListeners) {
                    sipListener.loginFail(new FGSipException(SipStatus.LOGIN_INFO_MISS.status, SipStatus.LOGIN_INFO_MISS.msg));
                }
                return;
            }
            getAtomicLoginState().set(1);


            AuthInfo user = getFactory().createAuthInfo(username, null, password, null, null, domain, null);
            AccountParams accountParams = getCore().createAccountParams();
            // A SIP account is identified by an identity address that we can construct from the username and domain
            String sipAddress = "sip:" + username + "@" + domain;
            Address identity = getFactory().createAddress(sipAddress);
            Log.i("linphoneSdk","login for address " + sipAddress);

            accountParams.setIdentityAddress(identity);
            // We also need to configure where the proxy server is located
            Address address = getFactory().createAddress("sip:" + server + ":" + port);
            // We use the Address object to easily set the transport protocol
            address.setTransport(TransportType.Tcp);
            address.setPort(Integer.parseInt(port));
            accountParams.setServerAddress(address);
            accountParams.setOutboundProxyEnabled(true);
            // And we ensure the account will start the registration process
            accountParams.setRegisterEnabled(true);

            // Asks the CaptureTextureView to resize to match the captured video's size ratio
            //core.getConfig().setBool("video", "auto_resize_preview_to_keep_ratio", true);

            // Now that our AccountParams is configured, we can create the Account object
            Account account = getCore().createAccount(accountParams);
            log("login for username " + username + "@" + domain + " server:" + server + " port:" + port);

            //account.setCustomHeader("Header1", "Header2");
            // Now let's add our objects to the Core
            getCore().addAuthInfo(user);
            getCore().addAccount(account);

            // Also set the newly added account as default
            getCore().setDefaultAccount(account);
            getCore().setUserAgent("Feige_Andorid_Sip", null);

            // Finally we need the Core to be started for the registration to happen (it could have been started before)
            getCore().start();
            //SipCoreService.startForegroundSerice(getContext());
        } catch (Exception e) {
            e.printStackTrace();
            //CrashReport.postCatchedException(e);
        }
    }

    public void logout() {
        //log("logout");
        Account account = getCore().getDefaultAccount();
        if (account != null) {
            AccountParams accountParams = account.getParams().clone();
            accountParams.setRegisterEnabled(false);
            account.setParams(accountParams);
            getCore().removeAccount(account);
            getCore().clearAccounts();
            getCore().clearAllAuthInfo();
        }
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        getAtomicLoginState().set(0);
    }

    public Call getCallId() {
        return getCurrentCall();
    }

    private Context getContext() {
        return context;
    }

    //语音呼叫
    public void call(String displayPhone, String realPhone, String customerId, String concatId) {
         Flowable.just(new Object()).subscribeOn(Schedulers.io()).doOnNext(o -> {
            if (TextUtils.isEmpty(realPhone)) {
                throw new RxException("请输入呼叫号码！");
            }
            if (isCalling()) {
                throw new RxException("通话正在进行中");
            }
            try {
                this.displayPhone = displayPhone;
                AccountParams params1 = getCore().getDefaultAccount().getParams();
                // As for everything we need to get the SIP URI of the remote and convert it to an Address
                String remoteSipUri = "sip:" + realPhone + "@" + params1.getDomain();
                Address remoteAddress = getFactory().createAddress(remoteSipUri);
                if (remoteAddress == null) return;
                // If address parsing fails, we can't continue with outgoing call process

                // We also need a CallParams object
                // Create call params expects a Call object for incoming calls, but for outgoing we must use null safely
                CallParams params = getCore().createCallParams(null);
                if (!StringUtils.isTrimEmpty(custormsStr)) {
                    params.addCustomHeader("X-Customer-Info", custormsStr);
                    custormsStr = null;
                }

                // We can now configure it
                // Here we ask for no encryption but we could ask for ZRTP/SRTP/DTLS
                params.setMediaEncryption(MediaEncryption.None);
                params.setVideoEnabled(false);

                //show preview before caling.
                //core.enableVideoPreview(video);

                // Finally we start the call
                getCore().inviteAddressWithParams(remoteAddress, params);
                //回声消除
                // Call process can be followed in onCallStateChanged callback from core listener
            } catch (Exception e) {
                e.printStackTrace();
               // CrashReport.postCatchedException(e);
                throw new RxException("拨打失败，请稍后再试");
            }
            callCustomerId = customerId;
            callConcatId = concatId;
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new MyResourceSubscriber());
    }

    public boolean isCalling() {
        return callState != Idle;
    }


    public void onDestroy() {
       // log("onDestroy");
        reject();
        logout();
        if (coreListener != null) {
            try {
                getCore().removeListener(coreListener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        getAtomicLoginState().set(0);
        isInit = false;
        callCustomerId = null;
        custormsStr = null;
        displayPhone = null;
        callConcatId = null;
        noticeAtomic.set(CAN_NOTICE);
        core = null;
        factory = null;
        Log.i(TAG, "FeigeSipManager  onDestroy ");
    }

    public String getRealPhone() {
        return realPhone;
    }

    private void reconnect() {
        reconnect(10 * 1000);
    }

    private void reconnect(long delayMillis) {
        //log("reconnect");
        if (isOffline()) {
            if (AppUtils.isAppForeground() && NetworkUtils.isConnected() && getAtomicLoginState().get()!=2) {
                Log.w(TAG, "sip 正在重新登录");
                getAtomicLoginState().set(1);
                handler.removeCallbacksAndMessages(null);
                handler.sendEmptyMessageDelayed(WAHT_LOGIN, delayMillis);
            } else {
                getAtomicLoginState().set(0);
            }
        }

    }

    public Call.State getCallState() {
        return callState;
    }

    /**
     * 拒接电话
     */
    public void reject() {
        try {
            callTerminate();
            finishCall();
            isActivelyHangUp = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 切换听筒和外放
     */
    public void toggleMianti() {
        isMianti = !isMianti;
        changeToincall(isMianti);
    }

    /**
     * 外放模式和听筒模式 切换
     *
     * @param on
     */
    private void changeToincall(boolean on) {
        AudioDevice[] audioDevices = getCore().getAudioDevices();
        Call currentCall = getCurrentCall();
        if (currentCall == null || audioDevices == null)
            return;
        boolean isLanya = false;
        for (AudioDevice audioDevice : audioDevices) {
            if (!on && (audioDevice.getType() == AudioDevice.Type.Bluetooth || audioDevice.getType() == AudioDevice.Type.Headset || audioDevice.getType() == AudioDevice.Type.Headphones) && audioDevice.hasCapability(AudioDevice.Capabilities.CapabilityPlay)) {
                currentCall.setOutputAudioDevice(audioDevice);
                isLanya = true;
                break;
            }
        }
        if (!isLanya) {
            for (AudioDevice audioDevice : audioDevices) {
                if (!on && audioDevice.getType() == AudioDevice.Type.Earpiece && audioDevice.hasCapability(AudioDevice.Capabilities.CapabilityPlay)) {
                    currentCall.setOutputAudioDevice(audioDevice);
                    break;
                } else if (on && audioDevice.getType() == AudioDevice.Type.Speaker && audioDevice.hasCapability(AudioDevice.Capabilities.CapabilityPlay)) {
                    currentCall.setOutputAudioDevice(audioDevice);
                    break;
                }
            }
        }
        for (AudioDevice audioDevice : audioDevices) {
            if (audioDevice.getType() == AudioDevice.Type.Microphone && audioDevice.hasCapability(AudioDevice.Capabilities.CapabilityRecord)) {
                currentCall.setInputAudioDevice(audioDevice);
                break;
            }
        }
    }

    /**
     * 切换静音
     */

    public void toggleMute() {
        //麦克风静音
        isMicMute = !isMicMute;
        getCore().setMicEnabled(!isMicMute);
    }

    /**
     * 挂断电话
     */

    public void hangUpActiveCalls() {

        callTerminate();

        finishCall();
        isActivelyHangUp = true;
    }

    private boolean callTerminate() {
        //log("callTerminate");
        Call currentCall = getCurrentCall();
        if (currentCall != null) {
            // Terminating a call is quite simple
            currentCall.terminate();
        }
        return false;
    }

    public void declineIncomingCall() {


        callTerminate();

        System.out.println("FeigeSipManager.getInstance().getCallId() = " + FeigeSipManager.getInstance().getCallId());
        finishCall();
        isActivelyHangUp = true;
    }


    public long getCallSeconds() {
        return callSeconds;
    }

//    private void beginCallTimer() {
//        timerSubscriber = new ResourceSubscriber<Long>() {
//            @Override
//            public void onNext(Long aLong) {
//                long confirmedTime = FeigeSipManager.getInstance().getConfirmedTime();
//                if (confirmedTime > 0) {
//                    callSeconds = aLong;
//                    EventBus.getDefault().post(new CallTimeChangeEvent());
//                }
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                t.printStackTrace();
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        long confirmedTime = FeigeSipManager.getInstance().getConfirmedTime();
//        if (confirmedTime > 0) {
//            Flowable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(timerSubscriber);
//        }
//    }

//    private void calcelTimerCall() {
//        if (timerSubscriber != null && !timerSubscriber.isDisposed()) {
//            timerSubscriber.dispose();
//            timerSubscriber = null;
//        }
//    }


    public boolean isLogin() {
        return 2 == getAtomicLoginState().get();
    }

    public boolean isOffline() {
        return 0 == getAtomicLoginState().get() ||getCore().getDefaultAccount()==null|| !getCore().getDefaultAccount().getParams().isRegisterEnabled();
    }

//    public void accept() {
//        SipServiceCommand.acceptIncomingCall(getContext(), mAccountId, callId, false);
//        CallActivity.startActivityIn(getContext());
//    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setRegistration(boolean registration) {
        System.out.println("FeigeSipManager.setRegistration() " + "registration = " + registration);
        Account defaultAccount = getCore().getDefaultAccount();
        AccountParams clone = defaultAccount.getParams().clone();
        clone.setRegisterEnabled(registration);
        defaultAccount.setParams(clone);
    }

    public String getCallCustomerId() {
        return callCustomerId;
    }

    public String getCallConcatId() {
        return callConcatId;
    }

    public void callNotice(Context context) {
        Account defaultAccount = getCore().getDefaultAccount();
        RegistrationState state = null;
        if (defaultAccount != null) {
            state = defaultAccount.getState();
        }
        if ((state != RegistrationState.Ok && state != RegistrationState.Progress)) {
            onDestroy();
        }
        noticeAtomic.compareAndSet(NO_NOTICE, CAN_NOTICE);
        setRegistration(true);
//        login();
//        if (ServiceUtils.isServiceRunning(SipService.class)) {
//            noticeOfflineCall();
//        } else {
//            FeigeSipManager.getInstance().startService();
//        }
//        setRegistration(true);
    }

    public boolean isHold() {
        return hold;
    }

    public void toggleHold() {
        Call currentCall = getCurrentCall();
        if (currentCall == null) {
            ToastUtils.showShort("没有通话");
            return;
        }
        if (currentCall == null) return;
        hold = !hold;
        if (hold) {
            currentCall.pause();
        } else {
            currentCall.resume();
        }
    }

    @Nullable
    private Call getCurrentCall() {
        if (core.getCallsNb() == 0) {
            return null;
        }
        Call currentCall = getCore().getCurrentCall();
        currentCall = currentCall == null ? core.getCalls()[0] : currentCall;
        return currentCall;
    }

    public boolean isInCommingPhone() {
        return isInCommingPhone;
    }

    private void log(String msg) {
        System.out.println(TAG + "\t" + msg);
//        if (logViewModel == null)
//            logViewModel = new LogViewModel();
//        logViewModel.log("FeigeSip\t" + msg);
    }

//    public NotificationCompat.Builder createNotificationBuilder(Context context) {
//        System.out.println("VoiceCallService.createNotification");
//        Intent intent = new Intent(context, CallActivity.class);
//
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_ID, intent, PendingIntent.FLAG_IMMUTABLE);
//
//        int priorityHigh = AppUtils.isAppForeground() ? NotificationCompat.PRIORITY_DEFAULT : NotificationCompat.PRIORITY_HIGH;
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, (CALL_CHANNEL_I_D))
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("通话进行中")
//                .setContentText("点击以返回通话界面")
//                .setContentIntent(pendingIntent)
////                .setSound(sound)
//                .setAutoCancel(true)
//                .setCategory(NotificationCompat.CATEGORY_CALL)
////                .setCategory(NotificationCompat.CATEGORY_SERVICE)
//                .setPriority(priorityHigh)
//                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
//        return builder;
//    }

    public void answer() {
        //log("answer");
        Call currentCall = getCurrentCall();
        if (currentCall != null) {
            currentCall.accept();
        }
    }

    public void sendDTMF(char dtmfTone) {
        Call currentCall = getCurrentCall();
        if (currentCall != null) {
            currentCall.sendDtmf(dtmfTone);
        }
    }

    public String getCustormsStr() {
        return custormsStr;
    }

    public void setCustormsStr(String custormsStr) {
        this.custormsStr = custormsStr;
    }


}