package com.qingge.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qingge.common.pojo.TaotaoResult;
import com.qingge.common.utils.HttpClientUtil;
import com.qingge.common.utils.JsonUtils;
import com.qingge.pojo.TbContent;
import com.qingge.portal.service.ContentService;
/**
 * 
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月20日上午10:34:56
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	
	@Override
	public String getContentList() {
		// TODO Auto-generated method stub
		try {
			String result = HttpClientUtil.doGet(REST_BASE_URL+REST_INDEX_AD_URL);
			TaotaoResult resultList = TaotaoResult.formatToList(result, TbContent.class);
			List<TbContent> data = (List<TbContent>) resultList.getData();
			List<Map> resultMapList=new ArrayList<Map>();
			for (TbContent tbContent : data) {
				Map map=new HashMap<>();
				map.put("src", tbContent.getPic());
				map.put("srcB", tbContent.getPic2());
				map.put("width", 670);
				map.put("height", 240);
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", tbContent.getUrl());
				map.put("alt", tbContent.getSubTitle());
				resultMapList.add(map);
			}
			return JsonUtils.objectToJson(resultMapList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
