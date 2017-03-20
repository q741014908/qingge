package com.qingge.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingge.common.pojo.TaotaoResult;
import com.qingge.common.utils.ExceptionUtil;
import com.qingge.pojo.TbContent;
import com.qingge.rest.service.ContentService;

@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/list/{contentCategoryId}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable("contentCategoryId")Long contentId){
		try {
			List<TbContent> contentList = contentService.getContentList(contentId);
			return TaotaoResult.ok(contentList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
