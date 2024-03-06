package com.feige.linphonesdk.utils;

public class AccoutInfo {
    private String ip;
    private String name;
    private String password;
    private String port;
    private String realm;

    public AccoutInfo() {
    }

    public AccoutInfo(String ip, String name, String password, String port, String realm) {
        this.ip = ip;
        this.name = name;
        this.password = password;
        this.port = port;
        this.realm = realm;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
}
