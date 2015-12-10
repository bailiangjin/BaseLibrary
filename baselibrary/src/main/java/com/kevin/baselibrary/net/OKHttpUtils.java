package com.kevin.baselibrary.net;

import com.kevin.baselibrary.interfaze.callback.HttpCallback;
import com.kevin.baselibrary.utils.LogUtils;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;

/**
 * 作者  liangjin.bai Email:bailiangjin@gmail.com
 * 创建时间 2015/8/25 14:40
 */

public class OKHttpUtils {

    /**
     * 异步get方式请求网络
     * @param url
     * @param pairs 参数map
     * @param httpCallback 网络请求回调
     */
    public
    static void asyncGet(final String url, final Map<String, Object> pairs, final HttpCallback httpCallback) {
        LogUtils.e("localh2asyncPost:url=" + url);
        String queryString = "";
        for (Map.Entry<String, Object> entry : pairs.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            queryString += key + "=" + value + "&";
            LogUtils.e("h2asyncPost:" + key + "=" + value);
        }
        LogUtils.e("h2asyncGet:queryString=" + queryString);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + "?" + queryString)
                .build();
        try {
            client.newCall(request).enqueue(new Callback() {
                public void onFailure(Request request_, IOException e) {
                    httpCallback.onFailed(e.getMessage());
                }

                public void onResponse(Response response_) throws IOException {
                    httpCallback.onSucess(response_.body().string());
                }
            });
        } catch (Exception e) {
            LogUtils.e("h2asyncGet:error=" + e.getMessage());
            e.printStackTrace();

            httpCallback.onError(e.getMessage());
        }
    }


    /**
     * 异步 post 方式请求网络
     * @param url url
     * @param pairs 参数键值对Map
     * @param httpCallback 请求网络回调
     */
    public static void asyncPost(final String url, final Map<String, Object> pairs, final HttpCallback httpCallback) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtils.e("localh2asyncPost:url=" + url);
                OkHttpClient client = new OkHttpClient();
                FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();

                for (Map.Entry<String, Object> entry : pairs.entrySet()) {
                    formEncodingBuilder.add(entry.getKey(), (String) entry.getValue());
                    LogUtils.e("h2asyncPost:" + entry.getKey() + "=" + (String) entry.getValue());
                }
                RequestBody formBody = formEncodingBuilder.build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(formBody)
                        .build();
                try {
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {
                            httpCallback.onFailed(e.getMessage());
                        }

                        @Override
                        public void onResponse(Response response) throws IOException {
                            httpCallback.onSucess(response.body().string());
                        }
                    });
                } catch (Exception e) {
                    LogUtils.e("h2asyncPost:error=" + e.getMessage());
                    e.printStackTrace();
                    httpCallback.onError(e.getMessage());
                }
            }
        }).start();

    }

}
