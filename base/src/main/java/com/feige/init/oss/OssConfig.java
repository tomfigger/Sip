package com.feige.init.oss;

import cn.feige.apilibrary.base.Constants;

/**
 * Created by wangzheng on 2017/11/22.
 */

public class OssConfig {

    // To run the sample correctly, the following variables must have valid values.
    // The endpoint value below is just the example. Please use proper value according to your region

    // 访问的endpoint地址
    public static final String OSS_ENDPOINT = "https://oss-cn-hangzhou.aliyuncs.com";
    //callback 测试地址
    // STS 鉴权服务器地址，使用前请参照文档 https://help.aliyun.com/document_detail/31920.html 介绍配置STS 鉴权服务器地址。
    // 或者根据工程sts_local_server目录中本地鉴权服务脚本代码启动本地STS 鉴权服务器。详情参见sts_local_server 中的脚本内容。
    public static final String STS_SERVER_URL = Constants.RELEASE_URL + "Common/GetTokenByAliYunSts";//STS 地址
    public static long EXPIRATION = 10 * 6 * 60;

    public static String BUCKET_NAME = "febookpic";

}
