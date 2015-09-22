package org.gfg.portal.dao;

import org.gfg.portal.entity.UserEntity;

/**
 * Created by NS on 2015/9/7.
 */
public interface UserDao {
    public Boolean saveUser(UserEntity userEntity);

    public void update(UserEntity userEntity);

    public void deleteById(Integer id);

    public UserEntity findById(Integer id);

}
