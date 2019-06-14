package com.heygis.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密Util
 */
public class EncodeUtil {

    private static BASE64Encoder encoder = new BASE64Encoder();
    private static BASE64Decoder decoder = new BASE64Decoder();

    /**
     * 将byte[]使用Base64编码
     * @param bytes
     * @return
     */
    public static String encoderByBase64(byte[] bytes) {
        String base64Str = encoder.encode(bytes);
        return base64Str;
    }

    /**
     * 将字符串解码Base64编码的byte[]
     * @param str
     * @return
     */
    public static byte[] dncoderByBase64(String str) throws IOException {
        byte[] bytes = decoder.decodeBuffer(str);
        return bytes;
    }

    /**
     * 字符串MD5 加密后再把所得的Byte[]使用Base64编码
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encoderByMd5AndBase64(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //加密后的字符串Base64编码
        String newstr = encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}
