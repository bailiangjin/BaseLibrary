package com.kevin.building.demo.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.kevin.baselibrary.utils.ToastUtils;
import com.kevin.baselibrary.view.TitleView;

/**
 * Created by bailiangjin on 16/9/7.
 */
public abstract class DataBindingBaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    Toolbar toolbar;

    T binding;
    protected FrameLayout baseContainer;

    protected TitleView commonTitleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSuperUI();
        binding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), baseContainer, false);
    }

    protected abstract int getLayoutId();


    /**
     * 初始化父类UI
     */
    private void initSuperUI() {
        super.setContentView(com.kevin.baselibrary.R.layout.activity_binding_base_xml);
        baseContainer = (FrameLayout) findViewById(com.kevin.baselibrary.R.id.baseContainer);
        toolbar = (Toolbar) findViewById(com.kevin.baselibrary.R.id.toolbar);
        toolbar.setNavigationIcon(com.kevin.baselibrary.R.drawable.ic_arrow_back_white_36dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        toolbar.inflateMenu(com.kevin.baselibrary.R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == com.kevin.baselibrary.R.id.action_search) {
                    ToastUtils.shortToast("点击了搜索");

                } else if (menuItemId == com.kevin.baselibrary.R.id.action_notification) {
                    ToastUtils.shortToast("点击了通知");
                }
                return false;
            }
        });

    }

}
