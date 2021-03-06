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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ReportingMethods service. Represents a row in the &quot;reportingmethods&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rknowsys.eapp.hrm.model.impl.ReportingMethodsImpl}.
 * </p>
 *
 * @author rknowsys
 * @see ReportingMethods
 * @see com.rknowsys.eapp.hrm.model.impl.ReportingMethodsImpl
 * @see com.rknowsys.eapp.hrm.model.impl.ReportingMethodsModelImpl
 * @generated
 */
public interface ReportingMethodsModel extends BaseModel<ReportingMethods> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a reporting methods model instance should use the {@link ReportingMethods} interface instead.
	 */

	/**
	 * Returns the primary key of this reporting methods.
	 *
	 * @return the primary key of this reporting methods
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this reporting methods.
	 *
	 * @param primaryKey the primary key of this reporting methods
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the reportingmethod ID of this reporting methods.
	 *
	 * @return the reportingmethod ID of this reporting methods
	 */
	public long getReportingmethodId();

	/**
	 * Sets the reportingmethod ID of this reporting methods.
	 *
	 * @param reportingmethodId the reportingmethod ID of this reporting methods
	 */
	public void setReportingmethodId(long reportingmethodId);

	/**
	 * Returns the company ID of this reporting methods.
	 *
	 * @return the company ID of this reporting methods
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this reporting methods.
	 *
	 * @param companyId the company ID of this reporting methods
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this reporting methods.
	 *
	 * @return the group ID of this reporting methods
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this reporting methods.
	 *
	 * @param groupId the group ID of this reporting methods
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this reporting methods.
	 *
	 * @return the create date of this reporting methods
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this reporting methods.
	 *
	 * @param createDate the create date of this reporting methods
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this reporting methods.
	 *
	 * @return the modified date of this reporting methods
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this reporting methods.
	 *
	 * @param modifiedDate the modified date of this reporting methods
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this reporting methods.
	 *
	 * @return the user ID of this reporting methods
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this reporting methods.
	 *
	 * @param userId the user ID of this reporting methods
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this reporting methods.
	 *
	 * @return the user uuid of this reporting methods
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this reporting methods.
	 *
	 * @param userUuid the user uuid of this reporting methods
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the reportingmethod name of this reporting methods.
	 *
	 * @return the reportingmethod name of this reporting methods
	 */
	@AutoEscape
	public String getReportingmethodName();

	/**
	 * Sets the reportingmethod name of this reporting methods.
	 *
	 * @param reportingmethodName the reportingmethod name of this reporting methods
	 */
	public void setReportingmethodName(String reportingmethodName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.rknowsys.eapp.hrm.model.ReportingMethods reportingMethods);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rknowsys.eapp.hrm.model.ReportingMethods> toCacheModel();

	@Override
	public com.rknowsys.eapp.hrm.model.ReportingMethods toEscapedModel();

	@Override
	public com.rknowsys.eapp.hrm.model.ReportingMethods toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}