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
 * Provides a wrapper for {@link EmpSalaryComponentLocalService}.
 *
 * @author rknowsys
 * @see EmpSalaryComponentLocalService
 * @generated
 */
public class EmpSalaryComponentLocalServiceWrapper
	implements EmpSalaryComponentLocalService,
		ServiceWrapper<EmpSalaryComponentLocalService> {
	public EmpSalaryComponentLocalServiceWrapper(
		EmpSalaryComponentLocalService empSalaryComponentLocalService) {
		_empSalaryComponentLocalService = empSalaryComponentLocalService;
	}

	/**
	* Adds the emp salary component to the database. Also notifies the appropriate model listeners.
	*
	* @param empSalaryComponent the emp salary component
	* @return the emp salary component that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent addEmpSalaryComponent(
		com.rknowsys.eapp.hrm.model.EmpSalaryComponent empSalaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.addEmpSalaryComponent(empSalaryComponent);
	}

	/**
	* Creates a new emp salary component with the primary key. Does not add the emp salary component to the database.
	*
	* @param empSalaryEarningId the primary key for the new emp salary component
	* @return the new emp salary component
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent createEmpSalaryComponent(
		long empSalaryEarningId) {
		return _empSalaryComponentLocalService.createEmpSalaryComponent(empSalaryEarningId);
	}

	/**
	* Deletes the emp salary component with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empSalaryEarningId the primary key of the emp salary component
	* @return the emp salary component that was removed
	* @throws PortalException if a emp salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent deleteEmpSalaryComponent(
		long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.deleteEmpSalaryComponent(empSalaryEarningId);
	}

	/**
	* Deletes the emp salary component from the database. Also notifies the appropriate model listeners.
	*
	* @param empSalaryComponent the emp salary component
	* @return the emp salary component that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent deleteEmpSalaryComponent(
		com.rknowsys.eapp.hrm.model.EmpSalaryComponent empSalaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.deleteEmpSalaryComponent(empSalaryComponent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empSalaryComponentLocalService.dynamicQuery();
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
		return _empSalaryComponentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empSalaryComponentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empSalaryComponentLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _empSalaryComponentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empSalaryComponentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent fetchEmpSalaryComponent(
		long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.fetchEmpSalaryComponent(empSalaryEarningId);
	}

	/**
	* Returns the emp salary component with the primary key.
	*
	* @param empSalaryEarningId the primary key of the emp salary component
	* @return the emp salary component
	* @throws PortalException if a emp salary component with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent getEmpSalaryComponent(
		long empSalaryEarningId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.getEmpSalaryComponent(empSalaryEarningId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp salary components.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmpSalaryComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp salary components
	* @param end the upper bound of the range of emp salary components (not inclusive)
	* @return the range of emp salary components
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmpSalaryComponent> getEmpSalaryComponents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.getEmpSalaryComponents(start, end);
	}

	/**
	* Returns the number of emp salary components.
	*
	* @return the number of emp salary components
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpSalaryComponentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.getEmpSalaryComponentsCount();
	}

	/**
	* Updates the emp salary component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empSalaryComponent the emp salary component
	* @return the emp salary component that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmpSalaryComponent updateEmpSalaryComponent(
		com.rknowsys.eapp.hrm.model.EmpSalaryComponent empSalaryComponent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empSalaryComponentLocalService.updateEmpSalaryComponent(empSalaryComponent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empSalaryComponentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empSalaryComponentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empSalaryComponentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpSalaryComponentLocalService getWrappedEmpSalaryComponentLocalService() {
		return _empSalaryComponentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpSalaryComponentLocalService(
		EmpSalaryComponentLocalService empSalaryComponentLocalService) {
		_empSalaryComponentLocalService = empSalaryComponentLocalService;
	}

	@Override
	public EmpSalaryComponentLocalService getWrappedService() {
		return _empSalaryComponentLocalService;
	}

	@Override
	public void setWrappedService(
		EmpSalaryComponentLocalService empSalaryComponentLocalService) {
		_empSalaryComponentLocalService = empSalaryComponentLocalService;
	}

	private EmpSalaryComponentLocalService _empSalaryComponentLocalService;
}