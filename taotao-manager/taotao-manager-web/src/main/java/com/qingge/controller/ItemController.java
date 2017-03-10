package com.qingge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingge.pojo.TbItem;
import com.qingge.service.ItemService;

/**
 * 商品管理
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月10日上午10:19:55
 * @version 1.0
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId){
		return itemService.getItemById(itemId);
	}
}
