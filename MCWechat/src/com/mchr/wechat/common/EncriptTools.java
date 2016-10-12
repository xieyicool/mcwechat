package com.mchr.wechat.common;

import java.security.MessageDigest;

public class EncriptTools {

	public static String md5(String src)
	{
		try {			
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(src.getBytes());
			byte[] dst = messageDigest.digest();
			return byteArrayToHexString(dst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sha(String src)
	{
		try {			
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.update(src.getBytes());
			byte[] dst = messageDigest.digest();
			return byteArrayToHexString(dst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String byteArrayToHexString(byte[] bytearray) {
		String strDigest = "";
		for (int i = 0; i < bytearray.length; i++) {
			strDigest += byteToHexString(bytearray[i]);
		}
		return strDigest.toLowerCase();
	}
	
	private static String byteToHexString(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}
	
}
