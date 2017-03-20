package com.qingge.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingge.mapper.TbContentMapper;
import com.qingge.pojo.TbContent;
import com.qingge.pojo.TbContentExample;
import com.qingge.pojo.TbContentExample.Criteria;
import com.qingge.rest.service.ContentService;
/**
 * 内容管理
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月19日下午8:01:56
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public List<TbContent> getContentList(Long contentId) {
		// TODO Auto-generated method stub
		TbContentExample example=new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentId);
		//执行查询
		return contentMapper.selectByExample(example);
	}

}
