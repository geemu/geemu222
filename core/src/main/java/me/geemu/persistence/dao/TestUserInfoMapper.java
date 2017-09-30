package me.geemu.persistence.dao;

import me.geemu.persistence.entity.TestUserInfo;
import me.geemu.util.MyMapper;

import java.util.List;


public interface TestUserInfoMapper extends MyMapper<TestUserInfo> {
    List<TestUserInfo> selectAllTestUserInfo();
}