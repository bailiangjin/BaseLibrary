package com.bailiangjin.simpleim.appui.account;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.base.BaseActivity;
import com.kevin.baselibrary.interfaze.listener.CommonTitleListener;

/**
 * 用户列表页
 */
public class UserListActivity extends BaseActivity {

    public static void start(Activity activity){
        Intent intent = new Intent(activity,UserListActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_userlist;
    }

    @Override
    protected void initIntentData() {

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
                AddFriendActivity.start(UserListActivity.this);
                return true;
            }
        });
    }

    @Override
    protected void initData() {

    }



}
