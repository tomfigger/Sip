package com.feige.init.oss;

import android.util.Log;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.blankj.utilcode.util.FileUtils;
import com.feige.init.base.BaseApplication;

import org.json.JSONObject;

import java.io.File;
import java.util.UUID;

import androidx.annotation.NonNull;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by mOss on 2015/12/7 0007.
 * 支持普通上传，普通下载
 */
public class OssService {

    private static OssService INSTANCE = null;
    public OSS mOss;

    public static OssService getInstance() {
        if (INSTANCE == null) {
            synchronized (OssService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OssService();
                }
            }
        }
        return INSTANCE;
    }

    public OssService() {
        OSSAuthCredentialsProvider11 credentialProvider = new OSSAuthCredentialsProvider11(OssConfig.STS_SERVER_URL);
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        OSS oss = new OSSClient(BaseApplication.getInstance(), OssConfig.OSS_ENDPOINT, credentialProvider, conf);
        OSSLog.disableLog();
        this.mOss = oss;
    }

    public void init() {
        initBucketName();
    }

    private void initBucketName() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        RequestBody formBody = new FormBody.Builder()
                                .build();
                        Request request = new Request.Builder()
                                .url(OssConfig.STS_SERVER_URL)
                                .post(formBody)
                                .build();
                        Call call = new OkHttpClient().newCall(request);
                        Response response = call.execute();
                        String string = response.body().string();
                        JSONObject jsonObj = new JSONObject(string);
                        boolean statusCode = jsonObj.getBoolean("status");
                        if (statusCode) {
                            JSONObject data = jsonObj.getJSONObject("data");
                            OssConfig.BUCKET_NAME = data.getString("bucket");
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        sleep(5 * 1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    public void asyncPutImage(String object, String localFile, OnOssUploadListener callback) {
        final long upload_start = System.currentTimeMillis();
        OSSLog.logDebug("upload start");

        if (object.equals("")) {
            Log.w("AsyncPutImage", "ObjectNull");
            return;
        }

        File file = new File(localFile);
        if (!file.exists()) {
            Log.w("AsyncPutImage", "FileNotExist");
            Log.w("LocalFile", localFile);
            return;
        }

        // 构造上传请求
        OSSLog.logDebug("create PutObjectRequest ");
        PutObjectRequest put = new PutObjectRequest(OssConfig.BUCKET_NAME, object, localFile);
        System.out.println("OssConfig.BUCKET_NAME " + OssConfig.BUCKET_NAME);
        put.setCRC64(OSSRequest.CRC64Config.YES);
        // 异步上传时可以设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
                Log.d("PutObject", "currentSize: " + currentSize + " totalSize: " + totalSize);
                int progress = (int) (100 * currentSize / totalSize);
                callback.onProgress(request, currentSize, totalSize);
//                mDisplayer.updateProgress(progress);
//                mDisplayer.displayInfo("上传进度: " + String.valueOf(progress) + "%");
            }
        });

        OSSLog.logDebug(" asyncPutObject ");
        OSSAsyncTask task = mOss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {
                Log.d("PutObject", "UploadSuccess");

                Log.d("ETag", result.getETag());
                Log.d("RequestId", result.getRequestId());

                long upload_end = System.currentTimeMillis();
                OSSLog.logDebug("upload cost: " + (upload_end - upload_start) / 1000f);
                callback.onSuccess(request, result);
//                mDisplayer.uploadComplete();
//                mDisplayer.displayInfo("Bucket: " + OssConfig.BUCKET_NAME
//                +"\nObject: " + request.getObjectKey()
//                        + "\nETag: " + result.getETag()
//                        + "\nRequestId: " + result.getRequestId()
//                        + "\nCallback: " + result.getServerCallbackReturnBody());
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                String info = "";
                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    clientExcepion.printStackTrace();
                    info = clientExcepion.toString();
                }
                if (serviceException != null) {
                    // 服务异常
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                    info = serviceException.toString();
                }
                callback.onFailure(request, clientExcepion, serviceException);
//                mDisplayer.uploadFail(info);
//                mDisplayer.displayInfo(info);
            }
        });
    }

    @NonNull
    public static String getOssName(File file) {
        return UUID.randomUUID() + "." + FileUtils.getFileExtension(file);
    }

    @NonNull
    public static String getOssUrl(String object) {
        return "https://febookpic.oss-cn-hangzhou.aliyuncs.com/" + object;
    }


    public static interface OnOssUploadListener {
        void onProgress(PutObjectRequest request, long currentSize, long totalSize);

        void onSuccess(PutObjectRequest request, PutObjectResult result);

        void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException);
    }

}
