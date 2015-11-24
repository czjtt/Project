package org.gfg.portal.service;

import java.util.List;

/**
 * Created by NS on 2015/10/8.
 */
public interface ReptileService {

    /**
     * 判别这个url是否存在已处理url队列中
     * @param url
     * @return
     *      true：存在
     *      false：不存在
     */
    public Boolean existUrl(String url);

    /**
     * 根据url找到该url存在于已处理url队列中的id
     * @param url
     * @return 该url的已处理url队列的id
     *      如果该url不存在于已处理url队列中则返回-1.
     */
    public Integer findAnalysisQueueIdByUrl(String url);

    /**
     * 添加url到已处理url队列中
     * @param url
     */
    public void addqueue(String url);

    /**
     * 对当前url进行处理，返回从这个url找到的所有url
     * @param url
     * @return list
     */
    public List<String> analysisUrl(String url);

    /**
     * 删除在等待url队列中的url
     * @param url
     */
    public void deleteWaitQueue(String url);



}
