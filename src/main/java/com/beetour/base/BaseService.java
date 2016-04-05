

package com.beetour.base;

import java.util.List;

/**
 * 通用接口
 */
public interface BaseService<T> {

	void save(T entity);

	void delete(T t);

	void update(T t);

	T selectByKey(T t);

	List<T> findAll();

	List<T> selectByPage(T t,int pageSize,int page);
}
