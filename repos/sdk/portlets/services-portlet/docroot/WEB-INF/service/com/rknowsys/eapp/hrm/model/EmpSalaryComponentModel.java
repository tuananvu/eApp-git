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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EmpSalaryComponent service. Represents a row in the &quot;emp_salary_component&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentImpl}.
 * </p>
 *
 * @author rknowsys
 * @see EmpSalaryComponent
 * @see com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentImpl
 * @see com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl
 * @generated
 */
public interface EmpSalaryComponentModel extends BaseModel<EmpSalaryComponent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a emp salary component model instance should use the {@link EmpSalaryComponent} interface instead.
	 */

	/**
	 * Returns the primary key of this emp salary component.
	 *
	 * @return the primary key of this emp salary component
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this emp salary component.
	 *
	 * @param primaryKey the primary key of this emp salary component
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the emp salary earning ID of this emp salary component.
	 *
	 * @return the emp salary earning ID of this emp salary component
	 */
	public long getEmpSalaryEarningId();

	/**
	 * Sets the emp salary earning ID of this emp salary component.
	 *
	 * @param empSalaryEarningId the emp salary earning ID of this emp salary component
	 */
	public void setEmpSalaryEarningId(long empSalaryEarningId);

	/**
	 * Returns the emp salary ID of this emp salary component.
	 *
	 * @return the emp salary ID of this emp salary component
	 */
	public long getEmpSalaryId();

	/**
	 * Sets the emp salary ID of this emp salary component.
	 *
	 * @param empSalaryId the emp salary ID of this emp salary component
	 */
	public void setEmpSalaryId(long empSalaryId);

	/**
	 * Returns the group ID of this emp salary component.
	 *
	 * @return the group ID of this emp salary component
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this emp salary component.
	 *
	 * @param groupId the group ID of this emp salary component
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this emp salary component.
	 *
	 * @return the company ID of this emp salary component
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this emp salary component.
	 *
	 * @param companyId the company ID of this emp salary component
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this emp salary component.
	 *
	 * @return the create date of this emp salary component
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this emp salary component.
	 *
	 * @param createDate the create date of this emp salary component
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this emp salary component.
	 *
	 * @return the modified date of this emp salary component
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this emp salary component.
	 *
	 * @param modifiedDate the modified date of this emp salary component
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this emp salary component.
	 *
	 * @return the user ID of this emp salary component
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this emp salary component.
	 *
	 * @param userId the user ID of this emp salary component
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this emp salary component.
	 *
	 * @return the user uuid of this emp salary component
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this emp salary component.
	 *
	 * @param userUuid the user uuid of this emp salary component
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the salary component ID of this emp salary component.
	 *
	 * @return the salary component ID of this emp salary component
	 */
	public long getSalaryComponentId();

	/**
	 * Sets the salary component ID of this emp salary component.
	 *
	 * @param salaryComponentId the salary component ID of this emp salary component
	 */
	public void setSalaryComponentId(long salaryComponentId);

	/**
	 * Returns the amount of this emp salary component.
	 *
	 * @return the amount of this emp salary component
	 */
	public long getAmount();

	/**
	 * Sets the amount of this emp salary component.
	 *
	 * @param amount the amount of this emp salary component
	 */
	public void setAmount(long amount);

	/**
	 * Returns the effective date of this emp salary component.
	 *
	 * @return the effective date of this emp salary component
	 */
	public Date getEffectiveDate();

	/**
	 * Sets the effective date of this emp salary component.
	 *
	 * @param effectiveDate the effective date of this emp salary component
	 */
	public void setEffectiveDate(Date effectiveDate);

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
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmpSalaryComponent empSalaryComponent);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> toCacheModel();

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent toEscapedModel();

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}