package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

import org.apache.log4j.Logger;

public class CustomComparatorUtil {

	public static final String DEPENDENTS_COL_NAME = "dependentsId";
	public static final String ORDER_TYPE_ASC = "asc";
	
	private static Logger log = Logger.getLogger(CustomComparatorUtil.class);
	
	public static OrderByComparator getDependentOrderByComparator(
			String orderByCol, String orderByType) {
 
		boolean orderByAsc = false;

		if (orderByType.equals(ORDER_TYPE_ASC)) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		log.info("Inside getDependentOrderByComparator(): Order by Column: " + orderByCol);
		
		if (orderByCol.equalsIgnoreCase(DEPENDENTS_COL_NAME)) {
			orderByComparator = new DependentComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
