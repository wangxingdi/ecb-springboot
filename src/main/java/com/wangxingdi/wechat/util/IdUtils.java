package com.wangxingdi.wechat.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * id工具类
 * @author www.wangxingdi.com
 * @date 2023/7/24 17:05
 */
public class IdUtils {

    private static String MODULE_ECB = "ECB";

    private static AtomicInteger seed = new AtomicInteger(13);

    /**
     * 生成有序的id
     * @return
     */
    public static String generateOrderedId(String module){
        StringBuilder sb = new StringBuilder(module);
        sb.append(System.currentTimeMillis());
        int seq = seed.getAndAdd(3) % 1000;
        sb.append(String.format("%03d", seq));
        return sb.toString();
    }

    public static String generateOrderedId(){
        return generateOrderedId(MODULE_ECB);
    }
}
