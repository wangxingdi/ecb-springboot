package com.wangxingdi.wechat.ecb.dao;

import com.wangxingdi.wechat.common.domain.Page;
import com.wangxingdi.wechat.ecb.domain.EcbAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 账户相关
 * @author www.wangxingdi.com
 * @date 2023/7/19 18:25
 */
public interface EcbAccountDAO {

    /**
     * 新增
     * @param ecbAccount
     * @return
     */
    int insert(EcbAccount ecbAccount);

    /**
     * 删除
     * @param ecbAccount
     * @return
     */
    int delete(EcbAccount ecbAccount);

    /**
     * 更新
     * @param ecbAccount
     * @return
     */
    int update(EcbAccount ecbAccount);

    /**
     * 分页查询
     * @param ecbAccount
     * @param page
     * @return
     */
    List<EcbAccount> list(@Param("ecbAccount") EcbAccount ecbAccount, @Param("page") Page page);

    /**
     * 总计查询
     * @param ecbAccount
     * @return
     */
    int count(EcbAccount ecbAccount);

    /**
     * 唯一查询
     * @param ecbAccount
     * @return
     */
    EcbAccount findByAsId(EcbAccount ecbAccount);
}
