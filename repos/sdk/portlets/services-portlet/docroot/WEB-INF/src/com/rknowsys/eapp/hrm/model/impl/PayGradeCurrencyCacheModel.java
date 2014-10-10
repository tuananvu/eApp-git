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

package com.rknowsys.eapp.hrm.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rknowsys.eapp.hrm.model.PayGradeCurrency;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PayGradeCurrency in entity cache.
 *
 * @author rknowsys
 * @see PayGradeCurrency
 * @generated
 */
public class PayGradeCurrencyCacheModel implements CacheModel<PayGradeCurrency>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{payGradeCurrencyId=");
		sb.append(payGradeCurrencyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", payGradeId=");
		sb.append(payGradeId);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", minSalary=");
		sb.append(minSalary);
		sb.append(", maxSalary=");
		sb.append(maxSalary);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PayGradeCurrency toEntityModel() {
		PayGradeCurrencyImpl payGradeCurrencyImpl = new PayGradeCurrencyImpl();

		payGradeCurrencyImpl.setPayGradeCurrencyId(payGradeCurrencyId);
		payGradeCurrencyImpl.setCompanyId(companyId);
		payGradeCurrencyImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			payGradeCurrencyImpl.setCreateDate(null);
		}
		else {
			payGradeCurrencyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			payGradeCurrencyImpl.setModifiedDate(null);
		}
		else {
			payGradeCurrencyImpl.setModifiedDate(new Date(modifiedDate));
		}

		payGradeCurrencyImpl.setUserId(userId);
		payGradeCurrencyImpl.setPayGradeId(payGradeId);

		if (currency == null) {
			payGradeCurrencyImpl.setCurrency(StringPool.BLANK);
		}
		else {
			payGradeCurrencyImpl.setCurrency(currency);
		}

		payGradeCurrencyImpl.setMinSalary(minSalary);
		payGradeCurrencyImpl.setMaxSalary(maxSalary);

		payGradeCurrencyImpl.resetOriginalValues();

		return payGradeCurrencyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		payGradeCurrencyId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		payGradeId = objectInput.readLong();
		currency = objectInput.readUTF();
		minSalary = objectInput.readLong();
		maxSalary = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(payGradeCurrencyId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(payGradeId);

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeLong(minSalary);
		objectOutput.writeLong(maxSalary);
	}

	public long payGradeCurrencyId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long payGradeId;
	public String currency;
	public long minSalary;
	public long maxSalary;
}