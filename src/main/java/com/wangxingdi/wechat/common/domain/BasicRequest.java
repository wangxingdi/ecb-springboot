package com.wangxingdi.wechat.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础请求对象
 * @author www.wangxingdi.com
 * @date 2023/7/17 17:43
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasicRequest implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否启用
     */
    private Integer yn;
}
