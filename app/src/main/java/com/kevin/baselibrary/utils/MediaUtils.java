package com.kevin.baselibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

/**
 * Author:  liangjin.bai Email:bailiangjin@gmail.com
 * Create Time: 2015/9/14 13:43
 */
public class MediaUtils {


    /**
     * 打开视频文件.
     *
     * @param filePtath 视频文件路径
     */
    public static void playVideo(Context context, String filePtath) {
        try {
            File videoFile = new File(filePtath);
            if (!videoFile.exists()) {
                ToastUtils.show("Video File not exist!");
                return;
            }
            // 调用系统程序打开文件.
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(videoFile), "video/*");
            context.startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(context, "打开失败.", Toast.LENGTH_SHORT).show();
        }
    }
}
