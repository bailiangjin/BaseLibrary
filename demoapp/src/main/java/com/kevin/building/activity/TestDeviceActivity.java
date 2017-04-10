package com.kevin.building.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.utils.device.BluetoothUtils;
import com.kevin.baselibrary.utils.device.CheckCameraUtils;
import com.kevin.baselibrary.utils.device.LocationUtils;
import com.kevin.baselibrary.utils.device.NFCUtils;
import com.kevin.baselibrary.utils.device.NetUtils;
import com.kevin.baselibrary.utils.device.RecorderUtils;
import com.kevin.building.R;
import com.kevin.building.base.BtnBaseActivity;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/20 10:40
 */
public class TestDeviceActivity extends BtnBaseActivity {


    private boolean mobileOn = true;


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, TestDeviceActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_btn_base;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        titleBarBuilder.setTitleText("测试设备");

        btn1.setText("切换WIFI");
        btn2.setText("切换移动网络");
        btn3.setText("设置GPS");
        btn4.setText("设置NFC");
        btn5.setText("切换蓝牙");
        btn6.setText("检查摄像头");
        btn7.setText("检查麦克风");
        btn8.setText("开始录音");


        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.GONE);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                NetUtils.toggleWiFi(!NetUtils.isWifiConnect());
                break;

            case R.id.btn2:
                mobileOn = !mobileOn;
                NetUtils.toggleMobileData(mobileOn);

                break;

            case R.id.btn3:
                LocationUtils.toSetLocation();
                break;

            case R.id.btn4:
                NFCUtils.toSetNFC();
                break;

            case R.id.btn5:
                BluetoothUtils.toggleBluetooth(!BluetoothUtils.isBluetoothEnabled());
                break;

            case R.id.btn6:
                String isCameraInUse= CheckCameraUtils.isCameraInUse(TestDeviceActivity.this)? "正在使用":"未使用";

                shortToast("检查摄像头:" +isCameraInUse);
                break;

            case R.id.btn7:

                String isMCInUse=RecorderUtils.INSTANCE.checkIsInUse()? "正在使用":"未使用";

                shortToast("检查麦克风：" +isMCInUse);

                break;
            case R.id.btn8:
                shortToast("停止录音");

                break;


            default:
                break;
        }

    }

    @Override
    protected void handleMsg(Message msg) {

    }


}
