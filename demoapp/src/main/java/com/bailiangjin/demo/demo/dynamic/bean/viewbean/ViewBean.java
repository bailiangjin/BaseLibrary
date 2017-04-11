package com.bailiangjin.demo.demo.dynamic.bean.viewbean;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.group.CBGroup;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.group.RBGroup;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.item.BtnItem;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.item.TextItem;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.type.BtnGroupType;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.type.ViewBeanType;

/**
 * 页面每一行 界面元素
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:14
 */
public class ViewBean {

    /**
     * ViewBean 类型
     */
    private int viewItemType;

    /**
     * 排序顺序 从上到下第几个条目
     */
    private int order;

    private TextItem textItem;

    private BtnItem btnItem;

    private EditTextItem editTextItem;

    private BtnGroup btnGroup;

    private RBGroup rbGroup;

    private CBGroup cbGroup;

    public ViewBean() {

    }

    public ViewBean(BaseItem item) {

        if (item instanceof TextItem) {
            this.textItem = (TextItem) item;
            this.viewItemType = ViewBeanType.TEXT;
        } else if (item instanceof EditTextItem) {
            this.editTextItem = (EditTextItem) item;
            this.viewItemType = ViewBeanType.ET;
        } else if (item instanceof BtnItem) {
            this.btnItem = (BtnItem) item;
            this.viewItemType = ViewBeanType.BTN;
        } else if (item instanceof BtnGroup) {
            BtnGroup btnGroup = (BtnGroup) item;
            this.btnGroup = (btnGroup);
            switch (btnGroup.getBtnGroupType()) {
                case BtnGroupType.SKIP_BTN_GROUP:
                    this.viewItemType = (ViewBeanType.SKIP_BTN_GROUP);
                    break;
                case BtnGroupType.PHOTO_BTN_GROUP:
                    this.viewItemType = (ViewBeanType.PHOTO_BTN_GROUP);
                    break;
                default:
                    this.viewItemType = (ViewBeanType.SKIP_BTN_GROUP);
                    break;
            }

        } else if (item instanceof CBGroup) {
            this.cbGroup = (CBGroup) item;
            this.viewItemType = (ViewBeanType.CB_GROUP);
        } else if (item instanceof RBGroup) {
            this.rbGroup = (RBGroup) item;
            this.viewItemType = (ViewBeanType.RB_GROUP);
        }


    }

    public int getViewItemType() {
        return viewItemType;
    }

    public void setViewItemType(int viewItemType) {
        this.viewItemType = viewItemType;
    }

    public TextItem getTextItem() {
        return textItem;
    }

    public void setTextItem(TextItem textItem) {
        this.textItem = textItem;
    }

    public BtnItem getBtnItem() {
        return btnItem;
    }

    public void setBtnItem(BtnItem btnItem) {
        this.btnItem = btnItem;
    }

    public EditTextItem getEditTextItem() {
        return editTextItem;
    }

    public void setEditTextItem(EditTextItem editTextItem) {
        this.editTextItem = editTextItem;
    }

    public BtnGroup getBtnGroup() {
        return btnGroup;
    }

    public void setBtnGroup(BtnGroup btnGroup) {
        this.btnGroup = btnGroup;
    }

    public RBGroup getRbGroup() {
        return rbGroup;
    }

    public void setRbGroup(RBGroup rbGroup) {
        this.rbGroup = rbGroup;
    }

    public CBGroup getCbGroup() {
        return cbGroup;
    }

    public void setCbGroup(CBGroup cbGroup) {
        this.cbGroup = cbGroup;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
