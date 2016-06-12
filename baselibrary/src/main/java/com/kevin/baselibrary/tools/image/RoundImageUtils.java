package com.kevin.baselibrary.tools.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * 生成圆头像工具类
 * Created by bailiangjin on 16/5/30.
 */
public class RoundImageUtils {

    /**
     * 转换图片成圆形
     *
     * @param bitmap 传入Bitmap对象
     * @return
     */
    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        float src_left, src_top, src_right, src_bottom;
        float dst_left, dst_top, dst_right, dst_bottom;

        int sideLength = width < height ? width : height;
        float roundPx = sideLength / 2;
        float clip = Math.abs(width - height) / 2;
        //输入参数
        if (width <= height) {
            src_top = clip;
            src_bottom = height - clip;
            src_left = 0;
            src_right = sideLength;
        } else {
            src_top = 0;
            src_bottom = sideLength;
            src_left = clip;
            src_right = width - clip;
        }
        //输出参数
        dst_left = 0;
        dst_top = 0;
        dst_right = sideLength;
        dst_bottom = sideLength;

        Bitmap output = Bitmap.createBitmap(sideLength,
                sideLength, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int) src_left, (int) src_top, (int) src_right, (int) src_bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
        final RectF rectF = new RectF(dst);

        paint.setAntiAlias(true);

        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, dst, paint);
        return output;
    }
}
