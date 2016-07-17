package com.bailiangjin.imageload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * @author bailiangjin
 */
public class MainActivity extends AppCompatActivity {

    ImageView iv_org;
    ImageView iv_round;
    ImageView iv_rounded_rectangle;

    static String picUrl="https://raw.githubusercontent.com/bailiangjin/bailiangjin.github.io/master/dev/download/picture/HeadPortrait.jpeg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_org = (ImageView) findViewById(R.id.iv_org);
        iv_round = (ImageView) findViewById(R.id.iv_round);
        iv_rounded_rectangle = (ImageView) findViewById(R.id.iv_rounded_rectangle);

        //普通加载效果
        ImageLoadUtils.INSTANCE.loadImageView(iv_org,picUrl);
        //圆形图片加载效果
        ImageLoadUtils.INSTANCE.loadCircleImageView(iv_round,picUrl);
        //圆角加载效果
        ImageLoadUtils.INSTANCE.loadRoundedImageView(iv_rounded_rectangle,picUrl);
    }
}
