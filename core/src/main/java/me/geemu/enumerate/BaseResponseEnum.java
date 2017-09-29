package me.geemu.enumerate;

import lombok.Getter;

/**
 * Author: geemu
 * Email: cfmmail@sina.com
 * Date: 2017/9/11 17:21
 * Description:
 */
@Getter
public enum BaseResponseEnum {

    DEFAULT_OK(200, "success"),
    DEFAULT_BUSINESS_ERROR(201, "error occured"),
    DEFAULT_UNKNOW_ERROR(500, "后台未知系统异常，请联系开发小哥！"),

    DEFAULT_TEST_ERROR(300, "测试异常");
    // 1000 授权相关
    // 2000 用户相关
    // 3000业务相关 4000 业务相关
    private Integer code;

    private String message;

    BaseResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
