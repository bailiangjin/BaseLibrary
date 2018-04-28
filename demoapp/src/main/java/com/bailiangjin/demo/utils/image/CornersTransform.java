package com.bailiangjin.demo.utils.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bailiangjin.demo.MyApplication;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * 圆角效果的Transform
 *
 * @author bailiangjin
 * @date 2018/4/13
 */
public class CornersTransform extends BitmapTransformation {
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 1 << 1;
    public static final int CORNER_BOTTOM_LEFT = 1 << 2;
    public static final int CORNER_BOTTOM_RIGHT = 1 << 3;
    public static final int CORNER_ALL = CORNER_TOP_LEFT | CORNER_TOP_RIGHT | CORNER_BOTTOM_LEFT | CORNER_BOTTOM_RIGHT;

    private int corners = CORNER_ALL;

    private float cornerRadius;

    public CornersTransform(Context context) {
        super(context);
        this.cornerRadius = Resources.getSystem().getDisplayMetrics().density * 4;
    }

    public CornersTransform(Context context, float cornerRadius, int corners) {
        super(context);
        this.cornerRadius = Resources.getSystem().getDisplayMetrics().density * cornerRadius;
        this.corners = corners;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return cornersCrop(pool, toTransform, outWidth, outHeight);
    }

    /**
     * 圆角转换
     *
     * @param pool
     * @param sourceBitmap
     * @param viewWidth
     * @param viewHeight
     * @return
     */
    private Bitmap cornersCrop(BitmapPool pool, Bitmap sourceBitmap, int viewWidth, int viewHeight) {
        if (sourceBitmap == null) {
            return null;
        }

        int longSidePixel = viewWidth > viewHeight ? viewWidth : viewHeight;
        int shortSidePixel = viewWidth <= viewHeight ? viewWidth : viewHeight;

        Bitmap drawSourceBitmap;
        if (sourceBitmap.getWidth() <= viewWidth && sourceBitmap.getHeight() <= viewHeight) {
            //view已满足需要
            drawSourceBitmap = sourceBitmap;
        } else {
            //bitmap 大于View 抽取 view大小的缩略图
            Bitmap thumbnailBitmap = ImageUtils.extractThumbnailRecycleInput(sourceBitmap, shortSidePixel, longSidePixel);
            drawSourceBitmap = null == thumbnailBitmap ? sourceBitmap : thumbnailBitmap;
        }

        int drawWidth = viewWidth;
        int drawHeight = viewHeight;

        //获取或创建最终需要的bitmap画布
        Bitmap resultBitmap = pool.get(drawWidth, drawHeight, Bitmap.Config.ARGB_8888);
        if (resultBitmap == null) {
            resultBitmap = Bitmap.createBitmap(drawWidth, drawHeight, Bitmap.Config.ARGB_8888);
        }

        //画四个圆角
        float realRadius = 1 * cornerRadius;
        Canvas canvas = new Canvas(resultBitmap);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(drawSourceBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, drawWidth, drawHeight);
        canvas.drawRoundRect(rectF, realRadius, realRadius, paint);

        //将不是圆角的角画出来
        int notRoundedCorners = corners ^ CORNER_ALL;
        //哪个角不是圆角我再把你用矩形画出来
        if ((notRoundedCorners & CORNER_TOP_LEFT) != 0) {
            canvas.drawRect(0, 0, realRadius, realRadius, paint);
        }
        if ((notRoundedCorners & CORNER_TOP_RIGHT) != 0) {
            canvas.drawRect(rectF.right - realRadius, 0, rectF.right, realRadius, paint);
        }
        if ((notRoundedCorners & CORNER_BOTTOM_LEFT) != 0) {
            canvas.drawRect(0, rectF.bottom - realRadius, realRadius, rectF.bottom, paint);
        }
        if ((notRoundedCorners & CORNER_BOTTOM_RIGHT) != 0) {
            canvas.drawRect(rectF.right - realRadius, rectF.bottom - realRadius, rectF.right, rectF.bottom, paint);
        }
        return resultBitmap;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }

    /**
     * dp2px
     */
    public static int dip2px(float dpValue) {
        final float scale = MyApplication.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}