package org.gfg.portal.action;

import org.gfg.portal.entity.UserEntity;
import org.gfg.portal.service.testService;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by NS on 2015/9/14.
 */
@Controller
@RequestMapping("/test")
public class testAction {

    @Resource(name = "testService")
    private testService testService;

    @RequestMapping(value = "/save.shtm",method = RequestMethod.POST)
    public @ResponseBody String test(ModelMap model){
        System.out.println("control");
        if(testService.test()){
            System.out.println("save ok.");
            model.addAttribute("message", "nice save");
            return "nice save";
        }else {
            model.addAttribute("message", "bad save");
            return "bad save";
        }
    }

    @RequestMapping(value = "/print.shtm",method = RequestMethod.POST)
    public @ResponseBody
    List<UserEntity> finduser(Integer userId){
        System.out.println("finduser action");
        UserEntity userEntity = testService.find(userId);
        System.out.println(userEntity);
        List<UserEntity> list = new ArrayList<UserEntity>();
        list.add(userEntity);
        System.out.println(userEntity);
        //return list;
        return list;
    }
}
