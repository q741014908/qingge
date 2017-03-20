package com.qingge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingge.common.pojo.EasyUITreeNode;
import com.qingge.common.pojo.TaotaoResult;
import com.qingge.service.ContentCategoryService;
/**
 * 内容分类管理
 * <p>Title: ContentCategoryController</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月17日下午2:13:47
 * @version 1.0
 */
@Controller
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
		return contentCategoryService.getCategoryList(parentId);
	}
	
	@RequestMapping("/content/category/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId,String name){
		return contentCategoryService.insertContentCategory(parentId, name);
	}
	
	@RequestMapping("/content/category/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(@RequestParam("id")Long nodeId){
		return contentCategoryService.deleteContentCategory(nodeId);
	}
	
	@RequestMapping("/content/category/update")
	@ResponseBody
	public TaotaoResult updateContentCategory(@RequestParam("id")Long nodeId,String name){
		return contentCategoryService.updateContentCategory(nodeId, name);
	}
}
