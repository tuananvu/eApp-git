<%@ include file="/html/locations/init.jsp" %>
<% ResultRow row=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Location Location=(Location)row.getObject();
	long id=Location.getId();
	String redirect=PortalUtil.getCurrentURL(renderRequest);
%>
<liferay-ui:icon-menu>
	<portlet:actionURL name="editLocation" var="editLocation">
		<portlet:param name="id"
			value="<%=Long.toString(Location.getLocationId()) %>" />
	</portlet:actionURL>
	<liferay-ui:icon image="edit" url="<%= editLocation.toString() %>" />
 </liferay-ui:icon-menu>
