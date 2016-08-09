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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for JobCategory. This utility wraps
 * {@link com.rknowsys.eapp.hrm.service.impl.JobCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author rknowsys
 * @see JobCategoryLocalService
 * @see com.rknowsys.eapp.hrm.service.base.JobCategoryLocalServiceBaseImpl
 * @see com.rknowsys.eapp.hrm.service.impl.JobCategoryLocalServiceImpl
 * @generated
 */
public class JobCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rknowsys.eapp.hrm.service.impl.JobCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the job category to the database. Also notifies the appropriate model listeners.
	*
	* @param jobCategory the job category
	* @return the job category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory addJobCategory(
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addJobCategory(jobCategory);
	}

	/**
	* Creates a new job category with the primary key. Does not add the job category to the database.
	*
	* @param jobCategoryId the primary key for the new job category
	* @return the new job category
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory createJobCategory(
		long jobCategoryId) {
		return getService().createJobCategory(jobCategoryId);
	}

	/**
	* Deletes the job category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jobCategoryId the primary key of the job category
	* @return the job category that was removed
	* @throws PortalException if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory deleteJobCategory(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJobCategory(jobCategoryId);
	}

	/**
	* Deletes the job category from the database. Also notifies the appropriate model listeners.
	*
	* @param jobCategory the job category
	* @return the job category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory deleteJobCategory(
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteJobCategory(jobCategory);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.rknowsys.eapp.hrm.model.JobCategory fetchJobCategory(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchJobCategory(jobCategoryId);
	}

	/**
	* Returns the job category with the primary key.
	*
	* @param jobCategoryId the primary key of the job category
	* @return the job category
	* @throws PortalException if a job category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory getJobCategory(
		long jobCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobCategory(jobCategoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the job categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rknowsys.eapp.hrm.model.impl.JobCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of job categories
	* @param end the upper bound of the range of job categories (not inclusive)
	* @return the range of job categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getJobCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobCategories(start, end);
	}

	/**
	* Returns the number of job categories.
	*
	* @return the number of job categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getJobCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getJobCategoriesCount();
	}

	/**
	* Updates the job category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param jobCategory the job category
	* @return the job category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.rknowsys.eapp.hrm.model.JobCategory updateJobCategory(
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateJobCategory(jobCategory);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveRuleApplicableJobCategory(
		long leaveRuleApplicableId, long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLeaveRuleApplicableJobCategory(leaveRuleApplicableId,
			jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveRuleApplicableJobCategory(
		long leaveRuleApplicableId,
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLeaveRuleApplicableJobCategory(leaveRuleApplicableId,
			jobCategory);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId, long[] jobCategoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLeaveRuleApplicableJobCategories(leaveRuleApplicableId,
			jobCategoryIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId,
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> JobCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addLeaveRuleApplicableJobCategories(leaveRuleApplicableId,
			JobCategories);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearLeaveRuleApplicableJobCategories(leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLeaveRuleApplicableJobCategory(
		long leaveRuleApplicableId, long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLeaveRuleApplicableJobCategory(leaveRuleApplicableId,
			jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLeaveRuleApplicableJobCategory(
		long leaveRuleApplicableId,
		com.rknowsys.eapp.hrm.model.JobCategory jobCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLeaveRuleApplicableJobCategory(leaveRuleApplicableId,
			jobCategory);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId, long[] jobCategoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLeaveRuleApplicableJobCategories(leaveRuleApplicableId,
			jobCategoryIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId,
		java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> JobCategories)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteLeaveRuleApplicableJobCategories(leaveRuleApplicableId,
			JobCategories);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeaveRuleApplicableJobCategories(leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeaveRuleApplicableJobCategories(leaveRuleApplicableId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rknowsys.eapp.hrm.model.JobCategory> getLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeaveRuleApplicableJobCategories(leaveRuleApplicableId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getLeaveRuleApplicableJobCategoriesCount(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getLeaveRuleApplicableJobCategoriesCount(leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasLeaveRuleApplicableJobCategory(
		long leaveRuleApplicableId, long jobCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasLeaveRuleApplicableJobCategory(leaveRuleApplicableId,
			jobCategoryId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasLeaveRuleApplicableJobCategories(leaveRuleApplicableId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setLeaveRuleApplicableJobCategories(
		long leaveRuleApplicableId, long[] jobCategoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setLeaveRuleApplicableJobCategories(leaveRuleApplicableId,
			jobCategoryIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static JobCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					JobCategoryLocalService.class.getName());

			if (invokableLocalService instanceof JobCategoryLocalService) {
				_service = (JobCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new JobCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(JobCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(JobCategoryLocalService service) {
	}

	private static JobCategoryLocalService _service;
}