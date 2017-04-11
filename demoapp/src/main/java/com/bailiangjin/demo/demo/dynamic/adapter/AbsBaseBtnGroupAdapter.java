package com.bailiangjin.demo.demo.dynamic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bailiangjin.demo.demo.dynamic.bean.viewbean.item.BtnItem;

import java.util.List;

/**
 * 抽象类
 * 按钮列表Adapter基类
 * 子类只需设置引用的 条目layoutResId 和文本TextView ResId 即可 如没有文本条目 子类 getItemTvResId 请返回-1
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/28 16:09
 */
public abstract class AbsBaseBtnGroupAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private int itemLayoutResId;
    private int itemTvResId;

    private List<BtnItem> list;


    public AbsBaseBtnGroupAdapter(Context context, List<BtnItem> list) {
        this.list = list;
        this.itemLayoutResId = getItemLayoutResId();
        this.itemTvResId = getItemTvResId();
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return null == list ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return null == list && !list.isEmpty() ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(itemLayoutResId, null);

        //找到条目的文本字段 给该TV设置文本内容 如没有文本条目 子类 getItemTvResId 请返回-1
        if (0 != itemTvResId && -1 != itemTvResId) {
            TextView mTextView = (TextView) convertView.findViewById(itemTvResId);
            mTextView.setText((CharSequence) list.get(position).getIndexText());
        }

        return convertView;
    }

    /**
     * 获取条目layoutid
     *
     * @return
     */
    protected abstract int getItemLayoutResId();

    /**
     * 获取条目 文本id 如没有文本条目 子类 getItemTvResId 请返回-1
     *
     * @return
     */
    protected abstract int getItemTvResId();
}
