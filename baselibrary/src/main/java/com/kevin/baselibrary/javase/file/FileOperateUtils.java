package com.kevin.baselibrary.javase.file;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：16/2/26 23:00
 */
public class FileOperateUtils {

    /**
     * 文件合并程序。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

//        File dir = new File("/Users/bailiangjin/Desktop/sepedfile/");
//        mergeFile(dir);

        File file = new File("/Users/bailiangjin/Desktop/sepedfile/TestSu.apk");
        File dir = new File("/Users/bailiangjin/Desktop/sepedfile/");
        splitFile(file, dir, FileConfig.FRAGMENT_SIZE);

    }

    /**
     * 获取文件分块数
     *
     * @param fileLength
     * @param partSize
     * @return
     */
    public static int getPartNum(long fileLength, int partSize) {

        if (fileLength < partSize) {
            return 1;
        }
        if (fileLength % partSize == 0) {
            return (int) (fileLength / partSize);
        } else {
            return (int) (fileLength / partSize + 1);
        }

    }


    /**
     * @param file
     * @param dir
     * @param partSize 文件分块大小
     * @throws IOException
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void splitFile(File file, File dir, int partSize) throws IOException {

        FileInputStream fis = new FileInputStream(file);
        if (!dir.exists())
            dir.mkdirs();
        FileOutputStream fos = null;

        int partNumber = getPartNum(file.length(), partSize);

        Object[] radomIntArray = getRandomIntArray(partNumber);

        Properties pro = new Properties();
        pro.setProperty(FileConfig.fileNameKey, file.getName());

        byte[] buf = new byte[partSize];
        int len = 0;
        int count = 1;
        while ((len = fis.read(buf)) != -1) {
            String partFileKey = FileConfig.filePartNameKeyPrefix + count;
            String partFileName = (int) radomIntArray[count - 1] + FileConfig.filePartSuffixKey;
            fos = new FileOutputStream(new File(dir, partFileName));
            //将文件名写入 配置文件 无配置文件将无法组拼文件碎片为整个文件
            pro.setProperty(partFileKey, partFileName);
            fos.write(buf, 0, len);
            fos.close();
            count++;
        }
        FileWriter fw = new FileWriter(new File(dir, FileConfig.propertiesFileNameAll));

        pro.setProperty(FileConfig.filePartCountKey, count + "");
        pro.store(fw, FileConfig.propertiesFileName);
        fw.close();
        fis.close();
    }


    /**
     * 合并文件
     *
     * @param dir
     * @throws IOException
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void mergeFile(File dir) throws IOException {
        File[] properties_file = dir.listFiles(new Suffix(FileConfig.propertiesFileSuffix));
        if (properties_file.length != 1)
            throw new RuntimeException("配置文件不存在 或 不唯一");


        Properties pro = new Properties();
        pro.load(new FileReader(properties_file[0]));
        int count = Integer.parseInt(pro.getProperty(FileConfig.filePartCountKey));
        String file_name = pro.getProperty(FileConfig.fileNameKey);

        File[] myPart = dir.listFiles(new Suffix(FileConfig.filePartSuffixKey));
        if (myPart.length != count - 1)
            throw new RuntimeException("碎片文件数目不正确！ 应为 " + (count - 1) + " 个");


        ArrayList<InputStream> al = new ArrayList<InputStream>();
        FileInputStream fis = null;
        for (int i = 1; i < count; i++) {
            //从配置文件中找的该部分对应的文件名
            String partFilename = pro.getProperty(FileConfig.filePartNameKeyPrefix + i);
            fis = new FileInputStream(new File(dir, partFilename));
            al.add(fis);
        }
        //创建枚举变量 来存取集合中的读入流。
        Enumeration<InputStream> en = Collections.enumeration(al);
        //将枚举变量中的读取流，进行逻辑串联。
        SequenceInputStream sis = new SequenceInputStream(en);


        FileOutputStream fos = new FileOutputStream(new File(dir, file_name));
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf, 0, len);
            fos.flush();
        }
        fos.close();
        sis.close();
    }

    /**
     * 获取指定长度的不重复的随机整数数组
     *
     * @param size 数组长度 可传入最大值为 int最大值/5
     * @return
     */
    public static Object[] getRandomIntArray(int size) {
        Random random = new Random();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        // 生成随机数字并存入HashMap
        while (hashMap.keySet().size() < size) {
            int number = random.nextInt(size * 5) + 1;
            hashMap.put(number, 0);
        }
        return hashMap.keySet().toArray();

    }

}
