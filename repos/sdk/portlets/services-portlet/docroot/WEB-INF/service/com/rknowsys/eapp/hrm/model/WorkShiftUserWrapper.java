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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkShiftUser}.
 * </p>
 *
 * @author rknowsys
 * @see WorkShiftUser
 * @generated
 */
public class WorkShiftUserWrapper implements WorkShiftUser,
	ModelWrapper<WorkShiftUser> {
	public WorkShiftUserWrapper(WorkShiftUser workShiftUser) {
		_workShiftUser = workShiftUser;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkShiftUser.class;
	}

	@Override
	public String getModelClassName() {
		return WorkShiftUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workShiftUserId", getWorkShiftUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("empId", getEmpId());
		attributes.put("shiftId", getShiftId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workShiftUserId = (Long)attributes.get("workShiftUserId");

		if (workShiftUserId != null) {
			setWorkShiftUserId(workShiftUserId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Long shiftId = (Long)attributes.get("shiftId");

		if (shiftId != null) {
			setShiftId(shiftId);
		}
	}

	/**
	* Returns the primary key of this work shift user.
	*
	* @return the primary key of this work shift user
	*/
	@Override
	public long getPrimaryKey() {
		return _workShiftUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this work shift user.
	*
	* @param primaryKey the primary key of this work shift user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workShiftUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the work shift user ID of this work shift user.
	*
	* @return the work shift user ID of this work shift user
	*/
	@Override
	public long getWorkShiftUserId() {
		return _workShiftUser.getWorkShiftUserId();
	}

	/**
	* Sets the work shift user ID of this work shift user.
	*
	* @param workShiftUserId the work shift user ID of this work shift user
	*/
	@Override
	public void setWorkShiftUserId(long workShiftUserId) {
		_workShiftUser.setWorkShiftUserId(workShiftUserId);
	}

	/**
	* Returns the work shift user uuid of this work shift user.
	*
	* @return the work shift user uuid of this work shift user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getWorkShiftUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workShiftUser.getWorkShiftUserUuid();
	}

	/**
	* Sets the work shift user uuid of this work shift user.
	*
	* @param workShiftUserUuid the work shift user uuid of this work shift user
	*/
	@Override
	public void setWorkShiftUserUuid(java.lang.String workShiftUserUuid) {
		_workShiftUser.setWorkShiftUserUuid(workShiftUserUuid);
	}

	/**
	* Returns the company ID of this work shift user.
	*
	* @return the company ID of this work shift user
	*/
	@Override
	public long getCompanyId() {
		return _workShiftUser.getCompanyId();
	}

	/**
	* Sets the company ID of this work shift user.
	*
	* @param companyId the company ID of this work shift user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workShiftUser.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this work shift user.
	*
	* @return the group ID of this work shift user
	*/
	@Override
	public long getGroupId() {
		return _workShiftUser.getGroupId();
	}

	/**
	* Sets the group ID of this work shift user.
	*
	* @param groupId the group ID of this work shift user
	*/
	@Override
	public void setGroupId(long groupId) {
		_workShiftUser.setGroupId(groupId);
	}

	/**
	* Returns the create date of this work shift user.
	*
	* @return the create date of this work shift user
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workShiftUser.getCreateDate();
	}

	/**
	* Sets the create date of this work shift user.
	*
	* @param createDate the create date of this work shift user
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workShiftUser.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this work shift user.
	*
	* @return the modified date of this work shift user
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workShiftUser.getModifiedDate();
	}

	/**
	* Sets the modified date of this work shift user.
	*
	* @param modifiedDate the modified date of this work shift user
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workShiftUser.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this work shift user.
	*
	* @return the user ID of this work shift user
	*/
	@Override
	public long getUserId() {
		return _workShiftUser.getUserId();
	}

	/**
	* Sets the user ID of this work shift user.
	*
	* @param userId the user ID of this work shift user
	*/
	@Override
	public void setUserId(long userId) {
		_workShiftUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this work shift user.
	*
	* @return the user uuid of this work shift user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workShiftUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this work shift user.
	*
	* @param userUuid the user uuid of this work shift user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workShiftUser.setUserUuid(userUuid);
	}

	/**
	* Returns the emp ID of this work shift user.
	*
	* @return the emp ID of this work shift user
	*/
	@Override
	public long getEmpId() {
		return _workShiftUser.getEmpId();
	}

	/**
	* Sets the emp ID of this work shift user.
	*
	* @param empId the emp ID of this work shift user
	*/
	@Override
	public void setEmpId(long empId) {
		_workShiftUser.setEmpId(empId);
	}

	/**
	* Returns the shift ID of this work shift user.
	*
	* @return the shift ID of this work shift user
	*/
	@Override
	public long getShiftId() {
		return _workShiftUser.getShiftId();
	}

	/**
	* Sets the shift ID of this work shift user.
	*
	* @param shiftId the shift ID of this work shift user
	*/
	@Override
	public void setShiftId(long shiftId) {
		_workShiftUser.setShiftId(shiftId);
	}

	@Override
	public boolean isNew() {
		return _workShiftUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workShiftUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workShiftUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workShiftUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workShiftUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workShiftUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workShiftUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workShiftUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workShiftUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workShiftUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workShiftUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkShiftUserWrapper((WorkShiftUser)_workShiftUser.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.WorkShiftUser workShiftUser) {
		return _workShiftUser.compareTo(workShiftUser);
	}

	@Override
	public int hashCode() {
		return _workShiftUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.WorkShiftUser> toCacheModel() {
		return _workShiftUser.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.WorkShiftUser toEscapedModel() {
		return new WorkShiftUserWrapper(_workShiftUser.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.WorkShiftUser toUnescapedModel() {
		return new WorkShiftUserWrapper(_workShiftUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workShiftUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workShiftUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workShiftUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkShiftUserWrapper)) {
			return false;
		}

		WorkShiftUserWrapper workShiftUserWrapper = (WorkShiftUserWrapper)obj;

		if (Validator.equals(_workShiftUser, workShiftUserWrapper._workShiftUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WorkShiftUser getWrappedWorkShiftUser() {
		return _workShiftUser;
	}

	@Override
	public WorkShiftUser getWrappedModel() {
		return _workShiftUser;
	}

	@Override
	public void resetOriginalValues() {
		_workShiftUser.resetOriginalValues();
	}

	private WorkShiftUser _workShiftUser;
}