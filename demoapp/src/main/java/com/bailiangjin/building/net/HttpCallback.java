package com.bailiangjin.building.net;

public interface HttpCallback {
    /**
     * 请求成功
     *
     * @param json 返回参数
     */
    void onSuccess(final String json);

    /**
     * 请求失败
     *
     * @param json 返回参数
     */
    void onFailed(final String json);

    /**
     * 请求异常
     *
     * @param json 返回参数
     */
    void onError(final String json);
}
