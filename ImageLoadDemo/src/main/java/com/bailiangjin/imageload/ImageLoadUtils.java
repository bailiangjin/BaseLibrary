package com.bailiangjin.imageload;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

/**
 * 基于Universal imageLoader 封装的 图片加载工具类
 * 枚举形式 实现单例
 * Created by bailiangjin on 16/7/16.
 */
public enum ImageLoadUtils {
    INSTANCE;
    private DisplayImageOptions normalOptions;
    private DisplayImageOptions circleOptions;
    private DisplayImageOptions roundedOptions;


    private BitmapDisplayer simpleBitmapDisplayer;
    private BitmapDisplayer circleBitmapDisplayer;
    private BitmapDisplayer roundedBitmapDisplayer;

    private int onLoadingImageResId;
    private int onEmptyImageResId;
    private int onFailedImageResId;


    private ImageLoadUtils() {
        //初始化 全局默认图片
        onLoadingImageResId = R.drawable.icon_user;
        onEmptyImageResId = R.drawable.icon_user;
        onFailedImageResId = R.drawable.icon_user;
        //圆角图片 圆角半径dp
        int cornerRadiusDp = 10;

        simpleBitmapDisplayer = new SimpleBitmapDisplayer();
        normalOptions = getOption(onLoadingImageResId, onEmptyImageResId, onFailedImageResId, simpleBitmapDisplayer);

        circleBitmapDisplayer = new CircleBitmapDisplayer();
        circleOptions = getOption(onLoadingImageResId, onEmptyImageResId, onFailedImageResId, circleBitmapDisplayer);

        roundedBitmapDisplayer = new RoundedBitmapDisplayer(dip2px(MyApplication.getContext(),cornerRadiusDp));
        roundedOptions = getOption(onLoadingImageResId, onEmptyImageResId, onFailedImageResId, roundedBitmapDisplayer);

    }

    private DisplayImageOptions getOption(int onLoadingImageResId, int onEmptyImageResId, int onFailedImageResId, BitmapDisplayer bitmapDisplayer) {
        return new DisplayImageOptions.Builder()
                .showImageOnLoading(onLoadingImageResId)
                .showImageForEmptyUri(onEmptyImageResId)
                .showImageOnFail(onFailedImageResId)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(bitmapDisplayer)
                .build();
    }


    public void loadImageView(ImageView iv, String url) {
        ImageLoader.getInstance().displayImage(url, iv, normalOptions);
    }

    public void loadCircleImageView(ImageView iv, String url) {
        ImageLoader.getInstance().displayImage(url, iv, circleOptions);
    }

    public void loadRoundedImageView(ImageView iv, String url) {
        ImageLoader.getInstance().displayImage(url, iv, roundedOptions);
    }

//    private void loadImageView(ImageView iv, String url, int defaultImageResId) {
//        DisplayImageOptions normalOptions = getOption(defaultImageResId, defaultImageResId, defaultImageResId, simpleBitmapDisplayer);
//        ImageLoader.getInstance().displayImage(url, iv, normalOptions);
//    }
//
//    private void loadCircleImageView(ImageView iv, String url, int defaultImageResId) {
//        DisplayImageOptions circleOptions = getOption(defaultImageResId, defaultImageResId, defaultImageResId, circleBitmapDisplayer);
//
//        ImageLoader.getInstance().displayImage(url, iv, circleOptions);
//    }
//
//    private void loadRoundedImageView(ImageView iv, String url, int defaultImageResId, int cornerRadiusDp) {
//        BitmapDisplayer roundedBitmapDisplayer = new RoundedBitmapDisplayer(dip2px(iv.getContext(), cornerRadiusDp));
//        DisplayImageOptions roundedOptions = getOption(defaultImageResId, defaultImageResId, defaultImageResId, roundedBitmapDisplayer);
//        ImageLoader.getInstance().displayImage(url, iv, roundedOptions);
//    }

    public static int dip2px(Context context, float dpValue) {
        final float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }


    public void init(Context context) {
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
