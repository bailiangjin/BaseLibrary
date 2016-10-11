package com.bailiangjin.simpleim;

import com.avos.avoscloud.AVOSCloud;
import com.bailiangjin.simpleim.engine.logicutils.AccountUtils;
import com.bailiangjin.simpleim.sdk.leancloud.CustomUserProvider;
import com.bailiangjin.simpleim.sdk.leancloud.LCConfig;
import com.bailiangjin.simpleim.utils.ImageLoadUtils;
import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.kevin.baselibrary.app.SuperApplication;

import cn.leancloud.chatkit.LCChatKit;

/**
 * Created by bailiangjin on 16/8/2.
 */
public class IMApplication extends SuperApplication {




    @Override
    public void onCreate() {
        super.onCreate();
        initBugstags();
        //初始化 ImageLoad工具类
        // 只在Application中初始化一次 全局可使用
        ImageLoadUtils.INSTANCE.init(this);
        LCChatKit.getInstance().setProfileProvider(CustomUserProvider.getInstance());
        AVOSCloud.setDebugLogEnabled(true);
        LCChatKit.getInstance().init(getApplicationContext(), LCConfig.TEST_IM_APP_ID, LCConfig.TEST_IM_APP_KEY);
    }

    @Override
    protected String getAppNameFromSub() {
        return "simpleim";
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
