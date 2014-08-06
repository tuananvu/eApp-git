<%@include file="/html/locationseapp/init.jsp" %>
<%
String lname=(String)request.getAttribute("lname");
String lcountry=(String)request.getAttribute("lcountry");

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/locationseapp/search.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);
PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);
String sortByCol = ParamUtil.getString(request, "orderByCol");
String sortByType = ParamUtil.getString(request, "orderByType");
System.out.println("sortByCol == " +sortByCol);
System.out.println("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) {
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol);
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol);
} else {
sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");
}
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Locations> searchContainer;
%>
<div id="displaySearchLocations">
<liferay-ui:search-container emptyResultsMessage="norecordsfound" 
headerNames="name,city,country,phone,numberofemployees"
iteratorURL="<%=iteratorURL %>"
delta="9"
deltaConfigurable="true"
orderByCol="<%=sortByCol %>"   orderByType="<%=sortByType %>"
rowChecker="<%=new RowChecker(renderResponse) %>" > 
		<liferay-ui:search-container-results>
		<%List<Locations> jt=LocationsLocalServiceUtil.findBynameAndCountry(lname, lcountry);
		  OrderByComparator orderByComparator=CustomComparatorUtil.getLocationsOrderByComparator(sortByCol, sortByType);
		  Collections.sort(jt,orderByComparator);
		  results=ListUtil.subList(jt, searchContainer.getStart(), searchContainer.getEnd());
		  total=LocationsLocalServiceUtil.getLocationsesCount();
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
		%>
		</liferay-ui:search-container-results>
				<liferay-ui:search-container-row className="com.rknowsys.eapp.hrm.model.Locations" 
 				keyProperty="id" modelVar="id" >
						 <liferay-ui:search-container-column-text name="name" property="name" orderable="<%=true %>" orderableProperty="name"/>
						 <liferay-ui:search-container-column-text name="city" property="city" orderable="<%=true %>" orderableProperty="city"/>
						 <liferay-ui:search-container-column-text name="country" property="country" orderable="<%=true %>" orderableProperty="country"/>
						 <liferay-ui:search-container-column-text name="phone" property="phone" orderable="<%=true %>" orderableProperty="phone"/>
						 	 <liferay-ui:search-container-column-jsp path="/html/locationseapp/edit.jsp" />
 				</liferay-ui:search-container-row>
	 <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>

</div>