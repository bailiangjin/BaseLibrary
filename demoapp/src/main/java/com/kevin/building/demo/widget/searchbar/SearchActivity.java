package com.kevin.building.demo.widget.searchbar;

import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
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
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

        titleView.setTitleText("搜索");
        titleView.setTitleViewListener(new TitleViewListener() {
            @Override
            public boolean onLeftImgClick() {
                return false;
            }

            @Override
            public boolean onRightImgClick() {
                return false;
            }

            @Override
            public boolean onLeftBtnClick() {
                return false;
            }

            @Override
            public boolean onRightBtnClick() {
                shortToast("点击了设置");
                return false;
            }
        });
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
                shortToast("内容变化");
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
    protected void initLogic() {

    }

    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Search Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.kevin.building.demo.widget.searchbar/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Search Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.kevin.building.demo.widget.searchbar/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
