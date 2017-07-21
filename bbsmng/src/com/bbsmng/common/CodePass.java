package com.bbsmng.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CodePass {
	private static final String fix[] = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f"
			.split(",");

	public static String encodePass(String pass) {
		if (pass == null || "".equals(pass)) {
			return "";
		}
		byte[] b1 = pass.getBytes();
		StringBuffer rst = new StringBuffer();
		try {
			MessageDigest md = null;
			md = MessageDigest.getInstance("MD5");
			byte[] b2 = md.digest(b1);
			for (int i = 0; i < b2.length; i++) {
				int t = b2[i];
				t = t < 0 ? t + 256 : t;
				int t1 = t / 16;
				int t2 = t % 16;
				rst.append(fix[t1] + fix[t2]);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return rst.toString();
	}
}
