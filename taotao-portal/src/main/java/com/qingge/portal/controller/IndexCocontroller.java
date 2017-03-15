package com.qingge.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCocontroller {

	@RequestMapping("/index")
	public String showIndex(){
		return "index";
	}
}
