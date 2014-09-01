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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rknowsys.eapp.hrm.NoSuchImmigrationException;
import com.rknowsys.eapp.hrm.model.Immigration;
import com.rknowsys.eapp.hrm.model.impl.ImmigrationImpl;
import com.rknowsys.eapp.hrm.model.impl.ImmigrationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the immigration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ImmigrationPersistence
 * @see ImmigrationUtil
 * @generated
 */
public class ImmigrationPersistenceImpl extends BasePersistenceImpl<Immigration>
	implements ImmigrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImmigrationUtil} to access the immigration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImmigrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationModelImpl.FINDER_CACHE_ENABLED, ImmigrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationModelImpl.FINDER_CACHE_ENABLED, ImmigrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ImmigrationPersistenceImpl() {
		setModelClass(Immigration.class);
	}

	/**
	 * Caches the immigration in the entity cache if it is enabled.
	 *
	 * @param immigration the immigration
	 */
	@Override
	public void cacheResult(Immigration immigration) {
		EntityCacheUtil.putResult(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationImpl.class, immigration.getPrimaryKey(), immigration);

		immigration.resetOriginalValues();
	}

	/**
	 * Caches the immigrations in the entity cache if it is enabled.
	 *
	 * @param immigrations the immigrations
	 */
	@Override
	public void cacheResult(List<Immigration> immigrations) {
		for (Immigration immigration : immigrations) {
			if (EntityCacheUtil.getResult(
						ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
						ImmigrationImpl.class, immigration.getPrimaryKey()) == null) {
				cacheResult(immigration);
			}
			else {
				immigration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all immigrations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ImmigrationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ImmigrationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the immigration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Immigration immigration) {
		EntityCacheUtil.removeResult(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationImpl.class, immigration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Immigration> immigrations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Immigration immigration : immigrations) {
			EntityCacheUtil.removeResult(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
				ImmigrationImpl.class, immigration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new immigration with the primary key. Does not add the immigration to the database.
	 *
	 * @param id the primary key for the new immigration
	 * @return the new immigration
	 */
	@Override
	public Immigration create(long id) {
		Immigration immigration = new ImmigrationImpl();

		immigration.setNew(true);
		immigration.setPrimaryKey(id);

		return immigration;
	}

	/**
	 * Removes the immigration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the immigration
	 * @return the immigration that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationException if a immigration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Immigration remove(long id)
		throws NoSuchImmigrationException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the immigration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the immigration
	 * @return the immigration that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationException if a immigration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Immigration remove(Serializable primaryKey)
		throws NoSuchImmigrationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Immigration immigration = (Immigration)session.get(ImmigrationImpl.class,
					primaryKey);

			if (immigration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImmigrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(immigration);
		}
		catch (NoSuchImmigrationException nsee) {
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
	protected Immigration removeImpl(Immigration immigration)
		throws SystemException {
		immigration = toUnwrappedModel(immigration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(immigration)) {
				immigration = (Immigration)session.get(ImmigrationImpl.class,
						immigration.getPrimaryKeyObj());
			}

			if (immigration != null) {
				session.delete(immigration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (immigration != null) {
			clearCache(immigration);
		}

		return immigration;
	}

	@Override
	public Immigration updateImpl(
		com.rknowsys.eapp.hrm.model.Immigration immigration)
		throws SystemException {
		immigration = toUnwrappedModel(immigration);

		boolean isNew = immigration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (immigration.isNew()) {
				session.save(immigration);

				immigration.setNew(false);
			}
			else {
				session.merge(immigration);
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

		EntityCacheUtil.putResult(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationImpl.class, immigration.getPrimaryKey(), immigration);

		return immigration;
	}

	protected Immigration toUnwrappedModel(Immigration immigration) {
		if (immigration instanceof ImmigrationImpl) {
			return immigration;
		}

		ImmigrationImpl immigrationImpl = new ImmigrationImpl();

		immigrationImpl.setNew(immigration.isNew());
		immigrationImpl.setPrimaryKey(immigration.getPrimaryKey());

		immigrationImpl.setId(immigration.getId());
		immigrationImpl.setGroupId(immigration.getGroupId());
		immigrationImpl.setCompanyId(immigration.getCompanyId());
		immigrationImpl.setUserId(immigration.getUserId());
		immigrationImpl.setCreateDate(immigration.getCreateDate());
		immigrationImpl.setModifiedDate(immigration.getModifiedDate());

		return immigrationImpl;
	}

	/**
	 * Returns the immigration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the immigration
	 * @return the immigration
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationException if a immigration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Immigration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImmigrationException, SystemException {
		Immigration immigration = fetchByPrimaryKey(primaryKey);

		if (immigration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImmigrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return immigration;
	}

	/**
	 * Returns the immigration with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchImmigrationException} if it could not be found.
	 *
	 * @param id the primary key of the immigration
	 * @return the immigration
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationException if a immigration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Immigration findByPrimaryKey(long id)
		throws NoSuchImmigrationException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the immigration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the immigration
	 * @return the immigration, or <code>null</code> if a immigration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Immigration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Immigration immigration = (Immigration)EntityCacheUtil.getResult(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
				ImmigrationImpl.class, primaryKey);

		if (immigration == _nullImmigration) {
			return null;
		}

		if (immigration == null) {
			Session session = null;

			try {
				session = openSession();

				immigration = (Immigration)session.get(ImmigrationImpl.class,
						primaryKey);

				if (immigration != null) {
					cacheResult(immigration);
				}
				else {
					EntityCacheUtil.putResult(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
						ImmigrationImpl.class, primaryKey, _nullImmigration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ImmigrationModelImpl.ENTITY_CACHE_ENABLED,
					ImmigrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return immigration;
	}

	/**
	 * Returns the immigration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the immigration
	 * @return the immigration, or <code>null</code> if a immigration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Immigration fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the immigrations.
	 *
	 * @return the immigrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Immigration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the immigrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of immigrations
	 * @param end the upper bound of the range of immigrations (not inclusive)
	 * @return the range of immigrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Immigration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the immigrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of immigrations
	 * @param end the upper bound of the range of immigrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of immigrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Immigration> findAll(int start, int end,
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

		List<Immigration> list = (List<Immigration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMMIGRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMMIGRATION;

				if (pagination) {
					sql = sql.concat(ImmigrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Immigration>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Immigration>(list);
				}
				else {
					list = (List<Immigration>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the immigrations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Immigration immigration : findAll()) {
			remove(immigration);
		}
	}

	/**
	 * Returns the number of immigrations.
	 *
	 * @return the number of immigrations
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

				Query q = session.createQuery(_SQL_COUNT_IMMIGRATION);

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
	 * Initializes the immigration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Immigration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Immigration>> listenersList = new ArrayList<ModelListener<Immigration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Immigration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ImmigrationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IMMIGRATION = "SELECT immigration FROM Immigration immigration";
	private static final String _SQL_COUNT_IMMIGRATION = "SELECT COUNT(immigration) FROM Immigration immigration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "immigration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Immigration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ImmigrationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static Immigration _nullImmigration = new ImmigrationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Immigration> toCacheModel() {
				return _nullImmigrationCacheModel;
			}
		};

	private static CacheModel<Immigration> _nullImmigrationCacheModel = new CacheModel<Immigration>() {
			@Override
			public Immigration toEntityModel() {
				return _nullImmigration;
			}
		};
}