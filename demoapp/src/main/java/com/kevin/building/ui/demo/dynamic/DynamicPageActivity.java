package com.kevin.building.ui.demo.dynamic;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.kevin.baselibrary.utils.FilePathUtil;
import com.kevin.baselibrary.utils.FileUtils;
import com.kevin.baselibrary.utils.GsonUtils;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.bean.PageInfo;
import com.kevin.building.ui.demo.dynamic.bean.PageParamBean;
import com.kevin.building.ui.demo.dynamic.bean.constants.BtnGroupType;
import com.kevin.building.ui.demo.dynamic.bean.constants.BtnType;
import com.kevin.building.ui.demo.dynamic.bean.constants.TxtType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.RBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.CBItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.RBItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.TextItem;
import com.kevin.building.ui.demo.dynamic.generater.DynamicViewGenerator;
import com.kevin.building.ui.demo.dynamic.generater.PagerBeanGenerator;
import com.kevin.building.ui.demo.dynamic.generater.ViewBeanGenerator;

import java.io.File;
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
//        Type type = new TypeToken<ArrayList<ViewItem>>() {
//        }.getType();

//       Gson gson =  GsonUtils.getInstance().getGson();
//
//        List<ViewItem> list = gson.fromJson(jsonData, type);


        List<ViewItem> viewBeanList = pageParamBeanNew.getViewItemList();
        for (ViewItem viewBean : viewBeanList) {
            View view = DynamicViewGenerator.getView(DynamicPageActivity.this, viewBean);
//            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//            view.setLayoutParams(layoutParams);
            if (null!=view){
                mLinearLayout.addView(view);
            }

        }

        long endTime = System.currentTimeMillis();

        long gapTime = endTime - startTime;


        ToastUtils.show("页面加载耗时：" + gapTime+"毫秒");

    }


    private void initData() {

        List<BtnItem> essentialItemList = new ArrayList<>();
        List<BtnItem> inessentialItemList = new ArrayList<>();
        List<BtnItem> photoItemList = new ArrayList<>();
        List<CBItem> cbItemList = new ArrayList<>();
        List<RBItem> rbItemList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            BtnItem btnItem = new BtnItem();
            btnItem.setBtnType(BtnType.SKIP);
            btnItem.setIndexText("必拍" + (i + 1));
            essentialItemList.add(btnItem);
        }


        for (int i = 0; i < 2; i++) {
            BtnItem essentialItem = new BtnItem();
            essentialItem.setBtnType(BtnType.SKIP);
            essentialItem.setIndexText("非必拍" + (i + 1));
            inessentialItemList.add(essentialItem);
        }

        for (int i = 0; i < 2; i++) {
            BtnItem essentialItem = new BtnItem();
            essentialItem.setBtnType(BtnType.PHOTO);
            essentialItem.setIndexText("拍照" + (i + 1));
            photoItemList.add(essentialItem);
        }

        for (int i = 0; i < 2; i++) {
            CBItem essentialItem = new CBItem();
            essentialItem.setIndexText("多选框" + (i + 1));
            cbItemList.add(essentialItem);
        }

        for (int i = 0; i < 2; i++) {
            RBItem essentialItem = new RBItem();
            essentialItem.setIndexText("RadioButoon" + (i + 1));
            rbItemList.add(essentialItem);
        }

        TextItem textTitle = new TextItem();
        textTitle.setIndexText("拍小区");
        textTitle.setTxtType(TxtType.TITLE);
        ViewItem txtTitle = ViewBeanGenerator.getViewBean(textTitle);

        TextItem textItemMust = new TextItem();
        textItemMust.setIndexText("必拍");
        textItemMust.setTxtType(TxtType.CLASS_NAME);
        ViewItem txtMust = ViewBeanGenerator.getViewBean(textItemMust);

        TextItem textItemNoMust = new TextItem();
        textItemNoMust.setIndexText("非必拍");
        textItemNoMust.setTxtType(TxtType.CLASS_NAME);
        ViewItem txtNoMust = ViewBeanGenerator.getViewBean(textItemNoMust);

        TextItem textItemNoMust1 = new TextItem();
        textItemNoMust1.setIndexText("拍摄注意事项");
        textItemNoMust1.setTxtType(TxtType.CONTENT);
