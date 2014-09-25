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

import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.ImmigrationDocumentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class ImmigrationDocumentClp extends BaseModelImpl<ImmigrationDocument>
	implements ImmigrationDocument {
	public ImmigrationDocumentClp() {
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
	public long getPrimaryKey() {
		return _immigrationDocumentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setImmigrationDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _immigrationDocumentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getImmigrationDocumentId() {
		return _immigrationDocumentId;
	}

	@Override
	public void setImmigrationDocumentId(long immigrationDocumentId) {
		_immigrationDocumentId = immigrationDocumentId;

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setImmigrationDocumentId",
						long.class);

				method.invoke(_immigrationDocumentRemoteModel,
					immigrationDocumentId);
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

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_immigrationDocumentRemoteModel, employeeId);
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

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_immigrationDocumentRemoteModel, companyId);
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

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_immigrationDocumentRemoteModel, groupId);
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

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_immigrationDocumentRemoteModel, createDate);
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

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_immigrationDocumentRemoteModel, modifiedDate);
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

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_immigrationDocumentRemoteModel, userId);
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
	public String getDocTopic() {
		return _docTopic;
	}

	@Override
	public void setDocTopic(String docTopic) {
		_docTopic = docTopic;

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocTopic", String.class);

				method.invoke(_immigrationDocumentRemoteModel, docTopic);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDocCategory() {
		return _docCategory;
	}

	@Override
	public void setDocCategory(String docCategory) {
		_docCategory = docCategory;

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocCategory", String.class);

				method.invoke(_immigrationDocumentRemoteModel, docCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_immigrationDocumentRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishTo() {
		return _publishTo;
	}

	@Override
	public void setPublishTo(String publishTo) {
		_publishTo = publishTo;

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishTo", String.class);

				method.invoke(_immigrationDocumentRemoteModel, publishTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPublishDate() {
		return _publishDate;
	}

	@Override
	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;

		if (_immigrationDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _immigrationDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDate", Date.class);

				method.invoke(_immigrationDocumentRemoteModel, publishDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getImmigrationDocumentRemoteModel() {
		return _immigrationDocumentRemoteModel;
	}

	public void setImmigrationDocumentRemoteModel(
		BaseModel<?> immigrationDocumentRemoteModel) {
		_immigrationDocumentRemoteModel = immigrationDocumentRemoteModel;
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

		Class<?> remoteModelClass = _immigrationDocumentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_immigrationDocumentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ImmigrationDocumentLocalServiceUtil.addImmigrationDocument(this);
		}
		else {
			ImmigrationDocumentLocalServiceUtil.updateImmigrationDocument(this);
		}
	}

	@Override
	public ImmigrationDocument toEscapedModel() {
		return (ImmigrationDocument)ProxyUtil.newProxyInstance(ImmigrationDocument.class.getClassLoader(),
			new Class[] { ImmigrationDocument.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ImmigrationDocumentClp clone = new ImmigrationDocumentClp();

		clone.setImmigrationDocumentId(getImmigrationDocumentId());
		clone.setEmployeeId(getEmployeeId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setDocTopic(getDocTopic());
		clone.setDocCategory(getDocCategory());
		clone.setDescription(getDescription());
		clone.setPublishTo(getPublishTo());
		clone.setPublishDate(getPublishDate());

		return clone;
	}

	@Override
	public int compareTo(ImmigrationDocument immigrationDocument) {
		long primaryKey = immigrationDocument.getPrimaryKey();

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

		if (!(obj instanceof ImmigrationDocumentClp)) {
			return false;
		}

		ImmigrationDocumentClp immigrationDocument = (ImmigrationDocumentClp)obj;

		long primaryKey = immigrationDocument.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{immigrationDocumentId=");
		sb.append(getImmigrationDocumentId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", docTopic=");
		sb.append(getDocTopic());
		sb.append(", docCategory=");
		sb.append(getDocCategory());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", publishTo=");
		sb.append(getPublishTo());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.ImmigrationDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>immigrationDocumentId</column-name><column-value><![CDATA[");
		sb.append(getImmigrationDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docTopic</column-name><column-value><![CDATA[");
		sb.append(getDocTopic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docCategory</column-name><column-value><![CDATA[");
		sb.append(getDocCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishTo</column-name><column-value><![CDATA[");
		sb.append(getPublishTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _immigrationDocumentId;
	private long _employeeId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _docTopic;
	private String _docCategory;
	private String _description;
	private String _publishTo;
	private Date _publishDate;
	private BaseModel<?> _immigrationDocumentRemoteModel;
}