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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException;
import com.rknowsys.eapp.hrm.model.WorkExpCompany;
import com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyImpl;
import com.rknowsys.eapp.hrm.model.impl.WorkExpCompanyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the WorkExpCompany service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkExpCompanyPersistence
 * @see WorkExpCompanyUtil
 * @generated
 */
public class WorkExpCompanyPersistenceImpl extends BasePersistenceImpl<WorkExpCompany>
	implements WorkExpCompanyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkExpCompanyUtil} to access the WorkExpCompany persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkExpCompanyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED,
			WorkExpCompanyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED,
			WorkExpCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED,
			WorkExpCompanyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED,
			WorkExpCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			WorkExpCompanyModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the WorkExpCompanies where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching WorkExpCompanies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkExpCompany> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<WorkExpCompany> findByemployeeId(long employeeId, int start,
		int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

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
	@Override
	public List<WorkExpCompany> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<WorkExpCompany> list = (List<WorkExpCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkExpCompany workExpCompany : list) {
				if ((employeeId != workExpCompany.getEmployeeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WORKEXPCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkExpCompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<WorkExpCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkExpCompany>(list);
				}
				else {
					list = (List<WorkExpCompany>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first WorkExpCompany in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WorkExpCompany
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a matching WorkExpCompany could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkExpCompanyException, SystemException {
		WorkExpCompany workExpCompany = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (workExpCompany != null) {
			return workExpCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkExpCompanyException(msg.toString());
	}

	/**
	 * Returns the first WorkExpCompany in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WorkExpCompany, or <code>null</code> if a matching WorkExpCompany could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkExpCompany> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WorkExpCompany in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WorkExpCompany
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a matching WorkExpCompany could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkExpCompanyException, SystemException {
		WorkExpCompany workExpCompany = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (workExpCompany != null) {
			return workExpCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkExpCompanyException(msg.toString());
	}

	/**
	 * Returns the last WorkExpCompany in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WorkExpCompany, or <code>null</code> if a matching WorkExpCompany could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<WorkExpCompany> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public WorkExpCompany[] findByemployeeId_PrevAndNext(
		long workExpCompanyId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkExpCompanyException, SystemException {
		WorkExpCompany workExpCompany = findByPrimaryKey(workExpCompanyId);

		Session session = null;

		try {
			session = openSession();

			WorkExpCompany[] array = new WorkExpCompanyImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, workExpCompany,
					employeeId, orderByComparator, true);

			array[1] = workExpCompany;

			array[2] = getByemployeeId_PrevAndNext(session, workExpCompany,
					employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkExpCompany getByemployeeId_PrevAndNext(Session session,
		WorkExpCompany workExpCompany, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKEXPCOMPANY_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WorkExpCompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workExpCompany);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkExpCompany> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the WorkExpCompanies where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (WorkExpCompany workExpCompany : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workExpCompany);
		}
	}

	/**
	 * Returns the number of WorkExpCompanies where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching WorkExpCompanies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemployeeId(long employeeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKEXPCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "workExpCompany.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKEXPCOMPANYID =
		new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED,
			WorkExpCompanyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByworkExpCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKEXPCOMPANYID =
		new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED,
			WorkExpCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByworkExpCompanyId", new String[] { Long.class.getName() },
			WorkExpCompanyModelImpl.WORKEXPCOMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKEXPCOMPANYID = new FinderPath(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByworkExpCompanyId", new String[] { Long.class.getName() });

	/**
	 * Returns all the WorkExpCompanies where workExpCompanyId = &#63;.
	 *
	 * @param workExpCompanyId the work exp company ID
	 * @return the matching WorkExpCompanies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkExpCompany> findByworkExpCompanyId(long workExpCompanyId)
		throws SystemException {
		return findByworkExpCompanyId(workExpCompanyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<WorkExpCompany> findByworkExpCompanyId(long workExpCompanyId,
		int start, int end) throws SystemException {
		return findByworkExpCompanyId(workExpCompanyId, start, end, null);
	}

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
	@Override
	public List<WorkExpCompany> findByworkExpCompanyId(long workExpCompanyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKEXPCOMPANYID;
			finderArgs = new Object[] { workExpCompanyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKEXPCOMPANYID;
			finderArgs = new Object[] {
					workExpCompanyId,
					
					start, end, orderByComparator
				};
		}

		List<WorkExpCompany> list = (List<WorkExpCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkExpCompany workExpCompany : list) {
				if ((workExpCompanyId != workExpCompany.getWorkExpCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WORKEXPCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_WORKEXPCOMPANYID_WORKEXPCOMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkExpCompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workExpCompanyId);

				if (!pagination) {
					list = (List<WorkExpCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkExpCompany>(list);
				}
				else {
					list = (List<WorkExpCompany>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first WorkExpCompany in the ordered set where workExpCompanyId = &#63;.
	 *
	 * @param workExpCompanyId the work exp company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WorkExpCompany
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a matching WorkExpCompany could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany findByworkExpCompanyId_First(long workExpCompanyId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkExpCompanyException, SystemException {
		WorkExpCompany workExpCompany = fetchByworkExpCompanyId_First(workExpCompanyId,
				orderByComparator);

		if (workExpCompany != null) {
			return workExpCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workExpCompanyId=");
		msg.append(workExpCompanyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkExpCompanyException(msg.toString());
	}

	/**
	 * Returns the first WorkExpCompany in the ordered set where workExpCompanyId = &#63;.
	 *
	 * @param workExpCompanyId the work exp company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching WorkExpCompany, or <code>null</code> if a matching WorkExpCompany could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany fetchByworkExpCompanyId_First(long workExpCompanyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkExpCompany> list = findByworkExpCompanyId(workExpCompanyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last WorkExpCompany in the ordered set where workExpCompanyId = &#63;.
	 *
	 * @param workExpCompanyId the work exp company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WorkExpCompany
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a matching WorkExpCompany could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany findByworkExpCompanyId_Last(long workExpCompanyId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkExpCompanyException, SystemException {
		WorkExpCompany workExpCompany = fetchByworkExpCompanyId_Last(workExpCompanyId,
				orderByComparator);

		if (workExpCompany != null) {
			return workExpCompany;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workExpCompanyId=");
		msg.append(workExpCompanyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkExpCompanyException(msg.toString());
	}

	/**
	 * Returns the last WorkExpCompany in the ordered set where workExpCompanyId = &#63;.
	 *
	 * @param workExpCompanyId the work exp company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching WorkExpCompany, or <code>null</code> if a matching WorkExpCompany could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany fetchByworkExpCompanyId_Last(long workExpCompanyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByworkExpCompanyId(workExpCompanyId);

		if (count == 0) {
			return null;
		}

		List<WorkExpCompany> list = findByworkExpCompanyId(workExpCompanyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the WorkExpCompanies where workExpCompanyId = &#63; from the database.
	 *
	 * @param workExpCompanyId the work exp company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByworkExpCompanyId(long workExpCompanyId)
		throws SystemException {
		for (WorkExpCompany workExpCompany : findByworkExpCompanyId(
				workExpCompanyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workExpCompany);
		}
	}

	/**
	 * Returns the number of WorkExpCompanies where workExpCompanyId = &#63;.
	 *
	 * @param workExpCompanyId the work exp company ID
	 * @return the number of matching WorkExpCompanies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByworkExpCompanyId(long workExpCompanyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WORKEXPCOMPANYID;

		Object[] finderArgs = new Object[] { workExpCompanyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKEXPCOMPANY_WHERE);

			query.append(_FINDER_COLUMN_WORKEXPCOMPANYID_WORKEXPCOMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workExpCompanyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_WORKEXPCOMPANYID_WORKEXPCOMPANYID_2 =
		"workExpCompany.workExpCompanyId = ?";

	public WorkExpCompanyPersistenceImpl() {
		setModelClass(WorkExpCompany.class);
	}

	/**
	 * Caches the WorkExpCompany in the entity cache if it is enabled.
	 *
	 * @param workExpCompany the WorkExpCompany
	 */
	@Override
	public void cacheResult(WorkExpCompany workExpCompany) {
		EntityCacheUtil.putResult(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyImpl.class, workExpCompany.getPrimaryKey(),
			workExpCompany);

		workExpCompany.resetOriginalValues();
	}

	/**
	 * Caches the WorkExpCompanies in the entity cache if it is enabled.
	 *
	 * @param workExpCompanies the WorkExpCompanies
	 */
	@Override
	public void cacheResult(List<WorkExpCompany> workExpCompanies) {
		for (WorkExpCompany workExpCompany : workExpCompanies) {
			if (EntityCacheUtil.getResult(
						WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
						WorkExpCompanyImpl.class, workExpCompany.getPrimaryKey()) == null) {
				cacheResult(workExpCompany);
			}
			else {
				workExpCompany.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all WorkExpCompanies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkExpCompanyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkExpCompanyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the WorkExpCompany.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkExpCompany workExpCompany) {
		EntityCacheUtil.removeResult(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyImpl.class, workExpCompany.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkExpCompany> workExpCompanies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkExpCompany workExpCompany : workExpCompanies) {
			EntityCacheUtil.removeResult(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
				WorkExpCompanyImpl.class, workExpCompany.getPrimaryKey());
		}
	}

	/**
	 * Creates a new WorkExpCompany with the primary key. Does not add the WorkExpCompany to the database.
	 *
	 * @param workExpCompanyId the primary key for the new WorkExpCompany
	 * @return the new WorkExpCompany
	 */
	@Override
	public WorkExpCompany create(long workExpCompanyId) {
		WorkExpCompany workExpCompany = new WorkExpCompanyImpl();

		workExpCompany.setNew(true);
		workExpCompany.setPrimaryKey(workExpCompanyId);

		return workExpCompany;
	}

	/**
	 * Removes the WorkExpCompany with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workExpCompanyId the primary key of the WorkExpCompany
	 * @return the WorkExpCompany that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a WorkExpCompany with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany remove(long workExpCompanyId)
		throws NoSuchWorkExpCompanyException, SystemException {
		return remove((Serializable)workExpCompanyId);
	}

	/**
	 * Removes the WorkExpCompany with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the WorkExpCompany
	 * @return the WorkExpCompany that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a WorkExpCompany with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany remove(Serializable primaryKey)
		throws NoSuchWorkExpCompanyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkExpCompany workExpCompany = (WorkExpCompany)session.get(WorkExpCompanyImpl.class,
					primaryKey);

			if (workExpCompany == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkExpCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workExpCompany);
		}
		catch (NoSuchWorkExpCompanyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected WorkExpCompany removeImpl(WorkExpCompany workExpCompany)
		throws SystemException {
		workExpCompany = toUnwrappedModel(workExpCompany);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workExpCompany)) {
				workExpCompany = (WorkExpCompany)session.get(WorkExpCompanyImpl.class,
						workExpCompany.getPrimaryKeyObj());
			}

			if (workExpCompany != null) {
				session.delete(workExpCompany);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workExpCompany != null) {
			clearCache(workExpCompany);
		}

		return workExpCompany;
	}

	@Override
	public WorkExpCompany updateImpl(
		com.rknowsys.eapp.hrm.model.WorkExpCompany workExpCompany)
		throws SystemException {
		workExpCompany = toUnwrappedModel(workExpCompany);

		boolean isNew = workExpCompany.isNew();

		WorkExpCompanyModelImpl workExpCompanyModelImpl = (WorkExpCompanyModelImpl)workExpCompany;

		Session session = null;

		try {
			session = openSession();

			if (workExpCompany.isNew()) {
				session.save(workExpCompany);

				workExpCompany.setNew(false);
			}
			else {
				session.merge(workExpCompany);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkExpCompanyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workExpCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workExpCompanyModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { workExpCompanyModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}

			if ((workExpCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKEXPCOMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workExpCompanyModelImpl.getOriginalWorkExpCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKEXPCOMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKEXPCOMPANYID,
					args);

				args = new Object[] {
						workExpCompanyModelImpl.getWorkExpCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKEXPCOMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKEXPCOMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
			WorkExpCompanyImpl.class, workExpCompany.getPrimaryKey(),
			workExpCompany);

		return workExpCompany;
	}

	protected WorkExpCompany toUnwrappedModel(WorkExpCompany workExpCompany) {
		if (workExpCompany instanceof WorkExpCompanyImpl) {
			return workExpCompany;
		}

		WorkExpCompanyImpl workExpCompanyImpl = new WorkExpCompanyImpl();

		workExpCompanyImpl.setNew(workExpCompany.isNew());
		workExpCompanyImpl.setPrimaryKey(workExpCompany.getPrimaryKey());

		workExpCompanyImpl.setWorkExpCompanyId(workExpCompany.getWorkExpCompanyId());
		workExpCompanyImpl.setEmployeeId(workExpCompany.getEmployeeId());
		workExpCompanyImpl.setGroupId(workExpCompany.getGroupId());
		workExpCompanyImpl.setCompanyId(workExpCompany.getCompanyId());
		workExpCompanyImpl.setUserId(workExpCompany.getUserId());
		workExpCompanyImpl.setCreateDate(workExpCompany.getCreateDate());
		workExpCompanyImpl.setModifiedDate(workExpCompany.getModifiedDate());
		workExpCompanyImpl.setCompany(workExpCompany.getCompany());
		workExpCompanyImpl.setJobTitle(workExpCompany.getJobTitle());
		workExpCompanyImpl.setFromDate(workExpCompany.getFromDate());
		workExpCompanyImpl.setToDate(workExpCompany.getToDate());
		workExpCompanyImpl.setComment(workExpCompany.getComment());

		return workExpCompanyImpl;
	}

	/**
	 * Returns the WorkExpCompany with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the WorkExpCompany
	 * @return the WorkExpCompany
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a WorkExpCompany with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkExpCompanyException, SystemException {
		WorkExpCompany workExpCompany = fetchByPrimaryKey(primaryKey);

		if (workExpCompany == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkExpCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workExpCompany;
	}

	/**
	 * Returns the WorkExpCompany with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException} if it could not be found.
	 *
	 * @param workExpCompanyId the primary key of the WorkExpCompany
	 * @return the WorkExpCompany
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkExpCompanyException if a WorkExpCompany with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany findByPrimaryKey(long workExpCompanyId)
		throws NoSuchWorkExpCompanyException, SystemException {
		return findByPrimaryKey((Serializable)workExpCompanyId);
	}

	/**
	 * Returns the WorkExpCompany with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the WorkExpCompany
	 * @return the WorkExpCompany, or <code>null</code> if a WorkExpCompany with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkExpCompany workExpCompany = (WorkExpCompany)EntityCacheUtil.getResult(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
				WorkExpCompanyImpl.class, primaryKey);

		if (workExpCompany == _nullWorkExpCompany) {
			return null;
		}

		if (workExpCompany == null) {
			Session session = null;

			try {
				session = openSession();

				workExpCompany = (WorkExpCompany)session.get(WorkExpCompanyImpl.class,
						primaryKey);

				if (workExpCompany != null) {
					cacheResult(workExpCompany);
				}
				else {
					EntityCacheUtil.putResult(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
						WorkExpCompanyImpl.class, primaryKey,
						_nullWorkExpCompany);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkExpCompanyModelImpl.ENTITY_CACHE_ENABLED,
					WorkExpCompanyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workExpCompany;
	}

	/**
	 * Returns the WorkExpCompany with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workExpCompanyId the primary key of the WorkExpCompany
	 * @return the WorkExpCompany, or <code>null</code> if a WorkExpCompany with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkExpCompany fetchByPrimaryKey(long workExpCompanyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)workExpCompanyId);
	}

	/**
	 * Returns all the WorkExpCompanies.
	 *
	 * @return the WorkExpCompanies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkExpCompany> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<WorkExpCompany> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<WorkExpCompany> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<WorkExpCompany> list = (List<WorkExpCompany>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKEXPCOMPANY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKEXPCOMPANY;

				if (pagination) {
					sql = sql.concat(WorkExpCompanyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkExpCompany>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkExpCompany>(list);
				}
				else {
					list = (List<WorkExpCompany>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the WorkExpCompanies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkExpCompany workExpCompany : findAll()) {
			remove(workExpCompany);
		}
	}

	/**
	 * Returns the number of WorkExpCompanies.
	 *
	 * @return the number of WorkExpCompanies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORKEXPCOMPANY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the WorkExpCompany persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.WorkExpCompany")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkExpCompany>> listenersList = new ArrayList<ModelListener<WorkExpCompany>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkExpCompany>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WorkExpCompanyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WORKEXPCOMPANY = "SELECT workExpCompany FROM WorkExpCompany workExpCompany";
	private static final String _SQL_SELECT_WORKEXPCOMPANY_WHERE = "SELECT workExpCompany FROM WorkExpCompany workExpCompany WHERE ";
	private static final String _SQL_COUNT_WORKEXPCOMPANY = "SELECT COUNT(workExpCompany) FROM WorkExpCompany workExpCompany";
	private static final String _SQL_COUNT_WORKEXPCOMPANY_WHERE = "SELECT COUNT(workExpCompany) FROM WorkExpCompany workExpCompany WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workExpCompany.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkExpCompany exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkExpCompany exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkExpCompanyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
	private static WorkExpCompany _nullWorkExpCompany = new WorkExpCompanyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkExpCompany> toCacheModel() {
				return _nullWorkExpCompanyCacheModel;
			}
		};

	private static CacheModel<WorkExpCompany> _nullWorkExpCompanyCacheModel = new CacheModel<WorkExpCompany>() {
			@Override
			public WorkExpCompany toEntityModel() {
				return _nullWorkExpCompany;
			}
		};
}