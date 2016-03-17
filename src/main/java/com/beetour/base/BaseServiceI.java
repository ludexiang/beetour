

package com.beetour.base;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 通用接口
 */
@Service
public interface BaseServiceI<T> {

	void save(T entity);

	void delete(T t);

	void update(T t);

	T selectByKey(T t);

	List<T> selectByExample(Class<T> t);

	List<T> selectByPage(T t,int pageSize,int page);
}
