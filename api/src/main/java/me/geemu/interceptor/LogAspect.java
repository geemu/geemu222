package me.geemu.interceptor;

import com.alibaba.fastjson.JSON;
import me.geemu.enumerate.BaseResponseEnum;
import me.geemu.exception.BusinessException;
import me.geemu.util.BaseResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;


@Aspect
@Component
public class LogAspect {
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Pointcut("execution(* me.geemu.controller..*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        StringBuilder logSb = new StringBuilder("\r\n");
        String targetMethod = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        Object[] requestParams = point.getArgs();
        Object responseBody = null;
        responseBody = point.proceed();
        logSb.append(String.format("[TargetMethod]\t%s\r\n", targetMethod));
        logSb.append(String.format("[RequestParams]\t\t%s\r\n", JSON.toJSONString(requestParams)));
        logSb.append(String.format("[ResponseBody]\t%s\r\n", JSON.toJSONString(responseBody)));
        logger.info(logSb.toString());
        return responseBody;
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void errorMsg(JoinPoint point, Exception e) {
        String targetMethod = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object[] requestParams = point.getArgs();
        BaseResponse<Object> responseBody = new BaseResponse<Object>();
        StringBuilder logSb = new StringBuilder("\r\n");
        logSb.append(String.format("[TargetMethod]\t%s\r\n", targetMethod));
        logSb.append(String.format("[RequestParams]\t\t%s\r\n", JSON.toJSONString(requestParams)));
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            responseBody.setCode(BaseResponseEnum.DEFAULT_BUSINESS_ERROR.getCode());
            responseBody.setMessage(be.getMessage());
            if (be.getCode() != null) {
                responseBody.setCode(be.getCode());
            }
            logSb.append(String.format("[ResponseBody]\t%s\r\n", JSON.toJSONString(responseBody)));
            logger.error(String.format("[发生了自定义异常]\t%s\r", logSb.toString()));
        } else {
            responseBody.setCode(BaseResponseEnum.DEFAULT_UNKNOW_ERROR.getCode());
            responseBody.setMessage(BaseResponseEnum.DEFAULT_UNKNOW_ERROR.getMessage());
            logSb.append(String.format("[ResponseBody]\t%s\r\n", JSON.toJSONString(responseBody)));
            logger.error(String.format("[后台未知异常，请联系开发小哥]\t%s\r", logSb.toString()));
        }

    }
}
