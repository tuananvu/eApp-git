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

import com.rknowsys.eapp.hrm.model.Locations;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Locations in entity cache.
 *
 * @author rknowsys
 * @see Locations
 * @generated
 */
public class LocationsCacheModel implements CacheModel<Locations>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

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
		sb.append(", name=");
		sb.append(name);
		sb.append(", country=");
		sb.append(country);
		sb.append(", state=");
		sb.append(state);
		sb.append(", city=");
		sb.append(city);
		sb.append(", address=");
		sb.append(address);
		sb.append(", postalcode=");
		sb.append(postalcode);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", notes=");
		sb.append(notes);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Locations toEntityModel() {
		LocationsImpl locationsImpl = new LocationsImpl();

		locationsImpl.setId(id);
		locationsImpl.setCompanyId(companyId);
		locationsImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			locationsImpl.setCreateDate(null);
		}
		else {
			locationsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			locationsImpl.setModifiedDate(null);
		}
		else {
			locationsImpl.setModifiedDate(new Date(modifiedDate));
		}

		locationsImpl.setUserId(userId);

		if (name == null) {
			locationsImpl.setName(StringPool.BLANK);
		}
		else {
			locationsImpl.setName(name);
		}

		if (country == null) {
			locationsImpl.setCountry(StringPool.BLANK);
		}
		else {
			locationsImpl.setCountry(country);
		}

		if (state == null) {
			locationsImpl.setState(StringPool.BLANK);
		}
		else {
			locationsImpl.setState(state);
		}

		if (city == null) {
			locationsImpl.setCity(StringPool.BLANK);
		}
		else {
			locationsImpl.setCity(city);
		}

		if (address == null) {
			locationsImpl.setAddress(StringPool.BLANK);
		}
		else {
			locationsImpl.setAddress(address);
		}

		if (postalcode == null) {
			locationsImpl.setPostalcode(StringPool.BLANK);
		}
		else {
			locationsImpl.setPostalcode(postalcode);
		}

		if (phone == null) {
			locationsImpl.setPhone(StringPool.BLANK);
		}
		else {
			locationsImpl.setPhone(phone);
		}

		if (fax == null) {
			locationsImpl.setFax(StringPool.BLANK);
		}
		else {
			locationsImpl.setFax(fax);
		}

		if (notes == null) {
			locationsImpl.setNotes(StringPool.BLANK);
		}
		else {
			locationsImpl.setNotes(notes);
		}

		locationsImpl.resetOriginalValues();

		return locationsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		country = objectInput.readUTF();
		state = objectInput.readUTF();
		city = objectInput.readUTF();
		address = objectInput.readUTF();
		postalcode = objectInput.readUTF();
		phone = objectInput.readUTF();
		fax = objectInput.readUTF();
		notes = objectInput.readUTF();
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (postalcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalcode);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (fax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fax);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}
	}

	public long id;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String name;
	public String country;
	public String state;
	public String city;
	public String address;
	public String postalcode;
	public String phone;
	public String fax;
	public String notes;
}