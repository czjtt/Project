package org.gfg.portal.config;

//import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.springframework.web.servlet.ResourceServlet;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 这个类用于在创建bean后输出bean的信息
 * Created by NS on 2015/9/15.
 */
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

    // simply return the instantiated bean as-is
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean; // we could potentially return any object reference here...
    }
    //在创建bean后输出bean的信息
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
         System.out.println("Bean '" + beanName + "' created : " + bean.toString());

        if (bean instanceof ResourceServlet){
            ResourceServlet result = (ResourceServlet) bean;
        }
        return bean;
    }
}
