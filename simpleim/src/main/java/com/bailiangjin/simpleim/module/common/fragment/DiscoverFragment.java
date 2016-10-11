package com.bailiangjin.simpleim.module.common.fragment;

import com.bailiangjin.simpleim.R;
import com.bailiangjin.simpleim.appcommon.base.BaseFragment;
import com.bailiangjin.simpleim.sdk.leancloud.LcLoginActivity;
import com.bailiangjin.simpleim.view.MyItemView;
import com.kevin.baselibrary.activity.ItemClickListener;

/**
 * Created by bailiangjin on 16/9/30.
 */

public class DiscoverFragment extends BaseFragment{

    MyItemView itv_friend_circle;
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main_discover;
    }



    @Override
    protected void initView() {
        itv_friend_circle= (MyItemView) rootView.findViewById(R.id.itv_friend_circle);
        itv_friend_circle.setClickListener(new ItemClickListener() {
            @Override
            public void onClick() {
                LcLoginActivity.start(getActivity());
            }
        });
    }

    @Override
    protected void initData() {

    }

}
