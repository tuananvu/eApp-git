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
 * This class is a wrapper for {@link WorkExpCompany}.
 * </p>
 *
 * @author rknowsys
 * @see WorkExpCompany
 * @generated
 */
public class WorkExpCompanyWrapper implements WorkExpCompany,
	ModelWrapper<WorkExpCompany> {
	public WorkExpCompanyWrapper(WorkExpCompany workExpCompany) {
		_workExpCompany = workExpCompany;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkExpCompany.class;
	}

	@Override
	public String getModelClassName() {
		return WorkExpCompany.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workExpCompanyId", getWorkExpCompanyId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("company", getCompany());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workExpCompanyId = (Long)attributes.get("workExpCompanyId");

		if (workExpCompanyId != null) {
			setWorkExpCompanyId(workExpCompanyId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	/**
	* Returns the primary key of this WorkExpCompany.
	*
	* @return the primary key of this WorkExpCompany
	*/
	@Override
	public long getPrimaryKey() {
		return _workExpCompany.getPrimaryKey();
	}

	/**
	* Sets the primary key of this WorkExpCompany.
	*
	* @param primaryKey the primary key of this WorkExpCompany
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workExpCompany.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the work exp company ID of this WorkExpCompany.
	*
	* @return the work exp company ID of this WorkExpCompany
	*/
	@Override
	public long getWorkExpCompanyId() {
		return _workExpCompany.getWorkExpCompanyId();
	}

	/**
	* Sets the work exp company ID of this WorkExpCompany.
	*
	* @param workExpCompanyId the work exp company ID of this WorkExpCompany
	*/
	@Override
	public void setWorkExpCompanyId(long workExpCompanyId) {
		_workExpCompany.setWorkExpCompanyId(workExpCompanyId);
	}

	/**
	* Returns the employee ID of this WorkExpCompany.
	*
	* @return the employee ID of this WorkExpCompany
	*/
	@Override
	public long getEmployeeId() {
		return _workExpCompany.getEmployeeId();
	}

	/**
	* Sets the employee ID of this WorkExpCompany.
	*
	* @param employeeId the employee ID of this WorkExpCompany
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_workExpCompany.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this WorkExpCompany.
	*
	* @return the group ID of this WorkExpCompany
	*/
	@Override
	public long getGroupId() {
		return _workExpCompany.getGroupId();
	}

	/**
	* Sets the group ID of this WorkExpCompany.
	*
	* @param groupId the group ID of this WorkExpCompany
	*/
	@Override
	public void setGroupId(long groupId) {
		_workExpCompany.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this WorkExpCompany.
	*
	* @return the company ID of this WorkExpCompany
	*/
	@Override
	public long getCompanyId() {
		return _workExpCompany.getCompanyId();
	}

	/**
	* Sets the company ID of this WorkExpCompany.
	*
	* @param companyId the company ID of this WorkExpCompany
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workExpCompany.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this WorkExpCompany.
	*
	* @return the user ID of this WorkExpCompany
	*/
	@Override
	public long getUserId() {
		return _workExpCompany.getUserId();
	}

	/**
	* Sets the user ID of this WorkExpCompany.
	*
	* @param userId the user ID of this WorkExpCompany
	*/
	@Override
	public void setUserId(long userId) {
		_workExpCompany.setUserId(userId);
	}

	/**
	* Returns the user uuid of this WorkExpCompany.
	*
	* @return the user uuid of this WorkExpCompany
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompany.getUserUuid();
	}

	/**
	* Sets the user uuid of this WorkExpCompany.
	*
	* @param userUuid the user uuid of this WorkExpCompany
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workExpCompany.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this WorkExpCompany.
	*
	* @return the create date of this WorkExpCompany
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workExpCompany.getCreateDate();
	}

	/**
	* Sets the create date of this WorkExpCompany.
	*
	* @param createDate the create date of this WorkExpCompany
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workExpCompany.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this WorkExpCompany.
	*
	* @return the modified date of this WorkExpCompany
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workExpCompany.getModifiedDate();
	}

	/**
	* Sets the modified date of this WorkExpCompany.
	*
	* @param modifiedDate the modified date of this WorkExpCompany
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workExpCompany.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the company of this WorkExpCompany.
	*
	* @return the company of this WorkExpCompany
	*/
	@Override
	public java.lang.String getCompany() {
		return _workExpCompany.getCompany();
	}

	/**
	* Sets the company of this WorkExpCompany.
	*
	* @param company the company of this WorkExpCompany
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_workExpCompany.setCompany(company);
	}

	/**
	* Returns the job title of this WorkExpCompany.
	*
	* @return the job title of this WorkExpCompany
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _workExpCompany.getJobTitle();
	}

	/**
	* Sets the job title of this WorkExpCompany.
	*
	* @param jobTitle the job title of this WorkExpCompany
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_workExpCompany.setJobTitle(jobTitle);
	}

	/**
	* Returns the from date of this WorkExpCompany.
	*
	* @return the from date of this WorkExpCompany
	*/
	@Override
	public java.util.Date getFromDate() {
		return _workExpCompany.getFromDate();
	}

	/**
	* Sets the from date of this WorkExpCompany.
	*
	* @param fromDate the from date of this WorkExpCompany
	*/
	@Override
	public void setFromDate(java.util.Date fromDate) {
		_workExpCompany.setFromDate(fromDate);
	}

	/**
	* Returns the to date of this WorkExpCompany.
	*
	* @return the to date of this WorkExpCompany
	*/
	@Override
	public java.util.Date getToDate() {
		return _workExpCompany.getToDate();
	}

	/**
	* Sets the to date of this WorkExpCompany.
	*
	* @param toDate the to date of this WorkExpCompany
	*/
	@Override
	public void setToDate(java.util.Date toDate) {
		_workExpCompany.setToDate(toDate);
	}

	/**
	* Returns the comment of this WorkExpCompany.
	*
	* @return the comment of this WorkExpCompany
	*/
	@Override
	public java.lang.String getComment() {
		return _workExpCompany.getComment();
	}

	/**
	* Sets the comment of this WorkExpCompany.
	*
	* @param comment the comment of this WorkExpCompany
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_workExpCompany.setComment(comment);
	}

	@Override
	public boolean isNew() {
		return _workExpCompany.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workExpCompany.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workExpCompany.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workExpCompany.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workExpCompany.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workExpCompany.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workExpCompany.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workExpCompany.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workExpCompany.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workExpCompany.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workExpCompany.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkExpCompanyWrapper((WorkExpCompany)_workExpCompany.clone());
	}

	@Override
	public int compareTo(WorkExpCompany workExpCompany) {
		return _workExpCompany.compareTo(workExpCompany);
	}

	@Override
	public int hashCode() {
		return _workExpCompany.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<WorkExpCompany> toCacheModel() {
		return _workExpCompany.toCacheModel();
	}

	@Override
	public WorkExpCompany toEscapedModel() {
		return new WorkExpCompanyWrapper(_workExpCompany.toEscapedModel());
	}

	@Override
	public WorkExpCompany toUnescapedModel() {
		return new WorkExpCompanyWrapper(_workExpCompany.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workExpCompany.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workExpCompany.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workExpCompany.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkExpCompanyWrapper)) {
			return false;
		}

		WorkExpCompanyWrapper workExpCompanyWrapper = (WorkExpCompanyWrapper)obj;

		if (Validator.equals(_workExpCompany,
					workExpCompanyWrapper._workExpCompany)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WorkExpCompany getWrappedWorkExpCompany() {
		return _workExpCompany;
	}

	@Override
	public WorkExpCompany getWrappedModel() {
		return _workExpCompany;
	}

	@Override
	public void resetOriginalValues() {
		_workExpCompany.resetOriginalValues();
	}

	private WorkExpCompany _workExpCompany;
}