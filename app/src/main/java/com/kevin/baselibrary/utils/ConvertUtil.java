package com.kevin.baselibrary.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import android.util.Base64;

/**
 * 功能：转码工具
 * 
 * @author qianjunping
 */
public class ConvertUtil {
	private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
			.toCharArray();
	/**
	 * 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块
	 */
	public static final String US_ASCII = "US-ASCII";
	/**
	 * ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1
	 */
	public static final String ISO_8859_1 = "ISO-8859-1";
	/**
	 * 8 位 UCS 转换格式
	 */
	public static final String UTF_8 = "UTF-8";
	/**
	 * 16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序
	 */
	public static final String UTF_16BE = "UTF-16BE";
	/**
	 * 16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序
	 */
	public static final String UTF_16LE = "UTF-16LE";
	/**
	 * 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识
	 */
	public static final String UTF_16 = "UTF-16";
	/**
	 * 中文超大字符集
	 */
	public static final String GBK = "GBK";

	/**
	 * 将字符编码转换成US-ASCII码
	 */
	public static String convertToASCII(String str)
			throws UnsupportedEncodingException {
		return convertCharset(str, US_ASCII);
	}

	/**
	 * 将字符编码转换成ISO-8859-1码
	 */
	public static String convertToISO_8859_1(String str)
			throws UnsupportedEncodingException {
		return convertCharset(str, ISO_8859_1);
	}

	/**
	 * 将字符编码转换成UTF-8码
	 */
	public static String convertToUTF_8(String str)
			throws UnsupportedEncodingException {
		return convertCharset(str, UTF_8);
	}

	/**
	 * 将字符编码转换成UTF-16BE码
	 */
	public static String convertToUTF_16BE(String str)
			throws UnsupportedEncodingException {
		return convertCharset(str, UTF_16BE);
	}

	/**
	 * 将字符编码转换成UTF-16LE码
	 */
	public static String convertToUTF_16LE(String str)
			throws UnsupportedEncodingException {
		return convertCharset(str, UTF_16LE);
	}

	/**
	 * 将字符编码转换成UTF-16码
	 */
	public static String convertToUTF_16(String str)
			throws UnsupportedEncodingException {
		return convertCharset(str, UTF_16);
	}

	/**
	 * 将字符编码转换成GBK码
	 */
	public static String convertToGBK(String str)
			throws UnsupportedEncodingException {
		return convertCharset(str, GBK);
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换编码的字符串
	 * @param newCharset
	 *            目标编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String convertCharset(String str, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// 用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换编码的字符串
	 * @param oldCharset
	 *            原编码
	 * @param newCharset
	 *            目标编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String convertCharset(String str, String oldCharset,
			String newCharset) throws UnsupportedEncodingException {
		if (str != null) {
			// 用旧的字符编码解码字符串。解码可能会出现异常。
			byte[] bs = str.getBytes(oldCharset);
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * 输入流转字符串
	 * 
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	/**
	 * 半角转换成全角
	 * 
	 * @param input
	 * @return
	 */
	public static String convertSBC(String input) {
		// 半角转全角
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 32) {
				c[i] = (char) 12288;
				continue;
			}
			if (c[i] < 127)
				c[i] = (char) (c[i] + 65248);
		}
		return new String(c);
	}

	/**
	 * 全角转换成半角
	 * 
	 * @param input
	 * @return
	 */
	public static String convertDBC(String input) {
		// 全角转 半角
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	/**
	 * Hex编码.
	 */
	public static String convertEncodeHex(byte[] input) {
		String stmp = "";
		StringBuilder sb = new StringBuilder("");
		for (int n = 0; n < input.length; n++) {
			stmp = Integer.toHexString(input[n] & 0xFF);
			sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
		}
		return sb.toString().trim();
	}

	/**
	 * Hex解码.
	 */
	public static byte[] convertDecodeHex(String input) {
		char[] data = input.toCharArray();
		int len = data.length;
		if ((len & 0x01) != 0) {
			throw new RuntimeException("Odd number of characters.");
		}
		byte[] out = new byte[len >> 1];
		// two characters form the hex value.
		for (int i = 0, j = 0; j < len; i++) {
			int f = toDigit(data[j], j) << 4;
			j++;
			f = f | toDigit(data[j], j);
			j++;
			out[i] = (byte) (f & 0xFF);
		}
		return out;
	}

	/**
	 * Base64编码.
	 */
	public static String convertEncodeBase64(byte[] input) {
		return Base64.encodeToString(input, Base64.NO_WRAP);
	}

	/**
	 * Base64编码, URL安全(将Base64中的URL非法字符'+'和'/'转为'-'和'_', 见RFC3548).
	 */
	public static String convertEncodeUrlSafeBase64(byte[] input) {
		return Base64.encodeToString(input, Base64.URL_SAFE);
	}

	/**
	 * Base64解码.
	 */
	public static byte[] convertDecodeBase64(String input) {
		return Base64.decode(input, Base64.NO_WRAP);
	}

	/**
	 * Base62编码。
	 */
	public static String convertEncodeBase62(byte[] input) {
		char[] chars = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			chars[i] = BASE62[((input[i] & 0xFF) % BASE62.length)];
		}
		return new String(chars);
	}

	private static int toDigit(char data, int index) {
		int digit = Character.digit(data, 16);
		if (digit == -1) {
			throw new RuntimeException("Illegal hexadecimal character " + data
					+ " at index " + index);
		}
		return digit;
	}

}
