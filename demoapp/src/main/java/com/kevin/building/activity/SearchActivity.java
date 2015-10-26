package com.kevin.building.activity;

import android.os.Message;
import android.view.View;

import com.kevin.baselibrary.interfaze.listener.SearchBarListener;
import com.kevin.baselibrary.interfaze.listener.TitleViewListener;
import com.kevin.baselibrary.view.SearchBar;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/26 11:29
 */
public class SearchActivity extends BaseActivity {

    private SearchBar searchBar;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

        titleView.setTitleText("搜索");
        titleView.setTitleViewListener(new TitleViewListener() {
            @Override
            public boolean onLeftBtnClick() {
                return false;
            }

            @Override
            public boolean onRightBtnClick() {
                show("点击了设置");
                return false;
            }
        });
        searchBar = (SearchBar) findViewById(R.id.search_bar);
        searchBar.setHint("请输入关键词搜索");
        searchBar.setSearchBarListener(new SearchBarListener() {
            @Override
            public boolean onSearch(String searchKey) {
                show("点击了搜索");
                return false;
            }

            @Override
            public boolean onTextChange(String curTextStr) {
                show("内容变化");
                return true;

            }

            @Override
            public boolean onCancelClick() {
                show("点击了取消");
                return true;
            }
        });

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }
}
