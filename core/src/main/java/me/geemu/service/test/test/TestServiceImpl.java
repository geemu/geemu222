package me.geemu.service.test.test;

import me.geemu.enumerate.BaseResponseEnum;
import me.geemu.exception.BusinessException;
import me.geemu.persistence.dao.test.TestUserInfoMapper;
import me.geemu.persistence.entity.test.TestUserInfo;
import me.geemu.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/13 9:01
 * Description:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestUserInfoMapper testUserInfoMapper;
    /**
     * 测试异常
     *
     * @param param
     * @return
     */
    @Override
    public String TestException(String param) {
        if (param.equalsIgnoreCase("1")) {
            throw new BusinessException("字符串异常");
        }
        if (param.equalsIgnoreCase("2")) {
            throw new BusinessException(BaseResponseEnum.DEFAULT_TEST_ERROR);
        }
        if (param.equalsIgnoreCase("3")) {
            throw new RuntimeException("运行时异常");
        }
        return "normal";

    }

    @Override
    public List<TestUserInfo> TestAll() {
        return testUserInfoMapper.selectAllTestUserInfo();
    }
}
