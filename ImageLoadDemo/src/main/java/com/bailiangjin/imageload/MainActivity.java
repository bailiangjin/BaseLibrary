package com.bailiangjin.imageload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_round;
    ImageView iv_rounded_rectangle;

    static String picUrl="https://raw.githubusercontent.com/bailiangjin/bailiangjin.github.io/master/dev/download/picture/HeadPortrait.jpeg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_round = (ImageView) findViewById(R.id.iv_round);
        iv_rounded_rectangle = (ImageView) findViewById(R.id.iv_rounded_rectangle);


        ImageLoadUtils.loadCircleImageView(iv_round,picUrl);

        ImageLoadUtils.loadRoundedImageView(iv_rounded_rectangle,picUrl);


    }
}
