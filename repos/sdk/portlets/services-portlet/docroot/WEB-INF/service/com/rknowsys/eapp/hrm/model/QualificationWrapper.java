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
 * This class is a wrapper for {@link Qualification}.
 * </p>
 *
 * @author rknowsys
 * @see Qualification
 * @generated
 */
public class QualificationWrapper implements Qualification,
	ModelWrapper<Qualification> {
	public QualificationWrapper(Qualification qualification) {
		_qualification = qualification;
	}

	@Override
	public Class<?> getModelClass() {
		return Qualification.class;
	}

	@Override
	public String getModelClassName() {
		return Qualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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
	}

	/**
	* Returns the primary key of this qualification.
	*
	* @return the primary key of this qualification
	*/
	@Override
	public long getPrimaryKey() {
		return _qualification.getPrimaryKey();
	}

	/**
	* Sets the primary key of this qualification.
	*
	* @param primaryKey the primary key of this qualification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_qualification.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this qualification.
	*
	* @return the ID of this qualification
	*/
	@Override
	public long getId() {
		return _qualification.getId();
	}

	/**
	* Sets the ID of this qualification.
	*
	* @param id the ID of this qualification
	*/
	@Override
	public void setId(long id) {
		_qualification.setId(id);
	}

	/**
	* Returns the group ID of this qualification.
	*
	* @return the group ID of this qualification
	*/
	@Override
	public long getGroupId() {
		return _qualification.getGroupId();
	}

	/**
	* Sets the group ID of this qualification.
	*
	* @param groupId the group ID of this qualification
	*/
	@Override
	public void setGroupId(long groupId) {
		_qualification.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this qualification.
	*
	* @return the company ID of this qualification
	*/
	@Override
	public long getCompanyId() {
		return _qualification.getCompanyId();
	}

	/**
	* Sets the company ID of this qualification.
	*
	* @param companyId the company ID of this qualification
	*/
	@Override
	public void setCompanyId(long companyId) {
		_qualification.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this qualification.
	*
	* @return the user ID of this qualification
	*/
	@Override
	public long getUserId() {
		return _qualification.getUserId();
	}

	/**
	* Sets the user ID of this qualification.
	*
	* @param userId the user ID of this qualification
	*/
	@Override
	public void setUserId(long userId) {
		_qualification.setUserId(userId);
	}

	/**
	* Returns the user uuid of this qualification.
	*
	* @return the user uuid of this qualification
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _qualification.getUserUuid();
	}

	/**
	* Sets the user uuid of this qualification.
	*
	* @param userUuid the user uuid of this qualification
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_qualification.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this qualification.
	*
	* @return the create date of this qualification
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _qualification.getCreateDate();
	}

	/**
	* Sets the create date of this qualification.
	*
	* @param createDate the create date of this qualification
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_qualification.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this qualification.
	*
	* @return the modified date of this qualification
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _qualification.getModifiedDate();
	}

	/**
	* Sets the modified date of this qualification.
	*
	* @param modifiedDate the modified date of this qualification
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_qualification.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _qualification.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_qualification.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _qualification.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_qualification.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _qualification.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _qualification.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_qualification.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _qualification.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_qualification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_qualification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_qualification.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new QualificationWrapper((Qualification)_qualification.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.Qualification qualification) {
		return _qualification.compareTo(qualification);
	}

	@Override
	public int hashCode() {
		return _qualification.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Qualification> toCacheModel() {
		return _qualification.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Qualification toEscapedModel() {
		return new QualificationWrapper(_qualification.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Qualification toUnescapedModel() {
		return new QualificationWrapper(_qualification.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _qualification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _qualification.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_qualification.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QualificationWrapper)) {
			return false;
		}

		QualificationWrapper qualificationWrapper = (QualificationWrapper)obj;

		if (Validator.equals(_qualification, qualificationWrapper._qualification)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Qualification getWrappedQualification() {
		return _qualification;
	}

	@Override
	public Qualification getWrappedModel() {
		return _qualification;
	}

	@Override
	public void resetOriginalValues() {
		_qualification.resetOriginalValues();
	}

	private Qualification _qualification;
}