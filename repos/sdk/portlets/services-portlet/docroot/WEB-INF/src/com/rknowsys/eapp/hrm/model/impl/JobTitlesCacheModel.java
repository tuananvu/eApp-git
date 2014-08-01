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

import com.rknowsys.eapp.hrm.model.JobTitles;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobTitles in entity cache.
 *
 * @author Rknowsys
 * @see JobTitles
 * @generated
 */
public class JobTitlesCacheModel implements CacheModel<JobTitles>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", specification=");
		sb.append(specification);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobTitles toEntityModel() {
		JobTitlesImpl jobTitlesImpl = new JobTitlesImpl();

		jobTitlesImpl.setId(id);
		jobTitlesImpl.setCompanyId(companyId);
		jobTitlesImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			jobTitlesImpl.setCreateDate(null);
		}
		else {
			jobTitlesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobTitlesImpl.setModifiedDate(null);
		}
		else {
			jobTitlesImpl.setModifiedDate(new Date(modifiedDate));
		}

		jobTitlesImpl.setUserId(userId);

		if (title == null) {
			jobTitlesImpl.setTitle(StringPool.BLANK);
		}
		else {
			jobTitlesImpl.setTitle(title);
		}

		if (description == null) {
			jobTitlesImpl.setDescription(StringPool.BLANK);
		}
		else {
			jobTitlesImpl.setDescription(description);
		}

		if (notes == null) {
			jobTitlesImpl.setNotes(StringPool.BLANK);
		}
		else {
			jobTitlesImpl.setNotes(notes);
		}

		if (specification == null) {
			jobTitlesImpl.setSpecification(StringPool.BLANK);
		}
		else {
			jobTitlesImpl.setSpecification(specification);
		}

		jobTitlesImpl.resetOriginalValues();

		return jobTitlesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		notes = objectInput.readUTF();
		specification = objectInput.readUTF();
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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		if (specification == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(specification);
		}
	}

	public long id;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String title;
	public String description;
	public String notes;
	public String specification;
}