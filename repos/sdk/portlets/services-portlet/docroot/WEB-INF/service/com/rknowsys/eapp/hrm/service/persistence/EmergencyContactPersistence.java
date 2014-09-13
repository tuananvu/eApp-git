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
 * The persistence interface for the EmergencyContact service.
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
	 * Never modify or reference this interface directly. Always use {@link EmergencyContactUtil} to access the EmergencyContact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the EmergencyContacts where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @return the matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemergencyContactId(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmergencyContacts where emergencyContactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emergencyContactId the emergency contact ID
	* @param start the lower bound of the range of EmergencyContacts
	* @param end the upper bound of the range of EmergencyContacts (not inclusive)
	* @return the range of matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemergencyContactId(
		long emergencyContactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmergencyContacts where emergencyContactId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emergencyContactId the emergency contact ID
	* @param start the lower bound of the range of EmergencyContacts
	* @param end the upper bound of the range of EmergencyContacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemergencyContactId(
		long emergencyContactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmergencyContact in the ordered set where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact findByemergencyContactId_First(
		long emergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	/**
	* Returns the first EmergencyContact in the ordered set where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact fetchByemergencyContactId_First(
		long emergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmergencyContact in the ordered set where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact findByemergencyContactId_Last(
		long emergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	/**
	* Returns the last EmergencyContact in the ordered set where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact fetchByemergencyContactId_Last(
		long emergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmergencyContacts where emergencyContactId = &#63; from the database.
	*
	* @param emergencyContactId the emergency contact ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemergencyContactId(long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmergencyContacts where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @return the number of matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public int countByemergencyContactId(long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmergencyContacts where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the EmergencyContacts where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmergencyContacts
	* @param end the upper bound of the range of EmergencyContacts (not inclusive)
	* @return the range of matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmergencyContacts where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of EmergencyContacts
	* @param end the upper bound of the range of EmergencyContacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	/**
	* Returns the first EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	/**
	* Returns the last EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmergencyContacts before and after the current EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param emergencyContactId the primary key of the current EmergencyContact
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact[] findByemployeeId_PrevAndNext(
		long emergencyContactId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	/**
	* Removes all the EmergencyContacts where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmergencyContacts where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the EmergencyContact in the entity cache if it is enabled.
	*
	* @param emergencyContact the EmergencyContact
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact);

	/**
	* Caches the EmergencyContacts in the entity cache if it is enabled.
	*
	* @param emergencyContacts the EmergencyContacts
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> emergencyContacts);

	/**
	* Creates a new EmergencyContact with the primary key. Does not add the EmergencyContact to the database.
	*
	* @param emergencyContactId the primary key for the new EmergencyContact
	* @return the new EmergencyContact
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact create(
		long emergencyContactId);

	/**
	* Removes the EmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emergencyContactId the primary key of the EmergencyContact
	* @return the EmergencyContact that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact remove(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	public com.rknowsys.eapp.hrm.model.EmergencyContact updateImpl(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the EmergencyContact with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmergencyContactException} if it could not be found.
	*
	* @param emergencyContactId the primary key of the EmergencyContact
	* @return the EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact findByPrimaryKey(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;

	/**
	* Returns the EmergencyContact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param emergencyContactId the primary key of the EmergencyContact
	* @return the EmergencyContact, or <code>null</code> if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.EmergencyContact fetchByPrimaryKey(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the EmergencyContacts.
	*
	* @return the EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the EmergencyContacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of EmergencyContacts
	* @param end the upper bound of the range of EmergencyContacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the EmergencyContacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of EmergencyContacts.
	*
	* @return the number of EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}