package me.geemu.controller.Test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.geemu.persistence.entity.test.TestUserInfo;
import me.geemu.util.BaseResponse;
import me.geemu.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/13 8:53
 * Description:
 */
@RestController
@RequestMapping("test")
@Api(description = "用户")
public class TestController {

    @Autowired
    private TestService testSertvice;

    @ApiOperation(value = "异常捕获测试", notes = "1 字符串异常 2 枚举异常 3 后台异常", response = String.class)
    @PostMapping("/exception")
    public BaseResponse<String> TestExc(@RequestParam("param") String param) {
        BaseResponse<String> response = new BaseResponse<>();
        response.setContent(testSertvice.TestException(param));
        return response;
    }

    @ApiOperation(value = "查询所有", notes = "查询所有", response = String.class)
    @PostMapping("/all")
    public BaseResponse<List<TestUserInfo>> TestAll() {
        BaseResponse<List<TestUserInfo>> response = new BaseResponse<>();
        response.setContent(testSertvice.TestAll());
        return response;
    }
}
