package com.haibing.mvvm.utils;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description sha256签名算法
 * @Author 王小军
 * @CreateTime 2024年05月27日
 **/

public class SHA256Utils {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, SHA256Utils.class.getSimpleName());


    public static String getSHA256StrFromHexString(String hexString) {

        LogUtils.d(TAG, StringUtils.concat("hex = ", hexString));

        byte[] byteArray = new BigInteger(hexString, 16).toByteArray();
        for(byte b : byteArray) {
            LogUtils.d(TAG, StringUtils.concat("byte = ", String.valueOf(b)));
        }

        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(byteArray);
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        LogUtils.d(TAG, StringUtils.concat("getSHA256Str src: ", hexString, " target: ", encodeStr));
        return encodeStr;
    }

    public static String getSHA256Str(long userId) {

        String hex = Long.toHexString(userId);
        LogUtils.d(TAG, StringUtils.concat("hex = ", hex));

        byte[] byteArray = new BigInteger(hex, 16).toByteArray();
        for(byte b : byteArray) {
            LogUtils.d(TAG, StringUtils.concat("byte = ", String.valueOf(b)));
        }

        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(byteArray);
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        LogUtils.d(TAG, StringUtils.concat("getSHA256Str src: ", String.valueOf(userId), " target: ", encodeStr));
        return encodeStr;
    }

    /**
     * 加密
     * @param str 加密前报文
     * @return 加密后报文
     */
    public static String getSHA256Str(String str) {

        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        LogUtils.d(TAG, StringUtils.concat("getSHA256Str src: ", str, " target: ", encodeStr));
        return encodeStr;
    }
    /**
     * 二行制转字符串
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (Integer i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1 得到一位的进行补 0 操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}
