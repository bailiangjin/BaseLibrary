package com.kevin.baselibrary.utils.ui.textview;

import android.text.TextUtils;

/**
 * Created by bailiangjin on 16/4/28.
 */
public class BaseText {

    private String content;
    private int length;

    public BaseText(String content) {
        this.content = content;
        setLength(content);
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        setLength(content);
    }

    private void setLength(String content) {
        if (!TextUtils.isEmpty(content)){
            this.length=content.length();
        }
    }

    public int getLength() {
        return length;
    }

}
