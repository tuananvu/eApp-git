package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	public static OrderByComparator getSkillsrOrderByComparator(
			   String orderByCol, String orderByType) {
			  
			  
			   boolean orderByAsc = false;
			 
			   if (orderByType.equals("asc")) {
			   orderByAsc = true;
			   }
			 
			   OrderByComparator orderByComparator = null;
			   
			   
			   if (orderByCol.equalsIgnoreCase("skillName")) {
			    
			    orderByComparator = new NameComparator(orderByAsc);
			   } 
			   if(orderByCol.equalsIgnoreCase("description"));
			   {
				   orderByComparator = new DescriptionComparator(orderByAsc);
			   }
			  		   
			   return orderByComparator;
			   }

}
