package com.bailiangjin.building.demo.dynamic.view.base;

import android.content.Context;
import android.widget.TextView;

import com.bailiangjin.building.R;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.base.BaseItem;
import com.bailiangjin.building.demo.dynamic.bean.viewbean.item.TextItem;
import com.bailiangjin.building.demo.dynamic.view.root.BaseView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 14:05
 */
public abstract class BaseTextView extends BaseView {

    private TextView tv_index;
    private TextItem textItem;


    public BaseTextView(Context context, TextItem textItem) {
        super(context, textItem);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.ctn_textview;
    }


    /**
     * 将父类转为子类 加载初始化View之前的逻辑
     *
     * @param baseItem
     */
    @Override
    protected void initBase(BaseItem baseItem) {
        textItem = (TextItem) baseItem;
    }

    @Override
    protected void initView() {
        tv_index = (TextView) findViewById(R.id.tv_index);
//        tv_index.setGravity(Gravity.CENTER_HORIZONTAL);

//
//        int gravity = 0 != textItem.getGravity() && -1 != textItem.getGravity() ? textItem.getGravity() : getGravity();
//        tv_index.setGravity(gravity);
//
//        int textSize = (0 != textItem.getIndexTextSize() && -1 != textItem.getIndexTextSize()) ? textItem.getIndexTextSize() : getTextSize();
//        tv_index.setTextSize(textSize);

        tv_index.setGravity(getGravity());

        tv_index.setTextSize(getTextSize());

        tv_index.setText(textItem.getIndexText());


    }

    @Override
    protected void initLogic() {


    }

    /**
     * 获取默认 重力方向
     *
     * @return
     */
    protected abstract int getGravity();

    /**
     * 获取默认文字大小
     *
     * @return
     */
    protected abstract int getTextSize();


}
