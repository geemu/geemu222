package me.geemu.service.impl;

import me.geemu.enumerate.BaseResponseEnum;
import me.geemu.exception.BusinessException;
import me.geemu.persistence.dao.PassToolAssortmentMapper;
import me.geemu.persistence.entity.PassToolAssortment;
import me.geemu.service.PassToolAssortmentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: 陈方明
 * Email: cfmmail@sina.com
 * Date: 2017/10/10 18:08
 * Description:
 */
@Service
public class PassToolAssortmentServiceImpl implements PassToolAssortmentService {

    @Autowired
    private PassToolAssortmentMapper passToolAssortmentDao;

    /**
     * 获取用户名下所有的账号分类
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> GetUserAssortmentList(Long userId) {
        Example example = new Example(PassToolAssortment.class);
        example.createCriteria()
                .andEqualTo("userId", userId)
                .andEqualTo("isValid", true)
                .andEqualTo("isDelete", false)
        ;
        example.orderBy("sort asc");
        List<PassToolAssortment> exists = passToolAssortmentDao.selectByExample(example);
        if (CollectionUtils.isEmpty(exists)) {
            throw new BusinessException(BaseResponseEnum.DEFAULT_BUSINESS_NO_FOUND_ASSORTMENT_ERROR);
        }
        List<String> response = new LinkedList<>();
        for (PassToolAssortment exist : exists) {
            response.add(exist.getAssortmentName());
        }
        return response;
    }
}
