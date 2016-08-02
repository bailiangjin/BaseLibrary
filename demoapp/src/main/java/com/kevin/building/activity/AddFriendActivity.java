package com.kevin.building.activity;

import android.view.View;
import android.widget.Button;

import com.kevin.baselibrary.interfaze.listener.CommonTitleListener;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.utils.ActivityUtils;

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
                        ActivityUtils.startActivity(AddFriendActivity.this, UserInfoActivity.class);
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
                ActivityUtils.startActivity(AddFriendActivity.this, LogoutActivity.class);
                break;

            default:
                break;
        }
    }

}
