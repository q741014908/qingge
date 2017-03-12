package com.qingge.service;


import java.util.List;

import com.qingge.common.pojo.EasyUITreeNode;

public interface ItemCatService {

	List<EasyUITreeNode> getCatList(Long parentId); 
}
