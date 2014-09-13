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

package com.rknowsys.eapp.hrm.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the file column in Attachment.
 *
 * @author rknowsys
 * @see Attachment
 * @generated
 */
public class AttachmentFileBlobModel {
	public AttachmentFileBlobModel() {
	}

	public AttachmentFileBlobModel(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public AttachmentFileBlobModel(long attachmentId, Blob fileBlob) {
		_attachmentId = attachmentId;
		_fileBlob = fileBlob;
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public Blob getFileBlob() {
		return _fileBlob;
	}

	public void setFileBlob(Blob fileBlob) {
		_fileBlob = fileBlob;
	}

	private long _attachmentId;
	private Blob _fileBlob;
}