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
 * Provides a wrapper for {@link WorkExpCompanyLocalService}.
 *
 * @author rknowsys
 * @see WorkExpCompanyLocalService
 * @generated
 */
public class WorkExpCompanyLocalServiceWrapper
	implements WorkExpCompanyLocalService,
		ServiceWrapper<WorkExpCompanyLocalService> {
	public WorkExpCompanyLocalServiceWrapper(
		WorkExpCompanyLocalService workExpCompanyLocalService) {
		_workExpCompanyLocalService = workExpCompanyLocalService;
	}

	/**
	* Adds the WorkExpCompany to the database. Also notifies the appropriate model listeners.
	*
	* @param workExpCompany the WorkExpCompany
	* @return the WorkExpCompany that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkExpCompany addWorkExpCompany(
		com.rknowsys.eapp.hrm.model.WorkExpCompany workExpCompany)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.addWorkExpCompany(workExpCompany);
	}

	/**
	* Creates a new WorkExpCompany with the primary key. Does not add the WorkExpCompany to the database.
	*
	* @param workExpCompanyId the primary key for the new WorkExpCompany
	* @return the new WorkExpCompany
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkExpCompany createWorkExpCompany(
		long workExpCompanyId) {
		return _workExpCompanyLocalService.createWorkExpCompany(workExpCompanyId);
	}

	/**
	* Deletes the WorkExpCompany with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workExpCompanyId the primary key of the WorkExpCompany
	* @return the WorkExpCompany that was removed
	* @throws PortalException if a WorkExpCompany with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkExpCompany deleteWorkExpCompany(
		long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.deleteWorkExpCompany(workExpCompanyId);
	}

	/**
	* Deletes the WorkExpCompany from the database. Also notifies the appropriate model listeners.
	*
	* @param workExpCompany the WorkExpCompany
	* @return the WorkExpCompany that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkExpCompany deleteWorkExpCompany(
		com.rknowsys.eapp.hrm.model.WorkExpCompany workExpCompany)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.deleteWorkExpCompany(workExpCompany);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workExpCompanyLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.WorkExpCompany fetchWorkExpCompany(
		long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.fetchWorkExpCompany(workExpCompanyId);
	}

	/**
	* Returns the WorkExpCompany with the primary key.
	*
	* @param workExpCompanyId the primary key of the WorkExpCompany
	* @return the WorkExpCompany
	* @throws PortalException if a WorkExpCompany with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkExpCompany getWorkExpCompany(
		long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.getWorkExpCompany(workExpCompanyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the WorkExpCompanies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WorkExpCompanies
	* @param end the upper bound of the range of WorkExpCompanies (not inclusive)
	* @return the range of WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> getWorkExpCompanies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.getWorkExpCompanies(start, end);
	}

	/**
	* Returns the number of WorkExpCompanies.
	*
	* @return the number of WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkExpCompaniesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.getWorkExpCompaniesCount();
	}

	/**
	* Updates the WorkExpCompany in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workExpCompany the WorkExpCompany
	* @return the WorkExpCompany that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.WorkExpCompany updateWorkExpCompany(
		com.rknowsys.eapp.hrm.model.WorkExpCompany workExpCompany)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.updateWorkExpCompany(workExpCompany);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _workExpCompanyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_workExpCompanyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _workExpCompanyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> getEmployeeWorkExpCompanys(
		long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workExpCompanyLocalService.getEmployeeWorkExpCompanys(employeeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WorkExpCompanyLocalService getWrappedWorkExpCompanyLocalService() {
		return _workExpCompanyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWorkExpCompanyLocalService(
		WorkExpCompanyLocalService workExpCompanyLocalService) {
		_workExpCompanyLocalService = workExpCompanyLocalService;
	}

	@Override
	public WorkExpCompanyLocalService getWrappedService() {
		return _workExpCompanyLocalService;
	}

	@Override
	public void setWrappedService(
		WorkExpCompanyLocalService workExpCompanyLocalService) {
		_workExpCompanyLocalService = workExpCompanyLocalService;
	}

	private WorkExpCompanyLocalService _workExpCompanyLocalService;
}