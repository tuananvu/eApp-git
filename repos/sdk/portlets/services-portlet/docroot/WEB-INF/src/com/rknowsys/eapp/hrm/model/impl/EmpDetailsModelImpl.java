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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rknowsys.eapp.hrm.model.EmpDetails;
import com.rknowsys.eapp.hrm.model.EmpDetailsModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the EmpDetails service. Represents a row in the &quot;empdetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rknowsys.eapp.hrm.model.EmpDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmpDetailsImpl}.
 * </p>
 *
 * @author rknowsys
 * @see EmpDetailsImpl
 * @see com.rknowsys.eapp.hrm.model.EmpDetails
 * @see com.rknowsys.eapp.hrm.model.EmpDetailsModel
 * @generated
 */
public class EmpDetailsModelImpl extends BaseModelImpl<EmpDetails>
	implements EmpDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a emp details model instance should use the {@link com.rknowsys.eapp.hrm.model.EmpDetails} interface instead.
	 */
	public static final String TABLE_NAME = "empdetails";
	public static final Object[][] TABLE_COLUMNS = {
			{ "empdetailsId", Types.BIGINT },
			{ "employeeNo", Types.VARCHAR },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "employmentstatus", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "supervisor", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table empdetails (empdetailsId LONG not null primary key,employeeNo VARCHAR(75) null,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,title VARCHAR(75) null,employmentstatus VARCHAR(75) null,name VARCHAR(75) null,supervisor VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table empdetails";
	public static final String ORDER_BY_JPQL = " ORDER BY empDetails.empdetailsId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY empdetails.empdetailsId ASC";
	public static final String DATA_SOURCE = "hrmDataSource";
	public static final String SESSION_FACTORY = "hrmSessionFactory";
	public static final String TX_MANAGER = "hrmTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rknowsys.eapp.hrm.model.EmpDetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rknowsys.eapp.hrm.model.EmpDetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rknowsys.eapp.hrm.model.EmpDetails"));

	public EmpDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _empdetailsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpdetailsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empdetailsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmpDetails.class;
	}

	@Override
	public String getModelClassName() {
		return EmpDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empdetailsId", getEmpdetailsId());
		attributes.put("employeeNo", getEmployeeNo());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("title", getTitle());
		attributes.put("employmentstatus", getEmploymentstatus());
		attributes.put("name", getName());
		attributes.put("supervisor", getSupervisor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empdetailsId = (Long)attributes.get("empdetailsId");

		if (empdetailsId != null) {
			setEmpdetailsId(empdetailsId);
		}

		String employeeNo = (String)attributes.get("employeeNo");

		if (employeeNo != null) {
			setEmployeeNo(employeeNo);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String employmentstatus = (String)attributes.get("employmentstatus");

		if (employmentstatus != null) {
			setEmploymentstatus(employmentstatus);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String supervisor = (String)attributes.get("supervisor");

		if (supervisor != null) {
			setSupervisor(supervisor);
		}
	}

	@Override
	public long getEmpdetailsId() {
		return _empdetailsId;
	}

	@Override
	public void setEmpdetailsId(long empdetailsId) {
		_empdetailsId = empdetailsId;
	}

	@Override
	public String getEmployeeNo() {
		if (_employeeNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _employeeNo;
		}
	}

	@Override
	public void setEmployeeNo(String employeeNo) {
		_employeeNo = employeeNo;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getEmploymentstatus() {
		if (_employmentstatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _employmentstatus;
		}
	}

	@Override
	public void setEmploymentstatus(String employmentstatus) {
		_employmentstatus = employmentstatus;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getSupervisor() {
		if (_supervisor == null) {
			return StringPool.BLANK;
		}
		else {
			return _supervisor;
		}
	}

	@Override
	public void setSupervisor(String supervisor) {
		_supervisor = supervisor;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			EmpDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmpDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EmpDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmpDetailsImpl empDetailsImpl = new EmpDetailsImpl();

		empDetailsImpl.setEmpdetailsId(getEmpdetailsId());
		empDetailsImpl.setEmployeeNo(getEmployeeNo());
		empDetailsImpl.setCompanyId(getCompanyId());
		empDetailsImpl.setUserId(getUserId());
		empDetailsImpl.setCreateDate(getCreateDate());
		empDetailsImpl.setModifiedDate(getModifiedDate());
		empDetailsImpl.setFirstName(getFirstName());
		empDetailsImpl.setLastName(getLastName());
		empDetailsImpl.setTitle(getTitle());
		empDetailsImpl.setEmploymentstatus(getEmploymentstatus());
		empDetailsImpl.setName(getName());
		empDetailsImpl.setSupervisor(getSupervisor());

		empDetailsImpl.resetOriginalValues();

		return empDetailsImpl;
	}

	@Override
	public int compareTo(EmpDetails empDetails) {
		long primaryKey = empDetails.getPrimaryKey();

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

		if (!(obj instanceof EmpDetails)) {
			return false;
		}

		EmpDetails empDetails = (EmpDetails)obj;

		long primaryKey = empDetails.getPrimaryKey();

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<EmpDetails> toCacheModel() {
		EmpDetailsCacheModel empDetailsCacheModel = new EmpDetailsCacheModel();

		empDetailsCacheModel.empdetailsId = getEmpdetailsId();

		empDetailsCacheModel.employeeNo = getEmployeeNo();

		String employeeNo = empDetailsCacheModel.employeeNo;

		if ((employeeNo != null) && (employeeNo.length() == 0)) {
			empDetailsCacheModel.employeeNo = null;
		}

		empDetailsCacheModel.companyId = getCompanyId();

		empDetailsCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			empDetailsCacheModel.createDate = createDate.getTime();
		}
		else {
			empDetailsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			empDetailsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			empDetailsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		empDetailsCacheModel.firstName = getFirstName();

		String firstName = empDetailsCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			empDetailsCacheModel.firstName = null;
		}

		empDetailsCacheModel.lastName = getLastName();

		String lastName = empDetailsCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			empDetailsCacheModel.lastName = null;
		}

		empDetailsCacheModel.title = getTitle();

		String title = empDetailsCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			empDetailsCacheModel.title = null;
		}

		empDetailsCacheModel.employmentstatus = getEmploymentstatus();

		String employmentstatus = empDetailsCacheModel.employmentstatus;

		if ((employmentstatus != null) && (employmentstatus.length() == 0)) {
			empDetailsCacheModel.employmentstatus = null;
		}

		empDetailsCacheModel.name = getName();

		String name = empDetailsCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			empDetailsCacheModel.name = null;
		}

		empDetailsCacheModel.supervisor = getSupervisor();

		String supervisor = empDetailsCacheModel.supervisor;

		if ((supervisor != null) && (supervisor.length() == 0)) {
			empDetailsCacheModel.supervisor = null;
		}

		return empDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{empdetailsId=");
		sb.append(getEmpdetailsId());
		sb.append(", employeeNo=");
		sb.append(getEmployeeNo());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", employmentstatus=");
		sb.append(getEmploymentstatus());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", supervisor=");
		sb.append(getSupervisor());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rknowsys.eapp.hrm.model.EmpDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empdetailsId</column-name><column-value><![CDATA[");
		sb.append(getEmpdetailsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeNo</column-name><column-value><![CDATA[");
		sb.append(getEmployeeNo());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employmentstatus</column-name><column-value><![CDATA[");
		sb.append(getEmploymentstatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supervisor</column-name><column-value><![CDATA[");
		sb.append(getSupervisor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = EmpDetails.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EmpDetails.class
		};
	private long _empdetailsId;
	private String _employeeNo;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _title;
	private String _employmentstatus;
	private String _name;
	private String _supervisor;
	private EmpDetails _escapedModel;
}