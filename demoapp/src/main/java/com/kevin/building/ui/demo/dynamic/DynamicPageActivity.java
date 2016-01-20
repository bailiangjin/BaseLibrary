package com.kevin.building.ui.demo.dynamic;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.kevin.baselibrary.utils.GsonUtils;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.bean.PageInfo;
import com.kevin.building.ui.demo.dynamic.bean.PageParamBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.constants.ItemType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.constants.TxtType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.PhotoBtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.TextItem;
import com.kevin.building.ui.demo.dynamic.generater.DynamicViewGenerator;
import com.kevin.building.ui.demo.dynamic.generater.PagerBeanGenerator;
import com.kevin.building.ui.demo.dynamic.generater.ViewBeanGenerator;

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
//        ScrollView scrollView = (ScrollView) layoutInflater.inflate(R.layout.ctn_scrollview, null);
//        setContentView(scrollView);
//        LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.ll_container);

        LinearLayout mLinearLayout = (LinearLayout) layoutInflater.inflate(R.layout.ctn_ll, null);
        setContentView(mLinearLayout);


        initData();

        String jsonData = GsonUtils.getInstance().toJson(pageParamBean);

        long startTime = System.currentTimeMillis();
        PageParamBean pageParamBeanNew = GsonUtils.getInstance().toObj(jsonData, PageParamBean.class);
//        Type type = new TypeToken<ArrayList<ViewBean>>() {
//        }.getType();

//       Gson gson =  GsonUtils.getInstance().getGson();
//
//        List<ViewBean> list = gson.fromJson(jsonData, type);


        List<ViewBean> viewBeanList = pageParamBeanNew.getViewBeanList();
        for (ViewBean viewBean : viewBeanList) {
            View view = DynamicViewGenerator.getView(DynamicPageActivity.this, viewBean);
//            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//            view.setLayoutParams(layoutParams);
            mLinearLayout.addView(view);
        }

        long endTime = System.currentTimeMillis();

        long gapTime = endTime - startTime;

        LogUtils.e("gaptime:" + gapTime);

        ToastUtils.show("页面加载耗时：" + gapTime+"毫秒");

    }


    private void initData() {

        List<BtnItem> essentialItemList = new ArrayList<>();
        List<BtnItem> inessentialItemList = new ArrayList<>();
        List<BtnItem> photoItemList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            BtnItem btnItem = new BtnItem();
            btnItem.setViewType(ItemType.BTN);
            btnItem.setBtnType(ItemType.BTN);
            btnItem.setIndex("必拍" + (i + 1));
            essentialItemList.add(btnItem);
        }


        for (int i = 0; i < 2; i++) {
            BtnItem essentialItem = new BtnItem();
            essentialItem.setViewType(ItemType.BTN);
            essentialItem.setIndex("非必拍" + (i + 1));
            inessentialItemList.add(essentialItem);
        }

        for (int i = 0; i < 2; i++) {
            BtnItem essentialItem = new BtnItem();
            essentialItem.setViewType(ItemType.BTN);
            essentialItem.setIndex("拍照" + (i + 1));
            photoItemList.add(essentialItem);
        }

        TextItem textTitle = new TextItem();
        textTitle.setIndex("拍小区");
        textTitle.setTxtType(TxtType.TITLE);
        ViewBean txtTitle = ViewBeanGenerator.getViewBean(textTitle);

        TextItem textItemMust = new TextItem();
        textItemMust.setIndex("必拍");
        textItemMust.setTxtType(TxtType.CLASS_NAME);
        ViewBean txtMust = ViewBeanGenerator.getViewBean(textItemMust);

        TextItem textItemNoMust = new TextItem();
        textItemNoMust.setIndex("非必拍");
        textItemNoMust.setTxtType(TxtType.CLASS_NAME);
        ViewBean txtNoMust = ViewBeanGenerator.getViewBean(textItemNoMust);

        TextItem textItemNoMust1 = new TextItem();
        textItemNoMust1.setIndex("爱拍不拍爱拍不拍爱拍不拍爱拍不拍爱拍不拍爱拍不拍");
        textItemNoMust1.setTxtType(TxtType.CONTENT);
//        textItemNoMust1.setGravity(Gravity.RIGHT);
        textItemNoMust1.setTextSize(12);


        ViewBean txtNoMust1 = ViewBeanGenerator.getViewBean(textItemNoMust1);


        BtnGroup btnGroup_must = new BtnGroup();
        btnGroup_must.setBtnList(essentialItemList);
        ViewBean viewBean_btnGroupMust = ViewBeanGenerator.getViewBean(btnGroup_must);

        BtnGroup btnGroup_nomust = new BtnGroup();
        btnGroup_nomust.setBtnList(inessentialItemList);
        ViewBean viewBean_btnGroupNoMust = ViewBeanGenerator.getViewBean(btnGroup_nomust);


        PhotoBtnGroup photoBtnGroup = new PhotoBtnGroup();
        photoBtnGroup.setViewType(ItemType.PHOTO_BTN_GROUP);
        photoBtnGroup.setBtnList(photoItemList);
        ViewBean viewBean_photoBtnGroup = ViewBeanGenerator.getViewBean(photoBtnGroup);


        EditTextItem et1 = new EditTextItem();
        et1.setViewType(ItemType.ET);
        et1.setIndex("楼栋数");
        et1.setHint("请输入楼栋数");
        ViewBean viewBean_et = ViewBeanGenerator.getViewBean(et1);

        BtnItem btn1 = new BtnItem();
        btn1.setViewType(ItemType.BTN);
        btn1.setIndex("保存");
        ViewBean viewBean_btn1 = ViewBeanGenerator.getViewBean(btn1);


        List<ViewBean> viewBeanList = new ArrayList<>();

        viewBeanList.add(txtTitle);
        viewBeanList.add(txtMust);
        viewBeanList.add(viewBean_btnGroupMust);
        viewBeanList.add(txtNoMust);
        viewBeanList.add(viewBean_btnGroupNoMust);
        viewBeanList.add(txtNoMust1);
        viewBeanList.add(viewBean_photoBtnGroup);
        viewBeanList.add(viewBean_et);
        viewBeanList.add(viewBean_btn1);

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
