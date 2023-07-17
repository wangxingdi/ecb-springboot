package com.wangxingdi.wechat.ecb.service;

import com.wangxingdi.wechat.ecb.dao.WeChatUserDAO;
import com.wangxingdi.wechat.ecb.domain.WeChatUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author www.wangxingdi.com
 * @date 2023/7/17 19:53
 */
@Service
public class WeChatUserService {

    @Resource
    private WeChatUserDAO weChatUserDAO;

    public int insert(WeChatUser weChatUser){
        return weChatUserDAO.insert(weChatUser);
    }

    public WeChatUser findById(WeChatUser weChatUser){
        return weChatUserDAO.findById(weChatUser);
    }

}
