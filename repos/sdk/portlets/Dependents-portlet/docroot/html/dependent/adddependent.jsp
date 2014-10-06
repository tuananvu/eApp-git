<%@ include file="/html/dependent/init.jsp"%>
<%@page import="com.rknowsys.eapp.hrm.service.DependentLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Dependent"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dependent</title>
<portlet:actionURL var="savedependent" name="saveDependent">
</portlet:actionURL>
<portlet:resourceURL var="deletedependent" id="deleteDependent"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/dependent/adddependent.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}
.table-last-header {
	width: 15%;
}
</style>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delete');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[type=checkbox]:checked').each(function(object) {
      idArray.push(object.get("value"));
    
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected Work Experience ?");
		  if(d){
		   var url = '<%=deletedependent%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />dependentIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('deleted successfully');
                   window.location='<%=listview%>';
              },
               failure: function() {
                  
                 }
                }
                 }
                );
		  																		
		  console.log(idArray);
	  
      return true;
  }
  else
    return false;
}             
      }
    );
  }
);
</aui:script>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#dependentadddelete').hide();
         A.one('#addDependentForm').show();
                     
      }
    );
  }
);

 AUI().ready('event', 'node', function(A){

  A.one('#addDependentForm').hide();
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancel');
    node.on(
      'click',
      function() {
         A.one('#dependentadddelete').show();
         A.one('#addDependentForm').hide();
                     
      }
    );
  }
);

</aui:script>
</head>

<body>
	<div id="dependentadddelete" class="span12">
		<a href="#" id="add">Add</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" id="delete">Delete</a>

	</div>
	<div  id="addDependentForm">
	<aui:form name="myForm" action="<%=savedependent.toString()%>">
		<aui:input name="dependentId" type="hidden" id="dependentId" />
		
		<div class="span12">
			<div class="span2">
				<label>Name *</label>
		</div>
		<div class="span3">		
		 <aui:input name="name" type="text" label="" />
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Relationship *</label>
		</div>
		<div class="span3">		
		 <aui:input name="relationship" type="text" label="" />
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Please Specify *</label>
		</div>
		<div class="span3">		
		 <aui:input name="otherRelationship" type="text" label="" />
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Date of Birth</label>
		</div>
		<div class="span3">		
		 <aui:input name="dateOfBirth" type="text" label="" />
			</div>
		</div>

		<aui:button type="submit" value="Submit" />
		<aui:button  type="reset" value="Cancel" id ="cancel"/>
		
	</aui:form>
	</div>

	 <div><label style="color: white" >.</label></div>
	
</body>

<%

	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/dependent/adddependent.jsp");
	RowChecker rowChecker = new RowChecker(renderResponse);
	
	PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
	String sortByCol = ParamUtil.getString(request, "orderByCol"); 
	String sortByType = ParamUtil.getString(request, "orderByType"); 
	System.out.println("sortByCol == " +sortByCol);
	System.out.println("sortByType == " +sortByType);
	if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
		System.out.println("if block...");
	 
	portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
	portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
	 
	} else { 
	 
		sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
	}
	
	System.out.println("after....");
	System.out.println("sortByCol == " +sortByCol);
	System.out.println("sortByType == " +sortByType);

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Dependent> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="7"
	emptyResultsMessage="No records is available for Dependents."
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	
	<liferay-ui:search-container-results>

		<%
		  List<Dependent> dependentList = DependentLocalServiceUtil.getDependents(searchContainer.getStart(), searchContainer.getEnd());
		  System.out.println("list size == " +dependentList.size());
		  OrderByComparator orderByComparator = CustomComparatorUtil.getDependentOrderByComparator(sortByCol, sortByType);         
		
		  Collections.sort(dependentList,orderByComparator);
		
		  results = dependentList;
		
		  System.out.println("results == " +results);
		
		  total = DependentLocalServiceUtil.getDependentsCount();
		  System.out.println("total == " +total);
		  pageContext.setAttribute("results", results);
		  pageContext.setAttribute("total", total);
 %>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="Dependent"
		keyProperty="dependentId" modelVar="dependent" rowVar="curRow"
		escapedModel="<%= true %>">

		<liferay-ui:search-container-column-text orderable="<%=false %>"
			name="Name" property="name" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Relationship"  property="relationship" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Date of Birth"  property="dateOfBirth" />

		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/dependent/edit.jsp" />	

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>

</html>