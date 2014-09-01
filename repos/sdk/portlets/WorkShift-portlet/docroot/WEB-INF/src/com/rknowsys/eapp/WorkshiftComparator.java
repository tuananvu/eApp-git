package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Workshift;

public class WorkshiftComparator extends OrderByComparator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "workshiftName ASC";
	 
	 public static String ORDER_BY_DESC = "workshiftName DESC";
	 
	 
	  public WorkshiftComparator() 
	  {
	   this(false);
	  }
	 
	  public WorkshiftComparator(boolean asc) {
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   Workshift instance1 = (Workshift) obj1;
	   Workshift instance2 = (Workshift) obj2;
	   
	   System.out.println("============");
	   System.out.println("instance1 === " +instance1.getWorkshiftName().toLowerCase());
	   System.out.println("instance2 == " +instance2.getWorkshiftName().toLowerCase());
	   
	   int value = instance1.getWorkshiftName().toLowerCase().compareTo(instance2.getWorkshiftName().toLowerCase());
	 
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
