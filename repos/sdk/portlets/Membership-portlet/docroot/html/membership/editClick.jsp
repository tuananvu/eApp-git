
<%@ include file="/html/membership/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Membership membership= (Membership)rslt.getObject();

String prk=String.valueOf(membership.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editMemberships" name="editMembership">
<portlet:param name="membershipId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editMemberships.toString()%>'"><img
					width="18px" height="18px" alt="loading..." 
					src="<%=request.getContextPath() %>/images/pencil.jpg"></a> 
</liferay-ui:icon-menu>
