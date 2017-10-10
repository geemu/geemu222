package me.geemu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.geemu.persistence.entity.TestUserInfo;
import me.geemu.util.BaseResponse;
import me.geemu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/13 8:53
 * Description:
 */
@RestController
@RequestMapping("test")
@Api(description = "测试")
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


    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "登录删除", notes = "登录删除", response = boolean.class)
    @DeleteMapping("/delete")
    public BaseResponse<Boolean> TestDelete() {
        BaseResponse<Boolean> response = new BaseResponse<>();
        response.setContent(true);
        return response;
    }

    @ApiOperation(value = "测试登录", notes = "测试登录", response = String.class)
    @PostMapping("/login")
    public BaseResponse<String> TestLogin(@RequestParam("nickName") String nickName, @RequestParam("password") String password) {
        BaseResponse<String> response = new BaseResponse<>();
        String token = testSertvice.TestLogin(nickName, password);
        response.setContent(token);
        return response;
    }
}
