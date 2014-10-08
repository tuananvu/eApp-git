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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Job}.
 * </p>
 *
 * @author rknowsys
 * @see Job
 * @generated
 */
public class JobWrapper implements Job, ModelWrapper<Job> {
	public JobWrapper(Job job) {
		_job = job;
	}

	@Override
	public Class<?> getModelClass() {
		return Job.class;
	}

	@Override
	public String getModelClassName() {
		return Job.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobId", getJobId());
		attributes.put("jobTitleId", getJobTitleId());
		attributes.put("jobCategoryId", getJobCategoryId());
		attributes.put("subUnitId", getSubUnitId());
		attributes.put("locationId", getLocationId());
		attributes.put("employmentStatusId", getEmploymentStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("joinedDate", getJoinedDate());
		attributes.put("employmentContractStartDate",
			getEmploymentContractStartDate());
		attributes.put("employmentContractEndDate",
			getEmploymentContractEndDate());
		attributes.put("contractDetails", getContractDetails());
		attributes.put("employeeId", getEmployeeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		Long jobTitleId = (Long)attributes.get("jobTitleId");

		if (jobTitleId != null) {
			setJobTitleId(jobTitleId);
		}

		Long jobCategoryId = (Long)attributes.get("jobCategoryId");

		if (jobCategoryId != null) {
			setJobCategoryId(jobCategoryId);
		}

		Long subUnitId = (Long)attributes.get("subUnitId");

		if (subUnitId != null) {
			setSubUnitId(subUnitId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long employmentStatusId = (Long)attributes.get("employmentStatusId");

		if (employmentStatusId != null) {
			setEmploymentStatusId(employmentStatusId);
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

		Date joinedDate = (Date)attributes.get("joinedDate");

		if (joinedDate != null) {
			setJoinedDate(joinedDate);
		}

		Date employmentContractStartDate = (Date)attributes.get(
				"employmentContractStartDate");

		if (employmentContractStartDate != null) {
			setEmploymentContractStartDate(employmentContractStartDate);
		}

		Date employmentContractEndDate = (Date)attributes.get(
				"employmentContractEndDate");

		if (employmentContractEndDate != null) {
			setEmploymentContractEndDate(employmentContractEndDate);
		}

		Blob contractDetails = (Blob)attributes.get("contractDetails");

		if (contractDetails != null) {
			setContractDetails(contractDetails);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	/**
	* Returns the primary key of this job.
	*
	* @return the primary key of this job
	*/
	@Override
	public long getPrimaryKey() {
		return _job.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job.
	*
	* @param primaryKey the primary key of this job
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_job.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job ID of this job.
	*
	* @return the job ID of this job
	*/
	@Override
	public long getJobId() {
		return _job.getJobId();
	}

	/**
	* Sets the job ID of this job.
	*
	* @param jobId the job ID of this job
	*/
	@Override
	public void setJobId(long jobId) {
		_job.setJobId(jobId);
	}

	/**
	* Returns the job title ID of this job.
	*
	* @return the job title ID of this job
	*/
	@Override
	public long getJobTitleId() {
		return _job.getJobTitleId();
	}

	/**
	* Sets the job title ID of this job.
	*
	* @param jobTitleId the job title ID of this job
	*/
	@Override
	public void setJobTitleId(long jobTitleId) {
		_job.setJobTitleId(jobTitleId);
	}

	/**
	* Returns the job category ID of this job.
	*
	* @return the job category ID of this job
	*/
	@Override
	public long getJobCategoryId() {
		return _job.getJobCategoryId();
	}

	/**
	* Sets the job category ID of this job.
	*
	* @param jobCategoryId the job category ID of this job
	*/
	@Override
	public void setJobCategoryId(long jobCategoryId) {
		_job.setJobCategoryId(jobCategoryId);
	}

	/**
	* Returns the sub unit ID of this job.
	*
	* @return the sub unit ID of this job
	*/
	@Override
	public long getSubUnitId() {
		return _job.getSubUnitId();
	}

	/**
	* Sets the sub unit ID of this job.
	*
	* @param subUnitId the sub unit ID of this job
	*/
	@Override
	public void setSubUnitId(long subUnitId) {
		_job.setSubUnitId(subUnitId);
	}

	/**
	* Returns the location ID of this job.
	*
	* @return the location ID of this job
	*/
	@Override
	public long getLocationId() {
		return _job.getLocationId();
	}

	/**
	* Sets the location ID of this job.
	*
	* @param locationId the location ID of this job
	*/
	@Override
	public void setLocationId(long locationId) {
		_job.setLocationId(locationId);
	}

	/**
	* Returns the employment status ID of this job.
	*
	* @return the employment status ID of this job
	*/
	@Override
	public long getEmploymentStatusId() {
		return _job.getEmploymentStatusId();
	}

	/**
	* Sets the employment status ID of this job.
	*
	* @param employmentStatusId the employment status ID of this job
	*/
	@Override
	public void setEmploymentStatusId(long employmentStatusId) {
		_job.setEmploymentStatusId(employmentStatusId);
	}

	/**
	* Returns the group ID of this job.
	*
	* @return the group ID of this job
	*/
	@Override
	public long getGroupId() {
		return _job.getGroupId();
	}

	/**
	* Sets the group ID of this job.
	*
	* @param groupId the group ID of this job
	*/
	@Override
	public void setGroupId(long groupId) {
		_job.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this job.
	*
	* @return the company ID of this job
	*/
	@Override
	public long getCompanyId() {
		return _job.getCompanyId();
	}

	/**
	* Sets the company ID of this job.
	*
	* @param companyId the company ID of this job
	*/
	@Override
	public void setCompanyId(long companyId) {
		_job.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this job.
	*
	* @return the user ID of this job
	*/
	@Override
	public long getUserId() {
		return _job.getUserId();
	}

	/**
	* Sets the user ID of this job.
	*
	* @param userId the user ID of this job
	*/
	@Override
	public void setUserId(long userId) {
		_job.setUserId(userId);
	}

	/**
	* Returns the user uuid of this job.
	*
	* @return the user uuid of this job
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _job.getUserUuid();
	}

	/**
	* Sets the user uuid of this job.
	*
	* @param userUuid the user uuid of this job
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_job.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this job.
	*
	* @return the create date of this job
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _job.getCreateDate();
	}

	/**
	* Sets the create date of this job.
	*
	* @param createDate the create date of this job
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_job.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this job.
	*
	* @return the modified date of this job
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _job.getModifiedDate();
	}

	/**
	* Sets the modified date of this job.
	*
	* @param modifiedDate the modified date of this job
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_job.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the joined date of this job.
	*
	* @return the joined date of this job
	*/
	@Override
	public java.util.Date getJoinedDate() {
		return _job.getJoinedDate();
	}

	/**
	* Sets the joined date of this job.
	*
	* @param joinedDate the joined date of this job
	*/
	@Override
	public void setJoinedDate(java.util.Date joinedDate) {
		_job.setJoinedDate(joinedDate);
	}

	/**
	* Returns the employment contract start date of this job.
	*
	* @return the employment contract start date of this job
	*/
	@Override
	public java.util.Date getEmploymentContractStartDate() {
		return _job.getEmploymentContractStartDate();
	}

	/**
	* Sets the employment contract start date of this job.
	*
	* @param employmentContractStartDate the employment contract start date of this job
	*/
	@Override
	public void setEmploymentContractStartDate(
		java.util.Date employmentContractStartDate) {
		_job.setEmploymentContractStartDate(employmentContractStartDate);
	}

	/**
	* Returns the employment contract end date of this job.
	*
	* @return the employment contract end date of this job
	*/
	@Override
	public java.util.Date getEmploymentContractEndDate() {
		return _job.getEmploymentContractEndDate();
	}

	/**
	* Sets the employment contract end date of this job.
	*
	* @param employmentContractEndDate the employment contract end date of this job
	*/
	@Override
	public void setEmploymentContractEndDate(
		java.util.Date employmentContractEndDate) {
		_job.setEmploymentContractEndDate(employmentContractEndDate);
	}

	/**
	* Returns the contract details of this job.
	*
	* @return the contract details of this job
	*/
	@Override
	public java.sql.Blob getContractDetails() {
		return _job.getContractDetails();
	}

	/**
	* Sets the contract details of this job.
	*
	* @param contractDetails the contract details of this job
	*/
	@Override
	public void setContractDetails(java.sql.Blob contractDetails) {
		_job.setContractDetails(contractDetails);
	}

	/**
	* Returns the employee ID of this job.
	*
	* @return the employee ID of this job
	*/
	@Override
	public long getEmployeeId() {
		return _job.getEmployeeId();
	}

	/**
	* Sets the employee ID of this job.
	*
	* @param employeeId the employee ID of this job
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_job.setEmployeeId(employeeId);
	}

	@Override
	public boolean isNew() {
		return _job.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_job.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _job.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_job.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _job.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _job.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_job.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _job.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_job.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_job.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_job.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobWrapper((Job)_job.clone());
	}

	@Override
	public int compareTo(Job job) {
		return _job.compareTo(job);
	}

	@Override
	public int hashCode() {
		return _job.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<Job> toCacheModel() {
		return _job.toCacheModel();
	}

	@Override
	public Job toEscapedModel() {
		return new JobWrapper(_job.toEscapedModel());
	}

	@Override
	public Job toUnescapedModel() {
		return new JobWrapper(_job.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _job.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _job.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_job.persist();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.JobTitle getJobTitle()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _job.getJobTitle();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.JobCategory getJobCategory()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _job.getJobCategory();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmploymentStatus getEmploymentStatus()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _job.getEmploymentStatus();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Location getLocation()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _job.getLocation();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.SubUnit getSubUnit()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _job.getSubUnit();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobWrapper)) {
			return false;
		}

		JobWrapper jobWrapper = (JobWrapper)obj;

		if (Validator.equals(_job, jobWrapper._job)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Job getWrappedJob() {
		return _job;
	}

	@Override
	public Job getWrappedModel() {
		return _job;
	}

	@Override
	public void resetOriginalValues() {
		_job.resetOriginalValues();
	}

	private Job _job;
}