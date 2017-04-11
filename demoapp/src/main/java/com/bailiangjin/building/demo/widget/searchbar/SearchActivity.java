package com.bailiangjin.building.demo.widget.searchbar;

import android.os.Bundle;
import android.os.Message;

import com.bailiangjin.uilibrary.widget.SearchBarListener;
import com.bailiangjin.uilibrary.widget.SearchBar;
import com.bailiangjin.building.R;
import com.bailiangjin.building.base.BaseActivity;

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
    protected void beforeViewBind(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        titleBarBuilder.setTitleText("搜索");


        searchBar = (SearchBar) findViewById(R.id.search_bar);
        searchBar.setHint("请输入关键词搜索");
        searchBar.setSearchBarListener(new SearchBarListener() {
            @Override
            public boolean onSearch(String searchKey) {
                shortToast("点击了搜索");
                return false;
            }

            @Override
            public boolean onTextChange(String curTextStr) {
                shortToast("内容变化:" + curTextStr);
                return true;

            }

            @Override
            public boolean onCancelClick() {
                shortToast("点击了取消");
                return true;
            }
        });

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    @Override
    protected void handleMsg(Message msg) {

    }


}
