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

import com.rknowsys.eapp.hrm.NoSuchQualificationException;
import com.rknowsys.eapp.hrm.model.Qualification;
import com.rknowsys.eapp.hrm.model.impl.QualificationImpl;
import com.rknowsys.eapp.hrm.model.impl.QualificationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the qualification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see QualificationPersistence
 * @see QualificationUtil
 * @generated
 */
public class QualificationPersistenceImpl extends BasePersistenceImpl<Qualification>
	implements QualificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QualificationUtil} to access the qualification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QualificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QualificationModelImpl.ENTITY_CACHE_ENABLED,
			QualificationModelImpl.FINDER_CACHE_ENABLED,
			QualificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QualificationModelImpl.ENTITY_CACHE_ENABLED,
			QualificationModelImpl.FINDER_CACHE_ENABLED,
			QualificationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QualificationModelImpl.ENTITY_CACHE_ENABLED,
			QualificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public QualificationPersistenceImpl() {
		setModelClass(Qualification.class);
	}

	/**
	 * Caches the qualification in the entity cache if it is enabled.
	 *
	 * @param qualification the qualification
	 */
	@Override
	public void cacheResult(Qualification qualification) {
		EntityCacheUtil.putResult(QualificationModelImpl.ENTITY_CACHE_ENABLED,
			QualificationImpl.class, qualification.getPrimaryKey(),
			qualification);

		qualification.resetOriginalValues();
	}

	/**
	 * Caches the qualifications in the entity cache if it is enabled.
	 *
	 * @param qualifications the qualifications
	 */
	@Override
	public void cacheResult(List<Qualification> qualifications) {
		for (Qualification qualification : qualifications) {
			if (EntityCacheUtil.getResult(
						QualificationModelImpl.ENTITY_CACHE_ENABLED,
						QualificationImpl.class, qualification.getPrimaryKey()) == null) {
				cacheResult(qualification);
			}
			else {
				qualification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all qualifications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QualificationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QualificationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the qualification.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Qualification qualification) {
		EntityCacheUtil.removeResult(QualificationModelImpl.ENTITY_CACHE_ENABLED,
			QualificationImpl.class, qualification.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Qualification> qualifications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Qualification qualification : qualifications) {
			EntityCacheUtil.removeResult(QualificationModelImpl.ENTITY_CACHE_ENABLED,
				QualificationImpl.class, qualification.getPrimaryKey());
		}
	}

	/**
	 * Creates a new qualification with the primary key. Does not add the qualification to the database.
	 *
	 * @param id the primary key for the new qualification
	 * @return the new qualification
	 */
	@Override
	public Qualification create(long id) {
		Qualification qualification = new QualificationImpl();

		qualification.setNew(true);
		qualification.setPrimaryKey(id);

		return qualification;
	}

	/**
	 * Removes the qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the qualification
	 * @return the qualification that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchQualificationException if a qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Qualification remove(long id)
		throws NoSuchQualificationException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the qualification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the qualification
	 * @return the qualification that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchQualificationException if a qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Qualification remove(Serializable primaryKey)
		throws NoSuchQualificationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Qualification qualification = (Qualification)session.get(QualificationImpl.class,
					primaryKey);

			if (qualification == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQualificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(qualification);
		}
		catch (NoSuchQualificationException nsee) {
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
	protected Qualification removeImpl(Qualification qualification)
		throws SystemException {
		qualification = toUnwrappedModel(qualification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(qualification)) {
				qualification = (Qualification)session.get(QualificationImpl.class,
						qualification.getPrimaryKeyObj());
			}

			if (qualification != null) {
				session.delete(qualification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (qualification != null) {
			clearCache(qualification);
		}

		return qualification;
	}

	@Override
	public Qualification updateImpl(
		com.rknowsys.eapp.hrm.model.Qualification qualification)
		throws SystemException {
		qualification = toUnwrappedModel(qualification);

		boolean isNew = qualification.isNew();

		Session session = null;

		try {
			session = openSession();

			if (qualification.isNew()) {
				session.save(qualification);

				qualification.setNew(false);
			}
			else {
				session.merge(qualification);
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

		EntityCacheUtil.putResult(QualificationModelImpl.ENTITY_CACHE_ENABLED,
			QualificationImpl.class, qualification.getPrimaryKey(),
			qualification);

		return qualification;
	}

	protected Qualification toUnwrappedModel(Qualification qualification) {
		if (qualification instanceof QualificationImpl) {
			return qualification;
		}

		QualificationImpl qualificationImpl = new QualificationImpl();

		qualificationImpl.setNew(qualification.isNew());
		qualificationImpl.setPrimaryKey(qualification.getPrimaryKey());

		qualificationImpl.setId(qualification.getId());
		qualificationImpl.setGroupId(qualification.getGroupId());
		qualificationImpl.setCompanyId(qualification.getCompanyId());
		qualificationImpl.setUserId(qualification.getUserId());
		qualificationImpl.setCreateDate(qualification.getCreateDate());
		qualificationImpl.setModifiedDate(qualification.getModifiedDate());

		return qualificationImpl;
	}

	/**
	 * Returns the qualification with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the qualification
	 * @return the qualification
	 * @throws com.rknowsys.eapp.hrm.NoSuchQualificationException if a qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Qualification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQualificationException, SystemException {
		Qualification qualification = fetchByPrimaryKey(primaryKey);

		if (qualification == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQualificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return qualification;
	}

	/**
	 * Returns the qualification with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchQualificationException} if it could not be found.
	 *
	 * @param id the primary key of the qualification
	 * @return the qualification
	 * @throws com.rknowsys.eapp.hrm.NoSuchQualificationException if a qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Qualification findByPrimaryKey(long id)
		throws NoSuchQualificationException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the qualification
	 * @return the qualification, or <code>null</code> if a qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Qualification fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Qualification qualification = (Qualification)EntityCacheUtil.getResult(QualificationModelImpl.ENTITY_CACHE_ENABLED,
				QualificationImpl.class, primaryKey);

		if (qualification == _nullQualification) {
			return null;
		}

		if (qualification == null) {
			Session session = null;

			try {
				session = openSession();

				qualification = (Qualification)session.get(QualificationImpl.class,
						primaryKey);

				if (qualification != null) {
					cacheResult(qualification);
				}
				else {
					EntityCacheUtil.putResult(QualificationModelImpl.ENTITY_CACHE_ENABLED,
						QualificationImpl.class, primaryKey, _nullQualification);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(QualificationModelImpl.ENTITY_CACHE_ENABLED,
					QualificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return qualification;
	}

	/**
	 * Returns the qualification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the qualification
	 * @return the qualification, or <code>null</code> if a qualification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Qualification fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the qualifications.
	 *
	 * @return the qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Qualification> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.QualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @return the range of qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Qualification> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the qualifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.QualificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of qualifications
	 * @param end the upper bound of the range of qualifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of qualifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Qualification> findAll(int start, int end,
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

		List<Qualification> list = (List<Qualification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUALIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUALIFICATION;

				if (pagination) {
					sql = sql.concat(QualificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Qualification>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Qualification>(list);
				}
				else {
					list = (List<Qualification>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the qualifications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Qualification qualification : findAll()) {
			remove(qualification);
		}
	}

	/**
	 * Returns the number of qualifications.
	 *
	 * @return the number of qualifications
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

				Query q = session.createQuery(_SQL_COUNT_QUALIFICATION);

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
	 * Initializes the qualification persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.Qualification")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Qualification>> listenersList = new ArrayList<ModelListener<Qualification>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Qualification>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QualificationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_QUALIFICATION = "SELECT qualification FROM Qualification qualification";
	private static final String _SQL_COUNT_QUALIFICATION = "SELECT COUNT(qualification) FROM Qualification qualification";
	private static final String _ORDER_BY_ENTITY_ALIAS = "qualification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Qualification exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QualificationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static Qualification _nullQualification = new QualificationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Qualification> toCacheModel() {
				return _nullQualificationCacheModel;
			}
		};

	private static CacheModel<Qualification> _nullQualificationCacheModel = new CacheModel<Qualification>() {
			@Override
			public Qualification toEntityModel() {
				return _nullQualification;
			}
		};
}