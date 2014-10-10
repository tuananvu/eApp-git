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
 * The Blob model class for lazy loading the photograph column in Employee.
 *
 * @author rknowsys
 * @see Employee
 * @generated
 */
public class EmployeePhotographBlobModel {
	public EmployeePhotographBlobModel() {
	}

	public EmployeePhotographBlobModel(long employeeId) {
		_employeeId = employeeId;
	}

	public EmployeePhotographBlobModel(long employeeId, Blob photographBlob) {
		_employeeId = employeeId;
		_photographBlob = photographBlob;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Blob getPhotographBlob() {
		return _photographBlob;
	}

	public void setPhotographBlob(Blob photographBlob) {
		_photographBlob = photographBlob;
	}

	private long _employeeId;
	private Blob _photographBlob;
}