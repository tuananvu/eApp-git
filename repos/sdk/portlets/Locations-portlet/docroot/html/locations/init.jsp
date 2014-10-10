<%@taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib uri="http://java.sun.com/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.rknowsys.eapp.CustomComparatorUtil" %>
<%@ page import="com.rknowsys.eapp.hrm.model.Location" %>
<%@ page import="com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil" %>
<portlet:defineObjects/>
<theme:defineObjects/>


