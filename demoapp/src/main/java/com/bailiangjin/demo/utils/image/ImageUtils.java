package com.bailiangjin.demo.utils.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.text.TextUtils;

import com.bailiangjin.utilslibrary.utils.LogUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 图片相关工具类
 */

public class ImageUtils {
    public static final String TYPE_JPG = "jpg";
    public static final String TYPE_JPEG = "jpeg";
    public static final String TYPE_GIF = "gif";
    public static final String TYPE_PNG = "png";
    public static final String TYPE_BMP = "bmp";
    public static final String TYPE_WEBP = "webp";
    public static final String TYPE_UNKNOWN = "unknown";
    private static Bitmap.Config BITMAP_CONFIG = Bitmap.Config.RGB_565;

    /**
     * maxCompressTimes
     */
    private static final int MAX_COMPRESS_TIMES = 20;

    /**
     * 压缩图片时 每次图片质量衰减比例
     */
    private static final float COUNTDOWN_EVERY_TIME = 0.95F;

    /**
     * 超长图 比例阈值
     */
    private static final float OVER_LENGTH_IMAGE_RATIO = 27f / 9f;

    /**
     * 超大图强制压缩控制阈值 超过8M为大图片 强制压缩
     */
    private static final long BIG_IMAGE_FILE_LENGTH = 8 * 1024 * 1024;


    public static ImageParam getImageParam(String imageFilePath) {

        if (TextUtils.isEmpty(imageFilePath)) {
            return null;
        }
        File file = new File(imageFilePath);
        if (!file.exists() || file.isDirectory() || 0 == file.length()) {
            return null;
        }

        BitmapFactory.Options options = getBitmapOptionsNotRealLoadImage(imageFilePath);
        if (null == options) {
            LogUtils.e("get picture options,found null please check the logic before");
            return null;
        }

        return new ImageParam(options.outWidth, options.outHeight);
    }

    /**
     * 从文件读取窄边宽度不大于targetShortSidePixel的bitmap
     *
     * @param sourceBitmap
     * @param targetLongSidePixel
     * @return
     */
    public static Bitmap getBitmapFromBitmapByLongSide(Bitmap sourceBitmap, final int targetLongSidePixel) {

        if (null == sourceBitmap) {
            return null;
        }

        int tempWidth = sourceBitmap.getWidth();
        int tempHeight = sourceBitmap.getHeight();


        Bitmap tempBitmap = sourceBitmap;

        float heightWidthRatio = (float) tempHeight / (float) tempWidth;

        int endWidth;
        int endHeight;
        //普通图 再次压缩处理
        if (heightWidthRatio >= 1 && tempHeight <= targetLongSidePixel
                || heightWidthRatio < 1 && tempWidth <= targetLongSidePixel) {
            //图片窄边已经小于等于控制值  不必再压缩 直接返回现有的bitmap
            return tempBitmap;
        } else {
            //图片窄边大于窄边像素期望值

            if (heightWidthRatio >= 1) {
                //竖图
                float secondCompressRatio = (float) targetLongSidePixel / (float) tempHeight;
                endWidth = (int) (tempWidth * secondCompressRatio);
                endHeight = targetLongSidePixel;
            } else {
                //横图
                float secondCompressRatio = (float) targetLongSidePixel / (float) tempWidth;
                endWidth = targetLongSidePixel;
                endHeight = (int) (tempHeight * secondCompressRatio);
            }
        }
        //最后一个参数解释 当进行的不只是平移变换时，filter参数为true可以进行滤波处理，有助于改善新图像质量;flase时，计算机不做过滤处理。
        Bitmap endBitmap = Bitmap.createScaledBitmap(tempBitmap, endWidth, endHeight, true);
        if (null == endBitmap) {
            return tempBitmap;
        }
        //释放中间的bitmap
        if (tempBitmap != endBitmap) {
            if (!tempBitmap.isRecycled()) {
                tempBitmap.recycle();
            }
            tempBitmap = null;
        }
        return endBitmap;
    }

