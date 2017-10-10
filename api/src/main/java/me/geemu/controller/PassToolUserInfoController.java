package me.geemu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.geemu.domain.response.PassToolLoginResponseVO;
import me.geemu.service.PassToolUserInfoService;
import me.geemu.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/10/10 17:16
 * Description:
 */
@RestController
@RequestMapping("pass_tool_user")
@Api(description = "密码管理工具，用户相关")
public class PassToolUserInfoController {

    @Autowired
    private PassToolUserInfoService passToolUserInfoService;


    @ApiOperation(value = "用户名密码登录", notes = "用户名密码登录", response = PassToolLoginResponseVO.class)
    @PostMapping("/login_account")
    public BaseResponse<PassToolLoginResponseVO> PassToolLoginByAccount(@RequestParam("account") String account, @RequestParam("password") String password) {
        BaseResponse<PassToolLoginResponseVO> response = new BaseResponse<>();
        response.setContent(passToolUserInfoService.PassToolLoginByAccount(account, password));
        return response;
    }
}
