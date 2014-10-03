package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.EmergencyContact;

public class EmergencyContactComparator extends OrderByComparator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 
	  public EmergencyContactComparator() 
	  {
	   this(false);
	  }
	 
	  public EmergencyContactComparator(boolean asc) {
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
		 EmergencyContact instance1 = (EmergencyContact) obj1;
		 EmergencyContact instance2 = (EmergencyContact) obj2;
	   
	   System.out.println("============");
	   System.out.println("instance1 === " +instance1.getEmergencyContactId());
	   System.out.println("instance2 == " +instance2.getEmergencyContactId());
	   
	   int value = 1;
	   if (instance1.getName().compareToIgnoreCase(instance2.getName()) < 0) {
		   value=-1;
	   }
	 
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
