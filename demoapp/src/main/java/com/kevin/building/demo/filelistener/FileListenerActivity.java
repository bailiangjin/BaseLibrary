package com.kevin.building.demo.filelistener;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.interfaze.listener.SDCardListener;
import com.kevin.baselibrary.utils.FilePathUtil;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.javabaselib.utils.FileUtils;

import java.io.File;

/**
 * Created by bailiangjin on 16/4/5.
 */
public class FileListenerActivity  extends BaseActivity{

    private SDCardListener mFileObserver;
//    private MultiFileObserver multiFileObserver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if(null == mFileObserver) {
//            mFileObserver = new SDCardListener(FilePathUtil.getAppPath()+"/",FileObserver.ALL_EVENTS);
//            mFileObserver.startWatching(); //开始监听
//            LogUtils.e("开始文件监听");
//        }

//        if(null == multiFileObserver) {
//            multiFileObserver = new MultiFileObserver(FilePathUtil.getAppPath(), FileObserver.ALL_EVENTS);
//            multiFileObserver.startWatching(); //开始监听
//        }

        startService(new Intent(FileListenerActivity.this,FileListenerService.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if(null != mFileObserver){
//            mFileObserver.stopWatching(); //停止监听
//        }

//        if(null != multiFileObserver){
//            multiFileObserver.stopWatching(); //停止监听
//        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_filelistener;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }

    public void onClick_writeFile(View v){
        LogUtils.e("点击了写文件");
        show("点击了写文件");

        new Thread(new Runnable() {
            @Override
            public void run() {
                String filePath = FilePathUtil.getAppPath()+ File.separator+"test.txt";
                LogUtils.e("文件路径:" + filePath);
                FileUtils.saveStringToFile(filePath,"测试写文件",false);
            }
        }).start();
    }
}
