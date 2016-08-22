package com.kevin.baselibrary.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.utils.ToastUtils;

/**
 * Created by bailiangjin on 16/8/22.
 */
public class ToolBarBaseActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.toolbar_demo_activity);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        initView();
    }

    private void initView() {
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    ToastUtils.shortToast("点击了搜索");

                } else if (menuItemId == R.id.action_notification) {
                    ToastUtils.shortToast("点击了通知");
                }
                return false;
            }
        });
    }
}
