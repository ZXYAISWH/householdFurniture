package com.duing.aspect;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.duing.annotation.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ Author     :Harlon
 * @ Description AOP - 接口日志打印
 * @ Date       :2022/7/10
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    @Pointcut("@annotation(com.duing.annotation.SysLog)")
    public void pt() {

    }

    @Around("pt()")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

        Object ret;
        try {
            handleBefore(joinPoint);
            ret = joinPoint.proceed();
            handleAfter(ret);
        } finally {
            log.info("=======END=======" + System.lineSeparator());
        }
        return ret;
    }

    private void handleAfter(Object ret) {
        log.info("Response             : {}", JSON.toJSONString(ret));
    }

    private void handleBefore(ProceedingJoinPoint joinPoint) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Object[] args = joinPoint.getArgs();
        Stream<?> stream = ArrayUtils.isEmpty(args) ? Stream.empty() : Arrays.stream(args);
        List<Object> logArgs = stream
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());

        SysLog sysLog = getSysLog(joinPoint);

        log.info("=======START=======");
        log.info("URL                  : {}", request.getRequestURL());
        log.info("BusinessName         : {}", sysLog.BusinessName());
        log.info("HTTP Method          : {}", request.getMethod());
        log.info("Class Method         : {}", joinPoint.getSignature().getDeclaringTypeName(),
                ((MethodSignature) joinPoint.getSignature()).getMethod().getName()
        );
        log.info("IP                   : {}", request.getRemoteHost());
        log.info("Request Args         : {}", JSON.toJSONString(logArgs));
    }

    private SysLog getSysLog(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SysLog annotation = signature.getMethod().getAnnotation(SysLog.class);
        return annotation;
    }
}
