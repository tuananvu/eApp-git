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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContactDetails}.
 * </p>
 *
 * @author rknowsys
 * @see ContactDetails
 * @generated
 */
public class ContactDetailsWrapper implements ContactDetails,
	ModelWrapper<ContactDetails> {
	public ContactDetailsWrapper(ContactDetails contactDetails) {
		_contactDetails = contactDetails;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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
	}

	/**
	* Returns the primary key of this contact details.
	*
	* @return the primary key of this contact details
	*/
	@Override
	public long getPrimaryKey() {
		return _contactDetails.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact details.
	*
	* @param primaryKey the primary key of this contact details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contactDetails.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this contact details.
	*
	* @return the ID of this contact details
	*/
	@Override
	public long getId() {
		return _contactDetails.getId();
	}

	/**
	* Sets the ID of this contact details.
	*
	* @param id the ID of this contact details
	*/
	@Override
	public void setId(long id) {
		_contactDetails.setId(id);
	}

	/**
	* Returns the group ID of this contact details.
	*
	* @return the group ID of this contact details
	*/
	@Override
	public long getGroupId() {
		return _contactDetails.getGroupId();
	}

	/**
	* Sets the group ID of this contact details.
	*
	* @param groupId the group ID of this contact details
	*/
	@Override
	public void setGroupId(long groupId) {
		_contactDetails.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this contact details.
	*
	* @return the company ID of this contact details
	*/
	@Override
	public long getCompanyId() {
		return _contactDetails.getCompanyId();
	}

	/**
	* Sets the company ID of this contact details.
	*
	* @param companyId the company ID of this contact details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contactDetails.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this contact details.
	*
	* @return the user ID of this contact details
	*/
	@Override
	public long getUserId() {
		return _contactDetails.getUserId();
	}

	/**
	* Sets the user ID of this contact details.
	*
	* @param userId the user ID of this contact details
	*/
	@Override
	public void setUserId(long userId) {
		_contactDetails.setUserId(userId);
	}

	/**
	* Returns the user uuid of this contact details.
	*
	* @return the user uuid of this contact details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactDetails.getUserUuid();
	}

	/**
	* Sets the user uuid of this contact details.
	*
	* @param userUuid the user uuid of this contact details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_contactDetails.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this contact details.
	*
	* @return the user name of this contact details
	*/
	@Override
	public java.lang.String getUserName() {
		return _contactDetails.getUserName();
	}

	/**
	* Sets the user name of this contact details.
	*
	* @param userName the user name of this contact details
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_contactDetails.setUserName(userName);
	}

	/**
	* Returns the create date of this contact details.
	*
	* @return the create date of this contact details
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _contactDetails.getCreateDate();
	}

	/**
	* Sets the create date of this contact details.
	*
	* @param createDate the create date of this contact details
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_contactDetails.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this contact details.
	*
	* @return the modified date of this contact details
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _contactDetails.getModifiedDate();
	}

	/**
	* Sets the modified date of this contact details.
	*
	* @param modifiedDate the modified date of this contact details
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contactDetails.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the address street1 of this contact details.
	*
	* @return the address street1 of this contact details
	*/
	@Override
	public java.lang.String getAddressStreet1() {
		return _contactDetails.getAddressStreet1();
	}

	/**
	* Sets the address street1 of this contact details.
	*
	* @param addressStreet1 the address street1 of this contact details
	*/
	@Override
	public void setAddressStreet1(java.lang.String addressStreet1) {
		_contactDetails.setAddressStreet1(addressStreet1);
	}

	/**
	* Returns the address street2 of this contact details.
	*
	* @return the address street2 of this contact details
	*/
	@Override
	public java.lang.String getAddressStreet2() {
		return _contactDetails.getAddressStreet2();
	}

	/**
	* Sets the address street2 of this contact details.
	*
	* @param addressStreet2 the address street2 of this contact details
	*/
	@Override
	public void setAddressStreet2(java.lang.String addressStreet2) {
		_contactDetails.setAddressStreet2(addressStreet2);
	}

	/**
	* Returns the city of this contact details.
	*
	* @return the city of this contact details
	*/
	@Override
	public java.lang.String getCity() {
		return _contactDetails.getCity();
	}

	/**
	* Sets the city of this contact details.
	*
	* @param city the city of this contact details
	*/
	@Override
	public void setCity(java.lang.String city) {
		_contactDetails.setCity(city);
	}

	/**
	* Returns the state of this contact details.
	*
	* @return the state of this contact details
	*/
	@Override
	public java.lang.String getState() {
		return _contactDetails.getState();
	}

	/**
	* Sets the state of this contact details.
	*
	* @param state the state of this contact details
	*/
	@Override
	public void setState(java.lang.String state) {
		_contactDetails.setState(state);
	}

	/**
	* Returns the postal code of this contact details.
	*
	* @return the postal code of this contact details
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _contactDetails.getPostalCode();
	}

	/**
	* Sets the postal code of this contact details.
	*
	* @param postalCode the postal code of this contact details
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_contactDetails.setPostalCode(postalCode);
	}

	/**
	* Returns the country of this contact details.
	*
	* @return the country of this contact details
	*/
	@Override
	public java.lang.String getCountry() {
		return _contactDetails.getCountry();
	}

	/**
	* Sets the country of this contact details.
	*
	* @param country the country of this contact details
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_contactDetails.setCountry(country);
	}

	/**
	* Returns the home telephone of this contact details.
	*
	* @return the home telephone of this contact details
	*/
	@Override
	public java.lang.String getHomeTelephone() {
		return _contactDetails.getHomeTelephone();
	}

	/**
	* Sets the home telephone of this contact details.
	*
	* @param homeTelephone the home telephone of this contact details
	*/
	@Override
	public void setHomeTelephone(java.lang.String homeTelephone) {
		_contactDetails.setHomeTelephone(homeTelephone);
	}

	/**
	* Returns the mobile of this contact details.
	*
	* @return the mobile of this contact details
	*/
	@Override
	public java.lang.String getMobile() {
		return _contactDetails.getMobile();
	}

	/**
	* Sets the mobile of this contact details.
	*
	* @param mobile the mobile of this contact details
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_contactDetails.setMobile(mobile);
	}

	/**
	* Returns the work telephone of this contact details.
	*
	* @return the work telephone of this contact details
	*/
	@Override
	public java.lang.String getWorkTelephone() {
		return _contactDetails.getWorkTelephone();
	}

	/**
	* Sets the work telephone of this contact details.
	*
	* @param workTelephone the work telephone of this contact details
	*/
	@Override
	public void setWorkTelephone(java.lang.String workTelephone) {
		_contactDetails.setWorkTelephone(workTelephone);
	}

	/**
	* Returns the work email of this contact details.
	*
	* @return the work email of this contact details
	*/
	@Override
	public java.lang.String getWorkEmail() {
		return _contactDetails.getWorkEmail();
	}

	/**
	* Sets the work email of this contact details.
	*
	* @param workEmail the work email of this contact details
	*/
	@Override
	public void setWorkEmail(java.lang.String workEmail) {
		_contactDetails.setWorkEmail(workEmail);
	}

	/**
	* Returns the other email of this contact details.
	*
	* @return the other email of this contact details
	*/
	@Override
	public java.lang.String getOtherEmail() {
		return _contactDetails.getOtherEmail();
	}

	/**
	* Sets the other email of this contact details.
	*
	* @param otherEmail the other email of this contact details
	*/
	@Override
	public void setOtherEmail(java.lang.String otherEmail) {
		_contactDetails.setOtherEmail(otherEmail);
	}

	@Override
	public boolean isNew() {
		return _contactDetails.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contactDetails.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contactDetails.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contactDetails.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contactDetails.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contactDetails.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactDetails.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contactDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contactDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactDetails.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactDetailsWrapper((ContactDetails)_contactDetails.clone());
	}

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.ContactDetails contactDetails) {
		return _contactDetails.compareTo(contactDetails);
	}

	@Override
	public int hashCode() {
		return _contactDetails.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.ContactDetails> toCacheModel() {
		return _contactDetails.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.ContactDetails toEscapedModel() {
		return new ContactDetailsWrapper(_contactDetails.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.ContactDetails toUnescapedModel() {
		return new ContactDetailsWrapper(_contactDetails.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contactDetails.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactDetails.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactDetailsWrapper)) {
			return false;
		}

		ContactDetailsWrapper contactDetailsWrapper = (ContactDetailsWrapper)obj;

		if (Validator.equals(_contactDetails,
					contactDetailsWrapper._contactDetails)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContactDetails getWrappedContactDetails() {
		return _contactDetails;
	}

	@Override
	public ContactDetails getWrappedModel() {
		return _contactDetails;
	}

	@Override
	public void resetOriginalValues() {
		_contactDetails.resetOriginalValues();
	}

	private ContactDetails _contactDetails;
}