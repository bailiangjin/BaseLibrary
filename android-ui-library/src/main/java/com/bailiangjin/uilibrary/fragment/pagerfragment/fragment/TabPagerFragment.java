package com.bailiangjin.uilibrary.fragment.pagerfragment.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.bailiangjin.uilibrary.R;
import com.bailiangjin.uilibrary.fragment.SuperBaseFragment;
import com.bailiangjin.uilibrary.fragment.pagerfragment.adapter.BaseTabPageBean;
import com.bailiangjin.uilibrary.fragment.pagerfragment.adapter.BaseFragmentPagerAdapter;
import com.bailiangjin.uilibrary.view.SupportNoScrollViewpager;


/**
 * Created by bailiangjin on 2017/3/22.
 */

public abstract class TabPagerFragment<T extends BaseTabPageBean> extends SuperBaseFragment {
    SupportNoScrollViewpager viewPager;

    TabLayout tabLayout;

    Fragment curFragment;

    private static int DEFAULT_NORMAL_TEXT_COLOR = R.color.tv_black_333;
    private static int DEFAULT_SELECTED_TEXT_COLOR = R.color.app_base_color;
    private static int DEFAULT_BACKGROUND_RESID = R.color.white;
    private static int DEFAULT_TAB_INDICATOR_COLOR = R.color.app_base_color;

    protected BaseFragmentPagerAdapter fragmentPagerAdapter;

    public BaseFragmentPagerAdapter<T> getFragmentPagerAdapter() {
        return fragmentPagerAdapter;
    }

    public void setFragmentPagerAdapter(BaseFragmentPagerAdapter<T> fragmentPagerAdapter) {
        this.fragmentPagerAdapter = fragmentPagerAdapter;
        curFragment = fragmentPagerAdapter.getItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                curFragment = TabPagerFragment.this.fragmentPagerAdapter.getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_with_fragment_viewpager;
    }


    @Override
    protected void initView() {
        viewPager= (SupportNoScrollViewpager) rootView.findViewById(R.id.viewPager);
        tabLayout= (TabLayout) rootView.findViewById(R.id.tabLayout);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        fragmentPagerAdapter = getAdapter();
        curFragment = fragmentPagerAdapter.getItem(0);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabTextColors(getNormalTabTextColor() <= 0 ? DEFAULT_NORMAL_TEXT_COLOR : getNormalTabTextColor(), getSelectedTabTextColor() <= 0 ? DEFAULT_SELECTED_TEXT_COLOR : getSelectedTabTextColor());
        setSelectedTabIndicatorColor(getSelectedTabIndicatorColor() <= 0 ? DEFAULT_TAB_INDICATOR_COLOR : getSelectedTabIndicatorColor());
        setTabBackground(getTabBackgroundResId() <= 0 ? DEFAULT_BACKGROUND_RESID : getTabBackgroundResId());
        setTabMode(getTabMode());
    }

    public void  setScroll(boolean isCanScroll){
        if(null!=viewPager){
            viewPager.setNoScroll(!isCanScroll);
        }
    }


    /**
     * 隐藏 tab layout
     */
    public void hideTab() {
        if (null != tabLayout) {
            tabLayout.setVisibility(View.GONE);
        }

    }

    /**
     * 显示 tab layout
     */
    public void showTab() {
        if (null != tabLayout) {
            tabLayout.setVisibility(View.VISIBLE);
        }
    }

    private void setTabTextColors(int normalColor, int selectedColor) {
        tabLayout.setTabTextColors(getActivity().getResources().getColor(normalColor), getActivity().getResources().getColor(selectedColor));

    }

    private void setSelectedTabIndicatorColor(int selectedColor) {
        tabLayout.setSelectedTabIndicatorColor(getActivity().getResources().getColor(selectedColor));
    }


    private void setTabMode(int mode) {
        tabLayout.setTabMode(mode);
    }


    private void setTabBackground(int bgResId) {
        tabLayout.setBackgroundResource(bgResId);

    }


    /**
     * 未选中文字颜色
     *
     * @return
     */
    protected int getNormalTabTextColor() {
        return 0;
    }

    /**
     * 选中文字颜色
     *
     * @return
     */
    protected int getSelectedTabTextColor() {
        return 0;
    }

    /**
     * 选中状态下划线颜色
     *
     * @return
     */
    protected int getSelectedTabIndicatorColor() {
        return 0;
    }

    /**
     * tablayout 背景 ResId
     *
     * @return
     */
    protected int getTabBackgroundResId() {
        return 0;
    }

    /**
     * tablayout mode
     *
     * @return
     */
    protected int getTabMode() {
        return TabLayout.MODE_SCROLLABLE;
    }


    /**
     * 获取当前显示的fragment
     *
     * @return
     */
    public Fragment getCurFragment() {
        return curFragment;
    }



    public abstract BaseFragmentPagerAdapter<T> getAdapter();
}
