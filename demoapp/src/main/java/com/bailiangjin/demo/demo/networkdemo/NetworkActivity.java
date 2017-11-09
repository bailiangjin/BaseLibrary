package com.bailiangjin.demo.demo.networkdemo;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.bailiangjin.javabaselib.utils.GsonUtils;
import com.bailiangjin.demo.net.HttpCallback;
import com.bailiangjin.demo.net.OKHttpUtils;
import com.bailiangjin.utilslibrary.utils.LogUtils;
import com.bailiangjin.demo.R;
import com.bailiangjin.demo.base.BaseActivity;
import com.bailiangjin.demo.demo.networkdemo.weather.WeatherRequest;
import com.bailiangjin.demo.demo.networkdemo.weather.model.WeatherSK;

import java.util.HashMap;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/10 10:53
 */
public class NetworkActivity extends BaseActivity implements View.OnClickListener{

    protected Button btn1;
    protected Button btn2;
    protected Button btn3;
    protected Button btn4;
    protected Button btn5;
    protected Button btn6;
    protected Button btn7;
    protected Button btn8;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_network;
    }

    @Override
    protected void beforeViewBind(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleBarBuilder.setTitleText("网络模块");

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);


    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        btn1.setText("获取天气信息");
        btn2.setText("测试post");

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn1:
                String cityId="101091001";
                WeatherRequest weatherRequestBean = new WeatherRequest(cityId);
                OKHttpUtils.asyncGet(weatherRequestBean.getSkUrl(), new HashMap<String, Object>(), new HttpCallback() {
                    @Override
                    public void onSuccess(final String json) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LogUtils.e("success:" + json);
                                longToast("onSucess:" + json);


                                WeatherSK weatherInfoBean =  GsonUtils.INSTANCE.toObj(json,WeatherSK.class);
                                LogUtils.e("weatherInfo:" + weatherInfoBean.getWeatherinfo().getCity());
//                                LogUtils.e("weatherInfo:" + weatherInfoBean.getWeatherinfo().toJson());
                            }
                        });
                    }

                    @Override
                    public void onFailed(final String json) {


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                longToast("onFailed:" + json);

                            }
                        });


                    }

                    @Override
                    public void onError(final String json) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                longToast("onError:" + json);

                            }
                        });


                    }
                });
                break;

            case R.id.btn2:

                OKHttpUtils.asyncPost("http://www.baidu.com", new HashMap<String, Object>(), new HttpCallback() {
                    @Override
                    public void onSuccess(final String json) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                longToast("onSucess:" + json);

                            }
                        });
                    }

                    @Override
                    public void onFailed(final String json) {


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                longToast("onFailed:" + json);

                            }
                        });


                    }

                    @Override
                    public void onError(final String json) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                longToast("onError:" + json);

                            }
                        });


                    }
                });

                break;

            case R.id.btn3:
                break;

            case R.id.btn4:
                break;

            case R.id.btn5:
                break;

            case R.id.btn6:
                //TODO:待添加模块
                shortToast("点击了测试6");


                break;

            case R.id.btn7:


                break;

            case R.id.btn8:
                shortToast("点击了当前测试");


                break;


            default:
                break;
        }

    }



    @Override
    protected void handleMsg(Message msg) {

    }


}
