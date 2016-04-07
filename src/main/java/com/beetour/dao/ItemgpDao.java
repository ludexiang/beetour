package com.beetour.dao;


import com.beetour.domain.item.Itemgp;
import com.beetour.base.BaseDao;

public interface ItemgpDao extends BaseDao<Itemgp> {

	void updateItemsIds(Itemgp itemgp);

}
