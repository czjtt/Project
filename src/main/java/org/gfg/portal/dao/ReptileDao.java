package org.gfg.portal.dao;

import org.gfg.portal.entity.AnalysedUrl;

import java.util.Date;

/**
 * Created by NS on 2015/10/8.
 */
public interface ReptileDao {

    public Boolean exist(String url);

    public Boolean add(String url, Date date);

    public Boolean delete(String url);

    public AnalysedUrl findAnalysedUrlById(Integer id);

    public AnalysedUrl findAnalysedUrlByUrl(String url);
}
