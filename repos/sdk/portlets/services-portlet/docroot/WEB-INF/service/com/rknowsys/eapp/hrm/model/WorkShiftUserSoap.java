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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class WorkShiftUserSoap implements Serializable {
	public static WorkShiftUserSoap toSoapModel(WorkShiftUser model) {
		WorkShiftUserSoap soapModel = new WorkShiftUserSoap();

		soapModel.setWorkShiftUserId(model.getWorkShiftUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setShiftId(model.getShiftId());

		return soapModel;
	}

	public static WorkShiftUserSoap[] toSoapModels(WorkShiftUser[] models) {
		WorkShiftUserSoap[] soapModels = new WorkShiftUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkShiftUserSoap[][] toSoapModels(WorkShiftUser[][] models) {
		WorkShiftUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkShiftUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkShiftUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkShiftUserSoap[] toSoapModels(List<WorkShiftUser> models) {
		List<WorkShiftUserSoap> soapModels = new ArrayList<WorkShiftUserSoap>(models.size());

		for (WorkShiftUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkShiftUserSoap[soapModels.size()]);
	}

	public WorkShiftUserSoap() {
	}

	public long getPrimaryKey() {
		return _workShiftUserId;
	}

	public void setPrimaryKey(long pk) {
		setWorkShiftUserId(pk);
	}

	public long getWorkShiftUserId() {
		return _workShiftUserId;
	}

	public void setWorkShiftUserId(long workShiftUserId) {
		_workShiftUserId = workShiftUserId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public long getShiftId() {
		return _shiftId;
	}

	public void setShiftId(long shiftId) {
		_shiftId = shiftId;
	}

	private long _workShiftUserId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _empId;
	private long _shiftId;
}