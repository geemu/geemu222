package me.geemu.service.impl;

import me.geemu.enumerate.BaseResponseEnum;
import me.geemu.exception.BusinessException;
import me.geemu.service.TestService;
import org.springframework.stereotype.Service;


/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/13 9:01
 * Description:
 */
@Service
public class TestServiceImpl implements TestService {


    @Override
    public String queryUserByNickNameAndPassword(String nickName, String password) {
        if (nickName.equalsIgnoreCase("1")) {
            throw new BusinessException("只有一个1");
        }
        if (nickName.equalsIgnoreCase("2")) {
            throw new BusinessException(BaseResponseEnum.DEFAULT_TEST_ERROR);
        }
        if (nickName.equalsIgnoreCase("3")) {
            throw new RuntimeException("runtimeexception");
        }
        return "803421";

    }
}
