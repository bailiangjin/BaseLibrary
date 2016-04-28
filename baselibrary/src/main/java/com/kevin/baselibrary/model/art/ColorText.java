package com.kevin.baselibrary.model.art;

import android.text.TextUtils;

/**
 * Created by bailiangjin on 16/4/28.
 */
public class ColorText {



    private String content;
    private int length;
    private int color;

    public ColorText(String content, int color) {

        this.content = content;
        this.color = color;
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
