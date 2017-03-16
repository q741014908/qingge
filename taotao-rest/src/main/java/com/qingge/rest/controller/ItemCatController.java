package com.qingge.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingge.common.utils.JsonUtils;
import com.qingge.rest.pojo.CatResult;
import com.qingge.rest.service.ItemCatService;

/**
 * 商品分类列表
 * <p>Title: ItemCatController</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月16日下午1:35:36
 * @version 1.0
 */
@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback){
		
		CatResult itemCatList = itemCatService.getItemCatList();
//		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(itemCatList);
		//把pojo转换成字符串
		String jsonString=JsonUtils.objectToJson(itemCatList);
		//拼装返回值
		String resultString= callback +"("+jsonString+")";
		return resultString;
	}
}
