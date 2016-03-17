package com.beetour.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;

import com.beetour.order;

/**
 * 操作类对象的工具类
 * 
 * @author xanderlu
 *
 */
public class ClassUtil {
	
	

	/**
	 * 获取类对象的字段及其值
	 * 
	 * @param obj
	 *            需要获取的对象
	 * @return key为字段名，value为字段名对应的值
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Map<String, Object> getFieldsNameAndValue(Object obj)
			throws IllegalArgumentException, IllegalAccessException {
		if (null == obj) {
			return null;
		}
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		Map<String, Object> nameValue = new HashMap<String, Object>();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			String name = field.getName();
			Object value = field.get(obj);
			Class<?> type = field.getType();
			if (null != value) {
				nameValue.put(name, value);
			}
		}
		return nameValue;
	}

	/**
	 * 获取对象中的主键值
	 * 
	 * @param obj
	 *            对象
	 * @return 对应类中@Id的值
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getIdValue(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
		Object value = null;
		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(Id.class)) {
				field.setAccessible(true);
				value = field.get(obj);
				break;
			}
		}
		return value;
	}
}
