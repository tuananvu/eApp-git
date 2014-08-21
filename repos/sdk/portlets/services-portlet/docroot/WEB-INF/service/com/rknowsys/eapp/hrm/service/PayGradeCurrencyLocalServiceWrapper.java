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

package com.rknowsys.eapp.hrm.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PayGradeCurrencyLocalService}.
 *
 * @author rknowsys
 * @see PayGradeCurrencyLocalService
 * @generated
 */
public class PayGradeCurrencyLocalServiceWrapper
	implements PayGradeCurrencyLocalService,
		ServiceWrapper<PayGradeCurrencyLocalService> {
	public PayGradeCurrencyLocalServiceWrapper(
		PayGradeCurrencyLocalService payGradeCurrencyLocalService) {
		_payGradeCurrencyLocalService = payGradeCurrencyLocalService;
	}

	/**
	* Adds the pay grade currency to the database. Also notifies the appropriate model listeners.
	*
	* @param payGradeCurrency the pay grade currency
	* @return the pay grade currency that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.PayGradeCurrency addPayGradeCurrency(
		com.rknowsys.eapp.hrm.model.PayGradeCurrency payGradeCurrency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.addPayGradeCurrency(payGradeCurrency);
	}

	/**
	* Creates a new pay grade currency with the primary key. Does not add the pay grade currency to the database.
	*
	* @param payGradeCurrencyId the primary key for the new pay grade currency
	* @return the new pay grade currency
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.PayGradeCurrency createPayGradeCurrency(
		long payGradeCurrencyId) {
		return _payGradeCurrencyLocalService.createPayGradeCurrency(payGradeCurrencyId);
	}

	/**
	* Deletes the pay grade currency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param payGradeCurrencyId the primary key of the pay grade currency
	* @return the pay grade currency that was removed
	* @throws PortalException if a pay grade currency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.PayGradeCurrency deletePayGradeCurrency(
		long payGradeCurrencyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.deletePayGradeCurrency(payGradeCurrencyId);
	}

	/**
	* Deletes the pay grade currency from the database. Also notifies the appropriate model listeners.
	*
	* @param payGradeCurrency the pay grade currency
	* @return the pay grade currency that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.PayGradeCurrency deletePayGradeCurrency(
		com.rknowsys.eapp.hrm.model.PayGradeCurrency payGradeCurrency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.deletePayGradeCurrency(payGradeCurrency);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payGradeCurrencyLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rknowsys.eapp.hrm.model.PayGradeCurrency fetchPayGradeCurrency(
		long payGradeCurrencyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.fetchPayGradeCurrency(payGradeCurrencyId);
	}

	/**
	* Returns the pay grade currency with the primary key.
	*
	* @param payGradeCurrencyId the primary key of the pay grade currency
	* @return the pay grade currency
	* @throws PortalException if a pay grade currency with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.PayGradeCurrency getPayGradeCurrency(
		long payGradeCurrencyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.getPayGradeCurrency(payGradeCurrencyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.rknowsys.eapp.hrm.model.PayGradeCurrency> getPayGradeCurrencies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.getPayGradeCurrencies(start, end);
	}

	/**
	* Returns the number of pay grade currencies.
	*
	* @return the number of pay grade currencies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPayGradeCurrenciesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.getPayGradeCurrenciesCount();
	}

	/**
	* Updates the pay grade currency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param payGradeCurrency the pay grade currency
	* @return the pay grade currency that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rknowsys.eapp.hrm.model.PayGradeCurrency updatePayGradeCurrency(
		com.rknowsys.eapp.hrm.model.PayGradeCurrency payGradeCurrency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _payGradeCurrencyLocalService.updatePayGradeCurrency(payGradeCurrency);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _payGradeCurrencyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_payGradeCurrencyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _payGradeCurrencyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PayGradeCurrencyLocalService getWrappedPayGradeCurrencyLocalService() {
		return _payGradeCurrencyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPayGradeCurrencyLocalService(
		PayGradeCurrencyLocalService payGradeCurrencyLocalService) {
		_payGradeCurrencyLocalService = payGradeCurrencyLocalService;
	}

	@Override
	public PayGradeCurrencyLocalService getWrappedService() {
		return _payGradeCurrencyLocalService;
	}

	@Override
	public void setWrappedService(
		PayGradeCurrencyLocalService payGradeCurrencyLocalService) {
		_payGradeCurrencyLocalService = payGradeCurrencyLocalService;
	}

	private PayGradeCurrencyLocalService _payGradeCurrencyLocalService;
}