package com.beetour.service.impl;

import org.springframework.stereotype.Service;

import com.beetour.domain.Banner;
import com.beetour.base.BaseServiceImpl;
import com.beetour.service.BannerService;

@Service
public class BannerServiceImpl extends BaseServiceImpl<Banner> implements BannerService {

	@Override
	protected Class<Banner> getEntityClass() {
		return Banner.class;
	}



}
