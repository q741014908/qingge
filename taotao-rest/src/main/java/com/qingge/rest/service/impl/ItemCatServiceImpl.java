package com.qingge.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingge.mapper.TbItemCatMapper;
import com.qingge.pojo.TbItemCat;
import com.qingge.pojo.TbItemCatExample;
import com.qingge.pojo.TbItemCatExample.Criteria;
import com.qingge.rest.pojo.CatNode;
import com.qingge.rest.pojo.CatResult;
import com.qingge.rest.service.ItemCatService;
/**
 * 商品分类服务
 * <p>Title: ItemCatServiceImpl</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月16日上午11:16:53
 * @version 1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCatList() {
		CatResult catResult=new CatResult();
		catResult.setData(getCatList(0L));
		return catResult;
	}
	/**
	 * 查询分类列表的方法
	 * <p>Title: getCatList</p>
	 * <p>Description: </p>
	 * @param parenId
	 * @return
	 */
	private List<?> getCatList(Long parentId){
		//创建查询条件
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list=itemCatMapper.selectByExample(example);
		List resultList=new ArrayList();
		if(list==null || list.isEmpty()){
			return resultList;
		}
		//向list中添加节点
		for (TbItemCat tbItemCat : list) {
			if(tbItemCat.getIsParent()){
				CatNode catNode=new CatNode();
				if(parentId==0){
					catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName());
				}else{
					catNode.setName(tbItemCat.getName());
				}
				catNode.setUrl("/products/"+tbItemCat.getId()+".html");
				catNode.setItem(getCatList(tbItemCat.getId()));
				resultList.add(catNode);
			}else{
				resultList.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName());
			}
			
		}
		return resultList;
	}
}
