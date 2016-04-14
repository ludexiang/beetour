package com.beetour.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.beetour.domain.Banner;
import com.beetour.service.BannerService;
import com.beetour.util.DateUtil;
import com.beetour.util.Page;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("banner")
public class BannerWebController {

	protected final Logger LOGGER = LoggerFactory.getLogger(BannerWebController.class);

	@Autowired
	private BannerService bannerService;
	
	private String redirect_list = "redirect:list";

	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ApiOperation(hidden = true, value = "")
	public String save(Banner banner) {
		banner.setCreated(DateUtil.getDate());
		bannerService.save(banner);
		return redirect_list;
	}
	
	
	//update
	@RequestMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(hidden = true, value = "")
	public String update(String id,Banner banner, Model model) {
		LOGGER.info("Fetching&Updating One with id:" + id);
		Banner b = bannerService.selectByKey(banner);
		if (b == null) {
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return "error";
		}
		banner.setCreated(DateUtil.getDate());
		bannerService.update(banner);
		return redirect_list;
	}
	
	// delete
	@RequestMapping(value = "delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(hidden = true, value = "")
	public String delete(String id, Model model) {
		LOGGER.info("Fetching&Deleting One with id:" + id);
		Banner b = new Banner();
		b.setId(id);
		Banner c = bannerService.selectByKey(b);
			
		if (c == null) {
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return "error";
		}
		bannerService.delete(b);
		return redirect_list;
	}

	@RequestMapping(value =  "{lists}" )
	@ApiOperation(hidden = true, value = "")
	public String getList(Banner banner, @RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int rows,
			@PathVariable(value = "lists") String lists,
			Model model) {
		Page pages = null;
		int totalCount = bannerService.findAll().size();
		List<Banner> list = new ArrayList<Banner>();

		if (page != 1) {
			pages = new Page(totalCount, page, rows);
			list = bannerService.selectByPage(banner, pages.getPageSize(), page);
		} else {
			pages = new Page(totalCount, 1, rows);
			list = bannerService.selectByPage(banner, pages.getPageSize(), page);
		}
		model.addAttribute("banner", list);
		model.addAttribute("page", page);
		model.addAttribute("totalCount", totalCount);
		if(lists.equals("ajax")){			
			return "banner/banner2";
		} else {
			return "banner/banner";
		}
	}
	
	//新增跳转
	@RequestMapping(value =  "create" )
	@ApiOperation(hidden = true, value = "")
	public String create(){
		return "banner/create";
	}
	
	//修改跳转
	@RequestMapping(value =  "updateRedirect")
	@ApiOperation(hidden = true, value = "")
	public String updateRedirect(String id, Model model){
		LOGGER.info("updateRedirect One with id:" + id);
		Banner banner = new Banner();
		banner.setId(id);
		Banner b = bannerService.selectByKey(banner);
		if (b == null) {
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			return "error";
		}
		model.addAttribute("banner", b);
		return "banner/update";
	}
	
	
}
