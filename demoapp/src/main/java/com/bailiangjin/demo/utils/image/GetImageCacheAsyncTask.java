package com.bailiangjin.demo.utils.image;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import org.reactivestreams.Subscriber;

import java.io.File;

/**
 * 获取缓存图片异步任务
 *
 * @author bailiangjin
 * @date 2018/4/11
 */
public class GetImageCacheAsyncTask extends AsyncTask<String, Void, File> {
    private final Context context;
    private final Subscriber<File> subscriber;

    public GetImageCacheAsyncTask(Context context, Subscriber<File> subscriber) {
        this.context = context;
        this.subscriber = subscriber;
    }

    @Override
    protected File doInBackground(String... params) {
        String imgUrl = params[0];
        try {
            return Glide.with(context)
                    .load(imgUrl)
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(File imageFile) {
        if (null == imageFile || 0 == imageFile.length()) {
            subscriber.onError(new RuntimeException("download image failed"));
            return;
        }
        //此path就是对应文件的缓存路径
        Log.d("path", imageFile.getAbsolutePath());
        subscriber.onNext(imageFile);

    }
}