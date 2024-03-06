package com.feige.init.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

import com.feige.init.R;

/**
 * MrLiu253@163.com
 *
 * @time 2/26/22
 * 描述:
 */
public class RingUtils {
    /**
     * 获取的是铃声的Uri
     *
     * @param ctx
     * @return
     */
    public static Uri getDefaultRingtoneUri(Context ctx) {

        return RingtoneManager.getActualDefaultRingtoneUri(ctx, RingtoneManager.TYPE_NOTIFICATION);

    }

    /**
     * 获取的是铃声相应的Ringtone
     *
     * @param ctx
     * @param type
     */
    public Ringtone getDefaultRingtone(Context ctx, int type) {

        return RingtoneManager.getRingtone(ctx,
                RingtoneManager.getActualDefaultRingtoneUri(ctx, type));

    }

    /**
     * 播放消息铃声
     *
     * @param ctx
     */

    public static void PlayRingTone(Context ctx) {
        MediaPlayer mMediaPlayer = MediaPlayer.create(ctx, R.raw.new_message);
        mMediaPlayer.setLooping(false);
        mMediaPlayer.start();
    }

    /**
     * 播放消息铃声
     *
     * @param ctx
     */

    public static void PlayRingToneRoom(Context ctx) {
        MediaPlayer mMediaPlayer = MediaPlayer.create(ctx, R.raw.new_session);
        mMediaPlayer.setLooping(false);
        mMediaPlayer.start();
    }
}
