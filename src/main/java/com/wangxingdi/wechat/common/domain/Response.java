package com.wangxingdi.wechat.common.domain;

import com.wangxingdi.wechat.common.enums.ResponseEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 响应对象
 * @author www.wangxingdi.com
 * @date 2023/7/25 11:30
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private String code;

    private String message;

    private T data;

    public static Response ofSuccess(Object  obj){
        return new Response(ResponseEnums.SUCCESS.getCode(), ResponseEnums.SUCCESS.getMessage(), obj);
    }

    public static Response ofSuccess(){
        return ofSuccess(null);
    }

    public static Response ofFail(){
        return ofFail(ResponseEnums.FAIL.getCode(), ResponseEnums.FAIL.getMessage());
    }

    public static Response ofFail(ResponseEnums em){
        return ofFail(em.getCode(), em.getMessage());
    }

    public static Response ofFail(String code, String message){
        return new Response(code, message, null);
    }

    public boolean isFail(){
        return code != ResponseEnums.SUCCESS.getCode();
    }

}
