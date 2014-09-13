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

import com.rknowsys.eapp.hrm.model.WorkExpCompany;

/**
 * The persistence interface for the WorkExpCompany service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkExpCompanyPersistenceImpl
 * @see WorkExpCompanyUtil
 * @generated
 */
public interface WorkExpCompanyPersistence extends BasePersistence<WorkExpCompany> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkExpCompanyUtil} to access the WorkExpCompany persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the WorkExpCompanies where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the WorkExpCompanies where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of WorkExpCompanies
	* @param end the upper bound of the range of WorkExpCompanies (not inclusive)
	* @return the range of matching WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the WorkExpCompanies where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of WorkExpCompanies
	* @param end the upper bound of the range of WorkExpCompanies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first WorkExpCompany in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WorkExpCompany
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a matching WorkExpCompany could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException;

	/**
	* Returns the first WorkExpCompany in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WorkExpCompany, or <code>null</code> if a matching WorkExpCompany could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last WorkExpCompany in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WorkExpCompany
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a matching WorkExpCompany could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException;

	/**
	* Returns the last WorkExpCompany in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WorkExpCompany, or <code>null</code> if a matching WorkExpCompany could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WorkExpCompanies before and after the current WorkExpCompany in the ordered set where employeeId = &#63;.
	*
	* @param workExpCompanyId the primary key of the current WorkExpCompany
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next WorkExpCompany
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a WorkExpCompany with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany[] findByemployeeId_PrevAndNext(
		long workExpCompanyId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException;

	/**
	* Removes all the WorkExpCompanies where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WorkExpCompanies where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the WorkExpCompanies where workExpCompanyId = &#63;.
	*
	* @param workExpCompanyId the work exp company ID
	* @return the matching WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findByworkExpCompanyId(
		long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the WorkExpCompanies where workExpCompanyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workExpCompanyId the work exp company ID
	* @param start the lower bound of the range of WorkExpCompanies
	* @param end the upper bound of the range of WorkExpCompanies (not inclusive)
	* @return the range of matching WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findByworkExpCompanyId(
		long workExpCompanyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the WorkExpCompanies where workExpCompanyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param workExpCompanyId the work exp company ID
	* @param start the lower bound of the range of WorkExpCompanies
	* @param end the upper bound of the range of WorkExpCompanies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findByworkExpCompanyId(
		long workExpCompanyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first WorkExpCompany in the ordered set where workExpCompanyId = &#63;.
	*
	* @param workExpCompanyId the work exp company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WorkExpCompany
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a matching WorkExpCompany could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany findByworkExpCompanyId_First(
		long workExpCompanyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException;

	/**
	* Returns the first WorkExpCompany in the ordered set where workExpCompanyId = &#63;.
	*
	* @param workExpCompanyId the work exp company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching WorkExpCompany, or <code>null</code> if a matching WorkExpCompany could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany fetchByworkExpCompanyId_First(
		long workExpCompanyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last WorkExpCompany in the ordered set where workExpCompanyId = &#63;.
	*
	* @param workExpCompanyId the work exp company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WorkExpCompany
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a matching WorkExpCompany could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany findByworkExpCompanyId_Last(
		long workExpCompanyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException;

	/**
	* Returns the last WorkExpCompany in the ordered set where workExpCompanyId = &#63;.
	*
	* @param workExpCompanyId the work exp company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching WorkExpCompany, or <code>null</code> if a matching WorkExpCompany could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany fetchByworkExpCompanyId_Last(
		long workExpCompanyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the WorkExpCompanies where workExpCompanyId = &#63; from the database.
	*
	* @param workExpCompanyId the work exp company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByworkExpCompanyId(long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WorkExpCompanies where workExpCompanyId = &#63;.
	*
	* @param workExpCompanyId the work exp company ID
	* @return the number of matching WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public int countByworkExpCompanyId(long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the WorkExpCompany in the entity cache if it is enabled.
	*
	* @param workExpCompany the WorkExpCompany
	*/
	public void cacheResult(
		com.rknowsys.eapp.hrm.model.WorkExpCompany workExpCompany);

	/**
	* Caches the WorkExpCompanies in the entity cache if it is enabled.
	*
	* @param workExpCompanies the WorkExpCompanies
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> workExpCompanies);

	/**
	* Creates a new WorkExpCompany with the primary key. Does not add the WorkExpCompany to the database.
	*
	* @param workExpCompanyId the primary key for the new WorkExpCompany
	* @return the new WorkExpCompany
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany create(
		long workExpCompanyId);

	/**
	* Removes the WorkExpCompany with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workExpCompanyId the primary key of the WorkExpCompany
	* @return the WorkExpCompany that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a WorkExpCompany with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany remove(
		long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException;

	public com.rknowsys.eapp.hrm.model.WorkExpCompany updateImpl(
		com.rknowsys.eapp.hrm.model.WorkExpCompany workExpCompany)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the WorkExpCompany with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException} if it could not be found.
	*
	* @param workExpCompanyId the primary key of the WorkExpCompany
	* @return the WorkExpCompany
	* @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a WorkExpCompany with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany findByPrimaryKey(
		long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException;

	/**
	* Returns the WorkExpCompany with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workExpCompanyId the primary key of the WorkExpCompany
	* @return the WorkExpCompany, or <code>null</code> if a WorkExpCompany with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.WorkExpCompany fetchByPrimaryKey(
		long workExpCompanyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the WorkExpCompanies.
	*
	* @return the WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the WorkExpCompanies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of WorkExpCompanies
	* @param end the upper bound of the range of WorkExpCompanies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.WorkExpCompany> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the WorkExpCompanies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of WorkExpCompanies.
	*
	* @return the number of WorkExpCompanies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}