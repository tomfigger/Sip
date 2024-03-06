package com.feige.init.oss;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by jingdan on 2017/11/15.
 * Authentication server issued under the agreement of the official website agreement, you can directly use the provider
 */

public class OSSAuthCredentialsProvider11 extends OSSFederationCredentialProvider {

    private String mAuthServerUrl;
    private AuthDecoder mDecoder;

    public OSSAuthCredentialsProvider11(String authServerUrl) {
        this.mAuthServerUrl = authServerUrl;
    }

    /**
     * set auth server urld
     *
     * @param authServerUrl
     */
    public void setAuthServerUrl(String authServerUrl) {
        this.mAuthServerUrl = authServerUrl;
    }

    /**
     * set response data decoder
     *
     * @param decoder
     */
    public void setDecoder(AuthDecoder decoder) {
        this.mDecoder = decoder;
    }

    @Override
    public OSSFederationToken getFederationToken() throws ClientException {
        System.out.println("OSSAuthCredentialsProvider11.getFederationToken");
        OSSFederationToken authToken;
        String authData;
        try {

            RequestBody formBody = new FormBody.Builder()
                    .build();


            Request request = new Request.Builder()
                    .url(mAuthServerUrl)
                    .post(formBody)
                    .build();

            Call call = new OkHttpClient().newCall(request);
            Response response = call.execute();
            String string = response.body().string();
            JSONObject jsonObj = new JSONObject(string);
            boolean statusCode = jsonObj.getBoolean("status");
            if (statusCode) {
                JSONObject data = jsonObj.getJSONObject("data");
                String ak = data.getString("accessKeyId");
                String sk = data.getString("accessKeySecrets");
                String token = data.getString("stsToken");
//                String expiration = data.getString("Expiration");
                OssConfig.BUCKET_NAME = data.getString("bucket");
                authToken = new OSSFederationToken(ak, sk, token, OssConfig.EXPIRATION);
            } else {
                String errorCode = jsonObj.getString("ErrorCode");
                String errorMessage = jsonObj.getString("ErrorMessage");
                throw new ClientException("ErrorCode: " + errorCode + "| ErrorMessage: " + errorMessage);
            }
            return authToken;
        } catch (Exception e) {
            throw new ClientException(e);
        }
    }

    public interface AuthDecoder {
        String decode(String data);
    }
}
