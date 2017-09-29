package me.geemu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.geemu.util.BaseResponse;
import me.geemu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/13 8:53
 * Description:
 */
@RestController
@RequestMapping("user")
@Api(description = "用户")
public class TestController {

    @Autowired
    private TestService userInfoService;

    @ApiOperation(value = "用户登录", notes = "用户登录", response = String.class)
    @PostMapping("/login")
    public BaseResponse<String> userLogin(@RequestParam("nickName") String nickName, @RequestParam("password") String password) {
        BaseResponse<String> response = new BaseResponse<>();
        response.setContent(userInfoService.queryUserByNickNameAndPassword(nickName, password));
        return response;
    }
}
