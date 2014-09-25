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

import com.rknowsys.eapp.hrm.model.Dependent;

/**
 * The persistence interface for the dependent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see DependentPersistenceImpl
 * @see DependentUtil
 * @generated
 */
public interface DependentPersistence extends BasePersistence<Dependent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DependentUtil} to access the dependent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dependents where dependentId = &#63;.
	*
	* @param dependentId the dependent ID
	* @return the matching dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findBydependentId(
		long dependentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dependents where dependentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dependentId the dependent ID
	* @param start the lower bound of the range of dependents
	* @param end the upper bound of the range of dependents (not inclusive)
	* @return the range of matching dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findBydependentId(
		long dependentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dependents where dependentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dependentId the dependent ID
	* @param start the lower bound of the range of dependents
	* @param end the upper bound of the range of dependents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findBydependentId(
		long dependentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dependent in the ordered set where dependentId = &#63;.
	*
	* @param dependentId the dependent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dependent
	* @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a matching dependent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent findBydependentId_First(
		long dependentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDependentException;

	/**
	* Returns the first dependent in the ordered set where dependentId = &#63;.
	*
	* @param dependentId the dependent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dependent, or <code>null</code> if a matching dependent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent fetchBydependentId_First(
		long dependentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dependent in the ordered set where dependentId = &#63;.
	*
	* @param dependentId the dependent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dependent
	* @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a matching dependent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent findBydependentId_Last(
		long dependentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDependentException;

	/**
	* Returns the last dependent in the ordered set where dependentId = &#63;.
	*
	* @param dependentId the dependent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dependent, or <code>null</code> if a matching dependent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent fetchBydependentId_Last(
		long dependentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dependents where dependentId = &#63; from the database.
	*
	* @param dependentId the dependent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBydependentId(long dependentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dependents where dependentId = &#63;.
	*
	* @param dependentId the dependent ID
	* @return the number of matching dependents
	* @throws SystemException if a system exception occurred
	*/
	public int countBydependentId(long dependentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dependents where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dependents where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of dependents
	* @param end the upper bound of the range of dependents (not inclusive)
	* @return the range of matching dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dependents where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of dependents
	* @param end the upper bound of the range of dependents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dependent in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dependent
	* @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a matching dependent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDependentException;

	/**
	* Returns the first dependent in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dependent, or <code>null</code> if a matching dependent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dependent in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dependent
	* @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a matching dependent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDependentException;

	/**
	* Returns the last dependent in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dependent, or <code>null</code> if a matching dependent could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dependents before and after the current dependent in the ordered set where employeeId = &#63;.
	*
	* @param dependentId the primary key of the current dependent
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dependent
	* @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a dependent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent[] findByemployeeId_PrevAndNext(
		long dependentId, long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDependentException;

	/**
	* Removes all the dependents where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dependents where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching dependents
	* @throws SystemException if a system exception occurred
	*/
	public int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dependent in the entity cache if it is enabled.
	*
	* @param dependent the dependent
	*/
	public void cacheResult(com.rknowsys.eapp.hrm.model.Dependent dependent);

	/**
	* Caches the dependents in the entity cache if it is enabled.
	*
	* @param dependents the dependents
	*/
	public void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Dependent> dependents);

	/**
	* Creates a new dependent with the primary key. Does not add the dependent to the database.
	*
	* @param dependentId the primary key for the new dependent
	* @return the new dependent
	*/
	public com.rknowsys.eapp.hrm.model.Dependent create(long dependentId);

	/**
	* Removes the dependent with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dependentId the primary key of the dependent
	* @return the dependent that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a dependent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent remove(long dependentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDependentException;

	public com.rknowsys.eapp.hrm.model.Dependent updateImpl(
		com.rknowsys.eapp.hrm.model.Dependent dependent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dependent with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchDependentException} if it could not be found.
	*
	* @param dependentId the primary key of the dependent
	* @return the dependent
	* @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a dependent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent findByPrimaryKey(
		long dependentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchDependentException;

	/**
	* Returns the dependent with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dependentId the primary key of the dependent
	* @return the dependent, or <code>null</code> if a dependent with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rknowsys.eapp.hrm.model.Dependent fetchByPrimaryKey(
		long dependentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dependents.
	*
	* @return the dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dependents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dependents
	* @param end the upper bound of the range of dependents (not inclusive)
	* @return the range of dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dependents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.DependentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dependents
	* @param end the upper bound of the range of dependents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dependents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rknowsys.eapp.hrm.model.Dependent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dependents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dependents.
	*
	* @return the number of dependents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}