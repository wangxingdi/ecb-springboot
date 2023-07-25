package com.wangxingdi.wechat.ecb.dao;

import com.wangxingdi.wechat.ecb.domain.WeChatUser;

/**
 * 用户相关
 * @author www.wangxingdi.com
 * @date 2023/7/17 19:55
 */
public interface WeChatUserDAO {

    /**
     * 新增
     * @param weChatUser
     * @return
     */
    int insert(WeChatUser weChatUser);

    /**
     * 根据openId查询
     * @param weChatUser
     * @return
     */
    WeChatUser findByOpenId(WeChatUser weChatUser);
}
