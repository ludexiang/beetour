package com.beetour.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.mongodb.core.query.Criteria;

public class CriteriaUtil {
	
	/**
	 * 获取查询条件</br>
	 * 这个方法中条件组合方式为Criteria.where().is()
	 * 
	 * @param nameValue
	 *            传入的条件，key为字段名，value为字段名对应的值
	 * @return 查询条件
	 */
	public static Criteria getCriteriaOfIs(Map<String, Object> nameValue) {
		if (nameValue == null || nameValue.isEmpty()) {
			return null;
		}
		List<Criteria> listC = new ArrayList<Criteria>();
		for (Map.Entry<String, Object> element : nameValue.entrySet()) {
			listC.add(Criteria.where(element.getKey()).is(element.getValue()));
		}
		Criteria[] cs = new Criteria[listC.size()];
		Criteria c = new Criteria();
		c.andOperator(listC.toArray(cs));
		return c;
	}
	
	

    /**
     * 查询语句
     * @param gtMap		sql中的" > "	
     * @param ltMap		sql中的" < "
     * @param eqMap		sql中的" = "		
     * @param gteMap		sql中的 " >= "	
     * @param lteMap		sql中的" <= "	
     * @param regexMap		sql中的" regex "	
     * @param inMap		sql中的" in "	
     * @param neMap		sql中的" != "	
     * @return Criteria 查询的语句
     */
    @SuppressWarnings("rawtypes")
	public Criteria createCriteria(Map<String, Object> gtMap,
            Map<String, Object> ltMap, Map<String, Object> eqMap,
            Map<String, Object> gteMap, Map<String, Object> lteMap,
            Map<String, String> regexMap, Map<String, Collection> inMap,
            Map<String, Object> neMap) {
        Criteria c = new Criteria();
        List<Criteria> listC= new ArrayList<Criteria>();
        Set<String> _set = null;
        if (gtMap != null && gtMap.size() > 0) {
            _set = gtMap.keySet();
            for (String _s : _set) {
                listC.add( Criteria.where(_s).gt(gtMap.get(_s)));
            }
        }
        if (ltMap != null && ltMap.size() > 0) {
            _set = ltMap.keySet();
            for (String _s : _set) {
                listC.add(  Criteria.where(_s).lt(ltMap.get(_s)));
            }
        }
        if (eqMap != null && eqMap.size() > 0) {
            _set = eqMap.keySet();
            for (String _s : _set) {
                listC.add(  Criteria.where(_s).is(eqMap.get(_s)));
            }
        }
        if (gteMap != null && gteMap.size() > 0) {
            _set = gteMap.keySet();
            for (String _s : _set) {
                listC.add( Criteria.where(_s).gte(gteMap.get(_s)));
            }
        }
        if (lteMap != null && lteMap.size() > 0) {
            _set = lteMap.keySet();
            for (String _s : _set) {
                listC.add(  Criteria.where(_s).lte(lteMap.get(_s)));
            }
        }
 
        if (regexMap != null && regexMap.size() > 0) {
            _set = regexMap.keySet();
            for (String _s : _set) {
                listC.add(  Criteria.where(_s).regex(regexMap.get(_s)));
            }
        }
 
        if (inMap != null && inMap.size() > 0) {
            _set = inMap.keySet();
            for (String _s : _set) {
                listC.add(  Criteria.where(_s).in(inMap.get(_s)));
            }
        }
        if (neMap != null && neMap.size() > 0) {
            _set = neMap.keySet();
            for (String _s : _set) {
                listC.add( Criteria.where(_s).ne(neMap.get(_s)));
            }
        }
        if(listC.size() > 0){
            Criteria [] cs = new Criteria[listC.size()];
            c.andOperator(listC.toArray(cs));
        }
        return c;
    }
	
}
