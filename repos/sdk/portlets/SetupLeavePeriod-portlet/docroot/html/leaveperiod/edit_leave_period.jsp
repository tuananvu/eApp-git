<%@page import="com.rknowsys.eapp.hrm.service.LeavePeriodLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.ui.LeavePeriod"%>
<%@page import="com.rknowsys.eapp.hrm.model.Employee"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@ include file="/html/leaveperiod/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Period</title>
<portlet:actionURL var="saveLeavePeriod" name="saveLeavePeriod">
</portlet:actionURL>

<%-- 
<portlet:resourceURL var="deleteemergencycontact" id="deleteEmergencyContact"/>
 --%>
 
<portlet:renderURL var="initialView">
	<%-- 	<portlet:param name="mvcPath" value="/html/contactdetails/edit_contact_details.jsp" /> --%>
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
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editLeavePeriodReadOnly').hide();
         A.one('#editLeavePeriodForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editLeavePeriodForm').hide();
 
 });

</aui:script>
</head>

<body>

 <jsp:useBean id="editLeavePeriod" type="com.rknowsys.eapp.ui.LeavePeriod" scope="request" />
 
 <div id="editLeavePeriodReadOnly">
 
		<aui:input name="leavePeriodId" type="hidden" value="<%=editLeavePeriod.getLeavePeriodId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Start Month</label>
		</div>
		<div class="span3">
		
			<aui:select type="select" name="startMonth" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editLeavePeriod.getMonths();
				String storedId=String.valueOf(editLeavePeriod.getStartMonth());
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		
		<%--  <aui:input name="startMonth" type="text" label="" disabled="true" value="<%=editLeavePeriod.getStartMonth() %>"/> --%>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Start Date</label>
			</div>
			<div class="span3">	
		 		<aui:input name="startDate" type="text" label="" disabled="true" value="<%=editLeavePeriod.getStartDate() %>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>End Date</label>
		</div>
		<div class="span3">
		 <aui:input name="endDate" type="text" label="" disabled="true" value="<%=editLeavePeriod.getEndDate() %>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Current Leave Period</label>
		</div>
		<div class="span3">		
		 <aui:input name="currentLeavePeriod" type="text" label="" disabled="true" value="<%=editLeavePeriod.getCurrentLeavePeriod()%>"/>
			</div>
		</div>

		<div class="span12">
			<aui:button type="button" id="edit" value="Edit" />
		</div>

</div>



<div id="editLeavePeriodForm">
  <aui:form name="myForm" action="<%=saveLeavePeriod.toString()%>">
  
		<aui:input name="leavePeriodId" type="hidden" value="<%=editLeavePeriod.getLeavePeriodId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Start Month</label>
		</div>
		<div class="span3">
		
			<aui:select type="select" name="startMonth" label="" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editLeavePeriod.getMonths();
				String storedId=String.valueOf(editLeavePeriod.getStartMonth());
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		
		<%--  <aui:input name="startMonth" type="text" label="" disabled="true" value="<%=editLeavePeriod.getStartMonth() %>"/> --%>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Start Date</label>
			</div>
			<div class="span3">	
		 		<aui:input name="startDate" type="text" label="" value="<%=editLeavePeriod.getStartDate() %>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>End Date</label>
		</div>
		<div class="span3">
		 <aui:input name="endDate" type="text" label="" disabled="true" value="<%=editLeavePeriod.getEndDate() %>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Current Leave Period</label>
		</div>
		<div class="span3">		
		 <aui:input name="currentLeavePeriod" type="text" label="" disabled="true" value="<%=editLeavePeriod.getCurrentLeavePeriod()%>"/>
			</div>
		</div>

		<aui:button type="submit" id="save" value="Submit" />
		<%-- <aui:button  type="reset" value="Cancel" id ="cancel"/> --%>

	</aui:form>
</div>
	 <div><label style="color: white" >.</label>
</div>
</body>

</html>