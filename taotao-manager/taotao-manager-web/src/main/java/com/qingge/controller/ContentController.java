package com.qingge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingge.common.pojo.TaotaoResult;
import com.qingge.pojo.TbContent;
import com.qingge.service.ContentService;
/**
 * 内容管理controller
 * <p>Title: ContentController</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月19日下午4:59:48
 * @version 1.0
 */
@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent tbContent){
		return contentService.insertContent(tbContent);
	}
}
