package com.beetour.service.impl;

import org.springframework.stereotype.Service;

import com.beetour.domain.item.Item;
import com.beetour.base.BaseServiceImpl;
import com.beetour.service.ItemService;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

	@Override
	protected Class<Item> getEntityClass() {
		return Item.class;
	}



}
