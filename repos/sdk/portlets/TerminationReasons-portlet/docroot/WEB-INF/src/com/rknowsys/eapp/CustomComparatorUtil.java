package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * 
 * @author Laxminarayana 10th october 2014 6:59:55 PM
 * 
 */
public class CustomComparatorUtil {
	public static OrderByComparator getterminationreasonsOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equalsIgnoreCase("terminationreasonsName")) {

			orderByComparator = new TerminationReasonNameComparator(orderByAsc);
		}

		return orderByComparator;
	}

}
