package org.gfg.portal.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

	int i = 0;

	@RequestMapping(value = "/print.shtm",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		System.out.println("print page" + i++);
		model.addAttribute("message", "jsp hello/print page.");
		return "hello/print";
	}

	@RequestMapping(value = "/hello.htm",method = RequestMethod.GET)
	public String print(ModelMap model) {
		System.out.println("hello man" + i++);
		model.addAttribute("message", "jsp hello/hello world!");
		return "hello/hello";
	}

	@RequestMapping(value = "/vm.shtm",method = RequestMethod.GET)
	public String vm(ModelMap model){
		System.out.println("vm page" + i++);
		model.addAttribute("message","velocity index page.");
		return "index";
	}

	@RequestMapping(value = "/vm_hello.shtm",method = RequestMethod.GET)
	public String vm_hello(ModelMap model){
		System.out.println("vm_hello page" + i++);
		model.addAttribute("message","velocity hello/index page.");
		return "hello/index";
	}

	@RequestMapping(value = "index.shtm")
	public ModelAndView home(){
		System.out.println("hello/index.shtm");
		return new ModelAndView("index.vm");
	}
}