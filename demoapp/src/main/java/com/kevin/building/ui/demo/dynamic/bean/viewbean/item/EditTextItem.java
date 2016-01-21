package com.kevin.building.ui.demo.dynamic.bean.viewbean.item;

import com.kevin.building.ui.demo.dynamic.bean.viewbean.base.BaseItem;
import com.kevin.building.ui.demo.dynamic.bean.constants.ViewType;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:00
 */
public class EditTextItem extends BaseItem {
    private String content;
    private String hint;

    /**
     * 输入框文字大小 sp
     */
    private  int contentTextSize;


    @Override
    public void setDefaultViewType() {
        setViewType(ViewType.ET);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getContentTextSize() {
        return contentTextSize;
    }

    public void setContentTextSize(int contentTextSize) {
        this.contentTextSize = contentTextSize;
    }
}
