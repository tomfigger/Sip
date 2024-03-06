package com.feige.init.bean.message;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

@Entity
public class TemplateTable implements Serializable {
    private static final long serialVersionUID = 1L;


    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Id(autoincrement = true)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private int websiteId;
    private String data;


    @Generated(hash = 529478056)
    public TemplateTable(long id, int websiteId, String data) {
        this.id = id;
        this.websiteId = websiteId;
        this.data = data;
    }

    @Generated(hash = 1181478406)
    public TemplateTable() {
    }


}
