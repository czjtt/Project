package org.gfg.portal.dao.impl;

import org.gfg.portal.dao.WaitingUrlDao;
import org.gfg.portal.entity.WaitingUrl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by czj on 2015-11-23.
 */
@Repository("waitingUrlDao")
public class WaitingUrlDaoImpl extends BaseDaoImpl<WaitingUrl> implements WaitingUrlDao {
    @Override
    public Boolean exist(String url) {
        if (findWaitingUrlByUrl(url).size() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean add(String url, Date date) {
        try {
            super.save(new WaitingUrl(url));
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(String url) {
        String hql = "delete WaitingUrl where url=:url";
        Query query = getSession().createQuery(hql);
        if (query.executeUpdate() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public WaitingUrl findWaitingUrlById(Integer id) {
        return super.findById(WaitingUrl.class, id);
    }

    @Override
    public List<WaitingUrl> findWaitingUrlByUrl(String url) throws HibernateException {
        DetachedCriteria query = DetachedCriteria.forClass(WaitingUrl.class);
        query.add(Property.forName("url").eq(url));
        return query.getExecutableCriteria(getSession()).setMaxResults(100).list();
    }
}
