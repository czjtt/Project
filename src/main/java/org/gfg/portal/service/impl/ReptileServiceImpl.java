package org.gfg.portal.service.impl;

import org.apache.log4j.Logger;
import org.gfg.portal.dao.ReptileDao;
import org.gfg.portal.dao.WaitingUrlDao;
import org.gfg.portal.entity.AnalysedUrl;
import org.gfg.portal.service.ReptileService;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by NS on 2015/10/8.
 */
@Service("reptileService")
public class ReptileServiceImpl implements ReptileService {

    private static Logger logger = Logger.getLogger(ReptileServiceImpl.class);

    @Resource(name = "reptileDao")
    private ReptileDao reptileDao;

    @Resource(name = "waitingUrlDao")
    private WaitingUrlDao waitingUrlDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Boolean existUrl(String url) {
        return reptileDao.exist(url);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Integer findAnalysisQueueIdByUrl(String url) throws HibernateException {
        if (!this.existUrl(url)) {
            return -1;
        }
        AnalysedUrl analysedUrl = reptileDao.findAnalysedUrlByUrl(url);
        if (analysedUrl != null) {
            return analysedUrl.getId();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void addqueue(String url) {
        Date date = new Date();
        reptileDao.add(url, date);
    }

    @Override
    public List<String> analysisUrl(String url) {
        List<String> urlList = new ArrayList<String>();
        // analysisUrl
        // TODO

        return urlList;
    }

    @Override
    public void deleteWaitQueue(String url) {
        if(!waitingUrlDao.delete(url)){
            logger.warn("delete url:" + url + ". failed");
        }
    }
}
