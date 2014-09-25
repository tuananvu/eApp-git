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

import com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException;
import com.rknowsys.eapp.hrm.model.ImmigrationDocument;
import com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentImpl;
import com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ImmigrationDocument service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rknowsys
 * @see ImmigrationDocumentPersistence
 * @see ImmigrationDocumentUtil
 * @generated
 */
public class ImmigrationDocumentPersistenceImpl extends BasePersistenceImpl<ImmigrationDocument>
	implements ImmigrationDocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImmigrationDocumentUtil} to access the ImmigrationDocument persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImmigrationDocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			ImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			ImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			ImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			ImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ImmigrationDocumentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ImmigrationDocuments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ImmigrationDocuments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @return the range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ImmigrationDocuments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByGroupId(long groupId, int start,
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

		List<ImmigrationDocument> list = (List<ImmigrationDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ImmigrationDocument immigrationDocument : list) {
				if ((groupId != immigrationDocument.getGroupId())) {
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

			query.append(_SQL_SELECT_IMMIGRATIONDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImmigrationDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ImmigrationDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImmigrationDocument>(list);
				}
				else {
					list = (List<ImmigrationDocument>)QueryUtil.list(q,
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
	 * Returns the first ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = fetchByGroupId_First(groupId,
				orderByComparator);

		if (immigrationDocument != null) {
			return immigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the first ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ImmigrationDocument> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (immigrationDocument != null) {
			return immigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ImmigrationDocument> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ImmigrationDocuments before and after the current ImmigrationDocument in the ordered set where groupId = &#63;.
	 *
	 * @param immigrationDocumentId the primary key of the current ImmigrationDocument
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument[] findByGroupId_PrevAndNext(
		long immigrationDocumentId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = findByPrimaryKey(immigrationDocumentId);

		Session session = null;

		try {
			session = openSession();

			ImmigrationDocument[] array = new ImmigrationDocumentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, immigrationDocument,
					groupId, orderByComparator, true);

			array[1] = immigrationDocument;

			array[2] = getByGroupId_PrevAndNext(session, immigrationDocument,
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

	protected ImmigrationDocument getByGroupId_PrevAndNext(Session session,
		ImmigrationDocument immigrationDocument, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMMIGRATIONDOCUMENT_WHERE);

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
			query.append(ImmigrationDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(immigrationDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImmigrationDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ImmigrationDocuments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ImmigrationDocument immigrationDocument : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(immigrationDocument);
		}
	}

	/**
	 * Returns the number of ImmigrationDocuments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching ImmigrationDocuments
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

			query.append(_SQL_COUNT_IMMIGRATIONDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "immigrationDocument.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMMIGRATIONDOCUMENTID =
		new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			ImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByimmigrationDocumentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMMIGRATIONDOCUMENTID =
		new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			ImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByimmigrationDocumentId",
			new String[] { Long.class.getName() },
			ImmigrationDocumentModelImpl.IMMIGRATIONDOCUMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMMIGRATIONDOCUMENTID = new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByimmigrationDocumentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ImmigrationDocuments where immigrationDocumentId = &#63;.
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @return the matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByimmigrationDocumentId(
		long immigrationDocumentId) throws SystemException {
		return findByimmigrationDocumentId(immigrationDocumentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ImmigrationDocuments where immigrationDocumentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @return the range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByimmigrationDocumentId(
		long immigrationDocumentId, int start, int end)
		throws SystemException {
		return findByimmigrationDocumentId(immigrationDocumentId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the ImmigrationDocuments where immigrationDocumentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByimmigrationDocumentId(
		long immigrationDocumentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMMIGRATIONDOCUMENTID;
			finderArgs = new Object[] { immigrationDocumentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMMIGRATIONDOCUMENTID;
			finderArgs = new Object[] {
					immigrationDocumentId,
					
					start, end, orderByComparator
				};
		}

		List<ImmigrationDocument> list = (List<ImmigrationDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ImmigrationDocument immigrationDocument : list) {
				if ((immigrationDocumentId != immigrationDocument.getImmigrationDocumentId())) {
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

			query.append(_SQL_SELECT_IMMIGRATIONDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_IMMIGRATIONDOCUMENTID_IMMIGRATIONDOCUMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImmigrationDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(immigrationDocumentId);

				if (!pagination) {
					list = (List<ImmigrationDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImmigrationDocument>(list);
				}
				else {
					list = (List<ImmigrationDocument>)QueryUtil.list(q,
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
	 * Returns the first ImmigrationDocument in the ordered set where immigrationDocumentId = &#63;.
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument findByimmigrationDocumentId_First(
		long immigrationDocumentId, OrderByComparator orderByComparator)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = fetchByimmigrationDocumentId_First(immigrationDocumentId,
				orderByComparator);

		if (immigrationDocument != null) {
			return immigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("immigrationDocumentId=");
		msg.append(immigrationDocumentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the first ImmigrationDocument in the ordered set where immigrationDocumentId = &#63;.
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument fetchByimmigrationDocumentId_First(
		long immigrationDocumentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ImmigrationDocument> list = findByimmigrationDocumentId(immigrationDocumentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where immigrationDocumentId = &#63;.
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument findByimmigrationDocumentId_Last(
		long immigrationDocumentId, OrderByComparator orderByComparator)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = fetchByimmigrationDocumentId_Last(immigrationDocumentId,
				orderByComparator);

		if (immigrationDocument != null) {
			return immigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("immigrationDocumentId=");
		msg.append(immigrationDocumentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where immigrationDocumentId = &#63;.
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument fetchByimmigrationDocumentId_Last(
		long immigrationDocumentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByimmigrationDocumentId(immigrationDocumentId);

		if (count == 0) {
			return null;
		}

		List<ImmigrationDocument> list = findByimmigrationDocumentId(immigrationDocumentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the ImmigrationDocuments where immigrationDocumentId = &#63; from the database.
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByimmigrationDocumentId(long immigrationDocumentId)
		throws SystemException {
		for (ImmigrationDocument immigrationDocument : findByimmigrationDocumentId(
				immigrationDocumentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(immigrationDocument);
		}
	}

	/**
	 * Returns the number of ImmigrationDocuments where immigrationDocumentId = &#63;.
	 *
	 * @param immigrationDocumentId the immigration document ID
	 * @return the number of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByimmigrationDocumentId(long immigrationDocumentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMMIGRATIONDOCUMENTID;

		Object[] finderArgs = new Object[] { immigrationDocumentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMMIGRATIONDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_IMMIGRATIONDOCUMENTID_IMMIGRATIONDOCUMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(immigrationDocumentId);

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

	private static final String _FINDER_COLUMN_IMMIGRATIONDOCUMENTID_IMMIGRATIONDOCUMENTID_2 =
		"immigrationDocument.immigrationDocumentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			ImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED,
			ImmigrationDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] { Long.class.getName() },
			ImmigrationDocumentModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ImmigrationDocuments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByemployeeId(long employeeId)
		throws SystemException {
		return findByemployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ImmigrationDocuments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @return the range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByemployeeId(long employeeId,
		int start, int end) throws SystemException {
		return findByemployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ImmigrationDocuments where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findByemployeeId(long employeeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ImmigrationDocument> list = (List<ImmigrationDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ImmigrationDocument immigrationDocument : list) {
				if ((employeeId != immigrationDocument.getEmployeeId())) {
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

			query.append(_SQL_SELECT_IMMIGRATIONDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImmigrationDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<ImmigrationDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImmigrationDocument>(list);
				}
				else {
					list = (List<ImmigrationDocument>)QueryUtil.list(q,
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
	 * Returns the first ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument findByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = fetchByemployeeId_First(employeeId,
				orderByComparator);

		if (immigrationDocument != null) {
			return immigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the first ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument fetchByemployeeId_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ImmigrationDocument> list = findByemployeeId(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument findByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = fetchByemployeeId_Last(employeeId,
				orderByComparator);

		if (immigrationDocument != null) {
			return immigrationDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImmigrationDocumentException(msg.toString());
	}

	/**
	 * Returns the last ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ImmigrationDocument, or <code>null</code> if a matching ImmigrationDocument could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument fetchByemployeeId_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<ImmigrationDocument> list = findByemployeeId(employeeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ImmigrationDocuments before and after the current ImmigrationDocument in the ordered set where employeeId = &#63;.
	 *
	 * @param immigrationDocumentId the primary key of the current ImmigrationDocument
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument[] findByemployeeId_PrevAndNext(
		long immigrationDocumentId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = findByPrimaryKey(immigrationDocumentId);

		Session session = null;

		try {
			session = openSession();

			ImmigrationDocument[] array = new ImmigrationDocumentImpl[3];

			array[0] = getByemployeeId_PrevAndNext(session,
					immigrationDocument, employeeId, orderByComparator, true);

			array[1] = immigrationDocument;

			array[2] = getByemployeeId_PrevAndNext(session,
					immigrationDocument, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImmigrationDocument getByemployeeId_PrevAndNext(Session session,
		ImmigrationDocument immigrationDocument, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMMIGRATIONDOCUMENT_WHERE);

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
			query.append(ImmigrationDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(immigrationDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImmigrationDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ImmigrationDocuments where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByemployeeId(long employeeId) throws SystemException {
		for (ImmigrationDocument immigrationDocument : findByemployeeId(
				employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(immigrationDocument);
		}
	}

	/**
	 * Returns the number of ImmigrationDocuments where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching ImmigrationDocuments
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

			query.append(_SQL_COUNT_IMMIGRATIONDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "immigrationDocument.employeeId = ?";

	public ImmigrationDocumentPersistenceImpl() {
		setModelClass(ImmigrationDocument.class);
	}

	/**
	 * Caches the ImmigrationDocument in the entity cache if it is enabled.
	 *
	 * @param immigrationDocument the ImmigrationDocument
	 */
	@Override
	public void cacheResult(ImmigrationDocument immigrationDocument) {
		EntityCacheUtil.putResult(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentImpl.class, immigrationDocument.getPrimaryKey(),
			immigrationDocument);

		immigrationDocument.resetOriginalValues();
	}

	/**
	 * Caches the ImmigrationDocuments in the entity cache if it is enabled.
	 *
	 * @param immigrationDocuments the ImmigrationDocuments
	 */
	@Override
	public void cacheResult(List<ImmigrationDocument> immigrationDocuments) {
		for (ImmigrationDocument immigrationDocument : immigrationDocuments) {
			if (EntityCacheUtil.getResult(
						ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
						ImmigrationDocumentImpl.class,
						immigrationDocument.getPrimaryKey()) == null) {
				cacheResult(immigrationDocument);
			}
			else {
				immigrationDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ImmigrationDocuments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ImmigrationDocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ImmigrationDocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ImmigrationDocument.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImmigrationDocument immigrationDocument) {
		EntityCacheUtil.removeResult(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentImpl.class, immigrationDocument.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ImmigrationDocument> immigrationDocuments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImmigrationDocument immigrationDocument : immigrationDocuments) {
			EntityCacheUtil.removeResult(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
				ImmigrationDocumentImpl.class,
				immigrationDocument.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ImmigrationDocument with the primary key. Does not add the ImmigrationDocument to the database.
	 *
	 * @param immigrationDocumentId the primary key for the new ImmigrationDocument
	 * @return the new ImmigrationDocument
	 */
	@Override
	public ImmigrationDocument create(long immigrationDocumentId) {
		ImmigrationDocument immigrationDocument = new ImmigrationDocumentImpl();

		immigrationDocument.setNew(true);
		immigrationDocument.setPrimaryKey(immigrationDocumentId);

		return immigrationDocument;
	}

	/**
	 * Removes the ImmigrationDocument with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param immigrationDocumentId the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument remove(long immigrationDocumentId)
		throws NoSuchImmigrationDocumentException, SystemException {
		return remove((Serializable)immigrationDocumentId);
	}

	/**
	 * Removes the ImmigrationDocument with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument that was removed
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument remove(Serializable primaryKey)
		throws NoSuchImmigrationDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ImmigrationDocument immigrationDocument = (ImmigrationDocument)session.get(ImmigrationDocumentImpl.class,
					primaryKey);

			if (immigrationDocument == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImmigrationDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(immigrationDocument);
		}
		catch (NoSuchImmigrationDocumentException nsee) {
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
	protected ImmigrationDocument removeImpl(
		ImmigrationDocument immigrationDocument) throws SystemException {
		immigrationDocument = toUnwrappedModel(immigrationDocument);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(immigrationDocument)) {
				immigrationDocument = (ImmigrationDocument)session.get(ImmigrationDocumentImpl.class,
						immigrationDocument.getPrimaryKeyObj());
			}

			if (immigrationDocument != null) {
				session.delete(immigrationDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (immigrationDocument != null) {
			clearCache(immigrationDocument);
		}

		return immigrationDocument;
	}

	@Override
	public ImmigrationDocument updateImpl(
		com.rknowsys.eapp.hrm.model.ImmigrationDocument immigrationDocument)
		throws SystemException {
		immigrationDocument = toUnwrappedModel(immigrationDocument);

		boolean isNew = immigrationDocument.isNew();

		ImmigrationDocumentModelImpl immigrationDocumentModelImpl = (ImmigrationDocumentModelImpl)immigrationDocument;

		Session session = null;

		try {
			session = openSession();

			if (immigrationDocument.isNew()) {
				session.save(immigrationDocument);

				immigrationDocument.setNew(false);
			}
			else {
				session.merge(immigrationDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ImmigrationDocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((immigrationDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						immigrationDocumentModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { immigrationDocumentModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((immigrationDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMMIGRATIONDOCUMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						immigrationDocumentModelImpl.getOriginalImmigrationDocumentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMMIGRATIONDOCUMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMMIGRATIONDOCUMENTID,
					args);

				args = new Object[] {
						immigrationDocumentModelImpl.getImmigrationDocumentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMMIGRATIONDOCUMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMMIGRATIONDOCUMENTID,
					args);
			}

			if ((immigrationDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						immigrationDocumentModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] { immigrationDocumentModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
			ImmigrationDocumentImpl.class, immigrationDocument.getPrimaryKey(),
			immigrationDocument);

		return immigrationDocument;
	}

	protected ImmigrationDocument toUnwrappedModel(
		ImmigrationDocument immigrationDocument) {
		if (immigrationDocument instanceof ImmigrationDocumentImpl) {
			return immigrationDocument;
		}

		ImmigrationDocumentImpl immigrationDocumentImpl = new ImmigrationDocumentImpl();

		immigrationDocumentImpl.setNew(immigrationDocument.isNew());
		immigrationDocumentImpl.setPrimaryKey(immigrationDocument.getPrimaryKey());

		immigrationDocumentImpl.setImmigrationDocumentId(immigrationDocument.getImmigrationDocumentId());
		immigrationDocumentImpl.setEmployeeId(immigrationDocument.getEmployeeId());
		immigrationDocumentImpl.setCompanyId(immigrationDocument.getCompanyId());
		immigrationDocumentImpl.setGroupId(immigrationDocument.getGroupId());
		immigrationDocumentImpl.setCreateDate(immigrationDocument.getCreateDate());
		immigrationDocumentImpl.setModifiedDate(immigrationDocument.getModifiedDate());
		immigrationDocumentImpl.setUserId(immigrationDocument.getUserId());
		immigrationDocumentImpl.setDocTopic(immigrationDocument.getDocTopic());
		immigrationDocumentImpl.setDocCategory(immigrationDocument.getDocCategory());
		immigrationDocumentImpl.setDescription(immigrationDocument.getDescription());
		immigrationDocumentImpl.setPublishTo(immigrationDocument.getPublishTo());
		immigrationDocumentImpl.setPublishDate(immigrationDocument.getPublishDate());

		return immigrationDocumentImpl;
	}

	/**
	 * Returns the ImmigrationDocument with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImmigrationDocumentException, SystemException {
		ImmigrationDocument immigrationDocument = fetchByPrimaryKey(primaryKey);

		if (immigrationDocument == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImmigrationDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return immigrationDocument;
	}

	/**
	 * Returns the ImmigrationDocument with the primary key or throws a {@link com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException} if it could not be found.
	 *
	 * @param immigrationDocumentId the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument
	 * @throws com.rknowsys.eapp.hrm.NoSuchImmigrationDocumentException if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument findByPrimaryKey(long immigrationDocumentId)
		throws NoSuchImmigrationDocumentException, SystemException {
		return findByPrimaryKey((Serializable)immigrationDocumentId);
	}

	/**
	 * Returns the ImmigrationDocument with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument, or <code>null</code> if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ImmigrationDocument immigrationDocument = (ImmigrationDocument)EntityCacheUtil.getResult(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
				ImmigrationDocumentImpl.class, primaryKey);

		if (immigrationDocument == _nullImmigrationDocument) {
			return null;
		}

		if (immigrationDocument == null) {
			Session session = null;

			try {
				session = openSession();

				immigrationDocument = (ImmigrationDocument)session.get(ImmigrationDocumentImpl.class,
						primaryKey);

				if (immigrationDocument != null) {
					cacheResult(immigrationDocument);
				}
				else {
					EntityCacheUtil.putResult(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
						ImmigrationDocumentImpl.class, primaryKey,
						_nullImmigrationDocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ImmigrationDocumentModelImpl.ENTITY_CACHE_ENABLED,
					ImmigrationDocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return immigrationDocument;
	}

	/**
	 * Returns the ImmigrationDocument with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param immigrationDocumentId the primary key of the ImmigrationDocument
	 * @return the ImmigrationDocument, or <code>null</code> if a ImmigrationDocument with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImmigrationDocument fetchByPrimaryKey(long immigrationDocumentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)immigrationDocumentId);
	}

	/**
	 * Returns all the ImmigrationDocuments.
	 *
	 * @return the ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ImmigrationDocuments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @return the range of ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ImmigrationDocuments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.ImmigrationDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ImmigrationDocuments
	 * @param end the upper bound of the range of ImmigrationDocuments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ImmigrationDocuments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImmigrationDocument> findAll(int start, int end,
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

		List<ImmigrationDocument> list = (List<ImmigrationDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMMIGRATIONDOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMMIGRATIONDOCUMENT;

				if (pagination) {
					sql = sql.concat(ImmigrationDocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ImmigrationDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImmigrationDocument>(list);
				}
				else {
					list = (List<ImmigrationDocument>)QueryUtil.list(q,
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
	 * Removes all the ImmigrationDocuments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ImmigrationDocument immigrationDocument : findAll()) {
			remove(immigrationDocument);
		}
	}

	/**
	 * Returns the number of ImmigrationDocuments.
	 *
	 * @return the number of ImmigrationDocuments
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

				Query q = session.createQuery(_SQL_COUNT_IMMIGRATIONDOCUMENT);

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
	 * Initializes the ImmigrationDocument persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rknowsys.eapp.hrm.model.ImmigrationDocument")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ImmigrationDocument>> listenersList = new ArrayList<ModelListener<ImmigrationDocument>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ImmigrationDocument>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ImmigrationDocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IMMIGRATIONDOCUMENT = "SELECT immigrationDocument FROM ImmigrationDocument immigrationDocument";
	private static final String _SQL_SELECT_IMMIGRATIONDOCUMENT_WHERE = "SELECT immigrationDocument FROM ImmigrationDocument immigrationDocument WHERE ";
	private static final String _SQL_COUNT_IMMIGRATIONDOCUMENT = "SELECT COUNT(immigrationDocument) FROM ImmigrationDocument immigrationDocument";
	private static final String _SQL_COUNT_IMMIGRATIONDOCUMENT_WHERE = "SELECT COUNT(immigrationDocument) FROM ImmigrationDocument immigrationDocument WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "immigrationDocument.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImmigrationDocument exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ImmigrationDocument exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ImmigrationDocumentPersistenceImpl.class);
	private static ImmigrationDocument _nullImmigrationDocument = new ImmigrationDocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ImmigrationDocument> toCacheModel() {
				return _nullImmigrationDocumentCacheModel;
			}
		};

	private static CacheModel<ImmigrationDocument> _nullImmigrationDocumentCacheModel =
		new CacheModel<ImmigrationDocument>() {
			@Override
			public ImmigrationDocument toEntityModel() {
				return _nullImmigrationDocument;
			}
		};
}