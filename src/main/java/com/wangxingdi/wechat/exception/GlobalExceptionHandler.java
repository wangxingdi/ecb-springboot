package com.wangxingdi.wechat.exception;

import com.alibaba.fastjson.JSON;
import com.wangxingdi.wechat.common.domain.Response;
import com.wangxingdi.wechat.common.enums.ResponseEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * @author www.wangxingdi.com
 * @date 2023/7/25 18:01
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception ex, HttpServletRequest request){
        log.error("exception: ", ex);
        if(ex instanceof IllegalArgumentException){
            return handleException(ResponseEnums.FAIL.getCode(), ex.getMessage(), request);
        }else if(ex instanceof MethodArgumentNotValidException){
            return handleException(ResponseEnums.FAIL_VALIDATION.getCode(), ((MethodArgumentNotValidException) ex).getBindingResult().getFieldError().getDefaultMessage(), request);
        }else {
            return handleException(ResponseEnums.FAIL.getCode(), ResponseEnums.FAIL.getMessage(), request);
        }
    }

    private Response handleException(String code, String message, HttpServletRequest request) {
        Response response = Response.ofFail(code, message);
        StringBuffer requestURL = request.getRequestURL();
        log.error("request:{} is exception, response is {}", requestURL, JSON.toJSONString(response));
        return response;
    }

}
