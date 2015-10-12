package com.kevin.baselibrary.constant;

public enum ProviderTypeEnum {
    UNKNOWN("UNKNOWN"),//未知
    CHINA_MOBILE("CHINA_MOBILE"),//中国移动
    CHINA_UNICOM("CHINA_UNICOM"),//中国联通
    CHINA_NET("CHINA_NET");//中国电信

    private String value;

    private ProviderTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}