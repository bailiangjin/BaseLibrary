package com.kevin.building.ui.demo.dynamic;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.kevin.baselibrary.utils.GsonUtils;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.bean.PageInfo;
import com.kevin.building.ui.demo.dynamic.bean.PageParamBean;
import com.kevin.building.ui.demo.dynamic.generater.DynamicViewGenerator;
import com.kevin.building.ui.demo.dynamic.generater.PagerBeanGenerator;
import com.kevin.building.ui.demo.dynamic.generater.ViewBeanGenerator;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.constants.ItemType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.TextItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态加载UIActivity
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 14:21
 */
public class DynamicPageActivity extends BaseActivity {

    private GridView gv_essential;
    private GridView gv_inessential;


    private PageParamBean pageParamBean;


    private LayoutInflater layoutInflater;


    @Override
    protected int getLayoutResId() {
        return -1;
    }

    @Override
    protected void initView() {
        layoutInflater = LayoutInflater.from(this);
        // 创建LinearLayout 作为根View
        LinearLayout mLinearLayout = (LinearLayout) layoutInflater.inflate(R.layout.ctn_ll, null);
        setContentView(mLinearLayout);

        initData();

        List<ViewBean> viewBeanList = pageParamBean.getViewBeanList();
        for (ViewBean viewBean : viewBeanList) {
            mLinearLayout.addView(DynamicViewGenerator.getView(DynamicPageActivity.this, viewBean));
        }

    }


    private void initData() {

        List<BtnItem> essentialItemList = new ArrayList<>();
        List<BtnItem> inessentialItemList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            BtnItem btnItem = new BtnItem();
            btnItem.setViewType(ItemType.BTN);
            btnItem.setBtnType(ItemType.BTN);
            btnItem.setIndex("必拍" + (i + 1));
            essentialItemList.add(btnItem);
        }


        for (int i = 0; i < 7; i++) {
            BtnItem essentialItem = new BtnItem();
            essentialItem.setViewType(ItemType.BTN);
            essentialItem.setIndex("非必拍" + (i + 1));
            inessentialItemList.add(essentialItem);
        }

        TextItem textItemMust = new TextItem();
        textItemMust.setIndex("必拍");
        ViewBean txtMust = ViewBeanGenerator.getViewBean(textItemMust);
        TextItem textItemNoMust = new TextItem();
        textItemNoMust.setIndex("非必拍");
        ViewBean txtNoMust = ViewBeanGenerator.getViewBean(textItemNoMust);

        TextItem textItemNoMust1 = new TextItem();
        textItemNoMust1.setIndex("爱拍不怕");
        ViewBean txtNoMust1 = ViewBeanGenerator.getViewBean(textItemNoMust1);


        BtnGroup btnGroup_must = new BtnGroup();
        btnGroup_must.setBtnList(essentialItemList);
        ViewBean viewBean_btnGroupMust = ViewBeanGenerator.getViewBean(btnGroup_must);

        BtnGroup btnGroup_nomust = new BtnGroup();
        btnGroup_nomust.setBtnList(inessentialItemList);
        ViewBean viewBean_btnGroupNoMust = ViewBeanGenerator.getViewBean(btnGroup_nomust);

        List<ViewBean> viewBeanList = new ArrayList<>();

        viewBeanList.add(txtMust);
        viewBeanList.add(viewBean_btnGroupMust);
        viewBeanList.add(txtNoMust);
        viewBeanList.add(viewBean_btnGroupNoMust);
        viewBeanList.add(txtNoMust1);

        PageInfo pageInfo = new PageInfo();


        pageParamBean = PagerBeanGenerator.getViewBean(pageInfo, viewBeanList);
        LogUtils.e("pageParamBeanJson:" + GsonUtils.getInstance().toJson(pageParamBean));

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
