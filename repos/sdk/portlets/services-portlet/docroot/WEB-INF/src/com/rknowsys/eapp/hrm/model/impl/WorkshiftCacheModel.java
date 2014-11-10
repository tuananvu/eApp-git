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

import com.rknowsys.eapp.hrm.model.Workshift;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Workshift in entity cache.
 *
 * @author rknowsys
 * @see Workshift
 * @generated
 */
public class WorkshiftCacheModel implements CacheModel<Workshift>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{shiftId=");
		sb.append(shiftId);
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
		sb.append(", workshiftName=");
		sb.append(workshiftName);
		sb.append(", fromWorkHours=");
		sb.append(fromWorkHours);
		sb.append(", toWorkHours=");
		sb.append(toWorkHours);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Workshift toEntityModel() {
		WorkshiftImpl workshiftImpl = new WorkshiftImpl();

		workshiftImpl.setShiftId(shiftId);
		workshiftImpl.setCompanyId(companyId);
		workshiftImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			workshiftImpl.setCreateDate(null);
		}
		else {
			workshiftImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workshiftImpl.setModifiedDate(null);
		}
		else {
			workshiftImpl.setModifiedDate(new Date(modifiedDate));
		}

		workshiftImpl.setUserId(userId);

		if (workshiftName == null) {
			workshiftImpl.setWorkshiftName(StringPool.BLANK);
		}
		else {
			workshiftImpl.setWorkshiftName(workshiftName);
		}

		if (fromWorkHours == Long.MIN_VALUE) {
			workshiftImpl.setFromWorkHours(null);
		}
		else {
			workshiftImpl.setFromWorkHours(new Date(fromWorkHours));
		}

		if (toWorkHours == Long.MIN_VALUE) {
			workshiftImpl.setToWorkHours(null);
		}
		else {
			workshiftImpl.setToWorkHours(new Date(toWorkHours));
		}

		workshiftImpl.resetOriginalValues();

		return workshiftImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		shiftId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		workshiftName = objectInput.readUTF();
		fromWorkHours = objectInput.readLong();
		toWorkHours = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(shiftId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (workshiftName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workshiftName);
		}

		objectOutput.writeLong(fromWorkHours);
		objectOutput.writeLong(toWorkHours);
	}

	public long shiftId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String workshiftName;
	public long fromWorkHours;
	public long toWorkHours;
}