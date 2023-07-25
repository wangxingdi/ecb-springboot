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

    SUCCESS("101", "操作成功"),
    FAIL("501", "操作失败，请稍后重试"),

    FAIL_VALIDATION("502", "入参校验失败"),
    FAIL_SECRET_KEY_IS_WRONG("503", "密钥错误，请重新输入"),

//    FAIL_OPEN_ID_IS_NULL("502", "缺少openId信息，请重新登录微信小程序"),
//    FAIL_LOGIN_CODE_IS_NULL("503", "缺少登录code信息，请重新登录微信小程序"),

    ;

    private String code;

    private String message;

}
