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

package com.rknowsys.eapp.hrm.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rknowsys.eapp.hrm.model.EmergencyContact;

/**
 * The persistence interface for the emergency contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmergencyContactPersistenceImpl
 * @see EmergencyContactUtil
 * @generated
 */
public interface EmergencyContactPersistence extends BasePersistence<EmergencyContact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmergencyContactUtil} to access the emergency contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the emergency contact in the entity cache if it is enabled.
	*
	* @param emergencyContact the emergency contact
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact);

	/**
	* Caches the emergency contacts in the entity cache if it is enabled.
	*
	* @param emergencyContacts the emergency contacts
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> emergencyContacts);

	/**
	* Creates a new emergency contact with the primary key. Does not add the emergency contact to the database.
	*
	* @param id the primary key for the new emergency contact
	* @return the new emergency contact
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact create(long id);

	/**
	* Removes the emergency contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the emergency contact
	* @return the emergency contact that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a emergency contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	public com.rknowsys.eapp.hrm.model.EmergencyContact updateImpl(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the emergency contact with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmergencyContactException} if it could not be found.
	*
	* @param id the primary key of the emergency contact
	* @return the emergency contact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a emergency contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	/**
	* Returns the emergency contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the emergency contact
	* @return the emergency contact, or <code>null</code> if a emergency contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the emergency contacts.
	*
	* @return the emergency contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the emergency contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emergency contacts
	* @param end the upper bound of the range of emergency contacts (not inclusive)
	* @return the range of emergency contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the emergency contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emergency contacts
	* @param end the upper bound of the range of emergency contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emergency contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the emergency contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of emergency contacts.
	*
	* @return the number of emergency contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}