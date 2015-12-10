package com.kevin.building.ui.demo.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.building.R;
import com.kevin.building.base.BtnBaseActivity;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/14 13:58
 */
public class LaunchModeActivity1 extends BtnBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.e("taskId:" + getLocalClassName() + ":" + getTaskId());


    }

    @Override
    protected void initView() {
        super.initView();
        titleView.setTitleText("Activity1");
        btn1.setText("跳转到Launch1");
        btn2.setText("跳转到Launch2");
        btn3.setText("跳转到Launch3");
        btn4.setText("跳转到Launch4");
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);

    }


    @Override
    protected void initLogic() {
    }

    @Override
    protected void onViewClick(View v) {

        switch (v.getId()) {


            case R.id.btn1:
                Intent intent1 = new Intent(LaunchModeActivity1.this, LaunchModeActivity1.class);

                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(LaunchModeActivity1.this, LaunchModeActivity2.class);
                //intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.putExtra("lastTaskId", LaunchModeActivity1.this.getTaskId());
                startActivity(intent2);
                break;
            case R.id.btn3:
                Intent intent3 = new Intent(LaunchModeActivity1.this, LaunchModeActivity3.class);
                //intent3.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                startActivityForResult(intent3, 0);
                //startActivity(intent3);

                break;

            case R.id.btn4:
                Intent intent4 = new Intent(LaunchModeActivity1.this, LaunchModeActivity4.class);
                //intent4.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                startActivity(intent4);
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    protected void handleMsg(Message msg) {

    }



    @Override
    public void onBackPressed() {
//        super.onBackPressed();

//        AppUtils.exit();
        finish();
//        System.exit(0);
//        ActivityManager mActivityManager = (ActivityManager) AppUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
//        mActivityManager.killBackgroundProcesses(AppUtils.getContext().getPackageName());

    }
}
