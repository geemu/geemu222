package me.geemu.service.impl;

import me.geemu.enumerate.BaseResponseEnum;
import me.geemu.exception.BusinessException;
import me.geemu.persistence.entity.TestUserInfo;
import me.geemu.service.RedisService;
import me.geemu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisUtil redisUtil;


    /**
     * 检查用户是否已经登录
     *
     * @param token
     * @return
     */
    @Override
    public boolean isUserLogin(String token) {
        boolean result = redisUtil.exists("login_User:" + token);
        if (result == false) {
            throw new BusinessException(BaseResponseEnum.DEFAULT_PLEASE_LOGIN);
        }
        return result;
    }

    /**
     * 获取登录用户
     *
     * @param token
     * @return
     */
    @Override
    public TestUserInfo getLoginUser(String token) {
        isUserLogin(token);
        String key = "login_User:" + token;
        TestUserInfo loginUser = (TestUserInfo) redisUtil.get(key);
        return loginUser;
    }

}
