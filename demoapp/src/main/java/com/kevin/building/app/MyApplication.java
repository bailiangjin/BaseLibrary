package com.kevin.building.app;

import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.kevin.baselibrary.app.SuperApplication;

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

    }

    @Override
    protected String getAppNameFromSub() {
        return "demoApp";
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
