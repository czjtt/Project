package org.gfg.portal.service.impl;

import org.gfg.portal.dao.BaseDao;
import org.gfg.portal.dao.UserDao;
import org.gfg.portal.entity.UserEntity;
import org.gfg.portal.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by NS on 2015/9/14.
 */
@Service("testService")
public class testServiceImpl implements testService {

    @Resource(name="userDao")
    private UserDao userDao;

    @Override
//    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Boolean test(){
        System.out.println("service");
        UserEntity user = new UserEntity();
        user.setUsername("chenwu");
        user.setPassword("123456");
        user.setRealname("zhangsan");
        user.setSex(1);
        return userDao.saveUser(user);
    }

    @Override
    public UserEntity find(Integer userId){
        return userDao.findById(userId);
    }
}
