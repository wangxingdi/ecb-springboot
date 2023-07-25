package com.wangxingdi.wechat.ecb.controller;

import com.wangxingdi.wechat.annotation.Log;
import com.wangxingdi.wechat.common.domain.Response;
import com.wangxingdi.wechat.common.domain.ValidationGroup;
import com.wangxingdi.wechat.ecb.domain.WeChatUser;
import com.wangxingdi.wechat.ecb.service.WeChatUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户相关
 * @author www.wangxingdi.com
 * @date 2023/7/17 17:46
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class WeChatUserController {

    @Resource
    private WeChatUserService weChatUserService;

    /**
     * 小程序数据初始化
     * @param weChatUser
     * @return
     */
    @Log
    @RequestMapping(value= "/init")
    public Response<WeChatUser> init(@Validated(ValidationGroup.Init.class) @RequestBody WeChatUser weChatUser){
        return weChatUserService.init(weChatUser);
    }

    /**
     * 新增
     * @param weChatUser
     * @return
     */
    @Deprecated
    @RequestMapping(value = "/insert")
    public Integer insert(@RequestBody WeChatUser weChatUser){
        return weChatUserService.insert(weChatUser);
    }

    /**
     * 根据openId进行唯一查询
     * @param weChatUser
     * @return
     */
    @Deprecated
    @RequestMapping(value = "/findByOpenId")
    public WeChatUser findByOpenId(@RequestBody WeChatUser weChatUser){
        return weChatUserService.findByOpenId(weChatUser);
    }

}
