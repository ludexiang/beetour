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

import com.beetour.domain.item.Itemgp;
import com.beetour.service.ItemgpService;
import com.beetour.util.DateUtil;
import com.beetour.util.Page;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("itemgp")
public class ItemgpWebController {

	protected final Logger LOGGER = LoggerFactory.getLogger(ItemgpWebController.class);

	@Autowired
	private ItemgpService itemgpService;
	
	private String redirect_list = "redirect:list";

	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ApiOperation(hidden = true, value = "")
	public String save(Itemgp itemgp) {
		itemgp.setCreated(DateUtil.getDate());
		itemgpService.save(itemgp);
		return redirect_list;
	}
	
	
	//update
	@RequestMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(hidden = true, value = "")
	public String update(String id,Itemgp itemgp, Model model) {
		LOGGER.info("Fetching&Updating One with id:" + id);
		Itemgp i = itemgpService.selectByKey(itemgp);
		if (i == null) {
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return "error";
		}
		itemgpService.update(itemgp);
		return redirect_list;
	}
	
	// delete
	@RequestMapping(value = "delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(hidden = true, value = "")
	public String delete(String id, Model model) {
		LOGGER.info("Fetching&Deleting One with id:" + id);
		Itemgp i = new Itemgp();
		i.setId(id);
		Itemgp c = itemgpService.selectByKey(i);
			
		if (c == null) {
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return "error";
		}
		itemgpService.delete(i);
		return redirect_list;
	}

	@RequestMapping(value =  "{lists}" )
	@ApiOperation(hidden = true, value = "")
	public String getList(Itemgp itemgp, @RequestParam(required = false, defaultValue = "1") int page, 
			@PathVariable(value = "lists") String lists,
			Model model) {
		Page pages = null;
		int totalCount = itemgpService.findAll().size();
		List<Itemgp> list = new ArrayList<Itemgp>();

		if (page != 1) {
			pages = new Page(totalCount, page);
			list = itemgpService.selectByPage(itemgp, pages.getPageSize(), page);
		} else {
			pages = new Page(totalCount, 1);
			list = itemgpService.selectByPage(itemgp, pages.getPageSize(), page);
		}
		model.addAttribute("itemgp", list);
		model.addAttribute("page", page);
		model.addAttribute("totalCount", totalCount);
		if(lists.equals("ajax")){			
			return "itemgp/itemgp2";
		} else {
			return "itemgp/itemgp";
		}
	}
	
	//新增跳转
	@RequestMapping(value =  "create" )
	@ApiOperation(hidden = true, value = "")
	public String create(){
		return "itemgp/create";
	}
	
	//修改跳转
	@RequestMapping(value =  "updateRedirect")
	@ApiOperation(hidden = true, value = "")
	public String updateRedirect(String id, Model model){
		LOGGER.info("updateRedirect One with id:" + id);
		Itemgp itemgp = new Itemgp();
		itemgp.setId(id);
		Itemgp i = itemgpService.selectByKey(itemgp);
		if (i == null) {
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			return "error";
		}
		model.addAttribute("itemgp", i);
		return "itemgp/update";
	}
	
	
}
