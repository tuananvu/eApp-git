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

import com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException;
import com.rknowsys.eapp.hrm.model.WorkShiftUser;
import com.rknowsys.eapp.hrm.model.impl.WorkShiftUserImpl;
import com.rknowsys.eapp.hrm.model.impl.WorkShiftUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the work shift user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see WorkShiftUserPersistence
 * @see WorkShiftUserUtil
 * @generated
 */
public class WorkShiftUserPersistenceImpl extends BasePersistenceImpl<WorkShiftUser>
	implements WorkShiftUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkShiftUserUtil} to access the work shift user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkShiftUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserModelImpl.FINDER_CACHE_ENABLED,
			WorkShiftUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserModelImpl.FINDER_CACHE_ENABLED,
			WorkShiftUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserModelImpl.FINDER_CACHE_ENABLED,
			WorkShiftUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserModelImpl.FINDER_CACHE_ENABLED,
			WorkShiftUserImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			WorkShiftUserModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the work shift users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching work shift users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShiftUser> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work shift users where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkShiftUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of work shift users
	 * @param end the upper bound of the range of work shift users (not inclusive)
	 * @return the range of matching work shift users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShiftUser> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work shift users where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkShiftUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of work shift users
	 * @param end the upper bound of the range of work shift users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work shift users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShiftUser> findByGroupId(long groupId, int start, int end,
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

		List<WorkShiftUser> list = (List<WorkShiftUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkShiftUser workShiftUser : list) {
				if ((groupId != workShiftUser.getGroupId())) {
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

			query.append(_SQL_SELECT_WORKSHIFTUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkShiftUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<WorkShiftUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkShiftUser>(list);
				}
				else {
					list = (List<WorkShiftUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first work shift user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work shift user
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException if a matching work shift user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkShiftUserException, SystemException {
		WorkShiftUser workShiftUser = fetchByGroupId_First(groupId,
				orderByComparator);

		if (workShiftUser != null) {
			return workShiftUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkShiftUserException(msg.toString());
	}

	/**
	 * Returns the first work shift user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work shift user, or <code>null</code> if a matching work shift user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkShiftUser> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work shift user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work shift user
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException if a matching work shift user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkShiftUserException, SystemException {
		WorkShiftUser workShiftUser = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (workShiftUser != null) {
			return workShiftUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkShiftUserException(msg.toString());
	}

	/**
	 * Returns the last work shift user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work shift user, or <code>null</code> if a matching work shift user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<WorkShiftUser> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work shift users before and after the current work shift user in the ordered set where groupId = &#63;.
	 *
	 * @param workShiftUserId the primary key of the current work shift user
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work shift user
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException if a work shift user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser[] findByGroupId_PrevAndNext(long workShiftUserId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchWorkShiftUserException, SystemException {
		WorkShiftUser workShiftUser = findByPrimaryKey(workShiftUserId);

		Session session = null;

		try {
			session = openSession();

			WorkShiftUser[] array = new WorkShiftUserImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, workShiftUser,
					groupId, orderByComparator, true);

			array[1] = workShiftUser;

			array[2] = getByGroupId_PrevAndNext(session, workShiftUser,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkShiftUser getByGroupId_PrevAndNext(Session session,
		WorkShiftUser workShiftUser, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKSHIFTUSER_WHERE);

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
			query.append(WorkShiftUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workShiftUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkShiftUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work shift users where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (WorkShiftUser workShiftUser : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workShiftUser);
		}
	}

	/**
	 * Returns the number of work shift users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching work shift users
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

			query.append(_SQL_COUNT_WORKSHIFTUSER_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "workShiftUser.groupId = ?";

	public WorkShiftUserPersistenceImpl() {
		setModelClass(WorkShiftUser.class);
	}

	/**
	 * Caches the work shift user in the entity cache if it is enabled.
	 *
	 * @param workShiftUser the work shift user
	 */
	@Override
	public void cacheResult(WorkShiftUser workShiftUser) {
		EntityCacheUtil.putResult(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserImpl.class, workShiftUser.getPrimaryKey(),
			workShiftUser);

		workShiftUser.resetOriginalValues();
	}

	/**
	 * Caches the work shift users in the entity cache if it is enabled.
	 *
	 * @param workShiftUsers the work shift users
	 */
	@Override
	public void cacheResult(List<WorkShiftUser> workShiftUsers) {
		for (WorkShiftUser workShiftUser : workShiftUsers) {
			if (EntityCacheUtil.getResult(
						WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
						WorkShiftUserImpl.class, workShiftUser.getPrimaryKey()) == null) {
				cacheResult(workShiftUser);
			}
			else {
				workShiftUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all work shift users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkShiftUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkShiftUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the work shift user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkShiftUser workShiftUser) {
		EntityCacheUtil.removeResult(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserImpl.class, workShiftUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkShiftUser> workShiftUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkShiftUser workShiftUser : workShiftUsers) {
			EntityCacheUtil.removeResult(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
				WorkShiftUserImpl.class, workShiftUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new work shift user with the primary key. Does not add the work shift user to the database.
	 *
	 * @param workShiftUserId the primary key for the new work shift user
	 * @return the new work shift user
	 */
	@Override
	public WorkShiftUser create(long workShiftUserId) {
		WorkShiftUser workShiftUser = new WorkShiftUserImpl();

		workShiftUser.setNew(true);
		workShiftUser.setPrimaryKey(workShiftUserId);

		return workShiftUser;
	}

	/**
	 * Removes the work shift user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workShiftUserId the primary key of the work shift user
	 * @return the work shift user that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException if a work shift user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser remove(long workShiftUserId)
		throws NoSuchWorkShiftUserException, SystemException {
		return remove((Serializable)workShiftUserId);
	}

	/**
	 * Removes the work shift user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work shift user
	 * @return the work shift user that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException if a work shift user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser remove(Serializable primaryKey)
		throws NoSuchWorkShiftUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkShiftUser workShiftUser = (WorkShiftUser)session.get(WorkShiftUserImpl.class,
					primaryKey);

			if (workShiftUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkShiftUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workShiftUser);
		}
		catch (NoSuchWorkShiftUserException nsee) {
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
	protected WorkShiftUser removeImpl(WorkShiftUser workShiftUser)
		throws SystemException {
		workShiftUser = toUnwrappedModel(workShiftUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workShiftUser)) {
				workShiftUser = (WorkShiftUser)session.get(WorkShiftUserImpl.class,
						workShiftUser.getPrimaryKeyObj());
			}

			if (workShiftUser != null) {
				session.delete(workShiftUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workShiftUser != null) {
			clearCache(workShiftUser);
		}

		return workShiftUser;
	}

	@Override
	public WorkShiftUser updateImpl(
		com.rknowsys.eapp.hrm.model.WorkShiftUser workShiftUser)
		throws SystemException {
		workShiftUser = toUnwrappedModel(workShiftUser);

		boolean isNew = workShiftUser.isNew();

		WorkShiftUserModelImpl workShiftUserModelImpl = (WorkShiftUserModelImpl)workShiftUser;

		Session session = null;

		try {
			session = openSession();

			if (workShiftUser.isNew()) {
				session.save(workShiftUser);

				workShiftUser.setNew(false);
			}
			else {
				session.merge(workShiftUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkShiftUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workShiftUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workShiftUserModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { workShiftUserModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
			WorkShiftUserImpl.class, workShiftUser.getPrimaryKey(),
			workShiftUser);

		return workShiftUser;
	}

	protected WorkShiftUser toUnwrappedModel(WorkShiftUser workShiftUser) {
		if (workShiftUser instanceof WorkShiftUserImpl) {
			return workShiftUser;
		}

		WorkShiftUserImpl workShiftUserImpl = new WorkShiftUserImpl();

		workShiftUserImpl.setNew(workShiftUser.isNew());
		workShiftUserImpl.setPrimaryKey(workShiftUser.getPrimaryKey());

		workShiftUserImpl.setWorkShiftUserId(workShiftUser.getWorkShiftUserId());
		workShiftUserImpl.setCompanyId(workShiftUser.getCompanyId());
		workShiftUserImpl.setGroupId(workShiftUser.getGroupId());
		workShiftUserImpl.setCreateDate(workShiftUser.getCreateDate());
		workShiftUserImpl.setModifiedDate(workShiftUser.getModifiedDate());
		workShiftUserImpl.setUserId(workShiftUser.getUserId());
		workShiftUserImpl.setEmpId(workShiftUser.getEmpId());
		workShiftUserImpl.setShiftId(workShiftUser.getShiftId());

		return workShiftUserImpl;
	}

	/**
	 * Returns the work shift user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the work shift user
	 * @return the work shift user
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException if a work shift user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkShiftUserException, SystemException {
		WorkShiftUser workShiftUser = fetchByPrimaryKey(primaryKey);

		if (workShiftUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkShiftUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workShiftUser;
	}

	/**
	 * Returns the work shift user with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException} if it could not be found.
	 *
	 * @param workShiftUserId the primary key of the work shift user
	 * @return the work shift user
	 * @throws com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException if a work shift user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser findByPrimaryKey(long workShiftUserId)
		throws NoSuchWorkShiftUserException, SystemException {
		return findByPrimaryKey((Serializable)workShiftUserId);
	}

	/**
	 * Returns the work shift user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work shift user
	 * @return the work shift user, or <code>null</code> if a work shift user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkShiftUser workShiftUser = (WorkShiftUser)EntityCacheUtil.getResult(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
				WorkShiftUserImpl.class, primaryKey);

		if (workShiftUser == _nullWorkShiftUser) {
			return null;
		}

		if (workShiftUser == null) {
			Session session = null;

			try {
				session = openSession();

				workShiftUser = (WorkShiftUser)session.get(WorkShiftUserImpl.class,
						primaryKey);

				if (workShiftUser != null) {
					cacheResult(workShiftUser);
				}
				else {
					EntityCacheUtil.putResult(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
						WorkShiftUserImpl.class, primaryKey, _nullWorkShiftUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkShiftUserModelImpl.ENTITY_CACHE_ENABLED,
					WorkShiftUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workShiftUser;
	}

	/**
	 * Returns the work shift user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workShiftUserId the primary key of the work shift user
	 * @return the work shift user, or <code>null</code> if a work shift user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkShiftUser fetchByPrimaryKey(long workShiftUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)workShiftUserId);
	}

	/**
	 * Returns all the work shift users.
	 *
	 * @return the work shift users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShiftUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work shift users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkShiftUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work shift users
	 * @param end the upper bound of the range of work shift users (not inclusive)
	 * @return the range of work shift users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShiftUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work shift users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.WorkShiftUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of work shift users
	 * @param end the upper bound of the range of work shift users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work shift users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkShiftUser> findAll(int start, int end,
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

		List<WorkShiftUser> list = (List<WorkShiftUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKSHIFTUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKSHIFTUSER;

				if (pagination) {
					sql = sql.concat(WorkShiftUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkShiftUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkShiftUser>(list);
				}
				else {
					list = (List<WorkShiftUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the work shift users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkShiftUser workShiftUser : findAll()) {
			remove(workShiftUser);
		}
	}

	/**
	 * Returns the number of work shift users.
	 *
	 * @return the number of work shift users
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

				Query q = session.createQuery(_SQL_COUNT_WORKSHIFTUSER);

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
	 * Initializes the work shift user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.WorkShiftUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkShiftUser>> listenersList = new ArrayList<ModelListener<WorkShiftUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkShiftUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WorkShiftUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WORKSHIFTUSER = "SELECT workShiftUser FROM WorkShiftUser workShiftUser";
	private static final String _SQL_SELECT_WORKSHIFTUSER_WHERE = "SELECT workShiftUser FROM WorkShiftUser workShiftUser WHERE ";
	private static final String _SQL_COUNT_WORKSHIFTUSER = "SELECT COUNT(workShiftUser) FROM WorkShiftUser workShiftUser";
	private static final String _SQL_COUNT_WORKSHIFTUSER_WHERE = "SELECT COUNT(workShiftUser) FROM WorkShiftUser workShiftUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workShiftUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkShiftUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkShiftUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkShiftUserPersistenceImpl.class);
	private static WorkShiftUser _nullWorkShiftUser = new WorkShiftUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkShiftUser> toCacheModel() {
				return _nullWorkShiftUserCacheModel;
			}
		};

	private static CacheModel<WorkShiftUser> _nullWorkShiftUserCacheModel = new CacheModel<WorkShiftUser>() {
			@Override
			public WorkShiftUser toEntityModel() {
				return _nullWorkShiftUser;
			}
		};
}