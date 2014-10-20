<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rknowsys.eapp.hrm.model.Location"%>
<%@page import="com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.service.NationalityLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpContactDetails"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import="com.rknowsys.eapp.hrm.model.Employee"%>
<%@page import="com.rknowsys.eapp.hrm.model.Nationality"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.model.License"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpPersonalDetails"%>
<%@page import="com.liferay.portal.util.PortalUtil " %>
<%@page import="com.rknowsys.eapp.hrm.model.EmpEmergencyContact"%>
<%@page import="com.rknowsys.eapp.hrm.service.EmpDependentLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmpDependent"%>
<%@page import="com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Language"%>
<%@page import="com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Skill"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.JobTitle"%>
<%@page import="com.rknowsys.eapp.hrm.service.WorkshiftLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Workshift"%>
<%@page import="com.rknowsys.eapp.hrm.service.SubUnitLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.SubUnit"%>
<%@page import="com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.JobCategory"%>
<%@page
	import="com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.EmploymentStatus"%>

<portlet:defineObjects />
