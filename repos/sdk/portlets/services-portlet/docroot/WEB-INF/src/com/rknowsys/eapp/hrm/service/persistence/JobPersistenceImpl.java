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

import com.rknowsys.eapp.hrm.NoSuchJobException;
import com.rknowsys.eapp.hrm.model.Job;
import com.rknowsys.eapp.hrm.model.impl.JobImpl;
import com.rknowsys.eapp.hrm.model.impl.JobModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see JobPersistence
 * @see JobUtil
 * @generated
 */
public class JobPersistenceImpl extends BasePersistenceImpl<Job>
	implements JobPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobUtil} to access the job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEID = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, JobImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmployeeId",
			new String[] { Long.class.getName() },
			JobModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the job where employeeId = &#63; or throws a {@link com.rknowsys.eapp.hrm.NoSuchJobException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching job
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobException if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByEmployeeId(long employeeId)
		throws NoSuchJobException, SystemException {
		Job job = fetchByEmployeeId(employeeId);

		if (job == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJobException(msg.toString());
		}

		return job;
	}

	/**
	 * Returns the job where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByEmployeeId(long employeeId) throws SystemException {
		return fetchByEmployeeId(employeeId, true);
	}

	/**
	 * Returns the job where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByEmployeeId(long employeeId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { employeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof Job) {
			Job job = (Job)result;

			if ((employeeId != job.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				List<Job> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"JobPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Job job = list.get(0);

					result = job;

					cacheResult(job);

					if ((job.getEmployeeId() != employeeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
							finderArgs, job);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Job)result;
		}
	}

	/**
	 * Removes the job where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the job that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job removeByEmployeeId(long employeeId)
		throws NoSuchJobException, SystemException {
		Job job = findByEmployeeId(employeeId);

		return remove(job);
	}

	/**
	 * Returns the number of jobs where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmployeeId(long employeeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "job.employeeId = ?";

	public JobPersistenceImpl() {
		setModelClass(Job.class);
	}

	/**
	 * Caches the job in the entity cache if it is enabled.
	 *
	 * @param job the job
	 */
	@Override
	public void cacheResult(Job job) {
		EntityCacheUtil.putResult(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobImpl.class, job.getPrimaryKey(), job);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
			new Object[] { job.getEmployeeId() }, job);

		job.resetOriginalValues();
	}

	/**
	 * Caches the jobs in the entity cache if it is enabled.
	 *
	 * @param jobs the jobs
	 */
	@Override
	public void cacheResult(List<Job> jobs) {
		for (Job job : jobs) {
			if (EntityCacheUtil.getResult(JobModelImpl.ENTITY_CACHE_ENABLED,
						JobImpl.class, job.getPrimaryKey()) == null) {
				cacheResult(job);
			}
			else {
				job.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jobs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Job job) {
		EntityCacheUtil.removeResult(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobImpl.class, job.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(job);
	}

	@Override
	public void clearCache(List<Job> jobs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Job job : jobs) {
			EntityCacheUtil.removeResult(JobModelImpl.ENTITY_CACHE_ENABLED,
				JobImpl.class, job.getPrimaryKey());

			clearUniqueFindersCache(job);
		}
	}

	protected void cacheUniqueFindersCache(Job job) {
		if (job.isNew()) {
			Object[] args = new Object[] { job.getEmployeeId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args, job);
		}
		else {
			JobModelImpl jobModelImpl = (JobModelImpl)job;

			if ((jobModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { job.getEmployeeId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					args, job);
			}
		}
	}

	protected void clearUniqueFindersCache(Job job) {
		JobModelImpl jobModelImpl = (JobModelImpl)job;

		Object[] args = new Object[] { job.getEmployeeId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);

		if ((jobModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
			args = new Object[] { jobModelImpl.getOriginalEmployeeId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}
	}

	/**
	 * Creates a new job with the primary key. Does not add the job to the database.
	 *
	 * @param jobId the primary key for the new job
	 * @return the new job
	 */
	@Override
	public Job create(long jobId) {
		Job job = new JobImpl();

		job.setNew(true);
		job.setPrimaryKey(jobId);

		return job;
	}

	/**
	 * Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job
	 * @return the job that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job remove(long jobId) throws NoSuchJobException, SystemException {
		return remove((Serializable)jobId);
	}

	/**
	 * Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job
	 * @return the job that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job remove(Serializable primaryKey)
		throws NoSuchJobException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Job job = (Job)session.get(JobImpl.class, primaryKey);

			if (job == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(job);
		}
		catch (NoSuchJobException nsee) {
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
	protected Job removeImpl(Job job) throws SystemException {
		job = toUnwrappedModel(job);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(job)) {
				job = (Job)session.get(JobImpl.class, job.getPrimaryKeyObj());
			}

			if (job != null) {
				session.delete(job);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (job != null) {
			clearCache(job);
		}

		return job;
	}

	@Override
	public Job updateImpl(com.rknowsys.eapp.hrm.model.Job job)
		throws SystemException {
		job = toUnwrappedModel(job);

		boolean isNew = job.isNew();

		Session session = null;

		try {
			session = openSession();

			if (job.isNew()) {
				session.save(job);

				job.setNew(false);
			}
			else {
				session.evict(job);
				session.saveOrUpdate(job);
			}

			session.flush();
			session.clear();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JobModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(JobModelImpl.ENTITY_CACHE_ENABLED,
			JobImpl.class, job.getPrimaryKey(), job);

		clearUniqueFindersCache(job);
		cacheUniqueFindersCache(job);

		job.resetOriginalValues();

		return job;
	}

	protected Job toUnwrappedModel(Job job) {
		if (job instanceof JobImpl) {
			return job;
		}

		JobImpl jobImpl = new JobImpl();

		jobImpl.setNew(job.isNew());
		jobImpl.setPrimaryKey(job.getPrimaryKey());

		jobImpl.setJobId(job.getJobId());
		jobImpl.setJobTitleId(job.getJobTitleId());
		jobImpl.setJobCategoryId(job.getJobCategoryId());
		jobImpl.setSubUnitId(job.getSubUnitId());
		jobImpl.setLocationId(job.getLocationId());
		jobImpl.setEmploymentStatusId(job.getEmploymentStatusId());
		jobImpl.setGroupId(job.getGroupId());
		jobImpl.setCompanyId(job.getCompanyId());
		jobImpl.setUserId(job.getUserId());
		jobImpl.setCreateDate(job.getCreateDate());
		jobImpl.setModifiedDate(job.getModifiedDate());
		jobImpl.setJoinedDate(job.getJoinedDate());
		jobImpl.setEmploymentContractStartDate(job.getEmploymentContractStartDate());
		jobImpl.setEmploymentContractEndDate(job.getEmploymentContractEndDate());
		jobImpl.setContractDetails(job.getContractDetails());
		jobImpl.setEmployeeId(job.getEmployeeId());

		return jobImpl;
	}

	/**
	 * Returns the job with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job
	 * @return the job
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobException, SystemException {
		Job job = fetchByPrimaryKey(primaryKey);

		if (job == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return job;
	}

	/**
	 * Returns the job with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchJobException} if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job
	 * @throws com.rknowsys.eapp.hrm.NoSuchJobException if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job findByPrimaryKey(long jobId)
		throws NoSuchJobException, SystemException {
		return findByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns the job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job
	 * @return the job, or <code>null</code> if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Job job = (Job)EntityCacheUtil.getResult(JobModelImpl.ENTITY_CACHE_ENABLED,
				JobImpl.class, primaryKey);

		if (job == _nullJob) {
			return null;
		}

		if (job == null) {
			Session session = null;

			try {
				session = openSession();

				job = (Job)session.get(JobImpl.class, primaryKey);

				if (job != null) {
					cacheResult(job);
				}
				else {
					EntityCacheUtil.putResult(JobModelImpl.ENTITY_CACHE_ENABLED,
						JobImpl.class, primaryKey, _nullJob);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JobModelImpl.ENTITY_CACHE_ENABLED,
					JobImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return job;
	}

	/**
	 * Returns the job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job, or <code>null</code> if a job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Job fetchByPrimaryKey(long jobId) throws SystemException {
		return fetchByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns all the jobs.
	 *
	 * @return the jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Job> findAll(int start, int end,
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

		List<Job> list = (List<Job>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOB;

				if (pagination) {
					sql = sql.concat(JobModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Job>(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the jobs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Job job : findAll()) {
			remove(job);
		}
	}

	/**
	 * Returns the number of jobs.
	 *
	 * @return the number of jobs
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

				Query q = session.createQuery(_SQL_COUNT_JOB);

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
	 * Initializes the job persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Job")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Job>> listenersList = new ArrayList<ModelListener<Job>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Job>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JobImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JOB = "SELECT job FROM Job job";
	private static final String _SQL_SELECT_JOB_WHERE = "SELECT job FROM Job job WHERE ";
	private static final String _SQL_COUNT_JOB = "SELECT COUNT(job) FROM Job job";
	private static final String _SQL_COUNT_JOB_WHERE = "SELECT COUNT(job) FROM Job job WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "job.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Job exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Job exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobPersistenceImpl.class);
	private static Job _nullJob = new JobImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Job> toCacheModel() {
				return _nullJobCacheModel;
			}
		};

	private static CacheModel<Job> _nullJobCacheModel = new CacheModel<Job>() {
			@Override
			public Job toEntityModel() {
				return _nullJob;
			}
		};
}