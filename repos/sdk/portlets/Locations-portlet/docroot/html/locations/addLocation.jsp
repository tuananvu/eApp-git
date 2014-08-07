<%@include file="/html/locations/init.jsp" %>
<portlet:actionURL name="addLocations" var="addLocation"></portlet:actionURL>
<aui:form action="<%=addLocation %>" method="post" >
<aui:fieldset>
<aui:input name="name" id="name" >
<aui:validator name="required" /> 
</aui:input>
<aui:select name="country">
<aui:option label="Afganisthan" value="Afganisthan"></aui:option>
<aui:option label="China" value="China"></aui:option>
<aui:option label="India" value="India"></aui:option>
</aui:select>
<aui:input name="state" />
<aui:input name="city" />
<aui:input name="address" />
<aui:input name="zip" />
<aui:input name="phone" >
<aui:validator name="digits" />
</aui:input>
<aui:input name="fax" />
<aui:input name="notes" />
<aui:button-row>
<aui:button name="save"  type="submit" />
<aui:button name="reset" type="reset"/>
</aui:button-row>
</aui:fieldset>
</aui:form>