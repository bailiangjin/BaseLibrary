package com.kevin.baselibrary.utils.device;

import android.media.MediaRecorder;

import com.kevin.baselibrary.utils.FilePathUtil;
import com.kevin.baselibrary.utils.ToastUtils;

import java.io.IOException;

/**
 * Created by bailiangjin on 2016/10/18.
 */

public class RecorderUtils {

// 录音

    private MediaRecorder recorder;

    private Boolean bool = false;

    private String path;

//初始化

    private void init() {

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC); // 音频输入源

        recorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_WB);	//设置输出格式

        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);	//设置编码格式

        path = FilePathUtil.getAppPath()+"/db_demo/AudioFrequency/" + System.currentTimeMillis()+".amr";

        recorder.setOutputFile(path);	//设置音频保存路径

    }

    /**

     * 开始录制音频

     */

    public void startRecord() {

        if( recorder == null ){

            recorder = new MediaRecorder();

            this.init();

        }

        if( bool == false ) {

            try {

                recorder.prepare();

                recorder.start(); // 开始录制

                ToastUtils.shortToast("开始录音");

                bool = true;

            } catch (IOException e) {

                ToastUtils.shortToast("录制音频出现异常");


            }

        } else if(bool) {

            ToastUtils.shortToast("当前正在录制音频");

        }

    }

    /**

     * 停止录制，资源释放

     */

    public void stopRecord(){

        if(recorder != null){

            recorder.stop();

            recorder.release();

            recorder = null;

            ToastUtils.shortToast("已经结束,文件保存在");


            bool = false;

        }

    }

}


