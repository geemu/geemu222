package me.geemu.service;


import me.geemu.domain.response.TestLoginResponseVO;
import me.geemu.persistence.entity.TestUserInfo;

import java.util.List;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/13 8:58
 * Description:
 */
public interface TestService {
    /**
     * 测试异常
     *
     * @param param
     * @return
     */
    String TestException(String param);

    /**
     * 查询所有
     *
     * @return
     */
    List<TestUserInfo> TestAll();

    /**
     * 测试登录
     *
     * @return
     */
    TestLoginResponseVO TestLogin(String nickName, String password);
}
