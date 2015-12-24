package com.kevin.building.ui.demo.viewpager;

import android.content.Context;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.SuperViewUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/24 10:27
 */
public class ViewPagerDemoActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

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
    private List<VpBean> vpBeanList;

    /**
     * ViewPager 下方点  数组
     */
    private ImageView[] imgDots;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_viewpager_demo;
    }

    @Override
    protected void initView() {
        tv_vp_title = (TextView) findViewById(R.id.tv_vp_title);
        mViewPager = (ViewPager) findViewById(R.id.vp_images);
        ll_dot = (LinearLayout) findViewById(R.id.ll_dot);
        mViewPager.addOnPageChangeListener(this);

    }

    @Override
    protected void initLogic() {
        vpBeanList = PageUtil.getPageList(ViewPagerDemoActivity.this);
        mViewPager.setAdapter(new MyPagerAdapter(vpBeanList));
        tv_vp_title.setText(vpBeanList.get(0).getTitle());
        initDots(this, vpBeanList.size());

    }

    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }

    //ViewPager 监听----------------------------------------

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        LogUtils.e("onPageSelected:" + position);
        tv_vp_title.setText(vpBeanList.get(position).getTitle());

        for (int i = 0; i < vpBeanList.size(); i++) {
            if (i == position) {
                this.imgDots[i]
                        .setBackgroundResource(R.drawable.dot_selected);
            } else {
                this.imgDots[i]
                        .setBackgroundResource(R.drawable.dot_normal);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private void initDots(Context context, int dotNum) {
        this.imgDots = SuperViewUtils.getDotImageViews(context, dotNum);
        SuperViewUtils.addDot2Layout(ll_dot, imgDots);
    }


}
