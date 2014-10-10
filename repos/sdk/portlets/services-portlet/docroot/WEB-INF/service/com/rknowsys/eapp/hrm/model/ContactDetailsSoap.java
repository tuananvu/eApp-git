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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author rknowsys
 * @generated
 */
public class ContactDetailsSoap implements Serializable {
	public static ContactDetailsSoap toSoapModel(ContactDetails model) {
		ContactDetailsSoap soapModel = new ContactDetailsSoap();

		soapModel.setContactDetailsId(model.getContactDetailsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAddressStreet1(model.getAddressStreet1());
		soapModel.setAddressStreet2(model.getAddressStreet2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setCountry(model.getCountry());
		soapModel.setHomeTelephone(model.getHomeTelephone());
		soapModel.setMobile(model.getMobile());
		soapModel.setWorkTelephone(model.getWorkTelephone());
		soapModel.setWorkEmail(model.getWorkEmail());
		soapModel.setOtherEmail(model.getOtherEmail());

		return soapModel;
	}

	public static ContactDetailsSoap[] toSoapModels(ContactDetails[] models) {
		ContactDetailsSoap[] soapModels = new ContactDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactDetailsSoap[][] toSoapModels(ContactDetails[][] models) {
		ContactDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactDetailsSoap[] toSoapModels(List<ContactDetails> models) {
		List<ContactDetailsSoap> soapModels = new ArrayList<ContactDetailsSoap>(models.size());

		for (ContactDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactDetailsSoap[soapModels.size()]);
	}

	public ContactDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _contactDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setContactDetailsId(pk);
	}

	public long getContactDetailsId() {
		return _contactDetailsId;
	}

	public void setContactDetailsId(long contactDetailsId) {
		_contactDetailsId = contactDetailsId;
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

	public String getAddressStreet1() {
		return _addressStreet1;
	}

	public void setAddressStreet1(String addressStreet1) {
		_addressStreet1 = addressStreet1;
	}

	public String getAddressStreet2() {
		return _addressStreet2;
	}

	public void setAddressStreet2(String addressStreet2) {
		_addressStreet2 = addressStreet2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getHomeTelephone() {
		return _homeTelephone;
	}

	public void setHomeTelephone(String homeTelephone) {
		_homeTelephone = homeTelephone;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getWorkTelephone() {
		return _workTelephone;
	}

	public void setWorkTelephone(String workTelephone) {
		_workTelephone = workTelephone;
	}

	public String getWorkEmail() {
		return _workEmail;
	}

	public void setWorkEmail(String workEmail) {
		_workEmail = workEmail;
	}

	public String getOtherEmail() {
		return _otherEmail;
	}

	public void setOtherEmail(String otherEmail) {
		_otherEmail = otherEmail;
	}

	private long _contactDetailsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _addressStreet1;
	private String _addressStreet2;
	private String _city;
	private String _state;
	private String _postalCode;
	private String _country;
	private String _homeTelephone;
	private String _mobile;
	private String _workTelephone;
	private String _workEmail;
	private String _otherEmail;
}