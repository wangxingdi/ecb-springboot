package com.wangxingdi.wechat.ecb.dao;

import com.wangxingdi.wechat.ecb.domain.WeChatUser;

/**
 * @author www.wangxingdi.com
 * @date 2023/7/17 19:55
 */
public interface WeChatUserDAO {

    int insert(WeChatUser weChatUser);

    WeChatUser findById(WeChatUser weChatUser);
}
