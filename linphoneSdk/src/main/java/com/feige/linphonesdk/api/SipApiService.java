package com.feige.linphonesdk.api;

import com.alibaba.fastjson.JSONObject;
import com.feige.linphonesdk.utils.Constants;

import cn.feige.apilibrary.base.ApiServiceBase;
import cn.feige.apilibrary.base.BaseDataBean;
import cn.feige.apilibrary.base.bean.LoginInfo;
import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * MrLiu253@163.com
 *
 * @time 1/17/22
 * 描述:
 */
public interface SipApiService extends ApiServiceBase {
    @POST(Constants.API_TEST_URL + "User/SDKLogin")
    Flowable<Response<BaseDataBean<LoginInfo>>> sdkLogin(@Body RequestBody requestBody);

    @POST(Constants.API_TEST_SEAT_URL+"Account/GetAccountInfo")
    Flowable<Response<BaseDataBean<JSONObject>>> getUserInfo();
    @POST(Constants.CALLCENTER_URL + "agent/agent/status")
    Flowable<Response<BaseDataBean<String>>> getAgentState(@Body RequestBody requestBody);

    @POST(Constants.CALLCENTER_URL + "agent/esl/notice")
    Flowable<Response<BaseDataBean<String>>> offlineCallComming(@Body RequestBody requestBody);
    @POST("Report/GetAppHomeData")
    Flowable<Response<BaseDataBean<JSONObject>>> appHomeData(@Body RequestBody requestBody);

    @POST("System/RandomSentence")
    Flowable<Response<BaseDataBean<JSONObject>>> randomSentence(@Body RequestBody requestBody);
}