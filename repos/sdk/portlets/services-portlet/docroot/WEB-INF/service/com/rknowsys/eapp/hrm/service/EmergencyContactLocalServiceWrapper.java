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
 * Provides a wrapper for {@link EmergencyContactLocalService}.
 *
 * @author rknowsys
 * @see EmergencyContactLocalService
 * @generated
 */
public class EmergencyContactLocalServiceWrapper
	implements EmergencyContactLocalService,
		ServiceWrapper<EmergencyContactLocalService> {
	public EmergencyContactLocalServiceWrapper(
		EmergencyContactLocalService emergencyContactLocalService) {
		_emergencyContactLocalService = emergencyContactLocalService;
	}

	/**
	* Adds the EmergencyContact to the database. Also notifies the appropriate model listeners.
	*
	* @param emergencyContact the EmergencyContact
	* @return the EmergencyContact that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact addEmergencyContact(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.addEmergencyContact(emergencyContact);
	}

	/**
	* Creates a new EmergencyContact with the primary key. Does not add the EmergencyContact to the database.
	*
	* @param emergencyContactId the primary key for the new EmergencyContact
	* @return the new EmergencyContact
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact createEmergencyContact(
		long emergencyContactId) {
		return _emergencyContactLocalService.createEmergencyContact(emergencyContactId);
	}

	/**
	* Deletes the EmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emergencyContactId the primary key of the EmergencyContact
	* @return the EmergencyContact that was removed
	* @throws PortalException if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact deleteEmergencyContact(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.deleteEmergencyContact(emergencyContactId);
	}

	/**
	* Deletes the EmergencyContact from the database. Also notifies the appropriate model listeners.
	*
	* @param emergencyContact the EmergencyContact
	* @return the EmergencyContact that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact deleteEmergencyContact(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.deleteEmergencyContact(emergencyContact);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emergencyContactLocalService.dynamicQuery();
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
		return _emergencyContactLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _emergencyContactLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _emergencyContactLocalService.dynamicQuery(dynamicQuery, start,
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
		return _emergencyContactLocalService.dynamicQueryCount(dynamicQuery);
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
		return _emergencyContactLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact fetchEmergencyContact(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.fetchEmergencyContact(emergencyContactId);
	}

	/**
	* Returns the EmergencyContact with the primary key.
	*
	* @param emergencyContactId the primary key of the EmergencyContact
	* @return the EmergencyContact
	* @throws PortalException if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact getEmergencyContact(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.getEmergencyContact(emergencyContactId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the EmergencyContacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmergencyContacts
	* @param end the upper bound of the range of EmergencyContacts (not inclusive)
	* @return the range of EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> getEmergencyContacts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.getEmergencyContacts(start, end);
	}

	/**
	* Returns the number of EmergencyContacts.
	*
	* @return the number of EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmergencyContactsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.getEmergencyContactsCount();
	}

	/**
	* Updates the EmergencyContact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param emergencyContact the EmergencyContact
	* @return the EmergencyContact that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.EmergencyContact updateEmergencyContact(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.updateEmergencyContact(emergencyContact);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _emergencyContactLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_emergencyContactLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _emergencyContactLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> getEmployeeEmergencyContacts(
		long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _emergencyContactLocalService.getEmployeeEmergencyContacts(employeeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmergencyContactLocalService getWrappedEmergencyContactLocalService() {
		return _emergencyContactLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmergencyContactLocalService(
		EmergencyContactLocalService emergencyContactLocalService) {
		_emergencyContactLocalService = emergencyContactLocalService;
	}

	@Override
	public EmergencyContactLocalService getWrappedService() {
		return _emergencyContactLocalService;
	}

	@Override
	public void setWrappedService(
		EmergencyContactLocalService emergencyContactLocalService) {
		_emergencyContactLocalService = emergencyContactLocalService;
	}

	private EmergencyContactLocalService _emergencyContactLocalService;
}