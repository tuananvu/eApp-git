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
 * This class is a wrapper for {@link Dependent}.
 * </p>
 *
 * @author rknowsys
 * @see Dependent
 * @generated
 */
public class DependentWrapper implements Dependent, ModelWrapper<Dependent> {
	public DependentWrapper(Dependent dependent) {
		_dependent = dependent;
	}

	@Override
	public Class<?> getModelClass() {
		return Dependent.class;
	}

	@Override
	public String getModelClassName() {
		return Dependent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dependentId", getDependentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dependentId = (Long)attributes.get("dependentId");

		if (dependentId != null) {
			setDependentId(dependentId);
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
	* Returns the primary key of this dependent.
	*
	* @return the primary key of this dependent
	*/
	@Override
	public long getPrimaryKey() {
		return _dependent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dependent.
	*
	* @param primaryKey the primary key of this dependent
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dependent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dependent ID of this dependent.
	*
	* @return the dependent ID of this dependent
	*/
	@Override
	public long getDependentId() {
		return _dependent.getDependentId();
	}

	/**
	* Sets the dependent ID of this dependent.
	*
	* @param dependentId the dependent ID of this dependent
	*/
	@Override
	public void setDependentId(long dependentId) {
		_dependent.setDependentId(dependentId);
	}

	/**
	* Returns the group ID of this dependent.
	*
	* @return the group ID of this dependent
	*/
	@Override
	public long getGroupId() {
		return _dependent.getGroupId();
	}

	/**
	* Sets the group ID of this dependent.
	*
	* @param groupId the group ID of this dependent
	*/
	@Override
	public void setGroupId(long groupId) {
		_dependent.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this dependent.
	*
	* @return the company ID of this dependent
	*/
	@Override
	public long getCompanyId() {
		return _dependent.getCompanyId();
	}

	/**
	* Sets the company ID of this dependent.
	*
	* @param companyId the company ID of this dependent
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dependent.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this dependent.
	*
	* @return the user ID of this dependent
	*/
	@Override
	public long getUserId() {
		return _dependent.getUserId();
	}

	/**
	* Sets the user ID of this dependent.
	*
	* @param userId the user ID of this dependent
	*/
	@Override
	public void setUserId(long userId) {
		_dependent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dependent.
	*
	* @return the user uuid of this dependent
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dependent.getUserUuid();
	}

	/**
	* Sets the user uuid of this dependent.
	*
	* @param userUuid the user uuid of this dependent
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dependent.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dependent.
	*
	* @return the create date of this dependent
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dependent.getCreateDate();
	}

	/**
	* Sets the create date of this dependent.
	*
	* @param createDate the create date of this dependent
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dependent.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dependent.
	*
	* @return the modified date of this dependent
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dependent.getModifiedDate();
	}

	/**
	* Sets the modified date of this dependent.
	*
	* @param modifiedDate the modified date of this dependent
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dependent.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _dependent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dependent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dependent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dependent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dependent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dependent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dependent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dependent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dependent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dependent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dependent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DependentWrapper((Dependent)_dependent.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Dependent dependent) {
		return _dependent.compareTo(dependent);
	}

	@Override
	public int hashCode() {
		return _dependent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Dependent> toCacheModel() {
		return _dependent.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Dependent toEscapedModel() {
		return new DependentWrapper(_dependent.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Dependent toUnescapedModel() {
		return new DependentWrapper(_dependent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dependent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dependent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dependent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DependentWrapper)) {
			return false;
		}

		DependentWrapper dependentWrapper = (DependentWrapper)obj;

		if (Validator.equals(_dependent, dependentWrapper._dependent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Dependent getWrappedDependent() {
		return _dependent;
	}

	@Override
	public Dependent getWrappedModel() {
		return _dependent;
	}

	@Override
	public void resetOriginalValues() {
		_dependent.resetOriginalValues();
	}

	private Dependent _dependent;
}