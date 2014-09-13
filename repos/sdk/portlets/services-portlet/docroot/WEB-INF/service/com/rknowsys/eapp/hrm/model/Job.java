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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Job service. Represents a row in the &quot;hrm_Job&quot; database table, with each column mapped to a property of this class.
 *
 * @author rknowsys
 * @see JobModel
 * @see com.rknowsys.eapp.hrm.model.impl.JobImpl
 * @see com.rknowsys.eapp.hrm.model.impl.JobModelImpl
 * @generated
 */
public interface Job extends JobModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.rknowsys.eapp.hrm.model.impl.JobImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.rknowsys.eapp.hrm.model.JobTitle getJobTitle()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.rknowsys.eapp.hrm.model.JobCategory getJobCategory()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.rknowsys.eapp.hrm.model.EmploymentStatus getEmploymentStatus()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.rknowsys.eapp.hrm.model.Location getLocation()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.rknowsys.eapp.hrm.model.SubUnit getSubUnit()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}