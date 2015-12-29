package com.kevin.building.ui.demo.dynamic.bean;

import java.util.List;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 11:50
 */
public class IndexPageDataBean {

    private String esTitle;
    private String inesTitle;

    private List<EssentialItem> essentialList;
    private List<EssentialItem> inessentialList;

    public String getEsTitle() {
        return esTitle;
    }

    public void setEsTitle(String esTitle) {
        this.esTitle = esTitle;
    }

    public String getInesTitle() {
        return inesTitle;
    }

    public void setInesTitle(String inesTitle) {
        this.inesTitle = inesTitle;
    }

    public List<EssentialItem> getEssentialList() {
        return essentialList;
    }

    public void setEssentialList(List<EssentialItem> essentialList) {
        this.essentialList = essentialList;
    }

    public List<EssentialItem> getInessentialList() {
        return inessentialList;
    }

    public void setInessentialList(List<EssentialItem> inessentialList) {
        this.inessentialList = inessentialList;
    }
}
