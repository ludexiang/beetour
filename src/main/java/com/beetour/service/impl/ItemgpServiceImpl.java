package com.beetour.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beetour.domain.item.Item;
import com.beetour.domain.item.Itemgp;
import com.beetour.base.BaseServiceImpl;
import com.beetour.dao.ItemgpDao;
import com.beetour.service.ItemgpService;

@Service
public class ItemgpServiceImpl extends BaseServiceImpl<Itemgp> implements ItemgpService {
	
	@Autowired
	private ItemgpDao itemgpdao;

	@Override
	protected Class<Itemgp> getEntityClass() {
		return Itemgp.class;
	}

	@Override
	public void saveItemId(Item item) {		
		Itemgp itemgp = getItemgp(item);
		List<String> itemIds = itemgp.getItemIds();
		if(itemIds == null){
			itemIds = new ArrayList<String>();
		}
		itemIds.add(item.getId());
		itemgp.setItemIds(itemIds);
		itemgpdao.updateItemsIds(itemgp);
	}

	private Itemgp getItemgp(Item item) {
		Itemgp t = new Itemgp();
		t.setId(item.getItemgpId());
		Itemgp itemgp = itemgpdao.selectById(t);
		return itemgp;
	}

	@Override
	public boolean updateItemIds(Item item) {
		return true;
	}

	@Override
	public void deleteItemId(Item item) {
		Itemgp itemgp = getItemgp(item);
		List<String> itemIds = itemgp.getItemIds();
		if(itemIds == null){
			return;
		}		
		Iterator<String> it = itemIds.iterator();
        while (it.hasNext()) {
            String value = it.next();
            if (item.getItemgpId().equals(value)) {
                it.remove();//删除集合中对应的itemId
            }
        }
        itemgp.setItemIds(itemIds);
		itemgpdao.updateItemsIds(itemgp);
	}



}
