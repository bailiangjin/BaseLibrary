package com.bailiangjin.demo;

import android.util.Log;

import com.bailiangjin.uilibrary.app.SuperApplication;
import com.bailiangjin.utilslibrary.api.UtilsLibrary;
import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.tencent.smtt.sdk.QbSdk;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/10/12 17:32
 */
public class MyApplication extends SuperApplication {



    @Override
    public void onCreate() {
        super.onCreate();

        initBugstags();

        //初始化 ImageLoad工具类
        // 只在Application中初始化一次 全局可使用
        UtilsLibrary.init(this);

        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);



    }

    /**
     * 初始化Bugstags
     */
    private void initBugstags() {
        final String BUGTAGS_APP_KEY = "2ee6086adc2bc223e122e1abd3edb16a";
        BugtagsOptions options = new BugtagsOptions.Builder().
                trackingLocation(false).//是否获取位置
                trackingCrashLog(true).//是否收集crash
                trackingConsoleLog(true).//是否收集console log
                trackingUserSteps(true).//是否收集用户操作步骤
                build();

        //BTGInvocationEventBubble(悬浮小球)
        //BTGInvocationEventShake(摇一摇)
        //BTGInvocationEventNone(静默)
        Bugtags.start(BUGTAGS_APP_KEY, this, Bugtags.BTGInvocationEventNone, options);


    }

    @Override
    protected void onAppExit() {

    }
}
