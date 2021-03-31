package com.project.util;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密工具
 */
public class MD5Util {
    public static void main(String[] args) {
        String str = "B85CCC0B83B46972C6B63D39265D9E42";
        System.out.println(str.length());

//        String str = "fanlvyu";
        String s = encodeMD5Hex(str);
        System.out.println(s);
    }

    /**
     * MD5加密
     * @param data 待加密数据
     * @return byte[] 消息摘要
     * @throws Exception
     */
    public static byte[] encodeMD5(String data) {

        // 执行消息摘要
        return DigestUtils.md5(data);
    }

    /**
     * MD5加密
     * @param data 待加密数据
     * @return 消息摘要
     */
    public static String encodeMD5Hex(String data) {
        // 执行消息摘要
        return DigestUtils.md5Hex(data);
    }

}
