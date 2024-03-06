package com.feige.init.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.feige.init.R;

import java.util.List;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_SETTINGS;

/**
 * MrLiu253@163.com
 *
 * @time 8/13/21
 */
public class BasePermission {

    /**
     * 判断是否有相机权限
     *
     * @param
     * @param click
     */
    public static void getCamera(onBackOkClick click) {
        if (PermissionUtils.isGranted(PermissionConstants.CAMERA, PermissionConstants.STORAGE)) {
            click.onOk(true);
        } else {
            PermissionUtils
                    .permission(PermissionConstants.CAMERA, PermissionConstants.STORAGE)
                    .callback(new PermissionUtils.FullCallback() {
                        @Override
                        public void onGranted(@NonNull List<String> granted) {
                            click.onOk(true);
                        }

                        @Override
                        public void onDenied(@NonNull List<String> deniedForever, @NonNull List<String> denied) {
                            click.onOk(false);
                            BaseToast.showShort("权限被拒绝");
                        }
                    }).request();

        }
    }

    /**
     * 判断是否有
     * 相册权限
     *
     * @param
     * @param click
     */
    public static void getStorage(onBackOkClick click) {
        if (PermissionUtils.isGranted( PermissionConstants.STORAGE)) {
            click.onOk(true);
        } else {
            PermissionUtils
                    .permission( PermissionConstants.STORAGE)
                    .callback(new PermissionUtils.FullCallback() {
                        @Override
                        public void onGranted(@NonNull List<String> granted) {
                            click.onOk(true);
                        }

                        @Override
                        public void onDenied(@NonNull List<String> deniedForever, @NonNull List<String> denied) {
                            click.onOk(false);
                            BaseToast.showShort("权限被拒绝");
                        }
                    }).request();

        }
    }

    /**
     * 判断是否有
     * 设备权限
     *
     * @param
     * @param click
     */
    public static void getDevice(onBackOkClick click) {
        if (PermissionUtils.isGranted(READ_PHONE_STATE,WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE,WRITE_SETTINGS)) {
            click.onOk(true);
        } else {
            PermissionUtils
                    .permission(READ_PHONE_STATE,WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE,WRITE_SETTINGS)
                    .callback(new PermissionUtils.FullCallback() {
                        @Override
                        public void onGranted(@NonNull List<String> granted) {
                            click.onOk(true);
                        }

                        @Override
                        public void onDenied(@NonNull List<String> deniedForever, @NonNull List<String> denied) {
                            click.onOk(false);
                            BaseToast.showShort("权限被拒绝");
                        }
                    }).request();

        }
    }

    public interface onBackOkClick {
        void onOk(boolean isOk);
    }


}
