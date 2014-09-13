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

import com.rknowsys.eapp.hrm.model.Attachment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Attachment in entity cache.
 *
 * @author rknowsys
 * @see Attachment
 * @generated
 */
public class AttachmentCacheModel implements CacheModel<Attachment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{attachmentId=");
		sb.append(attachmentId);
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
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", attachmentType=");
		sb.append(attachmentType);
		sb.append(", size=");
		sb.append(size);
		sb.append(", fileType=");
		sb.append(fileType);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Attachment toEntityModel() {
		AttachmentImpl attachmentImpl = new AttachmentImpl();

		attachmentImpl.setAttachmentId(attachmentId);
		attachmentImpl.setEmployeeId(employeeId);
		attachmentImpl.setGroupId(groupId);
		attachmentImpl.setCompanyId(companyId);
		attachmentImpl.setUserId(userId);

		if (userName == null) {
			attachmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			attachmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			attachmentImpl.setCreateDate(null);
		}
		else {
			attachmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			attachmentImpl.setModifiedDate(null);
		}
		else {
			attachmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (comment == null) {
			attachmentImpl.setComment(StringPool.BLANK);
		}
		else {
			attachmentImpl.setComment(comment);
		}

		attachmentImpl.setAttachmentType(attachmentType);
		attachmentImpl.setSize(size);

		if (fileType == null) {
			attachmentImpl.setFileType(StringPool.BLANK);
		}
		else {
			attachmentImpl.setFileType(fileType);
		}

		if (fileName == null) {
			attachmentImpl.setFileName(StringPool.BLANK);
		}
		else {
			attachmentImpl.setFileName(fileName);
		}

		attachmentImpl.resetOriginalValues();

		return attachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attachmentId = objectInput.readLong();
		employeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		comment = objectInput.readUTF();
		attachmentType = objectInput.readInt();
		size = objectInput.readLong();
		fileType = objectInput.readUTF();
		fileName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(attachmentId);
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

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeInt(attachmentType);
		objectOutput.writeLong(size);

		if (fileType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileType);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}
	}

	public long attachmentId;
	public long employeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String comment;
	public int attachmentType;
	public long size;
	public String fileType;
	public String fileName;
}