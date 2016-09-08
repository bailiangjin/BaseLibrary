package com.kevin.building.demo.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.SuperViewUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseFragment;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/24 17:01
 */
public class BaseViewPagerFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    /**
     * 标题
     */
    private TextView tv_vp_title;

    /**
     * viewPager 元素
     */
    private ViewPager mViewPager;
    /**
     * 点布局
     */
    private LinearLayout ll_dot;
    /**
     * viewpager item list
     */
    private List<ViewPagerBean> vpBeanList;

    /**
     * ViewPager 下方点  数组
     */
    private ImageView[] imgDots;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_viewpager_demo;
    }




    //viewPager事件监听-------------------------------------------------

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        position = position % vpBeanList.size();
        LogUtils.e("onPageSelected:" + position);
        tv_vp_title.setText(vpBeanList.get(position).getTitle());

        for (int i = 0; i < vpBeanList.size(); i++) {
            if (i == position) {
                imgDots[i].setSelected(true);
            } else {
                imgDots[i].setSelected(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //-----------------------------------------------------------------


    /**
     * 初始化页面
     */
    private void initView() {
        tv_vp_title = (TextView) rootView.findViewById(R.id.tv_vp_title);
        mViewPager = (ViewPager) rootView.findViewById(R.id.vp_images);
        ll_dot = (LinearLayout) rootView.findViewById(R.id.ll_dot);
        mViewPager.addOnPageChangeListener(this);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        vpBeanList = getVpBeanList();
        mViewPager.setAdapter(new MyPagerAdapter(vpBeanList));

        tv_vp_title.setText(vpBeanList.get(0).getTitle());
        initDots(getActivity(), vpBeanList.size());

        if (PageUtil.isCycle) {
            /*
             * 此处设置当前页的显示位置,设置在100(随便什么数,稍微大点就行)就 可以实现向左循环,当然是有限制的,不过一般情况下没啥问题
             */
            mViewPager.setCurrentItem(Integer.MAX_VALUE / 2);
        }
    }

    /**
     * 初始化 点布局
     *
     * @param context
     * @param dotNum
     */
    private void initDots(Context context, int dotNum) {
        //清空原有的View
        ll_dot.removeAllViewsInLayout();
        imgDots = SuperViewUtils.getDotImageViews(context, dotNum);
        SuperViewUtils.addDot2Layout(ll_dot, imgDots);
    }

    /**
     * 获取ViewPager 数据list
     * @return
     */
    protected List<ViewPagerBean> getVpBeanList() {
        return PageUtil.getPageList(getActivity());

    }





}
