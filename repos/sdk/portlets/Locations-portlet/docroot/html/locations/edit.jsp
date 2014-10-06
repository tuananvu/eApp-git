<%@ include file="/html/locations/init.jsp" %>
<% ResultRow row=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Location locations=(Location)row.getObject();
	long id=locations.getLocationId();
	String redirect=PortalUtil.getCurrentURL(renderRequest);
%>
<liferay-ui:icon-menu>
	<portlet:actionURL name="editLocation" var="editLocations">
		<portlet:param name="id"
			value="<%=Long.toString(locations.getLocationId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon image="edit" url="<%= editLocations.toString() %>" />
 </liferay-ui:icon-menu>
