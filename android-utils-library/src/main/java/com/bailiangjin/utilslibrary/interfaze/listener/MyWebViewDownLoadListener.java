package com.bailiangjin.utilslibrary.interfaze.listener;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

import com.bailiangjin.utilslibrary.utils.app.AppUtils;
import com.bailiangjin.utilslibrary.utils.LogUtils;

/**
 * webView 下载事件监听
 * Created by bailiangjin on 2016/12/9.
 */
public class MyWebViewDownLoadListener implements DownloadListener {
    @Override
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {

        LogUtils.d("download file url:" + url);

        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        AppUtils.getContext().startActivity(intent);
    }

//

}
