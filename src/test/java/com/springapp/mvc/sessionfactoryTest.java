package com.springapp.mvc;

import org.gfg.portal.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.Serializable;

/**
 * Created by NS on 2015/9/7.
 */
public class sessionfactoryTest implements Serializable {

//    test1
//    需要hibernagte.cfg.xml配置文件
//    @Test
    public void test1(){

        Configuration cfg = new Configuration().configure("/config/db.properties");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        //        打开事务
        session.beginTransaction();

        UserEntity user = new UserEntity();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setRealname("zhangsan");
        user.setSex(1);
        session.save(user);
//        提交事务
        session.getTransaction().commit();
    }

//    test2
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.openSession();
    }

    @Test
    public void test2(){
        String str = sessionFactory==null?"null":"not";
        System.out.printf(str);
        if (str.equals("null")){
            return;
        }
        UserEntity user = new UserEntity();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        user.setRealname("zhangsan");
        user.setSex(1);
        getSession().save(user);
        System.out.println("test2");
    }
}
