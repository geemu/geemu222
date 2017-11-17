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


@Aspect
@Component
public class LogAspect {
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    @Pointcut("execution(* me.geemu.controller..*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public BaseResponse<Object> around(ProceedingJoinPoint point) {
        BaseResponse<Object> response = new BaseResponse<Object>();
        StringBuilder logSb = new StringBuilder("\r\n");
        String targetMethod = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object[] requestParams = point.getArgs();
        logSb.append(String.format("[RequestURL]\t%s\r\n", attributes.getRequest().getRequestURL()));
        logSb.append(String.format("[RequestParams]\t\t%s\r\n", JSON.toJSONString(requestParams)));
        logSb.append(String.format("[TargetMethod]\t%s\r\n", targetMethod));
        Throwable err = null;
        try {
            response = (BaseResponse<Object>) point.proceed();
            logSb.append(String.format("[ResponseBody]\t%s\r\n", JSON.toJSONString(response)));
        } catch (BusinessException be) {
            response.setCode(BaseResponseEnum.DEFAULT_BUSINESS_ERROR.getCode());
            response.setMessage(be.getMessage());
            if (be.getCode() != null) {
                response.setCode(be.getCode());
            }
            logSb.append(String.format("[ResponseBody]\t%s\r\n", JSON.toJSONString(response)));
        } catch (Throwable e) {
            response.setCode(BaseResponseEnum.DEFAULT_UNKNOW_ERROR.getCode());
            response.setMessage(BaseResponseEnum.DEFAULT_UNKNOW_ERROR.getMessage());
            logSb.append(String.format("[ResponseBody]\t%s\r\n", JSON.toJSONString(response)));
            err = e;
        } finally {
            // 输出日志
            logger.error(logSb.toString());
            if (err != null) {
                err.printStackTrace();
            }
        }
        return response;
    }

}
