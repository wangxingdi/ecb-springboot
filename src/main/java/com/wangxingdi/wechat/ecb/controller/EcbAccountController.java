package com.wangxingdi.wechat.ecb.controller;

import com.wangxingdi.wechat.annotation.Log;
import com.wangxingdi.wechat.common.domain.Page;
import com.wangxingdi.wechat.common.domain.Response;
import com.wangxingdi.wechat.common.domain.ValidationGroup;
import com.wangxingdi.wechat.ecb.domain.EcbAccount;
import com.wangxingdi.wechat.ecb.service.EcbAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 账户相关
 * @author www.wangxingdi.com
 * @date 2023/7/19 18:23
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class EcbAccountController {

    @Resource
    private EcbAccountService ecbAccountService;

    @Log
    @PostMapping("/insert")
    public Response<EcbAccount> insert(@Validated(ValidationGroup.Create.class) @RequestBody EcbAccount ecbAccount) {
        return ecbAccountService.insert(ecbAccount);
    }

    @Log
    @PostMapping("/delete")
    public Response<EcbAccount> delete(@Validated(ValidationGroup.Delete.class) @RequestBody EcbAccount ecbAccount){
        return ecbAccountService.delete(ecbAccount);
    }

    @Log
    @PostMapping("/update")
    public Response<EcbAccount> update(@Validated(ValidationGroup.Update.class) @RequestBody EcbAccount ecbAccount){
        return ecbAccountService.update(ecbAccount);
    }

    @Log
    @PostMapping("/page")
    public Page<EcbAccount> page(@Validated(ValidationGroup.Page.class) @RequestBody EcbAccount ecbAccount, @RequestBody Page page){
        page.setPageStart((page.getPageNum() - 1) * page.getPageSize());
        return ecbAccountService.page(ecbAccount, page);
    }

    @Log
    @PostMapping("/findByAsId")
    public Response<EcbAccount> findByAsId(@Validated(ValidationGroup.Query.class) @RequestBody EcbAccount ecbAccount){
        return ecbAccountService.findByAsId(ecbAccount);
    }
}
