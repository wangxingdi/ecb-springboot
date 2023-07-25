package com.wangxingdi.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 加密类型
 * @author www.wangxingdi.com
 * @date 2023/7/21 11:14
 */
@Getter
@AllArgsConstructor
public enum EncryptTypeEnums {

    SMS_4("sms4", "国密算法SMS4"),
    ;

    private String code;

    private String desc;
}
