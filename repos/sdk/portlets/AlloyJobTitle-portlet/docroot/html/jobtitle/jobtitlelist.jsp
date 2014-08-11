<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rknowsys.eapp.CustomComparatorUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.service.persistence.PortletPreferencesFinderUtil"%>
<%@page import="com.liferay.portlet.PortalPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.rknowsys.eapp.service.JobTitlesLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.model.JobTitles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<portlet:defineObjects />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jobtitlelist</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/screen_preview.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.7.0.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<portlet:resourceURL var="savejobtitle" id="saveJobtitle"></portlet:resourceURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/jobtitle/jobtitlelist.jsp" />
</portlet:renderURL>
<portlet:resourceURL var="deletejobtitle" id="deleteJobtitle"></portlet:resourceURL>
<style type="text/css">	
.aui h6 {
 margin: -10px;
}
.aui .modal-header{
height: 18px;
}
</style>


<aui:script>
		function savejobtitle() {
			           
			       
			         var A=new AUI();
			          var id= A.one("#jobtitleId").get("value");
                     var title= A.one("#jobtitlename").get("value");
                     var description= A.one("#description").get("value");
                     var notes= A.one("#notes").get("value");
                     var url = '<%=savejobtitle%>';
			         A.io.request(url,
			                 {
			                  data: {
			                  		<portlet:namespace />jobtitleId: id,  
			                        <portlet:namespace />jobtitlename: title,
			                        <portlet:namespace />description: description,
			                        <portlet:namespace />notes: notes,  
			                         },
			                  on: {
			                       success: function() { 
			                          
			                      },
			                       failure: function() {
			                          
			                         }
			                        }
	                     }
	          );
	}
		
		

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
			  var d = confirm("Are you sure you want to delete the selected jobtitle ?");
		  if(d){
		   var url = '<%=deletejobtitle%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />jobtitleIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('Success');
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
</head>

<body>

	<h4></h4>
	
<div id="adddelete">

<!-- Button trigger modal -->     
     <a href="<%=request.getContextPath()%>/html/jobtitle/addjobtitle.jsp" onclick="showForm()" data-toggle="modal" data-target="#largeModal">Add</a> 
 
   
	&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"
		onclick="deleteJobtitle()" id="delete">Delete</a>
</div>


<input type="hidden" id="hiddenIds">


<div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true" style="top:60%;left:45%;width: 685px">
  <div class="modal-dialog">
    <div class="modal-content">
 	<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h6 class="modal-title" id="myModalLabel" style="margin-left: 10px;margin-top: -19px">Add Jobtitle</h6>
      </div>
 	
            </div>
      <div class="modal-body">
       
       
      </div>

      
    </div>
  </div>
</div>

<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="largeModal" aria-hidden="true" style="top:60%;left:45%;width: 685px">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h6 class="modal-title" id="myModalLabel" style="margin-left: 10px;margin-top: -19px">Edit Jobtitle</h6>
      </div> 
            </div>
      <div class="modal-body">
     
       
      </div>
      
    </div>
  </div>
</div>




</body>
 <%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/jobtitle/jobtitlelist.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<JobTitles> searchContainer;
%>

 <liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>"  delta="5" emptyResultsMessage="No records is available for Job Title" rowChecker="<%= new RowChecker(renderResponse) %>"  deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<JobTitles> jobtitleList = JobTitlesLocalServiceUtil.getJobTitleses(searchContainer.getStart(), searchContainer.getEnd()); //UserLocalServiceUtil.getUser(-1,-1);
            System.out.println("list size == " +jobtitleList.size());
            OrderByComparator orderByComparator = CustomComparatorUtil.getJobtitleOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(jobtitleList,orderByComparator);
  
          results = jobtitleList;
          
            System.out.println("results == " +results);
           
     
               total = JobTitlesLocalServiceUtil.getJobTitlesesCount();
               System.out.println("total == " +total);
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
		
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="JobTitles" keyProperty="id" modelVar="JobTitles"  rowVar="curRow" escapedModel="<%= true %>">
	     
	      <liferay-ui:search-container-column-text orderable="true" name="Job Title" property="title" orderableProperty="title"/>
		<liferay-ui:search-container-column-text orderable="true" name="Description" property="description" orderableProperty="description"/>
		<liferay-ui:search-container-column-text orderable="true" name="Notes" property="notes" orderableProperty="notes"/>
				<liferay-ui:search-container-column-jsp name="Edit"  path="/html/jobtitle/edit.jsp"/>
		
	     
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container> 
 

 

</html>