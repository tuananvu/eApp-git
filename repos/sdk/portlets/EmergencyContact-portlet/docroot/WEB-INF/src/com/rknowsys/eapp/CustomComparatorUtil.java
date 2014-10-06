package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

import org.apache.log4j.Logger;

public class CustomComparatorUtil {

	public static final String EMERGENCY_CONTACT_COL_NAME = "emergencycontactId";
	public static final String ORDER_TYPE_ASC = "asc";
	
	private static Logger log = Logger.getLogger(CustomComparatorUtil.class);
	
	public static OrderByComparator getEmergencyContactOrderByComparator(
			String orderByCol, String orderByType) {
 
		boolean orderByAsc = false;

		if (orderByType.equals(ORDER_TYPE_ASC)) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		log.info("Inside getEmergencyContactOrderByComparator(): Order by Column: " + orderByCol);
		
		if (orderByCol.equalsIgnoreCase(EMERGENCY_CONTACT_COL_NAME)) {
			orderByComparator = new EmergencyContactComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
