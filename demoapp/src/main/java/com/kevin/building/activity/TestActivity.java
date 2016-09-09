package com.kevin.building.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import com.kevin.baselibrary.model.art.text.ColorText;
import com.kevin.baselibrary.model.art.text.StyleText;
import com.kevin.baselibrary.utils.TVUtils;
import com.kevin.building.R;
import com.kevin.building.base.BaseActivity2;

/**
 * Created by bailiangjin on 16/4/28.
 */
public class TestActivity extends BaseActivity2 {

    private TextView tv_content;
    private TextView tv_style_content;
    private Button btn_test;


    public static void start(Activity activity){
        Intent intent= new Intent(activity,TestActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initIntentData() {

    }

    @Override
    protected void initView() {

        tv_content= (TextView) findViewById(R.id.tv_content);
        tv_style_content= (TextView) findViewById(R.id.tv_style_content);
        ColorText[] texts = {new ColorText("ceshi", Color.RED),new ColorText("ceshi", Color.GREEN)};
        TVUtils.setContentWithColor(tv_content,texts);

        StyleText[] textsStyle = {new StyleText("样式", R.style.green_tv_style),new StyleText("测试", R.style.red_tv_style)};
        TVUtils.setContentWithStyle(tv_style_content,textsStyle);

        btn_test= (Button) findViewById(R.id.btn_test);
        btn_test.setText("测试Style");

    }

    @Override
    protected void initData() {

    }




}
