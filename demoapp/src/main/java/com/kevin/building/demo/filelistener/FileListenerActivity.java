package com.kevin.building.demo.filelistener;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.bailiangjin.javabaselib.utils.FileUtils;
import com.kevin.baselibrary.utils.FileListenerUtils;
import com.kevin.baselibrary.utils.FilePathUtil;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

import java.io.File;

/**
 * Created by bailiangjin on 16/4/5.
 */
public class FileListenerActivity  extends BaseActivity {

    private String filePath = FilePathUtil.getAppPath()+ File.separator+"test.txt";

    private TextView tv_content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv_content = (TextView) findViewById(R.id.tv_desc);
        FileListenerUtils.startFileListenerService(FileListenerActivity.this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_filelistener;
    }

    @Override
    protected void beforeViewBind(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }



    @Override
    protected void handleMsg(Message msg) {

    }


    /**
     * 创建 写文件
     * @param v
     */
    public void onClick_writeFile(View v){
        LogUtils.e("点击了写文件");
        shortToast("点击了写文件");

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.e("文件路径:" + filePath);
                FileUtils.saveStringToFile(filePath, "测试写文件", false);
            }
        }).start();
    }

    /**
     * 读取文件
     * @param v
     */
    public void onClick_readFile(View v){
        LogUtils.e("点击了读文件");
        shortToast("点击了读文件");

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.e("文件路径:" + filePath);
                final String content = FileUtils.readFile(filePath).toString();
                LogUtils.e("fileContent:" + content);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_content.setText(content);
                    }
                });


            }
        }).start();
    }

    /***
     *修改文件
     * @param v
     */
    public void onClick_modifyFile(View v){
        LogUtils.e("点击了修改文件");
        shortToast("点击了修改文件");

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.e("文件路径:" + filePath);
                FileUtils.saveStringToFile(filePath, "add", true);
            }
        }).start();
    }
}
