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

package com.rknowsys.eapp.hrm.model.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.rknowsys.eapp.hrm.model.Attachment;
import com.rknowsys.eapp.hrm.model.ContactDetails;
import com.rknowsys.eapp.hrm.model.Dependent;
import com.rknowsys.eapp.hrm.model.Education;
import com.rknowsys.eapp.hrm.model.EmergencyContact;
import com.rknowsys.eapp.hrm.model.ImmigrationDocument;
import com.rknowsys.eapp.hrm.model.Job;
import com.rknowsys.eapp.hrm.model.Language;
import com.rknowsys.eapp.hrm.model.License;
import com.rknowsys.eapp.hrm.model.Membership;
import com.rknowsys.eapp.hrm.model.SalaryComponent;
import com.rknowsys.eapp.hrm.model.Skill;
import com.rknowsys.eapp.hrm.service.AttachmentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.ContactDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.DependentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EducationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmergencyContactLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.ImmigrationDocumentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.MembershipLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SalaryComponentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil;

/**
 * The extended model implementation for the Employee service. Represents a row
 * in the &quot;employee&quot; database table, with each column mapped to a
 * property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.rknowsys.eapp.hrm.model.Employee} interface.
 * </p>
 * 
 * @author rknowsys
 */
public class EmployeeImpl extends EmployeeBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this class directly. All methods that expect a Employee
	 * model instance should use the {@link
	 * com.rknowsys.eapp.hrm.model.Employee} interface instead.
	 */
	public EmployeeImpl() {
	}

	public ContactDetails getContactDetails() throws PortalException,
			SystemException {
		return ContactDetailsLocalServiceUtil
				.getContactDetails(getContactDetailsId());
	}

	public License getLicense() throws PortalException, SystemException {
		return LicenseLocalServiceUtil.getLicense(getLicenseId());
	}

	public Job getJob() throws PortalException, SystemException {
		return JobLocalServiceUtil.getJob(getJobId());
	}

	public List<Attachment> getAttachments() throws PortalException,
			SystemException {
		return AttachmentLocalServiceUtil
				.getEmployeeAttachments(getEmployeeId());
	}

	public List<Dependent> getDependents() throws PortalException,
			SystemException {
		return DependentLocalServiceUtil.getEmployeeDependents(getEmployeeId());
	}

	public List<SalaryComponent> getSalaryComponents() throws PortalException,
			SystemException {
		return SalaryComponentLocalServiceUtil
				.getEmployeeSalaryComponents(getEmployeeId());
	}

	public List<EmergencyContact> getEmergencyContacts() throws
	PortalException, SystemException {
		return
		EmergencyContactLocalServiceUtil
				.getEmployeeEmergencyContacts(getEmployeeId());
	}

	public List<ImmigrationDocument> getImmigrationDocuments()
			throws PortalException, SystemException {
		return ImmigrationDocumentLocalServiceUtil
				.getEmployeeImmigrationDocuments(getEmployeeId());
	}

	public List<Education> getEducations()
			throws PortalException, SystemException {
		return EducationLocalServiceUtil
				.getEmployeeEducations(getEmployeeId());
	}
	
	public List<Language> getLanguages()
			throws PortalException, SystemException {
		return LanguageLocalServiceUtil.
				getEmployeeLanguages(getEmployeeId());
	}
	
	public List<Skill> getSkills()
			throws PortalException, SystemException {
		return SkillLocalServiceUtil
				.getEmployeeSkills(getEmployeeId());
	}
	
	public List<Membership> getMemberships()
			throws PortalException, SystemException {
		return MembershipLocalServiceUtil
				.getEmployeeMemberships(getEmployeeId());
	}
	
}
