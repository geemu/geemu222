package me.geemu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.geemu.service.PassToolAssortmentService;
import me.geemu.service.RedisService;
import me.geemu.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/10/10 18:06
 * Description:
 */
@RestController
@RequestMapping("pass_tool_assortment")
@Api(description = "密码管理工具，分类相关")
public class PassToolAssortmentController {

    @Autowired
    private PassToolAssortmentService passToolAssortmentService;

    @Autowired
    private RedisService redisService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "获取用户分类集合", notes = "获取用户分类集合", response = String.class)
    @GetMapping("/list")
    public BaseResponse<List<String>> GetAssortmentList(@RequestHeader("token") String token) {
        BaseResponse<List<String>> response = new BaseResponse<>();
        Long userId = redisService.GetPassToolLoginUser(token).getId();
        response.setContent(passToolAssortmentService.GetUserAssortmentList(userId));
        return response;
    }


}
