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
public class WorkShiftSoap implements Serializable {
	public static WorkShiftSoap toSoapModel(WorkShift model) {
		WorkShiftSoap soapModel = new WorkShiftSoap();

		soapModel.setShiftId(model.getShiftId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setShiftName(model.getShiftName());
		soapModel.setFromWorkHrs(model.getFromWorkHrs());
		soapModel.setToWorkHrs(model.getToWorkHrs());

		return soapModel;
	}

	public static WorkShiftSoap[] toSoapModels(WorkShift[] models) {
		WorkShiftSoap[] soapModels = new WorkShiftSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkShiftSoap[][] toSoapModels(WorkShift[][] models) {
		WorkShiftSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkShiftSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkShiftSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkShiftSoap[] toSoapModels(List<WorkShift> models) {
		List<WorkShiftSoap> soapModels = new ArrayList<WorkShiftSoap>(models.size());

		for (WorkShift model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkShiftSoap[soapModels.size()]);
	}

	public WorkShiftSoap() {
	}

	public long getPrimaryKey() {
		return _shiftId;
	}

	public void setPrimaryKey(long pk) {
		setShiftId(pk);
	}

	public long getShiftId() {
		return _shiftId;
	}

	public void setShiftId(long shiftId) {
		_shiftId = shiftId;
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

	public String getShiftName() {
		return _shiftName;
	}

	public void setShiftName(String shiftName) {
		_shiftName = shiftName;
	}

	public long getFromWorkHrs() {
		return _fromWorkHrs;
	}

	public void setFromWorkHrs(long fromWorkHrs) {
		_fromWorkHrs = fromWorkHrs;
	}

	public long getToWorkHrs() {
		return _toWorkHrs;
	}

	public void setToWorkHrs(long toWorkHrs) {
		_toWorkHrs = toWorkHrs;
	}

	private long _shiftId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _shiftName;
	private long _fromWorkHrs;
	private long _toWorkHrs;
}