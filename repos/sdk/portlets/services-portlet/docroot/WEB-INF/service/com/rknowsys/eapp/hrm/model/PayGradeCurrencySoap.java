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
public class PayGradeCurrencySoap implements Serializable {
	public static PayGradeCurrencySoap toSoapModel(PayGradeCurrency model) {
		PayGradeCurrencySoap soapModel = new PayGradeCurrencySoap();

		soapModel.setPayGradeCurrencyId(model.getPayGradeCurrencyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setPayGradeId(model.getPayGradeId());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setMinSalary(model.getMinSalary());
		soapModel.setMaxSalary(model.getMaxSalary());

		return soapModel;
	}

	public static PayGradeCurrencySoap[] toSoapModels(PayGradeCurrency[] models) {
		PayGradeCurrencySoap[] soapModels = new PayGradeCurrencySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PayGradeCurrencySoap[][] toSoapModels(
		PayGradeCurrency[][] models) {
		PayGradeCurrencySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PayGradeCurrencySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PayGradeCurrencySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PayGradeCurrencySoap[] toSoapModels(
		List<PayGradeCurrency> models) {
		List<PayGradeCurrencySoap> soapModels = new ArrayList<PayGradeCurrencySoap>(models.size());

		for (PayGradeCurrency model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PayGradeCurrencySoap[soapModels.size()]);
	}

	public PayGradeCurrencySoap() {
	}

	public long getPrimaryKey() {
		return _payGradeCurrencyId;
	}

	public void setPrimaryKey(long pk) {
		setPayGradeCurrencyId(pk);
	}

	public long getPayGradeCurrencyId() {
		return _payGradeCurrencyId;
	}

	public void setPayGradeCurrencyId(long payGradeCurrencyId) {
		_payGradeCurrencyId = payGradeCurrencyId;
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

	public long getPayGradeId() {
		return _payGradeId;
	}

	public void setPayGradeId(long payGradeId) {
		_payGradeId = payGradeId;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public long getMinSalary() {
		return _minSalary;
	}

	public void setMinSalary(long minSalary) {
		_minSalary = minSalary;
	}

	public long getMaxSalary() {
		return _maxSalary;
	}

	public void setMaxSalary(long maxSalary) {
		_maxSalary = maxSalary;
	}

	private long _payGradeCurrencyId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _payGradeId;
	private String _currency;
	private long _minSalary;
	private long _maxSalary;
}