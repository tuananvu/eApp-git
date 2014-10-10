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

import com.rknowsys.eapp.hrm.model.ContactDetails;

import java.util.List;

/**
 * The persistence utility for the ContactDetails service. This utility wraps {@link ContactDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ContactDetailsPersistence
 * @see ContactDetailsPersistenceImpl
 * @generated
 */
public class ContactDetailsUtil {
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
	public static void clearCache(ContactDetails contactDetails) {
		getPersistence().clearCache(contactDetails);
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
	public static List<ContactDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ContactDetails update(ContactDetails contactDetails)
		throws SystemException {
		return getPersistence().update(contactDetails);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ContactDetails update(ContactDetails contactDetails,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contactDetails, serviceContext);
	}

	/**
	* Returns the ContactDetails where employeeId = &#63; or throws a {@link com.rknowsys.eapp.hrm.NoSuchContactDetailsException} if it could not be found.
	*
	* @param employeeId the employee ID
	* @return the matching ContactDetails
	* @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a matching ContactDetails could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ContactDetails findByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchContactDetailsException {
		return getPersistence().findByEmployeeId(employeeId);
	}

	/**
	* Returns the ContactDetails where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param employeeId the employee ID
	* @return the matching ContactDetails, or <code>null</code> if a matching ContactDetails could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ContactDetails fetchByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmployeeId(employeeId);
	}

	/**
	* Returns the ContactDetails where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param employeeId the employee ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ContactDetails, or <code>null</code> if a matching ContactDetails could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ContactDetails fetchByEmployeeId(
		long employeeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmployeeId(employeeId, retrieveFromCache);
	}

	/**
	* Removes the ContactDetails where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @return the ContactDetails that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ContactDetails removeByEmployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchContactDetailsException {
		return getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	* Returns the number of ContactDetailses where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching ContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	* Caches the ContactDetails in the entity cache if it is enabled.
	*
	* @param contactDetails the ContactDetails
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.ContactDetails contactDetails) {
		getPersistence().cacheResult(contactDetails);
	}

	/**
	* Caches the ContactDetailses in the entity cache if it is enabled.
	*
	* @param contactDetailses the ContactDetailses
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.ContactDetails> contactDetailses) {
		getPersistence().cacheResult(contactDetailses);
	}

	/**
	* Creates a new ContactDetails with the primary key. Does not add the ContactDetails to the database.
	*
	* @param contactDetailsId the primary key for the new ContactDetails
	* @return the new ContactDetails
	*/
	public static com.rknowsys.eapp.hrm.model.ContactDetails create(
		long contactDetailsId) {
		return getPersistence().create(contactDetailsId);
	}

	/**
	* Removes the ContactDetails with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactDetailsId the primary key of the ContactDetails
	* @return the ContactDetails that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a ContactDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ContactDetails remove(
		long contactDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchContactDetailsException {
		return getPersistence().remove(contactDetailsId);
	}

	public static com.rknowsys.eapp.hrm.model.ContactDetails updateImpl(
		com.rknowsys.eapp.hrm.model.ContactDetails contactDetails)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactDetails);
	}

	/**
	* Returns the ContactDetails with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchContactDetailsException} if it could not be found.
	*
	* @param contactDetailsId the primary key of the ContactDetails
	* @return the ContactDetails
	* @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a ContactDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ContactDetails findByPrimaryKey(
		long contactDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchContactDetailsException {
		return getPersistence().findByPrimaryKey(contactDetailsId);
	}

	/**
	* Returns the ContactDetails with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactDetailsId the primary key of the ContactDetails
	* @return the ContactDetails, or <code>null</code> if a ContactDetails with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ContactDetails fetchByPrimaryKey(
		long contactDetailsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contactDetailsId);
	}

	/**
	* Returns all the ContactDetailses.
	*
	* @return the ContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ContactDetails> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ContactDetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ContactDetailses
	* @param end the upper bound of the range of ContactDetailses (not inclusive)
	* @return the range of ContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ContactDetails> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ContactDetailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ContactDetailses
	* @param end the upper bound of the range of ContactDetailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ContactDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ContactDetailses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ContactDetailses.
	*
	* @return the number of ContactDetailses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactDetailsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactDetailsPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					ContactDetailsPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactDetailsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ContactDetailsPersistence persistence) {
	}

	private static ContactDetailsPersistence _persistence;
}