    /**
     * 从文件读取窄边宽度不大于targetShortSidePixel的bitmap
     *
     * @param imageFilePath       文件路径
     * @param targetLongSidePixel 长边像素限制值
     * @return 读取的bitmap
     */
    public static Bitmap getBitmapFromFileByLongSide(String imageFilePath, final int targetLongSidePixel) {

        if (TextUtils.isEmpty(imageFilePath)) {
            return null;
        }
        File file = new File(imageFilePath);
        if (!file.exists() || file.isDirectory() || 0 == file.length()) {
            return null;
        }

        BitmapFactory.Options options = getBitmapOptionsNotRealLoadImage(imageFilePath);
        if (null == options) {
            LogUtils.e("get picture options,found null please check the logic before");
            return null;
        }

        int orgHeight = options.outHeight;
        int orgWidth = options.outWidth;
        // 设置只读取参数配置为false 为下一步真正读取bitmap做准备
        options.inJustDecodeBounds = false;

        int pixelCompressRatio = getPixelCompressRatio(orgWidth, orgHeight, targetLongSidePixel);
        if (1 == pixelCompressRatio) {
            long fileLength = file.length();
            if (fileLength > BIG_IMAGE_FILE_LENGTH) {
                //窄边大文件强制压缩
                pixelCompressRatio = (int) Math.ceil((double) fileLength / (double) BIG_IMAGE_FILE_LENGTH);
            }
        }

        options.inSampleSize = pixelCompressRatio;
        options.inPreferredConfig = BITMAP_CONFIG;

        //真正读取bitmap到内存当中
        Bitmap tempBitmap = BitmapFactory.decodeFile(imageFilePath, options);
        if (null == tempBitmap) {
            return null;
        }
        int tempWidth = options.outWidth;
        int tempHeight = options.outHeight;


        float heightWidthRatio = (float) tempHeight / (float) tempWidth;

        tempBitmap = rotateBitmap(tempBitmap, imageFilePath);
        int endWidth;
        int endHeight;
        //普通图 再次压缩处理
        if (heightWidthRatio >= 1 && tempHeight <= targetLongSidePixel
                || heightWidthRatio < 1 && tempWidth <= targetLongSidePixel) {
            //图片窄边已经小于等于控制值  不必再压缩 直接返回现有的bitmap
            return tempBitmap;
        } else {
            //图片窄边大于窄边像素期望值

            if (heightWidthRatio >= 1) {
                //竖图
                float secondCompressRatio = (float) targetLongSidePixel / (float) tempHeight;
                endWidth = (int) (tempWidth * secondCompressRatio);
                endHeight = targetLongSidePixel;
            } else {
                //横图
                float secondCompressRatio = (float) targetLongSidePixel / (float) tempWidth;
                endWidth = targetLongSidePixel;
                endHeight = (int) (tempHeight * secondCompressRatio);
            }
        }
        //最后一个参数解释 当进行的不只是平移变换时，filter参数为true可以进行滤波处理，有助于改善新图像质量;flase时，计算机不做过滤处理。
        Bitmap endBitmap = Bitmap.createScaledBitmap(tempBitmap, endWidth, endHeight, true);
        if (null == endBitmap) {
            return tempBitmap;
        }
        //释放中间的bitmap
        if (tempBitmap != endBitmap) {
            if (!tempBitmap.isRecycled()) {
                tempBitmap.recycle();
            }
            tempBitmap = null;
        }
        return endBitmap;
    }


    /**
     * 检测图片是否为超长图
     *
     * @param imageFilePath
     * @return
     */
    public static float getOverLengthImageMultiplyingPower(String imageFilePath, float overLengthRatio) {
        if (overLengthRatio < 0) {
            return 1;
        }
        BitmapFactory.Options options = getBitmapOptionsNotRealLoadImage(imageFilePath);
        if (null == options) {
            LogUtils.e("get picture options,found null please check the logic before");
            return 1F;
        }


        int orgHeight = options.outHeight;
        int orgWidth = options.outWidth;
        if (0 == orgWidth || 0 == orgHeight) {
            LogUtils.e("error:the picture is invalid,because its  width or height is 0");
            return 1F;
        }
        float heightWidthRatio = (float) orgHeight / (float) orgWidth;

        heightWidthRatio = heightWidthRatio > 1 ? heightWidthRatio : 1 / heightWidthRatio;

        float multiplyingPower = heightWidthRatio / overLengthRatio;
        return multiplyingPower;

    }

    /**
     * 检测图片是否为超长图
     *
     * @param imageFilePath 图片文件路径
     * @return
     */
    public static boolean isOverLengthImage(String imageFilePath, float overLengthRatio) {

        if (overLengthRatio <= 0) {
            return true;
        }


        BitmapFactory.Options options = getBitmapOptionsNotRealLoadImage(imageFilePath);
        if (null == options) {
            LogUtils.e("get picture options,found null please check the logic before");
            return false;
        }


        int orgHeight = options.outHeight;
        int orgWidth = options.outWidth;
        if (0 == orgWidth || 0 == orgHeight) {
            LogUtils.e("error:the picture is invalid,because its  width or height is 0");
            return false;
        }

        float heightWidthRatio = (float) orgHeight / (float) orgWidth;

        return heightWidthRatio > overLengthRatio || heightWidthRatio < (1 / overLengthRatio);
    }


