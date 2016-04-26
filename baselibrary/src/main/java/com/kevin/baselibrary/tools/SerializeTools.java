package com.kevin.baselibrary.tools;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.internal.Primitives;
import com.kevin.baselibrary.utils.LogUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serialize Tools
 */
public class SerializeTools {

    private SerializeTools() {
        throw new AssertionError();
    }

    /**
     * 获取缓存的对象
     * @param context
     * @param fileName
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T getObj(Context context, String fileName, Class<T> classOfT) {
        if (TextUtils.isEmpty(fileName) || null == classOfT) {
            return null;
        }
        File file = new File(context.getFilesDir(), fileName);
        Object obj;
        if (file.exists()) {
            obj = deserialization(file.getAbsolutePath());
            T result = Primitives.wrap(classOfT).cast(obj);
            if (null == result) {
                //删除脏数据
                file.delete();
            }
            return result;
        } else {
            return null;
        }
    }

    /**
     * 缓存对象
     * @param context
     * @param fileNameKey
     * @param object
     * @return
     */
    public static boolean cacheObj(Context context, String fileNameKey, Object object) {
        if (null == object || TextUtils.isEmpty(fileNameKey)) {
            return false;
        }
        try {
            File file = new File(context.getFilesDir(), fileNameKey);
            serialization(file.getAbsolutePath(), object);
            return true;
        } catch (Exception e) {
            LogUtils.e("serialization:cacheObjError:" + e.getMessage());
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Deserialization object from file.
     *
     * @param filePath file path
     * @return de-serialized object
     * @throws RuntimeException if an error occurs
     */
    public static Object deserialization(String filePath) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            Object obj = objectInputStream.readObject();
            objectInputStream.close();
            return obj;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ClassNotFoundException occurred. ", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred. ", e);
        } finally {
            IOUtils.close(objectInputStream);
        }
    }

    /**
     * Serialize object to file.
     *
     * @param filePath file path
     * @param obj      object
     * @throws RuntimeException if an error occurs
     */
    public static void serialization(String filePath, Object obj) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            outputStream.writeObject(obj);
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred. ", e);
        } finally {
            IOUtils.close(outputStream);
        }
    }

    /**
     * 删除文件
     *
     * @param filePath
     */
    public static void deletePath(String filePath) {
        File file = new File(filePath);
        if (file != null) {
            if (file.isFile())
                file.delete();
        }
    }

}
