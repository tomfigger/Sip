package com.feige.init.base;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.feige.init.BuildConfig;
import com.tencent.mmkv.MMKV;

import org.jivesoftware.smack.android.AndroidSmackInitializer;

import java.io.File;

import androidx.multidex.MultiDex;

import static android.os.Environment.DIRECTORY_DCIM;
import static android.os.Environment.DIRECTORY_DOWNLOADS;

/**
 * MrLiu253@163.com
 */
public class BaseApplication extends Application {
    private static volatile BaseApplication instance = null;


    public static Context getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
        MMKV.initialize(this);
        AndroidSmackInitializer.initialize(this);
        LogUtils.getConfig().setLogSwitch(BuildConfig.DEBUG);
    }


    public File getFile() {
        //获取到下载得到的图片，进行本地保存
        File externalFilesDir = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS), "feige");
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    public File getImageFile() {
        //获取到下载得到的图片，进行本地保存
        File externalFilesDir = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DCIM) + "/feige/");
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    public String getVideo(Context context) {
        return context.getExternalFilesDir("") + File.separator + "Media" + File.separator;
    }


}
