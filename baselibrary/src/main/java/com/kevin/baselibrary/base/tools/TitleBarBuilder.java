package com.kevin.baselibrary.base.tools;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.baselibrary.R;
import com.kevin.baselibrary.activity.ItemClickListener;
import com.kevin.baselibrary.utils.DensityUtils;
import com.kevin.baselibrary.utils.LogUtils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author bailiangjin
 */
public class TitleBarBuilder {

    private static final int defaultBgResId = R.drawable.title_gradient_bg;
    private static final int defaultBackIconResId = R.drawable.ic_arrow_back_white_36dp;
    private static final int defaultSearchIconResId = R.drawable.ic_search_white;
    private static final int defaultShareIconResId = R.drawable.ic_share_white;

    Map<String, MyMenuItem> itemLinkedHashMap = new LinkedHashMap<>();

    Toolbar toolbar;
    TextView tv_title;

    public TitleBarBuilder(final Activity activity, Toolbar toolbar) {
        this.toolbar = toolbar;

        tv_title = (TextView) toolbar.findViewById(R.id.tv_title_toolbar);
        toolbar.setBackgroundResource(defaultBgResId);

        //默认 返回键按钮
        toolbar.setNavigationIcon(defaultBackIconResId);
        //默认点击事件 finish Activity
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });


        toolbar.setTitleTextAppearance(activity, R.style.title_tv_style);
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                MyMenuItem myMenuItem = itemLinkedHashMap.get(item.getTitle());
                if (null != myMenuItem && null != myMenuItem.getItemClickListener()) {
                    myMenuItem.getItemClickListener().onClick();
                    return true;
                }
                return false;
            }
        });
    }


    public Toolbar build() {
        setMyMenu(toolbar.getMenu());
        return toolbar;
    }


    public TitleBarBuilder setTitle(String title) {
        tv_title.setText(title);
        return this;
    }

    public TitleBarBuilder setIconVisibility(String title,boolean visibility) {
        if(null==itemLinkedHashMap.get(title)) {
            return this;
        }

        MenuItem menuItem = toolbar.getMenu().findItem(itemLinkedHashMap.get(title).getId());
        if (null==menuItem){
            return this;
        }
        menuItem.setVisible(visibility);
        return this;
    }


    /**
     * 设置 标题栏北京
     * @param backGroundResId
     * @return
     */
    public TitleBarBuilder setBackGround(int backGroundResId) {
        toolbar.setBackgroundResource(backGroundResId);
        return this;
    }

    /**
     * 设置标题文字宽度
     *
     * @param width dp
     */
    public void setTitleTvWidth(int width) {
        ViewGroup.LayoutParams layoutParams = tv_title.getLayoutParams();
        layoutParams.width = DensityUtils.dip2px(width);
        tv_title.setLayoutParams(layoutParams);
        tv_title.invalidate();
    }




    /**
     * 自定义返回键
     *
     * @param description
     * @param iconResId
     * @param listener
     * @return
     */
    public TitleBarBuilder setBackIcon(String description, int iconResId, final ItemClickListener listener) {
        toolbar.setNavigationIcon(iconResId);
        toolbar.setNavigationContentDescription(description);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick();
            }
        });
        return this;
    }

    public TitleBarBuilder addMenuItem(MyMenuItem menuItem) {
        itemLinkedHashMap.put(menuItem.getTitle(), menuItem);
        return this;
    }


    public TitleBarBuilder addItem(String title, ItemClickListener listener) {
        MyMenuItem menuItem = new MyMenuItem(title, -1, MyMenuItem.Type.OTHER, listener);
        itemLinkedHashMap.put(menuItem.getTitle(), menuItem);
        return this;
    }

    public TitleBarBuilder addItem(String title, int iconResId, ItemClickListener listener) {
        MyMenuItem menuItem = new MyMenuItem(title, iconResId, MyMenuItem.Type.OTHER, listener);
        itemLinkedHashMap.put(menuItem.getTitle(), menuItem);
        return this;
    }

    public TitleBarBuilder addShareMenuItem(ItemClickListener listener) {
        MyMenuItem menuItem = new MyMenuItem("分享", defaultShareIconResId, MyMenuItem.Type.SHARE, listener);
        itemLinkedHashMap.put(menuItem.getTitle(), menuItem);
        return this;
    }

    public TitleBarBuilder addSearchMenuItem(ItemClickListener listener) {
        MyMenuItem menuItem = new MyMenuItem("搜索", defaultSearchIconResId, MyMenuItem.Type.SEARCH, listener);
        itemLinkedHashMap.put(menuItem.getTitle(), menuItem);
        return this;
    }


    private void addMenuItem(Menu menu, int itemResId, MyMenuItem myMenuItem) {
        menu.findItem(itemResId).setVisible(true);
        if (myMenuItem.getIconResId() > 0) {
            menu.findItem(itemResId).setIcon(myMenuItem.getIconResId());
        } else {
            menu.findItem(itemResId).setIcon(0);
        }
        menu.findItem(itemResId).setTitle(myMenuItem.getTitle());
    }


    private boolean setMyMenu(Menu menu) {
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
                    item.setIconResId(defaultSearchIconResId);
                    break;
                case SHARE:
                    item.setIconResId(defaultShareIconResId);
                    break;
                case OTHER:
                    break;
            }
            int itemId;
            switch (menuCount) {
                case 0:
                    itemId=R.id.item1;
                    addMenuItem(menu, R.id.item1, item);
                    break;
                case 1:
                    itemId=R.id.item2;
                    addMenuItem(menu, R.id.item2, item);
                    break;
                case 2:
                    itemId=R.id.item3;
                    addMenuItem(menu, R.id.item3, item);
                    break;
                case 3:
                    itemId=R.id.item4;
                    addMenuItem(menu, R.id.item4, item);
                    break;
                case 4:
                    itemId=R.id.item5;
                    addMenuItem(menu, R.id.item5, item);
                    break;
                default:
                    //menu.add(item.getTitle());
                    itemId=-menuCount;
                    menu.add(1,itemId,0,item.getTitle());
                    LogUtils.e("menu item size is over 5 ");
                    break;
            }

            item.setId(itemId);
            menuCount++;

        }
        return true;
    }


}
