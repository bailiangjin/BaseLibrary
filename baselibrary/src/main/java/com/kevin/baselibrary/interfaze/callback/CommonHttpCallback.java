package com.kevin.baselibrary.interfaze.callback;

import com.kevin.baselibrary.utils.ToastUtils;

/**
 * Created by bailiangjin on 16/8/4.
 */
public abstract class CommonHttpCallback implements HttpCallback{

    @Override
    public void onFailed(String json) {
        ToastUtils.shortToast("请求数据失败："+json);
    }

    @Override
    public void onError(String json) {
        ToastUtils.shortToast("请求数据异常："+json);
    }
}
