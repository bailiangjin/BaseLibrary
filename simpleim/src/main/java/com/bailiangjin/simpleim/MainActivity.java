package com.bailiangjin.simpleim;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.bailiangjin.simpleim.appui.common.adapter.MainFragmentAdapter;
import com.bailiangjin.simpleim.appui.common.fragment.ContactFragment;
import com.bailiangjin.simpleim.appui.common.fragment.DiscoverFragment;
import com.bailiangjin.simpleim.appui.common.fragment.HomeFragment;
import com.bailiangjin.simpleim.appui.common.fragment.SettingFragment;
import com.bailiangjin.simpleim.appui.im.user.UserListActivity;
import com.bailiangjin.simpleim.base.BaseActivity;
import com.kevin.baselibrary.activity.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {


    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;
    private Class fragmentArray[] = {HomeFragment.class, ContactFragment.class, DiscoverFragment.class,SettingFragment.class};
    private int imageViewArray[] = {R.drawable.ic_tab_home_selector, R.drawable.ic_tab_contact_selector,R.drawable.ic_tab_discover_selector,R.drawable.ic_tab_my_selector};
    private String textViewArray[] = {"简信", "联系人", "发现","我"};
    private List<Fragment> list = new ArrayList<Fragment>();
    private ViewPager vp;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initIntentData() {

    }

    @Override
    protected void initView() {
        titleBarBuilder.setTitleText("简信");
        titleBarBuilder.hideBackIcon();
        titleBarBuilder.addMenuItem("扫一扫", new ItemClickListener() {
            @Override
            public void onClick() {
                UserListActivity.start(MainActivity.this);
                shortToast("点击了扫一扫");
            }
        }).build();
        initFRView();
        initPage();//初始化页面

    }

    @Override
    protected void initData() {

    }


    //    控件初始化控件
    private void initFRView() {
        vp = (ViewPager) findViewById(R.id.vp);

        /*实现OnPageChangeListener接口,目的是监听Tab选项卡的变化，然后通知ViewPager适配器切换界面*/
        /*简单来说,是为了让ViewPager滑动的时候能够带着底部菜单联动*/

        vp.addOnPageChangeListener(this);//设置页面切换时的监听器
        layoutInflater = LayoutInflater.from(this);//加载布局管理器

        /*实例化FragmentTabHost对象并进行绑定*/
        mTabHost = (FragmentTabHost) findViewById(R.id.fragmentTabHost);//绑定tahost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.vp);//绑定viewpager

        /*实现setOnTabChangedListener接口,目的是为监听界面切换），然后实现TabHost里面图片文字的选中状态切换*/
        /*简单来说,是为了当点击下面菜单时,上面的ViewPager能滑动到对应的Fragment*/
        mTabHost.setOnTabChangedListener(this);

        int count = textViewArray.length;

        /*新建Tabspec选项卡并设置Tab菜单栏的内容和绑定对应的Fragment*/
        for (int i = 0; i < count; i++) {
            // 给每个Tab按钮设置标签、图标和文字
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(textViewArray[i])
                    .setIndicator(getTabItemView(i));
            // 将Tab按钮添加进Tab选项卡中，并绑定Fragment
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.setTag(i);
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.color.white);//设置Tab被选中的时候颜色改变
        }
    }

    /*初始化Fragment*/
    private void initPage() {
        HomeFragment fragment1 = new HomeFragment();
        ContactFragment fragment2 = new ContactFragment();
        DiscoverFragment fragment3 = new DiscoverFragment();
        SettingFragment fragment4 = new SettingFragment();


        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);

        //绑定Fragment适配器
        vp.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), list));
        mTabHost.getTabWidget().setDividerDrawable(R.color.black);
    }

    private View getTabItemView(int i) {
        //将xml布局转换为view对象
        View view = layoutInflater.inflate(R.layout.tab_content, null);
        //利用view对象，找到布局中的组件,并设置内容，然后返回视图
        ImageView mImageView = (ImageView) view
                .findViewById(R.id.tab_imageview);
        TextView mTextView = (TextView) view.findViewById(R.id.tab_textview);
        mImageView.setBackgroundResource(imageViewArray[i]);
        mTextView.setText(textViewArray[i]);
        return view;
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }//arg0 ==1的时候表示正在滑动，arg0==2的时候表示滑动完毕了，arg0==0的时候表示什么都没做，就是停在那。

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }//表示在前一个页面滑动到后一个页面的时候，在前一个页面滑动前调用的方法

    @Override
    public void onPageSelected(int arg0) {//arg0是表示你当前选中的页面位置Postion，这事件是在你页面跳转完毕的时候调用的。
        TabWidget widget = mTabHost.getTabWidget();
        int oldFocusability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);//设置View覆盖子类控件而直接获得焦点
        mTabHost.setCurrentTab(arg0);//根据位置Postion设置当前的Tab
        widget.setDescendantFocusability(oldFocusability);//设置取消分割线

    }

    @Override
    public void onTabChanged(String tabId) {//Tab改变的时候调用
        int position = mTabHost.getCurrentTab();
        vp.setCurrentItem(position);//把选中的Tab的位置赋给适配器，让它控制页面切换
    }


}
