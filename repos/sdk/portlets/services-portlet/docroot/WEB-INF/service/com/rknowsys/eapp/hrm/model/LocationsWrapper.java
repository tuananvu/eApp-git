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
 * This class is a wrapper for {@link Locations}.
 * </p>
 *
 * @author rknowsys
 * @see Locations
 * @generated
 */
public class LocationsWrapper implements Locations, ModelWrapper<Locations> {
	public LocationsWrapper(Locations locations) {
		_locations = locations;
	}

	@Override
	public Class<?> getModelClass() {
		return Locations.class;
	}

	@Override
	public String getModelClassName() {
		return Locations.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("city", getCity());
		attributes.put("address", getAddress());
		attributes.put("postalcode", getPostalcode());
		attributes.put("phone", getPhone());
		attributes.put("fax", getFax());
		attributes.put("notes", getNotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String postalcode = (String)attributes.get("postalcode");

		if (postalcode != null) {
			setPostalcode(postalcode);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String fax = (String)attributes.get("fax");

		if (fax != null) {
			setFax(fax);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	/**
	* Returns the primary key of this locations.
	*
	* @return the primary key of this locations
	*/
	@Override
	public long getPrimaryKey() {
		return _locations.getPrimaryKey();
	}

	/**
	* Sets the primary key of this locations.
	*
	* @param primaryKey the primary key of this locations
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_locations.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this locations.
	*
	* @return the ID of this locations
	*/
	@Override
	public long getId() {
		return _locations.getId();
	}

	/**
	* Sets the ID of this locations.
	*
	* @param id the ID of this locations
	*/
	@Override
	public void setId(long id) {
		_locations.setId(id);
	}

	/**
	* Returns the company ID of this locations.
	*
	* @return the company ID of this locations
	*/
	@Override
	public long getCompanyId() {
		return _locations.getCompanyId();
	}

	/**
	* Sets the company ID of this locations.
	*
	* @param companyId the company ID of this locations
	*/
	@Override
	public void setCompanyId(long companyId) {
		_locations.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this locations.
	*
	* @return the group ID of this locations
	*/
	@Override
	public long getGroupId() {
		return _locations.getGroupId();
	}

	/**
	* Sets the group ID of this locations.
	*
	* @param groupId the group ID of this locations
	*/
	@Override
	public void setGroupId(long groupId) {
		_locations.setGroupId(groupId);
	}

	/**
	* Returns the create date of this locations.
	*
	* @return the create date of this locations
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _locations.getCreateDate();
	}

	/**
	* Sets the create date of this locations.
	*
	* @param createDate the create date of this locations
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_locations.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this locations.
	*
	* @return the modified date of this locations
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _locations.getModifiedDate();
	}

	/**
	* Sets the modified date of this locations.
	*
	* @param modifiedDate the modified date of this locations
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_locations.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this locations.
	*
	* @return the user ID of this locations
	*/
	@Override
	public long getUserId() {
		return _locations.getUserId();
	}

	/**
	* Sets the user ID of this locations.
	*
	* @param userId the user ID of this locations
	*/
	@Override
	public void setUserId(long userId) {
		_locations.setUserId(userId);
	}

	/**
	* Returns the user uuid of this locations.
	*
	* @return the user uuid of this locations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _locations.getUserUuid();
	}

	/**
	* Sets the user uuid of this locations.
	*
	* @param userUuid the user uuid of this locations
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_locations.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this locations.
	*
	* @return the name of this locations
	*/
	@Override
	public java.lang.String getName() {
		return _locations.getName();
	}

	/**
	* Sets the name of this locations.
	*
	* @param name the name of this locations
	*/
	@Override
	public void setName(java.lang.String name) {
		_locations.setName(name);
	}

	/**
	* Returns the country of this locations.
	*
	* @return the country of this locations
	*/
	@Override
	public java.lang.String getCountry() {
		return _locations.getCountry();
	}

	/**
	* Sets the country of this locations.
	*
	* @param country the country of this locations
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_locations.setCountry(country);
	}

	/**
	* Returns the state of this locations.
	*
	* @return the state of this locations
	*/
	@Override
	public java.lang.String getState() {
		return _locations.getState();
	}

	/**
	* Sets the state of this locations.
	*
	* @param state the state of this locations
	*/
	@Override
	public void setState(java.lang.String state) {
		_locations.setState(state);
	}

	/**
	* Returns the city of this locations.
	*
	* @return the city of this locations
	*/
	@Override
	public java.lang.String getCity() {
		return _locations.getCity();
	}

	/**
	* Sets the city of this locations.
	*
	* @param city the city of this locations
	*/
	@Override
	public void setCity(java.lang.String city) {
		_locations.setCity(city);
	}

	/**
	* Returns the address of this locations.
	*
	* @return the address of this locations
	*/
	@Override
	public java.lang.String getAddress() {
		return _locations.getAddress();
	}

	/**
	* Sets the address of this locations.
	*
	* @param address the address of this locations
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_locations.setAddress(address);
	}

	/**
	* Returns the postalcode of this locations.
	*
	* @return the postalcode of this locations
	*/
	@Override
	public java.lang.String getPostalcode() {
		return _locations.getPostalcode();
	}

	/**
	* Sets the postalcode of this locations.
	*
	* @param postalcode the postalcode of this locations
	*/
	@Override
	public void setPostalcode(java.lang.String postalcode) {
		_locations.setPostalcode(postalcode);
	}

	/**
	* Returns the phone of this locations.
	*
	* @return the phone of this locations
	*/
	@Override
	public java.lang.String getPhone() {
		return _locations.getPhone();
	}

	/**
	* Sets the phone of this locations.
	*
	* @param phone the phone of this locations
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_locations.setPhone(phone);
	}

	/**
	* Returns the fax of this locations.
	*
	* @return the fax of this locations
	*/
	@Override
	public java.lang.String getFax() {
		return _locations.getFax();
	}

	/**
	* Sets the fax of this locations.
	*
	* @param fax the fax of this locations
	*/
	@Override
	public void setFax(java.lang.String fax) {
		_locations.setFax(fax);
	}

	/**
	* Returns the notes of this locations.
	*
	* @return the notes of this locations
	*/
	@Override
	public java.lang.String getNotes() {
		return _locations.getNotes();
	}

	/**
	* Sets the notes of this locations.
	*
	* @param notes the notes of this locations
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_locations.setNotes(notes);
	}

	@Override
	public boolean isNew() {
		return _locations.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_locations.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _locations.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_locations.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _locations.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _locations.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_locations.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _locations.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_locations.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_locations.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_locations.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LocationsWrapper((Locations)_locations.clone());
	}

	@Override
	public int compareTo(com.rknowsys.eapp.hrm.model.Locations locations) {
		return _locations.compareTo(locations);
	}

	@Override
	public int hashCode() {
		return _locations.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rknowsys.eapp.hrm.model.Locations> toCacheModel() {
		return _locations.toCacheModel();
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Locations toEscapedModel() {
		return new LocationsWrapper(_locations.toEscapedModel());
	}

	@Override
	public com.rknowsys.eapp.hrm.model.Locations toUnescapedModel() {
		return new LocationsWrapper(_locations.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _locations.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _locations.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_locations.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocationsWrapper)) {
			return false;
		}

		LocationsWrapper locationsWrapper = (LocationsWrapper)obj;

		if (Validator.equals(_locations, locationsWrapper._locations)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Locations getWrappedLocations() {
		return _locations;
	}

	@Override
	public Locations getWrappedModel() {
		return _locations;
	}

	@Override
	public void resetOriginalValues() {
		_locations.resetOriginalValues();
	}

	private Locations _locations;
}