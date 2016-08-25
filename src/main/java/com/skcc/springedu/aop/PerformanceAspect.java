package com.skcc.springedu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author HyunSub Shim
 * @since 1.0
 */
@Aspect
@Component
public class PerformanceAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.skcc.springedu.dao.UserDao.*(..)) || execution(* com.skcc.springedu.service.UserService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = proceedingJoinPoint.proceed();
        logger.info("{} Execution Time : {} ms", proceedingJoinPoint.getSignature(), System.currentTimeMillis() - startTime);
        return returnValue;
    }
}
