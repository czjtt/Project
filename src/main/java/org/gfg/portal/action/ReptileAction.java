package org.gfg.portal.action;

import org.apache.log4j.Logger;
import org.gfg.portal.service.ReptileService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by NS on 2015/9/28.
 */
@Controller
@RequestMapping("/reptile")
public class ReptileAction {

    private static Logger logger = Logger.getLogger(ReptileAction.class);

    private ArrayList<String> waitingQueue;
    private ArrayList<String> analysedQueue;
    private ArrayList<String> badQueue;
    @Autowired
    ReptileService reptileService;

    @RequestMapping(value = "/index.htm",method = RequestMethod.GET)
    public String index(){
        logger.info("game starting run.");
        return "reptile/index";
    }

    /**
     * 大致步骤：
     * 得到一个url，
     * 1.对其进行判断是否已经存在于已识别url队列中
     * 2.如果已存在，则结束。
     *   如果不存在已识别url队列中，把他添加到已识别url队列中，然后进行分析
     * 3.对该url进行数据分析处理，删除其在待分析url队列中的值
     * 4.分析获取该url中的所有url，并把这些url添加到待分析url队列
     * 5.继续第一步.
     * @param url
     * @return
     */
    @RequestMapping(value = "/analysisUrl.shtm",method = RequestMethod.POST)
    public @ResponseBody
    String analysisUrl(String url){
        logger.info("starting analysis Url: " + url);

        StringBuffer result = new StringBuffer("url:" + url + "\t\r");
        int id=0;
        try{
             id = reptileService.findAnalysisQueueIdByUrl(url);
        }catch (HibernateException e){
            e.printStackTrace();
            logger.warn("id not find.");
        }

        if(id>=0){
            logger.info("this url is exist.");
            result.append("this url is exist.");
        }else {
            //1. 添加到已处理url队列中
            reptileService.addqueue(url);

            //2. 做url处理
            // 读取url中的内容

            //3. 添加处理后的urllist到待分析url队列

            logger.info("this url is add to queue.");
            result.append("this url is add to queue.");
        }
        System.out.println("analysisUrl:"+ url);
        return result.toString();
    }

}
