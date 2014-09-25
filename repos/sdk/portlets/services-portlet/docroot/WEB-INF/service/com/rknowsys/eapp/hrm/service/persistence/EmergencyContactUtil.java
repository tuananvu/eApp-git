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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rknowsys.eapp.hrm.model.EmergencyContact;

import java.util.List;

/**
 * The persistence utility for the EmergencyContact service. This utility wraps {@link EmergencyContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmergencyContactPersistence
 * @see EmergencyContactPersistenceImpl
 * @generated
 */
public class EmergencyContactUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(EmergencyContact emergencyContact) {
		getPersistence().clearCache(emergencyContact);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmergencyContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmergencyContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmergencyContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmergencyContact update(EmergencyContact emergencyContact)
		throws SystemException {
		return getPersistence().update(emergencyContact);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmergencyContact update(EmergencyContact emergencyContact,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(emergencyContact, serviceContext);
	}

	/**
	* Returns all the EmergencyContacts where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @return the matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemergencyContactId(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemergencyContactId(emergencyContactId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemergencyContactId(
		long emergencyContactId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemergencyContactId(emergencyContactId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemergencyContactId(
		long emergencyContactId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemergencyContactId(emergencyContactId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first EmergencyContact in the ordered set where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact findByemergencyContactId_First(
		long emergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException {
		return getPersistence()
				   .findByemergencyContactId_First(emergencyContactId,
			orderByComparator);
	}

	/**
	* Returns the first EmergencyContact in the ordered set where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact fetchByemergencyContactId_First(
		long emergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemergencyContactId_First(emergencyContactId,
			orderByComparator);
	}

	/**
	* Returns the last EmergencyContact in the ordered set where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact findByemergencyContactId_Last(
		long emergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException {
		return getPersistence()
				   .findByemergencyContactId_Last(emergencyContactId,
			orderByComparator);
	}

	/**
	* Returns the last EmergencyContact in the ordered set where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact fetchByemergencyContactId_Last(
		long emergencyContactId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemergencyContactId_Last(emergencyContactId,
			orderByComparator);
	}

	/**
	* Removes all the EmergencyContacts where emergencyContactId = &#63; from the database.
	*
	* @param emergencyContactId the emergency contact ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemergencyContactId(long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemergencyContactId(emergencyContactId);
	}

	/**
	* Returns the number of EmergencyContacts where emergencyContactId = &#63;.
	*
	* @param emergencyContactId the emergency contact ID
	* @return the number of matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemergencyContactId(long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemergencyContactId(emergencyContactId);
	}

	/**
	* Returns all the EmergencyContacts where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns the first EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last EmergencyContact in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

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
	public static com.rknowsys.eapp.hrm.model.EmergencyContact[] findByemployeeId_PrevAndNext(
		long emergencyContactId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(emergencyContactId,
			employeeId, orderByComparator);
	}

	/**
	* Removes all the EmergencyContacts where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of EmergencyContacts where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Caches the EmergencyContact in the entity cache if it is enabled.
	*
	* @param emergencyContact the EmergencyContact
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact) {
		getPersistence().cacheResult(emergencyContact);
	}

	/**
	* Caches the EmergencyContacts in the entity cache if it is enabled.
	*
	* @param emergencyContacts the EmergencyContacts
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> emergencyContacts) {
		getPersistence().cacheResult(emergencyContacts);
	}

	/**
	* Creates a new EmergencyContact with the primary key. Does not add the EmergencyContact to the database.
	*
	* @param emergencyContactId the primary key for the new EmergencyContact
	* @return the new EmergencyContact
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact create(
		long emergencyContactId) {
		return getPersistence().create(emergencyContactId);
	}

	/**
	* Removes the EmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param emergencyContactId the primary key of the EmergencyContact
	* @return the EmergencyContact that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact remove(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException {
		return getPersistence().remove(emergencyContactId);
	}

	public static com.rknowsys.eapp.hrm.model.EmergencyContact updateImpl(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(emergencyContact);
	}

	/**
	* Returns the EmergencyContact with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmergencyContactException} if it could not be found.
	*
	* @param emergencyContactId the primary key of the EmergencyContact
	* @return the EmergencyContact
	* @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact findByPrimaryKey(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmergencyContactException {
		return getPersistence().findByPrimaryKey(emergencyContactId);
	}

	/**
	* Returns the EmergencyContact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param emergencyContactId the primary key of the EmergencyContact
	* @return the EmergencyContact, or <code>null</code> if a EmergencyContact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.EmergencyContact fetchByPrimaryKey(
		long emergencyContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(emergencyContactId);
	}

	/**
	* Returns all the EmergencyContacts.
	*
	* @return the EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rknowsys.eapp.hrm.model.EmergencyContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the EmergencyContacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of EmergencyContacts.
	*
	* @return the number of EmergencyContacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmergencyContactPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmergencyContactPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmergencyContactPersistence.class.getName());

			ReferenceRegistry.registerReference(EmergencyContactUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmergencyContactPersistence persistence) {
	}

	private static EmergencyContactPersistence _persistence;
}