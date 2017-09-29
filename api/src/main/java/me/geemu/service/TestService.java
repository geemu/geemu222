package me.geemu.service;


/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/13 8:58
 * Description:
 */
public interface TestService {
    /**
     * 返回用户token
     *
     * @param nickName
     * @param password
     * @return
     */
    String queryUserByNickNameAndPassword(String nickName, String password);
}
