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
import com.rknowsys.eapp.hrm.service.JobLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class JobClp extends BaseModelImpl<Job> implements Job {
	public JobClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Job.class;
	}

	@Override
	public String getModelClassName() {
		return Job.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _jobId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJobId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobId", getJobId());
		attributes.put("jobTitleId", getJobTitleId());
		attributes.put("jobCategoryId", getJobCategoryId());
		attributes.put("subUnitId", getSubUnitId());
		attributes.put("locationId", getLocationId());
		attributes.put("employmentStatusId", getEmploymentStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("joinedDate", getJoinedDate());
		attributes.put("employmentContractStartDate",
			getEmploymentContractStartDate());
		attributes.put("employmentContractEndDate",
			getEmploymentContractEndDate());
		attributes.put("contractDetails", getContractDetails());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		Long jobTitleId = (Long)attributes.get("jobTitleId");

		if (jobTitleId != null) {
			setJobTitleId(jobTitleId);
		}

		Long jobCategoryId = (Long)attributes.get("jobCategoryId");

		if (jobCategoryId != null) {
			setJobCategoryId(jobCategoryId);
		}

		Long subUnitId = (Long)attributes.get("subUnitId");

		if (subUnitId != null) {
			setSubUnitId(subUnitId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Long employmentStatusId = (Long)attributes.get("employmentStatusId");

		if (employmentStatusId != null) {
			setEmploymentStatusId(employmentStatusId);
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

		Date joinedDate = (Date)attributes.get("joinedDate");

		if (joinedDate != null) {
			setJoinedDate(joinedDate);
		}

		Date employmentContractStartDate = (Date)attributes.get(
				"employmentContractStartDate");

		if (employmentContractStartDate != null) {
			setEmploymentContractStartDate(employmentContractStartDate);
		}

		Date employmentContractEndDate = (Date)attributes.get(
				"employmentContractEndDate");

		if (employmentContractEndDate != null) {
			setEmploymentContractEndDate(employmentContractEndDate);
		}

		Blob contractDetails = (Blob)attributes.get("contractDetails");

		if (contractDetails != null) {
			setContractDetails(contractDetails);
		}
	}

	@Override
	public long getJobId() {
		return _jobId;
	}

	@Override
	public void setJobId(long jobId) {
		_jobId = jobId;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobId", long.class);

				method.invoke(_jobRemoteModel, jobId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobTitleId() {
		return _jobTitleId;
	}

	@Override
	public void setJobTitleId(long jobTitleId) {
		_jobTitleId = jobTitleId;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitleId", long.class);

				method.invoke(_jobRemoteModel, jobTitleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobCategoryId() {
		return _jobCategoryId;
	}

	@Override
	public void setJobCategoryId(long jobCategoryId) {
		_jobCategoryId = jobCategoryId;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobCategoryId", long.class);

				method.invoke(_jobRemoteModel, jobCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubUnitId() {
		return _subUnitId;
	}

	@Override
	public void setSubUnitId(long subUnitId) {
		_subUnitId = subUnitId;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setSubUnitId", long.class);

				method.invoke(_jobRemoteModel, subUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLocationId() {
		return _locationId;
	}

	@Override
	public void setLocationId(long locationId) {
		_locationId = locationId;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", long.class);

				method.invoke(_jobRemoteModel, locationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmploymentStatusId() {
		return _employmentStatusId;
	}

	@Override
	public void setEmploymentStatusId(long employmentStatusId) {
		_employmentStatusId = employmentStatusId;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentStatusId",
						long.class);

				method.invoke(_jobRemoteModel, employmentStatusId);
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

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_jobRemoteModel, groupId);
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

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_jobRemoteModel, companyId);
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

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_jobRemoteModel, userId);
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

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_jobRemoteModel, createDate);
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

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_jobRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJoinedDate() {
		return _joinedDate;
	}

	@Override
	public void setJoinedDate(Date joinedDate) {
		_joinedDate = joinedDate;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setJoinedDate", Date.class);

				method.invoke(_jobRemoteModel, joinedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEmploymentContractStartDate() {
		return _employmentContractStartDate;
	}

	@Override
	public void setEmploymentContractStartDate(Date employmentContractStartDate) {
		_employmentContractStartDate = employmentContractStartDate;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentContractStartDate",
						Date.class);

				method.invoke(_jobRemoteModel, employmentContractStartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEmploymentContractEndDate() {
		return _employmentContractEndDate;
	}

	@Override
	public void setEmploymentContractEndDate(Date employmentContractEndDate) {
		_employmentContractEndDate = employmentContractEndDate;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setEmploymentContractEndDate",
						Date.class);

				method.invoke(_jobRemoteModel, employmentContractEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Blob getContractDetails() {
		return _contractDetails;
	}

	@Override
	public void setContractDetails(Blob contractDetails) {
		_contractDetails = contractDetails;

		if (_jobRemoteModel != null) {
			try {
				Class<?> clazz = _jobRemoteModel.getClass();

				Method method = clazz.getMethod("setContractDetails", Blob.class);

				method.invoke(_jobRemoteModel, contractDetails);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJobRemoteModel() {
		return _jobRemoteModel;
	}

	public void setJobRemoteModel(BaseModel<?> jobRemoteModel) {
		_jobRemoteModel = jobRemoteModel;
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

		Class<?> remoteModelClass = _jobRemoteModel.getClass();

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

		Object returnValue = method.invoke(_jobRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JobLocalServiceUtil.addJob(this);
		}
		else {
			JobLocalServiceUtil.updateJob(this);
		}
	}

	@Override
	public Job toEscapedModel() {
		return (Job)ProxyUtil.newProxyInstance(Job.class.getClassLoader(),
			new Class[] { Job.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JobClp clone = new JobClp();

		clone.setJobId(getJobId());
		clone.setJobTitleId(getJobTitleId());
		clone.setJobCategoryId(getJobCategoryId());
		clone.setSubUnitId(getSubUnitId());
		clone.setLocationId(getLocationId());
		clone.setEmploymentStatusId(getEmploymentStatusId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setJoinedDate(getJoinedDate());
		clone.setEmploymentContractStartDate(getEmploymentContractStartDate());
		clone.setEmploymentContractEndDate(getEmploymentContractEndDate());
		clone.setContractDetails(getContractDetails());

		return clone;
	}

	@Override
	public int compareTo(Job job) {
		long primaryKey = job.getPrimaryKey();

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

		if (!(obj instanceof JobClp)) {
			return false;
		}

		JobClp job = (JobClp)obj;

		long primaryKey = job.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{jobId=");
		sb.append(getJobId());
		sb.append(", jobTitleId=");
		sb.append(getJobTitleId());
		sb.append(", jobCategoryId=");
		sb.append(getJobCategoryId());
		sb.append(", subUnitId=");
		sb.append(getSubUnitId());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", employmentStatusId=");
		sb.append(getEmploymentStatusId());
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
		sb.append(", joinedDate=");
		sb.append(getJoinedDate());
		sb.append(", employmentContractStartDate=");
		sb.append(getEmploymentContractStartDate());
		sb.append(", employmentContractEndDate=");
		sb.append(getEmploymentContractEndDate());
		sb.append(", contractDetails=");
		sb.append(getContractDetails());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.Job");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jobId</column-name><column-value><![CDATA[");
		sb.append(getJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitleId</column-name><column-value><![CDATA[");
		sb.append(getJobTitleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobCategoryId</column-name><column-value><![CDATA[");
		sb.append(getJobCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subUnitId</column-name><column-value><![CDATA[");
		sb.append(getSubUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentStatusId</column-name><column-value><![CDATA[");
		sb.append(getEmploymentStatusId());
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
			"<column><column-name>joinedDate</column-name><column-value><![CDATA[");
		sb.append(getJoinedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentContractStartDate</column-name><column-value><![CDATA[");
		sb.append(getEmploymentContractStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentContractEndDate</column-name><column-value><![CDATA[");
		sb.append(getEmploymentContractEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractDetails</column-name><column-value><![CDATA[");
		sb.append(getContractDetails());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jobId;
	private long _jobTitleId;
	private long _jobCategoryId;
	private long _subUnitId;
	private long _locationId;
	private long _employmentStatusId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _joinedDate;
	private Date _employmentContractStartDate;
	private Date _employmentContractEndDate;
	private Blob _contractDetails;
	private BaseModel<?> _jobRemoteModel;
}