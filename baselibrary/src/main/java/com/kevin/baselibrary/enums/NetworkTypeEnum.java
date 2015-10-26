package com.kevin.baselibrary.enums;

public enum NetworkTypeEnum {
    UNKNOWN("UNKNOWN"),
    TYPE_WIFI("WIFI"),
    TYPE_2G("2G"),
    TYPE_3G("3G"),
    TYPE_4G("4G");

    private String value;

    private NetworkTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}