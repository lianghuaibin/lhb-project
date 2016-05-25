package com.lhb.common.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

 private static String[] confusedString={"Y3iowymlv0MQ","c:oO*eks.iLrhmCay1:z_;K]$eBZdj:w,nJvg2B"};

 public static String md5Encrypt(String plainText) {
  StringBuffer buf = new StringBuffer("");
  try {
   plainText = confusedString[0]+plainText+confusedString[1];
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(plainText.getBytes());
    byte b[] = md.digest();

    int i;

    for (int offset = 0; offset < b.length; offset++) {
     i = b[offset];
      if (i < 0)
        i += 256;
      if (i < 16)
       buf.append("0");
      buf.append(Integer.toHexString(i));
    }
    //System.out.println("result: " + buf.toString());// 32位的加密
    //System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密
  } catch (NoSuchAlgorithmException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  return buf.toString();
 }

 public static void main(String agrs[]) {
  String ss="123456";
  String string3= MD5.md5Encrypt(ss);//加密4
  System.out.println(string3);
  string3 = MD5.md5Encrypt(string3);
  System.out.println(string3);
	 
 }

}