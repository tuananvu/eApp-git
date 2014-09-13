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

import com.rknowsys.eapp.hrm.model.WorkExpCompany;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkExpCompany in entity cache.
 *
 * @author rknowsys
 * @see WorkExpCompany
 * @generated
 */
public class WorkExpCompanyCacheModel implements CacheModel<WorkExpCompany>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{workExpCompanyId=");
		sb.append(workExpCompanyId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", company=");
		sb.append(company);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkExpCompany toEntityModel() {
		WorkExpCompanyImpl workExpCompanyImpl = new WorkExpCompanyImpl();

		workExpCompanyImpl.setWorkExpCompanyId(workExpCompanyId);
		workExpCompanyImpl.setEmployeeId(employeeId);
		workExpCompanyImpl.setGroupId(groupId);
		workExpCompanyImpl.setCompanyId(companyId);
		workExpCompanyImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			workExpCompanyImpl.setCreateDate(null);
		}
		else {
			workExpCompanyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workExpCompanyImpl.setModifiedDate(null);
		}
		else {
			workExpCompanyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (company == null) {
			workExpCompanyImpl.setCompany(StringPool.BLANK);
		}
		else {
			workExpCompanyImpl.setCompany(company);
		}

		if (jobTitle == null) {
			workExpCompanyImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			workExpCompanyImpl.setJobTitle(jobTitle);
		}

		if (fromDate == Long.MIN_VALUE) {
			workExpCompanyImpl.setFromDate(null);
		}
		else {
			workExpCompanyImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			workExpCompanyImpl.setToDate(null);
		}
		else {
			workExpCompanyImpl.setToDate(new Date(toDate));
		}

		if (comment == null) {
			workExpCompanyImpl.setComment(StringPool.BLANK);
		}
		else {
			workExpCompanyImpl.setComment(comment);
		}

		workExpCompanyImpl.resetOriginalValues();

		return workExpCompanyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workExpCompanyId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		company = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workExpCompanyId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public long workExpCompanyId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String company;
	public String jobTitle;
	public long fromDate;
	public long toDate;
	public String comment;
}