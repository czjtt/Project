package org.gfg.portal.dao.impl;

import org.gfg.portal.dao.BaseDao;
import org.gfg.portal.dao.UserDao;
import org.gfg.portal.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by NS on 2015/9/7.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {


    @Override
    public Boolean saveUser(UserEntity userEntity) {
        System.out.println("userdao");
        try {
            save(userEntity);
        }catch (Exception e){
            return false;
        }
        return true;
//        getHibernateTemplate().save(userEntity);
    }

    @Override
    public void update(UserEntity userEntity) {
//        getHibernateTemplate().update(userEntity);
    }

    @Override
    public void deleteById(Integer id) {
//        getHibernateTemplate().delete(getHibernateTemplate().findByNamedQuery("id",id));
    }

    @Override
    public UserEntity findById(Integer id){
        System.out.println("findById");
        return super.findById(UserEntity.class, id);
    }
}
