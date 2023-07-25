package com.wangxingdi.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型
 * @author www.wangxingdi.com
 * @date 2023/7/18 20:31
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnums {

    ECB("ecb", "电子密码本"),
    ;

    private String code;

    private String desc;

}
