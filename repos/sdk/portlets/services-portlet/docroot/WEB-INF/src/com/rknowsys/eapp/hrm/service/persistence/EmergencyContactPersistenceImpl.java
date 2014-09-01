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

import com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;
import com.rknowsys.eapp.hrm.model.EmergencyContact;
import com.rknowsys.eapp.hrm.model.impl.EmergencyContactImpl;
import com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the emergency contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see EmergencyContactPersistence
 * @see EmergencyContactUtil
 * @generated
 */
public class EmergencyContactPersistenceImpl extends BasePersistenceImpl<EmergencyContact>
	implements EmergencyContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmergencyContactUtil} to access the emergency contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmergencyContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmergencyContactImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmergencyContactPersistenceImpl() {
		setModelClass(EmergencyContact.class);
	}

	/**
	 * Caches the emergency contact in the entity cache if it is enabled.
	 *
	 * @param emergencyContact the emergency contact
	 */
	@Override
	public void cacheResult(EmergencyContact emergencyContact) {
		EntityCacheUtil.putResult(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactImpl.class, emergencyContact.getPrimaryKey(),
			emergencyContact);

		emergencyContact.resetOriginalValues();
	}

	/**
	 * Caches the emergency contacts in the entity cache if it is enabled.
	 *
	 * @param emergencyContacts the emergency contacts
	 */
	@Override
	public void cacheResult(List<EmergencyContact> emergencyContacts) {
		for (EmergencyContact emergencyContact : emergencyContacts) {
			if (EntityCacheUtil.getResult(
						EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
						EmergencyContactImpl.class,
						emergencyContact.getPrimaryKey()) == null) {
				cacheResult(emergencyContact);
			}
			else {
				emergencyContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emergency contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmergencyContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmergencyContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emergency contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmergencyContact emergencyContact) {
		EntityCacheUtil.removeResult(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactImpl.class, emergencyContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmergencyContact> emergencyContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmergencyContact emergencyContact : emergencyContacts) {
			EntityCacheUtil.removeResult(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
				EmergencyContactImpl.class, emergencyContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emergency contact with the primary key. Does not add the emergency contact to the database.
	 *
	 * @param id the primary key for the new emergency contact
	 * @return the new emergency contact
	 */
	@Override
	public EmergencyContact create(long id) {
		EmergencyContact emergencyContact = new EmergencyContactImpl();

		emergencyContact.setNew(true);
		emergencyContact.setPrimaryKey(id);

		return emergencyContact;
	}

	/**
	 * Removes the emergency contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the emergency contact
	 * @return the emergency contact that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a emergency contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact remove(long id)
		throws NoSuchEmergencyContactException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the emergency contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emergency contact
	 * @return the emergency contact that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a emergency contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact remove(Serializable primaryKey)
		throws NoSuchEmergencyContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmergencyContact emergencyContact = (EmergencyContact)session.get(EmergencyContactImpl.class,
					primaryKey);

			if (emergencyContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmergencyContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(emergencyContact);
		}
		catch (NoSuchEmergencyContactException nsee) {
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
	protected EmergencyContact removeImpl(EmergencyContact emergencyContact)
		throws SystemException {
		emergencyContact = toUnwrappedModel(emergencyContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emergencyContact)) {
				emergencyContact = (EmergencyContact)session.get(EmergencyContactImpl.class,
						emergencyContact.getPrimaryKeyObj());
			}

			if (emergencyContact != null) {
				session.delete(emergencyContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (emergencyContact != null) {
			clearCache(emergencyContact);
		}

		return emergencyContact;
	}

	@Override
	public EmergencyContact updateImpl(
		com.rknowsys.eapp.hrm.model.EmergencyContact emergencyContact)
		throws SystemException {
		emergencyContact = toUnwrappedModel(emergencyContact);

		boolean isNew = emergencyContact.isNew();

		Session session = null;

		try {
			session = openSession();

			if (emergencyContact.isNew()) {
				session.save(emergencyContact);

				emergencyContact.setNew(false);
			}
			else {
				session.merge(emergencyContact);
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

		EntityCacheUtil.putResult(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactImpl.class, emergencyContact.getPrimaryKey(),
			emergencyContact);

		return emergencyContact;
	}

	protected EmergencyContact toUnwrappedModel(
		EmergencyContact emergencyContact) {
		if (emergencyContact instanceof EmergencyContactImpl) {
			return emergencyContact;
		}

		EmergencyContactImpl emergencyContactImpl = new EmergencyContactImpl();

		emergencyContactImpl.setNew(emergencyContact.isNew());
		emergencyContactImpl.setPrimaryKey(emergencyContact.getPrimaryKey());

		emergencyContactImpl.setId(emergencyContact.getId());
		emergencyContactImpl.setGroupId(emergencyContact.getGroupId());
		emergencyContactImpl.setCompanyId(emergencyContact.getCompanyId());
		emergencyContactImpl.setUserId(emergencyContact.getUserId());
		emergencyContactImpl.setCreateDate(emergencyContact.getCreateDate());
		emergencyContactImpl.setModifiedDate(emergencyContact.getModifiedDate());

		return emergencyContactImpl;
	}

	/**
	 * Returns the emergency contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emergency contact
	 * @return the emergency contact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a emergency contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmergencyContactException, SystemException {
		EmergencyContact emergencyContact = fetchByPrimaryKey(primaryKey);

		if (emergencyContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmergencyContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return emergencyContact;
	}

	/**
	 * Returns the emergency contact with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmergencyContactException} if it could not be found.
	 *
	 * @param id the primary key of the emergency contact
	 * @return the emergency contact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a emergency contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact findByPrimaryKey(long id)
		throws NoSuchEmergencyContactException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the emergency contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emergency contact
	 * @return the emergency contact, or <code>null</code> if a emergency contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmergencyContact emergencyContact = (EmergencyContact)EntityCacheUtil.getResult(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
				EmergencyContactImpl.class, primaryKey);

		if (emergencyContact == _nullEmergencyContact) {
			return null;
		}

		if (emergencyContact == null) {
			Session session = null;

			try {
				session = openSession();

				emergencyContact = (EmergencyContact)session.get(EmergencyContactImpl.class,
						primaryKey);

				if (emergencyContact != null) {
					cacheResult(emergencyContact);
				}
				else {
					EntityCacheUtil.putResult(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
						EmergencyContactImpl.class, primaryKey,
						_nullEmergencyContact);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
					EmergencyContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return emergencyContact;
	}

	/**
	 * Returns the emergency contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the emergency contact
	 * @return the emergency contact, or <code>null</code> if a emergency contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the emergency contacts.
	 *
	 * @return the emergency contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emergency contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emergency contacts
	 * @param end the upper bound of the range of emergency contacts (not inclusive)
	 * @return the range of emergency contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emergency contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emergency contacts
	 * @param end the upper bound of the range of emergency contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emergency contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findAll(int start, int end,
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

		List<EmergencyContact> list = (List<EmergencyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMERGENCYCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMERGENCYCONTACT;

				if (pagination) {
					sql = sql.concat(EmergencyContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmergencyContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmergencyContact>(list);
				}
				else {
					list = (List<EmergencyContact>)QueryUtil.list(q,
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
	 * Removes all the emergency contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmergencyContact emergencyContact : findAll()) {
			remove(emergencyContact);
		}
	}

	/**
	 * Returns the number of emergency contacts.
	 *
	 * @return the number of emergency contacts
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

				Query q = session.createQuery(_SQL_COUNT_EMERGENCYCONTACT);

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
	 * Initializes the emergency contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.EmergencyContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmergencyContact>> listenersList = new ArrayList<ModelListener<EmergencyContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmergencyContact>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmergencyContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMERGENCYCONTACT = "SELECT emergencyContact FROM EmergencyContact emergencyContact";
	private static final String _SQL_COUNT_EMERGENCYCONTACT = "SELECT COUNT(emergencyContact) FROM EmergencyContact emergencyContact";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emergencyContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmergencyContact exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmergencyContactPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static EmergencyContact _nullEmergencyContact = new EmergencyContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmergencyContact> toCacheModel() {
				return _nullEmergencyContactCacheModel;
			}
		};

	private static CacheModel<EmergencyContact> _nullEmergencyContactCacheModel = new CacheModel<EmergencyContact>() {
			@Override
			public EmergencyContact toEntityModel() {
				return _nullEmergencyContact;
			}
		};
}