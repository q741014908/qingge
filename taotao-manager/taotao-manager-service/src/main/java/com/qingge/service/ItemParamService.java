package com.qingge.service;

import com.qingge.common.pojo.TaotaoResult;
import com.qingge.pojo.TbItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(Long cid);
	
	TaotaoResult insertItemParam(TbItemParam tbItemParam);
}
