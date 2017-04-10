package com.kevin.baselibrary.utils.file;

import android.content.Context;
import android.content.Intent;

import com.kevin.baselibrary.service.FileListenerService;

/**
 * Created by bailiangjin on 16/4/5.
 */
public class FileListenerUtils {
    /**
     * 开启文件监听服务
     * @param context
     */
    public static void startFileListenerService(Context context) {
        context.startService(new Intent(context, FileListenerService.class));
    }

}
