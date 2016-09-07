package com.kevin.building.demo.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.databinding.ActivityTestDatabindingBinding;
import com.kevin.building.model.TaskItemBean;

/**
 * Created by bailiangjin on 16/9/7.
 */
public class TestDataBindingActivity extends Activity {
    TaskItemBean itemBean;

    ActivityTestDatabindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test_databinding);
        itemBean = new TaskItemBean();
        itemBean.setId("1");
        itemBean.setName("初始名");
        itemBean.setOrder(1);
        binding.setUser(itemBean);


    }


    public void onClick_change(View v) {
        itemBean.setName("更改后的名字" + System.currentTimeMillis());
    }
}
