package com.kevin.building.ui.demo.dynamic.view;

import android.content.Context;
import android.widget.TextView;

import com.kevin.building.R;
import com.kevin.building.ui.demo.dynamic.view.base.BaseView;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/29 14:05
 */
public class BaseTextView extends BaseView {

    private TextView tv_index;


    public BaseTextView(Context context) {
        super(context);
    }

    public BaseTextView(Context context,String content) {
        super(context);
        setTvContent(content);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.ctn_textview;
    }

    @Override
    protected void initView() {
        tv_index= (TextView) findViewById(R.id.tv_index);
//        tv_index.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    @Override
    protected void initLogic() {

    }

    public void setTvContent(String content){
        tv_index.setText(content);
    }
}
