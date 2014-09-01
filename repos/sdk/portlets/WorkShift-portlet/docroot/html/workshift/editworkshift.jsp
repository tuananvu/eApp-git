<%@page import="com.rknowsys.eapp.hrm.model.Workshift"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/workshift/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Workshift</title>
<portlet:actionURL var="saveworkshift" name="saveWorkshift">
</portlet:actionURL>
<portlet:resourceURL var="deleteworkshift" id="deleteWorkshift" />
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/workshift/editworkshift.jsp" />
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
			  var d = confirm("Are you sure you want to delete the selected workshift ?");
		  if(d){
		   var url = '<%=deleteworkshift%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />workshiftIds: idArray,   
                 },
          on: {
               success: function() { 
                   alert('Records deleted successfully.');
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
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editjobeditdelete').hide();
         A.one('#editWorkshiftForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editjobeditdelete').hide();
 
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editcancel');
    node.on(
      'click',
      function() {
      	 A.one('#editjobeditdelete').show();
         A.	one('#editWorkshiftForm').hide();
         A.one("#editworkshift").set("value","");
      	A.one("#editworkshiftTime").set("value","");
      }
    );																																
  }
);

</aui:script>

<aui:script>
YUI().use(
  'aui-timepicker',
  function(Y) {
    new Y.TimePicker(
      {
        trigger: '#fromWorkHours',
        popover: {
          zIndex: 1
        },
        mask:'%H:%M',
        on: {
          selectionChange: function(event) {
            document.<portlet:namespace />addworkshiftForm_1.<portlet:namespace />duration.value = event.newSelection;
          }
        }
      }
    );
    new Y.TimePicker(
      {
        trigger: '#toWorkHours',
        mask:'%H:%M',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
            document.<portlet:namespace />addworkshiftForm_1.<portlet:namespace />duration.value = event.newSelection;
          }
        }
      }
    );
  }
);
</aui:script>

</head>
<body>
	<jsp:useBean id="editworkshift"
		type="com.rknowsys.eapp.hrm.model.Workshift" scope="request" />
			
	<div id="editjobeditdelete" class="span12">
		<a href="#" id="edit">edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"
			id="delete">Delete</a>
	</div>
	
	<div id="editWorkshiftForm">
		<aui:form name="myForm" action="<%=saveworkshift.toString()%>">
			<aui:input name="shiftId" type="hidden" id="shiftId"
				value="<%=editworkshift.getShiftId()%>" />
				<aui:fieldset label="Edit Work Shift">
					<label>Edit Work Shift</label>
					<input name="<portlet:namespace/>workshiftName" id="workshiftName"
					    type="text" value="<%=editworkshift.getWorkshiftName() %>">
					<label>From</label>
					<input name="<portlet:namespace/>fromWorkHours" id="fromWorkHours"
						type="text" value="<%=editworkshift.getFormattedFromWorkHoursStr() %>">
                    <label>To</label>
					<input name="<portlet:namespace/>toWorkHours" id="toWorkHours"
						type="text" value="<%=editworkshift.getFormattedToWorkHoursStr() %>">
		<aui:button-row>
			<aui:button type="submit" value="Submit" />
			<aui:button type="reset" value="Cancel" id="editcancel"></aui:button>
		</aui:button-row>
		</aui:fieldset>
		</aui:form>
	</div>
	
	<div>
		<label style="color: white">.</label>
	</div>
</body>
<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/workshift/editworkshift.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<Workshift> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Workshift."   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<Workshift> workshiftList = WorkshiftLocalServiceUtil.getWorkshifts(searchContainer.getStart(), searchContainer.getEnd());
            System.out.println("list size == " + workshiftList.size());
            OrderByComparator orderByComparator = CustomComparatorUtil.getWorkshiftOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(workshiftList,orderByComparator);
  
          results = workshiftList;
          
            System.out.println("results == " +results);
           
     
               total = WorkshiftLocalServiceUtil.getWorkshiftsCount();
               System.out.println("total == " +total);
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
               
 %>
	</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="Workshift"
			keyProperty="shiftId" modelVar="workshift" rowVar="curRow"
			escapedModel="<%=true%>">
			<liferay-ui:search-container-column-text orderable="<%=true%>"
				name="Shift Name" property="workshiftName"
				orderableProperty="workshift" />
			<liferay-ui:search-container-column-text orderable="<%=false%>"
				name="From" property="formattedFromWorkHoursStr" />
			<liferay-ui:search-container-column-text orderable="<%=false%>"
				name="To" property="formattedToWorkHoursStr" />
			<liferay-ui:search-container-column-text orderable="<%=false%>"
				name="Duration" property="formattedDurationStr" />
			<liferay-ui:search-container-column-jsp name="Edit"
				path="/html/workshift/edit.jsp" />

		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container>
</html>