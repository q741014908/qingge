package com.qingge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingge.common.pojo.TaotaoResult;
import com.qingge.pojo.TbItemParam;
import com.qingge.service.ItemParamService;
/**
 * 商品规格参数模板管理
 * <p>Title: ItemParamController</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月14日下午6:48:43
 * @version 1.0
 */
@Controller
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	//item/param/query/itemcatid/147 Failed to load resource: the server responded with a status of 404 (Not Found)
	@RequestMapping("/item/param/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Long itemCatId){
		return itemParamService.getItemParamByCid(itemCatId);
	}
	
	@RequestMapping("/item/param/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid,String paramData){
		TbItemParam tbItemParam=new TbItemParam();
		tbItemParam.setItemCatId(cid);
		tbItemParam.setParamData(paramData);
		return itemParamService.insertItemParam(tbItemParam);
	}
}
