package org.gfg.portal.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gfg.portal.dao.BaseDao;
import org.gfg.portal.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by NS on 2015/9/7.
 */
@Repository("baseDao")
public class BaseDaoImpl<M extends Serializable> implements BaseDao<M> {

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
//        return this.sessionFactory.openSession();
        Session session = null;
        System.out.println("getSession");
        try {
            session = sessionFactory.getCurrentSession();
        }catch (Exception e){
            System.out.println("e.getMessage:" + e.getMessage());
            System.out.println("Exception:");
            e.printStackTrace();
        }
        System.out.println("return session");
        return session;
    }

    public M findById(Class clazz,Serializable id){
        return (M) getSession().get(clazz,id);
    }

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

//    private ApplicationContext ctx;

    public Serializable save(M object) {
        return getSession().save(object);
    }
}

//    @Override
//    public void testSql(){
//        System.out.println("dao");
//        if(this.sessionFactory==null){
//            System.out.println("sessionfactory is null");
//        }else {
//            System.out.println("sessionfactory not null");
//        }
//        UserEntity user = new UserEntity();
//        user.setUsername("zhangsan");
//        user.setPassword("123456");
//        user.setRealname("lisi");
//        user.setSex(1);
//        try {
//            if (null == this.getSession()) {
//                System.out.println("getSession is null");
//                return;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        getSession().save(user);
//        System.out.println("test2");
//    }
//
//    //    @Test
//    public void test2(){
////        自动注入失败
//        String str = sessionFactory==null?"null":"not";
//        System.out.println(str);
//        if (str.equals("null")){
////            手动获取
//            ctx = new ClassPathXmlApplicationContext("config/spring/spring-datasource.xml");
//            sessionFactory = (SessionFactory)ctx.getBean("sessionFactory");
//            if(sessionFactory==null){
//                System.out.println("null");
//                return;
//            }
//            System.out.printf("not");
//        }
//        UserEntity user = new UserEntity();
//        user.setUsername("zhangsan");
//        user.setPassword("123456");
//        user.setRealname("zhangsan");
//        user.setSex(1);
////        getSession().save(user);
//        System.out.println("test2");
//    }
//}
