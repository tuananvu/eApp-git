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

import com.rknowsys.eapp.hrm.model.ContactDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContactDetails in entity cache.
 *
 * @author rknowsys
 * @see ContactDetails
 * @generated
 */
public class ContactDetailsCacheModel implements CacheModel<ContactDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(id);
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
		sb.append(", addressStreet1=");
		sb.append(addressStreet1);
		sb.append(", addressStreet2=");
		sb.append(addressStreet2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", country=");
		sb.append(country);
		sb.append(", homeTelephone=");
		sb.append(homeTelephone);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", workTelephone=");
		sb.append(workTelephone);
		sb.append(", workEmail=");
		sb.append(workEmail);
		sb.append(", otherEmail=");
		sb.append(otherEmail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactDetails toEntityModel() {
		ContactDetailsImpl contactDetailsImpl = new ContactDetailsImpl();

		contactDetailsImpl.setId(id);
		contactDetailsImpl.setGroupId(groupId);
		contactDetailsImpl.setCompanyId(companyId);
		contactDetailsImpl.setUserId(userId);

		if (userName == null) {
			contactDetailsImpl.setUserName(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactDetailsImpl.setCreateDate(null);
		}
		else {
			contactDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactDetailsImpl.setModifiedDate(null);
		}
		else {
			contactDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (addressStreet1 == null) {
			contactDetailsImpl.setAddressStreet1(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setAddressStreet1(addressStreet1);
		}

		if (addressStreet2 == null) {
			contactDetailsImpl.setAddressStreet2(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setAddressStreet2(addressStreet2);
		}

		if (city == null) {
			contactDetailsImpl.setCity(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setCity(city);
		}

		if (state == null) {
			contactDetailsImpl.setState(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setState(state);
		}

		if (postalCode == null) {
			contactDetailsImpl.setPostalCode(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setPostalCode(postalCode);
		}

		if (country == null) {
			contactDetailsImpl.setCountry(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setCountry(country);
		}

		if (homeTelephone == null) {
			contactDetailsImpl.setHomeTelephone(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setHomeTelephone(homeTelephone);
		}

		if (mobile == null) {
			contactDetailsImpl.setMobile(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setMobile(mobile);
		}

		if (workTelephone == null) {
			contactDetailsImpl.setWorkTelephone(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setWorkTelephone(workTelephone);
		}

		if (workEmail == null) {
			contactDetailsImpl.setWorkEmail(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setWorkEmail(workEmail);
		}

		if (otherEmail == null) {
			contactDetailsImpl.setOtherEmail(StringPool.BLANK);
		}
		else {
			contactDetailsImpl.setOtherEmail(otherEmail);
		}

		contactDetailsImpl.resetOriginalValues();

		return contactDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		addressStreet1 = objectInput.readUTF();
		addressStreet2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		country = objectInput.readUTF();
		homeTelephone = objectInput.readUTF();
		mobile = objectInput.readUTF();
		workTelephone = objectInput.readUTF();
		workEmail = objectInput.readUTF();
		otherEmail = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
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

		if (addressStreet1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addressStreet1);
		}

		if (addressStreet2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addressStreet2);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (postalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
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

		if (workEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workEmail);
		}

		if (otherEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherEmail);
		}
	}

	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String addressStreet1;
	public String addressStreet2;
	public String city;
	public String state;
	public String postalCode;
	public String country;
	public String homeTelephone;
	public String mobile;
	public String workTelephone;
	public String workEmail;
	public String otherEmail;
}