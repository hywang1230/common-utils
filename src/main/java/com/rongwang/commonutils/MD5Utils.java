package com.rongwang.commonutils;

import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * MD532位加密
 * @author rongwang
 *
 */
public class MD5Utils {
	private static Logger logger = Logger.getLogger(MD5Utils.class);
	
	public static String encrypt(String data) {
		if (StringUtils.isBlank(data)) {
			return StringUtils.EMPTY;
		}
		
		logger.debug(String.format("要加密的数据为%s", data));
		
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			logger.error("初始化MessageDigest异常", e);
			return StringUtils.EMPTY;
		}
		
		
		char[] charArray = data.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}
}
