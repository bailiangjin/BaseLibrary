package com.bailiangjin.simpleim.module.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.appcommon.base.BaseActivity;
import com.bailiangjin.simpleim.engine.logicutils.AccountUtils;
import com.bailiangjin.utilslibrary.utils.ui.ImageLoadUtils;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 用户信息页
 */
public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.iv_head)
    ImageView iv_head;
    @BindView(R.id.btn_userinfo_back)
    Button btn_userinfo_back;
    @BindView(R.id.tv_userinfo_userid)
    TextView tv_userinfo_userid;



    public static void start(Activity activity) {
        Intent intent = new Intent(activity, UserInfoActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void initView(Bundle savedInstanceState) {

        titleBarBuilder.setTitleText(getString(R.string.friend_info));
        ImageLoadUtils.INSTANCE.loadCircleImageView(iv_head,AccountUtils.defaultHeadUrl);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        tv_userinfo_userid.setText(AccountUtils.getUserName());

    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void beforeViewBind(Bundle savedInstanceState) {

    }


    @OnClick( R.id.btn_userinfo_back)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_userinfo_back:
                this.finish();
                break;

            default:
                break;
        }

    }

}
