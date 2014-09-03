<%@ include file="/html/locations/init.jsp" %>
<jsp:useBean id="edit" type="com.rknowsys.eapp.hrm.model.Locations" scope="request" />
<portlet:actionURL name="updateLocation" var="editLocation"></portlet:actionURL>
<aui:form name="eLocation" method="post" action="<%=editLocation%>">
	<aui:fieldset>
		<aui:input name="id" value="<%=edit.getId()%>" type="hidden" />
		<aui:input name="name" value="<%=edit.getName()%>" />
		<aui:input name="country" value="<%=edit.getCountry()%>" />
		<aui:input name="state" value="<%=edit.getState()%>" />
		<aui:input name="phone" value="<%=edit.getPhone()%>" />
	</aui:fieldset>
	<aui:button type="submit" />
</aui:form>