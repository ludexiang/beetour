package com.beetour.controller.mobile;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.beetour.controller.CustomerController;
import com.beetour.domain.item.Item;
import com.beetour.domain.item.Itemgp;
import com.beetour.service.ItemService;
import com.beetour.service.ItemgpService;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("project")
public class ItemController {

	protected final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemgpService itemgpService;

	@Autowired
	private ItemService itemService;

	/**
	 * 获取所有项目分类
	 * @return
	 */
	@RequestMapping(value = "/itemgp/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "项目所有分类", httpMethod = "GET", notes = "id:项目分类id<br/> catetoryName:项目分类名称<br/> "
			+ "pic:项目分类图片（subTpic：大图地址，subPic：缩略图地址，subSpic：小图地址）<br/> "
			+ "introduction:项目介绍<br/> 另：忽略其他字段")
	public ResponseEntity<List<Itemgp>> selectItemgpAll() {
		List<Itemgp> all = itemgpService.findAll();
		if (all == null || all.isEmpty()) {
			LOGGER.info("Fetching with All is not found!");
			return new ResponseEntity<List<Itemgp>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Itemgp>>(all, HttpStatus.OK);
	}

	/**
	 * 获取一个项目分类
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/itemgp/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "单个项目分类", httpMethod = "GET", notes = "id:项目分类id<br/> catetoryName:项目分类名称<br/> "
			+ "pic:项目分类图片（subTpic：大图地址，subPic：缩略图地址，subSpic：小图地址）<br/> "
			+ "introduction:项目介绍<br/> 另：忽略其他字段")
	public ResponseEntity<Itemgp> selectItemgpOne(@PathVariable("id") String id) {
		Itemgp i = new Itemgp();
		i.setId(id);
		Itemgp itemgp = itemgpService.selectByKey(i);
		if (itemgp == null) {
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return new ResponseEntity<Itemgp>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Itemgp>(itemgp, HttpStatus.OK);
	}
	
	/**
	 * 获取所有项目
	 * @return
	 */
	@RequestMapping(value = "/item/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "所有项目", httpMethod = "GET", notes = "id:项目id<br/> entityName:项目名称<br/> "
			+ "pic:项目图片（subTpic：大图地址，subPic：缩略图地址，subSpic：小图地址）<br/> "
			+ "destination:地点<br/> synopsis:概要<br/> entityContext:活动内容<br/> requirement:须知<br/> "
			+ "harvest:收获<br/> time:时间（startime：起始时间，endtime：结束时间）<br/> "
			+ "price:价格（baseTotalAmount：市场价，basePreferentialPrice：优惠价，perPrice：团购价）<br/> "
			+ "costInfo:费用说明<br/> include:包括<br/> notInclude:不包括<br/> "
			+ "isTop:是否置顶，默认不置顶（false不置顶，true置顶）<br/> ")
	public ResponseEntity<List<Item>> selectItemAll() {
		List<Item> all = itemService.findAll();
		if (all == null || all.isEmpty()) {
			LOGGER.info("Fetching with All is not found!");
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(all, HttpStatus.OK);
	}
	
	/**
	 * 获取一个项目分类
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/item/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "单个项目详情", httpMethod = "GET", notes = "id:项目id<br/> entityName:项目名称<br/> "
			+ "pic:项目图片（subTpic：大图地址，subPic：缩略图地址，subSpic：小图地址）<br/> "
			+ "destination:地点<br/> synopsis:概要<br/> entityContext:活动内容<br/> requirement:须知<br/> "
			+ "harvest:收获<br/> time:时间（startime：起始时间，endtime：结束时间）<br/> "
			+ "price:价格（baseTotalAmount：市场价，basePreferentialPrice：优惠价，perPrice：团购价）<br/> "
			+ "costInfo:费用说明<br/> include:包括<br/> notInclude:不包括<br/> "
			+ "isTop:是否置顶，默认不置顶（false不置顶，true置顶）<br/> ")
	public ResponseEntity<Item> selectItemOne(@PathVariable("id") String id) {
		Item i = new Item();
		i.setId(id);
		Item item = itemService.selectByKey(i);
		if (item == null) {
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	
	

}
