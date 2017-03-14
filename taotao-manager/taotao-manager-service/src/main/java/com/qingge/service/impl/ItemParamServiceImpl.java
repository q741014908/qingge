package com.qingge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingge.common.pojo.TaotaoResult;
import com.qingge.mapper.TbItemParamMapper;
import com.qingge.pojo.TbItemParam;
import com.qingge.pojo.TbItemParamExample;
import com.qingge.pojo.TbItemParamExample.Criteria;
import com.qingge.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	
	@Override
	public TaotaoResult getItemParamByCid(Long cid) {
		// TODO Auto-generated method stub
		TbItemParamExample tbItemParamExample=new TbItemParamExample();
		Criteria criteria = tbItemParamExample.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> itemList = tbItemParamMapper.selectByExample(tbItemParamExample);
		//判断结果是否有值
		if(itemList!=null && itemList.size()>0){
			return TaotaoResult.ok(itemList.get(0));
		}
		return TaotaoResult.ok();
	}

}
