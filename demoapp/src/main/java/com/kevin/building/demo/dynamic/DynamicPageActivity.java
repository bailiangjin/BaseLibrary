package com.kevin.building.demo.dynamic;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.kevin.baselibrary.utils.FilePathUtil;
import com.kevin.baselibrary.utils.FileUtils;
import com.kevin.baselibrary.utils.GsonUtils;
import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.baselibrary.utils.ToastUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.demo.dynamic.bean.databean.ClassDataBean;
import com.kevin.building.demo.dynamic.bean.databean.PageDataBean;
import com.kevin.building.demo.dynamic.bean.databean.PageInfo;
import com.kevin.building.demo.dynamic.bean.databean.ProjectDataBean;
import com.kevin.building.demo.dynamic.bean.viewbean.ViewBean;
import com.kevin.building.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.group.RBGroup;
import com.kevin.building.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.CBItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.RBItem;
import com.kevin.building.demo.dynamic.bean.viewbean.item.TextItem;
import com.kevin.building.demo.dynamic.bean.viewbean.type.BtnGroupType;
import com.kevin.building.demo.dynamic.bean.viewbean.type.BtnType;
import com.kevin.building.demo.dynamic.bean.viewbean.type.TxtType;
import com.kevin.building.demo.dynamic.generater.ViewGeneratorImpl;

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


    private PageDataBean pageParamBean;


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
        PageDataBean pageParamBeanNew = GsonUtils.getInstance().toObj(jsonData, PageDataBean.class);
//        Type type = new TypeToken<ArrayList<ViewBean>>() {
//        }.getType();

