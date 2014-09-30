<%@include file="/html/locations/init.jsp" %>
<portlet:renderURL var="home">
<portlet:param name="mvcPath" value="/html/locations/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="addLocations" var="addLocation"></portlet:actionURL>
<div align="justify" class="row-fluid" >
<div class="span3">
<a href="<%=home %>">back</a>
</div>
<div class="span9" >
<h3>Add Location</h3>
</div>
</div>
<div class="container-fluid" >
<aui:form action="<%=addLocation %>" method="post" >

<aui:input name="name" id="name" showRequiredLabel="false" 
inlineLabel="left" >
<aui:validator name="required" /> 
</aui:input>
<aui:select name="country" inlineLabel="left">
<aui:option label="Afganisthan" value="Afganisthan"></aui:option>
<aui:option label="China" value="China"></aui:option>
<aui:option label="India" value="India"></aui:option>
</aui:select>
<aui:input name="state" inlineLabel="left" />
<aui:input name="city" inlineLabel="left" />
<aui:input name="address" inlineLabel="left" />
<aui:input name="zip" inlineLabel="left" />
<aui:input name="phone" inlineLabel="left"  >
<aui:validator name="digits" />
</aui:input>
<aui:input name="fax"  inlineLabel="left" />
<aui:input name="notes" inlineLabel="left" />
<aui:button-row>
<aui:button name="save"  type="submit" />
<aui:button name="reset" type="reset"/>
</aui:button-row>
</aui:form>
</div>