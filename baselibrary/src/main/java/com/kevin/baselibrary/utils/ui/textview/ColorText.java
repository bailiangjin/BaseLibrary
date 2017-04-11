package com.kevin.baselibrary.utils.ui.textview;

/**
 * Created by bailiangjin on 16/4/28.
 */
public class ColorText extends BaseText{

    private int color;

    public ColorText(String content, int color) {
        super(content);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
