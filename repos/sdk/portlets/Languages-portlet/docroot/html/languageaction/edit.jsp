
<%@ include file="/html/languageaction/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Language languages= (Language)rslt.getObject();

String prk=String.valueOf(languages.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editLanguages" name="editLanguage">
<portlet:param name="languageId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editLanguages.toString()%>'"><img
					width="18px" height="18px" alt="loading..." 
					src="<%=request.getContextPath() %>/images/pencil.jpg"></a> 
</liferay-ui:icon-menu>
