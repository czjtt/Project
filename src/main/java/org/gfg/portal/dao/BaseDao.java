package org.gfg.portal.dao;

import java.io.Serializable;

/**
 * Created by NS on 2015/9/14.
 */
public interface BaseDao <M extends Serializable> {
    /**
     * 保存
     * @param object
     * @return
     */
    public Serializable save(M object);

    /**
     * 根据ID查找
     * @param clazz
     * @param id
     * @return
     */
    public M findById(Class clazz,Serializable id);
//    public void testSql();
}
