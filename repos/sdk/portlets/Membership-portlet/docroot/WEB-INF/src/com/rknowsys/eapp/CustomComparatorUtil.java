package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	public static OrderByComparator getMembershipOrderByComparator(
			   String orderByCol, String orderByType) {
			  
			  
			   boolean orderByAsc = false;
			 
			   if (orderByType.equals("asc")) {
			   orderByAsc = true;
			   }
			 
			   OrderByComparator orderByComparator = null;
			   
			   
			   if (orderByCol.equalsIgnoreCase("membershipName")) {
			    
			    orderByComparator = new MembershipComparator(orderByAsc);
			   } 
			   
			   return orderByComparator;
			   }


}
