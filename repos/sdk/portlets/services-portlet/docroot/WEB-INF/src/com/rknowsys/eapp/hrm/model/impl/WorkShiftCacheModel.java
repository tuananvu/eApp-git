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

import com.rknowsys.eapp.hrm.model.WorkShift;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkShift in entity cache.
 *
 * @author rknowsys
 * @see WorkShift
 * @generated
 */
public class WorkShiftCacheModel implements CacheModel<WorkShift>,
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
		sb.append(", shiftName=");
		sb.append(shiftName);
		sb.append(", fromWorkHrs=");
		sb.append(fromWorkHrs);
		sb.append(", toWorkHrs=");
		sb.append(toWorkHrs);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkShift toEntityModel() {
		WorkShiftImpl workShiftImpl = new WorkShiftImpl();

		workShiftImpl.setShiftId(shiftId);
		workShiftImpl.setCompanyId(companyId);
		workShiftImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			workShiftImpl.setCreateDate(null);
		}
		else {
			workShiftImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workShiftImpl.setModifiedDate(null);
		}
		else {
			workShiftImpl.setModifiedDate(new Date(modifiedDate));
		}

		workShiftImpl.setUserId(userId);

		if (shiftName == null) {
			workShiftImpl.setShiftName(StringPool.BLANK);
		}
		else {
			workShiftImpl.setShiftName(shiftName);
		}

		workShiftImpl.setFromWorkHrs(fromWorkHrs);
		workShiftImpl.setToWorkHrs(toWorkHrs);

		workShiftImpl.resetOriginalValues();

		return workShiftImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		shiftId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		shiftName = objectInput.readUTF();
		fromWorkHrs = objectInput.readLong();
		toWorkHrs = objectInput.readLong();
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

		if (shiftName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shiftName);
		}

		objectOutput.writeLong(fromWorkHrs);
		objectOutput.writeLong(toWorkHrs);
	}

	public long shiftId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String shiftName;
	public long fromWorkHrs;
	public long toWorkHrs;
}