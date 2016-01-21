package com.kevin.building.ui.demo.dynamic.bean.viewbean;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.BtnGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.CBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.group.RBGroup;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.EditTextItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.TextItem;
import com.kevin.building.ui.demo.dynamic.bean.viewbean.item.BtnItem;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:14
 */
public class ViewBean {

    /**
     *  ViewBean 类型
     */
    private int viewBeanType;

    private TextItem textItem;

    private BtnItem btnItem;

    private EditTextItem editTextItem;

    private BtnGroup btnGroup;

    private RBGroup rbGroup;

    private CBGroup cbGroup;

    public int getViewBeanType() {
        return viewBeanType;
    }

    public void setViewBeanType(int viewBeanType) {
        this.viewBeanType = viewBeanType;
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
}
