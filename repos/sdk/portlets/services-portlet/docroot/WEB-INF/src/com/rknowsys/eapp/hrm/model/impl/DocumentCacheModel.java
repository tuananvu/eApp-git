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

import com.rknowsys.eapp.hrm.model.Document;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author rknowsys
 * @see Document
 * @generated
 */
public class DocumentCacheModel implements CacheModel<Document>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

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
	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setId(id);
		documentImpl.setCompanyId(companyId);
		documentImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			documentImpl.setCreateDate(null);
		}
		else {
			documentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentImpl.setModifiedDate(null);
		}
		else {
			documentImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentImpl.setUserId(userId);

		if (docTopic == null) {
			documentImpl.setDocTopic(StringPool.BLANK);
		}
		else {
			documentImpl.setDocTopic(docTopic);
		}

		if (docCategory == null) {
			documentImpl.setDocCategory(StringPool.BLANK);
		}
		else {
			documentImpl.setDocCategory(docCategory);
		}

		if (description == null) {
			documentImpl.setDescription(StringPool.BLANK);
		}
		else {
			documentImpl.setDescription(description);
		}

		if (publishTo == null) {
			documentImpl.setPublishTo(StringPool.BLANK);
		}
		else {
			documentImpl.setPublishTo(publishTo);
		}

		if (publishDate == Long.MIN_VALUE) {
			documentImpl.setPublishDate(null);
		}
		else {
			documentImpl.setPublishDate(new Date(publishDate));
		}

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
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
		objectOutput.writeLong(id);
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

	public long id;
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