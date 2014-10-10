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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class JobSoap implements Serializable {
	public static JobSoap toSoapModel(Job model) {
		JobSoap soapModel = new JobSoap();

		soapModel.setJobId(model.getJobId());
		soapModel.setJobTitleId(model.getJobTitleId());
		soapModel.setJobCategoryId(model.getJobCategoryId());
		soapModel.setSubUnitId(model.getSubUnitId());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setEmploymentStatusId(model.getEmploymentStatusId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setJoinedDate(model.getJoinedDate());
		soapModel.setEmploymentContractStartDate(model.getEmploymentContractStartDate());
		soapModel.setEmploymentContractEndDate(model.getEmploymentContractEndDate());
		soapModel.setContractDetails(model.getContractDetails());
		soapModel.setEmployeeId(model.getEmployeeId());

		return soapModel;
	}

	public static JobSoap[] toSoapModels(Job[] models) {
		JobSoap[] soapModels = new JobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobSoap[][] toSoapModels(Job[][] models) {
		JobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobSoap[] toSoapModels(List<Job> models) {
		List<JobSoap> soapModels = new ArrayList<JobSoap>(models.size());

		for (Job model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobSoap[soapModels.size()]);
	}

	public JobSoap() {
	}

	public long getPrimaryKey() {
		return _jobId;
	}

	public void setPrimaryKey(long pk) {
		setJobId(pk);
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	public long getJobTitleId() {
		return _jobTitleId;
	}

	public void setJobTitleId(long jobTitleId) {
		_jobTitleId = jobTitleId;
	}

	public long getJobCategoryId() {
		return _jobCategoryId;
	}

	public void setJobCategoryId(long jobCategoryId) {
		_jobCategoryId = jobCategoryId;
	}

	public long getSubUnitId() {
		return _subUnitId;
	}

	public void setSubUnitId(long subUnitId) {
		_subUnitId = subUnitId;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
	}

	public long getEmploymentStatusId() {
		return _employmentStatusId;
	}

	public void setEmploymentStatusId(long employmentStatusId) {
		_employmentStatusId = employmentStatusId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getJoinedDate() {
		return _joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		_joinedDate = joinedDate;
	}

	public Date getEmploymentContractStartDate() {
		return _employmentContractStartDate;
	}

	public void setEmploymentContractStartDate(Date employmentContractStartDate) {
		_employmentContractStartDate = employmentContractStartDate;
	}

	public Date getEmploymentContractEndDate() {
		return _employmentContractEndDate;
	}

	public void setEmploymentContractEndDate(Date employmentContractEndDate) {
		_employmentContractEndDate = employmentContractEndDate;
	}

	public Blob getContractDetails() {
		return _contractDetails;
	}

	public void setContractDetails(Blob contractDetails) {
		_contractDetails = contractDetails;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
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
	private Date _createDate;
	private Date _modifiedDate;
	private Date _joinedDate;
	private Date _employmentContractStartDate;
	private Date _employmentContractEndDate;
	private Blob _contractDetails;
	private long _employeeId;
}