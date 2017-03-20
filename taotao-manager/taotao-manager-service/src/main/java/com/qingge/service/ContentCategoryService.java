package com.qingge.service;

import java.util.List;

import com.qingge.common.pojo.EasyUITreeNode;
import com.qingge.common.pojo.TaotaoResult;

public interface ContentCategoryService {

	List<EasyUITreeNode> getCategoryList(Long parentId);

	TaotaoResult insertContentCategory(Long parentId,String name);
	
	TaotaoResult deleteContentCategory(Long nodeId);
	
	TaotaoResult updateContentCategory(Long id,String nodeText);
}
