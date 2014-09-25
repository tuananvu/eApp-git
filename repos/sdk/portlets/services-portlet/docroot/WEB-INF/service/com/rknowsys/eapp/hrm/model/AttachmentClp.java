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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rknowsys.eapp.hrm.service.AttachmentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class AttachmentClp extends BaseModelImpl<Attachment>
	implements Attachment {
	public AttachmentClp() {
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
	public long getPrimaryKey() {
		return _attachmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAttachmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _attachmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getAttachmentId() {
		return _attachmentId;
	}

	@Override
	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentId", long.class);

				method.invoke(_attachmentRemoteModel, attachmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_attachmentRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_attachmentRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_attachmentRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_attachmentRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_attachmentRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_attachmentRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_attachmentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComment() {
		return _comment;
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_attachmentRemoteModel, comment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Blob getFile() {
		return _file;
	}

	@Override
	public void setFile(Blob file) {
		_file = file;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setFile", Blob.class);

				method.invoke(_attachmentRemoteModel, file);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAttachmentType() {
		return _attachmentType;
	}

	@Override
	public void setAttachmentType(int attachmentType) {
		_attachmentType = attachmentType;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentType", int.class);

				method.invoke(_attachmentRemoteModel, attachmentType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSize() {
		return _size;
	}

	@Override
	public void setSize(long size) {
		_size = size;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setSize", long.class);

				method.invoke(_attachmentRemoteModel, size);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileType() {
		return _fileType;
	}

	@Override
	public void setFileType(String fileType) {
		_fileType = fileType;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setFileType", String.class);

				method.invoke(_attachmentRemoteModel, fileType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_attachmentRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_attachmentRemoteModel, fileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAttachmentRemoteModel() {
		return _attachmentRemoteModel;
	}

	public void setAttachmentRemoteModel(BaseModel<?> attachmentRemoteModel) {
		_attachmentRemoteModel = attachmentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _attachmentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_attachmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AttachmentLocalServiceUtil.addAttachment(this);
		}
		else {
			AttachmentLocalServiceUtil.updateAttachment(this);
		}
	}

	@Override
	public Attachment toEscapedModel() {
		return (Attachment)ProxyUtil.newProxyInstance(Attachment.class.getClassLoader(),
			new Class[] { Attachment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AttachmentClp clone = new AttachmentClp();

		clone.setAttachmentId(getAttachmentId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setComment(getComment());
		clone.setFile(getFile());
		clone.setAttachmentType(getAttachmentType());
		clone.setSize(getSize());
		clone.setFileType(getFileType());
		clone.setFileName(getFileName());

		return clone;
	}

	@Override
	public int compareTo(Attachment attachment) {
		long primaryKey = attachment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentClp)) {
			return false;
		}

		AttachmentClp attachment = (AttachmentClp)obj;

		long primaryKey = attachment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{attachmentId=");
		sb.append(getAttachmentId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", file=");
		sb.append(getFile());
		sb.append(", attachmentType=");
		sb.append(getAttachmentType());
		sb.append(", size=");
		sb.append(getSize());
		sb.append(", fileType=");
		sb.append(getFileType());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.Attachment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attachmentId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>file</column-name><column-value><![CDATA[");
		sb.append(getFile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentType</column-name><column-value><![CDATA[");
		sb.append(getAttachmentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileType</column-name><column-value><![CDATA[");
		sb.append(getFileType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _attachmentId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _comment;
	private Blob _file;
	private int _attachmentType;
	private long _size;
	private String _fileType;
	private String _fileName;
	private BaseModel<?> _attachmentRemoteModel;
}