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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchSupervisorException;
import com.rknowsys.eapp.hrm.model.Supervisor;
import com.rknowsys.eapp.hrm.model.impl.SupervisorImpl;
import com.rknowsys.eapp.hrm.model.impl.SupervisorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the Supervisor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see SupervisorPersistence
 * @see SupervisorUtil
 * @generated
 */
public class SupervisorPersistenceImpl extends BasePersistenceImpl<Supervisor>
	implements SupervisorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SupervisorUtil} to access the Supervisor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SupervisorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
			SupervisorModelImpl.FINDER_CACHE_ENABLED, SupervisorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
			SupervisorModelImpl.FINDER_CACHE_ENABLED, SupervisorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
			SupervisorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SupervisorPersistenceImpl() {
		setModelClass(Supervisor.class);
	}

	/**
	 * Caches the Supervisor in the entity cache if it is enabled.
	 *
	 * @param supervisor the Supervisor
	 */
	@Override
	public void cacheResult(Supervisor supervisor) {
		EntityCacheUtil.putResult(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
			SupervisorImpl.class, supervisor.getPrimaryKey(), supervisor);

		supervisor.resetOriginalValues();
	}

	/**
	 * Caches the Supervisors in the entity cache if it is enabled.
	 *
	 * @param supervisors the Supervisors
	 */
	@Override
	public void cacheResult(List<Supervisor> supervisors) {
		for (Supervisor supervisor : supervisors) {
			if (EntityCacheUtil.getResult(
						SupervisorModelImpl.ENTITY_CACHE_ENABLED,
						SupervisorImpl.class, supervisor.getPrimaryKey()) == null) {
				cacheResult(supervisor);
			}
			else {
				supervisor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Supervisors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SupervisorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SupervisorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Supervisor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Supervisor supervisor) {
		EntityCacheUtil.removeResult(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
			SupervisorImpl.class, supervisor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Supervisor> supervisors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Supervisor supervisor : supervisors) {
			EntityCacheUtil.removeResult(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
				SupervisorImpl.class, supervisor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Supervisor with the primary key. Does not add the Supervisor to the database.
	 *
	 * @param supervisorId the primary key for the new Supervisor
	 * @return the new Supervisor
	 */
	@Override
	public Supervisor create(long supervisorId) {
		Supervisor supervisor = new SupervisorImpl();

		supervisor.setNew(true);
		supervisor.setPrimaryKey(supervisorId);

		return supervisor;
	}

	/**
	 * Removes the Supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supervisorId the primary key of the Supervisor
	 * @return the Supervisor that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchSupervisorException if a Supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Supervisor remove(long supervisorId)
		throws NoSuchSupervisorException, SystemException {
		return remove((Serializable)supervisorId);
	}

	/**
	 * Removes the Supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Supervisor
	 * @return the Supervisor that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchSupervisorException if a Supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Supervisor remove(Serializable primaryKey)
		throws NoSuchSupervisorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Supervisor supervisor = (Supervisor)session.get(SupervisorImpl.class,
					primaryKey);

			if (supervisor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupervisorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(supervisor);
		}
		catch (NoSuchSupervisorException nsee) {
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
	protected Supervisor removeImpl(Supervisor supervisor)
		throws SystemException {
		supervisor = toUnwrappedModel(supervisor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supervisor)) {
				supervisor = (Supervisor)session.get(SupervisorImpl.class,
						supervisor.getPrimaryKeyObj());
			}

			if (supervisor != null) {
				session.delete(supervisor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supervisor != null) {
			clearCache(supervisor);
		}

		return supervisor;
	}

	@Override
	public Supervisor updateImpl(
		com.rknowsys.eapp.hrm.model.Supervisor supervisor)
		throws SystemException {
		supervisor = toUnwrappedModel(supervisor);

		boolean isNew = supervisor.isNew();

		Session session = null;

		try {
			session = openSession();

			if (supervisor.isNew()) {
				session.save(supervisor);

				supervisor.setNew(false);
			}
			else {
				session.merge(supervisor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
			SupervisorImpl.class, supervisor.getPrimaryKey(), supervisor);

		return supervisor;
	}

	protected Supervisor toUnwrappedModel(Supervisor supervisor) {
		if (supervisor instanceof SupervisorImpl) {
			return supervisor;
		}

		SupervisorImpl supervisorImpl = new SupervisorImpl();

		supervisorImpl.setNew(supervisor.isNew());
		supervisorImpl.setPrimaryKey(supervisor.getPrimaryKey());

		supervisorImpl.setSupervisorId(supervisor.getSupervisorId());
		supervisorImpl.setEmployeeId(supervisor.getEmployeeId());
		supervisorImpl.setGroupId(supervisor.getGroupId());
		supervisorImpl.setCompanyId(supervisor.getCompanyId());
		supervisorImpl.setUserId(supervisor.getUserId());
		supervisorImpl.setUserName(supervisor.getUserName());
		supervisorImpl.setCreateDate(supervisor.getCreateDate());
		supervisorImpl.setModifiedDate(supervisor.getModifiedDate());
		supervisorImpl.setReportingMethod(supervisor.getReportingMethod());

		return supervisorImpl;
	}

	/**
	 * Returns the Supervisor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Supervisor
	 * @return the Supervisor
	 * @throws com.rknowsys.eapp.hrm.NoSuchSupervisorException if a Supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Supervisor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupervisorException, SystemException {
		Supervisor supervisor = fetchByPrimaryKey(primaryKey);

		if (supervisor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupervisorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return supervisor;
	}

	/**
	 * Returns the Supervisor with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchSupervisorException} if it could not be found.
	 *
	 * @param supervisorId the primary key of the Supervisor
	 * @return the Supervisor
	 * @throws com.rknowsys.eapp.hrm.NoSuchSupervisorException if a Supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Supervisor findByPrimaryKey(long supervisorId)
		throws NoSuchSupervisorException, SystemException {
		return findByPrimaryKey((Serializable)supervisorId);
	}

	/**
	 * Returns the Supervisor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Supervisor
	 * @return the Supervisor, or <code>null</code> if a Supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Supervisor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Supervisor supervisor = (Supervisor)EntityCacheUtil.getResult(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
				SupervisorImpl.class, primaryKey);

		if (supervisor == _nullSupervisor) {
			return null;
		}

		if (supervisor == null) {
			Session session = null;

			try {
				session = openSession();

				supervisor = (Supervisor)session.get(SupervisorImpl.class,
						primaryKey);

				if (supervisor != null) {
					cacheResult(supervisor);
				}
				else {
					EntityCacheUtil.putResult(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
						SupervisorImpl.class, primaryKey, _nullSupervisor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SupervisorModelImpl.ENTITY_CACHE_ENABLED,
					SupervisorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return supervisor;
	}

	/**
	 * Returns the Supervisor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supervisorId the primary key of the Supervisor
	 * @return the Supervisor, or <code>null</code> if a Supervisor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Supervisor fetchByPrimaryKey(long supervisorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)supervisorId);
	}

	/**
	 * Returns all the Supervisors.
	 *
	 * @return the Supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Supervisor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Supervisors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Supervisors
	 * @param end the upper bound of the range of Supervisors (not inclusive)
	 * @return the range of Supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Supervisor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Supervisors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.SupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Supervisors
	 * @param end the upper bound of the range of Supervisors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Supervisors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Supervisor> findAll(int start, int end,
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

		List<Supervisor> list = (List<Supervisor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUPERVISOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPERVISOR;

				if (pagination) {
					sql = sql.concat(SupervisorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Supervisor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Supervisor>(list);
				}
				else {
					list = (List<Supervisor>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Supervisors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Supervisor supervisor : findAll()) {
			remove(supervisor);
		}
	}

	/**
	 * Returns the number of Supervisors.
	 *
	 * @return the number of Supervisors
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

				Query q = session.createQuery(_SQL_COUNT_SUPERVISOR);

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
	 * Initializes the Supervisor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Supervisor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Supervisor>> listenersList = new ArrayList<ModelListener<Supervisor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Supervisor>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SupervisorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUPERVISOR = "SELECT supervisor FROM Supervisor supervisor";
	private static final String _SQL_COUNT_SUPERVISOR = "SELECT COUNT(supervisor) FROM Supervisor supervisor";
	private static final String _ORDER_BY_ENTITY_ALIAS = "supervisor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Supervisor exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SupervisorPersistenceImpl.class);
	private static Supervisor _nullSupervisor = new SupervisorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Supervisor> toCacheModel() {
				return _nullSupervisorCacheModel;
			}
		};

	private static CacheModel<Supervisor> _nullSupervisorCacheModel = new CacheModel<Supervisor>() {
			@Override
			public Supervisor toEntityModel() {
				return _nullSupervisor;
			}
		};
}