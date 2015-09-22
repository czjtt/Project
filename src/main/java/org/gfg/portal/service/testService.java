package org.gfg.portal.service;

import org.gfg.portal.entity.UserEntity;

import javax.jws.soap.SOAPBinding;

/**
 * Created by NS on 2015/9/14.
 */
public interface testService {

    public UserEntity find(Integer userId);
    public Boolean test();
}
