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
 * This class is a wrapper for {@link JobTitles}.
 * </p>
 *
 * @author Rknowsys
 * @see JobTitles
 * @generated
 */
public class JobTitlesWrapper implements JobTitles, ModelWrapper<JobTitles> {
	public JobTitlesWrapper(JobTitles jobTitles) {
		_jobTitles = jobTitles;
	}

	@Override
	public Class<?> getModelClass() {
		return JobTitles.class;
	}

	@Override
	public String getModelClassName() {
		return JobTitles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("notes", getNotes());
		attributes.put("specification", getSpecification());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		String specification = (String)attributes.get("specification");

		if (specification != null) {
			setSpecification(specification);
		}
	}

	/**
	* Returns the primary key of this job titles.
	*
	* @return the primary key of this job titles
	*/
	@Override
	public long getPrimaryKey() {
		return _jobTitles.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job titles.
	*
	* @param primaryKey the primary key of this job titles
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jobTitles.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this job titles.
	*
	* @return the ID of this job titles
	*/
	@Override
	public long getId() {
		return _jobTitles.getId();
	}

	/**
	* Sets the ID of this job titles.
	*
	* @param id the ID of this job titles
	*/
	@Override
	public void setId(long id) {
		_jobTitles.setId(id);
	}

	/**
	* Returns the company ID of this job titles.
	*
	* @return the company ID of this job titles
	*/
	@Override
	public long getCompanyId() {
		return _jobTitles.getCompanyId();
	}

	/**
	* Sets the company ID of this job titles.
	*
	* @param companyId the company ID of this job titles
	*/
	@Override
	public void setCompanyId(long companyId) {
		_jobTitles.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this job titles.
	*
	* @return the group ID of this job titles
	*/
	@Override
	public long getGroupId() {
		return _jobTitles.getGroupId();
	}

	/**
	* Sets the group ID of this job titles.
	*
	* @param groupId the group ID of this job titles
	*/
	@Override
	public void setGroupId(long groupId) {
		_jobTitles.setGroupId(groupId);
	}

	/**
	* Returns the create date of this job titles.
	*
	* @return the create date of this job titles
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jobTitles.getCreateDate();
	}

	/**
	* Sets the create date of this job titles.
	*
	* @param createDate the create date of this job titles
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jobTitles.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this job titles.
	*
	* @return the modified date of this job titles
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jobTitles.getModifiedDate();
	}

	/**
	* Sets the modified date of this job titles.
	*
	* @param modifiedDate the modified date of this job titles
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jobTitles.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this job titles.
	*
	* @return the user ID of this job titles
	*/
	@Override
	public long getUserId() {
		return _jobTitles.getUserId();
	}

	/**
	* Sets the user ID of this job titles.
	*
	* @param userId the user ID of this job titles
	*/
	@Override
	public void setUserId(long userId) {
		_jobTitles.setUserId(userId);
	}

	/**
	* Returns the user uuid of this job titles.
	*
	* @return the user uuid of this job titles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobTitles.getUserUuid();
	}

	/**
	* Sets the user uuid of this job titles.
	*
	* @param userUuid the user uuid of this job titles
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_jobTitles.setUserUuid(userUuid);
	}

	/**
	* Returns the title of this job titles.
	*
	* @return the title of this job titles
	*/
	@Override
	public java.lang.String getTitle() {
		return _jobTitles.getTitle();
	}

	/**
	* Sets the title of this job titles.
	*
	* @param title the title of this job titles
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_jobTitles.setTitle(title);
	}

	/**
	* Returns the description of this job titles.
	*
	* @return the description of this job titles
	*/
	@Override
	public java.lang.String getDescription() {
		return _jobTitles.getDescription();
	}

	/**
	* Sets the description of this job titles.
	*
	* @param description the description of this job titles
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_jobTitles.setDescription(description);
	}

	/**
	* Returns the notes of this job titles.
	*
	* @return the notes of this job titles
	*/
	@Override
	public java.lang.String getNotes() {
		return _jobTitles.getNotes();
	}

	/**
	* Sets the notes of this job titles.
	*
	* @param notes the notes of this job titles
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_jobTitles.setNotes(notes);
	}

	/**
	* Returns the specification of this job titles.
	*
	* @return the specification of this job titles
	*/
	@Override
	public java.lang.String getSpecification() {
		return _jobTitles.getSpecification();
	}

	/**
	* Sets the specification of this job titles.
	*
	* @param specification the specification of this job titles
	*/
	@Override
	public void setSpecification(java.lang.String specification) {
		_jobTitles.setSpecification(specification);
	}

	@Override
	public boolean isNew() {
		return _jobTitles.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jobTitles.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jobTitles.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jobTitles.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jobTitles.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jobTitles.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jobTitles.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jobTitles.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jobTitles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jobTitles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jobTitles.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobTitlesWrapper((JobTitles)_jobTitles.clone());
	}

	@Override
	public int compareTo(JobTitles jobTitles) {
		return _jobTitles.compareTo(jobTitles);
	}

	@Override
	public int hashCode() {
		return _jobTitles.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<JobTitles> toCacheModel() {
		return _jobTitles.toCacheModel();
	}

	@Override
	public JobTitles toEscapedModel() {
		return new JobTitlesWrapper(_jobTitles.toEscapedModel());
	}

	@Override
	public JobTitles toUnescapedModel() {
		return new JobTitlesWrapper(_jobTitles.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jobTitles.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jobTitles.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobTitles.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobTitlesWrapper)) {
			return false;
		}

		JobTitlesWrapper jobTitlesWrapper = (JobTitlesWrapper)obj;

		if (Validator.equals(_jobTitles, jobTitlesWrapper._jobTitles)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JobTitles getWrappedJobTitles() {
		return _jobTitles;
	}

	@Override
	public JobTitles getWrappedModel() {
		return _jobTitles;
	}

	@Override
	public void resetOriginalValues() {
		_jobTitles.resetOriginalValues();
	}

	private JobTitles _jobTitles;
}