package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.JobTitles;

public class JobdescriptionComparator extends OrderByComparator {
	
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 
	  public JobdescriptionComparator() 
	  {
	   this(false);
	  }
	 
	  public JobdescriptionComparator(boolean asc) {
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   JobTitles instance1 = (JobTitles) obj1;
	   JobTitles instance2 = (JobTitles) obj2;
	   
	   System.out.println("============");
	   System.out.println("instance1 === " +instance1 .getDescription().toLowerCase());
	   System.out.println("instance2 == " +instance2.getDescription().toLowerCase());
	   
	   int value = instance1.getDescription().toLowerCase().compareTo(instance2.getDescription().toLowerCase());
	 
	   if(_asc) 
	   {
	    return value;
	   } else 
	   {
	    return -value;
	   }
	    
	 }
	 
	 
	 public String getOrderBy() {
	  
	  if (_asc) {
	   return ORDER_BY_ASC;
	  } 
	  else {
	   return ORDER_BY_DESC;
	  }
	  }
	 
	 private boolean _asc;

	

}
