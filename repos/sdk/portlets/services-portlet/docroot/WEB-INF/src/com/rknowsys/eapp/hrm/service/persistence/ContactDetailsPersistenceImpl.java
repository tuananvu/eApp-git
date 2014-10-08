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

import com.rknowsys.eapp.hrm.NoSuchContactDetailsException;
import com.rknowsys.eapp.hrm.model.ContactDetails;
import com.rknowsys.eapp.hrm.model.impl.ContactDetailsImpl;
import com.rknowsys.eapp.hrm.model.impl.ContactDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the ContactDetails service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ContactDetailsPersistence
 * @see ContactDetailsUtil
 * @generated
 */
public class ContactDetailsPersistenceImpl extends BasePersistenceImpl<ContactDetails>
	implements ContactDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactDetailsUtil} to access the ContactDetails persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			ContactDetailsModelImpl.FINDER_CACHE_ENABLED,
			ContactDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			ContactDetailsModelImpl.FINDER_CACHE_ENABLED,
			ContactDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			ContactDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEID = new FinderPath(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			ContactDetailsModelImpl.FINDER_CACHE_ENABLED,
			ContactDetailsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmployeeId", new String[] { Long.class.getName() },
			ContactDetailsModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			ContactDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the ContactDetails where employeeId = &#63; or throws a {@link com.rknowsys.eapp.hrm.NoSuchContactDetailsException} if it could not be found.
	 *
	 * @param employeeId the employee ID
	 * @return the matching ContactDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a matching ContactDetails could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails findByEmployeeId(long employeeId)
		throws NoSuchContactDetailsException, SystemException {
		ContactDetails contactDetails = fetchByEmployeeId(employeeId);

		if (contactDetails == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContactDetailsException(msg.toString());
		}

		return contactDetails;
	}

	/**
	 * Returns the ContactDetails where employeeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @return the matching ContactDetails, or <code>null</code> if a matching ContactDetails could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails fetchByEmployeeId(long employeeId)
		throws SystemException {
		return fetchByEmployeeId(employeeId, true);
	}

	/**
	 * Returns the ContactDetails where employeeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param employeeId the employee ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching ContactDetails, or <code>null</code> if a matching ContactDetails could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails fetchByEmployeeId(long employeeId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { employeeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof ContactDetails) {
			ContactDetails contactDetails = (ContactDetails)result;

			if ((employeeId != contactDetails.getEmployeeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONTACTDETAILS_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				List<ContactDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ContactDetailsPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ContactDetails contactDetails = list.get(0);

					result = contactDetails;

					cacheResult(contactDetails);

					if ((contactDetails.getEmployeeId() != employeeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
							finderArgs, contactDetails);
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
			return (ContactDetails)result;
		}
	}

	/**
	 * Removes the ContactDetails where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @return the ContactDetails that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails removeByEmployeeId(long employeeId)
		throws NoSuchContactDetailsException, SystemException {
		ContactDetails contactDetails = findByEmployeeId(employeeId);

		return remove(contactDetails);
	}

	/**
	 * Returns the number of ContactDetailses where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching ContactDetailses
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

			query.append(_SQL_COUNT_CONTACTDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "contactDetails.employeeId = ?";

	public ContactDetailsPersistenceImpl() {
		setModelClass(ContactDetails.class);
	}

	/**
	 * Caches the ContactDetails in the entity cache if it is enabled.
	 *
	 * @param contactDetails the ContactDetails
	 */
	@Override
	public void cacheResult(ContactDetails contactDetails) {
		EntityCacheUtil.putResult(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			ContactDetailsImpl.class, contactDetails.getPrimaryKey(),
			contactDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
			new Object[] { contactDetails.getEmployeeId() }, contactDetails);

		contactDetails.resetOriginalValues();
	}

	/**
	 * Caches the ContactDetailses in the entity cache if it is enabled.
	 *
	 * @param contactDetailses the ContactDetailses
	 */
	@Override
	public void cacheResult(List<ContactDetails> contactDetailses) {
		for (ContactDetails contactDetails : contactDetailses) {
			if (EntityCacheUtil.getResult(
						ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
						ContactDetailsImpl.class, contactDetails.getPrimaryKey()) == null) {
				cacheResult(contactDetails);
			}
			else {
				contactDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ContactDetailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ContactDetails.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactDetails contactDetails) {
		EntityCacheUtil.removeResult(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			ContactDetailsImpl.class, contactDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(contactDetails);
	}

	@Override
	public void clearCache(List<ContactDetails> contactDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactDetails contactDetails : contactDetailses) {
			EntityCacheUtil.removeResult(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
				ContactDetailsImpl.class, contactDetails.getPrimaryKey());

			clearUniqueFindersCache(contactDetails);
		}
	}

	protected void cacheUniqueFindersCache(ContactDetails contactDetails) {
		if (contactDetails.isNew()) {
			Object[] args = new Object[] { contactDetails.getEmployeeId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args,
				contactDetails);
		}
		else {
			ContactDetailsModelImpl contactDetailsModelImpl = (ContactDetailsModelImpl)contactDetails;

			if ((contactDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { contactDetails.getEmployeeId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					args, contactDetails);
			}
		}
	}

	protected void clearUniqueFindersCache(ContactDetails contactDetails) {
		ContactDetailsModelImpl contactDetailsModelImpl = (ContactDetailsModelImpl)contactDetails;

		Object[] args = new Object[] { contactDetails.getEmployeeId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);

		if ((contactDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
			args = new Object[] { contactDetailsModelImpl.getOriginalEmployeeId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}
	}

	/**
	 * Creates a new ContactDetails with the primary key. Does not add the ContactDetails to the database.
	 *
	 * @param contactDetailsId the primary key for the new ContactDetails
	 * @return the new ContactDetails
	 */
	@Override
	public ContactDetails create(long contactDetailsId) {
		ContactDetails contactDetails = new ContactDetailsImpl();

		contactDetails.setNew(true);
		contactDetails.setPrimaryKey(contactDetailsId);

		return contactDetails;
	}

	/**
	 * Removes the ContactDetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactDetailsId the primary key of the ContactDetails
	 * @return the ContactDetails that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a ContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails remove(long contactDetailsId)
		throws NoSuchContactDetailsException, SystemException {
		return remove((Serializable)contactDetailsId);
	}

	/**
	 * Removes the ContactDetails with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ContactDetails
	 * @return the ContactDetails that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a ContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails remove(Serializable primaryKey)
		throws NoSuchContactDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactDetails contactDetails = (ContactDetails)session.get(ContactDetailsImpl.class,
					primaryKey);

			if (contactDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactDetails);
		}
		catch (NoSuchContactDetailsException nsee) {
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
	protected ContactDetails removeImpl(ContactDetails contactDetails)
		throws SystemException {
		contactDetails = toUnwrappedModel(contactDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactDetails)) {
				contactDetails = (ContactDetails)session.get(ContactDetailsImpl.class,
						contactDetails.getPrimaryKeyObj());
			}

			if (contactDetails != null) {
				session.delete(contactDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactDetails != null) {
			clearCache(contactDetails);
		}

		return contactDetails;
	}

	@Override
	public ContactDetails updateImpl(
		com.rknowsys.eapp.hrm.model.ContactDetails contactDetails)
		throws SystemException {
		contactDetails = toUnwrappedModel(contactDetails);

		boolean isNew = contactDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (contactDetails.isNew()) {
				session.save(contactDetails);

				contactDetails.setNew(false);
			}
			else {
				session.merge(contactDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
			ContactDetailsImpl.class, contactDetails.getPrimaryKey(),
			contactDetails);

		clearUniqueFindersCache(contactDetails);
		cacheUniqueFindersCache(contactDetails);

		return contactDetails;
	}

	protected ContactDetails toUnwrappedModel(ContactDetails contactDetails) {
		if (contactDetails instanceof ContactDetailsImpl) {
			return contactDetails;
		}

		ContactDetailsImpl contactDetailsImpl = new ContactDetailsImpl();

		contactDetailsImpl.setNew(contactDetails.isNew());
		contactDetailsImpl.setPrimaryKey(contactDetails.getPrimaryKey());

		contactDetailsImpl.setContactDetailsId(contactDetails.getContactDetailsId());
		contactDetailsImpl.setGroupId(contactDetails.getGroupId());
		contactDetailsImpl.setCompanyId(contactDetails.getCompanyId());
		contactDetailsImpl.setUserId(contactDetails.getUserId());
		contactDetailsImpl.setUserName(contactDetails.getUserName());
		contactDetailsImpl.setCreateDate(contactDetails.getCreateDate());
		contactDetailsImpl.setModifiedDate(contactDetails.getModifiedDate());
		contactDetailsImpl.setAddressStreet1(contactDetails.getAddressStreet1());
		contactDetailsImpl.setAddressStreet2(contactDetails.getAddressStreet2());
		contactDetailsImpl.setCity(contactDetails.getCity());
		contactDetailsImpl.setState(contactDetails.getState());
		contactDetailsImpl.setPostalCode(contactDetails.getPostalCode());
		contactDetailsImpl.setCountry(contactDetails.getCountry());
		contactDetailsImpl.setHomeTelephone(contactDetails.getHomeTelephone());
		contactDetailsImpl.setMobile(contactDetails.getMobile());
		contactDetailsImpl.setWorkTelephone(contactDetails.getWorkTelephone());
		contactDetailsImpl.setWorkEmail(contactDetails.getWorkEmail());
		contactDetailsImpl.setOtherEmail(contactDetails.getOtherEmail());
		contactDetailsImpl.setEmployeeId(contactDetails.getEmployeeId());

		return contactDetailsImpl;
	}

	/**
	 * Returns the ContactDetails with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ContactDetails
	 * @return the ContactDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a ContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactDetailsException, SystemException {
		ContactDetails contactDetails = fetchByPrimaryKey(primaryKey);

		if (contactDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contactDetails;
	}

	/**
	 * Returns the ContactDetails with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchContactDetailsException} if it could not be found.
	 *
	 * @param contactDetailsId the primary key of the ContactDetails
	 * @return the ContactDetails
	 * @throws com.rknowsys.eapp.hrm.NoSuchContactDetailsException if a ContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails findByPrimaryKey(long contactDetailsId)
		throws NoSuchContactDetailsException, SystemException {
		return findByPrimaryKey((Serializable)contactDetailsId);
	}

	/**
	 * Returns the ContactDetails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ContactDetails
	 * @return the ContactDetails, or <code>null</code> if a ContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContactDetails contactDetails = (ContactDetails)EntityCacheUtil.getResult(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
				ContactDetailsImpl.class, primaryKey);

		if (contactDetails == _nullContactDetails) {
			return null;
		}

		if (contactDetails == null) {
			Session session = null;

			try {
				session = openSession();

				contactDetails = (ContactDetails)session.get(ContactDetailsImpl.class,
						primaryKey);

				if (contactDetails != null) {
					cacheResult(contactDetails);
				}
				else {
					EntityCacheUtil.putResult(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
						ContactDetailsImpl.class, primaryKey,
						_nullContactDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContactDetailsModelImpl.ENTITY_CACHE_ENABLED,
					ContactDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contactDetails;
	}

	/**
	 * Returns the ContactDetails with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactDetailsId the primary key of the ContactDetails
	 * @return the ContactDetails, or <code>null</code> if a ContactDetails with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactDetails fetchByPrimaryKey(long contactDetailsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contactDetailsId);
	}

	/**
	 * Returns all the ContactDetailses.
	 *
	 * @return the ContactDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ContactDetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ContactDetailses
	 * @param end the upper bound of the range of ContactDetailses (not inclusive)
	 * @return the range of ContactDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ContactDetailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ContactDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ContactDetailses
	 * @param end the upper bound of the range of ContactDetailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ContactDetailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactDetails> findAll(int start, int end,
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

		List<ContactDetails> list = (List<ContactDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTDETAILS;

				if (pagination) {
					sql = sql.concat(ContactDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactDetails>(list);
				}
				else {
					list = (List<ContactDetails>)QueryUtil.list(q,
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
	 * Removes all the ContactDetailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContactDetails contactDetails : findAll()) {
			remove(contactDetails);
		}
	}

	/**
	 * Returns the number of ContactDetailses.
	 *
	 * @return the number of ContactDetailses
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

				Query q = session.createQuery(_SQL_COUNT_CONTACTDETAILS);

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
	 * Initializes the ContactDetails persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.ContactDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactDetails>> listenersList = new ArrayList<ModelListener<ContactDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTACTDETAILS = "SELECT contactDetails FROM ContactDetails contactDetails";
	private static final String _SQL_SELECT_CONTACTDETAILS_WHERE = "SELECT contactDetails FROM ContactDetails contactDetails WHERE ";
	private static final String _SQL_COUNT_CONTACTDETAILS = "SELECT COUNT(contactDetails) FROM ContactDetails contactDetails";
	private static final String _SQL_COUNT_CONTACTDETAILS_WHERE = "SELECT COUNT(contactDetails) FROM ContactDetails contactDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactDetails exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactDetailsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
	private static ContactDetails _nullContactDetails = new ContactDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactDetails> toCacheModel() {
				return _nullContactDetailsCacheModel;
			}
		};

	private static CacheModel<ContactDetails> _nullContactDetailsCacheModel = new CacheModel<ContactDetails>() {
			@Override
			public ContactDetails toEntityModel() {
				return _nullContactDetails;
			}
		};
}