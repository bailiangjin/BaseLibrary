package com.kevin.building.demo.databinding;

import android.view.View;

import com.kevin.baselibrary.activity.ItemClickListener;
import com.kevin.baselibrary.utils.ToastUtils;
import com.kevin.building.R;
import com.kevin.building.databinding.ActivityDataBindingBinding;
import com.kevin.building.model.TaskItemBean;

/**
 * Created by bailiangjin on 16/9/7.
 */
public class DataBindingActivity extends DataBindingBaseActivity<ActivityDataBindingBinding> {
    TaskItemBean itemBean;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_data_binding;
    }

    @Override
    protected void initView() {
        tv_title.setText("测试绑定绑定绑定绑定绑定绑定绑定");

        addSearchMenuItem(new ItemClickListener() {
            @Override
            public void onClick() {
                ToastUtils.shortToast("点击了搜索");
            }
        });
        addItem("添加", -1, new ItemClickListener() {
            @Override
            public void onClick() {

            }
        });
        addShareMenuItem(new ItemClickListener() {
            @Override
            public void onClick() {
                ToastUtils.shortToast("点击分享");
            }
        });
        addItem("测试1", R.drawable.ic_search_white, new ItemClickListener() {
            @Override
            public void onClick() {

            }
        });

        addItem("测试3", R.drawable.ic_search_white, new ItemClickListener() {
            @Override
            public void onClick() {

            }
        });
        buildMenu();


    }


    public void onClick_change(View v) {

        itemBean = new TaskItemBean();
        itemBean.setId("1");
        itemBean.setName("初始名");
        itemBean.setOrder(1);
        binding.setUser(itemBean);
        itemBean.setName("更改后的名字" + System.currentTimeMillis());
        invalidateOptionsMenu();
    }
}
