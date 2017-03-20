package com.qingge.rest.service;

import java.util.List;

import com.qingge.pojo.TbContent;

public interface ContentService {

	List<TbContent> getContentList(Long contentId);
}
