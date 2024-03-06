package com.feige.init.bean;

public enum FllowPlainType {
    Phone(1, "电话"),
    SMS(2, "短信"),
    Visit(3, "拜访"),
    QQ(4, "QQ"),
    Wechat(5, "微信"),
    Email(6, "邮件"),
    Other(7, "其它");


    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    FllowPlainType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static FllowPlainType getTypeById(Integer followType) {
        if (followType==null)
            return null;
        FllowPlainType[] changeHandleEnums = values();
        for (FllowPlainType changeHandleEnum : changeHandleEnums) {
            if (changeHandleEnum.id == followType) {
                return changeHandleEnum;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
