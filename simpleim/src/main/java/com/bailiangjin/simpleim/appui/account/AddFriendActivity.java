package com.bailiangjin.simpleim.appui.account;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.base.BaseActivity;
import com.kevin.baselibrary.interfaze.listener.CommonTitleListener;

/**
 * 添加联系人
 */
public class AddFriendActivity extends BaseActivity {

    /**
     * 添加按钮
     */
    private Button btn_add;
    /**
     * 退出按钮
     */
    private Button btn_logout;


    public static void start(Activity activity){
        Intent intent = new Intent(activity,AddFriendActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_addfriend;
    }

    @Override
    protected void initIntentData() {

    }


    @Override
    protected void initView() {
        commonTitleView.setTitleText(getString(R.string.addcontacts));
        commonTitleView.setRightBtnText(getString(R.string.user_info));
        commonTitleView.setRightBtnVisibility(View.VISIBLE);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_logout = (Button) findViewById(R.id.btn_logout);

        btn_add.setOnClickListener(this);
        btn_logout.setOnClickListener(this);

        commonTitleView.setTitleViewListener(new CommonTitleListener() {

            @Override
            public boolean onRightImgClick() {
                return false;
            }

            @Override
            public boolean onRightBtnClick() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        UserInfoActivity.start(AddFriendActivity.this);
                    }
                });
                return true;
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                shortToast("添加");
                break;
            case R.id.btn_logout:
                shortToast("登出");
                LogoutActivity.start(AddFriendActivity.this);
                break;

            default:
                break;
        }
    }

}
