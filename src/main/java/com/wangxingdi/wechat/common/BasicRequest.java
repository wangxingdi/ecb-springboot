package com.wangxingdi.wechat.common;

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

    private Integer id;

    private Date createTime;

    private Date updateTime;

    private boolean yn;
}
