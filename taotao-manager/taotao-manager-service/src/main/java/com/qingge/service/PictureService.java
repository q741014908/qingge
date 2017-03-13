package com.qingge.service;

import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

public interface PictureService {

	Map uploadPicture(MultipartFile file);
}
