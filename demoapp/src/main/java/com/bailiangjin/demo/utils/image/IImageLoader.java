package com.bailiangjin.demo.utils.image;

import android.widget.ImageView;

/**
 * 图片加载接口
 *
 * @author bailiangjin
 * @date 2018/4/11
 */

public interface IImageLoader {

    /**
     * 加载网络图片
     *
     * @param iv
     * @param imageUrl
     */
    void loadImage(ImageView iv, String imageUrl);

    /**
     * 加载本地图片
     *
     * @param iv
     * @param imageFilePath
     */
    void loadLocalImage(ImageView iv, String imageFilePath);

    /**
     * 以静态图的方式加载本地图片
     *
     * @param iv
     * @param imageUrl
     */
    void loadAsStaticImage(ImageView iv, String imageUrl);

    /**
     * 以静态图的方式加载本地图片
     *
     * @param iv
     * @param imageFilePath
     */
    void loadLocalAsStaticImage(ImageView iv, String imageFilePath);

    class Builder {
        private String url = "";
        private boolean isLocal = false;
        private boolean isLoadAsStatic = false;
        private CacheType cacheType = CacheType.FIT_VIEW;

        public void url(String url) {
            this.url = url;
        }

        public void localImage(boolean local) {
            isLocal = local;
        }

        public void asStaticImage(boolean loadAsStatic) {
            isLoadAsStatic = loadAsStatic;
        }

        public void cacheType(CacheType cacheType) {
            this.cacheType = cacheType;
        }
    }

    enum CacheType {
        ALL,
        FIT_VIEW,
        ORG
    }
}
