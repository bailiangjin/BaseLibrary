package com.kevin.building.demo.widget.dialog;

import android.content.DialogInterface;
import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.widget.listener.PNDialogListener;
import com.kevin.baselibrary.widget.utils.DialogUtils;
import com.kevin.building.R;
import com.kevin.building.base.BtnBaseActivity;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/10 16:37
 */
public class DialogActivity extends BtnBaseActivity {

    @Override
    protected void initView() {
        super.initView();

        commonTitleView.setTitleText("DialogDemos");
        commonTitleView.setLeftBtnVisibility(View.GONE);

        btn1.setText("退出应用Dialog");
        btn2.setText("Dialog2");
        btn3.setText("Dialog3");
//        btn4.setText("数据库模块");
//        btn5.setText("Fragment模块");
//        btn6.setText("用户信息");
//        btn7.setText("启动模式");
//        btn8.setText("当前测试");

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
                DialogUtils.showPNDialog(DialogActivity.this, getString(R.string.exit_app) + "?", false, new PNDialogListener() {
                    @Override
                    public void onPositive(DialogInterface dialog, int which) {
                        DialogActivity.this.finish();
                    }

                    @Override
                    public void onNegative(DialogInterface dialog, int which) {
                        shortToast("点击了取消");

                    }
                });

                break;

            case R.id.btn2:
                shortToast("点击了测试2");

                break;

            case R.id.btn3:

                break;

            case R.id.btn4:

                break;

            case R.id.btn5:

                break;

            case R.id.btn6:
                //TODO:待添加模块
                shortToast("点击了测试6");


                break;

            case R.id.btn7:


                break;

            case R.id.btn8:
                shortToast("点击了测试8");


                break;


            default:
                break;

        }
    }

    @Override
    protected void handleMsg(Message msg) {

    }


}
