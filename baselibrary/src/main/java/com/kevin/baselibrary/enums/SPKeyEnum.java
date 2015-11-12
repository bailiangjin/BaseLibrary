package com.kevin.baselibrary.enums;

public enum SPKeyEnum {
    CURRENT_VIDEO_FILE_PATH("CURRENT_VIDEO_FILE_PATH"),
    PULL_TO_REFRESH_PRIFIX("PULL_TO_REFRESH_PRIFIX"),
    APP_VERSION_CODE_KEY("APP_VERSION_CODE_KEY"),
    TEST("TEST");

    private String value;

    private SPKeyEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}