package com.kevin.baselibrary.interfaze.listener;

/**
 * Created by bailiangjin on 16/7/29.
 */
public abstract class CommonTitleListener implements TitleViewListener {

    @Override
    public boolean onLeftBtnClick() {
        return false;
    }

    @Override
    public boolean onRightBtnClick() {
        return false;
    }

    @Override
    public boolean onLeftImgClick() {
        return false;
    }


    @Override
    public boolean onRightImg2Click() {
        return false;
    }

}
