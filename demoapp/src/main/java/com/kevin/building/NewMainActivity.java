package com.kevin.building;

import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.config.CleanOptions;
import com.kevin.baselibrary.instance.jni.NdkJniUtils;
import com.kevin.baselibrary.utils.CleanUtils;
import com.kevin.building.activity.LoginActivity;
import com.kevin.building.activity.SearchActivity;
import com.kevin.building.activity.UIMainActivity;
import com.kevin.building.base.BtnBaseActivity;
import com.kevin.building.utils.ActivityUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/20 10:40
 */
public class NewMainActivity extends BtnBaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_btnbase;
    }

    @Override
    protected void initView() {
        super.initView();

        titleView.setTitleText("主页面");
        titleView.setLeftBtnVisibility(View.GONE);

        btn1.setText("UI");
        btn2.setText("应用");
        btn3.setText("网络");
        btn4.setText("数据库");
        btn5.setText("文件");
        btn6.setText("传感器");
        btn7.setText("控件");
        btn8.setText("当前测试");

        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.VISIBLE);
        NdkJniUtils jni = new NdkJniUtils();
        show("jni:" + jni.getCLanguageString());
    }

    @Override
    protected void initLogic() {

        CleanOptions cleanOptions = new CleanOptions.Builder()
                .cleanRootDir(false)
                .cleanDBDir(true)
                .cleanMediaDir(false)
                .cleanOtherDir(false).build();

        CleanUtils.cleanAppFileDirOnUpdate(cleanOptions);
    }

    @Override
    protected void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                ActivityUtils.startActivity(this, UIMainActivity.class);
                break;

            case R.id.btn2:
                ActivityUtils.startActivity(this, LoginActivity.class);

                break;

            case R.id.btn3:
                break;

            case R.id.btn4:
                ActivityUtils.startDatabaseActivity(NewMainActivity.this);


                break;

            case R.id.btn5:


                break;

            case R.id.btn6:


                break;

            case R.id.btn7:


                break;

            case R.id.btn8:
                ActivityUtils.startActivity(this, SearchActivity.class);


                break;


            default:
                break;
        }

    }

    @Override
    protected void handleMsg(Message msg) {

    }
}
