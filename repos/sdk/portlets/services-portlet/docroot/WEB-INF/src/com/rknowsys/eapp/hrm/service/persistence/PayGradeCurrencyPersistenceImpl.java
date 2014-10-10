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

import com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException;
import com.rknowsys.eapp.hrm.model.PayGradeCurrency;
import com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyImpl;
import com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the pay grade currency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see PayGradeCurrencyPersistence
 * @see PayGradeCurrencyUtil
 * @generated
 */
public class PayGradeCurrencyPersistenceImpl extends BasePersistenceImpl<PayGradeCurrency>
	implements PayGradeCurrencyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PayGradeCurrencyUtil} to access the pay grade currency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PayGradeCurrencyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyModelImpl.FINDER_CACHE_ENABLED,
			PayGradeCurrencyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyModelImpl.FINDER_CACHE_ENABLED,
			PayGradeCurrencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyModelImpl.FINDER_CACHE_ENABLED,
			PayGradeCurrencyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyModelImpl.FINDER_CACHE_ENABLED,
			PayGradeCurrencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			PayGradeCurrencyModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the pay grade currencies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching pay grade currencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGradeCurrency> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay grade currencies where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pay grade currencies
	 * @param end the upper bound of the range of pay grade currencies (not inclusive)
	 * @return the range of matching pay grade currencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGradeCurrency> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay grade currencies where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pay grade currencies
	 * @param end the upper bound of the range of pay grade currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pay grade currencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGradeCurrency> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<PayGradeCurrency> list = (List<PayGradeCurrency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PayGradeCurrency payGradeCurrency : list) {
				if ((groupId != payGradeCurrency.getGroupId())) {
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

			query.append(_SQL_SELECT_PAYGRADECURRENCY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PayGradeCurrencyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PayGradeCurrency>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PayGradeCurrency>(list);
				}
				else {
					list = (List<PayGradeCurrency>)QueryUtil.list(q,
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
	 * Returns the first pay grade currency in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay grade currency
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException if a matching pay grade currency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPayGradeCurrencyException, SystemException {
		PayGradeCurrency payGradeCurrency = fetchByGroupId_First(groupId,
				orderByComparator);

		if (payGradeCurrency != null) {
			return payGradeCurrency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayGradeCurrencyException(msg.toString());
	}

	/**
	 * Returns the first pay grade currency in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pay grade currency, or <code>null</code> if a matching pay grade currency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PayGradeCurrency> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pay grade currency in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay grade currency
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException if a matching pay grade currency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPayGradeCurrencyException, SystemException {
		PayGradeCurrency payGradeCurrency = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (payGradeCurrency != null) {
			return payGradeCurrency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPayGradeCurrencyException(msg.toString());
	}

	/**
	 * Returns the last pay grade currency in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pay grade currency, or <code>null</code> if a matching pay grade currency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<PayGradeCurrency> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pay grade currencies before and after the current pay grade currency in the ordered set where groupId = &#63;.
	 *
	 * @param payGradeCurrencyId the primary key of the current pay grade currency
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pay grade currency
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException if a pay grade currency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency[] findByGroupId_PrevAndNext(
		long payGradeCurrencyId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPayGradeCurrencyException, SystemException {
		PayGradeCurrency payGradeCurrency = findByPrimaryKey(payGradeCurrencyId);

		Session session = null;

		try {
			session = openSession();

			PayGradeCurrency[] array = new PayGradeCurrencyImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, payGradeCurrency,
					groupId, orderByComparator, true);

			array[1] = payGradeCurrency;

			array[2] = getByGroupId_PrevAndNext(session, payGradeCurrency,
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

	protected PayGradeCurrency getByGroupId_PrevAndNext(Session session,
		PayGradeCurrency payGradeCurrency, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PAYGRADECURRENCY_WHERE);

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
			query.append(PayGradeCurrencyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(payGradeCurrency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PayGradeCurrency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pay grade currencies where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (PayGradeCurrency payGradeCurrency : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(payGradeCurrency);
		}
	}

	/**
	 * Returns the number of pay grade currencies where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching pay grade currencies
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

			query.append(_SQL_COUNT_PAYGRADECURRENCY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "payGradeCurrency.groupId = ?";

	public PayGradeCurrencyPersistenceImpl() {
		setModelClass(PayGradeCurrency.class);
	}

	/**
	 * Caches the pay grade currency in the entity cache if it is enabled.
	 *
	 * @param payGradeCurrency the pay grade currency
	 */
	@Override
	public void cacheResult(PayGradeCurrency payGradeCurrency) {
		EntityCacheUtil.putResult(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyImpl.class, payGradeCurrency.getPrimaryKey(),
			payGradeCurrency);

		payGradeCurrency.resetOriginalValues();
	}

	/**
	 * Caches the pay grade currencies in the entity cache if it is enabled.
	 *
	 * @param payGradeCurrencies the pay grade currencies
	 */
	@Override
	public void cacheResult(List<PayGradeCurrency> payGradeCurrencies) {
		for (PayGradeCurrency payGradeCurrency : payGradeCurrencies) {
			if (EntityCacheUtil.getResult(
						PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
						PayGradeCurrencyImpl.class,
						payGradeCurrency.getPrimaryKey()) == null) {
				cacheResult(payGradeCurrency);
			}
			else {
				payGradeCurrency.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pay grade currencies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PayGradeCurrencyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PayGradeCurrencyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pay grade currency.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PayGradeCurrency payGradeCurrency) {
		EntityCacheUtil.removeResult(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyImpl.class, payGradeCurrency.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PayGradeCurrency> payGradeCurrencies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PayGradeCurrency payGradeCurrency : payGradeCurrencies) {
			EntityCacheUtil.removeResult(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
				PayGradeCurrencyImpl.class, payGradeCurrency.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pay grade currency with the primary key. Does not add the pay grade currency to the database.
	 *
	 * @param payGradeCurrencyId the primary key for the new pay grade currency
	 * @return the new pay grade currency
	 */
	@Override
	public PayGradeCurrency create(long payGradeCurrencyId) {
		PayGradeCurrency payGradeCurrency = new PayGradeCurrencyImpl();

		payGradeCurrency.setNew(true);
		payGradeCurrency.setPrimaryKey(payGradeCurrencyId);

		return payGradeCurrency;
	}

	/**
	 * Removes the pay grade currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param payGradeCurrencyId the primary key of the pay grade currency
	 * @return the pay grade currency that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException if a pay grade currency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency remove(long payGradeCurrencyId)
		throws NoSuchPayGradeCurrencyException, SystemException {
		return remove((Serializable)payGradeCurrencyId);
	}

	/**
	 * Removes the pay grade currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pay grade currency
	 * @return the pay grade currency that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException if a pay grade currency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency remove(Serializable primaryKey)
		throws NoSuchPayGradeCurrencyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PayGradeCurrency payGradeCurrency = (PayGradeCurrency)session.get(PayGradeCurrencyImpl.class,
					primaryKey);

			if (payGradeCurrency == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPayGradeCurrencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(payGradeCurrency);
		}
		catch (NoSuchPayGradeCurrencyException nsee) {
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
	protected PayGradeCurrency removeImpl(PayGradeCurrency payGradeCurrency)
		throws SystemException {
		payGradeCurrency = toUnwrappedModel(payGradeCurrency);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(payGradeCurrency)) {
				payGradeCurrency = (PayGradeCurrency)session.get(PayGradeCurrencyImpl.class,
						payGradeCurrency.getPrimaryKeyObj());
			}

			if (payGradeCurrency != null) {
				session.delete(payGradeCurrency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (payGradeCurrency != null) {
			clearCache(payGradeCurrency);
		}

		return payGradeCurrency;
	}

	@Override
	public PayGradeCurrency updateImpl(
		com.rknowsys.eapp.hrm.model.PayGradeCurrency payGradeCurrency)
		throws SystemException {
		payGradeCurrency = toUnwrappedModel(payGradeCurrency);

		boolean isNew = payGradeCurrency.isNew();

		PayGradeCurrencyModelImpl payGradeCurrencyModelImpl = (PayGradeCurrencyModelImpl)payGradeCurrency;

		Session session = null;

		try {
			session = openSession();

			if (payGradeCurrency.isNew()) {
				session.save(payGradeCurrency);

				payGradeCurrency.setNew(false);
			}
			else {
				session.merge(payGradeCurrency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PayGradeCurrencyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((payGradeCurrencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						payGradeCurrencyModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { payGradeCurrencyModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
			PayGradeCurrencyImpl.class, payGradeCurrency.getPrimaryKey(),
			payGradeCurrency);

		return payGradeCurrency;
	}

	protected PayGradeCurrency toUnwrappedModel(
		PayGradeCurrency payGradeCurrency) {
		if (payGradeCurrency instanceof PayGradeCurrencyImpl) {
			return payGradeCurrency;
		}

		PayGradeCurrencyImpl payGradeCurrencyImpl = new PayGradeCurrencyImpl();

		payGradeCurrencyImpl.setNew(payGradeCurrency.isNew());
		payGradeCurrencyImpl.setPrimaryKey(payGradeCurrency.getPrimaryKey());

		payGradeCurrencyImpl.setPayGradeCurrencyId(payGradeCurrency.getPayGradeCurrencyId());
		payGradeCurrencyImpl.setCompanyId(payGradeCurrency.getCompanyId());
		payGradeCurrencyImpl.setGroupId(payGradeCurrency.getGroupId());
		payGradeCurrencyImpl.setCreateDate(payGradeCurrency.getCreateDate());
		payGradeCurrencyImpl.setModifiedDate(payGradeCurrency.getModifiedDate());
		payGradeCurrencyImpl.setUserId(payGradeCurrency.getUserId());
		payGradeCurrencyImpl.setPayGradeId(payGradeCurrency.getPayGradeId());
		payGradeCurrencyImpl.setCurrency(payGradeCurrency.getCurrency());
		payGradeCurrencyImpl.setMinSalary(payGradeCurrency.getMinSalary());
		payGradeCurrencyImpl.setMaxSalary(payGradeCurrency.getMaxSalary());

		return payGradeCurrencyImpl;
	}

	/**
	 * Returns the pay grade currency with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay grade currency
	 * @return the pay grade currency
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException if a pay grade currency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPayGradeCurrencyException, SystemException {
		PayGradeCurrency payGradeCurrency = fetchByPrimaryKey(primaryKey);

		if (payGradeCurrency == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPayGradeCurrencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return payGradeCurrency;
	}

	/**
	 * Returns the pay grade currency with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException} if it could not be found.
	 *
	 * @param payGradeCurrencyId the primary key of the pay grade currency
	 * @return the pay grade currency
	 * @throws com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException if a pay grade currency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency findByPrimaryKey(long payGradeCurrencyId)
		throws NoSuchPayGradeCurrencyException, SystemException {
		return findByPrimaryKey((Serializable)payGradeCurrencyId);
	}

	/**
	 * Returns the pay grade currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pay grade currency
	 * @return the pay grade currency, or <code>null</code> if a pay grade currency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PayGradeCurrency payGradeCurrency = (PayGradeCurrency)EntityCacheUtil.getResult(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
				PayGradeCurrencyImpl.class, primaryKey);

		if (payGradeCurrency == _nullPayGradeCurrency) {
			return null;
		}

		if (payGradeCurrency == null) {
			Session session = null;

			try {
				session = openSession();

				payGradeCurrency = (PayGradeCurrency)session.get(PayGradeCurrencyImpl.class,
						primaryKey);

				if (payGradeCurrency != null) {
					cacheResult(payGradeCurrency);
				}
				else {
					EntityCacheUtil.putResult(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
						PayGradeCurrencyImpl.class, primaryKey,
						_nullPayGradeCurrency);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PayGradeCurrencyModelImpl.ENTITY_CACHE_ENABLED,
					PayGradeCurrencyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return payGradeCurrency;
	}

	/**
	 * Returns the pay grade currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param payGradeCurrencyId the primary key of the pay grade currency
	 * @return the pay grade currency, or <code>null</code> if a pay grade currency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PayGradeCurrency fetchByPrimaryKey(long payGradeCurrencyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)payGradeCurrencyId);
	}

	/**
	 * Returns all the pay grade currencies.
	 *
	 * @return the pay grade currencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGradeCurrency> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pay grade currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay grade currencies
	 * @param end the upper bound of the range of pay grade currencies (not inclusive)
	 * @return the range of pay grade currencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGradeCurrency> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pay grade currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay grade currencies
	 * @param end the upper bound of the range of pay grade currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pay grade currencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PayGradeCurrency> findAll(int start, int end,
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

		List<PayGradeCurrency> list = (List<PayGradeCurrency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PAYGRADECURRENCY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAYGRADECURRENCY;

				if (pagination) {
					sql = sql.concat(PayGradeCurrencyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PayGradeCurrency>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PayGradeCurrency>(list);
				}
				else {
					list = (List<PayGradeCurrency>)QueryUtil.list(q,
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
	 * Removes all the pay grade currencies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PayGradeCurrency payGradeCurrency : findAll()) {
			remove(payGradeCurrency);
		}
	}

	/**
	 * Returns the number of pay grade currencies.
	 *
	 * @return the number of pay grade currencies
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

				Query q = session.createQuery(_SQL_COUNT_PAYGRADECURRENCY);

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
	 * Initializes the pay grade currency persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.PayGradeCurrency")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PayGradeCurrency>> listenersList = new ArrayList<ModelListener<PayGradeCurrency>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PayGradeCurrency>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PayGradeCurrencyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PAYGRADECURRENCY = "SELECT payGradeCurrency FROM PayGradeCurrency payGradeCurrency";
	private static final String _SQL_SELECT_PAYGRADECURRENCY_WHERE = "SELECT payGradeCurrency FROM PayGradeCurrency payGradeCurrency WHERE ";
	private static final String _SQL_COUNT_PAYGRADECURRENCY = "SELECT COUNT(payGradeCurrency) FROM PayGradeCurrency payGradeCurrency";
	private static final String _SQL_COUNT_PAYGRADECURRENCY_WHERE = "SELECT COUNT(payGradeCurrency) FROM PayGradeCurrency payGradeCurrency WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "payGradeCurrency.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PayGradeCurrency exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PayGradeCurrency exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PayGradeCurrencyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static PayGradeCurrency _nullPayGradeCurrency = new PayGradeCurrencyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PayGradeCurrency> toCacheModel() {
				return _nullPayGradeCurrencyCacheModel;
			}
		};

	private static CacheModel<PayGradeCurrency> _nullPayGradeCurrencyCacheModel = new CacheModel<PayGradeCurrency>() {
			@Override
			public PayGradeCurrency toEntityModel() {
				return _nullPayGradeCurrency;
			}
		};
}