package com.kevin.baselibrary.callback;

public interface HttpCallback {
    /**
     * 请求成功
     * 
     * @param json
     *            返回参数
     */
    public void onSucess(String json);

    /**
     * 请求失败
     * 
     * @param json
     *            返回参数
     */
    public void onFailed(String json);

    /**
     * 请求异常
     * 
     * @param json
     *            返回参数
     */
    public void onError(String json);
}
