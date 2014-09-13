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

import com.rknowsys.eapp.hrm.model.Job;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Job in entity cache.
 *
 * @author rknowsys
 * @see Job
 * @generated
 */
public class JobCacheModel implements CacheModel<Job>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{jobId=");
		sb.append(jobId);
		sb.append(", jobTitleId=");
		sb.append(jobTitleId);
		sb.append(", jobCategoryId=");
		sb.append(jobCategoryId);
		sb.append(", subUnitId=");
		sb.append(subUnitId);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", employmentStatusId=");
		sb.append(employmentStatusId);
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
		sb.append(", joinedDate=");
		sb.append(joinedDate);
		sb.append(", employmentContractStartDate=");
		sb.append(employmentContractStartDate);
		sb.append(", employmentContractEndDate=");
		sb.append(employmentContractEndDate);

		return sb.toString();
	}

	@Override
	public Job toEntityModel() {
		JobImpl jobImpl = new JobImpl();

		jobImpl.setJobId(jobId);
		jobImpl.setJobTitleId(jobTitleId);
		jobImpl.setJobCategoryId(jobCategoryId);
		jobImpl.setSubUnitId(subUnitId);
		jobImpl.setLocationId(locationId);
		jobImpl.setEmploymentStatusId(employmentStatusId);
		jobImpl.setGroupId(groupId);
		jobImpl.setCompanyId(companyId);
		jobImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			jobImpl.setCreateDate(null);
		}
		else {
			jobImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobImpl.setModifiedDate(null);
		}
		else {
			jobImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (joinedDate == Long.MIN_VALUE) {
			jobImpl.setJoinedDate(null);
		}
		else {
			jobImpl.setJoinedDate(new Date(joinedDate));
		}

		if (employmentContractStartDate == Long.MIN_VALUE) {
			jobImpl.setEmploymentContractStartDate(null);
		}
		else {
			jobImpl.setEmploymentContractStartDate(new Date(
					employmentContractStartDate));
		}

		if (employmentContractEndDate == Long.MIN_VALUE) {
			jobImpl.setEmploymentContractEndDate(null);
		}
		else {
			jobImpl.setEmploymentContractEndDate(new Date(
					employmentContractEndDate));
		}

		jobImpl.resetOriginalValues();

		return jobImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobId = objectInput.readLong();
		jobTitleId = objectInput.readLong();
		jobCategoryId = objectInput.readLong();
		subUnitId = objectInput.readLong();
		locationId = objectInput.readLong();
		employmentStatusId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		joinedDate = objectInput.readLong();
		employmentContractStartDate = objectInput.readLong();
		employmentContractEndDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobId);
		objectOutput.writeLong(jobTitleId);
		objectOutput.writeLong(jobCategoryId);
		objectOutput.writeLong(subUnitId);
		objectOutput.writeLong(locationId);
		objectOutput.writeLong(employmentStatusId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(joinedDate);
		objectOutput.writeLong(employmentContractStartDate);
		objectOutput.writeLong(employmentContractEndDate);
	}

	public long jobId;
	public long jobTitleId;
	public long jobCategoryId;
	public long subUnitId;
	public long locationId;
	public long employmentStatusId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long joinedDate;
	public long employmentContractStartDate;
	public long employmentContractEndDate;
}