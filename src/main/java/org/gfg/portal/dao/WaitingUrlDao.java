package org.gfg.portal.dao;

import org.gfg.portal.entity.WaitingUrl;

import java.util.Date;
import java.util.List;

/**
 * Created by czj on 2015-11-23.
 */
public interface WaitingUrlDao {
    public Boolean exist(String url);

    public Boolean add(String url, Date date);

    public Boolean delete(String url);

    public WaitingUrl findWaitingUrlById(Integer id);

    public List<WaitingUrl> findWaitingUrlByUrl(String url);
}
