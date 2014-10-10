/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rknowsys.eapp.hrm.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.rknowsys.eapp.hrm.model.EmpDetails;
import com.rknowsys.eapp.hrm.service.EmpDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.base.EmpDetailsLocalServiceBaseImpl;
import com.rknowsys.eapp.hrm.service.persistence.EmpDetailsFinderUtil;

/**
 * The implementation of the emp details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rknowsys.eapp.hrm.service.EmpDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author rknowsys
 * @see com.rknowsys.eapp.hrm.service.base.EmpDetailsLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.EmpDetailsLocalServiceUtil
 */
public class EmpDetailsLocalServiceImpl extends EmpDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rknowsys.eapp.hrm.service.EmpDetailsLocalServiceUtil} to access the emp details local service.
	 */
	public List<EmpDetails> findByEmpDetails(int begin, int end)
			throws SystemException {
		      System.out.println("in empdetailslocalserviceimpl.....");

			    return EmpDetailsFinderUtil.findByEmpDetails(begin, end);
		}
	
	/**
	 * This method returns employee list based on the given search parameters.
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getSearchEmployees(String empname,String empid, String empstatus,String supervisorname,String jobtitle,String subunit,boolean andSearch, int start, int end)
	        throws SystemException
	    {
	        DynamicQuery dynamicQuery = buildEmployeeDynamicQuery(empname,empid,empstatus,supervisorname,jobtitle,subunit,andSearch);
	        return EmpDetailsLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);//  StudentLocalServiceUtil.dynamicQuery(dynamicQuery, start, end, orderByComparator);
	    }
		/**
		 * This method returns employee list count based on the given search parameters.
		 */
	    public int getSearchEmployeesCount(String empname,String empid, String empstatus,String supervisorname,String jobtitle,String subunit, boolean andSearch)
	            throws SystemException
	    {
	    	DynamicQuery dynamicQuery = buildEmployeeDynamicQuery(empname,empid,empstatus,supervisorname,jobtitle,subunit,andSearch);
	        return (int)EmpDetailsLocalServiceUtil.dynamicQueryCount(dynamicQuery);
	    }

	    protected DynamicQuery buildEmployeeDynamicQuery(String empname,String empid, String empstatus,String supervisorname,String jobtitle,String subunit,boolean andSearch)
	    {
	    	Junction junction = null;
	        if(andSearch)
	            junction = RestrictionsFactoryUtil.conjunction();
	        else
	            junction = RestrictionsFactoryUtil.disjunction();
	        
	        if(Validator.isNotNull(empname))
	        {
	            Property property = PropertyFactoryUtil.forName("firstName");
	            String value = (new StringBuilder("%")).append(empname).append("%").toString();
	            System.out.println("value == " +value);
	            junction.add(property.like(value));
	        }
	        if(Validator.isNotNull(empid))
	        {
	            Property property = PropertyFactoryUtil.forName("employeeNo");
	            String value = (new StringBuilder("%")).append(empid).append("%").toString();
	            junction.add(property.like(value));
	        }
	       
	        if(Validator.isNotNull(empstatus))
	        {
	            Property property = PropertyFactoryUtil.forName("employmentstatus");
	            String value = (new StringBuilder("%")).append(empstatus).append("%").toString();
	            junction.add(property.like(value));
	        }
	        if(Validator.isNotNull(supervisorname))
	        {
	            Property property = PropertyFactoryUtil.forName("supervisor");
	            String value = (new StringBuilder("%")).append(supervisorname).append("%").toString();
	            junction.add(property.like(value));
	        }
	        if(Validator.isNotNull(jobtitle))
	        {
	            Property property = PropertyFactoryUtil.forName("title");
	            String value = (new StringBuilder("%")).append(jobtitle).append("%").toString();
	            junction.add(property.like(value));
	        }
	        if(Validator.isNotNull(subunit))
	        {
	            Property property = PropertyFactoryUtil.forName("name");
	            String value = (new StringBuilder("%")).append(subunit).append("%").toString();
	            junction.add(property.like(value));
	        }
	        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EmpDetails.class, getClassLoader());
	        return dynamicQuery.add(junction);
	    }
}