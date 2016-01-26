package com.kevin.building.ui.demo.dynamic.generater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.kevin.baselibrary.utils.LogUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;
import com.kevin.building.ui.demo.dynamic.adapter.BtnPhotoGroupAdapter;
import com.kevin.building.ui.demo.dynamic.adapter.BtnSkipGroupAdapter;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.ViewBean;
import com.kevin.building.ui.demo.dynamic.bean.constants.ViewBeanType;
import com.kevin.building.ui.demo.dynamic.bean.constants.TxtType;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.TextItem;
import com.kevin.building.ui.demo.dynamic.callback.ClickCallback;
import com.kevin.building.ui.demo.dynamic.view.base.AbsBaseTextView;
import com.kevin.building.ui.demo.dynamic.view.base.BaseButton;
import com.kevin.building.ui.demo.dynamic.view.base.BaseEditText;
import com.kevin.building.ui.demo.dynamic.view.textview.ClassNameTextView;
import com.kevin.building.ui.demo.dynamic.view.textview.ContentTextView;
import com.kevin.building.ui.demo.dynamic.view.textview.TitleTextView;

import java.util.List;

/**
 * ViewBean 动态解析器 用于将ViewBean解析为相应的View 并返回
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 10:39
 */
public class DynamicViewGenerator {

    /**
     * 动态解析方法  动态解析ViewBean 返回View元素
     *
     * @param context  上下文 BaseActivity
     * @param viewBean ViewBean
     * @return View
     */
    public static View getView(BaseActivity context, ViewBean viewBean) {
        int itemType = viewBean.getViewItemType();
        switch (itemType) {
            case ViewBeanType.TEXT:
                return getTitleTextView(context, viewBean.getTextItem());
            case ViewBeanType.SKIP_BTN_GROUP:
                return getBtnGroup(context, viewBean);
            case ViewBeanType.PHOTO_BTN_GROUP:
                LogUtils.e("PHOTO_BTN_GOUP");
                return getPhotoBtnGroup(context, viewBean);
            case ViewBeanType.ET:
                return getEditText(context, viewBean.getEditTextItem());

            case ViewBeanType.BTN:
                return getButton(context, viewBean.getBtnItem());
            default:
                return null;
        }


    }


    private static BaseButton getButton(Context context, BtnItem btnItem) {

        if (null == btnItem || null == context) {
            return null;
        }
        return new BaseButton(context, btnItem);
    }

    private static BaseEditText getEditText(Context context, EditTextItem editTextItem) {

        if (null == editTextItem || null == context) {
            return null;
        }
        return new BaseEditText(context, editTextItem);
    }

    private static AbsBaseTextView getTitleTextView(Context context, TextItem textItem) {

        if (null == textItem || null == context) {
            return null;
        }
        switch (textItem.getTxtType()) {
            case TxtType.TITLE:
                return new TitleTextView(context, textItem);

            case TxtType.CLASS_NAME:
                return new ClassNameTextView(context, textItem);

            case TxtType.CONTENT:
                return new ContentTextView(context, textItem);

            default:
                return null;
        }
    }


    private static GridView getGridView(Context context, final ClickCallback clickCallback) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        GridView gridView = (GridView) layoutInflater.inflate(R.layout.ctn_gridview, null);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickCallback.onClick(position);
            }
        });
        return gridView;
    }

    private static View getBtnGroup(BaseActivity baseActivity, ViewBean viewBean) {
        GridView gridView;
        List<BtnItem> btnItemList = viewBean.getBtnGroup().getBtnList();
        ClickCallback inesCallback = CallBackGenerator.getSkipCallback(baseActivity, btnItemList);
        gridView = getGridView(baseActivity, inesCallback);
        gridView.setAdapter(new BtnSkipGroupAdapter(baseActivity, btnItemList));
        return gridView;
    }

    private static View getPhotoBtnGroup(BaseActivity baseActivity, ViewBean viewBean) {
        GridView gridView;
        List<BtnItem> btnItemList = viewBean.getBtnGroup().getBtnList();
        ClickCallback inesCallback = CallBackGenerator.getSkipCallback(baseActivity, btnItemList);
        gridView = getGridView(baseActivity, inesCallback);
        gridView.setAdapter(new BtnPhotoGroupAdapter(baseActivity, btnItemList));
        return gridView;
    }
}
