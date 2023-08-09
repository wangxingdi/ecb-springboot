package com.wangxingdi.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户角色
 * @author www.wangxingdi.com
 * @date 2023/7/21 11:11
 */
@Getter
@AllArgsConstructor
public enum UserRoleEnums {

    ADMIN("admin", "管理员"),
    USER("user", "用户"),
    ;

    private String code;

    private String desc;

}
