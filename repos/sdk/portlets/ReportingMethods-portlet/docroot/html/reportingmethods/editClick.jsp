
<%@page import="com.rknowsys.eapp.hrm.model.ReportingMethods"%>
<%@ include file="/html/reportingmethods/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ReportingMethods reportingMethods= (ReportingMethods)rslt.getObject();

String prk=String.valueOf(reportingMethods.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editreportingmethods" name="editReportingMethod">
<portlet:param name="reportingmethodId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editreportingmethods.toString()%>'"><img
					width="18px" height="18px" alt="loading..." 
					src="<%=request.getContextPath() %>/images/pencil.jpg"></a> 
</liferay-ui:icon-menu>
