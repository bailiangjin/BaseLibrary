package com.kevin.building.demo.launchmode;

import android.content.Intent;
import android.os.Message;

import com.kevin.baselibrary.activity.ItemClickListener;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/14 13:58
 */
public class LaunchModeActivity4 extends LaunchModeActivity1 {


    @Override
    protected void initView() {
        super.initView();
        titleBarBuilder.setTitleText("Activity4");

        titleBarBuilder.addMenuItem("onResult", new ItemClickListener() {
            @Override
            public void onClick() {
                Intent intent = new Intent();
                setResult(1,intent);
                LaunchModeActivity4.this.finish();
            }
        }).build();
    }





    @Override
    protected void handleMsg(Message msg) {

    }
}
