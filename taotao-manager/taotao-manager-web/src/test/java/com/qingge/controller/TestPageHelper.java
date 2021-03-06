package com.qingge.controller;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingge.mapper.TbItemMapper;
import com.qingge.pojo.TbItem;
import com.qingge.pojo.TbItemExample;

public class TestPageHelper {
	
	@Test
	public void testPageHelper(){
		//创建一个spring容器
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		//执行查询并分页
		TbItemExample example=new TbItemExample();
		//分页处理
		PageHelper.startPage(1, 10);
		List<TbItem> list = mapper.selectByExample(example);
		//获取商品列表
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		//取分页信息
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品信息:"+total);
	}
}
