package cn.szh.java.basic.szh;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * MD5 算法
*/
public class MD5 {
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式只为数字
	@SuppressWarnings("unused")
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	// 转换字节数组为16进制字串
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	public static String GetMD5Code(String strObj) {
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	public static void main(String[] args) {
		String string = GetMD5Code("shyadmin");
		String string2 = GetMD5Code("shyadmin");
		System.out.println(string);
		System.out.println(string2);
		if(string.equals(string2)){
			System.out.println(11111);
		}

		String pwd = "shyadmin";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");// 生成一个MD5加密计算摘要
			md.update(pwd.getBytes());// 计算md5函数
			/**
			 * digest()最后确定返回md5 hash值，返回值为8位字符串。
			 * 因为md5 hash值是16位的hex值，实际上就是8位的字符
			 * BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			 * 一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
			 */
			String hashedPwd = new BigInteger(1, md.digest()).toString(16);// 16是表示转换为16进制数
			System.out.println(hashedPwd);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}
