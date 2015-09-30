package com.kevin.baselibrary.utils;

import com.kevin.baselibrary.callback.HttpCallback;
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

public class MyHttpUtils {


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

            httpCallback.onFailed(e.getMessage());
        }
    }


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
                    httpCallback.onFailed(e.getMessage());
                }
            }
        }).start();

    }


//    public
//    static String send(String url, String method, Map<String, Object> pairs, HttpCallback callBack) {
//        if (method.equals("post"))
//            return post(url, pairs);
//        else if (method.equals("get"))
//            return get(url, pairs);
//        else if (method.equals("asyncGet"))
//            return asyncGet(url, pairs, callBack);
//        else if (method.equals("asyncPost"))
//            return asyncPost(url, pairs, callBack);
//    }
//
//    public static String get(String url, Map<String, Object> pairs) {
//        println "h2get:url=$url;pairs=$pairs"
//        String queryString = "";
//        pairs.each {
//            _m ->
//                    queryString += _m.key + "=" + _m.value.toString() + "&"
//        }
//        println "h2get:queryString=$queryString"
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("$url?$queryString")
//                .build();
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
//            String body = response.body().string();
//            println "h2get:response=" + body
//            return body;
//        } catch (IOException e) {
//            println "h2get:error=" + e.getMessage()
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    public static String post(String url, Map<String, Object> pairs) {
//        println "h2post:url=$url;pairs=$pairs"
//        OkHttpClient client = new OkHttpClient();
//        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
//        pairs.each {
//            _m ->
//                    formEncodingBuilder.add(_m.key, _m.value.toString());
//            println "h2post:" + _m.key + "=" + _m.value.toString()
//        }
//        RequestBody formBody = formEncodingBuilder.build();
//        Request request = new Request.Builder()
//                .url(url)
//                .post(formBody)
//                .build();
//        Response response = null;
//        try {
//            println "h2post:start"
//            response = client.newCall(request).execute();
//            String body = response.body().string();
//            println "h2post:response=" + body
//            return body;
//        } catch (Exception e) {
//            println "h2post:error=" + e
//            e.printStackTrace();
//        }
//        return null;
//    }

}
