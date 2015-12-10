package com.kevin.building.ui.demo.widget;

import android.os.Message;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.base.BtnBaseActivity;
import com.kevin.building.ui.demo.widget.draggridview.DragGridViewActivity;
import com.kevin.building.ui.demo.widget.searchbar.SearchActivity;
import com.kevin.building.utils.ActivityUtils;

/**
 * 控件入口 Activity
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/20 11:37
 */
public class WidgetMainActivity extends BtnBaseActivity{

    @Override
    protected void initView() {
        super.initView();

        titleView.setTitleText("控件主页面");

        btn1.setText("拖拽按钮示例");
        btn2.setText("搜索框示例");
//        btn3.setText("网络");
//        btn4.setText("数据库");
//        btn5.setText("文件");
//        btn6.setText("传感器");
//        btn7.setText("控件");
//        btn8.setText("搜索框示例");

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
                ActivityUtils.startActivity(this, SearchActivity.class);

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


                break;


            default:
                break;
        }

    }

    @Override
    protected void handleMsg(Message msg) {

    }
}