//        textItemNoMust1.setGravity(Gravity.RIGHT);
        textItemNoMust1.setIndexTextSize(12);


        ViewItem txtNoMust1 = ViewBeanGenerator.getViewBean(textItemNoMust1);


        BtnGroup btnGroup_must = new BtnGroup();
        btnGroup_must.setIndexText("必拍列表");
        btnGroup_must.setBtnGroupType(BtnGroupType.SKIP_BTN_GROUP);
        btnGroup_must.setBtnList(essentialItemList);
        ViewItem viewBean_btnGroupMust = ViewBeanGenerator.getViewBean(btnGroup_must);

        BtnGroup btnGroup_nomust = new BtnGroup();
        btnGroup_nomust.setIndexText("非必拍列表");
        btnGroup_nomust.setBtnGroupType(BtnGroupType.SKIP_BTN_GROUP);
        btnGroup_nomust.setBtnList(inessentialItemList);
        ViewItem viewBean_btnGroupNoMust = ViewBeanGenerator.getViewBean(btnGroup_nomust);


        BtnGroup photoBtnGroup = new BtnGroup();
        photoBtnGroup.setIndexText("拍照按钮列表");
        photoBtnGroup.setBtnGroupType(BtnGroupType.PHOTO_BTN_GROUP);
        photoBtnGroup.setBtnList(photoItemList);
        ViewItem viewBean_photoBtnGroup = ViewBeanGenerator.getViewBean(photoBtnGroup);

        CBGroup cbGroup = new CBGroup();
        cbGroup.setIndexText("多选框列表");
        cbGroup.setCbList(cbItemList);
        ViewItem viewBean_cbGroup = ViewBeanGenerator.getViewBean(cbGroup);

        RBGroup rbGroup = new RBGroup();
        rbGroup.setIndexText("单选框列表");
        rbGroup.setRbList(rbItemList);
        ViewItem viewBean_rbGroup = ViewBeanGenerator.getViewBean(rbGroup);


        EditTextItem et1 = new EditTextItem();
        et1.setIndexText("楼栋数");
        et1.setHint("请输入楼栋数");
        ViewItem viewBean_et = ViewBeanGenerator.getViewBean(et1);

        BtnItem btn1 = new BtnItem();
        btn1.setIndexText("保存");
        ViewItem viewBean_btn1 = ViewBeanGenerator.getViewBean(btn1);


        List<ViewItem> viewBeanList = new ArrayList<>();

        txtTitle.setOrder(1);
        viewBeanList.add(txtTitle);
        txtMust.setOrder(2);
        viewBeanList.add(txtMust);
        viewBean_btnGroupMust.setOrder(3);
        viewBeanList.add(viewBean_btnGroupMust);
        txtNoMust.setOrder(4);
        viewBeanList.add(txtNoMust);
        viewBean_btnGroupNoMust.setOrder(5);
        viewBeanList.add(viewBean_btnGroupNoMust);
        viewBean_cbGroup.setOrder(6);
        viewBeanList.add(viewBean_cbGroup);
        viewBean_rbGroup.setOrder(7);
        viewBeanList.add(viewBean_rbGroup);
        txtNoMust1.setOrder(8);
        viewBeanList.add(txtNoMust1);
        viewBean_photoBtnGroup.setOrder(9);
        viewBeanList.add(viewBean_photoBtnGroup);
        viewBean_et.setOrder(10);
        viewBeanList.add(viewBean_et);
        viewBean_btn1.setOrder(11);
        viewBeanList.add(viewBean_btn1);


        PageInfo pageInfo = new PageInfo();
        pageInfo.setBaseId("baseId");
        pageInfo.setBasePackageId("BasePackageId");
        pageInfo.setBasePackageName("BasePackageName");
        pageInfo.setCollectClassId("CollectClassId");
        pageInfo.setCollectClassParentId("CollectClassParentId");
        pageInfo.setDataName("采集小区111");
        pageInfo.setDeviceInfo("DeviceInfo");
        pageInfo.setEntranceStatus("1");
        pageInfo.setUserName("user001");
        pageInfo.setOwnerId("3");
        pageInfo.setTaskId("TaskId");
        pageInfo.setMaxCount(1);



        pageParamBean = PagerBeanGenerator.getViewBean(pageInfo, viewBeanList);
        String json = GsonUtils.getInstance().toJson(pageParamBean);
        LogUtils.e("pageParamBeanJson:" + json);

        FileUtils.saveStringToFile(FilePathUtil.getSdcardPath()+ File.separator+"json.txt",json,false);


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
