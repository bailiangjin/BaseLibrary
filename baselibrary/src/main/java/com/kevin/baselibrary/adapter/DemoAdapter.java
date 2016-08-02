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
 * 示例Adapter 类
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/9 18:25
 */
public class DemoAdapter extends SuperBaseAdapter<GroupModel> {


    public DemoAdapter(Activity context, List<GroupModel> list) {
        super(context, list);
    }


    @Override
    public int getItemLayoutResId() {
        return R.layout.item_group_list;
    }

    @Override
    public Object getViewHolder(View rootView) {
        //返回自己的 ViewHolder对象
        return new ViewHolder(rootView);
    }

    @Override
    public void setItemData(final int position, final GroupModel groupModel, final Object viewHolder) {
        //将holder 转为自己holder
        ViewHolder myHolder = (ViewHolder) viewHolder;
        myHolder.tv_group_name.setText(TextUtils.isEmpty(groupModel.getContactName()) ? "" : groupModel.getContactName());
        //ImageLoadUtils.loadImage(myHolder.iv_group_avatar, groupModel.getHeadUrl());
        myHolder.iv_group_no_disturb.setVisibility(groupModel.getIsDisturb() == 1 ? View.VISIBLE : View.GONE);

    }

    /**
     * ViewHolder 通过构造方法中 实现具体view的绑定的方式 创建一个自实现绑定View的ViewHolder
     * Created by bailiangjin on 16/7/5.
     */
    public static class ViewHolder {
        public final View root;
        public final ImageView iv_group_avatar;
        public final ImageView iv_group_no_disturb;
        public final TextView tv_group_name;

        public ViewHolder(View root) {
            this.root = root;
            this.iv_group_avatar = (ImageView) this.root.findViewById(R.id.iv_group_avatar);
            this.iv_group_no_disturb = (ImageView) this.root.findViewById(R.id.iv_group_no_disturb);
            this.tv_group_name = (TextView) this.root.findViewById(R.id.tv_group_name);

        }
    }


}
