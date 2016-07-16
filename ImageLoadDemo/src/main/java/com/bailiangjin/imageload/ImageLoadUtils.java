package com.bailiangjin.imageload;

import android.graphics.Color;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by bailiangjin on 16/7/13.
 */
public class ImageLoadUtils {

   static DisplayImageOptions circleOptions = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.icon_user)
            .showImageForEmptyUri(R.drawable.icon_user)
            .showImageOnFail(R.drawable.icon_user)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .considerExifParams(true)
            .displayer(new CircleBitmapDisplayer())
            .build();

   static DisplayImageOptions roundedOptions = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.icon_user)
            .showImageForEmptyUri(R.drawable.icon_user)
            .showImageOnFail(R.drawable.icon_user)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .considerExifParams(true)
            .displayer(new RoundedBitmapDisplayer(8))
            .build();


    public static void loadCircleImageView(ImageView iv, String url){
        ImageLoader.getInstance().displayImage(url, iv, circleOptions);
    }


    public static void loadRoundedImageView(ImageView iv,String url){
        ImageLoader.getInstance().displayImage(url, iv, roundedOptions);
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
