package com.wangxingdi.wechat.ecb.domain;

import com.wangxingdi.wechat.common.domain.BasicRequest;
import com.wangxingdi.wechat.common.domain.ValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 用户信息
 * @author www.wangxingdi.com
 * @date 2023/7/17 17:41
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeChatUser extends BasicRequest implements Serializable {

    /**
     * openId
     */
    private String openId;

    /**
     * 角色
     * see com.wangxingdi.wechat.common.enums.UserRoleEnums
     */
    private String userRole;

    /**
     * 账户类型
     * see com.wangxingdi.wechat.common.enums.UserTypeEnums
     */
    private String userType;

    /**
     * 加密令牌
     */
    private String encryptToken;

    /**
     * wx.login得到的code
     */
    @NotBlank(message = "缺少必要的code信息，请重新启动小程序", groups = ValidationGroup.Init.class)
    private String code;
}
