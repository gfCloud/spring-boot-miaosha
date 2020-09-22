package com.qixin.until;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Until {

	private static final String salt = "1a2c3b4d";

	public static String md5(String src) {
		return DigestUtils.md2Hex(src);
	}

	public static String inputpassToFromPass(String inputPass) {
		String str = "" + salt.charAt(0) + salt.charAt(1) + inputPass + salt.charAt(3) + salt.charAt(5);
		return md5(str);
	}
	
	public static String formpassToDBPass(String FormPass,String salt) {
		String str = "" + salt.charAt(0) + salt.charAt(1) + FormPass + salt.charAt(3) + salt.charAt(5);
		return md5(str);
	}
	
	public static String inputPassToDBPass(String input,String saltDB){
		String frompass = inputpassToFromPass(input);
		System.out.println(frompass);
		String DBpass = formpassToDBPass(frompass,saltDB);
		return DBpass;
	}
	
	/*public static void main(String[] args) {
		System.out.println(inputPassToDBPass("123456","1a2c3b4d"));
	}*/

}
