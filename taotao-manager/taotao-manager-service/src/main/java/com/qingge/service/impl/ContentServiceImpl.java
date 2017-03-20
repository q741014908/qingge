package com.qingge.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingge.common.pojo.TaotaoResult;
import com.qingge.mapper.TbContentMapper;
import com.qingge.pojo.TbContent;
import com.qingge.service.ContentService;
/**
 * 内容管理
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月19日下午4:55:49
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public TaotaoResult insertContent(TbContent tbContent) {
		//补全tbContent内容
		tbContent.setCreated(new Date());
		tbContent.setUpdated(new Date());
		contentMapper.insert(tbContent);
		return TaotaoResult.ok();
	}

}
