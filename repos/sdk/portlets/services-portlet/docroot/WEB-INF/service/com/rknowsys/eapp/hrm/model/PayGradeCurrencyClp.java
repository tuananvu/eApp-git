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
import com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class PayGradeCurrencyClp extends BaseModelImpl<PayGradeCurrency>
	implements PayGradeCurrency {
	public PayGradeCurrencyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PayGradeCurrency.class;
	}

	@Override
	public String getModelClassName() {
		return PayGradeCurrency.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _payGradeCurrencyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPayGradeCurrencyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _payGradeCurrencyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("payGradeCurrencyId", getPayGradeCurrencyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("payGradeId", getPayGradeId());
		attributes.put("currency", getCurrency());
		attributes.put("minSalary", getMinSalary());
		attributes.put("maxSalary", getMaxSalary());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long payGradeCurrencyId = (Long)attributes.get("payGradeCurrencyId");

		if (payGradeCurrencyId != null) {
			setPayGradeCurrencyId(payGradeCurrencyId);
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

		Long payGradeId = (Long)attributes.get("payGradeId");

		if (payGradeId != null) {
			setPayGradeId(payGradeId);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Long minSalary = (Long)attributes.get("minSalary");

		if (minSalary != null) {
			setMinSalary(minSalary);
		}

		Long maxSalary = (Long)attributes.get("maxSalary");

		if (maxSalary != null) {
			setMaxSalary(maxSalary);
		}
	}

	@Override
	public long getPayGradeCurrencyId() {
		return _payGradeCurrencyId;
	}

	@Override
	public void setPayGradeCurrencyId(long payGradeCurrencyId) {
		_payGradeCurrencyId = payGradeCurrencyId;

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setPayGradeCurrencyId",
						long.class);

				method.invoke(_payGradeCurrencyRemoteModel, payGradeCurrencyId);
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

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_payGradeCurrencyRemoteModel, companyId);
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

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_payGradeCurrencyRemoteModel, groupId);
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

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_payGradeCurrencyRemoteModel, createDate);
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

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_payGradeCurrencyRemoteModel, modifiedDate);
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

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_payGradeCurrencyRemoteModel, userId);
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
	public long getPayGradeId() {
		return _payGradeId;
	}

	@Override
	public void setPayGradeId(long payGradeId) {
		_payGradeId = payGradeId;

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setPayGradeId", long.class);

				method.invoke(_payGradeCurrencyRemoteModel, payGradeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrency() {
		return _currency;
	}

	@Override
	public void setCurrency(String currency) {
		_currency = currency;

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrency", String.class);

				method.invoke(_payGradeCurrencyRemoteModel, currency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMinSalary() {
		return _minSalary;
	}

	@Override
	public void setMinSalary(long minSalary) {
		_minSalary = minSalary;

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setMinSalary", long.class);

				method.invoke(_payGradeCurrencyRemoteModel, minSalary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMaxSalary() {
		return _maxSalary;
	}

	@Override
	public void setMaxSalary(long maxSalary) {
		_maxSalary = maxSalary;

		if (_payGradeCurrencyRemoteModel != null) {
			try {
				Class<?> clazz = _payGradeCurrencyRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxSalary", long.class);

				method.invoke(_payGradeCurrencyRemoteModel, maxSalary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPayGradeCurrencyRemoteModel() {
		return _payGradeCurrencyRemoteModel;
	}

	public void setPayGradeCurrencyRemoteModel(
		BaseModel<?> payGradeCurrencyRemoteModel) {
		_payGradeCurrencyRemoteModel = payGradeCurrencyRemoteModel;
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

		Class<?> remoteModelClass = _payGradeCurrencyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_payGradeCurrencyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PayGradeCurrencyLocalServiceUtil.addPayGradeCurrency(this);
		}
		else {
			PayGradeCurrencyLocalServiceUtil.updatePayGradeCurrency(this);
		}
	}

	@Override
	public PayGradeCurrency toEscapedModel() {
		return (PayGradeCurrency)ProxyUtil.newProxyInstance(PayGradeCurrency.class.getClassLoader(),
			new Class[] { PayGradeCurrency.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PayGradeCurrencyClp clone = new PayGradeCurrencyClp();

		clone.setPayGradeCurrencyId(getPayGradeCurrencyId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setPayGradeId(getPayGradeId());
		clone.setCurrency(getCurrency());
		clone.setMinSalary(getMinSalary());
		clone.setMaxSalary(getMaxSalary());

		return clone;
	}

	@Override
	public int compareTo(PayGradeCurrency payGradeCurrency) {
		long primaryKey = payGradeCurrency.getPrimaryKey();

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

		if (!(obj instanceof PayGradeCurrencyClp)) {
			return false;
		}

		PayGradeCurrencyClp payGradeCurrency = (PayGradeCurrencyClp)obj;

		long primaryKey = payGradeCurrency.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{payGradeCurrencyId=");
		sb.append(getPayGradeCurrencyId());
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
		sb.append(", payGradeId=");
		sb.append(getPayGradeId());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", minSalary=");
		sb.append(getMinSalary());
		sb.append(", maxSalary=");
		sb.append(getMaxSalary());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.PayGradeCurrency");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>payGradeCurrencyId</column-name><column-value><![CDATA[");
		sb.append(getPayGradeCurrencyId());
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
			"<column><column-name>payGradeId</column-name><column-value><![CDATA[");
		sb.append(getPayGradeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minSalary</column-name><column-value><![CDATA[");
		sb.append(getMinSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxSalary</column-name><column-value><![CDATA[");
		sb.append(getMaxSalary());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _payGradeCurrencyId;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private long _payGradeId;
	private String _currency;
	private long _minSalary;
	private long _maxSalary;
	private BaseModel<?> _payGradeCurrencyRemoteModel;
	private Class<?> _clpSerializerClass = com.rknowsys.eapp.hrm.service.ClpSerializer.class;
}