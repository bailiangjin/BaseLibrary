package com.bailiangjin.simpleim.module.im.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.module.account.LogoutActivity;
import com.bailiangjin.simpleim.module.account.UserInfoActivity;
import com.bailiangjin.simpleim.module.common.SettingActivity;
import com.bailiangjin.simpleim.appcommon.base.BaseActivity;
import com.bailiangjin.simpleim.utils.ActivityUtils;
import com.kevin.baselibrary.activity.ItemClickListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加联系人
 */
public class AddFriendActivity extends BaseActivity {

    /**
     * 添加按钮
     */
    @BindView(R.id.btn_add)
    Button btn_add;
    /**
     * 退出按钮
     */
    @BindView(R.id.btn_logout)
    Button btn_logout;


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, AddFriendActivity.class);
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
    protected void initView(Bundle savedInstanceState) {
        titleBarBuilder.setTitleText(getString(R.string.addcontacts));
        titleBarBuilder.addMenuItem("用户信息", new ItemClickListener() {
            @Override
            public void onClick() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        UserInfoActivity.start(AddFriendActivity.this);
                    }
                });
            }
        }).build();

        titleBarBuilder.addMenuItem("设置", new ItemClickListener() {
            @Override
            public void onClick() {
                ActivityUtils.startActivity(AddFriendActivity.this, SettingActivity.class);
            }
        }).build();

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    @OnClick({R.id.btn_add, R.id.btn_logout})
    public void onClick(View v) {
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
