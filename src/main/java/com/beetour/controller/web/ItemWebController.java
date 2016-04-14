package com.beetour.controller.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.beetour.domain.item.Item;
import com.beetour.domain.item.Itemgp;
import com.beetour.service.ItemService;
import com.beetour.service.ItemgpService;
import com.beetour.util.DateUtil;
import com.beetour.util.Page;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("item")
public class ItemWebController {

	protected final Logger LOGGER = LoggerFactory.getLogger(ItemWebController.class);

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemgpService itemgpService;
	
	private String redirect_list = "redirect:list";

	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ApiOperation(hidden = true, value = "")
	public String save(Item item) {
		item.setCreated(DateUtil.getDate());
		itemService.save(item);
		itemgpService.saveItemId(item);
		return redirect_list;
	}
	
	
	//update
	@RequestMapping(value = "update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(hidden = true, value = "")
	public String update(String id,Item item, Model model) {
		LOGGER.info("Fetching&Updating One with id:" + id);
		Item i = itemService.selectByKey(item);
		if (i == null) {
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return "error";
		}
		boolean updateItemIds = itemgpService.updateItemIds(item);
		if(updateItemIds){
			item.setCreated(DateUtil.getDate());
			itemService.update(item);
		}
		return redirect_list;
	}
	
	// delete
	@RequestMapping(value = "delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(hidden = true, value = "")
	public String delete(String id, Model model) {
		LOGGER.info("Fetching&Deleting One with id:" + id);
		Item i = new Item();
		i.setId(id);
		Item c = itemService.selectByKey(i);
			
		if (c == null) {
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return "error";
		}
		itemService.delete(i);
		itemgpService.deleteItemId(c);
		return redirect_list;
	}

	@RequestMapping(value =  "{lists}" )
	@ApiOperation(hidden = true, value = "")
	public String getList(Item item, @RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int rows,
			@PathVariable(value = "lists") String lists,
			Model model) {
		Page pages = null;
		int totalCount = itemService.findAll().size();
		List<Item> list = new ArrayList<Item>();
		if (page != 1) {
			pages = new Page(totalCount, page, rows);
			list = itemService.selectByPage(item, pages.getPageSize(), page);
		} else {
			pages = new Page(totalCount, 1, rows);
			list = itemService.selectByPage(item, pages.getPageSize(), page);
		}
		model.addAttribute("item", list);
		model.addAttribute("page", page);
		model.addAttribute("totalCount", totalCount);
		if(lists.equals("ajax")){			
			return "item/item2";
		} else {
			return "item/item";
		}
	}
	
	//新增跳转
	@RequestMapping(value =  "/create" )
	@ApiOperation(hidden = true, value = "")
	public String create(Model model){
		List<Itemgp> list = itemgpService.findAll();
		model.addAttribute("itemgp", list);
		return "item/create";
	}
	
	//修改跳转
	@RequestMapping(value =  "updateRedirect")
	@ApiOperation(hidden = true, value = "")
	public String updateRedirect(String id, Model model){
		LOGGER.info("updateRedirect One with id:" + id);
		Item item = new Item();
		item.setId(id);
		Item i = itemService.selectByKey(item);
		if (i == null) {
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			model.addAttribute("error", "Fetching One with id:" + id + " is not found!");
			return "error";
		}
		List<Itemgp> list = itemgpService.findAll();
		model.addAttribute("itemgp", list);
		model.addAttribute("item", i);
		return "item/update";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//true:允许输入空值，false:不能为空值
	}
}
