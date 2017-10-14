package me.geemu.service.impl;

import me.geemu.domain.response.PassToolLoginResponseVO;
import me.geemu.enumerate.BaseResponseEnum;
import me.geemu.exception.BusinessException;
import me.geemu.persistence.dao.PassToolUserInfoMapper;
import me.geemu.persistence.entity.PassToolUserInfo;
import me.geemu.service.PassToolUserInfoService;
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
 * Date: 2017/10/10 17:27
 * Description:
 */
@Service
public class PassToolUserInfoServiceImpl implements PassToolUserInfoService {

    @Autowired
    private PassToolUserInfoMapper passToolUserInfoDao;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 根据用户名和密码登录
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public PassToolLoginResponseVO PassToolLoginByAccount(String account, String password) {
        Example example = new Example(PassToolUserInfo.class);
        example.createCriteria()
                .andEqualTo("account", account)
                .andEqualTo("password", password)
                .andEqualTo("isValid", true)
                .andEqualTo("isDelete", false)
        ;
        List<PassToolUserInfo> exists = passToolUserInfoDao.selectByExample(example);
        if (CollectionUtils.isEmpty(exists)) {
            throw new BusinessException(BaseResponseEnum.DEAFULT_LOGIN_ERROR);
        }
        PassToolLoginResponseVO response = new PassToolLoginResponseVO();
        String token = UUID.randomUUID().toString().replace("-", "");
        response.setToken(token);
        int expireTime = 60 * 60 * 24 * 7; // 七天过期  将用户信息保存进redis
        redisUtil.put("login_User:" + token, exists.get(0), (long) expireTime);
        return response;
    }
}
