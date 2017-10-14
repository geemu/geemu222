package me.geemu.service;

import java.util.List;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/10/10 18:08
 * Description:
 */
public interface PassToolAssortmentService {

    /**
     * 获取用户名下所有的账号分类
     *
     * @param userId
     * @return
     */
    List<String> GetUserAssortmentList(Long userId);
}
