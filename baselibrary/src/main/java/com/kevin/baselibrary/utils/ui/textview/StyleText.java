package com.kevin.baselibrary.utils.ui.textview;

/**
 * Created by bailiangjin on 16/4/28.
 */
public class StyleText extends BaseText {

    private int style;

    public StyleText(String content, int style) {
        super(content);
        this.style = style;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
