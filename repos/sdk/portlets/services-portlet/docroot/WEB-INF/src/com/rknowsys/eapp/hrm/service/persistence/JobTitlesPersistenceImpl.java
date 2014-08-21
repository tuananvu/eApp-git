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

import com.rknowsys.eapp.hrm.NoSuchJobTitlesException;
import com.rknowsys.eapp.hrm.model.JobTitles;
import com.rknowsys.eapp.hrm.model.impl.JobTitlesImpl;
import com.rknowsys.eapp.hrm.model.impl.JobTitlesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the job titles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see JobTitlesPersistence
 * @see JobTitlesUtil
 * @generated
 */
public class JobTitlesPersistenceImpl extends BasePersistenceImpl<JobTitles>
	implements JobTitlesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobTitlesUtil} to access the job titles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobTitlesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesModelImpl.FINDER_CACHE_ENABLED, JobTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesModelImpl.FINDER_CACHE_ENABLED, JobTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesModelImpl.FINDER_CACHE_ENABLED, JobTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesModelImpl.FINDER_CACHE_ENABLED, JobTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			JobTitlesModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the job titleses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching job titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitles> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job titleses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of job titleses
	 * @param end the upper bound of the range of job titleses (not inclusive)
	 * @return the range of matching job titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitles> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job titleses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of job titleses
	 * @param end the upper bound of the range of job titleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitles> findByGroupId(long groupId, int start, int end,
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

		List<JobTitles> list = (List<JobTitles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobTitles jobTitles : list) {
				if ((groupId != jobTitles.getGroupId())) {
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

			query.append(_SQL_SELECT_JOBTITLES_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobTitlesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<JobTitles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobTitles>(list);
				}
				else {
					list = (List<JobTitles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job titles in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job titles
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitlesException if a matching job titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobTitlesException, SystemException {
		JobTitles jobTitles = fetchByGroupId_First(groupId, orderByComparator);

		if (jobTitles != null) {
			return jobTitles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobTitlesException(msg.toString());
	}

	/**
	 * Returns the first job titles in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job titles, or <code>null</code> if a matching job titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<JobTitles> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job titles in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job titles
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitlesException if a matching job titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobTitlesException, SystemException {
		JobTitles jobTitles = fetchByGroupId_Last(groupId, orderByComparator);

		if (jobTitles != null) {
			return jobTitles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobTitlesException(msg.toString());
	}

	/**
	 * Returns the last job titles in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job titles, or <code>null</code> if a matching job titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<JobTitles> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job titleses before and after the current job titles in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current job titles
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job titles
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitlesException if a job titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles[] findByGroupId_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchJobTitlesException, SystemException {
		JobTitles jobTitles = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			JobTitles[] array = new JobTitlesImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, jobTitles, groupId,
					orderByComparator, true);

			array[1] = jobTitles;

			array[2] = getByGroupId_PrevAndNext(session, jobTitles, groupId,
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

	protected JobTitles getByGroupId_PrevAndNext(Session session,
		JobTitles jobTitles, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBTITLES_WHERE);

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
			query.append(JobTitlesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobTitles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobTitles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job titleses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (JobTitles jobTitles : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(jobTitles);
		}
	}

	/**
	 * Returns the number of job titleses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching job titleses
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

			query.append(_SQL_COUNT_JOBTITLES_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "jobTitles.groupId = ?";

	public JobTitlesPersistenceImpl() {
		setModelClass(JobTitles.class);
	}

	/**
	 * Caches the job titles in the entity cache if it is enabled.
	 *
	 * @param jobTitles the job titles
	 */
	@Override
	public void cacheResult(JobTitles jobTitles) {
		EntityCacheUtil.putResult(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesImpl.class, jobTitles.getPrimaryKey(), jobTitles);

		jobTitles.resetOriginalValues();
	}

	/**
	 * Caches the job titleses in the entity cache if it is enabled.
	 *
	 * @param jobTitleses the job titleses
	 */
	@Override
	public void cacheResult(List<JobTitles> jobTitleses) {
		for (JobTitles jobTitles : jobTitleses) {
			if (EntityCacheUtil.getResult(
						JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
						JobTitlesImpl.class, jobTitles.getPrimaryKey()) == null) {
				cacheResult(jobTitles);
			}
			else {
				jobTitles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job titleses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobTitlesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobTitlesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job titles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobTitles jobTitles) {
		EntityCacheUtil.removeResult(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesImpl.class, jobTitles.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobTitles> jobTitleses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobTitles jobTitles : jobTitleses) {
			EntityCacheUtil.removeResult(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
				JobTitlesImpl.class, jobTitles.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job titles with the primary key. Does not add the job titles to the database.
	 *
	 * @param id the primary key for the new job titles
	 * @return the new job titles
	 */
	@Override
	public JobTitles create(long id) {
		JobTitles jobTitles = new JobTitlesImpl();

		jobTitles.setNew(true);
		jobTitles.setPrimaryKey(id);

		return jobTitles;
	}

	/**
	 * Removes the job titles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the job titles
	 * @return the job titles that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitlesException if a job titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles remove(long id)
		throws NoSuchJobTitlesException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the job titles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job titles
	 * @return the job titles that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitlesException if a job titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles remove(Serializable primaryKey)
		throws NoSuchJobTitlesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JobTitles jobTitles = (JobTitles)session.get(JobTitlesImpl.class,
					primaryKey);

			if (jobTitles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobTitlesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobTitles);
		}
		catch (NoSuchJobTitlesException nsee) {
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
	protected JobTitles removeImpl(JobTitles jobTitles)
		throws SystemException {
		jobTitles = toUnwrappedModel(jobTitles);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobTitles)) {
				jobTitles = (JobTitles)session.get(JobTitlesImpl.class,
						jobTitles.getPrimaryKeyObj());
			}

			if (jobTitles != null) {
				session.delete(jobTitles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobTitles != null) {
			clearCache(jobTitles);
		}

		return jobTitles;
	}

	@Override
	public JobTitles updateImpl(com.rknowsys.eapp.hrm.model.JobTitles jobTitles)
		throws SystemException {
		jobTitles = toUnwrappedModel(jobTitles);

		boolean isNew = jobTitles.isNew();

		JobTitlesModelImpl jobTitlesModelImpl = (JobTitlesModelImpl)jobTitles;

		Session session = null;

		try {
			session = openSession();

			if (jobTitles.isNew()) {
				session.save(jobTitles);

				jobTitles.setNew(false);
			}
			else {
				session.merge(jobTitles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JobTitlesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((jobTitlesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobTitlesModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { jobTitlesModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
			JobTitlesImpl.class, jobTitles.getPrimaryKey(), jobTitles);

		return jobTitles;
	}

	protected JobTitles toUnwrappedModel(JobTitles jobTitles) {
		if (jobTitles instanceof JobTitlesImpl) {
			return jobTitles;
		}

		JobTitlesImpl jobTitlesImpl = new JobTitlesImpl();

		jobTitlesImpl.setNew(jobTitles.isNew());
		jobTitlesImpl.setPrimaryKey(jobTitles.getPrimaryKey());

		jobTitlesImpl.setId(jobTitles.getId());
		jobTitlesImpl.setCompanyId(jobTitles.getCompanyId());
		jobTitlesImpl.setGroupId(jobTitles.getGroupId());
		jobTitlesImpl.setCreateDate(jobTitles.getCreateDate());
		jobTitlesImpl.setModifiedDate(jobTitles.getModifiedDate());
		jobTitlesImpl.setUserId(jobTitles.getUserId());
		jobTitlesImpl.setTitle(jobTitles.getTitle());
		jobTitlesImpl.setDescription(jobTitles.getDescription());
		jobTitlesImpl.setNotes(jobTitles.getNotes());
		jobTitlesImpl.setSpecification(jobTitles.getSpecification());

		return jobTitlesImpl;
	}

	/**
	 * Returns the job titles with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job titles
	 * @return the job titles
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitlesException if a job titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobTitlesException, SystemException {
		JobTitles jobTitles = fetchByPrimaryKey(primaryKey);

		if (jobTitles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobTitlesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jobTitles;
	}

	/**
	 * Returns the job titles with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchJobTitlesException} if it could not be found.
	 *
	 * @param id the primary key of the job titles
	 * @return the job titles
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobTitlesException if a job titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles findByPrimaryKey(long id)
		throws NoSuchJobTitlesException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the job titles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job titles
	 * @return the job titles, or <code>null</code> if a job titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JobTitles jobTitles = (JobTitles)EntityCacheUtil.getResult(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
				JobTitlesImpl.class, primaryKey);

		if (jobTitles == _nullJobTitles) {
			return null;
		}

		if (jobTitles == null) {
			Session session = null;

			try {
				session = openSession();

				jobTitles = (JobTitles)session.get(JobTitlesImpl.class,
						primaryKey);

				if (jobTitles != null) {
					cacheResult(jobTitles);
				}
				else {
					EntityCacheUtil.putResult(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
						JobTitlesImpl.class, primaryKey, _nullJobTitles);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JobTitlesModelImpl.ENTITY_CACHE_ENABLED,
					JobTitlesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jobTitles;
	}

	/**
	 * Returns the job titles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the job titles
	 * @return the job titles, or <code>null</code> if a job titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitles fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the job titleses.
	 *
	 * @return the job titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job titleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job titleses
	 * @param end the upper bound of the range of job titleses (not inclusive)
	 * @return the range of job titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job titleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job titleses
	 * @param end the upper bound of the range of job titleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobTitles> findAll(int start, int end,
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

		List<JobTitles> list = (List<JobTitles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOBTITLES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBTITLES;

				if (pagination) {
					sql = sql.concat(JobTitlesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobTitles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobTitles>(list);
				}
				else {
					list = (List<JobTitles>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the job titleses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JobTitles jobTitles : findAll()) {
			remove(jobTitles);
		}
	}

	/**
	 * Returns the number of job titleses.
	 *
	 * @return the number of job titleses
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

				Query q = session.createQuery(_SQL_COUNT_JOBTITLES);

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
	 * Initializes the job titles persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.JobTitles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JobTitles>> listenersList = new ArrayList<ModelListener<JobTitles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JobTitles>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JobTitlesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JOBTITLES = "SELECT jobTitles FROM JobTitles jobTitles";
	private static final String _SQL_SELECT_JOBTITLES_WHERE = "SELECT jobTitles FROM JobTitles jobTitles WHERE ";
	private static final String _SQL_COUNT_JOBTITLES = "SELECT COUNT(jobTitles) FROM JobTitles jobTitles";
	private static final String _SQL_COUNT_JOBTITLES_WHERE = "SELECT COUNT(jobTitles) FROM JobTitles jobTitles WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobTitles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobTitles exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobTitles exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobTitlesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static JobTitles _nullJobTitles = new JobTitlesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JobTitles> toCacheModel() {
				return _nullJobTitlesCacheModel;
			}
		};

	private static CacheModel<JobTitles> _nullJobTitlesCacheModel = new CacheModel<JobTitles>() {
			@Override
			public JobTitles toEntityModel() {
				return _nullJobTitles;
			}
		};
}