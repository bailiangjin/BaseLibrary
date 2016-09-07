package com.kevin.building.demo.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kevin.building.model.TaskItemBean;

/**
 * Created by bailiangjin on 16/9/7.
 */
public abstract  class DataBindingBaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    TaskItemBean itemBean;

    T binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getLayoutId();
        binding = DataBindingUtil.setContentView(this, layoutId);

    }

    protected abstract int getLayoutId();

}
