package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

import org.apache.log4j.Logger;

public class CustomComparatorUtil {

	public static final String WORKSHIFT_COL_NAME = "workshiftName";
	public static final String ORDER_TYPE_ASC = "asc";
	
	private static Logger log = Logger.getLogger(CustomComparatorUtil.class);
	
	public static OrderByComparator getWorkshiftOrderByComparator(
			String orderByCol, String orderByType) {
 
		boolean orderByAsc = false;

		if (orderByType.equals(ORDER_TYPE_ASC)) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		log.info("Inside getWorkshiftOrderByComparator(): Order by Column: " + orderByCol);
		
		if (orderByCol.equalsIgnoreCase(WORKSHIFT_COL_NAME)) {
			orderByComparator = new WorkshiftComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
