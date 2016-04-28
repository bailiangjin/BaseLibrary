package com.kevin.baselibrary.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.kevin.baselibrary.model.art.ColorText;

/**
 * Created by bailiangjin on 16/4/28.
 */
public class TVUtils {

    /**
     * 给文字设置多种颜色
     * @param textView
     * @param args
     */
    public static void setContentWithColor(TextView textView, ColorText... args) {

        String allContent="";
        StringBuffer sb = new StringBuffer();
        for (ColorText colorText : args) {
            if (colorText.getLength()>0){
                sb= sb.append(colorText.getContent());
            }
        }
        allContent=sb.toString();
        if (TextUtils.isEmpty(allContent)){
            return;
        }

        SpannableStringBuilder builder = new SpannableStringBuilder(allContent);
        int startPosition = 0;
        int endPosition = 0;
        for (ColorText colorText : args) {
            if (colorText.getLength() > 0) {
                ForegroundColorSpan span = new ForegroundColorSpan(colorText.getColor());
                endPosition = startPosition + colorText.getLength();
                builder.setSpan(span, startPosition, endPosition, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                startPosition = endPosition;
            }
        }
        textView.setText(builder);
    }



}


