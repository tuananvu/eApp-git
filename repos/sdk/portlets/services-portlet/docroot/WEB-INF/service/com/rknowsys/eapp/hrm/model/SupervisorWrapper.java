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
 * This class is a wrapper for {@link Supervisor}.
 * </p>
 *
 * @author rknowsys
 * @see Supervisor
 * @generated
 */
public class SupervisorWrapper implements Supervisor, ModelWrapper<Supervisor> {
	public SupervisorWrapper(Supervisor supervisor) {
		_supervisor = supervisor;
	}

	@Override
	public Class<?> getModelClass() {
		return Supervisor.class;
	}

	@Override
	public String getModelClassName() {
		return Supervisor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supervisorId", getSupervisorId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("reportingMethod", getReportingMethod());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supervisorId = (Long)attributes.get("supervisorId");

		if (supervisorId != null) {
			setSupervisorId(supervisorId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long reportingMethod = (Long)attributes.get("reportingMethod");

		if (reportingMethod != null) {
			setReportingMethod(reportingMethod);
		}
	}

	/**
	* Returns the primary key of this Supervisor.
	*
	* @return the primary key of this Supervisor
	*/
	@Override
	public long getPrimaryKey() {
		return _supervisor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Supervisor.
	*
	* @param primaryKey the primary key of this Supervisor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_supervisor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the supervisor ID of this Supervisor.
	*
	* @return the supervisor ID of this Supervisor
	*/
	@Override
	public long getSupervisorId() {
		return _supervisor.getSupervisorId();
	}

	/**
	* Sets the supervisor ID of this Supervisor.
	*
	* @param supervisorId the supervisor ID of this Supervisor
	*/
	@Override
	public void setSupervisorId(long supervisorId) {
		_supervisor.setSupervisorId(supervisorId);
	}

	/**
	* Returns the employee ID of this Supervisor.
	*
	* @return the employee ID of this Supervisor
	*/
	@Override
	public long getEmployeeId() {
		return _supervisor.getEmployeeId();
	}

	/**
	* Sets the employee ID of this Supervisor.
	*
	* @param employeeId the employee ID of this Supervisor
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_supervisor.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this Supervisor.
	*
	* @return the group ID of this Supervisor
	*/
	@Override
	public long getGroupId() {
		return _supervisor.getGroupId();
	}

	/**
	* Sets the group ID of this Supervisor.
	*
	* @param groupId the group ID of this Supervisor
	*/
	@Override
	public void setGroupId(long groupId) {
		_supervisor.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this Supervisor.
	*
	* @return the company ID of this Supervisor
	*/
	@Override
	public long getCompanyId() {
		return _supervisor.getCompanyId();
	}

	/**
	* Sets the company ID of this Supervisor.
	*
	* @param companyId the company ID of this Supervisor
	*/
	@Override
	public void setCompanyId(long companyId) {
		_supervisor.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this Supervisor.
	*
	* @return the user ID of this Supervisor
	*/
	@Override
	public long getUserId() {
		return _supervisor.getUserId();
	}

	/**
	* Sets the user ID of this Supervisor.
	*
	* @param userId the user ID of this Supervisor
	*/
	@Override
	public void setUserId(long userId) {
		_supervisor.setUserId(userId);
	}

	/**
	* Returns the user uuid of this Supervisor.
	*
	* @return the user uuid of this Supervisor
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _supervisor.getUserUuid();
	}

	/**
	* Sets the user uuid of this Supervisor.
	*
	* @param userUuid the user uuid of this Supervisor
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_supervisor.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this Supervisor.
	*
	* @return the user name of this Supervisor
	*/
	@Override
	public java.lang.String getUserName() {
		return _supervisor.getUserName();
	}

	/**
	* Sets the user name of this Supervisor.
	*
	* @param userName the user name of this Supervisor
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_supervisor.setUserName(userName);
	}

	/**
	* Returns the create date of this Supervisor.
	*
	* @return the create date of this Supervisor
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _supervisor.getCreateDate();
	}

	/**
	* Sets the create date of this Supervisor.
	*
	* @param createDate the create date of this Supervisor
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_supervisor.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this Supervisor.
	*
	* @return the modified date of this Supervisor
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _supervisor.getModifiedDate();
	}

	/**
	* Sets the modified date of this Supervisor.
	*
	* @param modifiedDate the modified date of this Supervisor
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_supervisor.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the reporting method of this Supervisor.
	*
	* @return the reporting method of this Supervisor
	*/
	@Override
	public long getReportingMethod() {
		return _supervisor.getReportingMethod();
	}

	/**
	* Sets the reporting method of this Supervisor.
	*
	* @param reportingMethod the reporting method of this Supervisor
	*/
	@Override
	public void setReportingMethod(long reportingMethod) {
		_supervisor.setReportingMethod(reportingMethod);
	}

	@Override
	public boolean isNew() {
		return _supervisor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_supervisor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _supervisor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_supervisor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _supervisor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _supervisor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_supervisor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _supervisor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_supervisor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_supervisor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_supervisor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SupervisorWrapper((Supervisor)_supervisor.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Supervisor supervisor) {
		return _supervisor.compareTo(supervisor);
	}

	@Override
	public int hashCode() {
		return _supervisor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Supervisor> toCacheModel() {
		return _supervisor.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Supervisor toEscapedModel() {
		return new SupervisorWrapper(_supervisor.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Supervisor toUnescapedModel() {
		return new SupervisorWrapper(_supervisor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _supervisor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _supervisor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_supervisor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupervisorWrapper)) {
			return false;
		}

		SupervisorWrapper supervisorWrapper = (SupervisorWrapper)obj;

		if (Validator.equals(_supervisor, supervisorWrapper._supervisor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Supervisor getWrappedSupervisor() {
		return _supervisor;
	}

	@Override
	public Supervisor getWrappedModel() {
		return _supervisor;
	}

	@Override
	public void resetOriginalValues() {
		_supervisor.resetOriginalValues();
	}

	private Supervisor _supervisor;
}