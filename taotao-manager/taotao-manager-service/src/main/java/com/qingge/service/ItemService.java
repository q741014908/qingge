package com.qingge.service;

import com.qingge.common.pojo.EasyUIDataGridResult;
import com.qingge.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	
	EasyUIDataGridResult getItemList(int page, int rows);
}
