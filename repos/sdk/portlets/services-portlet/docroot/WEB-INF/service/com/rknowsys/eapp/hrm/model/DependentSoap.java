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
public class DependentSoap implements Serializable {
	public static DependentSoap toSoapModel(Dependent model) {
		DependentSoap soapModel = new DependentSoap();

		soapModel.setDependentId(model.getDependentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static DependentSoap[] toSoapModels(Dependent[] models) {
		DependentSoap[] soapModels = new DependentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DependentSoap[][] toSoapModels(Dependent[][] models) {
		DependentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DependentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DependentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DependentSoap[] toSoapModels(List<Dependent> models) {
		List<DependentSoap> soapModels = new ArrayList<DependentSoap>(models.size());

		for (Dependent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DependentSoap[soapModels.size()]);
	}

	public DependentSoap() {
	}

	public long getPrimaryKey() {
		return _dependentId;
	}

	public void setPrimaryKey(long pk) {
		setDependentId(pk);
	}

	public long getDependentId() {
		return _dependentId;
	}

	public void setDependentId(long dependentId) {
		_dependentId = dependentId;
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

	private long _dependentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}