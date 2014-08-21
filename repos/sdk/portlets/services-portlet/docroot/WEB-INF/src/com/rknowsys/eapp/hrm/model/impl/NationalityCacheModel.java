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

import com.rknowsys.eapp.hrm.model.Nationality;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Nationality in entity cache.
 *
 * @author rknowsys
 * @see Nationality
 * @generated
 */
public class NationalityCacheModel implements CacheModel<Nationality>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
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
		sb.append(", nationalityName=");
		sb.append(nationalityName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Nationality toEntityModel() {
		NationalityImpl nationalityImpl = new NationalityImpl();

		nationalityImpl.setId(id);
		nationalityImpl.setCompanyId(companyId);
		nationalityImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			nationalityImpl.setCreateDate(null);
		}
		else {
			nationalityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			nationalityImpl.setModifiedDate(null);
		}
		else {
			nationalityImpl.setModifiedDate(new Date(modifiedDate));
		}

		nationalityImpl.setUserId(userId);

		if (nationalityName == null) {
			nationalityImpl.setNationalityName(StringPool.BLANK);
		}
		else {
			nationalityImpl.setNationalityName(nationalityName);
		}

		nationalityImpl.resetOriginalValues();

		return nationalityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		nationalityName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (nationalityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nationalityName);
		}
	}

	public long id;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String nationalityName;
}