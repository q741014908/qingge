package com.qingge.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingge.common.pojo.EasyUIDataGridResult;
import com.qingge.common.pojo.TaotaoResult;
import com.qingge.common.utils.IDUtils;
import com.qingge.mapper.TbItemDescMapper;
import com.qingge.mapper.TbItemMapper;
import com.qingge.mapper.TbItemParamItemMapper;
import com.qingge.pojo.TbItem;
import com.qingge.pojo.TbItemDesc;
import com.qingge.pojo.TbItemExample;
import com.qingge.pojo.TbItemExample.Criteria;
import com.qingge.pojo.TbItemParamItem;
import com.qingge.properties.ResourceProperties;
import com.qingge.service.ItemService;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		//添加查询条件
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 商品列表查询
	 * <p>Title: getItemList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param rows
	 * @return
	 * @see com.qingge.service.ItemService#getItemList(long, long)
	 */
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		TbItemExample example=new TbItemExample();
		//分页处理啊
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem tbItem,String desc,String itemParam) {
		// TODO Auto-generated method stub
		//item补全
		tbItem.setId(IDUtils.genItemId());
		//商品的状态
		tbItem.setStatus((byte) 1);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(tbItem);
		//添加商品描述信息
		insertItemDesc(tbItem.getId(), desc);
		//添加规格参数
		inserItemParamItem(tbItem.getId(), itemParam);
		return TaotaoResult.ok();
	}
	
	/**
	 * 添加商品描述
	 * <p>Title: insertItemDesc</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @param desc
	 * @return
	 */
	private TaotaoResult insertItemDesc(Long itemId,String desc){
		TbItemDesc itemDesc =new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}
	
	private TaotaoResult inserItemParamItem(Long itemId,String itemparam){
		//创建一个pojo
		TbItemParamItem itemParamItem=new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemparam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		itemParamItemMapper.insert(itemParamItem);
		return TaotaoResult.ok();
	}
}
