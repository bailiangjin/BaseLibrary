package com.kevin.building.demo.databinding;

import android.view.View;

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


    public void onClick_change(View v) {
        itemBean = new TaskItemBean();
        itemBean.setId("1");
        itemBean.setName("初始名");
        itemBean.setOrder(1);
        binding.setUser(itemBean);
        itemBean.setName("更改后的名字" + System.currentTimeMillis());
    }
}
