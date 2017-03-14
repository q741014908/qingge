package com.qingge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingge.common.pojo.TaotaoResult;
import com.qingge.service.ItemParamService;
/**
 * 商品规格参数模板管理
 * <p>Title: ItemParamController</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月14日下午6:48:43
 * @version 1.0
 */
@Service
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/item/param/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Long itemCatId){
		return itemParamService.getItemParamByCid(itemCatId);
	}
	
}
