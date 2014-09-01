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
 * This class is a wrapper for {@link Immigration}.
 * </p>
 *
 * @author rknowsys
 * @see Immigration
 * @generated
 */
public class ImmigrationWrapper implements Immigration,
	ModelWrapper<Immigration> {
	public ImmigrationWrapper(Immigration immigration) {
		_immigration = immigration;
	}

	@Override
	public Class<?> getModelClass() {
		return Immigration.class;
	}

	@Override
	public String getModelClassName() {
		return Immigration.class.getName();
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
	* Returns the primary key of this immigration.
	*
	* @return the primary key of this immigration
	*/
	@Override
	public long getPrimaryKey() {
		return _immigration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this immigration.
	*
	* @param primaryKey the primary key of this immigration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_immigration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this immigration.
	*
	* @return the ID of this immigration
	*/
	@Override
	public long getId() {
		return _immigration.getId();
	}

	/**
	* Sets the ID of this immigration.
	*
	* @param id the ID of this immigration
	*/
	@Override
	public void setId(long id) {
		_immigration.setId(id);
	}

	/**
	* Returns the group ID of this immigration.
	*
	* @return the group ID of this immigration
	*/
	@Override
	public long getGroupId() {
		return _immigration.getGroupId();
	}

	/**
	* Sets the group ID of this immigration.
	*
	* @param groupId the group ID of this immigration
	*/
	@Override
	public void setGroupId(long groupId) {
		_immigration.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this immigration.
	*
	* @return the company ID of this immigration
	*/
	@Override
	public long getCompanyId() {
		return _immigration.getCompanyId();
	}

	/**
	* Sets the company ID of this immigration.
	*
	* @param companyId the company ID of this immigration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_immigration.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this immigration.
	*
	* @return the user ID of this immigration
	*/
	@Override
	public long getUserId() {
		return _immigration.getUserId();
	}

	/**
	* Sets the user ID of this immigration.
	*
	* @param userId the user ID of this immigration
	*/
	@Override
	public void setUserId(long userId) {
		_immigration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this immigration.
	*
	* @return the user uuid of this immigration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _immigration.getUserUuid();
	}

	/**
	* Sets the user uuid of this immigration.
	*
	* @param userUuid the user uuid of this immigration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_immigration.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this immigration.
	*
	* @return the create date of this immigration
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _immigration.getCreateDate();
	}

	/**
	* Sets the create date of this immigration.
	*
	* @param createDate the create date of this immigration
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_immigration.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this immigration.
	*
	* @return the modified date of this immigration
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _immigration.getModifiedDate();
	}

	/**
	* Sets the modified date of this immigration.
	*
	* @param modifiedDate the modified date of this immigration
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_immigration.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _immigration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_immigration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _immigration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_immigration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _immigration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _immigration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_immigration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _immigration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_immigration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_immigration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_immigration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ImmigrationWrapper((Immigration)_immigration.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Immigration immigration) {
		return _immigration.compareTo(immigration);
	}

	@Override
	public int hashCode() {
		return _immigration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Immigration> toCacheModel() {
		return _immigration.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Immigration toEscapedModel() {
		return new ImmigrationWrapper(_immigration.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Immigration toUnescapedModel() {
		return new ImmigrationWrapper(_immigration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _immigration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _immigration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_immigration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImmigrationWrapper)) {
			return false;
		}

		ImmigrationWrapper immigrationWrapper = (ImmigrationWrapper)obj;

		if (Validator.equals(_immigration, immigrationWrapper._immigration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Immigration getWrappedImmigration() {
		return _immigration;
	}

	@Override
	public Immigration getWrappedModel() {
		return _immigration;
	}

	@Override
	public void resetOriginalValues() {
		_immigration.resetOriginalValues();
	}

	private Immigration _immigration;
}