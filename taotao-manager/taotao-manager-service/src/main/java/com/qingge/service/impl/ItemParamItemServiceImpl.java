package com.qingge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingge.mapper.TbItemParamItemMapper;
import com.qingge.pojo.TbItemParamItem;
import com.qingge.pojo.TbItemParamItemExample;
import com.qingge.pojo.TbItemParamItemExample.Criteria;
import com.qingge.service.ItemParamItemService;
/**
 * 展示商品规格参数
 * <p>Title: ItemParamItemServiceImpl</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月15日下午3:20:34
 * @version 1.0
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public String getItemParamByItemId(Long itemId) {
		// TODO Auto-generated method stub
		//根据商品id查询规格参数
		TbItemParamItemExample example=new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> tbItemParamItemList = itemParamItemMapper.selectByExampleWithBLOBs(example);
		if(tbItemParamItemList==null || tbItemParamItemList.size()<=0){
			return "";
		}
		TbItemParamItem tbItemParamItem = tbItemParamItemList.get(0);
		String paramData = tbItemParamItem.getParamData();
		//生成html
		
		return "";
	}

}
