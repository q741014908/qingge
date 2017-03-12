package com.qingge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingge.common.pojo.EasyUITreeNode;
import com.qingge.mapper.TbItemCatMapper;
import com.qingge.pojo.TbItemCat;
import com.qingge.pojo.TbItemCatExample;
import com.qingge.pojo.TbItemCatExample.Criteria;
import com.qingge.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getCatList(Long parentId) {
		// TODO Auto-generated method stub
		//创建查询条件
		TbItemCatExample tbItemExample=new TbItemCatExample();
		Criteria criteria = tbItemExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> selectByExample = tbItemCatMapper.selectByExample(tbItemExample);
		List<EasyUITreeNode> resultList=new ArrayList<EasyUITreeNode>();
		for (TbItemCat tbItemCat : selectByExample) {
			EasyUITreeNode easyUITreeNode=new EasyUITreeNode();
			easyUITreeNode.setId(tbItemCat.getId());
			easyUITreeNode.setText(tbItemCat.getName());
			easyUITreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(easyUITreeNode);
		}
		return resultList;
	}

}
