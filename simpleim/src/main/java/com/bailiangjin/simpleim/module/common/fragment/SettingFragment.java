package com.bailiangjin.simpleim.module.common.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.appcommon.base.BaseFragment;
import com.bailiangjin.simpleim.engine.logicutils.AccountUtils;
import com.bailiangjin.simpleim.module.account.UserInfoActivity;
import com.bailiangjin.simpleim.utils.ImageLoadUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bailiangjin on 16/9/30.
 */

public class SettingFragment extends BaseFragment{

    @BindView(R.id.rl_user_info)
    RelativeLayout rl_user_info;
    @BindView(R.id.tv_id)
    TextView tv_id;
    @BindView(R.id.tv_name)
    TextView tv_name;

    @BindView(R.id.iv_head)
    ImageView iv_head;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main_setting;
    }



    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        tv_id.setText(AccountUtils.getCurrentUserId());
        tv_name.setText(AccountUtils.getCurrentUserId().toUpperCase());
        ImageLoadUtils.INSTANCE.loadCircleImageView(iv_head,AccountUtils.defaultHeadUrl);
    }

    @OnClick( R.id.rl_user_info)
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.rl_user_info:
                UserInfoActivity.start(getActivity());
                break;

            default:
                break;
        }
    }

}
