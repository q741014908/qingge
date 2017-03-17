package com.qingge.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingge.common.pojo.EasyUITreeNode;
import com.qingge.common.pojo.TaotaoResult;
import com.qingge.mapper.TbContentCategoryMapper;
import com.qingge.pojo.TbContentCategory;
import com.qingge.pojo.TbContentCategoryExample;
import com.qingge.pojo.TbContentCategoryExample.Criteria;
import com.qingge.service.ContentCategoryService;
/**
 * 内容分类管理
 * <p>Title: ContentCategoryServiceImpl</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月17日下午2:05:35
 * @version 1.0
 */

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	@Override
	public List<EasyUITreeNode> getCategoryList(Long parentId) {
		// TODO Auto-generated method stub
		//根据parenId查询节点列表
		TbContentCategoryExample example=new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EasyUITreeNode> resultList=new ArrayList<EasyUITreeNode>();
		for (TbContentCategory tbContentCategory : list) {
			//创建一个节点
			EasyUITreeNode node=new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public TaotaoResult insertContentCategory(Long parentId, String name) {
        //创建一个pojo
		TbContentCategory contentCategory=new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//1正常 2删除
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent是否为true,如果不是true改为true
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!parentCat.getIsParent()){
			parentCat.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok(contentCategory);
	}

	@Override
	public TaotaoResult deleteContentCategory(Long parentId, Long nodeId) {
		// TODO Auto-generated method stub
		deleteChirldContentCategory(nodeId);
		TbContentCategory tbContentCategory = contentCategoryMapper.selectByPrimaryKey(parentId);
		tbContentCategory.setIsParent(false);
		tbContentCategory.setUpdated(new Date());
		contentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
		return TaotaoResult.ok();
	}
	/**
	 * 递归删除子节点
	 * <p>Title: deleteChirldContentCategory</p>
	 * <p>Description: </p>
	 * @param parentId 父节点id
	 */
	private void deleteChirldContentCategory(Long parentId){
		contentCategoryMapper.deleteByPrimaryKey(parentId);
		TbContentCategoryExample example=new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> tbContentCategoryList = contentCategoryMapper.selectByExample(example);
		if(tbContentCategoryList!=null){
			for (TbContentCategory tbContentCategory : tbContentCategoryList) {
				if(tbContentCategory.getIsParent()){
					deleteChirldContentCategory(tbContentCategory.getId());
				}
			}
		}
	}

}
