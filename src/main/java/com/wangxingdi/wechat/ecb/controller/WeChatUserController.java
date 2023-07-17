package com.wangxingdi.wechat.ecb.controller;

import com.wangxingdi.wechat.ecb.domain.WeChatUser;
import com.wangxingdi.wechat.ecb.service.WeChatUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author www.wangxingdi.com
 * @date 2023/7/17 17:46
 */
@RestController
public class WeChatUserController {

    @Resource
    private WeChatUserService weChatUserService;

    @GetMapping(value = "/test")
    public String test(){
        return "hi, test";
    }

    @RequestMapping(value = "/insert")
    public Integer insert(@RequestBody WeChatUser weChatUser){
        return weChatUserService.insert(weChatUser);
    }

    @RequestMapping(value = "findById")
    public WeChatUser findById(@RequestBody WeChatUser weChatUser){
        return weChatUserService.findById(weChatUser);
    }

}
