package com.kevin.building.demo.keylistener;

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;

import com.kevin.building.R;
import com.kevin.building.base.BaseActivity;

/**
 * Created by bailiangjin on 16/3/22.
 */
public class KeyListenerActivity extends BaseActivity{
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_keylistener;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void onViewClick(View v) {

    }

    @Override
    protected void handleMsg(Message msg) {

    }

    public void onClick_testListen(View v){
        shortToast("点击了测试");
    }

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event) {
        switch (keyCode) {
//            int i = getCurrentRingValue ();   //获取手机当前音量值
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                shortToast("音量-");
                break;
                
            case KeyEvent.KEYCODE_VOLUME_UP:
                shortToast("音量+");
                break;
            case KeyEvent.KEYCODE_BACK:
                shortToast("返回");
                break;
            case KeyEvent.KEYCODE_MENU:
                shortToast("菜单");
                break;
            case KeyEvent.KEYCODE_HOME:
                shortToast("Home键盘");
                //invalid...
                break;
            default:
                break;
        }
        return super.onKeyDown (keyCode, event);
    }
}
