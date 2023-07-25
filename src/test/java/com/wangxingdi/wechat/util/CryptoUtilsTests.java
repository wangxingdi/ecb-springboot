package com.wangxingdi.wechat.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试类
 * @author www.wangxingdi.com
 * @date 2023/7/24 16:28
 */
@SpringBootTest
public class CryptoUtilsTests {

    @Test
    public void testEncrypt(){
        Integer key = 123456;
        String value = "123456";
        String encrypt = CryptoUtils.encrypt(key, value);
        System.out.println("encrypt=" + encrypt);
    }

    @Test
    public void testDecrypt(){
        Integer key = 123456;
        String decrypt = CryptoUtils.decrypt(key, "6e8e06ac14c101328cf67dfbedf388ceb9b05e39fda5f336462b3812fee6d007c64e71895fac3164a1baa16e1e9e3880a982df3ce6b98fc30f2e48f0d5e5fd70");
        System.out.println("decrypt=" + decrypt);
    }
}
