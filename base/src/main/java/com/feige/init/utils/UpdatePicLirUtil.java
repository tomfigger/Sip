package com.feige.init.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;

public class UpdatePicLirUtil implements MediaScannerConnection.MediaScannerConnectionClient {


    private static final String TAG = "UpdatePicLirUtil";
    private MediaScannerConnection mConn;
    private String mFilename;

    public UpdatePicLirUtil(UpdatePicLirUtilListener listener) {
        this.listener = listener;
    }

    public static void updatePicLir(Context context, String path) {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        context.sendBroadcast(intent);
    }


    public void ScanFileToImageLir(Context context, File file) {
        mFilename = file.getAbsolutePath();
        mConn = new MediaScannerConnection(context, this);
        mConn.connect();
    }

    @Override
    public void onMediaScannerConnected() {
        scanFile(mFilename);
    }

    @Override
    public void onScanCompleted(String path, Uri uri) {
        Log.i(TAG, "onScanCompleted  scan path=" + path
                + " uri= " + uri);
        mConn.disconnect();
        if (listener != null) {
            listener.onScanOver(path,uri);
        }
    }



    /**
     * scan file,it can be directory or single file.
     * @param fileName fileName,if it's a directory,then get its every file.
     */
    public void scanFile(final String fileName) {
        Log.i(TAG, "scanFile fileName=" + fileName);
        if (TextUtils.isEmpty(fileName)) {
            Log.w(TAG, "scanFile fileName empty!!!");
            return;
        }
        File f = new File(fileName);
        if (!f.exists()) {
            Log.w(TAG, "scanFile this file does not exist!!!");
            return;
        }
        if ((mConn != null)
                && mConn.isConnected()) {
            if (f.isDirectory()) {
                File[] filesInThisDir = f.listFiles();
                if ((filesInThisDir != null)
                        && (filesInThisDir .length > 0)) {
                    for (File file : filesInThisDir) {
                        String filePath = file.getAbsolutePath();
                        Log.i(TAG, "scanFile directory file:getAbsolutePath=" + filePath);

                        scanFile(file.getAbsolutePath());

                    }
                }
                Log.i(TAG, "scanFile it's a directory,now scan its files done");
            } else {
                mConn.scanFile(fileName, null);
                Log.i(TAG, "scanFile the file done");
            }
        }
    }


    public static void scanFileToImageLir(Context context, File file, UpdatePicLirUtilListener listener) {
        UpdatePicLirUtil updatePicLirUtil = new UpdatePicLirUtil(listener);
        updatePicLirUtil.ScanFileToImageLir(context,file);
    }


    private UpdatePicLirUtilListener listener;
    public interface UpdatePicLirUtilListener{
        void onScanOver(String path, Uri uri);
    }
    public void setListener(UpdatePicLirUtilListener listener){
    this.listener=listener;
    }
}
