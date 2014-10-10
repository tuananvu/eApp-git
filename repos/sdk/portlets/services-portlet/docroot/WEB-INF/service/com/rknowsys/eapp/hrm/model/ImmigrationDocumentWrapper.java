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
 * This class is a wrapper for {@link ImmigrationDocument}.
 * </p>
 *
 * @author rknowsys
 * @see ImmigrationDocument
 * @generated
 */
public class ImmigrationDocumentWrapper implements ImmigrationDocument,
	ModelWrapper<ImmigrationDocument> {
	public ImmigrationDocumentWrapper(ImmigrationDocument immigrationDocument) {
		_immigrationDocument = immigrationDocument;
	}

	@Override
	public Class<?> getModelClass() {
		return ImmigrationDocument.class;
	}

	@Override
	public String getModelClassName() {
		return ImmigrationDocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("immigrationDocumentId", getImmigrationDocumentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("docTopic", getDocTopic());
		attributes.put("docCategory", getDocCategory());
		attributes.put("description", getDescription());
		attributes.put("publishTo", getPublishTo());
		attributes.put("publishDate", getPublishDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long immigrationDocumentId = (Long)attributes.get(
				"immigrationDocumentId");

		if (immigrationDocumentId != null) {
			setImmigrationDocumentId(immigrationDocumentId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
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

		String docTopic = (String)attributes.get("docTopic");

		if (docTopic != null) {
			setDocTopic(docTopic);
		}

		String docCategory = (String)attributes.get("docCategory");

		if (docCategory != null) {
			setDocCategory(docCategory);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String publishTo = (String)attributes.get("publishTo");

		if (publishTo != null) {
			setPublishTo(publishTo);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}
	}

	/**
	* Returns the primary key of this ImmigrationDocument.
	*
	* @return the primary key of this ImmigrationDocument
	*/
	@Override
	public long getPrimaryKey() {
		return _immigrationDocument.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ImmigrationDocument.
	*
	* @param primaryKey the primary key of this ImmigrationDocument
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_immigrationDocument.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the immigration document ID of this ImmigrationDocument.
	*
	* @return the immigration document ID of this ImmigrationDocument
	*/
	@Override
	public long getImmigrationDocumentId() {
		return _immigrationDocument.getImmigrationDocumentId();
	}

	/**
	* Sets the immigration document ID of this ImmigrationDocument.
	*
	* @param immigrationDocumentId the immigration document ID of this ImmigrationDocument
	*/
	@Override
	public void setImmigrationDocumentId(long immigrationDocumentId) {
		_immigrationDocument.setImmigrationDocumentId(immigrationDocumentId);
	}

	/**
	* Returns the employee ID of this ImmigrationDocument.
	*
	* @return the employee ID of this ImmigrationDocument
	*/
	@Override
	public long getEmployeeId() {
		return _immigrationDocument.getEmployeeId();
	}

	/**
	* Sets the employee ID of this ImmigrationDocument.
	*
	* @param employeeId the employee ID of this ImmigrationDocument
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_immigrationDocument.setEmployeeId(employeeId);
	}

	/**
	* Returns the company ID of this ImmigrationDocument.
	*
	* @return the company ID of this ImmigrationDocument
	*/
	@Override
	public long getCompanyId() {
		return _immigrationDocument.getCompanyId();
	}

	/**
	* Sets the company ID of this ImmigrationDocument.
	*
	* @param companyId the company ID of this ImmigrationDocument
	*/
	@Override
	public void setCompanyId(long companyId) {
		_immigrationDocument.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this ImmigrationDocument.
	*
	* @return the group ID of this ImmigrationDocument
	*/
	@Override
	public long getGroupId() {
		return _immigrationDocument.getGroupId();
	}

	/**
	* Sets the group ID of this ImmigrationDocument.
	*
	* @param groupId the group ID of this ImmigrationDocument
	*/
	@Override
	public void setGroupId(long groupId) {
		_immigrationDocument.setGroupId(groupId);
	}

	/**
	* Returns the create date of this ImmigrationDocument.
	*
	* @return the create date of this ImmigrationDocument
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _immigrationDocument.getCreateDate();
	}

	/**
	* Sets the create date of this ImmigrationDocument.
	*
	* @param createDate the create date of this ImmigrationDocument
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_immigrationDocument.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this ImmigrationDocument.
	*
	* @return the modified date of this ImmigrationDocument
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _immigrationDocument.getModifiedDate();
	}

	/**
	* Sets the modified date of this ImmigrationDocument.
	*
	* @param modifiedDate the modified date of this ImmigrationDocument
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_immigrationDocument.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this ImmigrationDocument.
	*
	* @return the user ID of this ImmigrationDocument
	*/
	@Override
	public long getUserId() {
		return _immigrationDocument.getUserId();
	}

	/**
	* Sets the user ID of this ImmigrationDocument.
	*
	* @param userId the user ID of this ImmigrationDocument
	*/
	@Override
	public void setUserId(long userId) {
		_immigrationDocument.setUserId(userId);
	}

	/**
	* Returns the user uuid of this ImmigrationDocument.
	*
	* @return the user uuid of this ImmigrationDocument
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _immigrationDocument.getUserUuid();
	}

	/**
	* Sets the user uuid of this ImmigrationDocument.
	*
	* @param userUuid the user uuid of this ImmigrationDocument
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_immigrationDocument.setUserUuid(userUuid);
	}

	/**
	* Returns the doc topic of this ImmigrationDocument.
	*
	* @return the doc topic of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getDocTopic() {
		return _immigrationDocument.getDocTopic();
	}

	/**
	* Sets the doc topic of this ImmigrationDocument.
	*
	* @param docTopic the doc topic of this ImmigrationDocument
	*/
	@Override
	public void setDocTopic(java.lang.String docTopic) {
		_immigrationDocument.setDocTopic(docTopic);
	}

	/**
	* Returns the doc category of this ImmigrationDocument.
	*
	* @return the doc category of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getDocCategory() {
		return _immigrationDocument.getDocCategory();
	}

	/**
	* Sets the doc category of this ImmigrationDocument.
	*
	* @param docCategory the doc category of this ImmigrationDocument
	*/
	@Override
	public void setDocCategory(java.lang.String docCategory) {
		_immigrationDocument.setDocCategory(docCategory);
	}

	/**
	* Returns the description of this ImmigrationDocument.
	*
	* @return the description of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getDescription() {
		return _immigrationDocument.getDescription();
	}

	/**
	* Sets the description of this ImmigrationDocument.
	*
	* @param description the description of this ImmigrationDocument
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_immigrationDocument.setDescription(description);
	}

	/**
	* Returns the publish to of this ImmigrationDocument.
	*
	* @return the publish to of this ImmigrationDocument
	*/
	@Override
	public java.lang.String getPublishTo() {
		return _immigrationDocument.getPublishTo();
	}

	/**
	* Sets the publish to of this ImmigrationDocument.
	*
	* @param publishTo the publish to of this ImmigrationDocument
	*/
	@Override
	public void setPublishTo(java.lang.String publishTo) {
		_immigrationDocument.setPublishTo(publishTo);
	}

	/**
	* Returns the publish date of this ImmigrationDocument.
	*
	* @return the publish date of this ImmigrationDocument
	*/
	@Override
	public java.util.Date getPublishDate() {
		return _immigrationDocument.getPublishDate();
	}

	/**
	* Sets the publish date of this ImmigrationDocument.
	*
	* @param publishDate the publish date of this ImmigrationDocument
	*/
	@Override
	public void setPublishDate(java.util.Date publishDate) {
		_immigrationDocument.setPublishDate(publishDate);
	}

	@Override
	public boolean isNew() {
		return _immigrationDocument.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_immigrationDocument.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _immigrationDocument.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_immigrationDocument.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _immigrationDocument.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _immigrationDocument.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_immigrationDocument.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _immigrationDocument.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_immigrationDocument.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_immigrationDocument.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_immigrationDocument.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ImmigrationDocumentWrapper((ImmigrationDocument)_immigrationDocument.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.ImmigrationDocument immigrationDocument) {
		return _immigrationDocument.compareTo(immigrationDocument);
	}

	@Override
	public int hashCode() {
		return _immigrationDocument.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.ImmigrationDocument> toCacheModel() {
		return _immigrationDocument.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.ImmigrationDocument toEscapedModel() {
		return new ImmigrationDocumentWrapper(_immigrationDocument.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.ImmigrationDocument toUnescapedModel() {
		return new ImmigrationDocumentWrapper(_immigrationDocument.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _immigrationDocument.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _immigrationDocument.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_immigrationDocument.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImmigrationDocumentWrapper)) {
			return false;
		}

		ImmigrationDocumentWrapper immigrationDocumentWrapper = (ImmigrationDocumentWrapper)obj;

		if (Validator.equals(_immigrationDocument,
					immigrationDocumentWrapper._immigrationDocument)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ImmigrationDocument getWrappedImmigrationDocument() {
		return _immigrationDocument;
	}

	@Override
	public ImmigrationDocument getWrappedModel() {
		return _immigrationDocument;
	}

	@Override
	public void resetOriginalValues() {
		_immigrationDocument.resetOriginalValues();
	}

	private ImmigrationDocument _immigrationDocument;
}