package com.kevin.building;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kevin.building.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



    @Override
    protected void handleMsg(Message msg) {

    }

    @Override
    protected void onViewClick(View v) {

    }


}
