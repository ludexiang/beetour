package com.beetour.service;

import com.beetour.base.BaseService;
import com.beetour.domain.item.Item;
import com.beetour.domain.item.Itemgp;

public interface ItemgpService extends BaseService<Itemgp> {

	/**
	 * 添加itemIds
	 * @param item
	 */
	void saveItemId(Item item);

	/**
	 * 修改itemIds
	 * @param item
	 */
	boolean updateItemIds(Item item);

	/**
	 * 删除itemId
	 * @param item
	 */
	void deleteItemId(Item item);

}
