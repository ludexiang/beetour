package com.beetour.controller.mobile;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beetour.domain.Banner;
import com.beetour.service.BannerService;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
public class BannerController {
	
	protected final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private BannerService bannerService;
	
	@RequestMapping(value =  "banner",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "首页轮播图", httpMethod = "GET", notes = "pic:图片地址<br/> "
			+ "show:是否显示（0：不显示，1：显示）<br/> 另：忽略其他字段")
	public ResponseEntity<List<Banner>> banner(){		
		List<Banner> all = bannerService.findAll();
		if (all == null || all.isEmpty()) {
			LOGGER.info("Fetching with BannerAll is not found!");
			return new ResponseEntity<List<Banner>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Banner>>(all, HttpStatus.OK);
	}
}
