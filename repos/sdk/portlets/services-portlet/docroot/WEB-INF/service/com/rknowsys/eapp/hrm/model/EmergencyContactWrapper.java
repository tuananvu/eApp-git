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
 * This class is a wrapper for {@link EmergencyContact}.
 * </p>
 *
 * @author rknowsys
 * @see EmergencyContact
 * @generated
 */
public class EmergencyContactWrapper implements EmergencyContact,
	ModelWrapper<EmergencyContact> {
	public EmergencyContactWrapper(EmergencyContact emergencyContact) {
		_emergencyContact = emergencyContact;
	}

	@Override
	public Class<?> getModelClass() {
		return EmergencyContact.class;
	}

	@Override
	public String getModelClassName() {
		return EmergencyContact.class.getName();
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
	* Returns the primary key of this emergency contact.
	*
	* @return the primary key of this emergency contact
	*/
	@Override
	public long getPrimaryKey() {
		return _emergencyContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emergency contact.
	*
	* @param primaryKey the primary key of this emergency contact
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_emergencyContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this emergency contact.
	*
	* @return the ID of this emergency contact
	*/
	@Override
	public long getId() {
		return _emergencyContact.getId();
	}

	/**
	* Sets the ID of this emergency contact.
	*
	* @param id the ID of this emergency contact
	*/
	@Override
	public void setId(long id) {
		_emergencyContact.setId(id);
	}

	/**
	* Returns the group ID of this emergency contact.
	*
	* @return the group ID of this emergency contact
	*/
	@Override
	public long getGroupId() {
		return _emergencyContact.getGroupId();
	}

	/**
	* Sets the group ID of this emergency contact.
	*
	* @param groupId the group ID of this emergency contact
	*/
	@Override
	public void setGroupId(long groupId) {
		_emergencyContact.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emergency contact.
	*
	* @return the company ID of this emergency contact
	*/
	@Override
	public long getCompanyId() {
		return _emergencyContact.getCompanyId();
	}

	/**
	* Sets the company ID of this emergency contact.
	*
	* @param companyId the company ID of this emergency contact
	*/
	@Override
	public void setCompanyId(long companyId) {
		_emergencyContact.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emergency contact.
	*
	* @return the user ID of this emergency contact
	*/
	@Override
	public long getUserId() {
		return _emergencyContact.getUserId();
	}

	/**
	* Sets the user ID of this emergency contact.
	*
	* @param userId the user ID of this emergency contact
	*/
	@Override
	public void setUserId(long userId) {
		_emergencyContact.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emergency contact.
	*
	* @return the user uuid of this emergency contact
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContact.getUserUuid();
	}

	/**
	* Sets the user uuid of this emergency contact.
	*
	* @param userUuid the user uuid of this emergency contact
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_emergencyContact.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this emergency contact.
	*
	* @return the create date of this emergency contact
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _emergencyContact.getCreateDate();
	}

	/**
	* Sets the create date of this emergency contact.
	*
	* @param createDate the create date of this emergency contact
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_emergencyContact.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emergency contact.
	*
	* @return the modified date of this emergency contact
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _emergencyContact.getModifiedDate();
	}

	/**
	* Sets the modified date of this emergency contact.
	*
	* @param modifiedDate the modified date of this emergency contact
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_emergencyContact.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _emergencyContact.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_emergencyContact.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _emergencyContact.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_emergencyContact.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _emergencyContact.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _emergencyContact.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_emergencyContact.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _emergencyContact.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_emergencyContact.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_emergencyContact.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_emergencyContact.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmergencyContactWrapper((EmergencyContact)_emergencyContact.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact) {
		return _emergencyContact.compareTo(emergencyContact);
	}

	@Override
	public int hashCode() {
		return _emergencyContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.EmergencyContact> toCacheModel() {
		return _emergencyContact.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact toEscapedModel() {
		return new EmergencyContactWrapper(_emergencyContact.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact toUnescapedModel() {
		return new EmergencyContactWrapper(_emergencyContact.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _emergencyContact.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _emergencyContact.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_emergencyContact.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmergencyContactWrapper)) {
			return false;
		}

		EmergencyContactWrapper emergencyContactWrapper = (EmergencyContactWrapper)obj;

		if (Validator.equals(_emergencyContact,
					emergencyContactWrapper._emergencyContact)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmergencyContact getWrappedEmergencyContact() {
		return _emergencyContact;
	}

	@Override
	public EmergencyContact getWrappedModel() {
		return _emergencyContact;
	}

	@Override
	public void resetOriginalValues() {
		_emergencyContact.resetOriginalValues();
	}

	private EmergencyContact _emergencyContact;
}