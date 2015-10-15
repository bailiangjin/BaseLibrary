package com.kevin.building.activity.launchmode;

import android.content.Intent;
import android.os.Message;
import android.view.View;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/14 13:58
 */
public class LaunchModeActivity4 extends LaunchModeActivity1 {


    @Override
    protected void initView() {
        super.initView();
        titleView.setTitleText("Activity4");
        titleView.setRightBtnText("onResult");
        titleView.setRightBtnVisibility(View.VISIBLE);
        titleView.setRightButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(1,intent);
                LaunchModeActivity4.this.finish();
            }
        });

    }





    @Override
    protected void handleMsg(Message msg) {

    }
}
