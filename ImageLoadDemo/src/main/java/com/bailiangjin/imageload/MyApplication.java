package com.bailiangjin.imageload;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by bailiangjin on 16/7/16.
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        initImageLoader(this);
    }

    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(80 * 1024 * 1024); // 80 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
    }


    //    File cacheDir = StorageUtils.getCacheDirectory(context);
//    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
//            .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
//            .diskCacheExtraOptions(480, 800, null)
//            .taskExecutor(...)
//            .taskExecutorForCachedImages(...)
//    .threadPoolSize(3) // default
//    .threadPriority(Thread.NORM_PRIORITY - 2) // default
//    .tasksProcessingOrder(QueueProcessingType.FIFO) // default
//    .denyCacheImageMultipleSizesInMemory()
//    .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
//            .memoryCacheSize(2 * 1024 * 1024)
//    .memoryCacheSizePercentage(13) // default
//    .diskCache(new UnlimitedDiskCache(cacheDir)) // default
//            .diskCacheSize(50 * 1024 * 1024)
//    .diskCacheFileCount(100)
//    .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
//            .imageDownloader(new BaseImageDownloader(context)) // default
//            .imageDecoder(new BaseImageDecoder()) // default
//            .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
//            .writeDebugLogs()
//    .build();

}
