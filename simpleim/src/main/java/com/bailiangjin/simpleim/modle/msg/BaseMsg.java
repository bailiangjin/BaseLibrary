package com.bailiangjin.simpleim.modle.msg;

/**
 * Created by bailiangjin on 16/8/4.
 */
public class BaseMsg {

    public static final int TEXT_MSG=1;
    public static final int IMAGE_MSG=2;
    public static final int AUDIO_MSG=3;
    public static final int FILE_MSG=4;

    private String id;
    private int type;

}
