package me.geemu.persistence.dao.test;

import me.geemu.persistence.entity.test.TestUserInfo;
import me.geemu.util.MyMapper;

import java.util.List;


public interface TestUserInfoMapper extends MyMapper<TestUserInfo> {
    List<TestUserInfo> selectAllTestUserInfo();
}