//       Gson gson =  GsonUtils.getInstance().getGson();
//
//        List<ViewBean> list = gson.fromJson(jsonData, type);


        List<ViewBean> viewBeanList = pageParamBeanNew.getViewBeanList();
        for (ViewBean viewBean : viewBeanList) {
            View view = new ViewGeneratorImpl(DynamicPageActivity.this, viewBean).getView();
//            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
//            view.setLayoutParams(layoutParams);
            if (null != view) {
                mLinearLayout.addView(view);
            }

        }

        long endTime = System.currentTimeMillis();

        long gapTime = endTime - startTime;


        ToastUtils.show("页面加载耗时：" + gapTime + "毫秒");

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
            btnItem.setSkipId("skipId" + (i + 1));
            essentialItemList.add(btnItem);
        }


        for (int i = 0; i < 2; i++) {
            BtnItem essentialItem = new BtnItem();
            essentialItem.setBtnType(BtnType.SKIP);
            essentialItem.setIndexText("非必拍" + (i + 1));
            essentialItem.setSkipId("skipId" + (i + 1));
            inessentialItemList.add(essentialItem);
        }

        for (int i = 0; i < 2; i++) {
            BtnItem essentialItem = new BtnItem();
            essentialItem.setBtnType(BtnType.PHOTO);
            essentialItem.setIndexText("拍照" + (i + 1));
            essentialItem.setLocateSuccessMsg("定位成功");
            essentialItem.setLocateFailMsg("定位失败");
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
        ViewBean txtTitle = new ViewBean(textTitle);

        TextItem textItemMust = new TextItem();
        textItemMust.setIndexText("必拍");
        textItemMust.setTxtType(TxtType.CLASS_NAME);
        ViewBean txtMust = new ViewBean(textItemMust);

        TextItem textItemNoMust = new TextItem();
        textItemNoMust.setIndexText("非必拍");
        textItemNoMust.setTxtType(TxtType.CLASS_NAME);
        ViewBean txtNoMust = new ViewBean(textItemNoMust);

        TextItem textNotice = new TextItem();
        textNotice.setIndexText("拍摄注意事项");
        textNotice.setTxtType(TxtType.CONTENT);
//        textItemNoMust1.setGravity(Gravity.RIGHT);
        textNotice.setIndexTextSize(12);


        ViewBean viewBean_NoticeTxt = new ViewBean(textNotice);


        BtnGroup btnGroup_must = new BtnGroup();
        btnGroup_must.setIndexText("必拍列表");
        btnGroup_must.setBtnGroupType(BtnGroupType.SKIP_BTN_GROUP);
        btnGroup_must.setBtnList(essentialItemList);
        ViewBean viewBean_btnGroupMust = new ViewBean(btnGroup_must);

        BtnGroup btnGroup_nomust = new BtnGroup();
        btnGroup_nomust.setIndexText("非必拍列表");
        btnGroup_nomust.setBtnGroupType(BtnGroupType.SKIP_BTN_GROUP);
        btnGroup_nomust.setBtnList(inessentialItemList);
        ViewBean viewBean_btnGroupNoMust = new ViewBean(btnGroup_nomust);


        BtnGroup photoBtnGroup = new BtnGroup();
        photoBtnGroup.setIndexText("拍照按钮列表");
        photoBtnGroup.setBtnGroupType(BtnGroupType.PHOTO_BTN_GROUP);
        photoBtnGroup.setBtnList(photoItemList);
        ViewBean viewBean_photoBtnGroup = new ViewBean(photoBtnGroup);

        CBGroup cbGroup = new CBGroup();
        cbGroup.setIndexText("多选框列表");
        cbGroup.setCbList(cbItemList);
        ViewBean viewBean_cbGroup = new ViewBean(cbGroup);

        RBGroup rbGroup = new RBGroup();
        rbGroup.setIndexText("单选框列表");
        rbGroup.setRbList(rbItemList);
        ViewBean viewBean_rbGroup = new ViewBean(rbGroup);


        EditTextItem et1 = new EditTextItem();
        et1.setIndexText("楼栋数");
        et1.setHint("请输入楼栋数");
        et1.setName("loudongshu");
        ViewBean viewBean_et = new ViewBean(et1);

        BtnItem btn_save = new BtnItem();
        btn_save.setIndexText("保存");
        ViewBean viewBean_btn_save = new ViewBean(btn_save);


        List<ViewBean> viewBeanList = new ArrayList<>();

        txtTitle.setOrder(1);
        viewBeanList.add(txtTitle);
        txtMust.setOrder(2);
        viewBeanList.add(txtMust);
        viewBean_btnGroupMust.setOrder(3);
        viewBeanList.add(viewBean_btnGroupMust);
        txtNoMust.setOrder(4);
//        viewBeanList.add(txtNoMust);
//        viewBean_btnGroupNoMust.setOrder(5);
//        viewBeanList.add(viewBean_btnGroupNoMust);
        viewBean_cbGroup.setOrder(6);
        viewBeanList.add(viewBean_cbGroup);
        viewBean_rbGroup.setOrder(7);
        viewBeanList.add(viewBean_rbGroup);
        viewBean_NoticeTxt.setOrder(8);
        viewBeanList.add(viewBean_NoticeTxt);
        viewBean_photoBtnGroup.setOrder(9);
        viewBeanList.add(viewBean_photoBtnGroup);
        viewBean_et.setOrder(10);
        viewBeanList.add(viewBean_et);
        viewBean_btn_save.setOrder(11);
        viewBeanList.add(viewBean_btn_save);


        PageInfo pageInfo = new PageInfo();
        pageInfo.setBaseId("baseId");
        pageInfo.setBasePackageId("BasePackageId");
        pageInfo.setBasePackageName("BasePackageName");
        pageInfo.setCollectClassId("CollectClassId");
        pageInfo.setCollectClassParentId("CollectClassParentId");
        pageInfo.setDataName("采集小区111");
        pageInfo.setTitle("页面标题：采集小区111");
        pageInfo.setDeviceInfo("DeviceInfo");
        pageInfo.setEntranceStatus("1");
        pageInfo.setUserName("user001");
        pageInfo.setOwnerId("3");
        pageInfo.setTaskId("TaskId");
        pageInfo.setMaxCount(1);
        pageInfo.setVersionNo("1111");


        pageParamBean = new PageDataBean(pageInfo, viewBeanList);
        PageDataBean pageParamBean2 = new PageDataBean(pageInfo, viewBeanList);
        String json = GsonUtils.getInstance().toJson(pageParamBean);
        LogUtils.e("pageParamBeanJson:" + json);

        FileUtils.saveStringToFile(FilePathUtil.getSdcardPath() + File.separator + "json.txt", json, false);

        ProjectDataBean projectDataBean = new ProjectDataBean();
        projectDataBean.setVersionNo("123");
        projectDataBean.setId("projectId");

        List<ClassDataBean> classDataBeanList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            ClassDataBean classDataBean = new ClassDataBean();
            classDataBean.setName("采集大类" + i);
            classDataBean.setId("collectClassId" + i);
            List<PageDataBean> pageParamBeanList = new ArrayList<>();
            pageParamBeanList.add(pageParamBean);
            pageParamBeanList.add(pageParamBean2);
            classDataBean.setPageDataBeanList(pageParamBeanList);
            classDataBeanList.add(classDataBean);
        }

        projectDataBean.setClassDataBeanList(classDataBeanList);

        String jsonPro = GsonUtils.getInstance().toJson(projectDataBean);

        FileUtils.saveStringToFile(FilePathUtil.getSdcardPath() + File.separator + "json_pro.txt", jsonPro, false);
        LogUtils.e("pageParamBeanJson:" + jsonPro);


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
