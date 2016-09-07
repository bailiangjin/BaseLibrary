package com.kevin.building.demo.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kevin.baselibrary.activity.ItemClickListener;
import com.kevin.baselibrary.activity.MyMenuItem;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;
import com.kevin.baselibrary.view.TitleView;
import com.kevin.building.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bailiangjin on 16/9/7.
 */
public abstract class DataBindingBaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    Toolbar toolbar;
    TextView tv_title;
    int visiableMenuCount = 0;

    Map<String, MyMenuItem> itemLinkedHashMap = new LinkedHashMap<>();

    T binding;
    protected FrameLayout baseContainer;

    protected TitleView commonTitleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSuperUI();
        binding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), baseContainer, true);
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();


    /**
     * 初始化父类UI
     */
    private void initSuperUI() {
        super.setContentView(com.kevin.baselibrary.R.layout.activity_binding_base_xml);
        baseContainer = (FrameLayout) findViewById(com.kevin.baselibrary.R.id.baseContainer);
        toolbar = (Toolbar) findViewById(com.kevin.baselibrary.R.id.toolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        toolbar.setBackgroundResource(R.drawable.title_gradient_bg);
        toolbar.setNavigationIcon(com.kevin.baselibrary.R.drawable.ic_arrow_back_white_36dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitleTextAppearance(this, R.style.title_tv_style);

        toolbar.inflateMenu(com.kevin.baselibrary.R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               MyMenuItem item1= itemLinkedHashMap.get(item.getTitle());
                if(null!=item1&&null!=item1.getItemClickListener()) {
                    item1.getItemClickListener().onClick();
                    return true;
                }
                return false;
            }
        });




    }


    public boolean setMyMenu(Menu menu) {
        LogUtils.e("menu list is empty");

        if (null == itemLinkedHashMap || itemLinkedHashMap.isEmpty()) {
            LogUtils.e("menu list is empty");
            return false;
        }

        int menuCount = 0;

        Iterator<Map.Entry<String, MyMenuItem>> iterator = itemLinkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, MyMenuItem> entry = iterator.next();
            MyMenuItem item = entry.getValue();

            switch (item.getType()) {
                case SEARCH:
                    item.setIconResId(R.drawable.ic_search_white);
                    break;
                case SHARE:
                    item.setIconResId(R.drawable.ic_share_white);
                    break;
                case OTHER:
                    break;
            }

            switch (menuCount) {
                case 0:
                    addMenuItem(menu, R.id.item1, item);
                    break;
                case 1:
                    addMenuItem(menu, R.id.item2, item);
                    break;
                case 2:
                    addMenuItem(menu, R.id.item3, item);
                    break;
                case 3:
                    addMenuItem(menu, R.id.item4, item);
                    break;
                case 4:
                    addMenuItem(menu, R.id.item5, item);
                    break;
                default:
                    LogUtils.e("menu item size is full ");
                    break;
            }

            menuCount++;

        }


        return true;
    }


    protected void buildMenu() {
        setMyMenu(toolbar.getMenu());
    }

    protected void addItem(String title, int iconResId,ItemClickListener listener) {
        MyMenuItem menuItem = new MyMenuItem(title, iconResId, MyMenuItem.Type.OTHER,listener);
        itemLinkedHashMap.put(menuItem.getTitle(), menuItem);
    }

    protected void addShareMenuItem(ItemClickListener listener) {
        MyMenuItem menuItem = new MyMenuItem("分享",R.drawable.ic_share_white, MyMenuItem.Type.SHARE,listener);
        itemLinkedHashMap.put(menuItem.getTitle(), menuItem);
    }

    protected void addSearchMenuItem(ItemClickListener listener) {
        MyMenuItem menuItem = new MyMenuItem("搜索",R.drawable.ic_search_white, MyMenuItem.Type.SEARCH,listener);
        itemLinkedHashMap.put(menuItem.getTitle(), menuItem);
    }



    private void addMenuItem(Menu menu, int itemResId, MyMenuItem myMenuItem) {
        menu.findItem(itemResId).setVisible(true);
        if(myMenuItem.getIconResId()>0){
            menu.findItem(itemResId).setIcon(myMenuItem.getIconResId());
        }else {
            menu.findItem(itemResId).setIcon(0);
        }

        menu.findItem(itemResId).setTitle(myMenuItem.getTitle());
    }


}
