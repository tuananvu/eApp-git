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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchWorkShiftException;
import com.rknowsys.eapp.hrm.model.WorkShift;
import com.rknowsys.eapp.hrm.model.impl.WorkShiftImpl;
import com.rknowsys.eapp.hrm.model.impl.WorkShiftModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the work shift service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkShiftPersistence
 * @see WorkShiftUtil
 * @generated
 */
public class WorkShiftPersistenceImpl extends BasePersistenceImpl<WorkShift>
	implements WorkShiftPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkShiftUtil} to access the work shift persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkShiftImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftModelImpl.FINDER_CACHE_ENABLED, WorkShiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftModelImpl.FINDER_CACHE_ENABLED, WorkShiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftModelImpl.FINDER_CACHE_ENABLED, WorkShiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftModelImpl.FINDER_CACHE_ENABLED, WorkShiftImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			WorkShiftModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the work shifts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching work shifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShift> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work shifts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkShiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of work shifts
	 * @param end the upper bound of the range of work shifts (not inclusive)
	 * @return the range of matching work shifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShift> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work shifts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkShiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of work shifts
	 * @param end the upper bound of the range of work shifts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work shifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShift> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<WorkShift> list = (List<WorkShift>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkShift workShift : list) {
				if ((groupId != workShift.getGroupId())) {
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

			query.append(_SQL_SELECT_WORKSHIFT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkShiftModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<WorkShift>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkShift>(list);
				}
				else {
					list = (List<WorkShift>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first work shift in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work shift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftException if a matching work shift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkShiftException, SystemException {
		WorkShift workShift = fetchByGroupId_First(groupId, orderByComparator);

		if (workShift != null) {
			return workShift;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkShiftException(msg.toString());
	}

	/**
	 * Returns the first work shift in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work shift, or <code>null</code> if a matching work shift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkShift> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work shift in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work shift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftException if a matching work shift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkShiftException, SystemException {
		WorkShift workShift = fetchByGroupId_Last(groupId, orderByComparator);

		if (workShift != null) {
			return workShift;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkShiftException(msg.toString());
	}

	/**
	 * Returns the last work shift in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work shift, or <code>null</code> if a matching work shift could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<WorkShift> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work shifts before and after the current work shift in the ordered set where groupId = &#63;.
	 *
	 * @param shiftId the primary key of the current work shift
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work shift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftException if a work shift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift[] findByGroupId_PrevAndNext(long shiftId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkShiftException, SystemException {
		WorkShift workShift = findByPrimaryKey(shiftId);

		Session session = null;

		try {
			session = openSession();

			WorkShift[] array = new WorkShiftImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, workShift, groupId,
					orderByComparator, true);

			array[1] = workShift;

			array[2] = getByGroupId_PrevAndNext(session, workShift, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkShift getByGroupId_PrevAndNext(Session session,
		WorkShift workShift, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKSHIFT_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(WorkShiftModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workShift);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkShift> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work shifts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (WorkShift workShift : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(workShift);
		}
	}

	/**
	 * Returns the number of work shifts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching work shifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKSHIFT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "workShift.groupId = ?";

	public WorkShiftPersistenceImpl() {
		setModelClass(WorkShift.class);
	}

	/**
	 * Caches the work shift in the entity cache if it is enabled.
	 *
	 * @param workShift the work shift
	 */
	@Override
	public void cacheResult(WorkShift workShift) {
		EntityCacheUtil.putResult(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftImpl.class, workShift.getPrimaryKey(), workShift);

		workShift.resetOriginalValues();
	}

	/**
	 * Caches the work shifts in the entity cache if it is enabled.
	 *
	 * @param workShifts the work shifts
	 */
	@Override
	public void cacheResult(List<WorkShift> workShifts) {
		for (WorkShift workShift : workShifts) {
			if (EntityCacheUtil.getResult(
						WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
						WorkShiftImpl.class, workShift.getPrimaryKey()) == null) {
				cacheResult(workShift);
			}
			else {
				workShift.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all work shifts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkShiftImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkShiftImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the work shift.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkShift workShift) {
		EntityCacheUtil.removeResult(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftImpl.class, workShift.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkShift> workShifts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkShift workShift : workShifts) {
			EntityCacheUtil.removeResult(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
				WorkShiftImpl.class, workShift.getPrimaryKey());
		}
	}

	/**
	 * Creates a new work shift with the primary key. Does not add the work shift to the database.
	 *
	 * @param shiftId the primary key for the new work shift
	 * @return the new work shift
	 */
	@Override
	public WorkShift create(long shiftId) {
		WorkShift workShift = new WorkShiftImpl();

		workShift.setNew(true);
		workShift.setPrimaryKey(shiftId);

		return workShift;
	}

	/**
	 * Removes the work shift with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shiftId the primary key of the work shift
	 * @return the work shift that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftException if a work shift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift remove(long shiftId)
		throws NoSuchWorkShiftException, SystemException {
		return remove((Serializable)shiftId);
	}

	/**
	 * Removes the work shift with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work shift
	 * @return the work shift that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftException if a work shift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift remove(Serializable primaryKey)
		throws NoSuchWorkShiftException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkShift workShift = (WorkShift)session.get(WorkShiftImpl.class,
					primaryKey);

			if (workShift == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkShiftException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workShift);
		}
		catch (NoSuchWorkShiftException nsee) {
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
	protected WorkShift removeImpl(WorkShift workShift)
		throws SystemException {
		workShift = toUnwrappedModel(workShift);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workShift)) {
				workShift = (WorkShift)session.get(WorkShiftImpl.class,
						workShift.getPrimaryKeyObj());
			}

			if (workShift != null) {
				session.delete(workShift);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workShift != null) {
			clearCache(workShift);
		}

		return workShift;
	}

	@Override
	public WorkShift updateImpl(com.rknowsys.eapp.hrm.model.WorkShift workShift)
		throws SystemException {
		workShift = toUnwrappedModel(workShift);

		boolean isNew = workShift.isNew();

		WorkShiftModelImpl workShiftModelImpl = (WorkShiftModelImpl)workShift;

		Session session = null;

		try {
			session = openSession();

			if (workShift.isNew()) {
				session.save(workShift);

				workShift.setNew(false);
			}
			else {
				session.merge(workShift);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkShiftModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workShiftModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workShiftModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { workShiftModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftImpl.class, workShift.getPrimaryKey(), workShift);

		return workShift;
	}

	protected WorkShift toUnwrappedModel(WorkShift workShift) {
		if (workShift instanceof WorkShiftImpl) {
			return workShift;
		}

		WorkShiftImpl workShiftImpl = new WorkShiftImpl();

		workShiftImpl.setNew(workShift.isNew());
		workShiftImpl.setPrimaryKey(workShift.getPrimaryKey());

		workShiftImpl.setShiftId(workShift.getShiftId());
		workShiftImpl.setCompanyId(workShift.getCompanyId());
		workShiftImpl.setGroupId(workShift.getGroupId());
		workShiftImpl.setCreateDate(workShift.getCreateDate());
		workShiftImpl.setModifiedDate(workShift.getModifiedDate());
		workShiftImpl.setUserId(workShift.getUserId());
		workShiftImpl.setShiftName(workShift.getShiftName());
		workShiftImpl.setFromWorkHrs(workShift.getFromWorkHrs());
		workShiftImpl.setToWorkHrs(workShift.getToWorkHrs());

		return workShiftImpl;
	}

	/**
	 * Returns the work shift with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the work shift
	 * @return the work shift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftException if a work shift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkShiftException, SystemException {
		WorkShift workShift = fetchByPrimaryKey(primaryKey);

		if (workShift == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkShiftException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workShift;
	}

	/**
	 * Returns the work shift with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkShiftException} if it could not be found.
	 *
	 * @param shiftId the primary key of the work shift
	 * @return the work shift
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftException if a work shift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift findByPrimaryKey(long shiftId)
		throws NoSuchWorkShiftException, SystemException {
		return findByPrimaryKey((Serializable)shiftId);
	}

	/**
	 * Returns the work shift with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work shift
	 * @return the work shift, or <code>null</code> if a work shift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkShift workShift = (WorkShift)EntityCacheUtil.getResult(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
				WorkShiftImpl.class, primaryKey);

		if (workShift == _nullWorkShift) {
			return null;
		}

		if (workShift == null) {
			Session session = null;

			try {
				session = openSession();

				workShift = (WorkShift)session.get(WorkShiftImpl.class,
						primaryKey);

				if (workShift != null) {
					cacheResult(workShift);
				}
				else {
					EntityCacheUtil.putResult(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
						WorkShiftImpl.class, primaryKey, _nullWorkShift);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkShiftModelImpl.ENTITY_CACHE_ENABLED,
					WorkShiftImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workShift;
	}

	/**
	 * Returns the work shift with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shiftId the primary key of the work shift
	 * @return the work shift, or <code>null</code> if a work shift with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShift fetchByPrimaryKey(long shiftId) throws SystemException {
		return fetchByPrimaryKey((Serializable)shiftId);
	}

	/**
	 * Returns all the work shifts.
	 *
	 * @return the work shifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShift> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work shifts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkShiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work shifts
	 * @param end the upper bound of the range of work shifts (not inclusive)
	 * @return the range of work shifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShift> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work shifts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkShiftModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work shifts
	 * @param end the upper bound of the range of work shifts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work shifts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShift> findAll(int start, int end,
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

		List<WorkShift> list = (List<WorkShift>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKSHIFT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKSHIFT;

				if (pagination) {
					sql = sql.concat(WorkShiftModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkShift>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkShift>(list);
				}
				else {
					list = (List<WorkShift>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the work shifts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkShift workShift : findAll()) {
			remove(workShift);
		}
	}

	/**
	 * Returns the number of work shifts.
	 *
	 * @return the number of work shifts
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

				Query q = session.createQuery(_SQL_COUNT_WORKSHIFT);

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

	/**
	 * Initializes the work shift persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.WorkShift")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkShift>> listenersList = new ArrayList<ModelListener<WorkShift>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkShift>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WorkShiftImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WORKSHIFT = "SELECT workShift FROM WorkShift workShift";
	private static final String _SQL_SELECT_WORKSHIFT_WHERE = "SELECT workShift FROM WorkShift workShift WHERE ";
	private static final String _SQL_COUNT_WORKSHIFT = "SELECT COUNT(workShift) FROM WorkShift workShift";
	private static final String _SQL_COUNT_WORKSHIFT_WHERE = "SELECT COUNT(workShift) FROM WorkShift workShift WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workShift.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkShift exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkShift exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkShiftPersistenceImpl.class);
	private static WorkShift _nullWorkShift = new WorkShiftImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkShift> toCacheModel() {
				return _nullWorkShiftCacheModel;
			}
		};

	private static CacheModel<WorkShift> _nullWorkShiftCacheModel = new CacheModel<WorkShift>() {
			@Override
			public WorkShift toEntityModel() {
				return _nullWorkShift;
			}
		};
}