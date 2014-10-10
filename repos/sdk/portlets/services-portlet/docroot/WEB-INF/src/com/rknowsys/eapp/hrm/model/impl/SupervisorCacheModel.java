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

import com.rknowsys.eapp.hrm.model.Supervisor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Supervisor in entity cache.
 *
 * @author rknowsys
 * @see Supervisor
 * @generated
 */
public class SupervisorCacheModel implements CacheModel<Supervisor>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{supervisorId=");
		sb.append(supervisorId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", reportingMethod=");
		sb.append(reportingMethod);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Supervisor toEntityModel() {
		SupervisorImpl supervisorImpl = new SupervisorImpl();

		supervisorImpl.setSupervisorId(supervisorId);
		supervisorImpl.setEmployeeId(employeeId);
		supervisorImpl.setGroupId(groupId);
		supervisorImpl.setCompanyId(companyId);
		supervisorImpl.setUserId(userId);

		if (userName == null) {
			supervisorImpl.setUserName(StringPool.BLANK);
		}
		else {
			supervisorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			supervisorImpl.setCreateDate(null);
		}
		else {
			supervisorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			supervisorImpl.setModifiedDate(null);
		}
		else {
			supervisorImpl.setModifiedDate(new Date(modifiedDate));
		}

		supervisorImpl.setReportingMethod(reportingMethod);

		supervisorImpl.resetOriginalValues();

		return supervisorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supervisorId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		reportingMethod = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(supervisorId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(reportingMethod);
	}

	public long supervisorId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long reportingMethod;
}