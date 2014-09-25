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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class AttachmentSoap implements Serializable {
	public static AttachmentSoap toSoapModel(Attachment model) {
		AttachmentSoap soapModel = new AttachmentSoap();

		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setComment(model.getComment());
		soapModel.setFile(model.getFile());
		soapModel.setAttachmentType(model.getAttachmentType());
		soapModel.setSize(model.getSize());
		soapModel.setFileType(model.getFileType());
		soapModel.setFileName(model.getFileName());

		return soapModel;
	}

	public static AttachmentSoap[] toSoapModels(Attachment[] models) {
		AttachmentSoap[] soapModels = new AttachmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttachmentSoap[][] toSoapModels(Attachment[][] models) {
		AttachmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttachmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttachmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttachmentSoap[] toSoapModels(List<Attachment> models) {
		List<AttachmentSoap> soapModels = new ArrayList<AttachmentSoap>(models.size());

		for (Attachment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttachmentSoap[soapModels.size()]);
	}

	public AttachmentSoap() {
	}

	public long getPrimaryKey() {
		return _attachmentId;
	}

	public void setPrimaryKey(long pk) {
		setAttachmentId(pk);
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public Blob getFile() {
		return _file;
	}

	public void setFile(Blob file) {
		_file = file;
	}

	public int getAttachmentType() {
		return _attachmentType;
	}

	public void setAttachmentType(int attachmentType) {
		_attachmentType = attachmentType;
	}

	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	public String getFileType() {
		return _fileType;
	}

	public void setFileType(String fileType) {
		_fileType = fileType;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	private long _attachmentId;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _comment;
	private Blob _file;
	private int _attachmentType;
	private long _size;
	private String _fileType;
	private String _fileName;
}