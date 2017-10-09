package me.geemu.service.test;


import me.geemu.persistence.entity.test.TestUserInfo;

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

    List<TestUserInfo> TestAll();
}
