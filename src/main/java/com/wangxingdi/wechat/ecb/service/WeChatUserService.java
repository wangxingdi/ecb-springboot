package com.wangxingdi.wechat.ecb.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangxingdi.wechat.common.domain.Response;
import com.wangxingdi.wechat.ecb.dao.WeChatUserDAO;
import com.wangxingdi.wechat.ecb.domain.WeChatUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.MessageFormat;

/**
 * 用户相关
 * @author www.wangxingdi.com
 * @date 2023/7/17 19:53
 */
@Service
public class WeChatUserService {

    @Value("${wx.ecb.app.id}")
    private String appId;
    @Value("${wx.ecb.app.secret}")
    private String appSecret;

    @Value("${wx.sns.code2session.url}")
    private String url;

    @Resource
    private WeChatUserDAO weChatUserDAO;

    @Deprecated
    public int insert(WeChatUser weChatUser){
        return weChatUserDAO.insert(weChatUser);
    }

    @Deprecated
    public WeChatUser findByOpenId(WeChatUser weChatUser){
        return weChatUserDAO.findByOpenId(weChatUser);
    }

    public Response<WeChatUser> init(WeChatUser weChatUser) {
        String requestUrl = MessageFormat.format(url, appId, appSecret, weChatUser.getCode());
        String res = HttpUtil.get(requestUrl);
        JSONObject jsonObject = JSON.parseObject(res);
        weChatUser.setOpenId(jsonObject.getString("openid"));
        return Response.ofSuccess(weChatUser);
    }
}
