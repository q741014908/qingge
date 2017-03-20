package com.qingge.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingge.common.pojo.TaotaoResult;

@Controller
public class JsonController {

	@RequestMapping(value="/httpclient/post",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult testPost(){
		return TaotaoResult.ok();
	}
}
