package com.wangxingdi.wechat.util;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.SM4;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import lombok.extern.slf4j.Slf4j;

/**
 * 加解密工具类
 * @author www.wangxingdi.com
 * @date 2023/7/24 11:28
 */
@Slf4j
public class CryptoUtils {

    private static byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    /**
     * 数字格式化-16位,不足左侧补0
     */
    private static final String INTEGER_FORMAT_16 = "%016d";

    public static SymmetricCrypto sm4(Integer key){
        return new SM4(Mode.CBC, Padding.PKCS5Padding, String.format(INTEGER_FORMAT_16, key).getBytes(), iv);
    }

    /**
     * 加密
     * @param key
     * @param value
     * @return
     */
    public static String encrypt(Integer key, String value){
        return sm4(key).encryptHex(value);
    }

    /**
     * 解密
     * @param key
     * @param value
     * @return
     */
    public static String decrypt(Integer key, String value){
        String result = null;
        try {
            result = sm4(key).decryptStr(value);
        }catch (Exception ex){
            log.error("com.wangxingdi.wechat.util.CryptoUtils.decrypt is exception, key={}, value={}, exception:", key, value, ex);
        }
        return result;
    }

}
