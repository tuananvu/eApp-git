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
public class WorkshiftSoap implements Serializable {
	public static WorkshiftSoap toSoapModel(Workshift model) {
		WorkshiftSoap soapModel = new WorkshiftSoap();

		soapModel.setShiftId(model.getShiftId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setWorkshiftName(model.getWorkshiftName());
		soapModel.setFromWorkHours(model.getFromWorkHours());
		soapModel.setToWorkHours(model.getToWorkHours());

		return soapModel;
	}

	public static WorkshiftSoap[] toSoapModels(Workshift[] models) {
		WorkshiftSoap[] soapModels = new WorkshiftSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkshiftSoap[][] toSoapModels(Workshift[][] models) {
		WorkshiftSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkshiftSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkshiftSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkshiftSoap[] toSoapModels(List<Workshift> models) {
		List<WorkshiftSoap> soapModels = new ArrayList<WorkshiftSoap>(models.size());

		for (Workshift model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkshiftSoap[soapModels.size()]);
	}

	public WorkshiftSoap() {
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

	public String getWorkshiftName() {
		return _workshiftName;
	}

	public void setWorkshiftName(String workshiftName) {
		_workshiftName = workshiftName;
	}

	public Date getFromWorkHours() {
		return _fromWorkHours;
	}

	public void setFromWorkHours(Date fromWorkHours) {
		_fromWorkHours = fromWorkHours;
	}

	public Date getToWorkHours() {
		return _toWorkHours;
	}

	public void setToWorkHours(Date toWorkHours) {
		_toWorkHours = toWorkHours;
	}

	private long _shiftId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _workshiftName;
	private Date _fromWorkHours;
	private Date _toWorkHours;
}