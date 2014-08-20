
<%@ include file="/html/licensesaction/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

License license= (License)rslt.getObject();

String prk=String.valueOf(license.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editLicenses" name="editLicense">
<portlet:param name="licenseId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editLicenses.toString()%>'"><img
					width="18px" height="18px" alt="loading..." 
					src="<%=request.getContextPath() %>/images/pencil.jpg"></a> 
</liferay-ui:icon-menu>
