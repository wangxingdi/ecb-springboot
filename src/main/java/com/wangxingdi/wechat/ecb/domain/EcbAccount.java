package com.wangxingdi.wechat.ecb.domain;

import com.wangxingdi.wechat.common.domain.BasicRequest;
import com.wangxingdi.wechat.common.domain.ValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 账户对象
 * @author www.wangxingdi.com
 * @date 2023/7/19 18:26
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EcbAccount extends BasicRequest implements Serializable {

    /**
     * 对外展示账户id
     */
    @NotBlank(message = "缺少必要的唯一标识，请重新启动小程序", groups = {ValidationGroup.Query.class, ValidationGroup.Update.class, ValidationGroup.Delete.class})
    private String asId;

    /**
     * openId
     */
    @NotBlank(message = "缺少必要的openId信息，请重新启动小程序",
            groups = {ValidationGroup.Page.class, ValidationGroup.Query.class, ValidationGroup.Create.class, ValidationGroup.Update.class, ValidationGroup.Delete.class})
    private String openId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 应用名称
     */
    @NotBlank(message = "请输入应用名称", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    private String appName;

    /**
     * 用户名
     */
    @NotBlank(message = "请输入用户名", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "请输入密码", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    private String password;

    /**
     * 备注
     */
    private String remark;

    /**
     * 密钥
     */
    @NotNull(message = "缺少必要的secretKey信息，请重新启动小程序",
            groups = {ValidationGroup.Query.class, ValidationGroup.Create.class, ValidationGroup.Update.class})
    private Integer secretKey;
}
