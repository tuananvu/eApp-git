package com.rknowsys.eapp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.model.Interview;

public class InterviewComparator extends OrderByComparator {
	
	
	private static final long serialVersionUID = 1L;

	public static String ORDER_BY_ASC = "status ASC";
	 
	 public static String ORDER_BY_DESC = "status DESC";
	 
	 private static Log log = LogFactoryUtil.getLog(InterviewComparator.class);
	 
	 
	  public InterviewComparator() 
	  {
	   this(false);
	  }
	 
	  public InterviewComparator(boolean asc) {
	   _asc = asc;
	  }
	 
	 
	 
	 public int compare(Object obj1, Object obj2) {
	   
	   Interview instance1 = (Interview) obj1;
	   Interview instance2 = (Interview) obj2;
	   
	   log.info("=====");
	   log.info("instance1 === " +instance1.getName().toLowerCase());
	   log.info("instance2 == " +instance2.getName().toLowerCase());
	   
	   int value = instance1.getName().toLowerCase().compareTo(instance2.getName().toLowerCase());
	 
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
