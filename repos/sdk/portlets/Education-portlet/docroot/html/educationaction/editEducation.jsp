<%@ include file="/html/educationaction/init.jsp" %>
<portlet:actionURL var="updateEducations" name="updateEducation">
</portlet:actionURL>
<portlet:resourceURL var="deleteEducations" id="deleteEducation"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/educationaction/addEducation.jsp" />
</portlet:renderURL>
<style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
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
			  var d = confirm("Are you sure you want to delete the selected education?");
		  if(d){
		   var url = '<%=deleteEducations%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />educationIds: idArray,  
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
</aui:script><aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#editEducationAddDelete').hide();
         A.one('#editEducationForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editEducationAddDelete').hide();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editCancel');
    node.on(
      'click',
      function() {
      	 A.one('#editEducationAddDelete').show();
         A.	one('#editEducationForm').hide();
         A.one("#editEducation").set("value","");
      	
          
      }
    );																																
  }
);

</aui:script>



</head>
<body>
<jsp:useBean id="editEducation" type="com.rknowsys.eapp.hrm.model.Education" scope="request" />
<div id="editEducationAddDelete" class="span12">
		<a href="#" id="add">Add</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"
			id="delete">Delete</a>
	</div>
	<div id="editEducationForm">
  <aui:form name="myForm" action="<%=updateEducations.toString()%>">
		<aui:input name="educationId" type="hidden" id="educationId"  value="<%=editEducation.getId()%>"/>
		<div class="span12">
			<div class="span2">
				<label>Level</label>
		</div>
		<div class="span3">		
		 <input name="<portlet:namespace/>education_level" type="text" required = "required" value="<%=editEducation.getEduLevel() %>" >
			</div>
		</div>
	<aui:button type="submit" value="Submit"/> <aui:button  type="reset" value="Cancel" id ="editCancel"></aui:button>
	</aui:form>
	</div>
	 <div><label style="color: white" >.</label></div>
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/educationaction/editEducation.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Education> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Jobcategory"   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<Education> listOfEducations = EducationLocalServiceUtil.getEducations(searchContainer.getStart(), searchContainer.getEnd());
            OrderByComparator orderByComparator = CustomComparatorUtil.getEducationOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(listOfEducations,orderByComparator);
  
          results = listOfEducations;
          
           
     
               total = EducationLocalServiceUtil.getEducationsCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Education" keyProperty="id" modelVar="id"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="name" property="eduLevel" orderableProperty="eduLevel"/>
		
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/educationaction/edit.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>




