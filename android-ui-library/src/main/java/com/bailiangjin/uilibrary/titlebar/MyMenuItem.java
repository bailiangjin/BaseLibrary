package com.bailiangjin.uilibrary.titlebar;


/**
 * Created by bailiangjin on 16/9/7.
 */
public class MyMenuItem {

    private int id;
    private String title;
    private int iconResId;
    private Type type;
    private ItemClickListener itemClickListener;




    public MyMenuItem(String title, int iconResId, Type type, ItemClickListener itemClickListener) {
        this.title = title;
        this.iconResId = iconResId;
        this.type = type;
        this.itemClickListener =itemClickListener;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public enum Type {
        SEARCH,
        SHARE,
        OTHER;
    }
}
