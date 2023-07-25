package com.wangxingdi.wechat.ecb.service;

import com.wangxingdi.wechat.common.domain.Page;
import com.wangxingdi.wechat.common.domain.Response;
import com.wangxingdi.wechat.common.enums.ResponseEnums;
import com.wangxingdi.wechat.common.enums.UserRoleEnums;
import com.wangxingdi.wechat.common.enums.UserTypeEnums;
import com.wangxingdi.wechat.ecb.dao.EcbAccountDAO;
import com.wangxingdi.wechat.ecb.dao.WeChatUserDAO;
import com.wangxingdi.wechat.ecb.domain.EcbAccount;
import com.wangxingdi.wechat.ecb.domain.WeChatUser;
import com.wangxingdi.wechat.util.CryptoUtils;
import com.wangxingdi.wechat.util.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 账户相关
 * @author www.wangxingdi.com
 * @date 2023/7/19 18:25
 */
@Slf4j
@Service
public class EcbAccountService {

    @Resource
    private WeChatUserDAO weChatUserDAO;
    @Resource
    private EcbAccountDAO ecbAccountDAO;

    public Response<EcbAccount> insert(EcbAccount ecbAccount) {
        Response<EcbAccount> response = getAndAddWeChatUser(ecbAccount);
        if(response.isFail()){
            return response;
        }
        ecbAccount.setUserId(response.getData().getUserId());
        String encrypt = CryptoUtils.encrypt(ecbAccount.getSecretKey(), ecbAccount.getPassword());
        ecbAccount.setPassword(encrypt);
        ecbAccount.setAsId(IdUtils.generateOrderedId());
        ecbAccountDAO.insert(ecbAccount);
        return Response.ofSuccess(ecbAccount);
    }

    private Response<EcbAccount> getAndAddWeChatUser(EcbAccount ecbAccount) {
        WeChatUser param = new WeChatUser();
        param.setOpenId(ecbAccount.getOpenId());
        WeChatUser weChatUser = weChatUserDAO.findByOpenId(param);
        String encryptToken = CryptoUtils.encrypt(ecbAccount.getSecretKey(), ecbAccount.getOpenId());
        if(Objects.isNull(weChatUser)){
            weChatUser = new WeChatUser(ecbAccount.getOpenId(), UserRoleEnums.ADMIN.getCode(), UserTypeEnums.ECB.getCode(), encryptToken, null);
            weChatUserDAO.insert(weChatUser);
        }else{
            if(!Objects.equals(encryptToken, weChatUser.getEncryptToken())){
                return Response.ofFail(ResponseEnums.FAIL_SECRET_KEY_IS_WRONG);
            }
        }
        EcbAccount account = new EcbAccount();
        account.setUserId(weChatUser.getId());
        return Response.ofSuccess(account);
    }

    public Response<EcbAccount> delete(EcbAccount ecbAccount){
        WeChatUser param = new WeChatUser();
        param.setOpenId(ecbAccount.getOpenId());
        WeChatUser weChatUser = weChatUserDAO.findByOpenId(param);
        if(Objects.isNull(weChatUser)){
            return Response.ofFail();
        }
        ecbAccount.setUserId(weChatUser.getId());
        int delete = ecbAccountDAO.delete(ecbAccount);
        return Response.ofSuccess(ecbAccount);
    }

    public Response<EcbAccount> update(EcbAccount ecbAccount){
        WeChatUser param = new WeChatUser();
        param.setOpenId(ecbAccount.getOpenId());
        WeChatUser weChatUser = weChatUserDAO.findByOpenId(param);
        if(Objects.isNull(weChatUser)){
            return Response.ofFail();
        }
        String encrypt = CryptoUtils.encrypt(ecbAccount.getSecretKey(), ecbAccount.getOpenId());
        if(!Objects.equals(encrypt, weChatUser.getEncryptToken())){
            return Response.ofFail(ResponseEnums.FAIL_SECRET_KEY_IS_WRONG);
        }
        ecbAccount.setUserId(weChatUser.getId());
        ecbAccount.setPassword(CryptoUtils.encrypt(ecbAccount.getSecretKey(), ecbAccount.getPassword()));
        int update = ecbAccountDAO.update(ecbAccount);
        return Response.ofSuccess(ecbAccount);
    }

    @Transactional(readOnly = true)
    public Page<EcbAccount> page(EcbAccount ecbAccount, Page page) {
        WeChatUser user = new WeChatUser();
        user.setOpenId(ecbAccount.getOpenId());
        WeChatUser weChatUser = weChatUserDAO.findByOpenId(user);
        if(Objects.isNull(weChatUser) || Objects.isNull(weChatUser.getId())){
            return page;
        }
        ecbAccount.setUserId(weChatUser.getId());
        if(StringUtils.isNotBlank(ecbAccount.getAppName())){
            ecbAccount.setAppName("%" + ecbAccount.getAppName() + "%");
        }
        List<EcbAccount> list = ecbAccountDAO.list(ecbAccount, page);
        int count = ecbAccountDAO.count(ecbAccount);
        page.setData(list);
        page.setTotal(count);
        return page;
    }


    public Response<EcbAccount> findByAsId(EcbAccount ecbAccount) {
        EcbAccount account = ecbAccountDAO.findByAsId(ecbAccount);
        if(Objects.isNull(account) || StringUtils.isBlank(account.getPassword())){
            return Response.ofFail(ResponseEnums.FAIL);
        }
        String decrypt = CryptoUtils.decrypt(ecbAccount.getSecretKey(), account.getPassword());
        if(StringUtils.isBlank(decrypt)){
            return Response.ofFail(ResponseEnums.FAIL_SECRET_KEY_IS_WRONG);
        }
        account.setPassword(decrypt);
        return Response.ofSuccess(account);
    }
}
