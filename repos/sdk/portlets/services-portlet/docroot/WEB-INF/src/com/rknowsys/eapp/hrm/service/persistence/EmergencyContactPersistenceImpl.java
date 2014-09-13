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

import com.rknowsys.eapp.hrm.NoSuchEmergencyContactException;
import com.rknowsys.eapp.hrm.model.EmergencyContact;
import com.rknowsys.eapp.hrm.model.impl.EmergencyContactImpl;
import com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the EmergencyContact service.
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
	 * Never modify or reference this class directly. Always use {@link EmergencyContactUtil} to access the EmergencyContact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMERGENCYCONTACTID =
		new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmergencyContactImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemergencyContactId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMERGENCYCONTACTID =
		new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemergencyContactId", new String[] { Long.class.getName() },
			EmergencyContactModelImpl.EMERGENCYCONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMERGENCYCONTACTID = new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemergencyContactId", new String[] { Long.class.getName() });

	/**
	 * Returns all the EmergencyContacts where emergencyContactId = &#63;.
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @return the matching EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findByemergencyContactId(
		long emergencyContactId) throws SystemException {
		return findByemergencyContactId(emergencyContactId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmergencyContacts where emergencyContactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @param start the lower bound of the range of EmergencyContacts
	 * @param end the upper bound of the range of EmergencyContacts (not inclusive)
	 * @return the range of matching EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findByemergencyContactId(
		long emergencyContactId, int start, int end) throws SystemException {
		return findByemergencyContactId(emergencyContactId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmergencyContacts where emergencyContactId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @param start the lower bound of the range of EmergencyContacts
	 * @param end the upper bound of the range of EmergencyContacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findByemergencyContactId(
		long emergencyContactId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMERGENCYCONTACTID;
			finderArgs = new Object[] { emergencyContactId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMERGENCYCONTACTID;
			finderArgs = new Object[] {
					emergencyContactId,
					
					start, end, orderByComparator
				};
		}

		List<EmergencyContact> list = (List<EmergencyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmergencyContact emergencyContact : list) {
				if ((emergencyContactId != emergencyContact.getEmergencyContactId())) {
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

			query.append(_SQL_SELECT_EMERGENCYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_EMERGENCYCONTACTID_EMERGENCYCONTACTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmergencyContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(emergencyContactId);

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
	 * Returns the first EmergencyContact in the ordered set where emergencyContactId = &#63;.
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact findByemergencyContactId_First(
		long emergencyContactId, OrderByComparator orderByComparator)
		throws NoSuchEmergencyContactException, SystemException {
		EmergencyContact emergencyContact = fetchByemergencyContactId_First(emergencyContactId,
				orderByComparator);

		if (emergencyContact != null) {
			return emergencyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emergencyContactId=");
		msg.append(emergencyContactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmergencyContactException(msg.toString());
	}

	/**
	 * Returns the first EmergencyContact in the ordered set where emergencyContactId = &#63;.
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact fetchByemergencyContactId_First(
		long emergencyContactId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EmergencyContact> list = findByemergencyContactId(emergencyContactId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmergencyContact in the ordered set where emergencyContactId = &#63;.
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact findByemergencyContactId_Last(
		long emergencyContactId, OrderByComparator orderByComparator)
		throws NoSuchEmergencyContactException, SystemException {
		EmergencyContact emergencyContact = fetchByemergencyContactId_Last(emergencyContactId,
				orderByComparator);

		if (emergencyContact != null) {
			return emergencyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emergencyContactId=");
		msg.append(emergencyContactId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmergencyContactException(msg.toString());
	}

	/**
	 * Returns the last EmergencyContact in the ordered set where emergencyContactId = &#63;.
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact fetchByemergencyContactId_Last(
		long emergencyContactId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByemergencyContactId(emergencyContactId);

		if (count == 0) {
			return null;
		}

		List<EmergencyContact> list = findByemergencyContactId(emergencyContactId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the EmergencyContacts where emergencyContactId = &#63; from the database.
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemergencyContactId(long emergencyContactId)
		throws SystemException {
		for (EmergencyContact emergencyContact : findByemergencyContactId(
				emergencyContactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(emergencyContact);
		}
	}

	/**
	 * Returns the number of EmergencyContacts where emergencyContactId = &#63;.
	 *
	 * @param emergencyContactId the emergency contact ID
	 * @return the number of matching EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemergencyContactId(long emergencyContactId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMERGENCYCONTACTID;

		Object[] finderArgs = new Object[] { emergencyContactId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMERGENCYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_EMERGENCYCONTACTID_EMERGENCYCONTACTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(emergencyContactId);

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

	private static final String _FINDER_COLUMN_EMERGENCYCONTACTID_EMERGENCYCONTACTID_2 =
		"emergencyContact.emergencyContactId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmergencyContactImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED,
			EmergencyContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			EmergencyContactModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the EmergencyContacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmergencyContacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmergencyContacts
	 * @param end the upper bound of the range of EmergencyContacts (not inclusive)
	 * @return the range of matching EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findByemployeeId(long employeeId, int start,
		int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmergencyContacts where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of EmergencyContacts
	 * @param end the upper bound of the range of EmergencyContacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findByemployeeId(long employeeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<EmergencyContact> list = (List<EmergencyContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmergencyContact emergencyContact : list) {
				if ((employeeId != emergencyContact.getEmployeeId())) {
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

			query.append(_SQL_SELECT_EMERGENCYCONTACT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmergencyContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

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
	 * Returns the first EmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmergencyContactException, SystemException {
		EmergencyContact emergencyContact = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (emergencyContact != null) {
			return emergencyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmergencyContactException(msg.toString());
	}

	/**
	 * Returns the first EmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmergencyContact> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last EmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a matching EmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmergencyContactException, SystemException {
		EmergencyContact emergencyContact = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (emergencyContact != null) {
			return emergencyContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmergencyContactException(msg.toString());
	}

	/**
	 * Returns the last EmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching EmergencyContact, or <code>null</code> if a matching EmergencyContact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<EmergencyContact> list = findByemployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the EmergencyContacts before and after the current EmergencyContact in the ordered set where employeeId = &#63;.
	 *
	 * @param emergencyContactId the primary key of the current EmergencyContact
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next EmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact[] findByemployeeId_PrevAndNext(
		long emergencyContactId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEmergencyContactException, SystemException {
		EmergencyContact emergencyContact = findByPrimaryKey(emergencyContactId);

		Session session = null;

		try {
			session = openSession();

			EmergencyContact[] array = new EmergencyContactImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session, emergencyContact,
					employeeId, orderByComparator, true);

			array[1] = emergencyContact;

			array[2] = getByemployeeId_PrevAndNext(session, emergencyContact,
					employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmergencyContact getByemployeeId_PrevAndNext(Session session,
		EmergencyContact emergencyContact, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMERGENCYCONTACT_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			query.append(EmergencyContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(emergencyContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmergencyContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the EmergencyContacts where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (EmergencyContact emergencyContact : findByemployeeId(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(emergencyContact);
		}
	}

	/**
	 * Returns the number of EmergencyContacts where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemployeeId(long employeeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMERGENCYCONTACT_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "emergencyContact.employeeId = ?";

	public EmergencyContactPersistenceImpl() {
		setModelClass(EmergencyContact.class);
	}

	/**
	 * Caches the EmergencyContact in the entity cache if it is enabled.
	 *
	 * @param emergencyContact the EmergencyContact
	 */
	@Override
	public void cacheResult(EmergencyContact emergencyContact) {
		EntityCacheUtil.putResult(EmergencyContactModelImpl.ENTITY_CACHE_ENABLED,
			EmergencyContactImpl.class, emergencyContact.getPrimaryKey(),
			emergencyContact);

		emergencyContact.resetOriginalValues();
	}

	/**
	 * Caches the EmergencyContacts in the entity cache if it is enabled.
	 *
	 * @param emergencyContacts the EmergencyContacts
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
	 * Clears the cache for all EmergencyContacts.
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
	 * Clears the cache for the EmergencyContact.
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
	 * Creates a new EmergencyContact with the primary key. Does not add the EmergencyContact to the database.
	 *
	 * @param emergencyContactId the primary key for the new EmergencyContact
	 * @return the new EmergencyContact
	 */
	@Override
	public EmergencyContact create(long emergencyContactId) {
		EmergencyContact emergencyContact = new EmergencyContactImpl();

		emergencyContact.setNew(true);
		emergencyContact.setPrimaryKey(emergencyContactId);

		return emergencyContact;
	}

	/**
	 * Removes the EmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param emergencyContactId the primary key of the EmergencyContact
	 * @return the EmergencyContact that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact remove(long emergencyContactId)
		throws NoSuchEmergencyContactException, SystemException {
		return remove((Serializable)emergencyContactId);
	}

	/**
	 * Removes the EmergencyContact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the EmergencyContact
	 * @return the EmergencyContact that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
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

		EmergencyContactModelImpl emergencyContactModelImpl = (EmergencyContactModelImpl)emergencyContact;

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

		if (isNew || !EmergencyContactModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((emergencyContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMERGENCYCONTACTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emergencyContactModelImpl.getOriginalEmergencyContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMERGENCYCONTACTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMERGENCYCONTACTID,
					args);

				args = new Object[] {
						emergencyContactModelImpl.getEmergencyContactId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMERGENCYCONTACTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMERGENCYCONTACTID,
					args);
			}

			if ((emergencyContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						emergencyContactModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { emergencyContactModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
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

		emergencyContactImpl.setEmergencyContactId(emergencyContact.getEmergencyContactId());
		emergencyContactImpl.setEmployeeId(emergencyContact.getEmployeeId());
		emergencyContactImpl.setGroupId(emergencyContact.getGroupId());
		emergencyContactImpl.setCompanyId(emergencyContact.getCompanyId());
		emergencyContactImpl.setUserId(emergencyContact.getUserId());
		emergencyContactImpl.setCreateDate(emergencyContact.getCreateDate());
		emergencyContactImpl.setModifiedDate(emergencyContact.getModifiedDate());
		emergencyContactImpl.setName(emergencyContact.getName());
		emergencyContactImpl.setRelationship(emergencyContact.getRelationship());
		emergencyContactImpl.setHomeTelephone(emergencyContact.getHomeTelephone());
		emergencyContactImpl.setMobile(emergencyContact.getMobile());
		emergencyContactImpl.setWorkTelephone(emergencyContact.getWorkTelephone());

		return emergencyContactImpl;
	}

	/**
	 * Returns the EmergencyContact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmergencyContact
	 * @return the EmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
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
	 * Returns the EmergencyContact with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchEmergencyContactException} if it could not be found.
	 *
	 * @param emergencyContactId the primary key of the EmergencyContact
	 * @return the EmergencyContact
	 * @throws com.rknowsys.eapp.hrm.NoSuchEmergencyContactException if a EmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact findByPrimaryKey(long emergencyContactId)
		throws NoSuchEmergencyContactException, SystemException {
		return findByPrimaryKey((Serializable)emergencyContactId);
	}

	/**
	 * Returns the EmergencyContact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the EmergencyContact
	 * @return the EmergencyContact, or <code>null</code> if a EmergencyContact with the primary key could not be found
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
	 * Returns the EmergencyContact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param emergencyContactId the primary key of the EmergencyContact
	 * @return the EmergencyContact, or <code>null</code> if a EmergencyContact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmergencyContact fetchByPrimaryKey(long emergencyContactId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)emergencyContactId);
	}

	/**
	 * Returns all the EmergencyContacts.
	 *
	 * @return the EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the EmergencyContacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmergencyContacts
	 * @param end the upper bound of the range of EmergencyContacts (not inclusive)
	 * @return the range of EmergencyContacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmergencyContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the EmergencyContacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.EmergencyContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of EmergencyContacts
	 * @param end the upper bound of the range of EmergencyContacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of EmergencyContacts
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
	 * Removes all the EmergencyContacts from the database.
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
	 * Returns the number of EmergencyContacts.
	 *
	 * @return the number of EmergencyContacts
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

	/**
	 * Initializes the EmergencyContact persistence.
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
	private static final String _SQL_SELECT_EMERGENCYCONTACT_WHERE = "SELECT emergencyContact FROM EmergencyContact emergencyContact WHERE ";
	private static final String _SQL_COUNT_EMERGENCYCONTACT = "SELECT COUNT(emergencyContact) FROM EmergencyContact emergencyContact";
	private static final String _SQL_COUNT_EMERGENCYCONTACT_WHERE = "SELECT COUNT(emergencyContact) FROM EmergencyContact emergencyContact WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emergencyContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmergencyContact exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmergencyContact exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmergencyContactPersistenceImpl.class);
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