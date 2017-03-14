package com.qingge.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qingge.common.utils.FtpUtil;
import com.qingge.common.utils.IDUtils;
import com.qingge.properties.ResourceProperties;
import com.qingge.service.PictureService;
/**
 * 图片上传服务
 * <p>Title: PictureServiceImpl</p>
 * <p>Description: </p>
 * @author	走走停停
 * @date	2017年3月13日下午1:09:07
 * @version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private ResourceProperties resourceProperties;
	
	@Override
	public Map uploadPicture(MultipartFile file) {
		Map resultMap=new HashMap();
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = file.getOriginalFilename();
			//生成新文件名
			String newName=IDUtils.genImageName();
			newName = newName+ oldName.substring(oldName.lastIndexOf("."));
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			//图片上传
			boolean result = FtpUtil.uploadFile(resourceProperties.getFtpAddress(), 
					resourceProperties.getFtpPort(),
					resourceProperties.getFtpUsername(), 
					resourceProperties.getFtpPassword(), 
					resourceProperties.getFtpBase_path(),
					imagePath, newName, file.getInputStream());
			if(result){
				resultMap.put("error", 0);
				resultMap.put("url", resourceProperties.getFtpBaseUrl()+imagePath+File.separatorChar+newName);
			}else{
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
			}
		} catch (IOException e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传失败");
		}
		return resultMap;
	}

}
