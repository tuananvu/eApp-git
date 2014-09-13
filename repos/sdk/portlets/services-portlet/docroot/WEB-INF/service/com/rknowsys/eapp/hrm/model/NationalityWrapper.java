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
 * This class is a wrapper for {@link Nationality}.
 * </p>
 *
 * @author rknowsys
 * @see Nationality
 * @generated
 */
public class NationalityWrapper implements Nationality,
	ModelWrapper<Nationality> {
	public NationalityWrapper(Nationality nationality) {
		_nationality = nationality;
	}

	@Override
	public Class<?> getModelClass() {
		return Nationality.class;
	}

	@Override
	public String getModelClassName() {
		return Nationality.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("nationalityId", getNationalityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("Name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
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

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}
	}

	/**
	* Returns the primary key of this nationality.
	*
	* @return the primary key of this nationality
	*/
	@Override
	public long getPrimaryKey() {
		return _nationality.getPrimaryKey();
	}

	/**
	* Sets the primary key of this nationality.
	*
	* @param primaryKey the primary key of this nationality
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_nationality.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the nationality ID of this nationality.
	*
	* @return the nationality ID of this nationality
	*/
	@Override
	public long getNationalityId() {
		return _nationality.getNationalityId();
	}

	/**
	* Sets the nationality ID of this nationality.
	*
	* @param nationalityId the nationality ID of this nationality
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_nationality.setNationalityId(nationalityId);
	}

	/**
	* Returns the group ID of this nationality.
	*
	* @return the group ID of this nationality
	*/
	@Override
	public long getGroupId() {
		return _nationality.getGroupId();
	}

	/**
	* Sets the group ID of this nationality.
	*
	* @param groupId the group ID of this nationality
	*/
	@Override
	public void setGroupId(long groupId) {
		_nationality.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this nationality.
	*
	* @return the company ID of this nationality
	*/
	@Override
	public long getCompanyId() {
		return _nationality.getCompanyId();
	}

	/**
	* Sets the company ID of this nationality.
	*
	* @param companyId the company ID of this nationality
	*/
	@Override
	public void setCompanyId(long companyId) {
		_nationality.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this nationality.
	*
	* @return the user ID of this nationality
	*/
	@Override
	public long getUserId() {
		return _nationality.getUserId();
	}

	/**
	* Sets the user ID of this nationality.
	*
	* @param userId the user ID of this nationality
	*/
	@Override
	public void setUserId(long userId) {
		_nationality.setUserId(userId);
	}

	/**
	* Returns the user uuid of this nationality.
	*
	* @return the user uuid of this nationality
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _nationality.getUserUuid();
	}

	/**
	* Sets the user uuid of this nationality.
	*
	* @param userUuid the user uuid of this nationality
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_nationality.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this nationality.
	*
	* @return the create date of this nationality
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _nationality.getCreateDate();
	}

	/**
	* Sets the create date of this nationality.
	*
	* @param createDate the create date of this nationality
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_nationality.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this nationality.
	*
	* @return the modified date of this nationality
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _nationality.getModifiedDate();
	}

	/**
	* Sets the modified date of this nationality.
	*
	* @param modifiedDate the modified date of this nationality
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_nationality.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this nationality.
	*
	* @return the name of this nationality
	*/
	@Override
	public java.lang.String getName() {
		return _nationality.getName();
	}

	/**
	* Sets the name of this nationality.
	*
	* @param Name the name of this nationality
	*/
	@Override
	public void setName(java.lang.String Name) {
		_nationality.setName(Name);
	}

	@Override
	public boolean isNew() {
		return _nationality.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_nationality.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _nationality.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_nationality.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _nationality.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _nationality.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nationality.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nationality.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_nationality.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_nationality.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nationality.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NationalityWrapper((Nationality)_nationality.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Nationality nationality) {
		return _nationality.compareTo(nationality);
	}

	@Override
	public int hashCode() {
		return _nationality.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Nationality> toCacheModel() {
		return _nationality.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Nationality toEscapedModel() {
		return new NationalityWrapper(_nationality.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Nationality toUnescapedModel() {
		return new NationalityWrapper(_nationality.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nationality.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _nationality.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nationality.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NationalityWrapper)) {
			return false;
		}

		NationalityWrapper nationalityWrapper = (NationalityWrapper)obj;

		if (Validator.equals(_nationality, nationalityWrapper._nationality)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Nationality getWrappedNationality() {
		return _nationality;
	}

	@Override
	public Nationality getWrappedModel() {
		return _nationality;
	}

	@Override
	public void resetOriginalValues() {
		_nationality.resetOriginalValues();
	}

	private Nationality _nationality;
}