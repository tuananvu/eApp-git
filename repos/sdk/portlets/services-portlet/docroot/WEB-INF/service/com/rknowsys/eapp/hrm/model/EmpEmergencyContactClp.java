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
import com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class EmpEmergencyContactClp extends BaseModelImpl<EmpEmergencyContact>
	implements EmpEmergencyContact {
	public EmpEmergencyContactClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpEmergencyContact.class;
	}

	@Override
	public String getModelClassName() {
		return EmpEmergencyContact.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empEmergencyContactId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpEmergencyContactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empEmergencyContactId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empEmergencyContactId", getEmpEmergencyContactId());
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
		Long empEmergencyContactId = (Long)attributes.get(
				"empEmergencyContactId");

		if (empEmergencyContactId != null) {
			setEmpEmergencyContactId(empEmergencyContactId);
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

	@Override
	public long getEmpEmergencyContactId() {
		return _empEmergencyContactId;
	}

	@Override
	public void setEmpEmergencyContactId(long empEmergencyContactId) {
		_empEmergencyContactId = empEmergencyContactId;

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpEmergencyContactId",
						long.class);

				method.invoke(_empEmergencyContactRemoteModel,
					empEmergencyContactId);
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

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_empEmergencyContactRemoteModel, employeeId);
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

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empEmergencyContactRemoteModel, groupId);
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

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empEmergencyContactRemoteModel, companyId);
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

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empEmergencyContactRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empEmergencyContactRemoteModel, createDate);
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

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empEmergencyContactRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_empEmergencyContactRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRelationship() {
		return _relationship;
	}

	@Override
	public void setRelationship(String relationship) {
		_relationship = relationship;

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setRelationship", String.class);

				method.invoke(_empEmergencyContactRemoteModel, relationship);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHomeTelephone() {
		return _homeTelephone;
	}

	@Override
	public void setHomeTelephone(String homeTelephone) {
		_homeTelephone = homeTelephone;

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setHomeTelephone", String.class);

				method.invoke(_empEmergencyContactRemoteModel, homeTelephone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobile() {
		return _mobile;
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setMobile", String.class);

				method.invoke(_empEmergencyContactRemoteModel, mobile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkTelephone() {
		return _workTelephone;
	}

	@Override
	public void setWorkTelephone(String workTelephone) {
		_workTelephone = workTelephone;

		if (_empEmergencyContactRemoteModel != null) {
			try {
				Class<?> clazz = _empEmergencyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkTelephone", String.class);

				method.invoke(_empEmergencyContactRemoteModel, workTelephone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpEmergencyContactRemoteModel() {
		return _empEmergencyContactRemoteModel;
	}

	public void setEmpEmergencyContactRemoteModel(
		BaseModel<?> empEmergencyContactRemoteModel) {
		_empEmergencyContactRemoteModel = empEmergencyContactRemoteModel;
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

		Class<?> remoteModelClass = _empEmergencyContactRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empEmergencyContactRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpEmergencyContactLocalServiceUtil.addEmpEmergencyContact(this);
		}
		else {
			EmpEmergencyContactLocalServiceUtil.updateEmpEmergencyContact(this);
		}
	}

	@Override
	public EmpEmergencyContact toEscapedModel() {
		return (EmpEmergencyContact)ProxyUtil.newProxyInstance(EmpEmergencyContact.class.getClassLoader(),
			new Class[] { EmpEmergencyContact.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpEmergencyContactClp clone = new EmpEmergencyContactClp();

		clone.setEmpEmergencyContactId(getEmpEmergencyContactId());
		clone.setEmployeeId(getEmployeeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setRelationship(getRelationship());
		clone.setHomeTelephone(getHomeTelephone());
		clone.setMobile(getMobile());
		clone.setWorkTelephone(getWorkTelephone());

		return clone;
	}

	@Override
	public int compareTo(EmpEmergencyContact empEmergencyContact) {
		long primaryKey = empEmergencyContact.getPrimaryKey();

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

		if (!(obj instanceof EmpEmergencyContactClp)) {
			return false;
		}

		EmpEmergencyContactClp empEmergencyContact = (EmpEmergencyContactClp)obj;

		long primaryKey = empEmergencyContact.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{empEmergencyContactId=");
		sb.append(getEmpEmergencyContactId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", relationship=");
		sb.append(getRelationship());
		sb.append(", homeTelephone=");
		sb.append(getHomeTelephone());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", workTelephone=");
		sb.append(getWorkTelephone());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpEmergencyContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empEmergencyContactId</column-name><column-value><![CDATA[");
		sb.append(getEmpEmergencyContactId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relationship</column-name><column-value><![CDATA[");
		sb.append(getRelationship());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>homeTelephone</column-name><column-value><![CDATA[");
		sb.append(getHomeTelephone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workTelephone</column-name><column-value><![CDATA[");
		sb.append(getWorkTelephone());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empEmergencyContactId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _relationship;
	private String _homeTelephone;
	private String _mobile;
	private String _workTelephone;
	private BaseModel<?> _empEmergencyContactRemoteModel;
	private Class<?> _clpSerializerClass = com.rknowsys.eapp.hrm.service.ClpSerializer.class;
}