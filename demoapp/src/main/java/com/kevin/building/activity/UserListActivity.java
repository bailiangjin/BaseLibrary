package com.kevin.building.activity;

import android.content.Intent;
import android.view.View;

import com.kevin.baselibrary.interfaze.listener.CommonTitleListener;
import com.kevin.building.R;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;

/**
 * 用户列表页
 */
public class UserListActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_userlist;
    }


    @Override
    protected void initView() {
        commonTitleView.setTitleText(getString(R.string.contacts));
        commonTitleView.setRightBtnText(getString(R.string.add));
        commonTitleView.setRightBtnVisibility(View.VISIBLE);

        commonTitleView.setTitleViewListener(new CommonTitleListener() {

            @Override
            public boolean onRightImgClick() {
                return false;
            }

            @Override
            public boolean onRightBtnClick() {
                Intent intent = new Intent(UserListActivity.this, AddFriendActivity.class);
                AppManager.getInstance().startActivity(UserListActivity.this, intent);
                return true;
            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void onViewClick(View v) {
        // TODO Auto-generated method stub

    }

}
