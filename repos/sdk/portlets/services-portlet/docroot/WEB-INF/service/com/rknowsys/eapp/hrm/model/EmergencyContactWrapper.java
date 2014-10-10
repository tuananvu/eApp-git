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

		attributes.put("emergencyContactId", getEmergencyContactId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("relationship", getRelationship());
		attributes.put("homeTelephone", getHomeTelephone());
		attributes.put("mobile", getMobile());
		attributes.put("workTelephone", getWorkTelephone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long emergencyContactId = (Long)attributes.get("emergencyContactId");

		if (emergencyContactId != null) {
			setEmergencyContactId(emergencyContactId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String relationship = (String)attributes.get("relationship");

		if (relationship != null) {
			setRelationship(relationship);
		}

		String homeTelephone = (String)attributes.get("homeTelephone");

		if (homeTelephone != null) {
			setHomeTelephone(homeTelephone);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String workTelephone = (String)attributes.get("workTelephone");

		if (workTelephone != null) {
			setWorkTelephone(workTelephone);
		}
	}

	/**
	* Returns the primary key of this EmergencyContact.
	*
	* @return the primary key of this EmergencyContact
	*/
	@Override
	public long getPrimaryKey() {
		return _emergencyContact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this EmergencyContact.
	*
	* @param primaryKey the primary key of this EmergencyContact
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_emergencyContact.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emergency contact ID of this EmergencyContact.
	*
	* @return the emergency contact ID of this EmergencyContact
	*/
	@Override
	public long getEmergencyContactId() {
		return _emergencyContact.getEmergencyContactId();
	}

	/**
	* Sets the emergency contact ID of this EmergencyContact.
	*
	* @param emergencyContactId the emergency contact ID of this EmergencyContact
	*/
	@Override
	public void setEmergencyContactId(long emergencyContactId) {
		_emergencyContact.setEmergencyContactId(emergencyContactId);
	}

	/**
	* Returns the employee ID of this EmergencyContact.
	*
	* @return the employee ID of this EmergencyContact
	*/
	@Override
	public long getEmployeeId() {
		return _emergencyContact.getEmployeeId();
	}

	/**
	* Sets the employee ID of this EmergencyContact.
	*
	* @param employeeId the employee ID of this EmergencyContact
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_emergencyContact.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this EmergencyContact.
	*
	* @return the group ID of this EmergencyContact
	*/
	@Override
	public long getGroupId() {
		return _emergencyContact.getGroupId();
	}

	/**
	* Sets the group ID of this EmergencyContact.
	*
	* @param groupId the group ID of this EmergencyContact
	*/
	@Override
	public void setGroupId(long groupId) {
		_emergencyContact.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this EmergencyContact.
	*
	* @return the company ID of this EmergencyContact
	*/
	@Override
	public long getCompanyId() {
		return _emergencyContact.getCompanyId();
	}

	/**
	* Sets the company ID of this EmergencyContact.
	*
	* @param companyId the company ID of this EmergencyContact
	*/
	@Override
	public void setCompanyId(long companyId) {
		_emergencyContact.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this EmergencyContact.
	*
	* @return the user ID of this EmergencyContact
	*/
	@Override
	public long getUserId() {
		return _emergencyContact.getUserId();
	}

	/**
	* Sets the user ID of this EmergencyContact.
	*
	* @param userId the user ID of this EmergencyContact
	*/
	@Override
	public void setUserId(long userId) {
		_emergencyContact.setUserId(userId);
	}

	/**
	* Returns the user uuid of this EmergencyContact.
	*
	* @return the user uuid of this EmergencyContact
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContact.getUserUuid();
	}

	/**
	* Sets the user uuid of this EmergencyContact.
	*
	* @param userUuid the user uuid of this EmergencyContact
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_emergencyContact.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this EmergencyContact.
	*
	* @return the create date of this EmergencyContact
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _emergencyContact.getCreateDate();
	}

	/**
	* Sets the create date of this EmergencyContact.
	*
	* @param createDate the create date of this EmergencyContact
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_emergencyContact.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this EmergencyContact.
	*
	* @return the modified date of this EmergencyContact
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _emergencyContact.getModifiedDate();
	}

	/**
	* Sets the modified date of this EmergencyContact.
	*
	* @param modifiedDate the modified date of this EmergencyContact
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_emergencyContact.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this EmergencyContact.
	*
	* @return the name of this EmergencyContact
	*/
	@Override
	public java.lang.String getName() {
		return _emergencyContact.getName();
	}

	/**
	* Sets the name of this EmergencyContact.
	*
	* @param name the name of this EmergencyContact
	*/
	@Override
	public void setName(java.lang.String name) {
		_emergencyContact.setName(name);
	}

	/**
	* Returns the relationship of this EmergencyContact.
	*
	* @return the relationship of this EmergencyContact
	*/
	@Override
	public java.lang.String getRelationship() {
		return _emergencyContact.getRelationship();
	}

	/**
	* Sets the relationship of this EmergencyContact.
	*
	* @param relationship the relationship of this EmergencyContact
	*/
	@Override
	public void setRelationship(java.lang.String relationship) {
		_emergencyContact.setRelationship(relationship);
	}

	/**
	* Returns the home telephone of this EmergencyContact.
	*
	* @return the home telephone of this EmergencyContact
	*/
	@Override
	public java.lang.String getHomeTelephone() {
		return _emergencyContact.getHomeTelephone();
	}

	/**
	* Sets the home telephone of this EmergencyContact.
	*
	* @param homeTelephone the home telephone of this EmergencyContact
	*/
	@Override
	public void setHomeTelephone(java.lang.String homeTelephone) {
		_emergencyContact.setHomeTelephone(homeTelephone);
	}

	/**
	* Returns the mobile of this EmergencyContact.
	*
	* @return the mobile of this EmergencyContact
	*/
	@Override
	public java.lang.String getMobile() {
		return _emergencyContact.getMobile();
	}

	/**
	* Sets the mobile of this EmergencyContact.
	*
	* @param mobile the mobile of this EmergencyContact
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_emergencyContact.setMobile(mobile);
	}

	/**
	* Returns the work telephone of this EmergencyContact.
	*
	* @return the work telephone of this EmergencyContact
	*/
	@Override
	public java.lang.String getWorkTelephone() {
		return _emergencyContact.getWorkTelephone();
	}

	/**
	* Sets the work telephone of this EmergencyContact.
	*
	* @param workTelephone the work telephone of this EmergencyContact
	*/
	@Override
	public void setWorkTelephone(java.lang.String workTelephone) {
		_emergencyContact.setWorkTelephone(workTelephone);
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
	public int compareTo(EmergencyContact emergencyContact) {
		return _emergencyContact.compareTo(emergencyContact);
	}

	@Override
	public int hashCode() {
		return _emergencyContact.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<EmergencyContact> toCacheModel() {
		return _emergencyContact.toCacheModel();
	}

	@Override
	public EmergencyContact toEscapedModel() {
		return new EmergencyContactWrapper(_emergencyContact.toEscapedModel());
	}

	@Override
	public EmergencyContact toUnescapedModel() {
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