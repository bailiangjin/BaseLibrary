package com.bailiangjin.demo.demo.launchmode;

import android.os.Bundle;
import android.os.Message;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/14 13:58
 */
public class LaunchModeActivity3 extends LaunchModeActivity1 {


    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        titleBarBuilder.setTitleText("Activity3");

    }





    @Override
    protected void handleMsg(Message msg) {

    }



}
