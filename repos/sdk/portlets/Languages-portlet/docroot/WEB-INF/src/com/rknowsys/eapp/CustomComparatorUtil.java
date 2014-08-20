package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;

public class CustomComparatorUtil {
	public static OrderByComparator getLanguagesOrderByComparator(
			   String orderByCol, String orderByType) {
			  
			  
			   boolean orderByAsc = false;
			 
			   if (orderByType.equals("asc")) {
			   orderByAsc = true;
			   }
			 
			   OrderByComparator orderByComparator = null;
			   
			   
			   if (orderByCol.equalsIgnoreCase("languageName")) {
			    
			    orderByComparator = new languageNameComparator(orderByAsc);
			   } 
			   
			  		   
			   return orderByComparator;
			   }


}
