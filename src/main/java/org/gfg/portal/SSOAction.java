package org.gfg.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.normalizer.ICUBinary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by NS on 2015/9/2.
 */
@Controller
@RequestMapping("/sso")
public class SSOAction {

    @RequestMapping(value = "/ajaxlogin.shtm",method = RequestMethod.POST)
    public @ResponseBody
    void ajaxLogin(String username,String password,HttpServletRequest request,HttpServletResponse response,String service){

    }
}
