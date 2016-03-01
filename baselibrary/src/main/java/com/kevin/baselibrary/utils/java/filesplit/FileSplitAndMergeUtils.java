package com.kevin.baselibrary.utils.java.filesplit;

import android.annotation.TargetApi;
import android.os.Build;

import com.kevin.baselibrary.utils.java.FileUtils;
import com.kevin.baselibrary.utils.java.enc.AESUtils;

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
 * 文件切分合并工具类 作者：bailiangjin bailiangjin@gmail.com 创建时间：16/2/26 23:00
 */
public class FileSplitAndMergeUtils {

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
	 * 切割apk 文件
	 * 
	 * @param apkFilePath
	 *            apk 路径
	 * @param outPutDir
	 *            输出目录
	 * @param partSize
	 *            片段大小
	 * @throws IOException
	 */
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public static void splitFile(String apkFilePath, String outPutDir,
			int partSize) throws IOException {
		File apkFile = new File(apkFilePath);
		File dir = new File(outPutDir);
		FileInputStream fis = new FileInputStream(apkFile);
		if (!dir.exists())
			dir.mkdirs();
		FileOutputStream fos = null;

		int partNumber = getPartNum(apkFile.length(), partSize);

		Object[] radomIntArray = getRandomIntArray(partNumber);

		Properties pro = new Properties();
		pro.setProperty(FileConfig.fileNameKey, apkFile.getName());

		byte[] buf = new byte[partSize];
		int len = 0;
		int count = 1;
		while ((len = fis.read(buf)) != -1) {
			String partFileKey = FileConfig.filePartNameKeyPrefix + count;
			String partFileName = radomIntArray[count - 1]
					+ FileConfig.filePartSuffixKey;
			fos = new FileOutputStream(new File(dir, partFileName));
			// 将文件名写入 配置文件 无配置文件将无法组拼文件碎片为整个文件
			pro.setProperty(partFileKey, partFileName);
			fos.write(buf, 0, len);
			fos.close();
			count++;
		}
		FileWriter fw = new FileWriter(new File(dir,
				FileConfig.propertiesFileNameAll));
		pro.setProperty(FileConfig.filePartCountKey, count + "");
		pro.store(fw, FileConfig.propertiesFileName);
		fw.close();
		fis.close();

		String proFilePath = dir + File.separator
				+ FileConfig.propertiesFileNameAll;
		String encFilePath = proFilePath + "." + FileConfig.encFileSuffix + "."
				+ FileConfig.propertiesFileSuffix;

		try {
			String fileContent = FileUtils.readFile(proFilePath).toString();
			String encFileContent = AESUtils.encrypt(fileContent);
			FileUtils.saveStringToFile(encFilePath, encFileContent, false);
			// 删除原明文 配置文件
			FileUtils.deleteFile(proFilePath);
		} catch (Exception e1) {

			e1.printStackTrace();
		}

	}

	/**
	 * 合并文件
	 * @param srcDir 原文件目录
	 * @param outputDir 输出文件目录
	 * @throws IOException
	 */
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public static void mergeFile(String srcDir, String outputDir)
			throws IOException {
		File dir = new File(srcDir);

		File[] properties_file = dir.listFiles(new Suffix(
				FileConfig.propertiesFileSuffix));
		if (properties_file.length != 1)
			throw new RuntimeException("配置文件不存在 或 不唯一");

		File fileEnc = properties_file[0];

		String encFilePath = fileEnc.getAbsolutePath();
		String decFilePath = encFilePath + ".aes."
				+ FileConfig.propertiesFileSuffix;

		try {
			String fileContent = FileUtils.readFile(encFilePath).toString();
			System.out.println(fileContent);
			String encFileContent = AESUtils.decrypt(fileContent);
			FileUtils.saveStringToFile(decFilePath, encFileContent, false);
			// 删除原密文文件
			// new File(encFilePath).delete();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		File fileDec = new File(decFilePath);
		Properties pro = new Properties();
		pro.load(new FileReader(fileDec));

		// 使用完毕 删除解密出的配置文件
		FileUtils.deleteFile(decFilePath);
		int count = Integer.parseInt(pro
				.getProperty(FileConfig.filePartCountKey));
		String file_name = pro.getProperty(FileConfig.fileNameKey);

		File[] myPart = dir.listFiles(new Suffix(FileConfig.filePartSuffixKey));
		if (myPart.length != count - 1)
			throw new RuntimeException("碎片文件数目不正确！ 应为 " + (count - 1) + " 个");

		ArrayList<InputStream> al = new ArrayList<InputStream>();
		FileInputStream fis = null;
		for (int i = 1; i < count; i++) {
			// 从配置文件中找的该部分对应的文件名
			String partFilename = pro
					.getProperty(FileConfig.filePartNameKeyPrefix + i);
			fis = new FileInputStream(new File(dir, partFilename));
			al.add(fis);
		}
		// 创建枚举变量 来存取集合中的读入流。
		Enumeration<InputStream> en = Collections.enumeration(al);
		// 将枚举变量中的读取流，进行逻辑串联。
		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream(new File(outputDir,
				file_name));
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
	 * @param size
	 *            数组长度 可传入最大值为 (int最大值-1)/5
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
