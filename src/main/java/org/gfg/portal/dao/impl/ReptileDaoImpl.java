package org.gfg.portal.dao.impl;

import org.gfg.portal.dao.ReptileDao;
import org.gfg.portal.entity.AnalysedUrl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 用于处理analysisUrl队列中的url对象的dao层
 * Created by NS on 2015/10/8.
 */
//需要更改该类的名字为AnalysedUrlDaoImpl,更改接口名字为AnalysedUrlDao
@Repository("reptileDao")
public class ReptileDaoImpl extends BaseDaoImpl<AnalysedUrl> implements ReptileDao {

    @Override
    public Boolean exist(String url) {
        if(findAnalysedUrlByUrl(url)!=null){
            return true;
        }
        return false;
    }

    @Override
    public Boolean add(String url,Date date) {
        try{
            super.save(new AnalysedUrl(url,date));
        }catch (Exception e){
            System.out.println("add url fail.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(String url) {
        try{
            getSession().delete(findAnalysedUrlByUrl(url));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public AnalysedUrl findAnalysedUrlById(Integer id) {
        return super.findById(AnalysedUrl.class,id);
    }

    @Override
    public AnalysedUrl findAnalysedUrlByUrl(String url) throws HibernateException{
        String hql = "from AnalysedUrl where url=:url";
        Query query=getSession().createQuery(hql);
        query.setParameter("url", url);
        AnalysedUrl analysedUrl =(AnalysedUrl)query.uniqueResult();
        return analysedUrl;
    }
}
