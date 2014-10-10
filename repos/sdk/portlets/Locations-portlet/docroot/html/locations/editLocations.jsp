<%@ include file="/html/locations/init.jsp" %>
<portlet:renderURL var="home">
<portlet:param name="mvcPath" value="/html/locations/view.jsp"/>
</portlet:renderURL>
<div class="row-fluid" >
<div align="justify"  class="span3" >
<a href="<%=home %>">back</a>
</div>
<div class="span9" >
<h3>Edit Location</h3>
</div>
</div>
<jsp:useBean id="edit" type="com.rknowsys.eapp.hrm.model.Location" scope="request" />
<portlet:actionURL name="updateLocation" var="editLocation"></portlet:actionURL>
<aui:form name="eLocation" method="post" action="<%=editLocation%>">
	<aui:fieldset>
		<aui:input name="id" value="<%=edit.getLocationId()%>" type="hidden" />
		<aui:input name="name" value="<%=edit.getName()%>" 
		inlineLabel="left" />
		<aui:input name="country" value="<%=edit.getCountry()%>"
		inlineLabel="left" />
		<aui:input name="state" value="<%=edit.getState()%>" 
		inlineLabel="left" />
		<aui:input name="city" value="<%=edit.getCity() %>"
		inlineLabel="left" />
		<aui:input name="address" value="<%=edit.getAddress() %>"
		inlineLabel="left" />
		<aui:input name="zip" value="<%=edit.getPostalcode() %>"
		inlineLabel="left" />
		<aui:input name="phone" value="<%=edit.getPhone() %>" 
		inlineLabel="left" />
	</aui:fieldset>
	<aui:button type="submit" />
</aui:form>