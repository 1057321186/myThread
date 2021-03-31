package com.project.util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * AES加密组件
 */
//@Slf4j
public final class AESUtil {

    private static final String KEY_AES = "AES";
    public static final String ALGORITHM = "AES/ECB/PKCS7Padding";

    /**
     * 加密
     * @param src 明文
     * @param key 加密秘钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String src, String key) throws Exception {
        if (key == null || key.length() != 16) {
            throw new Exception("key不满足条件,长度必须是16位");
        }
        byte[] raw = key.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        String iv = "aabbccddeeffgghh"; //初始化向量参数，AES 为16bytes. DES 为8bytes.
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec,ivSpec);
        byte[] encrypted = cipher.doFinal(src.getBytes());
        return StringUtil.byte2hex(encrypted);
    }

    /**
     * 解密
     * @param src 密文
     * @param key 解密秘钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String src, String key) throws Exception {
        if (key == null || key.length() != 16) {
            throw new Exception("key不满足条件,长度必须是16位");
        }
        byte[] raw = key.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_AES);
        Cipher cipher = Cipher.getInstance(KEY_AES);
        String iv = "aabbccddeeffgghh"; //初始化向量参数，AES 为16bytes. DES 为8bytes.
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec,ivSpec);
        byte[] encrypted1 = StringUtil.hex2byte(src);
        byte[] original = cipher.doFinal(encrypted1);
        String originalString = new String(original);
        return originalString;
    }

    /**
     * 微信退款通知，解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String decode(String data,String key) {
        try {
            byte[] bytes = Base64.decodeBase64(data.getBytes());
            String md5Key = MD5Util.encodeMD5Hex(key).toLowerCase();
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKey keySpec = new SecretKeySpec(md5Key.getBytes(), "AES"); //生成加密解密需要的Key
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decoded = cipher.doFinal(bytes);
            String  result = new String(decoded, "UTF-8");
            return result;
        } catch (Exception e) {
//            log.error("AES解密异常",e);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String key = "cdboost123456789";
        // 加密
        String encrypt = encrypt("admin", key);
        System.out.println(encrypt);

        // 解密
        String decrypt = decrypt(encrypt, key);
        System.out.println(decrypt);
    }
}