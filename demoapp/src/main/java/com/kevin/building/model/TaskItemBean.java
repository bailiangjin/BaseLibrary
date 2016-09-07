package com.kevin.building.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.kevin.building.BR;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/20 14:08
 */
public class TaskItemBean extends BaseObservable{

    private String id;
    private String name;

    private int order;

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
        notifyPropertyChanged(BR.order);
    }
}
