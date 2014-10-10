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

import com.rknowsys.eapp.hrm.model.EmergencyContact;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmergencyContact in entity cache.
 *
 * @author rknowsys
 * @see EmergencyContact
 * @generated
 */
public class EmergencyContactCacheModel implements CacheModel<EmergencyContact>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{emergencyContactId=");
		sb.append(emergencyContactId);
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
		sb.append(", homeTelephone=");
		sb.append(homeTelephone);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", workTelephone=");
		sb.append(workTelephone);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmergencyContact toEntityModel() {
		EmergencyContactImpl emergencyContactImpl = new EmergencyContactImpl();

		emergencyContactImpl.setEmergencyContactId(emergencyContactId);
		emergencyContactImpl.setEmployeeId(employeeId);
		emergencyContactImpl.setGroupId(groupId);
		emergencyContactImpl.setCompanyId(companyId);
		emergencyContactImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			emergencyContactImpl.setCreateDate(null);
		}
		else {
			emergencyContactImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			emergencyContactImpl.setModifiedDate(null);
		}
		else {
			emergencyContactImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			emergencyContactImpl.setName(StringPool.BLANK);
		}
		else {
			emergencyContactImpl.setName(name);
		}

		if (relationship == null) {
			emergencyContactImpl.setRelationship(StringPool.BLANK);
		}
		else {
			emergencyContactImpl.setRelationship(relationship);
		}

		if (homeTelephone == null) {
			emergencyContactImpl.setHomeTelephone(StringPool.BLANK);
		}
		else {
			emergencyContactImpl.setHomeTelephone(homeTelephone);
		}

		if (mobile == null) {
			emergencyContactImpl.setMobile(StringPool.BLANK);
		}
		else {
			emergencyContactImpl.setMobile(mobile);
		}

		if (workTelephone == null) {
			emergencyContactImpl.setWorkTelephone(StringPool.BLANK);
		}
		else {
			emergencyContactImpl.setWorkTelephone(workTelephone);
		}

		emergencyContactImpl.resetOriginalValues();

		return emergencyContactImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		emergencyContactId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		relationship = objectInput.readUTF();
		homeTelephone = objectInput.readUTF();
		mobile = objectInput.readUTF();
		workTelephone = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(emergencyContactId);
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

		if (homeTelephone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(homeTelephone);
		}

		if (mobile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (workTelephone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workTelephone);
		}
	}

	public long emergencyContactId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String relationship;
	public String homeTelephone;
	public String mobile;
	public String workTelephone;
}