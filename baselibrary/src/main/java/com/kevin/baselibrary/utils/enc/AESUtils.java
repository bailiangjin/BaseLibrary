package com.kevin.baselibrary.utils.enc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密解密工具包
 * 
 */
public class AESUtils {

	private static final String ALGORITHM = "AES";
	private static final int KEY_SIZE = 128;
	private static final int CACHE_SIZE = 1024;
	/**
	 * 默认密码
	 */
	private static String defaultSeed = "testkey";
	
	

	

	public static String getDefaultSeed() {
		return defaultSeed;
	}

	public static void setDefaultSeed(String defaultSeed) {
		AESUtils.defaultSeed = defaultSeed;
	}

	/**
	 * 加密字符串 使用默认密码
	 * 
	 * @param source
	 *            字符串
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public static String encrypt(String source) throws Exception {
		return encrypt(source, getSecretKey(defaultSeed));
	}

	/**
	 * 解密字符串 使用默认密钥
	 * 
	 * @param source
	 *            加密后的字符串
	 * @param key
	 *            密钥
	 * @return 解密后的字符串
	 * @throws Exception
	 */
	public static String decrypt(String source) throws Exception {
		return decrypt(source, getSecretKey(defaultSeed));
	}

	/**
	 * 加密字符串
	 * 
	 * @param source
	 *            未加密字符串
	 * @param key
	 *            密钥
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public static String encrypt(String source, String key) throws Exception {

		if (null == source || source.length() == 0) {
			return null;
		}
		byte[] inputData = source.getBytes();
		inputData = AESUtils.encrypt(inputData, key);
		return Base64Utils.encode(inputData);
	}

	/**
	 * 解密字符串
	 * 
	 * @param source
	 *            已经加密的字符串
	 * @param key
	 *            密钥
	 * @return 解密后的字符串
	 * @throws Exception
	 */
	public static String decrypt(String source, String key) throws Exception {
		if (null == source || source.length() == 0) {
			return null;
		}

		byte[] inputData = Base64Utils.decode(source);
		byte[] outputData = decrypt(inputData, key);
		return new String(outputData);
	}

	/**
	 * 加密文件 使用默认密码
	 * 
	 * @param sourceFilePath
	 * @param destFilePath
	 * @throws Exception
	 */
	public static void encryptFile(String sourceFilePath, String destFilePath)
			throws Exception {
		encryptFile(getSecretKey(defaultSeed), sourceFilePath, destFilePath);
	}

	/**
	 * 解密文件 使用默认密码
	 * 
	 * @param sourceFilePath
	 * @param destFilePath
	 * @throws Exception
	 */
	public static void decryptFile(String sourceFilePath, String destFilePath)
			throws Exception {
		decryptFile(getSecretKey(defaultSeed), sourceFilePath, destFilePath);
	}

	/**
	 * 文件加密
	 * 
	 * @param key
	 * @param sourceFilePath
	 * @param destFilePath
	 * @throws Exception
	 */
	public static void encryptFile(String key, String sourceFilePath,
			String destFilePath) throws Exception {
		File sourceFile = new File(sourceFilePath);
		File destFile = new File(destFilePath);
		if (sourceFile.exists() && sourceFile.isFile()) {
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			destFile.createNewFile();
			InputStream in = new FileInputStream(sourceFile);
			OutputStream out = new FileOutputStream(destFile);
			Key k = toKey(Base64Utils.decode(key));
			byte[] raw = k.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			CipherInputStream cin = new CipherInputStream(in, cipher);
			byte[] cache = new byte[CACHE_SIZE];
			int nRead = 0;
			while ((nRead = cin.read(cache)) != -1) {
				out.write(cache, 0, nRead);
				out.flush();
			}
			out.close();
			cin.close();
			in.close();
		}
	}

	/**
	 * 文件解密
	 * 
	 * @param key
	 * @param sourceFilePath
	 * @param destFilePath
	 * @throws Exception
	 */
	public static void decryptFile(String key, String sourceFilePath,
			String destFilePath) throws Exception {
		File sourceFile = new File(sourceFilePath);
		File destFile = new File(destFilePath);
		if (sourceFile.exists() && sourceFile.isFile()) {
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			destFile.createNewFile();
			FileInputStream in = new FileInputStream(sourceFile);
			FileOutputStream out = new FileOutputStream(destFile);
			Key k = toKey(Base64Utils.decode(key));
			byte[] raw = k.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			CipherOutputStream cout = new CipherOutputStream(out, cipher);
			byte[] cache = new byte[CACHE_SIZE];
			int nRead = 0;
			while ((nRead = in.read(cache)) != -1) {
				cout.write(cache, 0, nRead);
				cout.flush();
			}
			cout.close();
			out.close();
			in.close();
		}
	}

	/**
	 * 加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String key) throws Exception {
		Key k = toKey(Base64Utils.decode(key));
		byte[] raw = k.getEncoded();
		SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		return cipher.doFinal(data);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String key) throws Exception {
		Key k = toKey(Base64Utils.decode(key));
		byte[] raw = k.getEncoded();
		SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		return cipher.doFinal(data);
	}

	/**
	 * 生成随机密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getSecretKey() throws Exception {
		return getSecretKey(null);
	}

	/**
	 * 生成密钥
	 * 
	 * @param seed
	 *            密钥种子
	 * @return
	 * @throws Exception
	 */
	public static String getSecretKey(String seed) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);

		// SecureRandom secureRandom;
		// 废弃方法 Window上正常 在mac linux上会抛异常
		// secureRandom = new SecureRandom(seed.getBytes());

		// 防止unix系统随机生成key 造成解密时抛异常
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

		if (seed != null && !"".equals(seed)) {
			secureRandom.setSeed(seed.getBytes());
		} else {
			secureRandom.setSeed(null);
		}
		keyGenerator.init(KEY_SIZE, secureRandom);
		SecretKey secretKey = keyGenerator.generateKey();
		return Base64Utils.encode(secretKey.getEncoded());
	}

	/**
	 * 转换密钥
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		return secretKey;
	}

}
