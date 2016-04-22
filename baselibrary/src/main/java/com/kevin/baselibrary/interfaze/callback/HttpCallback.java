package com.kevin.baselibrary.interfaze.callback;

public interface HttpCallback {
    /**
     * 请求成功
     * 
     * @param json
     *            返回参数
     */
    public void onSuccess(final String json);

    /**
     * 请求失败
     * 
     * @param json
     *            返回参数
     */
    public void onFailed(final String json);

    /**
     * 请求异常
     * 
     * @param json
     *            返回参数
     */
    public void onError(final String json);
}
