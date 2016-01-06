package com.kevin.building.ui.demo.dynamic.enumtype;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 14:25
 */
public enum ItemType {
    BUTTON("BUTTON"),
    RADIO_BUTTON("RADIO_BUTTON"),
    CHECKBOX("CHECKBOX"),
    GRIDVIEW("GRIDVIEW"),
    BUTTONGROUP("BUTTONGROUP"),
    EDITTEXT("EDITTEXT"),
    RADIOGROUP("RADIOGROUP"),
    CHECKBOXGROUP("CHECKBOXGROUP"),
    TEXTVIEW("TEXTVIEW");

    private String value;

    private ItemType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}