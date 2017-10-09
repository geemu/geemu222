package me.geemu.service;


import me.geemu.persistence.entity.TestUserInfo;

public interface RedisService {

    /**
     * 检查用户是否已经登录
     *
     * @param token
     * @return
     */
    boolean isUserLogin(String token);

    /**
     * 获取登录用户
     *
     * @param token
     * @return
     */
    TestUserInfo getLoginUser(String token);
}
