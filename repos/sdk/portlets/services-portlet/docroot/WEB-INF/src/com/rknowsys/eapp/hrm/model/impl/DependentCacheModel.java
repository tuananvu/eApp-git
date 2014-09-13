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

import com.rknowsys.eapp.hrm.model.Dependent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dependent in entity cache.
 *
 * @author rknowsys
 * @see Dependent
 * @generated
 */
public class DependentCacheModel implements CacheModel<Dependent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{dependentId=");
		sb.append(dependentId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", relationship=");
		sb.append(relationship);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dependent toEntityModel() {
		DependentImpl dependentImpl = new DependentImpl();

		dependentImpl.setDependentId(dependentId);
		dependentImpl.setEmployeeId(employeeId);
		dependentImpl.setGroupId(groupId);
		dependentImpl.setCompanyId(companyId);
		dependentImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dependentImpl.setCreateDate(null);
		}
		else {
			dependentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dependentImpl.setModifiedDate(null);
		}
		else {
			dependentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			dependentImpl.setName(StringPool.BLANK);
		}
		else {
			dependentImpl.setName(name);
		}

		if (relationship == null) {
			dependentImpl.setRelationship(StringPool.BLANK);
		}
		else {
			dependentImpl.setRelationship(relationship);
		}

		if (dateOfBirth == Long.MIN_VALUE) {
			dependentImpl.setDateOfBirth(null);
		}
		else {
			dependentImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		dependentImpl.resetOriginalValues();

		return dependentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dependentId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		relationship = objectInput.readUTF();
		dateOfBirth = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dependentId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (relationship == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(relationship);
		}

		objectOutput.writeLong(dateOfBirth);
	}

	public long dependentId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String relationship;
	public long dateOfBirth;
}