    /**
     * 截取缩略图 回收源bitmap
     *
     * @param sourceBitmap         源bitmap
     * @param targetShortSidePixel 目标缩略图 短边像素值
     * @param targetLongSidePixel  目标缩略图 长边像素数
     * @return 截取的缩略图bitmap
     */
    public static Bitmap extractThumbnailRecycleInput(Bitmap sourceBitmap, int targetShortSidePixel, int targetLongSidePixel) {
        return extractThumbnail(sourceBitmap, targetShortSidePixel, targetLongSidePixel, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
    }

    /**
     * 截取缩略图 不回收源bitmap
     *
     * @param sourceBitmap         源bitmap
     * @param targetShortSidePixel 目标缩略图 短边像素值
     * @param targetLongSidePixel  目标缩略图 长边像素数
     * @return 截取的缩略图bitmap
     */
    public static Bitmap extractThumbnailNotRecycleInput(Bitmap sourceBitmap, int targetShortSidePixel, int targetLongSidePixel) {
        return extractThumbnail(sourceBitmap, targetShortSidePixel, targetLongSidePixel, 0);
    }

    /**
     * 截取缩略图
     *
     * @param sourceBitmap          源bitmap
     * @param targetShortSidePixel  目标缩略图 短边像素值
     * @param targetLongSidePixel   目标缩略图 长边像素数
     * @param thumbnailUtilsOptions 回收源bitmap传ThumbnailUtils.OPTIONS_RECYCLE_INPUT 不回收源bitmap传 0
     * @return 截取的缩略图bitmap
     */
    private static Bitmap extractThumbnail(Bitmap sourceBitmap, int targetShortSidePixel, int targetLongSidePixel, int thumbnailUtilsOptions) {
        if (sourceBitmap == null) {
            return null;
        }
        if (targetShortSidePixel <= 0 || targetLongSidePixel <= 0) {
            LogUtils.e("input param targetShortSidePixel or targetLongSidePixel <= 0 please check you code and logic");
            return null;
        }

        int bitmapWidth = sourceBitmap.getWidth();
        int bitmapHeight = sourceBitmap.getHeight();

        if (bitmapWidth <= 0 || bitmapWidth <= 0) {
            LogUtils.e("input param bitmap width or height <= 0 please check you code and logic");
            return null;
        }

        int bitmapShortSidePixel = bitmapWidth < bitmapHeight ? bitmapWidth : bitmapHeight;
        int bitmapLongSidePixel = bitmapWidth > bitmapHeight ? bitmapWidth : bitmapHeight;


        if (bitmapShortSidePixel <= targetShortSidePixel && bitmapLongSidePixel <= targetLongSidePixel) {
            //小于截图要求尺寸 不处理 直接返回
            return sourceBitmap;
        }

        int endWidth;
        int endHeight;

        if (bitmapWidth == bitmapLongSidePixel) {
            //bitmap 宽>=高 为横图 或正方形
            endWidth = bitmapWidth < targetLongSidePixel ? bitmapWidth : targetLongSidePixel;
            endHeight = bitmapHeight < targetShortSidePixel ? bitmapHeight : targetShortSidePixel;

        } else {
            //bitmap 宽<高 为竖图
            endWidth = bitmapWidth < targetShortSidePixel ? bitmapWidth : targetShortSidePixel;
            endHeight = bitmapHeight < targetLongSidePixel ? bitmapHeight : targetLongSidePixel;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap thumbnailBitmap = ThumbnailUtils.extractThumbnail(sourceBitmap, endWidth, endHeight, thumbnailUtilsOptions);
        return thumbnailBitmap;
    }


    /**
     * 计算像素压缩比率 （参数单位为像素）
     *
     * @param orgWidth            原宽度
     * @param orgHeight           原高度
     * @param targetLongSidePixel 目标短边像素值
     * @return 像素压缩比 值越大 压缩越狠
     */
    private static int getPixelCompressRatioByLongSide(int orgWidth, int orgHeight, int targetLongSidePixel) {
        //关键指标 像素压缩比率
        int pixelCompressRatio;

        //实际图片短边像素值
        int imageLongSidePixel = orgWidth > orgHeight ? orgWidth : orgHeight;
        //需要压缩的比率
        pixelCompressRatio = Math.round((float) imageLongSidePixel / (float) targetLongSidePixel);
        return pixelCompressRatio < 1 ? 1 : pixelCompressRatio;
    }

    /**
     * 计算像素压缩比率 （参数单位为像素）
     *
     * @param orgWidth            原宽度
     * @param orgHeight           原高度
     * @param targetLongSidePixel 目标短边像素值
     * @return 像素压缩比 值越大 压缩越狠
     */
    private static int getPixelCompressRatio(int orgWidth, int orgHeight, int targetLongSidePixel) {
        //关键指标 像素压缩比率
        int pixelCompressRatio;

        //实际图片短边像素值
        int imageLongSidePixel = orgWidth > orgHeight ? orgWidth : orgHeight;
        //需要压缩的比率
        pixelCompressRatio = Math.round((float) imageLongSidePixel / (float) targetLongSidePixel);
        return pixelCompressRatio < 1 ? 1 : pixelCompressRatio;
    }


    public static BitmapFactory.Options getBitmapOptionsNotRealLoadImage(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        if (!new File(filePath).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        //设置为true,表示解析Bitmap对象，该对象不占内存
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        return options;

    }

    /**
     * 压缩bitmap 并转为Bytes
     *
     * @param bitmap
     * @param maxKbSize
     * @return
     */
    public static byte[] bitmapToBytes(Bitmap bitmap, int maxKbSize) {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int quality = 100;
        maxKbSize = maxKbSize * 1024; // convert to Bytes
        if (maxKbSize == 0) {
            bitmap.compress(compressFormat, quality, baos);
        } else {
            baos.reset();
            bitmap.compress(compressFormat, quality, baos);
            int compressTimes = 0;
            while (baos.size() > maxKbSize && compressTimes <= MAX_COMPRESS_TIMES) {
                float countDownEveryTime = COUNTDOWN_EVERY_TIME;
                compressTimes++;
                quality = (int) ((float) quality * countDownEveryTime);
                baos.reset();
                bitmap.compress(compressFormat, quality, baos);
            }
        }
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    public static Bitmap.CompressFormat getBitmapCompressType(String fileType) {
        if (TextUtils.isEmpty(fileType)) {
            return Bitmap.CompressFormat.JPEG;
        }
        fileType = fileType.toLowerCase();
        switch (fileType) {
            case TYPE_JPG:
            case TYPE_JPEG:
                return Bitmap.CompressFormat.JPEG;
            case TYPE_PNG:
                return Bitmap.CompressFormat.PNG;
            case TYPE_WEBP:
                return Bitmap.CompressFormat.WEBP;
            default:
                return Bitmap.CompressFormat.JPEG;
        }
    }

    /**
     * 根据文件流判断图片类型
     *
     * @param filePath
     * @return jpg/png/gif/bmp
     */
    public static String getFileType(String filePath) {
        //读取文件的前几个字节来判断图片格式
        byte[] b = new byte[4];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            fis.read(b, 0, b.length);
            String type = bytesToHexString(b).toUpperCase();
            if (type.contains("FFD8FF")) {
                return TYPE_JPG;
            } else if (type.contains("89504E47")) {
                return TYPE_PNG;
            } else if (type.contains("47494638")) {
                return TYPE_GIF;
            } else if (type.contains("424D")) {
                return TYPE_BMP;
            } else {
                return TYPE_UNKNOWN;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 将byte字节转换为十六进制字符串
     *
     * @param src
     * @return
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }


    public static File compressAndSaveBitmapToFile(Bitmap bitmap, String fileSavePath, int aimedMaxKbSize) {
        byte[] bytes = bitmapToBytes(bitmap, aimedMaxKbSize);
        if (null != bytes && bytes.length > 0) {
            try {
                File file = new File(fileSavePath);
                if (!file.exists()) {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                }

                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(bytes);
                fos.close();
                return file;
            } catch (IOException e) {
                e.printStackTrace();
                LogUtils.e("save bytes to file io exception :" + e.getMessage());
                return null;
            }
        } else {
            LogUtils.e(" bytes to save to file is empty");
            return null;
        }
    }


    /**
     * 旋转bitmap
     *
     * @param bitmap              bitmap参数
     * @param sourceImageFilePath bitmap 源文件地址 用于获取ExifInterface信息
     * @return
     */
    public static Bitmap rotateBitmap(Bitmap bitmap, String sourceImageFilePath) {
        //照片旋转
        try {
            ExifInterface exifInterface = new ExifInterface(sourceImageFilePath);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            int rotate = 0;
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
                default:
                    rotate = 0;
            }
            if (rotate != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(rotate);
                Bitmap rotateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (rotateBitmap != bitmap) {
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
                bitmap = rotateBitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
