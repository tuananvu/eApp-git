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

package com.rknowsys.eapp.hrm.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EmpWorkExp service. Represents a row in the &quot;emp_work_exp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.EmpWorkExpImpl}.
 * </p>
 *
 * @author rknowsys
 * @see EmpWorkExp
 * @see com.rknowsys.eapp.hrm.model.impl.EmpWorkExpImpl
 * @see com.rknowsys.eapp.hrm.model.impl.EmpWorkExpModelImpl
 * @generated
 */
public interface EmpWorkExpModel extends BaseModel<EmpWorkExp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a EmpWorkExp model instance should use the {@link EmpWorkExp} interface instead.
	 */

	/**
	 * Returns the primary key of this EmpWorkExp.
	 *
	 * @return the primary key of this EmpWorkExp
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this EmpWorkExp.
	 *
	 * @param primaryKey the primary key of this EmpWorkExp
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the emp work exp ID of this EmpWorkExp.
	 *
	 * @return the emp work exp ID of this EmpWorkExp
	 */
	public long getEmpWorkExpId();

	/**
	 * Sets the emp work exp ID of this EmpWorkExp.
	 *
	 * @param empWorkExpId the emp work exp ID of this EmpWorkExp
	 */
	public void setEmpWorkExpId(long empWorkExpId);

	/**
	 * Returns the employee ID of this EmpWorkExp.
	 *
	 * @return the employee ID of this EmpWorkExp
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this EmpWorkExp.
	 *
	 * @param employeeId the employee ID of this EmpWorkExp
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the group ID of this EmpWorkExp.
	 *
	 * @return the group ID of this EmpWorkExp
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this EmpWorkExp.
	 *
	 * @param groupId the group ID of this EmpWorkExp
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this EmpWorkExp.
	 *
	 * @return the company ID of this EmpWorkExp
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this EmpWorkExp.
	 *
	 * @param companyId the company ID of this EmpWorkExp
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this EmpWorkExp.
	 *
	 * @return the user ID of this EmpWorkExp
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this EmpWorkExp.
	 *
	 * @param userId the user ID of this EmpWorkExp
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this EmpWorkExp.
	 *
	 * @return the user uuid of this EmpWorkExp
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this EmpWorkExp.
	 *
	 * @param userUuid the user uuid of this EmpWorkExp
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this EmpWorkExp.
	 *
	 * @return the create date of this EmpWorkExp
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this EmpWorkExp.
	 *
	 * @param createDate the create date of this EmpWorkExp
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this EmpWorkExp.
	 *
	 * @return the modified date of this EmpWorkExp
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this EmpWorkExp.
	 *
	 * @param modifiedDate the modified date of this EmpWorkExp
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the company of this EmpWorkExp.
	 *
	 * @return the company of this EmpWorkExp
	 */
	@AutoEscape
	public String getCompany();

	/**
	 * Sets the company of this EmpWorkExp.
	 *
	 * @param company the company of this EmpWorkExp
	 */
	public void setCompany(String company);

	/**
	 * Returns the job title of this EmpWorkExp.
	 *
	 * @return the job title of this EmpWorkExp
	 */
	@AutoEscape
	public String getJobTitle();

	/**
	 * Sets the job title of this EmpWorkExp.
	 *
	 * @param jobTitle the job title of this EmpWorkExp
	 */
	public void setJobTitle(String jobTitle);

	/**
	 * Returns the from date of this EmpWorkExp.
	 *
	 * @return the from date of this EmpWorkExp
	 */
	public Date getFromDate();

	/**
	 * Sets the from date of this EmpWorkExp.
	 *
	 * @param fromDate the from date of this EmpWorkExp
	 */
	public void setFromDate(Date fromDate);

	/**
	 * Returns the to date of this EmpWorkExp.
	 *
	 * @return the to date of this EmpWorkExp
	 */
	public Date getToDate();

	/**
	 * Sets the to date of this EmpWorkExp.
	 *
	 * @param toDate the to date of this EmpWorkExp
	 */
	public void setToDate(Date toDate);

	/**
	 * Returns the comment of this EmpWorkExp.
	 *
	 * @return the comment of this EmpWorkExp
	 */
	@AutoEscape
	public String getComment();

	/**
	 * Sets the comment of this EmpWorkExp.
	 *
	 * @param comment the comment of this EmpWorkExp
	 */
	public void setComment(String comment);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.EmpWorkExp empWorkExp);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rknowsys.eapp.hrm.model.EmpWorkExp> toCacheModel();

	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp toEscapedModel();

	@Override
	public com.rknowsys.eapp.hrm.model.EmpWorkExp toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}