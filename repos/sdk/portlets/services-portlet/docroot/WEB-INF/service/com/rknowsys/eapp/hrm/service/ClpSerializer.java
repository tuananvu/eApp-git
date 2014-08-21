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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.rknowsys.eapp.hrm.model.DocCategoryClp;
import com.rknowsys.eapp.hrm.model.DocumentClp;
import com.rknowsys.eapp.hrm.model.EducationClp;
import com.rknowsys.eapp.hrm.model.EmploymentStatusClp;
import com.rknowsys.eapp.hrm.model.InterviewClp;
import com.rknowsys.eapp.hrm.model.JobCategoryClp;
import com.rknowsys.eapp.hrm.model.JobTitlesClp;
import com.rknowsys.eapp.hrm.model.LanguageClp;
import com.rknowsys.eapp.hrm.model.LicenseClp;
import com.rknowsys.eapp.hrm.model.LocationsClp;
import com.rknowsys.eapp.hrm.model.MembershipClp;
import com.rknowsys.eapp.hrm.model.NationalityClp;
import com.rknowsys.eapp.hrm.model.NewsClp;
import com.rknowsys.eapp.hrm.model.PayGradeClp;
import com.rknowsys.eapp.hrm.model.PayGradeCurrencyClp;
import com.rknowsys.eapp.hrm.model.SalaryComponentClp;
import com.rknowsys.eapp.hrm.model.SkillClp;
import com.rknowsys.eapp.hrm.model.WorkShiftClp;
import com.rknowsys.eapp.hrm.model.WorkShiftUserClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rknowsys
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"services-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"services-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "services-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DocCategoryClp.class.getName())) {
			return translateInputDocCategory(oldModel);
		}

		if (oldModelClassName.equals(DocumentClp.class.getName())) {
			return translateInputDocument(oldModel);
		}

		if (oldModelClassName.equals(EducationClp.class.getName())) {
			return translateInputEducation(oldModel);
		}

		if (oldModelClassName.equals(EmploymentStatusClp.class.getName())) {
			return translateInputEmploymentStatus(oldModel);
		}

		if (oldModelClassName.equals(InterviewClp.class.getName())) {
			return translateInputInterview(oldModel);
		}

		if (oldModelClassName.equals(JobCategoryClp.class.getName())) {
			return translateInputJobCategory(oldModel);
		}

		if (oldModelClassName.equals(JobTitlesClp.class.getName())) {
			return translateInputJobTitles(oldModel);
		}

		if (oldModelClassName.equals(LanguageClp.class.getName())) {
			return translateInputLanguage(oldModel);
		}

		if (oldModelClassName.equals(LicenseClp.class.getName())) {
			return translateInputLicense(oldModel);
		}

		if (oldModelClassName.equals(LocationsClp.class.getName())) {
			return translateInputLocations(oldModel);
		}

		if (oldModelClassName.equals(MembershipClp.class.getName())) {
			return translateInputMembership(oldModel);
		}

		if (oldModelClassName.equals(NationalityClp.class.getName())) {
			return translateInputNationality(oldModel);
		}

		if (oldModelClassName.equals(NewsClp.class.getName())) {
			return translateInputNews(oldModel);
		}

		if (oldModelClassName.equals(PayGradeClp.class.getName())) {
			return translateInputPayGrade(oldModel);
		}

		if (oldModelClassName.equals(PayGradeCurrencyClp.class.getName())) {
			return translateInputPayGradeCurrency(oldModel);
		}

		if (oldModelClassName.equals(SalaryComponentClp.class.getName())) {
			return translateInputSalaryComponent(oldModel);
		}

		if (oldModelClassName.equals(SkillClp.class.getName())) {
			return translateInputSkill(oldModel);
		}

		if (oldModelClassName.equals(WorkShiftClp.class.getName())) {
			return translateInputWorkShift(oldModel);
		}

		if (oldModelClassName.equals(WorkShiftUserClp.class.getName())) {
			return translateInputWorkShiftUser(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputDocCategory(BaseModel<?> oldModel) {
		DocCategoryClp oldClpModel = (DocCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDocCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDocument(BaseModel<?> oldModel) {
		DocumentClp oldClpModel = (DocumentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEducation(BaseModel<?> oldModel) {
		EducationClp oldClpModel = (EducationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEducationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmploymentStatus(BaseModel<?> oldModel) {
		EmploymentStatusClp oldClpModel = (EmploymentStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmploymentStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInterview(BaseModel<?> oldModel) {
		InterviewClp oldClpModel = (InterviewClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInterviewRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJobCategory(BaseModel<?> oldModel) {
		JobCategoryClp oldClpModel = (JobCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJobTitles(BaseModel<?> oldModel) {
		JobTitlesClp oldClpModel = (JobTitlesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobTitlesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLanguage(BaseModel<?> oldModel) {
		LanguageClp oldClpModel = (LanguageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLanguageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLicense(BaseModel<?> oldModel) {
		LicenseClp oldClpModel = (LicenseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLicenseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLocations(BaseModel<?> oldModel) {
		LocationsClp oldClpModel = (LocationsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLocationsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMembership(BaseModel<?> oldModel) {
		MembershipClp oldClpModel = (MembershipClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMembershipRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNationality(BaseModel<?> oldModel) {
		NationalityClp oldClpModel = (NationalityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNationalityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNews(BaseModel<?> oldModel) {
		NewsClp oldClpModel = (NewsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNewsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPayGrade(BaseModel<?> oldModel) {
		PayGradeClp oldClpModel = (PayGradeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPayGradeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPayGradeCurrency(BaseModel<?> oldModel) {
		PayGradeCurrencyClp oldClpModel = (PayGradeCurrencyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPayGradeCurrencyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSalaryComponent(BaseModel<?> oldModel) {
		SalaryComponentClp oldClpModel = (SalaryComponentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSalaryComponentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSkill(BaseModel<?> oldModel) {
		SkillClp oldClpModel = (SkillClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSkillRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkShift(BaseModel<?> oldModel) {
		WorkShiftClp oldClpModel = (WorkShiftClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkShiftRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkShiftUser(BaseModel<?> oldModel) {
		WorkShiftUserClp oldClpModel = (WorkShiftUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkShiftUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.DocCategoryImpl")) {
			return translateOutputDocCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.DocumentImpl")) {
			return translateOutputDocument(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EducationImpl")) {
			return translateOutputEducation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.EmploymentStatusImpl")) {
			return translateOutputEmploymentStatus(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.InterviewImpl")) {
			return translateOutputInterview(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.JobCategoryImpl")) {
			return translateOutputJobCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.JobTitlesImpl")) {
			return translateOutputJobTitles(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LanguageImpl")) {
			return translateOutputLanguage(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LicenseImpl")) {
			return translateOutputLicense(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.LocationsImpl")) {
			return translateOutputLocations(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.MembershipImpl")) {
			return translateOutputMembership(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.NationalityImpl")) {
			return translateOutputNationality(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.NewsImpl")) {
			return translateOutputNews(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.PayGradeImpl")) {
			return translateOutputPayGrade(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.PayGradeCurrencyImpl")) {
			return translateOutputPayGradeCurrency(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SalaryComponentImpl")) {
			return translateOutputSalaryComponent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.SkillImpl")) {
			return translateOutputSkill(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.WorkShiftImpl")) {
			return translateOutputWorkShift(oldModel);
		}

		if (oldModelClassName.equals(
					"com.rknowsys.eapp.hrm.model.impl.WorkShiftUserImpl")) {
			return translateOutputWorkShiftUser(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchDocCategoryException")) {
			return new com.rknowsys.eapp.hrm.NoSuchDocCategoryException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchDocumentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchDocumentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchEducationException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEducationException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException")) {
			return new com.rknowsys.eapp.hrm.NoSuchEmploymentStatusException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchInterviewException")) {
			return new com.rknowsys.eapp.hrm.NoSuchInterviewException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchJobCategoryException")) {
			return new com.rknowsys.eapp.hrm.NoSuchJobCategoryException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchJobTitlesException")) {
			return new com.rknowsys.eapp.hrm.NoSuchJobTitlesException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLanguageException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLanguageException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLicenseException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLicenseException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchLocationsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchLocationsException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchMembershipException")) {
			return new com.rknowsys.eapp.hrm.NoSuchMembershipException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchNationalityException")) {
			return new com.rknowsys.eapp.hrm.NoSuchNationalityException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchNewsException")) {
			return new com.rknowsys.eapp.hrm.NoSuchNewsException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchPayGradeException")) {
			return new com.rknowsys.eapp.hrm.NoSuchPayGradeException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException")) {
			return new com.rknowsys.eapp.hrm.NoSuchPayGradeCurrencyException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchSalaryComponentException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSalaryComponentException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchSkillException")) {
			return new com.rknowsys.eapp.hrm.NoSuchSkillException();
		}

		if (className.equals("com.rknowsys.eapp.hrm.NoSuchWorkShiftException")) {
			return new com.rknowsys.eapp.hrm.NoSuchWorkShiftException();
		}

		if (className.equals(
					"com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException")) {
			return new com.rknowsys.eapp.hrm.NoSuchWorkShiftUserException();
		}

		return throwable;
	}

	public static Object translateOutputDocCategory(BaseModel<?> oldModel) {
		DocCategoryClp newModel = new DocCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDocCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDocument(BaseModel<?> oldModel) {
		DocumentClp newModel = new DocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEducation(BaseModel<?> oldModel) {
		EducationClp newModel = new EducationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEducationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmploymentStatus(BaseModel<?> oldModel) {
		EmploymentStatusClp newModel = new EmploymentStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmploymentStatusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInterview(BaseModel<?> oldModel) {
		InterviewClp newModel = new InterviewClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInterviewRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJobCategory(BaseModel<?> oldModel) {
		JobCategoryClp newModel = new JobCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJobTitles(BaseModel<?> oldModel) {
		JobTitlesClp newModel = new JobTitlesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobTitlesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLanguage(BaseModel<?> oldModel) {
		LanguageClp newModel = new LanguageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLanguageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLicense(BaseModel<?> oldModel) {
		LicenseClp newModel = new LicenseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLicenseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLocations(BaseModel<?> oldModel) {
		LocationsClp newModel = new LocationsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLocationsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMembership(BaseModel<?> oldModel) {
		MembershipClp newModel = new MembershipClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMembershipRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNationality(BaseModel<?> oldModel) {
		NationalityClp newModel = new NationalityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNationalityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNews(BaseModel<?> oldModel) {
		NewsClp newModel = new NewsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNewsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPayGrade(BaseModel<?> oldModel) {
		PayGradeClp newModel = new PayGradeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPayGradeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPayGradeCurrency(BaseModel<?> oldModel) {
		PayGradeCurrencyClp newModel = new PayGradeCurrencyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPayGradeCurrencyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSalaryComponent(BaseModel<?> oldModel) {
		SalaryComponentClp newModel = new SalaryComponentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSalaryComponentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSkill(BaseModel<?> oldModel) {
		SkillClp newModel = new SkillClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSkillRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkShift(BaseModel<?> oldModel) {
		WorkShiftClp newModel = new WorkShiftClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkShiftRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkShiftUser(BaseModel<?> oldModel) {
		WorkShiftUserClp newModel = new WorkShiftUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkShiftUserRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}