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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;
import com.rknowsys.eapp.hrm.model.JobCategory;
import com.rknowsys.eapp.hrm.model.JobTitle;
import com.rknowsys.eapp.hrm.model.Location;
import com.rknowsys.eapp.hrm.model.SubUnit;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SubUnitLocalServiceUtil;

/**
 * The extended model implementation for the Job service. Represents a row in
 * the &quot;hrm_Job&quot; database table, with each column mapped to a property
 * of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.rknowsys.eapp.hrm.model.Job} interface.
 * </p>
 * 
 * @author rknowsys
 */
public class JobImpl extends JobBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this class directly. All methods that expect a job model
	 * instance should use the {@link com.rknowsys.eapp.hrm.model.Job} interface
	 * instead.
	 */
	public JobImpl() {
	}

	public JobTitle getJobTitle() throws PortalException, SystemException {
		return JobTitleLocalServiceUtil.getJobTitle(getJobTitleId());
	}

	public JobCategory getJobCategory() throws PortalException, SystemException {
		return JobCategoryLocalServiceUtil.getJobCategory(getJobCategoryId());
	}

	public EmploymentStatus getEmploymentStatus() throws PortalException,
			SystemException {
		return EmploymentStatusLocalServiceUtil
				.getEmploymentStatus(getEmploymentStatusId());
	}

	public Location getLocation() throws PortalException, SystemException {
		return LocationLocalServiceUtil.getLocation(getLocationId());
	}

	public SubUnit getSubUnit() throws PortalException, SystemException {
		return SubUnitLocalServiceUtil.getSubUnit(getSubUnitId());
	}
}