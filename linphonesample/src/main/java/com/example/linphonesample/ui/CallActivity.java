package com.example.linphonesample.ui;

import android.Manifest;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.linphonesample.R;
import com.example.linphonesample.databinding.ActivityCallBinding;
import com.example.linphonesample.event.CallConnectedEvent;
import com.example.linphonesample.event.CallInComingEvent;
import com.example.linphonesample.event.CallStateEvent;
import com.example.linphonesample.event.CallingOutEvent;
import com.example.linphonesample.model.CallViewModel;
import com.example.linphonesample.util.TimeFormatUtil;
import com.feige.init.base.BaseActivity;
import com.feige.init.bean.ClientBean;
import com.feige.linphonesdk.manager.FeigeSipManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.linphone.core.Call;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subscribers.ResourceSubscriber;

public class CallActivity extends BaseActivity<CallViewModel, ActivityCallBinding> {
    private ResourceSubscriber<Long> timerSubscriber;
    private Long callSeconds;
    private long confirmedTime;
    private String sendDtmf = "";
    private Call.State callState;

    @Override
    protected CallViewModel bindModel() {
        return getViewModel(CallViewModel.class);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_call;
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLayout();
    }

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CallStateEvent event) {
        updateLayout();
        //mBinding.textViewCallState.setText(event.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CallConnectedEvent event) {
        confirmedTime = System.currentTimeMillis();
        beginCallTimer();
    }
    @Override
    protected void initClick() {
        mViewModel.onDelayClick(mBinding.buttonAccept, o -> {
            //接听
            FeigeSipManager.getInstance().answer();
        });
        mViewModel.onDelayClick(mBinding.buttonHangup, o -> {
            callState = FeigeSipManager.getInstance().getCallState();
            //拒绝
            if (callState == Call.State.IncomingReceived) {
                FeigeSipManager.getInstance().declineIncomingCall();  //对方打过来
            } else
                FeigeSipManager.getInstance().reject();
            finish();
        });

        mViewModel.onDelayClick(mBinding.keybordLayout, o -> {
            mBinding.buttonLayout.setVisibility(View.GONE);
            mBinding.keybordContainer.setVisibility(View.VISIBLE);
            mBinding.hideKeyboardTv.setVisibility(View.VISIBLE);
            sendDtmf = "";
            updatePhoneView();
        });
        mViewModel.onDelayClick(mBinding.hideKeyboardTv, o -> {
            mBinding.buttonLayout.setVisibility(View.VISIBLE);
            mBinding.keybordContainer.setVisibility(View.GONE);
            mBinding.hideKeyboardTv.setVisibility(View.GONE);
            sendDtmf = "";
            updatePhoneView();
        });

        mViewModel.onDelayClick(mBinding.btnHangUp, o -> {
            callState = FeigeSipManager.getInstance().getCallState();
            if (callState == Call.State.OutgoingProgress || callState == Call.State.OutgoingInit)
                FeigeSipManager.getInstance().hangUpActiveCalls();  //自己打出去
            else
                FeigeSipManager.getInstance().reject();
            finish();
        });

        mViewModel.onDelayClick(mBinding.btnMuteMic, o -> {
            FeigeSipManager.getInstance().toggleMute();
            updateMute();
        });
        mViewModel.onDelayClick(mBinding.btnMianti, o -> {
            FeigeSipManager.getInstance().toggleMianti();
            updateMianti();
        });
        setupCharClick(mBinding.callKeyboardNumberTv0, '0');
        setupCharClick(mBinding.callKeyboardNumberTv1, '1');
        setupCharClick(mBinding.callKeyboardNumberTv2, '2');
        setupCharClick(mBinding.callKeyboardNumberTv3, '3');
        setupCharClick(mBinding.callKeyboardNumberTv4, '4');
        setupCharClick(mBinding.callKeyboardNumberTv5, '5');
        setupCharClick(mBinding.callKeyboardNumberTv6, '6');
        setupCharClick(mBinding.callKeyboardNumberTv7, '7');
        setupCharClick(mBinding.callKeyboardNumberTv8, '8');
        setupCharClick(mBinding.callKeyboardNumberTv9, '9');
        setupCharClick(mBinding.callKeyboardNumberTvXing, '*');
        setupCharClick(mBinding.callKeyboardNumberTvJin, '#');
    }
    private void setupCharClick(View view, char c) {
        view.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    String dtmfTone = String.valueOf(c);
                    FeigeSipManager.getInstance().sendDTMF(c);
                   // startDialpadTone(c);
                    sendDtmf += dtmfTone;
                    updatePhoneView();
//                    if (longClickable) {
//                        longPressHandler.removeCallbacksAndMessages(null);
//                        longPressHandler.postDelayed({
//                                performLongClick(view, c)
//                        }, longPressTimeout);
//                    }
                }
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL: {
                    //stopDialpadTone(c);
                }
                case MotionEvent.ACTION_MOVE: {
                }
            }
            return false;
        });
    }

    @Override
    protected void initMonitor() {

    }
    private void updatePhoneView() {
        if (StringUtils.isTrimEmpty(sendDtmf)) {
            mBinding.tvOutCallInfo.setText(FeigeSipManager.getInstance().getDisplayPhone());
        } else {
            mBinding.tvOutCallInfo.setText(sendDtmf);
        }
    }
    private void finishCall() {
        confirmedTime = 0;
        String errMsg = FeigeSipManager.getInstance().getErrMsg();
        mBinding.textViewCallState.setText(StringUtils.isTrimEmpty(errMsg) ? "通话中断" : errMsg);
        mBinding.textViewCallState.postDelayed(this::finish, 3 * 1000);

    }
    private void beginCallTimer() {
        timerSubscriber = new ResourceSubscriber<Long>() {
            @Override
            public void onNext(Long aLong) {
                long confirmedTime = getConfirmedTime();
                if (confirmedTime > 0) {
                    callSeconds = aLong;
                    mBinding.textViewCallState.setText(TimeFormatUtil.getVideoFormat(callSeconds));
                }
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        };
        long confirmedTime = getConfirmedTime();
        if (confirmedTime > 0) {
            Flowable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(timerSubscriber);
        }
    }

    public long getConfirmedTime() {
        return confirmedTime;
    }

    private void updateLayout() {
        String realPhone = FeigeSipManager.getInstance().getRealPhone();
        String displayPhone = FeigeSipManager.getInstance().getDisplayPhone();
        callState = FeigeSipManager.getInstance().getCallState();
        System.out.println("CallActivity.updateLayout callState = " + callState + " phone = " + realPhone + " displayPhone = " + displayPhone);

        if (callState == callState.IncomingReceived) {
            mBinding.layoutIncomingCall.setVisibility(View.VISIBLE);
            mBinding.layoutConnected.setVisibility(View.GONE);
            mBinding.btnMuteMic.setEnabled(false);
            mBinding.textViewCallState.setText("来电中...");
            mBinding.tvOutCallInfo.setText(displayPhone);
            String[] strings = {Manifest.permission.WRITE_CONTACTS, Manifest.permission.RECORD_AUDIO};
            if (!PermissionUtils.isGranted(strings)) {
                PermissionUtils
                        .permission(strings)
                        .callback(new PermissionUtils.SimpleCallback() {
                            @Override
                            public void onGranted() {

                            }
                            @Override
                            public void onDenied() {
                                ToastUtils.showShort("请授予权限，才能使用电话功能");
                                finish();
                            }
                        }).request();
            }

        } else if (callState == Call.State.OutgoingProgress || callState == Call.State.OutgoingInit || callState == Call.State.OutgoingEarlyMedia) {
            mBinding.layoutIncomingCall.setVisibility(View.GONE);
            mBinding.layoutConnected.setVisibility(View.VISIBLE);
            mBinding.btnMuteMic.setEnabled(false);
            mBinding.tvOutCallInfo.setText(displayPhone);
            mBinding.textViewCallState.setText("正在拨号.");
        } else if (Call.State.Connected == callState || Call.State.StreamsRunning == callState || Call.State.Paused == callState) {
            mBinding.layoutIncomingCall.setVisibility(View.GONE);
            mBinding.tvOutCallInfo.setText(displayPhone);
//            mBinding.tvOutCallInfo.setText(mNumber);
//连接成功
            mBinding.btnMuteMic.setEnabled(true);
            mBinding.textViewCallState.setText("接听中...");
            mBinding.layoutConnected.setVisibility(View.VISIBLE);
        } else if (callState == Call.State.End || callState == Call.State.Error || callState == Call.State.Released || callState == Call.State.Idle) {
            //断开连接
            finishCall();
        }
        updateMianti();
        updateMute();
    }

    private void updateMianti() {
        mBinding.btnMianti.setImageResource(FeigeSipManager.getInstance().isMianti() ? R.mipmap.call_mianti_checked : R.mipmap.call_mianti_normal);
    }

    private void updateMute() {
        mBinding.btnMuteMic.setImageResource(FeigeSipManager.getInstance().isMicMute() ? R.mipmap.call_mute_checked : R.mipmap.call_mute_normal);
    }

    private void calcelTimerCall() {
        if (timerSubscriber != null && !timerSubscriber.isDisposed()) {
            timerSubscriber.dispose();
            timerSubscriber = null;
        }
        callSeconds = 0l;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        calcelTimerCall();
    }
}
