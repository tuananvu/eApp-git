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

import com.rknowsys.eapp.hrm.model.Employee;

import java.util.List;

/**
 * The persistence utility for the Employee service. This utility wraps {@link EmployeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmployeePersistence
 * @see EmployeePersistenceImpl
 * @generated
 */
public class EmployeeUtil {
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
	public static void clearCache(Employee employee) {
		getPersistence().clearCache(employee);
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
	public static List<Employee> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Employee update(Employee employee) throws SystemException {
		return getPersistence().update(employee);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Employee update(Employee employee,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(employee, serviceContext);
	}

	/**
	* Returns all the Employees where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @return the matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByshiftId(
		long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByshiftId(shiftId);
	}

	/**
	* Returns a range of all the Employees where shiftId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shiftId the shift ID
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @return the range of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByshiftId(
		long shiftId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByshiftId(shiftId, start, end);
	}

	/**
	* Returns an ordered range of all the Employees where shiftId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shiftId the shift ID
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByshiftId(
		long shiftId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByshiftId(shiftId, start, end, orderByComparator);
	}

	/**
	* Returns the first Employee in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee findByshiftId_First(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException {
		return getPersistence().findByshiftId_First(shiftId, orderByComparator);
	}

	/**
	* Returns the first Employee in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Employee, or <code>null</code> if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee fetchByshiftId_First(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByshiftId_First(shiftId, orderByComparator);
	}

	/**
	* Returns the last Employee in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee findByshiftId_Last(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException {
		return getPersistence().findByshiftId_Last(shiftId, orderByComparator);
	}

	/**
	* Returns the last Employee in the ordered set where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Employee, or <code>null</code> if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee fetchByshiftId_Last(
		long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByshiftId_Last(shiftId, orderByComparator);
	}

	/**
	* Returns the Employees before and after the current Employee in the ordered set where shiftId = &#63;.
	*
	* @param employeeId the primary key of the current Employee
	* @param shiftId the shift ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a Employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee[] findByshiftId_PrevAndNext(
		long employeeId, long shiftId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException {
		return getPersistence()
				   .findByshiftId_PrevAndNext(employeeId, shiftId,
			orderByComparator);
	}

	/**
	* Removes all the Employees where shiftId = &#63; from the database.
	*
	* @param shiftId the shift ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByshiftId(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByshiftId(shiftId);
	}

	/**
	* Returns the number of Employees where shiftId = &#63;.
	*
	* @param shiftId the shift ID
	* @return the number of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByshiftId(long shiftId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByshiftId(shiftId);
	}

	/**
	* Returns all the Employees where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByemployeeId(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	* Returns a range of all the Employees where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @return the range of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByemployeeId(
		long employeeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	* Returns an ordered range of all the Employees where employeeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param employeeId the employee ID
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findByemployeeId(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByemployeeId(employeeId, start, end, orderByComparator);
	}

	/**
	* Returns the first Employee in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee findByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException {
		return getPersistence()
				   .findByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the first Employee in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching Employee, or <code>null</code> if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee fetchByemployeeId_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_First(employeeId, orderByComparator);
	}

	/**
	* Returns the last Employee in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee findByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException {
		return getPersistence()
				   .findByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Returns the last Employee in the ordered set where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching Employee, or <code>null</code> if a matching Employee could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee fetchByemployeeId_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemployeeId_Last(employeeId, orderByComparator);
	}

	/**
	* Removes all the Employees where employeeId = &#63; from the database.
	*
	* @param employeeId the employee ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	* Returns the number of Employees where employeeId = &#63;.
	*
	* @param employeeId the employee ID
	* @return the number of matching Employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemployeeId(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	* Caches the Employee in the entity cache if it is enabled.
	*
	* @param employee the Employee
	*/
	public static void cacheResult(
		com.rknowsys.eapp.hrm.model.Employee employee) {
		getPersistence().cacheResult(employee);
	}

	/**
	* Caches the Employees in the entity cache if it is enabled.
	*
	* @param employees the Employees
	*/
	public static void cacheResult(
		java.util.List<com.rknowsys.eapp.hrm.model.Employee> employees) {
		getPersistence().cacheResult(employees);
	}

	/**
	* Creates a new Employee with the primary key. Does not add the Employee to the database.
	*
	* @param employeeId the primary key for the new Employee
	* @return the new Employee
	*/
	public static com.rknowsys.eapp.hrm.model.Employee create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	* Removes the Employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeId the primary key of the Employee
	* @return the Employee that was removed
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a Employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee remove(long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException {
		return getPersistence().remove(employeeId);
	}

	public static com.rknowsys.eapp.hrm.model.Employee updateImpl(
		com.rknowsys.eapp.hrm.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(employee);
	}

	/**
	* Returns the Employee with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmployeeException} if it could not be found.
	*
	* @param employeeId the primary key of the Employee
	* @return the Employee
	* @throws com.rknowsys.eapp.hrm.NoSuchEmployeeException if a Employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee findByPrimaryKey(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rknowsys.eapp.hrm.NoSuchEmployeeException {
		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	* Returns the Employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employeeId the primary key of the Employee
	* @return the Employee, or <code>null</code> if a Employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.Employee fetchByPrimaryKey(
		long employeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	/**
	* Returns all the Employees.
	*
	* @return the Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the Employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @return the range of Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the Employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Employees
	* @param end the upper bound of the range of Employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of Employees.
	*
	* @return the number of Employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmployeePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmployeePersistence)PortletBeanLocatorUtil.locate(com.rknowsys.eapp.hrm.service.ClpSerializer.getServletContextName(),
					EmployeePersistence.class.getName());

			ReferenceRegistry.registerReference(EmployeeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmployeePersistence persistence) {
	}

	private static EmployeePersistence _persistence;
}