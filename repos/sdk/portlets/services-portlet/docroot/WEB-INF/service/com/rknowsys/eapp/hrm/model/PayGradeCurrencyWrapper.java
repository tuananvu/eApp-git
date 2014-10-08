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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PayGradeCurrency}.
 * </p>
 *
 * @author rknowsys
 * @see PayGradeCurrency
 * @generated
 */
public class PayGradeCurrencyWrapper implements PayGradeCurrency,
	ModelWrapper<PayGradeCurrency> {
	public PayGradeCurrencyWrapper(PayGradeCurrency payGradeCurrency) {
		_payGradeCurrency = payGradeCurrency;
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

	/**
	* Returns the primary key of this pay grade currency.
	*
	* @return the primary key of this pay grade currency
	*/
	@Override
	public long getPrimaryKey() {
		return _payGradeCurrency.getPrimaryKey();
	}

	/**
	* Sets the primary key of this pay grade currency.
	*
	* @param primaryKey the primary key of this pay grade currency
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_payGradeCurrency.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the pay grade currency ID of this pay grade currency.
	*
	* @return the pay grade currency ID of this pay grade currency
	*/
	@Override
	public long getPayGradeCurrencyId() {
		return _payGradeCurrency.getPayGradeCurrencyId();
	}

	/**
	* Sets the pay grade currency ID of this pay grade currency.
	*
	* @param payGradeCurrencyId the pay grade currency ID of this pay grade currency
	*/
	@Override
	public void setPayGradeCurrencyId(long payGradeCurrencyId) {
		_payGradeCurrency.setPayGradeCurrencyId(payGradeCurrencyId);
	}

	/**
	* Returns the company ID of this pay grade currency.
	*
	* @return the company ID of this pay grade currency
	*/
	@Override
	public long getCompanyId() {
		return _payGradeCurrency.getCompanyId();
	}

	/**
	* Sets the company ID of this pay grade currency.
	*
	* @param companyId the company ID of this pay grade currency
	*/
	@Override
	public void setCompanyId(long companyId) {
		_payGradeCurrency.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this pay grade currency.
	*
	* @return the group ID of this pay grade currency
	*/
	@Override
	public long getGroupId() {
		return _payGradeCurrency.getGroupId();
	}

	/**
	* Sets the group ID of this pay grade currency.
	*
	* @param groupId the group ID of this pay grade currency
	*/
	@Override
	public void setGroupId(long groupId) {
		_payGradeCurrency.setGroupId(groupId);
	}

	/**
	* Returns the create date of this pay grade currency.
	*
	* @return the create date of this pay grade currency
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _payGradeCurrency.getCreateDate();
	}

	/**
	* Sets the create date of this pay grade currency.
	*
	* @param createDate the create date of this pay grade currency
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_payGradeCurrency.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this pay grade currency.
	*
	* @return the modified date of this pay grade currency
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _payGradeCurrency.getModifiedDate();
	}

	/**
	* Sets the modified date of this pay grade currency.
	*
	* @param modifiedDate the modified date of this pay grade currency
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_payGradeCurrency.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this pay grade currency.
	*
	* @return the user ID of this pay grade currency
	*/
	@Override
	public long getUserId() {
		return _payGradeCurrency.getUserId();
	}

	/**
	* Sets the user ID of this pay grade currency.
	*
	* @param userId the user ID of this pay grade currency
	*/
	@Override
	public void setUserId(long userId) {
		_payGradeCurrency.setUserId(userId);
	}

	/**
	* Returns the user uuid of this pay grade currency.
	*
	* @return the user uuid of this pay grade currency
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrency.getUserUuid();
	}

	/**
	* Sets the user uuid of this pay grade currency.
	*
	* @param userUuid the user uuid of this pay grade currency
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_payGradeCurrency.setUserUuid(userUuid);
	}

	/**
	* Returns the pay grade ID of this pay grade currency.
	*
	* @return the pay grade ID of this pay grade currency
	*/
	@Override
	public long getPayGradeId() {
		return _payGradeCurrency.getPayGradeId();
	}

	/**
	* Sets the pay grade ID of this pay grade currency.
	*
	* @param payGradeId the pay grade ID of this pay grade currency
	*/
	@Override
	public void setPayGradeId(long payGradeId) {
		_payGradeCurrency.setPayGradeId(payGradeId);
	}

	/**
	* Returns the currency of this pay grade currency.
	*
	* @return the currency of this pay grade currency
	*/
	@Override
	public java.lang.String getCurrency() {
		return _payGradeCurrency.getCurrency();
	}

	/**
	* Sets the currency of this pay grade currency.
	*
	* @param currency the currency of this pay grade currency
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_payGradeCurrency.setCurrency(currency);
	}

	/**
	* Returns the min salary of this pay grade currency.
	*
	* @return the min salary of this pay grade currency
	*/
	@Override
	public long getMinSalary() {
		return _payGradeCurrency.getMinSalary();
	}

	/**
	* Sets the min salary of this pay grade currency.
	*
	* @param minSalary the min salary of this pay grade currency
	*/
	@Override
	public void setMinSalary(long minSalary) {
		_payGradeCurrency.setMinSalary(minSalary);
	}

	/**
	* Returns the max salary of this pay grade currency.
	*
	* @return the max salary of this pay grade currency
	*/
	@Override
	public long getMaxSalary() {
		return _payGradeCurrency.getMaxSalary();
	}

	/**
	* Sets the max salary of this pay grade currency.
	*
	* @param maxSalary the max salary of this pay grade currency
	*/
	@Override
	public void setMaxSalary(long maxSalary) {
		_payGradeCurrency.setMaxSalary(maxSalary);
	}

	@Override
	public boolean isNew() {
		return _payGradeCurrency.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_payGradeCurrency.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _payGradeCurrency.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_payGradeCurrency.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _payGradeCurrency.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _payGradeCurrency.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_payGradeCurrency.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _payGradeCurrency.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_payGradeCurrency.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_payGradeCurrency.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_payGradeCurrency.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PayGradeCurrencyWrapper((PayGradeCurrency)_payGradeCurrency.clone());
	}

	@Override
	public int compareTo(PayGradeCurrency payGradeCurrency) {
		return _payGradeCurrency.compareTo(payGradeCurrency);
	}

	@Override
	public int hashCode() {
		return _payGradeCurrency.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<PayGradeCurrency> toCacheModel() {
		return _payGradeCurrency.toCacheModel();
	}

	@Override
	public PayGradeCurrency toEscapedModel() {
		return new PayGradeCurrencyWrapper(_payGradeCurrency.toEscapedModel());
	}

	@Override
	public PayGradeCurrency toUnescapedModel() {
		return new PayGradeCurrencyWrapper(_payGradeCurrency.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _payGradeCurrency.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _payGradeCurrency.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_payGradeCurrency.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PayGradeCurrencyWrapper)) {
			return false;
		}

		PayGradeCurrencyWrapper payGradeCurrencyWrapper = (PayGradeCurrencyWrapper)obj;

		if (Validator.equals(_payGradeCurrency,
					payGradeCurrencyWrapper._payGradeCurrency)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PayGradeCurrency getWrappedPayGradeCurrency() {
		return _payGradeCurrency;
	}

	@Override
	public PayGradeCurrency getWrappedModel() {
		return _payGradeCurrency;
	}

	@Override
	public void resetOriginalValues() {
		_payGradeCurrency.resetOriginalValues();
	}

	private PayGradeCurrency _payGradeCurrency;
}