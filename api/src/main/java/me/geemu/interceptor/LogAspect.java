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

    // 这边只能记录正常的日志，如果抛出异常则需要到底层记录
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        StringBuilder logSb = new StringBuilder("\r\n");
        logSb.append(String.format("[TargetMethod]\t%s\r\n", methodName));
        Object[] args = point.getArgs();
        logSb.append(String.format("[RequestParams]\t\t%s\r\n", JSON.toJSONString(args)));
        Object result = null;
        result = point.proceed();
        logSb.append(String.format("[ResponseBody]\t%s\r\n", JSON.toJSONString(result)));
        logger.info(logSb.toString());
        return result;
    }
}
