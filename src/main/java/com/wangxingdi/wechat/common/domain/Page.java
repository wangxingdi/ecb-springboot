package com.wangxingdi.wechat.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 分页对象
 * @author www.wangxingdi.com
 * @date 2023/7/19 20:03
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {

    /**
     * 当前页码
     */
    private int pageNum = 1;

    /**
     * 页大小
     */
    private int pageSize = 10;

    /**
     * 分页起始索引
     */
    private int pageStart = 0;

    /**
     * 总条数
     */
    private int total;

    /**
     * 当页数据
     */
    private List<T> data;

}
