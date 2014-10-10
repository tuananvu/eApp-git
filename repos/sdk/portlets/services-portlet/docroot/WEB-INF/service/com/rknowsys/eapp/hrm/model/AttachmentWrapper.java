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
 * This class is a wrapper for {@link Attachment}.
 * </p>
 *
 * @author rknowsys
 * @see Attachment
 * @generated
 */
public class AttachmentWrapper implements Attachment, ModelWrapper<Attachment> {
	public AttachmentWrapper(Attachment attachment) {
		_attachment = attachment;
	}

	@Override
	public Class<?> getModelClass() {
		return Attachment.class;
	}

	@Override
	public String getModelClassName() {
		return Attachment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("comment", getComment());
		attributes.put("file", getFile());
		attributes.put("attachmentType", getAttachmentType());
		attributes.put("size", getSize());
		attributes.put("fileType", getFileType());
		attributes.put("fileName", getFileName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Blob file = (Blob)attributes.get("file");

		if (file != null) {
			setFile(file);
		}

		Integer attachmentType = (Integer)attributes.get("attachmentType");

		if (attachmentType != null) {
			setAttachmentType(attachmentType);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		String fileType = (String)attributes.get("fileType");

		if (fileType != null) {
			setFileType(fileType);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}
	}

	/**
	* Returns the primary key of this attachment.
	*
	* @return the primary key of this attachment
	*/
	@Override
	public long getPrimaryKey() {
		return _attachment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this attachment.
	*
	* @param primaryKey the primary key of this attachment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_attachment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the attachment ID of this attachment.
	*
	* @return the attachment ID of this attachment
	*/
	@Override
	public long getAttachmentId() {
		return _attachment.getAttachmentId();
	}

	/**
	* Sets the attachment ID of this attachment.
	*
	* @param attachmentId the attachment ID of this attachment
	*/
	@Override
	public void setAttachmentId(long attachmentId) {
		_attachment.setAttachmentId(attachmentId);
	}

	/**
	* Returns the employee ID of this attachment.
	*
	* @return the employee ID of this attachment
	*/
	@Override
	public long getEmployeeId() {
		return _attachment.getEmployeeId();
	}

	/**
	* Sets the employee ID of this attachment.
	*
	* @param employeeId the employee ID of this attachment
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_attachment.setEmployeeId(employeeId);
	}

	/**
	* Returns the group ID of this attachment.
	*
	* @return the group ID of this attachment
	*/
	@Override
	public long getGroupId() {
		return _attachment.getGroupId();
	}

	/**
	* Sets the group ID of this attachment.
	*
	* @param groupId the group ID of this attachment
	*/
	@Override
	public void setGroupId(long groupId) {
		_attachment.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this attachment.
	*
	* @return the company ID of this attachment
	*/
	@Override
	public long getCompanyId() {
		return _attachment.getCompanyId();
	}

	/**
	* Sets the company ID of this attachment.
	*
	* @param companyId the company ID of this attachment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_attachment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this attachment.
	*
	* @return the user ID of this attachment
	*/
	@Override
	public long getUserId() {
		return _attachment.getUserId();
	}

	/**
	* Sets the user ID of this attachment.
	*
	* @param userId the user ID of this attachment
	*/
	@Override
	public void setUserId(long userId) {
		_attachment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this attachment.
	*
	* @return the user uuid of this attachment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachment.getUserUuid();
	}

	/**
	* Sets the user uuid of this attachment.
	*
	* @param userUuid the user uuid of this attachment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_attachment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this attachment.
	*
	* @return the user name of this attachment
	*/
	@Override
	public java.lang.String getUserName() {
		return _attachment.getUserName();
	}

	/**
	* Sets the user name of this attachment.
	*
	* @param userName the user name of this attachment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_attachment.setUserName(userName);
	}

	/**
	* Returns the create date of this attachment.
	*
	* @return the create date of this attachment
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _attachment.getCreateDate();
	}

	/**
	* Sets the create date of this attachment.
	*
	* @param createDate the create date of this attachment
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_attachment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this attachment.
	*
	* @return the modified date of this attachment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _attachment.getModifiedDate();
	}

	/**
	* Sets the modified date of this attachment.
	*
	* @param modifiedDate the modified date of this attachment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_attachment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the comment of this attachment.
	*
	* @return the comment of this attachment
	*/
	@Override
	public java.lang.String getComment() {
		return _attachment.getComment();
	}

	/**
	* Sets the comment of this attachment.
	*
	* @param comment the comment of this attachment
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_attachment.setComment(comment);
	}

	/**
	* Returns the file of this attachment.
	*
	* @return the file of this attachment
	*/
	@Override
	public java.sql.Blob getFile() {
		return _attachment.getFile();
	}

	/**
	* Sets the file of this attachment.
	*
	* @param file the file of this attachment
	*/
	@Override
	public void setFile(java.sql.Blob file) {
		_attachment.setFile(file);
	}

	/**
	* Returns the attachment type of this attachment.
	*
	* @return the attachment type of this attachment
	*/
	@Override
	public int getAttachmentType() {
		return _attachment.getAttachmentType();
	}

	/**
	* Sets the attachment type of this attachment.
	*
	* @param attachmentType the attachment type of this attachment
	*/
	@Override
	public void setAttachmentType(int attachmentType) {
		_attachment.setAttachmentType(attachmentType);
	}

	/**
	* Returns the size of this attachment.
	*
	* @return the size of this attachment
	*/
	@Override
	public long getSize() {
		return _attachment.getSize();
	}

	/**
	* Sets the size of this attachment.
	*
	* @param size the size of this attachment
	*/
	@Override
	public void setSize(long size) {
		_attachment.setSize(size);
	}

	/**
	* Returns the file type of this attachment.
	*
	* @return the file type of this attachment
	*/
	@Override
	public java.lang.String getFileType() {
		return _attachment.getFileType();
	}

	/**
	* Sets the file type of this attachment.
	*
	* @param fileType the file type of this attachment
	*/
	@Override
	public void setFileType(java.lang.String fileType) {
		_attachment.setFileType(fileType);
	}

	/**
	* Returns the file name of this attachment.
	*
	* @return the file name of this attachment
	*/
	@Override
	public java.lang.String getFileName() {
		return _attachment.getFileName();
	}

	/**
	* Sets the file name of this attachment.
	*
	* @param fileName the file name of this attachment
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_attachment.setFileName(fileName);
	}

	@Override
	public boolean isNew() {
		return _attachment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_attachment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _attachment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attachment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _attachment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _attachment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_attachment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _attachment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_attachment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_attachment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_attachment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AttachmentWrapper((Attachment)_attachment.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Attachment attachment) {
		return _attachment.compareTo(attachment);
	}

	@Override
	public int hashCode() {
		return _attachment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Attachment> toCacheModel() {
		return _attachment.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Attachment toEscapedModel() {
		return new AttachmentWrapper(_attachment.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Attachment toUnescapedModel() {
		return new AttachmentWrapper(_attachment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _attachment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _attachment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_attachment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentWrapper)) {
			return false;
		}

		AttachmentWrapper attachmentWrapper = (AttachmentWrapper)obj;

		if (Validator.equals(_attachment, attachmentWrapper._attachment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Attachment getWrappedAttachment() {
		return _attachment;
	}

	@Override
	public Attachment getWrappedModel() {
		return _attachment;
	}

	@Override
	public void resetOriginalValues() {
		_attachment.resetOriginalValues();
	}

	private Attachment _attachment;
}