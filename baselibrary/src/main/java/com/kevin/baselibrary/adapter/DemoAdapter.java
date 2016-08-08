package com.kevin.baselibrary.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.base.SuperBaseAdapter;
import com.kevin.baselibrary.model.GroupModel;

import java.util.List;

/**
 * Created by bailiangjin on 16/8/1.
 */
public class DemoAdapter extends SuperBaseAdapter<GroupModel> {

    public DemoAdapter(Activity activity, List<GroupModel> dataList) {
        super(activity, dataList);
    }

    @Override
    public int getItemLayoutResId() {
        return R.layout.item_group_list;
    }

    @Override
    protected BaseViewHolder getViewHolder(View rootView) {
        return new DemoViewHolder(rootView);
    }


    public class DemoViewHolder extends BaseViewHolder<GroupModel> {
        public final View root;
        public final ImageView iv_group_avatar;
        public final ImageView iv_group_no_disturb;
        public final TextView tv_group_name;

        public DemoViewHolder(View rootView) {
            super(rootView);
            this.root = rootView;
            this.iv_group_avatar = (ImageView) this.root.findViewById(R.id.iv_group_avatar);
            this.iv_group_no_disturb = (ImageView) this.root.findViewById(R.id.iv_group_no_disturb);
            this.tv_group_name = (TextView) this.root.findViewById(R.id.tv_group_name);
        }

        @Override
        public void show(int position,GroupModel groupModel) {
            this.tv_group_name.setText(TextUtils.isEmpty(groupModel.getContactName()) ? "" : groupModel.getContactName());
            this.iv_group_no_disturb.setVisibility(groupModel.getIsDisturb() == 1 ? View.VISIBLE : View.GONE);
            //ImageLoadUtils.loadImage(myHolder.iv_group_avatar, groupModel.getHeadUrl());
        }
    }
}
