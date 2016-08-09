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
 * The base model interface for the LeaveCarryForwardPolicy service. Represents a row in the &quot;leave_carry_forward_policy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyImpl}.
 * </p>
 *
 * @author rknowsys
 * @see LeaveCarryForwardPolicy
 * @see com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyImpl
 * @see com.rknowsys.eapp.hrm.model.impl.LeaveCarryForwardPolicyModelImpl
 * @generated
 */
public interface LeaveCarryForwardPolicyModel extends BaseModel<LeaveCarryForwardPolicy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a leave carry forward policy model instance should use the {@link LeaveCarryForwardPolicy} interface instead.
	 */

	/**
	 * Returns the primary key of this leave carry forward policy.
	 *
	 * @return the primary key of this leave carry forward policy
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this leave carry forward policy.
	 *
	 * @param primaryKey the primary key of this leave carry forward policy
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the leave carry forward policy ID of this leave carry forward policy.
	 *
	 * @return the leave carry forward policy ID of this leave carry forward policy
	 */
	public long getLeaveCarryForwardPolicyId();

	/**
	 * Sets the leave carry forward policy ID of this leave carry forward policy.
	 *
	 * @param leaveCarryForwardPolicyId the leave carry forward policy ID of this leave carry forward policy
	 */
	public void setLeaveCarryForwardPolicyId(long leaveCarryForwardPolicyId);

	/**
	 * Returns the company ID of this leave carry forward policy.
	 *
	 * @return the company ID of this leave carry forward policy
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this leave carry forward policy.
	 *
	 * @param companyId the company ID of this leave carry forward policy
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this leave carry forward policy.
	 *
	 * @return the group ID of this leave carry forward policy
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this leave carry forward policy.
	 *
	 * @param groupId the group ID of this leave carry forward policy
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this leave carry forward policy.
	 *
	 * @return the create date of this leave carry forward policy
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this leave carry forward policy.
	 *
	 * @param createDate the create date of this leave carry forward policy
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this leave carry forward policy.
	 *
	 * @return the modified date of this leave carry forward policy
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this leave carry forward policy.
	 *
	 * @param modifiedDate the modified date of this leave carry forward policy
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this leave carry forward policy.
	 *
	 * @return the user ID of this leave carry forward policy
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this leave carry forward policy.
	 *
	 * @param userId the user ID of this leave carry forward policy
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this leave carry forward policy.
	 *
	 * @return the user uuid of this leave carry forward policy
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this leave carry forward policy.
	 *
	 * @param userUuid the user uuid of this leave carry forward policy
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the leave type ID of this leave carry forward policy.
	 *
	 * @return the leave type ID of this leave carry forward policy
	 */
	public long getLeaveTypeId();

	/**
	 * Sets the leave type ID of this leave carry forward policy.
	 *
	 * @param leaveTypeId the leave type ID of this leave carry forward policy
	 */
	public void setLeaveTypeId(long leaveTypeId);

	/**
	 * Returns the expiry duration of this leave carry forward policy.
	 *
	 * @return the expiry duration of this leave carry forward policy
	 */
	public int getExpiryDuration();

	/**
	 * Sets the expiry duration of this leave carry forward policy.
	 *
	 * @param expiryDuration the expiry duration of this leave carry forward policy
	 */
	public void setExpiryDuration(int expiryDuration);

	/**
	 * Returns the expiry duration u o m of this leave carry forward policy.
	 *
	 * @return the expiry duration u o m of this leave carry forward policy
	 */
	@AutoEscape
	public String getExpiryDurationUOM();

	/**
	 * Sets the expiry duration u o m of this leave carry forward policy.
	 *
	 * @param expiryDurationUOM the expiry duration u o m of this leave carry forward policy
	 */
	public void setExpiryDurationUOM(String expiryDurationUOM);

	/**
	 * Returns the is max carry forward limit applicable of this leave carry forward policy.
	 *
	 * @return the is max carry forward limit applicable of this leave carry forward policy
	 */
	public boolean getIsMaxCarryForwardLimitApplicable();

	/**
	 * Returns <code>true</code> if this leave carry forward policy is is max carry forward limit applicable.
	 *
	 * @return <code>true</code> if this leave carry forward policy is is max carry forward limit applicable; <code>false</code> otherwise
	 */
	public boolean isIsMaxCarryForwardLimitApplicable();

	/**
	 * Sets whether this leave carry forward policy is is max carry forward limit applicable.
	 *
	 * @param isMaxCarryForwardLimitApplicable the is max carry forward limit applicable of this leave carry forward policy
	 */
	public void setIsMaxCarryForwardLimitApplicable(
		boolean isMaxCarryForwardLimitApplicable);

	/**
	 * Returns the max carry forward limit of this leave carry forward policy.
	 *
	 * @return the max carry forward limit of this leave carry forward policy
	 */
	@AutoEscape
	public String getMaxCarryForwardLimit();

	/**
	 * Sets the max carry forward limit of this leave carry forward policy.
	 *
	 * @param maxCarryForwardLimit the max carry forward limit of this leave carry forward policy
	 */
	public void setMaxCarryForwardLimit(String maxCarryForwardLimit);

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
		com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy leaveCarryForwardPolicy);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy> toCacheModel();

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy toEscapedModel();

	@Override
	public com.rknowsys.eapp.hrm.model.LeaveCarryForwardPolicy toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}