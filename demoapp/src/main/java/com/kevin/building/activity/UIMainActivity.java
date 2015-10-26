package com.kevin.building.activity;

import android.os.Message;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.base.BtnBaseActivity;
import com.kevin.building.demo.draggridview.DragGridViewActivity;
import com.kevin.building.utils.ActivityUtils;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/20 11:37
 */
public class UIMainActivity extends BtnBaseActivity{

    @Override
    protected void initView() {
        super.initView();

        titleView.setTitleText("UI主页面");

        btn1.setText("DragGridView");
        btn2.setText("Fragment");
//        btn3.setText("网络");
//        btn4.setText("数据库");
//        btn5.setText("文件");
//        btn6.setText("传感器");
//        btn7.setText("控件");
        btn8.setText("搜索Bar");
//
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        btn6.setVisibility(View.VISIBLE);
        btn7.setVisibility(View.VISIBLE);
        btn8.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void onViewClick(View v) {

        switch (v.getId()) {
            case R.id.btn1:
                ActivityUtils.startActivity(this, DragGridViewActivity.class);
                break;

            case R.id.btn2:


                break;

            case R.id.btn3:


                break;

            case R.id.btn4:


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
