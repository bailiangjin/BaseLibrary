package com.bailiangjin.simpleim.modle.msg;

/**
 * Created by bailiangjin on 16/8/4.
 */
public class ImageMsg extends BaseMsg{

    private String imagFilePath;
    private String imgUrl;

    public String getImagFilePath() {
        return imagFilePath;
    }

    public void setImagFilePath(String imagFilePath) {
        this.imagFilePath = imagFilePath;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
