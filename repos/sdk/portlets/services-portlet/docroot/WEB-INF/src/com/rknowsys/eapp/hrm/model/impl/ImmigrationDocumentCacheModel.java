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

import com.rknowsys.eapp.hrm.model.ImmigrationDocument;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ImmigrationDocument in entity cache.
 *
 * @author rknowsys
 * @see ImmigrationDocument
 * @generated
 */
public class ImmigrationDocumentCacheModel implements CacheModel<ImmigrationDocument>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{immigrationDocumentId=");
		sb.append(immigrationDocumentId);
		sb.append(", employeeId=");
		sb.append(employeeId);
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
		sb.append(", docTopic=");
		sb.append(docTopic);
		sb.append(", docCategory=");
		sb.append(docCategory);
		sb.append(", description=");
		sb.append(description);
		sb.append(", publishTo=");
		sb.append(publishTo);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImmigrationDocument toEntityModel() {
		ImmigrationDocumentImpl immigrationDocumentImpl = new ImmigrationDocumentImpl();

		immigrationDocumentImpl.setImmigrationDocumentId(immigrationDocumentId);
		immigrationDocumentImpl.setEmployeeId(employeeId);
		immigrationDocumentImpl.setCompanyId(companyId);
		immigrationDocumentImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			immigrationDocumentImpl.setCreateDate(null);
		}
		else {
			immigrationDocumentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			immigrationDocumentImpl.setModifiedDate(null);
		}
		else {
			immigrationDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		immigrationDocumentImpl.setUserId(userId);

		if (docTopic == null) {
			immigrationDocumentImpl.setDocTopic(StringPool.BLANK);
		}
		else {
			immigrationDocumentImpl.setDocTopic(docTopic);
		}

		if (docCategory == null) {
			immigrationDocumentImpl.setDocCategory(StringPool.BLANK);
		}
		else {
			immigrationDocumentImpl.setDocCategory(docCategory);
		}

		if (description == null) {
			immigrationDocumentImpl.setDescription(StringPool.BLANK);
		}
		else {
			immigrationDocumentImpl.setDescription(description);
		}

		if (publishTo == null) {
			immigrationDocumentImpl.setPublishTo(StringPool.BLANK);
		}
		else {
			immigrationDocumentImpl.setPublishTo(publishTo);
		}

		if (publishDate == Long.MIN_VALUE) {
			immigrationDocumentImpl.setPublishDate(null);
		}
		else {
			immigrationDocumentImpl.setPublishDate(new Date(publishDate));
		}

		immigrationDocumentImpl.resetOriginalValues();

		return immigrationDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		immigrationDocumentId = objectInput.readLong();
		employeeId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		docTopic = objectInput.readUTF();
		docCategory = objectInput.readUTF();
		description = objectInput.readUTF();
		publishTo = objectInput.readUTF();
		publishDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(immigrationDocumentId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (docTopic == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(docTopic);
		}

		if (docCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(docCategory);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (publishTo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishTo);
		}

		objectOutput.writeLong(publishDate);
	}

	public long immigrationDocumentId;
	public long employeeId;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String docTopic;
	public String docCategory;
	public String description;
	public String publishTo;
	public long publishDate;
}