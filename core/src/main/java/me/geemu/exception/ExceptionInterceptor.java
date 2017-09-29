package me.geemu.exception;

import me.geemu.enumerate.BaseResponseEnum;
import me.geemu.util.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截器
 */
@RestControllerAdvice
public class ExceptionInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionInterceptor.class);

    private static final boolean DEFAULT_STATUS_ERROR = false;

    /**
     * 自定义异常
     *
     * @param be
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<Object> handleCustomException(BusinessException be) {
        BaseResponse<Object> response = new BaseResponse<Object>();
        response.setCode(BaseResponseEnum.DEFAULT_BUSINESS_ERROR.getCode());
        if (be.getCode() == null) {
            response.setMessage(be.getMessage());
            return response;
        }
        response.setCode(be.getCode());
        response.setMessage(be.getMessage());
        return response;
    }

    /**
     * 其他异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse<Object> handleAllException(Exception e) {
        BaseResponse<Object> response = new BaseResponse<Object>();
        response.setCode(BaseResponseEnum.DEFAULT_UNKNOW_ERROR.getCode());
        response.setMessage(BaseResponseEnum.DEFAULT_UNKNOW_ERROR.getMessage());
        logger.error(BaseResponseEnum.DEFAULT_UNKNOW_ERROR.getMessage(), e);
        return response;
    }


}
