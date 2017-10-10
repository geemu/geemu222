package me.geemu.service;

import me.geemu.domain.response.PassToolLoginResponseVO;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/10/10 17:27
 * Description:
 */
public interface PassToolUserInfoService {
    /**
     * 根据用户名和密码登录
     *
     * @param account
     * @param password
     * @return
     */
    PassToolLoginResponseVO PassToolLoginByAccount(String account, String password);
}
