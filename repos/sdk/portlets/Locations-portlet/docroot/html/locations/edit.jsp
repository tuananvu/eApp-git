<%@ include file="/html/locationseapp/init.jsp" %>
<% ResultRow row=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Locations Locations=(Locations)row.getObject();
	long id=Locations.getId();
	String redirect=PortalUtil.getCurrentURL(renderRequest);
%>
<liferay-ui:icon-menu>
	<portlet:actionURL name="editLocation" var="editLocations">
		<portlet:param name="id"
			value="<%=Long.toString(Locations.getId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon image="edit" url="<%= editLocations.toString() %>" />
 </liferay-ui:icon-menu>
