package com.kevin.building.demo.launchmode;

import android.content.Intent;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.interfaze.listener.CommonTitleListener;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/14 13:58
 */
public class LaunchModeActivity4 extends LaunchModeActivity1 {


    @Override
    protected void initView() {
        super.initView();
        commonTitleView.setTitleText("Activity4");
        commonTitleView.setRightBtnText("onResult");
        commonTitleView.setRightBtnVisibility(View.VISIBLE);

        commonTitleView.setTitleViewListener(new CommonTitleListener() {
            @Override
            public boolean onRightImgClick() {
                return false;
            }

            @Override
            public boolean onRightBtnClick() {
                Intent intent = new Intent();
                setResult(1,intent);
                LaunchModeActivity4.this.finish();
                return true;
            }
        });

    }





    @Override
    protected void handleMsg(Message msg) {

    }
}
