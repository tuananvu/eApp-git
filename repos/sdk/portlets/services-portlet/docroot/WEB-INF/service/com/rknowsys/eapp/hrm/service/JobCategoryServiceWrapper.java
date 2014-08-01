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

package com.rknowsys.eapp.hrm.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobCategoryService}.
 *
 * @author Rknowsys
 * @see JobCategoryService
 * @generated
 */
public class JobCategoryServiceWrapper implements JobCategoryService,
	ServiceWrapper<JobCategoryService> {
	public JobCategoryServiceWrapper(JobCategoryService jobCategoryService) {
		_jobCategoryService = jobCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _jobCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_jobCategoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _jobCategoryService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public JobCategoryService getWrappedJobCategoryService() {
		return _jobCategoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedJobCategoryService(
		JobCategoryService jobCategoryService) {
		_jobCategoryService = jobCategoryService;
	}

	@Override
	public JobCategoryService getWrappedService() {
		return _jobCategoryService;
	}

	@Override
	public void setWrappedService(JobCategoryService jobCategoryService) {
		_jobCategoryService = jobCategoryService;
	}

	private JobCategoryService _jobCategoryService;
}