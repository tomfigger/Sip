package com.feige.linphonesdk.utils;

public enum SipStatus {
    CODE_400(400, "请求格式错误"),

    CODE_401(401, "用户未认证"),

    CODE_402(402, "用户需要付费"),

    CODE_403(403, "不提供服务"),

    CODE_404(404, "号码无法接通"),

    CODE_405(405, "请求方法不允许"),

    CODE_406(406, "不接受header中指定的请求"),

    CODE_407(407, "proxy服务器需要提供认证信息"),

    CODE_408(408, "请求超时"),

    CODE_409(409, "当前资源状态产生冲突"),

    CODE_410(410, "请求资源不可用"),

    CODE_411(411, "用户拒绝,content未定义"),

    CODE_413(413, "服务拒绝,请求内容过大"),

    CODE_414(414, "服务拒绝,请求的URL过长"),

    CODE_415(415, "服务拒绝,body格式不支持"),

    CODE_420(420, "不支持的拓展"),

    CODE_421(421, "需要拓展支持"),

    CODE_480(480, "暂时无应答"),

    CODE_481(481, "呼叫或事务不存在"),

    CODE_482(482, "收到了一个包含自己路径的请求"),

    CODE_483(483, "转发次数过多,Max-Forwards字段为0"),

    CODE_484(484, "请求地址不完整"),

    CODE_485(485, "请求地址不确定"),

    CODE_486(486, "被叫忙"),

    CODE_487(487, "请求终止"),

    CODE_488(488, "不被接受"),

    CODE_491(491, "请求未响应"),

    CODE_500(500, "您呼叫的用户暂时无法接听"),

    CODE_501(501, "不支持此功能"),

    CODE_502(502, "非法响应"),

    //服务不可用
    CODE_503(503, "呼叫失败"),

    CODE_504(504, "服务器超时"),

    CODE_505(505, "sip协议版本不支持"),

    CODE_600(600, "用户忙碌"),

    CODE_603(603, "用户忙"),

    CODE_604(604, "用户不存在"),

    CODE_606(606, "用户不接受"),
    CODE_NO_PHONE(2201, "请输入呼叫号码"),
    CODE_CALLING(2202, "通话正在进行中"),

    CALL_FAIL(2203, "拨打失败，请稍后再试"),
    LOGIN_INFO_MISS(2204, "请将信息填写完整"),
    CALL_NOT_LOGIN(2205, "请先登录");

    public int status;
    public String msg;

    SipStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 根据code获取去value
     *
     * @param code
     * @return
     */
    public static String getValueByCode(int code) {
        for (SipStatus sipError : SipStatus.values()) {
            if (code == sipError.status) {
                return sipError.msg;
            }
        }
        return null;
    }
}
