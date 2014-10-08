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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.ContactDetailsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rknowsys
 */
public class ContactDetailsClp extends BaseModelImpl<ContactDetails>
	implements ContactDetails {
	public ContactDetailsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContactDetails.class;
	}

	@Override
	public String getModelClassName() {
		return ContactDetails.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contactDetailsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactDetailsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactDetailsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactDetailsId", getContactDetailsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("addressStreet1", getAddressStreet1());
		attributes.put("addressStreet2", getAddressStreet2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("postalCode", getPostalCode());
		attributes.put("country", getCountry());
		attributes.put("homeTelephone", getHomeTelephone());
		attributes.put("mobile", getMobile());
		attributes.put("workTelephone", getWorkTelephone());
		attributes.put("workEmail", getWorkEmail());
		attributes.put("otherEmail", getOtherEmail());
		attributes.put("employeeId", getEmployeeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactDetailsId = (Long)attributes.get("contactDetailsId");

		if (contactDetailsId != null) {
			setContactDetailsId(contactDetailsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String addressStreet1 = (String)attributes.get("addressStreet1");

		if (addressStreet1 != null) {
			setAddressStreet1(addressStreet1);
		}

		String addressStreet2 = (String)attributes.get("addressStreet2");

		if (addressStreet2 != null) {
			setAddressStreet2(addressStreet2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String homeTelephone = (String)attributes.get("homeTelephone");

		if (homeTelephone != null) {
			setHomeTelephone(homeTelephone);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String workTelephone = (String)attributes.get("workTelephone");

		if (workTelephone != null) {
			setWorkTelephone(workTelephone);
		}

		String workEmail = (String)attributes.get("workEmail");

		if (workEmail != null) {
			setWorkEmail(workEmail);
		}

		String otherEmail = (String)attributes.get("otherEmail");

		if (otherEmail != null) {
			setOtherEmail(otherEmail);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}
	}

	@Override
	public long getContactDetailsId() {
		return _contactDetailsId;
	}

	@Override
	public void setContactDetailsId(long contactDetailsId) {
		_contactDetailsId = contactDetailsId;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDetailsId",
						long.class);

				method.invoke(_contactDetailsRemoteModel, contactDetailsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contactDetailsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contactDetailsRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_contactDetailsRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_contactDetailsRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_contactDetailsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_contactDetailsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddressStreet1() {
		return _addressStreet1;
	}

	@Override
	public void setAddressStreet1(String addressStreet1) {
		_addressStreet1 = addressStreet1;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressStreet1",
						String.class);

				method.invoke(_contactDetailsRemoteModel, addressStreet1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddressStreet2() {
		return _addressStreet2;
	}

	@Override
	public void setAddressStreet2(String addressStreet2) {
		_addressStreet2 = addressStreet2;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressStreet2",
						String.class);

				method.invoke(_contactDetailsRemoteModel, addressStreet2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_contactDetailsRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_contactDetailsRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostalCode() {
		return _postalCode;
	}

	@Override
	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setPostalCode", String.class);

				method.invoke(_contactDetailsRemoteModel, postalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_contactDetailsRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHomeTelephone() {
		return _homeTelephone;
	}

	@Override
	public void setHomeTelephone(String homeTelephone) {
		_homeTelephone = homeTelephone;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setHomeTelephone", String.class);

				method.invoke(_contactDetailsRemoteModel, homeTelephone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobile() {
		return _mobile;
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setMobile", String.class);

				method.invoke(_contactDetailsRemoteModel, mobile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkTelephone() {
		return _workTelephone;
	}

	@Override
	public void setWorkTelephone(String workTelephone) {
		_workTelephone = workTelephone;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkTelephone", String.class);

				method.invoke(_contactDetailsRemoteModel, workTelephone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkEmail() {
		return _workEmail;
	}

	@Override
	public void setWorkEmail(String workEmail) {
		_workEmail = workEmail;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkEmail", String.class);

				method.invoke(_contactDetailsRemoteModel, workEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOtherEmail() {
		return _otherEmail;
	}

	@Override
	public void setOtherEmail(String otherEmail) {
		_otherEmail = otherEmail;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherEmail", String.class);

				method.invoke(_contactDetailsRemoteModel, otherEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;

		if (_contactDetailsRemoteModel != null) {
			try {
				Class<?> clazz = _contactDetailsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_contactDetailsRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContactDetailsRemoteModel() {
		return _contactDetailsRemoteModel;
	}

	public void setContactDetailsRemoteModel(
		BaseModel<?> contactDetailsRemoteModel) {
		_contactDetailsRemoteModel = contactDetailsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _contactDetailsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_contactDetailsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactDetailsLocalServiceUtil.addContactDetails(this);
		}
		else {
			ContactDetailsLocalServiceUtil.updateContactDetails(this);
		}
	}

	@Override
	public ContactDetails toEscapedModel() {
		return (ContactDetails)ProxyUtil.newProxyInstance(ContactDetails.class.getClassLoader(),
			new Class[] { ContactDetails.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactDetailsClp clone = new ContactDetailsClp();

		clone.setContactDetailsId(getContactDetailsId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAddressStreet1(getAddressStreet1());
		clone.setAddressStreet2(getAddressStreet2());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setPostalCode(getPostalCode());
		clone.setCountry(getCountry());
		clone.setHomeTelephone(getHomeTelephone());
		clone.setMobile(getMobile());
		clone.setWorkTelephone(getWorkTelephone());
		clone.setWorkEmail(getWorkEmail());
		clone.setOtherEmail(getOtherEmail());
		clone.setEmployeeId(getEmployeeId());

		return clone;
	}

	@Override
	public int compareTo(ContactDetails contactDetails) {
		long primaryKey = contactDetails.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactDetailsClp)) {
			return false;
		}

		ContactDetailsClp contactDetails = (ContactDetailsClp)obj;

		long primaryKey = contactDetails.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{contactDetailsId=");
		sb.append(getContactDetailsId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", addressStreet1=");
		sb.append(getAddressStreet1());
		sb.append(", addressStreet2=");
		sb.append(getAddressStreet2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", postalCode=");
		sb.append(getPostalCode());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", homeTelephone=");
		sb.append(getHomeTelephone());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", workTelephone=");
		sb.append(getWorkTelephone());
		sb.append(", workEmail=");
		sb.append(getWorkEmail());
		sb.append(", otherEmail=");
		sb.append(getOtherEmail());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.ContactDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactDetailsId</column-name><column-value><![CDATA[");
		sb.append(getContactDetailsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressStreet1</column-name><column-value><![CDATA[");
		sb.append(getAddressStreet1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressStreet2</column-name><column-value><![CDATA[");
		sb.append(getAddressStreet2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postalCode</column-name><column-value><![CDATA[");
		sb.append(getPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>homeTelephone</column-name><column-value><![CDATA[");
		sb.append(getHomeTelephone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workTelephone</column-name><column-value><![CDATA[");
		sb.append(getWorkTelephone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workEmail</column-name><column-value><![CDATA[");
		sb.append(getWorkEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherEmail</column-name><column-value><![CDATA[");
		sb.append(getOtherEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactDetailsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private long _employeeId;
	private BaseModel<?> _contactDetailsRemoteModel;
}