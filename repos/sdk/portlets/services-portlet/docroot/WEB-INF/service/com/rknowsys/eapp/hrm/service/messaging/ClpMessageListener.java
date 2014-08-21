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

package com.rknowsys.eapp.hrm.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.rknowsys.eapp.hrm.service.ClpSerializer;
import com.rknowsys.eapp.hrm.service.DocCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.DocumentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EducationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.InterviewLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitlesLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.MembershipLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.NewsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SalaryComponentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkShiftLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkShiftUserLocalServiceUtil;

/**
 * @author rknowsys
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			DocCategoryLocalServiceUtil.clearService();

			DocumentLocalServiceUtil.clearService();

			EducationLocalServiceUtil.clearService();

			EmploymentStatusLocalServiceUtil.clearService();

			InterviewLocalServiceUtil.clearService();

			JobCategoryLocalServiceUtil.clearService();

			JobTitlesLocalServiceUtil.clearService();

			LanguageLocalServiceUtil.clearService();

			LicenseLocalServiceUtil.clearService();

			LocationsLocalServiceUtil.clearService();

			MembershipLocalServiceUtil.clearService();

			NationalityLocalServiceUtil.clearService();

			NewsLocalServiceUtil.clearService();

			PayGradeLocalServiceUtil.clearService();

			PayGradeCurrencyLocalServiceUtil.clearService();

			SalaryComponentLocalServiceUtil.clearService();

			SkillLocalServiceUtil.clearService();

			WorkShiftLocalServiceUtil.clearService();

			WorkShiftUserLocalServiceUtil.clearService();
		}
	}
}