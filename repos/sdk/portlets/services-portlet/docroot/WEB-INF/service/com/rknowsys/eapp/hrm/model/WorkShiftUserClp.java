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
import com.rknowsys.eapp.hrm.service.WorkShiftUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class WorkShiftUserClp extends BaseModelImpl<WorkShiftUser>
	implements WorkShiftUser {
	public WorkShiftUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WorkShiftUser.class;
	}

	@Override
	public String getModelClassName() {
		return WorkShiftUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _workShiftUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkShiftUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workShiftUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workShiftUserId", getWorkShiftUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("empId", getEmpId());
		attributes.put("shiftId", getShiftId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workShiftUserId = (Long)attributes.get("workShiftUserId");

		if (workShiftUserId != null) {
			setWorkShiftUserId(workShiftUserId);
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

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Long shiftId = (Long)attributes.get("shiftId");

		if (shiftId != null) {
			setShiftId(shiftId);
		}
	}

	@Override
	public long getWorkShiftUserId() {
		return _workShiftUserId;
	}

	@Override
	public void setWorkShiftUserId(long workShiftUserId) {
		_workShiftUserId = workShiftUserId;

		if (_workShiftUserRemoteModel != null) {
			try {
				Class<?> clazz = _workShiftUserRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkShiftUserId", long.class);

				method.invoke(_workShiftUserRemoteModel, workShiftUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkShiftUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getWorkShiftUserId(), "uuid",
			_workShiftUserUuid);
	}

	@Override
	public void setWorkShiftUserUuid(String workShiftUserUuid) {
		_workShiftUserUuid = workShiftUserUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_workShiftUserRemoteModel != null) {
			try {
				Class<?> clazz = _workShiftUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_workShiftUserRemoteModel, companyId);
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

		if (_workShiftUserRemoteModel != null) {
			try {
				Class<?> clazz = _workShiftUserRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_workShiftUserRemoteModel, groupId);
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

		if (_workShiftUserRemoteModel != null) {
			try {
				Class<?> clazz = _workShiftUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_workShiftUserRemoteModel, createDate);
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

		if (_workShiftUserRemoteModel != null) {
			try {
				Class<?> clazz = _workShiftUserRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_workShiftUserRemoteModel, modifiedDate);
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

		if (_workShiftUserRemoteModel != null) {
			try {
				Class<?> clazz = _workShiftUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_workShiftUserRemoteModel, userId);
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
	public long getEmpId() {
		return _empId;
	}

	@Override
	public void setEmpId(long empId) {
		_empId = empId;

		if (_workShiftUserRemoteModel != null) {
			try {
				Class<?> clazz = _workShiftUserRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_workShiftUserRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getShiftId() {
		return _shiftId;
	}

	@Override
	public void setShiftId(long shiftId) {
		_shiftId = shiftId;

		if (_workShiftUserRemoteModel != null) {
			try {
				Class<?> clazz = _workShiftUserRemoteModel.getClass();

				Method method = clazz.getMethod("setShiftId", long.class);

				method.invoke(_workShiftUserRemoteModel, shiftId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkShiftUserRemoteModel() {
		return _workShiftUserRemoteModel;
	}

	public void setWorkShiftUserRemoteModel(
		BaseModel<?> workShiftUserRemoteModel) {
		_workShiftUserRemoteModel = workShiftUserRemoteModel;
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

		Class<?> remoteModelClass = _workShiftUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workShiftUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkShiftUserLocalServiceUtil.addWorkShiftUser(this);
		}
		else {
			WorkShiftUserLocalServiceUtil.updateWorkShiftUser(this);
		}
	}

	@Override
	public WorkShiftUser toEscapedModel() {
		return (WorkShiftUser)ProxyUtil.newProxyInstance(WorkShiftUser.class.getClassLoader(),
			new Class[] { WorkShiftUser.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkShiftUserClp clone = new WorkShiftUserClp();

		clone.setWorkShiftUserId(getWorkShiftUserId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setEmpId(getEmpId());
		clone.setShiftId(getShiftId());

		return clone;
	}

	@Override
	public int compareTo(WorkShiftUser workShiftUser) {
		long primaryKey = workShiftUser.getPrimaryKey();

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

		if (!(obj instanceof WorkShiftUserClp)) {
			return false;
		}

		WorkShiftUserClp workShiftUser = (WorkShiftUserClp)obj;

		long primaryKey = workShiftUser.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{workShiftUserId=");
		sb.append(getWorkShiftUserId());
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
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", shiftId=");
		sb.append(getShiftId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.WorkShiftUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workShiftUserId</column-name><column-value><![CDATA[");
		sb.append(getWorkShiftUserId());
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
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shiftId</column-name><column-value><![CDATA[");
		sb.append(getShiftId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _workShiftUserId;
	private String _workShiftUserUuid;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _empId;
	private long _shiftId;
	private BaseModel<?> _workShiftUserRemoteModel;
}