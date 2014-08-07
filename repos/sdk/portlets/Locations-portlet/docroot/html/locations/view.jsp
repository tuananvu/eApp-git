<%@include file="/html/locations/init.jsp" %>
<portlet:renderURL var="addLocation">
	<portlet:param name="mvcPath" value="/html/locations/addLocation.jsp"/>
</portlet:renderURL>
<portlet:resourceURL var="deleteLocations"></portlet:resourceURL>
<portlet:renderURL var="viewJSP">
	<portlet:param name="mvcPath" value="/html/locations/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="searchLocations" var="searchLocations"></portlet:actionURL>
<div id="searchLocations">
	<aui:form name="locationSearch" action="<%=searchLocations %>" inlineLabel="right" >
		<aui:field-wrapper inlineLabel="true">
		<aui:input name="locationName" label="Location Name" inlineLabel="true" ></aui:input>
		<aui:select name="country" label="Country" inlineLabel="true">
		<aui:option label="Afganisthan" value="Afganisthan"></aui:option>
		<aui:option label="China" value="China"></aui:option>
		<aui:option label="India" value="India"></aui:option>
		</aui:select>
		</aui:field-wrapper>
		<aui:button type="submit" name="search" value="search"></aui:button>
	</aui:form>
</div>
<div id="buttons" align="right">
	<aui:a href="<%=addLocation %>">
	<i class="icon-plus"></i>
	</aui:a>
	<aui:button name="delete" id="delLocation" value="delete">
	</aui:button>
</div>
<hr>
<aui:script use="aui-base,aui-node, aui-io-request-deprecated, aui-datepicker-deprecated, aui-form-deprecated">
var A=new AUI();
A.one('#<portlet:namespace />delete').on('click',function(event)
	{
	var locationIdArray=[];
			A.all('input[type=checkbox]:checked').each(function(object)
			{
			locationIdArray.push(object.get("value"));
			alert(locationIdArray[0]);
			});
			alert(locationIdArray.length);
			if(confirm("Are you sure you want to delete?"))
			{
	var url="<%=deleteLocations%>"
	A.io.request(url,
		{
		data:{<portlet:namespace />id9:locationIdArray},
		 on: {
		     success: function() { 
		                   alert('Success');
		                   window.location('<%=viewJSP %>')
		                         }
             }
        });
        }
    });
</aui:script> 
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/locationseapp/view.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);
PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);
String sortByCol = ParamUtil.getString(request, "orderByCol");
String sortByType = ParamUtil.getString(request, "orderByType");
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) {
} else {
sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");
}
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Locations> searchContainer;
%>
<div id="displayLocations">
<liferay-ui:search-container emptyResultsMessage="norecordsfound" 
headerNames="name,city,country,phone,numberofemployees"
iteratorURL="<%=iteratorURL %>"
delta="9"
deltaConfigurable="true"
orderByCol="<%=sortByCol %>"   orderByType="<%=sortByType %>"
rowChecker="<%=new RowChecker(renderResponse) %>" > 
		<liferay-ui:search-container-results>
		<%List<Locations> jt=LocationsLocalServiceUtil.getLocationses(-1, -1);
		  OrderByComparator orderByComparator=CustomComparatorUtil.getLocationsOrderByComparator(sortByCol, sortByType);
		  Collections.sort(jt,orderByComparator);
		  results=ListUtil.subList(jt, searchContainer.getStart(), searchContainer.getEnd());
		  total=LocationsLocalServiceUtil.getLocationsesCount();
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
		%>
		</liferay-ui:search-container-results>
				<liferay-ui:search-container-row className="com.rknowsys.eapp.model.Locations" 
 				keyProperty="id" modelVar="id" >
						 <liferay-ui:search-container-column-text name="name" property="name" orderable="<%=true %>" orderableProperty="name"/>
						 <liferay-ui:search-container-column-text name="city" property="city" orderable="<%=true %>" orderableProperty="city"/>
						 <liferay-ui:search-container-column-text name="country" property="country" orderable="<%=true %>" orderableProperty="country"/>
						 <liferay-ui:search-container-column-text name="phone" property="phone" orderable="<%=true %>" orderableProperty="phone"/>
						 	 <liferay-ui:search-container-column-jsp path="/html/locations/edit.jsp" />
 				</liferay-ui:search-container-row>
	 <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>
</div>