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
 * The base model interface for the LeaveType service. Represents a row in the &quot;leave_type&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.LeaveTypeImpl}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveType
 * @see com.rknowsys.eapp.hrm.model.impl.LeaveTypeImpl
 * @see com.rknowsys.eapp.hrm.model.impl.LeaveTypeModelImpl
 * @generated
 */
public interface LeaveTypeModel extends BaseModel<LeaveType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a leave type model instance should use the {@link LeaveType} interface instead.
	 */

	/**
	 * Returns the primary key of this leave type.
	 *
	 * @return the primary key of this leave type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this leave type.
	 *
	 * @param primaryKey the primary key of this leave type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the leave type ID of this leave type.
	 *
	 * @return the leave type ID of this leave type
	 */
	public long getLeaveTypeId();

	/**
	 * Sets the leave type ID of this leave type.
	 *
	 * @param leaveTypeId the leave type ID of this leave type
	 */
	public void setLeaveTypeId(long leaveTypeId);

	/**
	 * Returns the company ID of this leave type.
	 *
	 * @return the company ID of this leave type
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this leave type.
	 *
	 * @param companyId the company ID of this leave type
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this leave type.
	 *
	 * @return the group ID of this leave type
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this leave type.
	 *
	 * @param groupId the group ID of this leave type
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this leave type.
	 *
	 * @return the create date of this leave type
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this leave type.
	 *
	 * @param createDate the create date of this leave type
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this leave type.
	 *
	 * @return the modified date of this leave type
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this leave type.
	 *
	 * @param modifiedDate the modified date of this leave type
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this leave type.
	 *
	 * @return the user ID of this leave type
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this leave type.
	 *
	 * @param userId the user ID of this leave type
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this leave type.
	 *
	 * @return the user uuid of this leave type
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this leave type.
	 *
	 * @param userUuid the user uuid of this leave type
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the nationality ID of this leave type.
	 *
	 * @return the nationality ID of this leave type
	 */
	public long getNationalityId();

	/**
	 * Sets the nationality ID of this leave type.
	 *
	 * @param nationalityId the nationality ID of this leave type
	 */
	public void setNationalityId(long nationalityId);

	/**
	 * Returns the leave type name of this leave type.
	 *
	 * @return the leave type name of this leave type
	 */
	@AutoEscape
	public String getLeaveTypeName();

	/**
	 * Sets the leave type name of this leave type.
	 *
	 * @param leaveTypeName the leave type name of this leave type
	 */
	public void setLeaveTypeName(String leaveTypeName);

	/**
	 * Returns the is situational of this leave type.
	 *
	 * @return the is situational of this leave type
	 */
	public boolean getIsSituational();

	/**
	 * Returns <code>true</code> if this leave type is is situational.
	 *
	 * @return <code>true</code> if this leave type is is situational; <code>false</code> otherwise
	 */
	public boolean isIsSituational();

	/**
	 * Sets whether this leave type is is situational.
	 *
	 * @param isSituational the is situational of this leave type
	 */
	public void setIsSituational(boolean isSituational);

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
	public int compareTo(com.rknowsys.eapp.hrm.model.LeaveType leaveType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rknowsys.eapp.hrm.model.LeaveType> toCacheModel();

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveType toEscapedModel();

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}