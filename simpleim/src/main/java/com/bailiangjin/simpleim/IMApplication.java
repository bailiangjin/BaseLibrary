package com.bailiangjin.simpleim;

import com.bailiangjin.simpleim.engine.logicutils.AccountUtils;
import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.kevin.baselibrary.app.SuperApplication;

/**
 * Created by bailiangjin on 16/8/2.
 */
public class IMApplication extends SuperApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        initBugstags();
    }

    /**
     * 初始化Bugstags
     */
    private void initBugstags() {
        final String BUGTAGS_APP_KEY = "bb985f4a3c77f6fd675870a9d68e2828";
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
        AccountUtils.logout();
    }
}
