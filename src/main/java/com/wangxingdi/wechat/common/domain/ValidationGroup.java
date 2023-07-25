package com.wangxingdi.wechat.common.domain;

import javax.validation.groups.Default;

/**
 * 分组校验
 * @author www.wangxingdi.com
 * @date 2023/7/25 14:20
 */
public interface ValidationGroup {

    interface Create extends Default {}

    interface Delete extends Default {}

    interface Update extends Default {}

    interface Init extends Default {}

    interface Page extends Default {}

    interface Query extends Default {}
}
