package com.beetour.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.beetour.domain.item.Itemgp;
import com.beetour.base.BaseDaoImpl;
import com.beetour.dao.ItemgpDao;

@Repository
public class ItemgpDaoImpl extends BaseDaoImpl<Itemgp> implements ItemgpDao {

	@Override
	public void updateItemsIds(Itemgp itemgp) {
		Query query = new Query(Criteria.where("id").is(itemgp.getId()) );
		Update update = new Update().set("itemIds", itemgp.getItemIds());
		mongo.updateFirst(query, update, Itemgp.class);
	}

	
}
