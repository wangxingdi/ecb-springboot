package com.wangxingdi.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应枚举
 * @author www.wangxingdi.com
 * @date 2023/7/25 12:26
 */
@Getter
@AllArgsConstructor
public enum ResponseEnums {

    SUCCESS("1", "操作成功"),
    FAIL("0", "系统开了个小差，请稍后重试"),

    FAIL_VALIDATION("500", "入参校验失败"),
    FAIL_SECRET_KEY_IS_WRONG("501", "密钥错误，请重新输入"),

    ;

    private String code;

    private String message;

}
