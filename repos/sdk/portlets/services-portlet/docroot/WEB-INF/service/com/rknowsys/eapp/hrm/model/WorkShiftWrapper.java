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
 * This class is a wrapper for {@link WorkShift}.
 * </p>
 *
 * @author rknowsys
 * @see WorkShift
 * @generated
 */
public class WorkShiftWrapper implements WorkShift, ModelWrapper<WorkShift> {
	public WorkShiftWrapper(WorkShift workShift) {
		_workShift = workShift;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkShift.class;
	}

	@Override
	public String getModelClassName() {
		return WorkShift.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("shiftId", getShiftId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("shiftName", getShiftName());
		attributes.put("fromWorkHrs", getFromWorkHrs());
		attributes.put("toWorkHrs", getToWorkHrs());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long shiftId = (Long)attributes.get("shiftId");

		if (shiftId != null) {
			setShiftId(shiftId);
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

		String shiftName = (String)attributes.get("shiftName");

		if (shiftName != null) {
			setShiftName(shiftName);
		}

		Long fromWorkHrs = (Long)attributes.get("fromWorkHrs");

		if (fromWorkHrs != null) {
			setFromWorkHrs(fromWorkHrs);
		}

		Long toWorkHrs = (Long)attributes.get("toWorkHrs");

		if (toWorkHrs != null) {
			setToWorkHrs(toWorkHrs);
		}
	}

	/**
	* Returns the primary key of this work shift.
	*
	* @return the primary key of this work shift
	*/
	@Override
	public long getPrimaryKey() {
		return _workShift.getPrimaryKey();
	}

	/**
	* Sets the primary key of this work shift.
	*
	* @param primaryKey the primary key of this work shift
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workShift.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the shift ID of this work shift.
	*
	* @return the shift ID of this work shift
	*/
	@Override
	public long getShiftId() {
		return _workShift.getShiftId();
	}

	/**
	* Sets the shift ID of this work shift.
	*
	* @param shiftId the shift ID of this work shift
	*/
	@Override
	public void setShiftId(long shiftId) {
		_workShift.setShiftId(shiftId);
	}

	/**
	* Returns the company ID of this work shift.
	*
	* @return the company ID of this work shift
	*/
	@Override
	public long getCompanyId() {
		return _workShift.getCompanyId();
	}

	/**
	* Sets the company ID of this work shift.
	*
	* @param companyId the company ID of this work shift
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workShift.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this work shift.
	*
	* @return the group ID of this work shift
	*/
	@Override
	public long getGroupId() {
		return _workShift.getGroupId();
	}

	/**
	* Sets the group ID of this work shift.
	*
	* @param groupId the group ID of this work shift
	*/
	@Override
	public void setGroupId(long groupId) {
		_workShift.setGroupId(groupId);
	}

	/**
	* Returns the create date of this work shift.
	*
	* @return the create date of this work shift
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workShift.getCreateDate();
	}

	/**
	* Sets the create date of this work shift.
	*
	* @param createDate the create date of this work shift
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workShift.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this work shift.
	*
	* @return the modified date of this work shift
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workShift.getModifiedDate();
	}

	/**
	* Sets the modified date of this work shift.
	*
	* @param modifiedDate the modified date of this work shift
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workShift.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this work shift.
	*
	* @return the user ID of this work shift
	*/
	@Override
	public long getUserId() {
		return _workShift.getUserId();
	}

	/**
	* Sets the user ID of this work shift.
	*
	* @param userId the user ID of this work shift
	*/
	@Override
	public void setUserId(long userId) {
		_workShift.setUserId(userId);
	}

	/**
	* Returns the user uuid of this work shift.
	*
	* @return the user uuid of this work shift
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workShift.getUserUuid();
	}

	/**
	* Sets the user uuid of this work shift.
	*
	* @param userUuid the user uuid of this work shift
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workShift.setUserUuid(userUuid);
	}

	/**
	* Returns the shift name of this work shift.
	*
	* @return the shift name of this work shift
	*/
	@Override
	public java.lang.String getShiftName() {
		return _workShift.getShiftName();
	}

	/**
	* Sets the shift name of this work shift.
	*
	* @param shiftName the shift name of this work shift
	*/
	@Override
	public void setShiftName(java.lang.String shiftName) {
		_workShift.setShiftName(shiftName);
	}

	/**
	* Returns the from work hrs of this work shift.
	*
	* @return the from work hrs of this work shift
	*/
	@Override
	public long getFromWorkHrs() {
		return _workShift.getFromWorkHrs();
	}

	/**
	* Sets the from work hrs of this work shift.
	*
	* @param fromWorkHrs the from work hrs of this work shift
	*/
	@Override
	public void setFromWorkHrs(long fromWorkHrs) {
		_workShift.setFromWorkHrs(fromWorkHrs);
	}

	/**
	* Returns the to work hrs of this work shift.
	*
	* @return the to work hrs of this work shift
	*/
	@Override
	public long getToWorkHrs() {
		return _workShift.getToWorkHrs();
	}

	/**
	* Sets the to work hrs of this work shift.
	*
	* @param toWorkHrs the to work hrs of this work shift
	*/
	@Override
	public void setToWorkHrs(long toWorkHrs) {
		_workShift.setToWorkHrs(toWorkHrs);
	}

	@Override
	public boolean isNew() {
		return _workShift.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workShift.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workShift.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workShift.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workShift.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workShift.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workShift.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workShift.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workShift.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workShift.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workShift.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkShiftWrapper((WorkShift)_workShift.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.WorkShift workShift) {
		return _workShift.compareTo(workShift);
	}

	@Override
	public int hashCode() {
		return _workShift.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.WorkShift> toCacheModel() {
		return _workShift.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.WorkShift toEscapedModel() {
		return new WorkShiftWrapper(_workShift.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.WorkShift toUnescapedModel() {
		return new WorkShiftWrapper(_workShift.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workShift.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workShift.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workShift.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkShiftWrapper)) {
			return false;
		}

		WorkShiftWrapper workShiftWrapper = (WorkShiftWrapper)obj;

		if (Validator.equals(_workShift, workShiftWrapper._workShift)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WorkShift getWrappedWorkShift() {
		return _workShift;
	}

	@Override
	public WorkShift getWrappedModel() {
		return _workShift;
	}

	@Override
	public void resetOriginalValues() {
		_workShift.resetOriginalValues();
	}

	private WorkShift _workShift;
}