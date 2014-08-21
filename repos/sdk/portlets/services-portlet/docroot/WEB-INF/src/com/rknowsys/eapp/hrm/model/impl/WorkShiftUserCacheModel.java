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
import com.liferay.portal.model.CacheModel;

import com.rknowsys.eapp.hrm.model.WorkShiftUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkShiftUser in entity cache.
 *
 * @author rknowsys
 * @see WorkShiftUser
 * @generated
 */
public class WorkShiftUserCacheModel implements CacheModel<WorkShiftUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{workShiftUserId=");
		sb.append(workShiftUserId);
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
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", shiftId=");
		sb.append(shiftId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkShiftUser toEntityModel() {
		WorkShiftUserImpl workShiftUserImpl = new WorkShiftUserImpl();

		workShiftUserImpl.setWorkShiftUserId(workShiftUserId);
		workShiftUserImpl.setCompanyId(companyId);
		workShiftUserImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			workShiftUserImpl.setCreateDate(null);
		}
		else {
			workShiftUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workShiftUserImpl.setModifiedDate(null);
		}
		else {
			workShiftUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		workShiftUserImpl.setUserId(userId);
		workShiftUserImpl.setEmpId(empId);
		workShiftUserImpl.setShiftId(shiftId);

		workShiftUserImpl.resetOriginalValues();

		return workShiftUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workShiftUserId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		empId = objectInput.readLong();
		shiftId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workShiftUserId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(empId);
		objectOutput.writeLong(shiftId);
	}

	public long workShiftUserId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long empId;
	public long shiftId;
}