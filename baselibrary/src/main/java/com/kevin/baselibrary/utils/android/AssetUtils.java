package com.kevin.baselibrary.utils.android;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：16/2/27 14:26
 */
public class AssetUtils {

    /**
     * 从assets目录中复制整个文件夹内容
     *
     * @param context        Context 使用CopyFiles类的Activity
     * @param assetsFilePath String  原文件路径  如：路径为 "assets/aa" 传入"aa"
     * @param desFilePath    String  目标路径  如：xx:/bb/cc
     */
    public static boolean copyAssetFiles(Context context, String assetsFilePath, String desFilePath) {
        try {
            String fileNames[] = context.getAssets().list(assetsFilePath);//获取assets目录下的所有文件及目录名
            if (fileNames.length > 0) {//如果是目录
                File file = new File(desFilePath);
                file.mkdirs();//如果文件夹不存在，则递归
                for (String fileName : fileNames) {
                    copyAssetFiles(context, assetsFilePath + "/" + fileName, desFilePath + "/" + fileName);
                }
            } else {//如果是文件
                InputStream is = context.getAssets().open(assetsFilePath);
                FileOutputStream fos = new FileOutputStream(new File(desFilePath));
                byte[] buffer = new byte[1024];
                int byteCount = 0;
                while ((byteCount = is.read(buffer)) != -1) {//循环从输入流读取 buffer字节
                    fos.write(buffer, 0, byteCount);//将读取的输入流写入到输出流
                }
                fos.flush();//刷新缓冲区
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
