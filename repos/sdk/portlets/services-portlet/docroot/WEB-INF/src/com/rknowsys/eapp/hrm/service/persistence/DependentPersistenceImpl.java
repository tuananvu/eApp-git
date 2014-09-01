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

import com.rknowsys.eapp.hrm.NoSuchDependentException;
import com.rknowsys.eapp.hrm.model.Dependent;
import com.rknowsys.eapp.hrm.model.impl.DependentImpl;
import com.rknowsys.eapp.hrm.model.impl.DependentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dependent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see DependentPersistence
 * @see DependentUtil
 * @generated
 */
public class DependentPersistenceImpl extends BasePersistenceImpl<Dependent>
	implements DependentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DependentUtil} to access the dependent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DependentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DependentModelImpl.ENTITY_CACHE_ENABLED,
			DependentModelImpl.FINDER_CACHE_ENABLED, DependentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DependentModelImpl.ENTITY_CACHE_ENABLED,
			DependentModelImpl.FINDER_CACHE_ENABLED, DependentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DependentModelImpl.ENTITY_CACHE_ENABLED,
			DependentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public DependentPersistenceImpl() {
		setModelClass(Dependent.class);
	}

	/**
	 * Caches the dependent in the entity cache if it is enabled.
	 *
	 * @param dependent the dependent
	 */
	@Override
	public void cacheResult(Dependent dependent) {
		EntityCacheUtil.putResult(DependentModelImpl.ENTITY_CACHE_ENABLED,
			DependentImpl.class, dependent.getPrimaryKey(), dependent);

		dependent.resetOriginalValues();
	}

	/**
	 * Caches the dependents in the entity cache if it is enabled.
	 *
	 * @param dependents the dependents
	 */
	@Override
	public void cacheResult(List<Dependent> dependents) {
		for (Dependent dependent : dependents) {
			if (EntityCacheUtil.getResult(
						DependentModelImpl.ENTITY_CACHE_ENABLED,
						DependentImpl.class, dependent.getPrimaryKey()) == null) {
				cacheResult(dependent);
			}
			else {
				dependent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dependents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DependentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DependentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dependent.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dependent dependent) {
		EntityCacheUtil.removeResult(DependentModelImpl.ENTITY_CACHE_ENABLED,
			DependentImpl.class, dependent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Dependent> dependents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dependent dependent : dependents) {
			EntityCacheUtil.removeResult(DependentModelImpl.ENTITY_CACHE_ENABLED,
				DependentImpl.class, dependent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dependent with the primary key. Does not add the dependent to the database.
	 *
	 * @param dependentId the primary key for the new dependent
	 * @return the new dependent
	 */
	@Override
	public Dependent create(long dependentId) {
		Dependent dependent = new DependentImpl();

		dependent.setNew(true);
		dependent.setPrimaryKey(dependentId);

		return dependent;
	}

	/**
	 * Removes the dependent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dependentId the primary key of the dependent
	 * @return the dependent that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dependent remove(long dependentId)
		throws NoSuchDependentException, SystemException {
		return remove((Serializable)dependentId);
	}

	/**
	 * Removes the dependent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dependent
	 * @return the dependent that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dependent remove(Serializable primaryKey)
		throws NoSuchDependentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Dependent dependent = (Dependent)session.get(DependentImpl.class,
					primaryKey);

			if (dependent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDependentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dependent);
		}
		catch (NoSuchDependentException nsee) {
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
	protected Dependent removeImpl(Dependent dependent)
		throws SystemException {
		dependent = toUnwrappedModel(dependent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dependent)) {
				dependent = (Dependent)session.get(DependentImpl.class,
						dependent.getPrimaryKeyObj());
			}

			if (dependent != null) {
				session.delete(dependent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dependent != null) {
			clearCache(dependent);
		}

		return dependent;
	}

	@Override
	public Dependent updateImpl(com.rknowsys.eapp.hrm.model.Dependent dependent)
		throws SystemException {
		dependent = toUnwrappedModel(dependent);

		boolean isNew = dependent.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dependent.isNew()) {
				session.save(dependent);

				dependent.setNew(false);
			}
			else {
				session.merge(dependent);
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

		EntityCacheUtil.putResult(DependentModelImpl.ENTITY_CACHE_ENABLED,
			DependentImpl.class, dependent.getPrimaryKey(), dependent);

		return dependent;
	}

	protected Dependent toUnwrappedModel(Dependent dependent) {
		if (dependent instanceof DependentImpl) {
			return dependent;
		}

		DependentImpl dependentImpl = new DependentImpl();

		dependentImpl.setNew(dependent.isNew());
		dependentImpl.setPrimaryKey(dependent.getPrimaryKey());

		dependentImpl.setDependentId(dependent.getDependentId());
		dependentImpl.setGroupId(dependent.getGroupId());
		dependentImpl.setCompanyId(dependent.getCompanyId());
		dependentImpl.setUserId(dependent.getUserId());
		dependentImpl.setCreateDate(dependent.getCreateDate());
		dependentImpl.setModifiedDate(dependent.getModifiedDate());

		return dependentImpl;
	}

	/**
	 * Returns the dependent with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dependent
	 * @return the dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dependent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDependentException, SystemException {
		Dependent dependent = fetchByPrimaryKey(primaryKey);

		if (dependent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDependentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dependent;
	}

	/**
	 * Returns the dependent with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchDependentException} if it could not be found.
	 *
	 * @param dependentId the primary key of the dependent
	 * @return the dependent
	 * @throws com.rknowsys.eapp.hrm.NoSuchDependentException if a dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dependent findByPrimaryKey(long dependentId)
		throws NoSuchDependentException, SystemException {
		return findByPrimaryKey((Serializable)dependentId);
	}

	/**
	 * Returns the dependent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dependent
	 * @return the dependent, or <code>null</code> if a dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dependent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Dependent dependent = (Dependent)EntityCacheUtil.getResult(DependentModelImpl.ENTITY_CACHE_ENABLED,
				DependentImpl.class, primaryKey);

		if (dependent == _nullDependent) {
			return null;
		}

		if (dependent == null) {
			Session session = null;

			try {
				session = openSession();

				dependent = (Dependent)session.get(DependentImpl.class,
						primaryKey);

				if (dependent != null) {
					cacheResult(dependent);
				}
				else {
					EntityCacheUtil.putResult(DependentModelImpl.ENTITY_CACHE_ENABLED,
						DependentImpl.class, primaryKey, _nullDependent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DependentModelImpl.ENTITY_CACHE_ENABLED,
					DependentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dependent;
	}

	/**
	 * Returns the dependent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dependentId the primary key of the dependent
	 * @return the dependent, or <code>null</code> if a dependent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dependent fetchByPrimaryKey(long dependentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dependentId);
	}

	/**
	 * Returns all the dependents.
	 *
	 * @return the dependents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dependent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Dependent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Dependent> findAll(int start, int end,
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

		List<Dependent> list = (List<Dependent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEPENDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEPENDENT;

				if (pagination) {
					sql = sql.concat(DependentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dependent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dependent>(list);
				}
				else {
					list = (List<Dependent>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dependents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Dependent dependent : findAll()) {
			remove(dependent);
		}
	}

	/**
	 * Returns the number of dependents.
	 *
	 * @return the number of dependents
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

				Query q = session.createQuery(_SQL_COUNT_DEPENDENT);

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
	 * Initializes the dependent persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Dependent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Dependent>> listenersList = new ArrayList<ModelListener<Dependent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Dependent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DependentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEPENDENT = "SELECT dependent FROM Dependent dependent";
	private static final String _SQL_COUNT_DEPENDENT = "SELECT COUNT(dependent) FROM Dependent dependent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dependent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dependent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DependentPersistenceImpl.class);
	private static Dependent _nullDependent = new DependentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Dependent> toCacheModel() {
				return _nullDependentCacheModel;
			}
		};

	private static CacheModel<Dependent> _nullDependentCacheModel = new CacheModel<Dependent>() {
			@Override
			public Dependent toEntityModel() {
				return _nullDependent;
			}
		};
}