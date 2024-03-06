package com.feige.init.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;

import androidx.fragment.app.Fragment;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.UriUtils;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectModeConfig;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.PictureFileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnNewCompressListener;
import top.zibin.luban.OnRenameListener;

/**
 * MrLiu253@163.com
 *
 * @time 1/20/22
 * 描述:
 */
public class BasePicture {


    /**
     * 打开拍照模式
     *
     * @param activity
     * @param click
     */
    public static void openCamera(Activity activity, onBackImageClick click) {
        PictureSelector.create(activity)
                .openCamera(SelectMimeType.ofImage())
                .setCompressEngine(new ImageFileCompressEngine())
                .forResult(new OnResultCallbackListener<LocalMedia>() {

                    @Override
                    public void onResult(ArrayList<LocalMedia> result) {
                        // 结果回调
                        if (result != null && result.size() > 0) {
                            LocalMedia localMedia = result.get(0);
                            if (click != null) {
                                click.onImage(localMedia.getRealPath());
                            }
                        }
                    }

                    @Override
                    public void onCancel() {

                    }
                });
    }

    /**
     * 打开相册  单选
     *
     * @param activity
     * @param click
     */
    public static void openGallery(Activity activity, onBackImageClick click) {
        PictureSelector.create(activity)
                .openGallery(SelectMimeType.ofImage())
                .setSelectionMode(SelectModeConfig.SINGLE)
                .setCompressEngine(new ImageFileCompressEngine())
                .setImageEngine(GlideEngine.createGlideEngine())
                .forResult(new OnResultCallbackListener<LocalMedia>() {

                    @Override
                    public void onResult(ArrayList<LocalMedia> result) {
                        // 结果回调
                        if (result != null && result.size() > 0) {
                            LocalMedia localMedia = result.get(0);
                            if (click != null) {
                                click.onImage(localMedia.getRealPath());
                            }
                        }
                    }

                    @Override
                    public void onCancel() {

                    }
                });
    }

    /**
     * 打开相册  多选
     *
     * @param activity
     * @param click
     */
    public static void openGalleryMultiple(Activity activity, onBackImageClick click) {
        PictureSelector.create(activity)
                .openGallery(SelectMimeType.ofImage())
                .setSelectionMode(SelectModeConfig.MULTIPLE)
                .setMaxSelectNum(1)
                .setCompressEngine(new ImageFileCompressEngine())
                .setImageEngine(GlideEngine.createGlideEngine())
                .forResult(new OnResultCallbackListener<LocalMedia>() {

                    @Override
                    public void onResult(ArrayList<LocalMedia> result) {
                        // 结果回调
                        if (result != null && result.size() > 0) {
                            LocalMedia localMedia = result.get(0);
                            if (click != null) {
                                click.onImage(localMedia.getRealPath());

                            }
                        }
//                        if (result != null && result.size() > 0) {
//                            LocalMedia localMedia = result.get(0);
//                            List<String> strings = new ArrayList<>();
//                            if (click != null) {
//                                for (LocalMedia data:result){
//                                    strings.add(data.getRealPath());
//                                }
//                            }
//                        }
                    }

                    @Override
                    public void onCancel() {

                    }
                });
    }

    public interface onBackImageClick {
        void onImage(String url);
    }

    public interface onBackImageListClick {
        void onImage(List<String> url);
    }

    /**
     * 自定义压缩
     */
    private static class ImageFileCompressEngine implements CompressFileEngine {

        @Override
        public void onStartCompress(Context context, ArrayList<Uri> source, OnKeyValueResultCallbackListener call) {
            Luban.with(context).load(source).ignoreBy(100).setRenameListener(new OnRenameListener() {
                @Override
                public String rename(String filePath) {
                    int indexOf = filePath.lastIndexOf(".");
                    String postfix = indexOf != -1 ? filePath.substring(indexOf) : ".jpg";
                    return DateUtils.getCreateFileName("CMP_") + postfix;
                }
            }).filter(new CompressionPredicate() {
                @Override
                public boolean apply(String path) {
                    if (PictureMimeType.isUrlHasImage(path) && !PictureMimeType.isHasHttp(path)) {
                        return true;
                    }
                    return !PictureMimeType.isUrlHasGif(path);
                }
            }).setCompressListener(new OnNewCompressListener() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(String source, File compressFile) {
                    if (call != null) {
                        call.onCallback(source, compressFile.getAbsolutePath());
                    }
                }

                @Override
                public void onError(String source, Throwable e) {
                    if (call != null) {
                        call.onCallback(source, null);
                    }
                }
            }).launch();
        }
    }


}
