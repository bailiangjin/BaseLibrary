package com.bailiangjin.demo.utils.image;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;


public class MyGlideModule implements GlideModule {

    /**
     * 缓存路径
     */
//    private final String CACHE_DIR = CustomExpressionImageManager.INSTANCE.getCustomExpressionTempDir();

    /**
     * 缓存名
     */
    private final String CACHE_NAME = "custom_expression_glide_cache";

    /**
     * 缓存大小80M
     */
    private final int CACHE_SIZE = 80 * 1024 * 1024;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //builder.setDecodeFormat(DecodeFormat.ALWAYS_ARGB_8888);
//        builder.setDiskCache(new DiskLruCacheFactory(CACHE_DIR, CACHE_NAME, CACHE_SIZE));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
    }
}
