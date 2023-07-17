package com.wangxingdi.wechat.ecb.domain;

import com.wangxingdi.wechat.common.BasicRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String username;
}
