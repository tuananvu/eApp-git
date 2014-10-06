package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Dependent;
import com.rknowsys.eapp.hrm.model.WorkExpCompany;

public class DependentComparator extends OrderByComparator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 
	  public DependentComparator() 
	  {
	   this(false);
	  }
	 
	  public DependentComparator(boolean asc) {
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
		 Dependent instance1 = (Dependent) obj1;
		 Dependent instance2 = (Dependent) obj2;
	   
	   System.out.println("============");
	   System.out.println("instance1 === " +instance1.getDependentId());
	   System.out.println("instance2 == " +instance2.getDependentId());
	   
	   int value = 1;
	   if (instance1.getDateOfBirth().before(instance2.getDateOfBirth())) {
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
