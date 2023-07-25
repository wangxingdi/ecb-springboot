package com.wangxingdi.wechat.annotation.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wangxingdi.wechat.annotation.Log;
import com.wangxingdi.wechat.common.enums.LogPositionEnum;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志打印
 * @author www.wangxingdi.com
 * @date 2023/7/25 15:20
 * @copyright Copyright JD.COM All Right Reserved
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.wangxingdi.wechat.annotation.Log)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log logAnnotation = method.getAnnotation(Log.class);
        logBefore(logAnnotation, joinPoint);
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        logAfter(logAnnotation, joinPoint, result, (System.currentTimeMillis() - start));
        return result;
    }

    private void logBefore(Log log, ProceedingJoinPoint proceedingJoinPoint) {
        if (log != null && isLogBefore(log)) {
            getLogger(log, proceedingJoinPoint.getThis().getClass()).info("{} before invoke method [{}],args:{}", log.beforeInvokeMessage(), proceedingJoinPoint.getSignature().getName(), JSON.toJSONString(proceedingJoinPoint.getArgs(), SerializerFeature.WriteDateUseDateFormat));
        }
    }

    private void logAfter(Log log, ProceedingJoinPoint proceedingJoinPoint, Object result, long responseTime) {
        if (log != null && isLogAfter(log)) {
            getLogger(log, proceedingJoinPoint.getThis().getClass()).info("{} after invoke method [{}],result:{}, cost:{}ms", log.afterInvokeMessage(), proceedingJoinPoint.getSignature().getName(), JSON.toJSONString(result, SerializerFeature.WriteDateUseDateFormat), responseTime);
        }
    }

    private boolean isLogBefore(Log log) {
        return log.position() == LogPositionEnum.BEFORE || log.position() == LogPositionEnum.ALL;
    }

    private boolean isLogAfter(Log log) {
        return log.position() == LogPositionEnum.AFTER || log.position() == LogPositionEnum.ALL;
    }

    private static Logger getLogger(Log log, Class<?> target) {
        return LoggerFactory.getLogger(getLoggerName(log, target));
    }

    private static String getLoggerName(Log loggerNewTag, Class<?> target) {
        if (loggerNewTag == null) {
            return target.getName();
        }
        String loggerName = loggerNewTag.name();
        if (StringUtils.isNotBlank(loggerName)) {
            return loggerName;
        }
        return target.getName();
    }
}
