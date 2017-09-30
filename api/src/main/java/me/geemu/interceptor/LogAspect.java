package me.geemu.interceptor;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Pointcut("execution(* me.geemu.controller..*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        Object[] args = point.getArgs();
        logger.info(String.format("[TargetMethod]\t%s\r", methodName));
        logger.info(String.format("[RequestParams]\t\t%s\r", JSON.toJSONString(args)));
        Object result = null;
        result = point.proceed();
        logger.info(String.format("[ResponseBody]\t%s\r", JSON.toJSONString(result)));
        return result;
    }
}
