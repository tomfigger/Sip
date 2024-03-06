package com.feige.linphonesdk.utils;

import static cn.feige.apilibrary.base.NetWorkUtils.reponseFlowable;
import static cn.feige.apilibrary.base.NetWorkUtils.unWrapReponseFlowable;

import android.util.Log;

import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.EncryptUtils;
import com.feige.linphonesdk.api.SipApiService;
import com.hhbb.amt.di.retrofit.RetrofitHelp;

import java.util.HashMap;
import java.util.Map;

import cn.feige.apilibrary.base.BaseDataBean;
import cn.feige.apilibrary.base.LoginInfoCache;
import io.reactivex.Flowable;
import retrofit2.Response;

public class SipViewModel {


    public Flowable<BaseDataBean<String>> agentState(String status, String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("extension_id", username);
        SipApiService service = RetrofitHelp.Companion.getInstance(null).getService(SipApiService.class);
        return reponseFlowable(service.getAgentState(RetrofitHelp.Companion.handlerRequestData(map)));
    }

    public Flowable<Response<BaseDataBean<String>>> offlineCallComming(String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("callee", username);
        SipApiService service = RetrofitHelp.Companion.getInstance(null).getService(SipApiService.class);

        return Flowable.fromPublisher(service.offlineCallComming(RetrofitHelp.Companion.handlerRequestData(map)));
    }


    public Flowable<AccoutInfo> login(String apiKey, String apiSecert, String userName) {
        Map<String, Object> map = getStringObjectMap(apiKey, apiSecert, userName);
        SipApiService service = RetrofitHelp.Companion.getInstance(null).getService(SipApiService.class);
        return unWrapReponseFlowable(service.sdkLogin(RetrofitHelp.Companion.handlerRequestData(map))).doOnNext(LoginInfoCache::setLoginToekn).concatMap(loginInfo -> {
            return getUserInfo();
        }).map(jsonObject -> {
            System.out.println("SipViewModel.getUserInfo");
            JSONObject userInfo = jsonObject.getJSONObject("userInfo");
            return new AccoutInfo(userInfo.getString("ip"), userInfo.getString("extensionUserName"), userInfo.getString("extensionPassword"), userInfo.getString("tcpPort"), userInfo.getString("companyId") + ".feige.cn");
        });
    }

    @NonNull
    private Map<String, Object> getStringObjectMap(String apiKey, String apiSecert, String userName) {
        Map<String, Object> map = new HashMap<>();
        map.put("apiKey", apiKey);
        map.put("userName", userName);
        long timeMillis = System.currentTimeMillis()/1000;
        map.put("timestamp", timeMillis);
        String md5Param = apiKey+userName+timeMillis+apiSecert;
        Log.i("ranwei",md5Param);
        String md2ToString = EncryptUtils.encryptMD5ToString(md5Param).toLowerCase();
        Log.i("ranwei",md2ToString);
        map.put("sign", md2ToString);
        return map;
    }

    //获取个人资料
    private Flowable<JSONObject> getUserInfo() {
        SipApiService service = RetrofitHelp.Companion.getInstance(null).getService(SipApiService.class);
        return unWrapReponseFlowable(service.getUserInfo());
    }

}
