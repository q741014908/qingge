package com.qingge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingge.mapper.TbItemMapper;
import com.qingge.pojo.TbItem;
import com.qingge.pojo.TbItemExample;
import com.qingge.pojo.TbItemExample.Criteria;
import com.qingge.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		//添加查询条件
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
