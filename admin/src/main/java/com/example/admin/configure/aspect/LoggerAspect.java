package com.example.admin.configure.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	
    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
    
    
    private final String executName="执行方法为：{}";

    private final String excuteTime="执行时间为：{}";
    
    private final String excuteArgs="执行参数为：{}";
    
    @Pointcut("execution(public * com.example.admin.modular.*.controller.*.*(..))")
    public void log() {
    }


    @Around("log()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        logger.info(executName, pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        long startTime = System.currentTimeMillis();
        Object[] args = pjp.getArgs();
        logger.info(excuteArgs,args);
        Object result = null;
        result = pjp.proceed(args);
        long endTime = System.currentTimeMillis();
        logger.info(excuteTime,(endTime - startTime)+"ms");
        return result;
    }


}
