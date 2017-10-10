package me.geemu.service.impl;

import me.geemu.domain.response.TestLoginResponseVO;
import me.geemu.enumerate.BaseResponseEnum;
import me.geemu.exception.BusinessException;
import me.geemu.persistence.dao.TestUserInfoMapper;
import me.geemu.persistence.entity.TestUserInfo;
import me.geemu.service.TestService;
import me.geemu.util.RedisUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.UUID;


/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/9/13 9:01
 * Description:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    RedisUtil redisUtil;

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

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<TestUserInfo> TestAll() {
        return testUserInfoMapper.selectAllTestUserInfo();
    }

    /**
     * 测试登录
     *
     * @return
     */
    @Override
    public TestLoginResponseVO TestLogin(String nickName, String password) {
        Example example = new Example(TestUserInfo.class);
        example.createCriteria()
                .andEqualTo("nickName", nickName)
                .andEqualTo("password", password)
        ;
        List<TestUserInfo> exists = testUserInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(exists)) {
            throw new BusinessException(BaseResponseEnum.DEAFULT_LOGIN_ERROR);
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        int expireTime = 60 * 60 * 24 * 7;
        redisUtil.put("login_User:" + token, exists.get(0), (long) expireTime);
        TestLoginResponseVO response = new TestLoginResponseVO();
        response.setToken(token);
        return response;
    }
}
