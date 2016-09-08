package com.kevin.building.demo.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

/**
 * Created by bailiangjin on 16/9/7.
 */
public abstract class ToolbarBindingBaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    Toolbar toolbar;

    TitleBarBuilder titleBarBuilder;

    T binding;

    protected FrameLayout baseContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSuperUI();
        binding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), baseContainer, true);
        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    /**
     * 初始化父类UI
     */
    private void initSuperUI() {
        super.setContentView(com.kevin.baselibrary.R.layout.activity_binding_base_xml);
        baseContainer = (FrameLayout) findViewById(com.kevin.baselibrary.R.id.baseContainer);
        toolbar = (Toolbar) findViewById(com.kevin.baselibrary.R.id.toolbar);
        titleBarBuilder = new TitleBarBuilder(this, toolbar);
    }


}
