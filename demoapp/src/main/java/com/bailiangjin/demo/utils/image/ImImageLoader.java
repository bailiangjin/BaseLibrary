package com.bailiangjin.demo.utils.image;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bailiangjin.demo.R;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.io.File;

/**
 * 图片加载工具
 *
 * @author bailiangjin
 * @date 2018/4/11
 */

public class ImImageLoader {

    private Builder builder;

    private ImImageLoader(Builder builder) {
        this.builder = builder;
    }

    public void load(final ImageView iv, String url) {

        ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();

        RequestManager requestManager = Glide.with(iv.getContext());
        DrawableTypeRequest drawableTypeRequest;
        if (builder.isLocal) {
            File file = new File(url);
            drawableTypeRequest = requestManager.load(file);
        } else {
            drawableTypeRequest = requestManager.load(url);
        }
        DiskCacheStrategy diskCacheStrategy;
        switch (builder.cacheType) {
            case ALL:
                diskCacheStrategy = DiskCacheStrategy.ALL;
                break;
            case SOURCE:
                diskCacheStrategy = DiskCacheStrategy.SOURCE;
                break;
            case RESULT:
                diskCacheStrategy = DiskCacheStrategy.RESULT;
                break;

            default:
                diskCacheStrategy = DiskCacheStrategy.RESULT;
                break;
        }
        //形状
        Shape shape = builder.shape;
        BitmapTransformation bitmapTransformation = null;
        if (shape instanceof RectShape) {
            //矩形 不处理
            //do nothing
        } else if (shape instanceof RoundConnerShape) {
            //圆角图片处理
            RoundConnerShape roundConnerShape = (RoundConnerShape) shape;
            bitmapTransformation = new CornersTransform(iv.getContext(),
                    roundConnerShape.getCornerRadiusDp(),
                    roundConnerShape.getCorners());

        } else if (shape instanceof RoundShape) {
            // 圆形图片处理
            bitmapTransformation = new CircleTransform(iv.getContext());
        }

        if (builder.isLoadAsStatic) {
            if (null != bitmapTransformation) {
                drawableTypeRequest
                        .asBitmap()
                        .dontAnimate()
                        .diskCacheStrategy(diskCacheStrategy)
                        .transform(bitmapTransformation)
                        .placeholder(builder.loadingImageResId)
                        .error(builder.errorImageResId)
                        .into(new BitmapImageViewTarget(iv) {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                                super.onResourceReady(resource,glideAnimation);
                                if (null != builder.loadStateCallback) {
                                    builder.loadStateCallback.onSuccess();
                                }
                            }
                        });
            } else {
                drawableTypeRequest
                        .asBitmap()
                        .dontAnimate()
                        .diskCacheStrategy(diskCacheStrategy)
                        .placeholder(builder.loadingImageResId)
                        .error(builder.errorImageResId)
                        .into(new BitmapImageViewTarget(iv) {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                               super.onResourceReady(resource,glideAnimation);
                                if (null != builder.loadStateCallback) {
                                    builder.loadStateCallback.onSuccess();
                                }
                            }
                        });
            }

        } else {
            if (null != bitmapTransformation) {
                drawableTypeRequest
                        .diskCacheStrategy(diskCacheStrategy)
                        .transform(bitmapTransformation)
                        .placeholder(builder.loadingImageResId)
                        .error(builder.errorImageResId)
                        .override(layoutParams.width,layoutParams.height)
                        .into(iv);
            } else {
                drawableTypeRequest
                        .diskCacheStrategy(diskCacheStrategy)
                        .placeholder(builder.loadingImageResId)
                        .error(builder.errorImageResId)
                        .override(layoutParams.width,layoutParams.height)
                        .into(iv);
            }
        }

    }


    /**
     * 构建器
     */
    public static class Builder {
        /**
         * 是否为本地文件
         */
        private boolean isLocal = false;

        /**
         * 是否加载为静态图片
         */
        private boolean isLoadAsStatic = false;

        /**
         * 缓存策略
         */
        private CacheType cacheType = CacheType.RESULT;

        /**
         * 加载中展位图
         */
        private int loadingImageResId = R.drawable.icon_image_load_utils_default;

        /**
         * 加载失败填充图
         */
        private int errorImageResId = R.drawable.icon_image_load_utils_default;

        private Shape shape = new RectShape();

        private LoadStateCallback loadStateCallback = null;


        public ImImageLoader build() {
            return new ImImageLoader(this);
        }

        public Builder localImage(boolean isLocal) {
            this.isLocal = isLocal;
            return this;
        }

        public Builder asStaticImage(boolean loadAsStatic) {
            isLoadAsStatic = loadAsStatic;
            return this;
        }

        public Builder cacheType(CacheType cacheType) {
            this.cacheType = cacheType;
            return this;
        }

        public Builder loadingImageResId(int loadingImageResId) {
            this.loadingImageResId = loadingImageResId;
            return this;
        }

        public Builder errorImageResId(int errorImageResId) {
            this.errorImageResId = errorImageResId;
            return this;
        }

        public Builder shape(Shape shape) {
            this.shape = shape;
            return this;
        }

        public Builder loadStateCallback(LoadStateCallback loadStateCallback) {
            this.loadStateCallback = loadStateCallback;
            return this;
        }
    }

    public interface LoadStateCallback {
        /**
         * 加载成功
         */
        void onSuccess();
    }

    public enum CacheType {
        /**
         * 缓存原图和所有加载过的尺寸的图
         */
        ALL,
        /**
         * 只缓存加载所需尺寸的图
         */
        RESULT,
        /**
         * 只缓存原图
         */
        SOURCE
    }


    public static class Shape {

    }

    public static class RectShape extends Shape {

    }

    public static class RoundShape extends Shape {

    }

    /**
     * 圆角图片
     */
    public static class RoundConnerShape extends Shape {

        public static final int CORNER_TOP_LEFT = 1;
        public static final int CORNER_TOP_RIGHT = 1 << 1;
        public static final int CORNER_BOTTOM_LEFT = 1 << 2;
        public static final int CORNER_BOTTOM_RIGHT = 1 << 3;
        public static final int CORNER_ALL = CORNER_TOP_LEFT | CORNER_TOP_RIGHT | CORNER_BOTTOM_LEFT | CORNER_BOTTOM_RIGHT;


        private float cornerRadiusDp = 4.0f;
        private int corners = CORNER_ALL;

        public RoundConnerShape() {

        }

        public RoundConnerShape(float cornerRadiusDp) {
            this.cornerRadiusDp = cornerRadiusDp;
        }

        /**
         * 完整构造方法
         *
         * @param cornerRadiusDp
         * @param corners
         */
        public RoundConnerShape(float cornerRadiusDp, int corners) {
            this.cornerRadiusDp = cornerRadiusDp;
            this.corners = corners;
        }

        public float getCornerRadiusDp() {
            return cornerRadiusDp;
        }

        public int getCorners() {
            return corners;
        }
    }
}
