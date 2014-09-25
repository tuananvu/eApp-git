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

import com.rknowsys.eapp.hrm.model.ImmigrationDocument;

import java.util.List;

/**
 * The persistence utility for the ImmigrationDocument service. This utility wraps {@link ImmigrationDocumentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ImmigrationDocumentPersistence
 * @see ImmigrationDocumentPersistenceImpl
 * @generated
 */
public class ImmigrationDocumentUtil {
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
	public static void clearCache(ImmigrationDocument immigrationDocument) {
		getPersistence().clearCache(immigrationDocument);
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
	public static List<ImmigrationDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ImmigrationDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ImmigrationDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ImmigrationDocument update(
		ImmigrationDocument immigrationDocument) throws SystemException {
		return getPersistence().update(immigrationDocument);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ImmigrationDocument update(
		ImmigrationDocument immigrationDocument, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(immigrationDocument, serviceContext);
	}

	/**
	* Returns all the ImmigrationDocuments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the ImmigrationDocuments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @return the range of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the ImmigrationDocuments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first ImmigrationDocument in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first ImmigrationDocument in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last ImmigrationDocument in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last ImmigrationDocument in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the ImmigrationDocuments before and after the current ImmigrationDocument in the ordered set where groupId = &#63;.
	*
	* @param immigrationDocumentId the primary key of the current ImmigrationDocument
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument[] findByGroupId_PrevAndNext(
		long immigrationDocumentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(immigrationDocumentId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the ImmigrationDocuments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of ImmigrationDocuments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the ImmigrationDocuments where immigrationDocumentId = &#63;.
	*
	* @param immigrationDocumentId the immigration document ID
	* @return the matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByimmigrationDocumentId(
		long immigrationDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByimmigrationDocumentId(immigrationDocumentId);
	}

	/**
	* Returns a range of all the ImmigrationDocuments where immigrationDocumentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param immigrationDocumentId the immigration document ID
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @return the range of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByimmigrationDocumentId(
		long immigrationDocumentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByimmigrationDocumentId(immigrationDocumentId, start,
			end);
	}

	/**
	* Returns an ordered range of all the ImmigrationDocuments where immigrationDocumentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param immigrationDocumentId the immigration document ID
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByimmigrationDocumentId(
		long immigrationDocumentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByimmigrationDocumentId(immigrationDocumentId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first ImmigrationDocument in the ordered set where immigrationDocumentId = &#63;.
	*
	* @param immigrationDocumentId the immigration document ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument findByimmigrationDocumentId_First(
		long immigrationDocumentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence()
				   .findByimmigrationDocumentId_First(immigrationDocumentId,
			orderByComparator);
	}

	/**
	* Returns the first ImmigrationDocument in the ordered set where immigrationDocumentId = &#63;.
	*
	* @param immigrationDocumentId the immigration document ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument fetchByimmigrationDocumentId_First(
		long immigrationDocumentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByimmigrationDocumentId_First(immigrationDocumentId,
			orderByComparator);
	}

	/**
	* Returns the last ImmigrationDocument in the ordered set where immigrationDocumentId = &#63;.
	*
	* @param immigrationDocumentId the immigration document ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument findByimmigrationDocumentId_Last(
		long immigrationDocumentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence()
				   .findByimmigrationDocumentId_Last(immigrationDocumentId,
			orderByComparator);
	}

	/**
	* Returns the last ImmigrationDocument in the ordered set where immigrationDocumentId = &#63;.
	*
	* @param immigrationDocumentId the immigration document ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument fetchByimmigrationDocumentId_Last(
		long immigrationDocumentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByimmigrationDocumentId_Last(immigrationDocumentId,
			orderByComparator);
	}

	/**
	* Removes all the ImmigrationDocuments where immigrationDocumentId = &#63; from the database.
	*
	* @param immigrationDocumentId the immigration document ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByimmigrationDocumentId(long immigrationDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByimmigrationDocumentId(immigrationDocumentId);
	}

	/**
	* Returns the number of ImmigrationDocuments where immigrationDocumentId = &#63;.
	*
	* @param immigrationDocumentId the immigration document ID
	* @return the number of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByimmigrationDocumentId(long immigrationDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByimmigrationDocumentId(immigrationDocumentId);
	}

	/**
	* Returns all the ImmigrationDocuments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	* Returns a range of all the ImmigrationDocuments where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @return the range of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the ImmigrationDocuments where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns the first ImmigrationDocument in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first ImmigrationDocument in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last ImmigrationDocument in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last ImmigrationDocument in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the ImmigrationDocuments before and after the current ImmigrationDocument in the ordered set where employeeId = &#63;.
	*
	* @param immigrationDocumentId the primary key of the current ImmigrationDocument
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument[] findByemployeeId_PrevAndNext(
		long immigrationDocumentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence()
				   .findByemployeeId_PrevAndNext(immigrationDocumentId,
			employeeId, orderByComparator);
	}

	/**
	* Removes all the ImmigrationDocuments where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of ImmigrationDocuments where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Caches the ImmigrationDocument in the entity cache if it is enabled.
	*
	* @param immigrationDocument the ImmigrationDocument
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.ImmigrationDocument immigrationDocument) {
		getPersistence().cacheResult(immigrationDocument);
	}

	/**
	* Caches the ImmigrationDocuments in the entity cache if it is enabled.
	*
	* @param immigrationDocuments the ImmigrationDocuments
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> immigrationDocuments) {
		getPersistence().cacheResult(immigrationDocuments);
	}

	/**
	* Creates a new ImmigrationDocument with the primary key. Does not add the ImmigrationDocument to the database.
	*
	* @param immigrationDocumentId the primary key for the new ImmigrationDocument
	* @return the new ImmigrationDocument
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument create(
		long immigrationDocumentId) {
		return getPersistence().create(immigrationDocumentId);
	}

	/**
	* Removes the ImmigrationDocument with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param immigrationDocumentId the primary key of the ImmigrationDocument
	* @return the ImmigrationDocument that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument remove(
		long immigrationDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence().remove(immigrationDocumentId);
	}

	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument updateImpl(
		com.rknowsys.eapp.hrm.model.ImmigrationDocument immigrationDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(immigrationDocument);
	}

	/**
	* Returns the ImmigrationDocument with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException} if it could not be found.
	*
	* @param immigrationDocumentId the primary key of the ImmigrationDocument
	* @return the ImmigrationDocument
	* @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument findByPrimaryKey(
		long immigrationDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException {
		return getPersistence().findByPrimaryKey(immigrationDocumentId);
	}

	/**
	* Returns the ImmigrationDocument with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param immigrationDocumentId the primary key of the ImmigrationDocument
	* @return the ImmigrationDocument, or <code>null</code> if a ImmigrationDocument with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.ImmigrationDocument fetchByPrimaryKey(
		long immigrationDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(immigrationDocumentId);
	}

	/**
	* Returns all the ImmigrationDocuments.
	*
	* @return the ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ImmigrationDocuments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @return the range of ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ImmigrationDocuments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ImmigrationDocuments
	* @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.ImmigrationDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ImmigrationDocuments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ImmigrationDocuments.
	*
	* @return the number of ImmigrationDocuments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ImmigrationDocumentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ImmigrationDocumentPersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					ImmigrationDocumentPersistence.class.getName());

			ReferenceRegistry.registerReference(ImmigrationDocumentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ImmigrationDocumentPersistence persistence) {
	}

	private static ImmigrationDocumentPersistence _persistence;
}