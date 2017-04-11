package com.bailiangjin.demo.demo.switchnetworkstate;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.bailiangjin.utilslibrary.utils.device.NetUtils;
import com.bailiangjin.demo.R;
import com.bailiangjin.demo.base.BaseActivity;

/**
 * Created by bailiangjin on 16/3/22.
 */
public class SwitchNetWorkStateActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_switch_network_state;
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


    public void onClick_Switch_WiFi_open(View v) {
        shortToast("打开 WiFi");
        NetUtils.toggleWiFi(true);
    }

    public void onClick_Switch_WiFi_close(View v) {
        shortToast("关闭 WiFi");
        NetUtils.toggleWiFi(false);
    }

    public void onClick_Switch_mobile_open(View v) {
        shortToast("打开 移动网络");
        NetUtils.toggleMobileData(true);
    }

    public void onClick_Switch_mobile_close(View v) {
        shortToast("关闭 移动网络");
        NetUtils.toggleMobileData(false);
    }


}
