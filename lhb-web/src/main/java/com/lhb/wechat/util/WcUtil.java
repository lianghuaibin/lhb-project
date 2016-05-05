package com.lhb.wechat.util;


import com.lhb.common.util.LogUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class WcUtil {

	/**
	 * 检查微信签名
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce,String myToken){
		String[] arr = new String[]{myToken,timestamp,nonce};
		Arrays.sort(arr);//排序
		//生成字符串
		StringBuffer content = new StringBuffer();
		for(String str: arr){
			content.append(str);
		}
		String temp = SHA1(content.toString());
        LogUtil.paramAndResult("-检查微信签名-", "signature：" + signature, temp);
		return temp.equals(signature);
	}
	/**
	 * sha1 加密
	 * @param decript
	 * @return
	 */
	public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String token="hhU3HpFlldKLrdAeW6X6TF3IX0JhsKq99CxHTsoUOsggPreVwJPJ4OAmVRmYta_VQs6HcGP-9_LPPnMC0l7gK5TvDTL3ot5EBVQr6v5WLUoGGOcAJAZZH";
       /* String[] arr = new String[]{token,"1447429446","523875627"};
        Arrays.sort(arr);//排序
        //生成字符串
        StringBuffer content = new StringBuffer();
        for(String str: arr){
            content.append(str);
        }
        String temp = SHA1(content.toString());*/
        System.out.println(SHA1(token));
    }

}
