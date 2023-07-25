package com.wangxingdi.wechat.annotation;

import com.wangxingdi.wechat.common.enums.LogPositionEnum;

import java.lang.annotation.*;

/**
 * 日志打印
 * @author www.wangxingdi.com
 * @date 2023/7/25 14:59
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String name() default "";

    LogPositionEnum position() default LogPositionEnum.ALL;

    String beforeInvokeMessage() default "";

    String afterInvokeMessage() default "";
}
