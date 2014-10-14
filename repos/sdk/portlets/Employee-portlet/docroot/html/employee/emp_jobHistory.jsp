<%@ include file="/html/employee/init.jsp"%>
<div class="panel">
	<div class="panel-heading">
		<h3>Job</h3>
	</div>
	<div class="panel-body">
		<aui:form name="jobHistoryDetails" var="jobHistoryDetails"
			method="post" action="#">
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="joined_date" label="Joined Date"
						class="dateEmployee" inlineLabel="left" disabled="true"></aui:input>
				</div>
				<div class="span6">
					<aui:input name="probation_date" label="Probation Date"
						class="dateEmployee" inlineLabel="left" disabled="true"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="date_permanency" label="Date of Permanency"
						class="dateEmployee" inlineLabel="left" disabled="true"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="emp_job_title" label="Job Title">
						<%
							List<JobTitle> jobTitle = JobTitleLocalServiceUtil
											.getJobTitles(-1, -1);
									{
										Iterator<JobTitle> jobTitles = jobTitle.iterator();
										while (jobTitles.hasNext()) {
											JobTitle empjobTitle = jobTitles.next();
						%>
						<aui:option value="<%=empjobTitle.getTitle()%>"
							label="<%=empjobTitle.getTitle()%>"></aui:option>
						<%
							}
									}
						%>
					</aui:select>
				</div>
				<div class="span6">
					<aui:select name="emp_status" label="Employment Status">
						<%
							List<EmploymentStatus> empStatus = EmploymentStatusLocalServiceUtil
											.getEmploymentStatuses(-1, -1);
									{
										Iterator<EmploymentStatus> empStatuses = empStatus
												.iterator();
										while (empStatuses.hasNext()) {
											EmploymentStatus empStatus9 = empStatuses.next();
						%>
						<aui:option value="<%=empStatus9.getEmploymentstatus()%>"
							label="<%=empStatus9.getEmploymentstatus()%>"></aui:option>
						<%
							}
									}
						%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="emp_job_category" label="Job Category">
						<%
							List<JobCategory> jobCategories = JobCategoryLocalServiceUtil
											.getJobCategories(-1, -1);
									{
										Iterator<JobCategory> jobCategory = jobCategories
												.iterator();
										while (jobCategory.hasNext()) {
											JobCategory jobCategory9 = jobCategory.next();
						%>
						<aui:option value="<%=jobCategory9.getJobcategory()%>"
							label="<%=jobCategory9.getJobcategory()%>"></aui:option>
						<%
							}
									}
						%>
					</aui:select>
				</div>
				<div class="span6">
					<aui:select name="emp_sub_unit" label="Sub Unit">
						<%
							List<SubUnit> subUnit = SubUnitLocalServiceUtil
											.getSubUnits(-1, -1);
									{
										Iterator<SubUnit> subUnits = subUnit.iterator();
										while (subUnits.hasNext()) {
											SubUnit subUnit9 = subUnits.next();
						%>
						<aui:option value="<%=subUnit9.getName()%>"
							label="<%=subUnit9.getName()%>"></aui:option>
						<%
							}
									}
						%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="emp_location" label="Location">
						<%
							List<Location> location = LocationLocalServiceUtil
											.getLocations(-1, -1);
									{
										Iterator<Location> locations = location.iterator();
										while (locations.hasNext()) {
											Location location9 = locations.next();
						%>
						<aui:option value="<%=location9.getName()%>"
							label="<%=location9.getName()%>"></aui:option>
						<%
							}
									}
						%>
					</aui:select>
				</div>
				<div class="span6">
					<aui:input name="effective_date" label="Effective Date"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="emp_workshift" label="Work Shift">
						<%
							List<Workshift> workShift = WorkshiftLocalServiceUtil
											.getWorkshifts(-1, -1);
									{
										Iterator<Workshift> workShifts = workShift.iterator();
										while (workShifts.hasNext()) {
											Workshift workShift9 = workShifts.next();
						%>
						<aui:option value="<%=workShift9.getWorkshiftName()%>"
							label="<%=workShift9.getWorkshiftName()%>"></aui:option>
						<%
							}
									}
						%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="job_comments" label="Comments" type="textarea"></aui:input>
				</div>
			</div>
			<aui:button type="submit" id="submitJobHistory"
				cssClass="button btn-success"></aui:button>
			<aui:button id="terminateEmployment" value="Terminate Employment"
				cssClass="button btn-danger"></aui:button>
		</aui:form>
	</div>
</div>
