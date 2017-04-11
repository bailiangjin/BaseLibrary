package com.bailiangjin.demo.demo.dynamic.bean.viewbean.item;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.demo.demo.dynamic.bean.viewbean.type.ViewType;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2016/1/6 16:00
 */
public class EditTextItem extends BaseItem {
    private String content;
    private String hint;


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


}
