package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * 
 * @author Laxminarayana 10th october 2014 6:57:54 PM
 * 
 */
public class CustomComparatorUtil {
	public static OrderByComparator getReportingMethodsOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equalsIgnoreCase("reportingmethodName")) {

			orderByComparator = new ReportingNameComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
