<%@page import="com.rknowsys.eapp.hrm.util.IdNamePair"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/job/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job</title>
<portlet:actionURL var="saveJob" name="saveJob">
</portlet:actionURL>
<portlet:renderURL var="initialView">
	<%-- 	<portlet:param name="mvcPath" value="/html/job/edit_job.jsp" /> --%>
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
         A.one('#editJobReadOnly').hide();
         A.one('#editJobForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editJobForm').hide();
 
 });

</aui:script>
</head>

<body>

 <jsp:useBean id="editJob" class="com.rknowsys.eapp.ui.Job" scope="request" />
 
 <div id="editJobReadOnly">
 
		<aui:input name="jobId" type="hidden" value="<%=editJob.getJobId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Job Title</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="jobTitleId" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> titles = editJob.getJobTitles(); 
				String empJobTitleId=editJob.getJobTitleId();
	         	for (IdNamePair title:titles) { %>
    	        <aui:option selected="<%=title.getId().equals(empJobTitleId)%>"
                        value="<%=title.getId() %>">
                	<%=title.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Job Specification</label>
			</div>
			<div class="span3">		
		 		<aui:input name="jobSpecification" type="text" label="" disabled="true" value="<%=editJob.getJobSpecification()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Employment Status</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="employmentStatusId" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> statuses = editJob.getEmploymentStatuses(); 
				String empStatusId=editJob.getEmploymentStatusId();
	         	for (IdNamePair status:statuses) { %>
    	        <aui:option selected="<%=status.getId().equals(empStatusId)%>"
                        value="<%=status.getId() %>">
                	<%=status.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Job Category</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="jobCategoryId" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> jobCategories = editJob.getJobCategories(); 
				String jobCategoryId=editJob.getJobCategoryId();
	         	for (IdNamePair jobCategory:jobCategories) { %>
    	        <aui:option selected="<%=jobCategory.getId().equals(jobCategoryId)%>"
                        value="<%=jobCategory.getId() %>">
                	<%=jobCategory.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>

		</div>
		<div class="span12">
			<div class="span2">
				<label>Joined Date</label>
		</div>
		<div class="span3">		
		 <aui:input name="joinedDate" type="text" label="" disabled="true" value="<%=editJob.getJoinedDate()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Sub Unit</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="subUnitId" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> subUnits = editJob.getSubUnits(); 
				String subUnitId=editJob.getSubUnitId();
	         	for (IdNamePair subUnit:subUnits) { %>
    	        <aui:option selected="<%=subUnit.getId().equals(subUnitId)%>"
                        value="<%=subUnit.getId() %>">
                	<%=subUnit.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>

		</div>

		<div class="span12">
			<div class="span2">
				<label>Location</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="locationId" label="" disabled="true" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> idNameList = editJob.getLocations(); 
				String storedId=editJob.getLocationId();
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
				<label>Employment Contract</label>
		</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Start Date</label>
		</div>
		<div class="span3">		
		 <aui:input name="employmentContractStartDate" type="text" label="" disabled="true" value="<%=editJob.getStartDate()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>End Date</label>
		</div>
		<div class="span3">		
		 <aui:input name="employmentContractEndDate" type="text" label="" disabled="true" value="<%=editJob.getEndDate()%>"/>
			</div>
		</div>

		<div class="span12">
			<aui:button type="button" id="edit" value="Edit" />
		</div>

</div>

<div id="editJobForm">
  <aui:form name="myForm" action="<%=saveJob.toString()%>">
		<aui:input name="jobId" type="hidden" value="<%=editJob.getJobId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Job Title</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="jobTitleId" label="" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> titles = editJob.getJobTitles(); 
				String empJobTitleId=editJob.getJobTitleId();
	         	for (IdNamePair title:titles) { %>
    	        <aui:option selected="<%=title.getId().equals(empJobTitleId)%>"
                        value="<%=title.getId() %>">
                	<%=title.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Job Specification</label>
			</div>
			<div class="span3">		
		 		<aui:input name="jobSpecification" type="text" label="" value="<%=editJob.getJobSpecification()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Employment Status</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="employmentStatusId" label=""  >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> statuses = editJob.getEmploymentStatuses(); 
				String empStatusId=editJob.getEmploymentStatusId();
	         	for (IdNamePair status:statuses) { %>
    	        <aui:option selected="<%=status.getId().equals(empStatusId)%>"
                        value="<%=status.getId() %>">
                	<%=status.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Job Category</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="jobCategoryId" label="" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> jobCategories = editJob.getJobCategories(); 
				String jobCategoryId=editJob.getJobCategoryId();
	         	for (IdNamePair jobCategory:jobCategories) { %>
    	        <aui:option selected="<%=jobCategory.getId().equals(jobCategoryId)%>"
                        value="<%=jobCategory.getId() %>">
                	<%=jobCategory.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>

		</div>
		<div class="span12">
			<div class="span2">
				<label>Joined Date</label>
		</div>
		<div class="span3">		
		 <aui:input name="joinedDate" type="text" label="" value="<%=editJob.getJoinedDate()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Sub Unit</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="subUnitId" label=""  >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> subUnits = editJob.getSubUnits(); 
				String subUnitId=editJob.getSubUnitId();
	         	for (IdNamePair subUnit:subUnits) { %>
    	        <aui:option selected="<%=subUnit.getId().equals(subUnitId)%>"
                        value="<%=subUnit.getId() %>">
                	<%=subUnit.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>

		</div>

		<div class="span12">
			<div class="span2">
				<label>Location</label>
		</div>
		<div class="span3">
		
		     <aui:select type="select" name="locationId" label="" >
				<aui:option value="-1">--Select--</aui:option>
	         <% 			
	         	List<IdNamePair> locations = editJob.getLocations(); 
				String locationId=editJob.getLocationId();
	         	for (IdNamePair location:locations) { %>
    	        <aui:option selected="<%=location.getId().equals(locationId)%>"
                        value="<%=location.getId() %>">
                	<%=location.getName()%>
            	</aui:option>
           	 <% } %>

			</aui:select>
		</div>

		</div>

		<div class="span12">
			<div class="span2">
				<label>Employment Contract</label>
		</div>
		</div>
		
		<div class="span12">
			<div class="span2">
				<label>Start Date</label>
		</div>
		<div class="span3">		
		 <aui:input name="employmentContractStartDate" type="text" label="" value="<%=editJob.getStartDate()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>End Date</label>
		</div>
		<div class="span3">		
		 <aui:input name="employmentContractEndDate" type="text" label="" value="<%=editJob.getEndDate()%>"/>
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