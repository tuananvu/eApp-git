<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/workweek/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Work Week</title>
<portlet:actionURL var="saveWorkWeek" name="saveWorkWeek">
</portlet:actionURL>

<portlet:renderURL var="initialView">
	<%-- 	<portlet:param name="mvcPath" value="/html/workweek/edit_workweek.jsp" /> --%>
 </portlet:renderURL>
<portlet:resourceURL var="resourceURL" id="resourceURL"/>

 <style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
</style>
<jsp:useBean id="editWorkWeek" class="com.rknowsys.eapp.ui.WorkWeek" scope="request" />
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editWorkWeekReadOnly').hide();
         A.one('#editWorkWeekFormDiv').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editWorkWeekFormDiv').hide();
 });
 

 function callServeResource(){
    AUI().use('aui-io-request', function(A){
        A.io.request('<%=resourceURL.toString()%>', {
               method: 'post',
               dataType: 'json',
               form: {
                   id: '<portlet:namespace />editWorkWeekForm'
               },
               on: {
                    success: function() {
						A.one('#<portlet:namespace />mondayWorkScheduleEdit > option[value="' + this.get('responseData').monday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />tuesdayWorkScheduleEdit > option[value="' + this.get('responseData').tuesday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />wednesdayWorkScheduleEdit > option[value="' + this.get('responseData').wednesday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />thursdayWorkScheduleEdit > option[value="' + this.get('responseData').thursday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />fridayWorkScheduleEdit > option[value="' + this.get('responseData').friday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />saturdayWorkScheduleEdit > option[value="' + this.get('responseData').saturday + '"]').set('selected', 'selected');
						A.one('#<portlet:namespace />sundayWorkScheduleEdit > option[value="' + this.get('responseData').sunday + '"]').set('selected', 'selected');
					}
				}
			});
		});
    }

</aui:script>
</head>

<body>
 
 <div id="editWorkWeekReadOnly">
 
		<aui:input name="workWeekId" type="hidden" value="<%=editWorkWeek.getWorkWeekId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Country</label>
		</div>
		<div class="span5">
		
		     <aui:select type="select" name="nationalityId" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getNationalities(); 
				String storedId=editWorkWeek.getNationalityId();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId()%>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Monday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="mondayWorkSchedule" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getMondayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Tuesday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="tuesdayWorkSchedule" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getTuesdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Wednesday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="wednesdayWorkSchedule" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getWednesdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Thursday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="thursdayWorkSchedule" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getThursdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Friday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="fridayWorkSchedule" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules();
				String storedId=editWorkWeek.getFridayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Saturday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="saturdayWorkSchedule" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getSaturdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Sunday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="sundayWorkSchedule" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getSundayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<aui:button type="button" id="edit" value="Edit" />
		</div>

</div>

<div id="editWorkWeekFormDiv">
  <aui:form name="editWorkWeekForm" action="<%=saveWorkWeek.toString()%>">
		<aui:input name="workWeekId" type="hidden" value="<%=editWorkWeek.getWorkWeekId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Country</label>
		</div>
		<div class="span5">
		
		     <aui:select type="select" name="nationalityId" label="" onchange="callServeResource()">
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getNationalities(); 
				String storedId=editWorkWeek.getNationalityId();
	         	for (IdNamePair idName:idNameList) { %>
	         	<% System.out.println("idName.getId() = " + idName.getId()); %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Monday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="mondayWorkScheduleEdit" label="" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getMondayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Tuesday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="tuesdayWorkScheduleEdit"  label=""  >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getTuesdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Wednesday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="wednesdayWorkScheduleEdit" label=""  >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getWednesdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Thursday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="thursdayWorkScheduleEdit" label=""  >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getThursdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Friday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="fridayWorkScheduleEdit" label="" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules();
				String storedId=editWorkWeek.getFridayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Saturday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="saturdayWorkScheduleEdit" label=""  >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getSaturdayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Sunday</label>
			</div>
			<div class="span5">		
		     <aui:select type="select" name="sundayWorkScheduleEdit" label=""  >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editWorkWeek.getWorkSchedules(); 
				String storedId=editWorkWeek.getSundayWorkSchedule();
	         	for (IdNamePair idName:idNameList) { %>
    	        <aui:option selected="<%=idName.getId().equals(storedId)%>"
                        value="<%=idName.getId() %>">
                	<%=idName.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
			</div>
		</div>

		<div class="span12">
			<aui:button type="submit" id="save" value="Submit" />
		</div>
	</aui:form>
</div>
	 <div><label style="color: white" >.</label>
</div>
</body>
</html>