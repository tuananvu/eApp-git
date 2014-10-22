<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateEmpJobHistory" var="updateEmpJobHistory">
</portlet:actionURL>
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
DynamicQuery jobDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpJob.class,
					PortletClassLoaderUtil.getClassLoader());
	jobDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpJob> empJob =EmpJobLocalServiceUtil
			.dynamicQuery(jobDynamicQuery);
	//EmpJob employeeJob; 
	if(empJob.size()!=0)
	{
Collections.sort(empJob, new Comparator<EmpJob>() {
		  public int compare(EmpJob o1, EmpJob o2) {
		      if (o1.getCreateDate() == null || o2.getCreateDate() == null)
		        return 0;
		      return o1.getCreateDate().compareTo(o2.getCreateDate());
		  }
		});	 
	}
%>
<div class="panel">
	<div class="panel-heading">
		<h3>Job</h3>
	</div>
	<div class="panel-body">
		<aui:form name="jobHistoryDetails" id="jobHistoryDetails"
			method="post" action="<%=updateEmpJobHistory %>">
			<aui:input name="empJId" value="<%=employeeId %>" type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="joined_date" id="joined_date" label="Joined Date"
						cssClass="dateEmployee" inlineLabel="left" type="date"></aui:input>
				</div>
				<div class="span6">
					<aui:input name="probation_date" label="Probation Date"
						cssClass="dateEmployee" inlineLabel="left" disabled="true"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="date_permanency" label="Date of Permanency"
						cssClass="dateEmployee" inlineLabel="left" disabled="true"></aui:input>
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
						<aui:option value="<%=empjobTitle.getJobTitleId()%>"
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
						<aui:option value="<%=empStatus9.getEmploymentStatusId()%>"
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
						<aui:option value="<%=jobCategory9.getJobCategoryId()%>"
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
						<aui:option value="<%=subUnit9.getSubUnitId()%>"
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
						<aui:option value="<%=location9.getLocationId()%>"
							label="<%=location9.getName()%>"></aui:option>
						<%
							}
									}
						%>
					</aui:select>
				</div>
				<div class="span6">
					<aui:input name="effective_date" label="Effective Date"
						cssClass="dateEmployee"></aui:input>
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
						<aui:option value="<%=workShift9.getShiftId()%>"
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
<div class="panel">
	<div class="panel-heading">
		<h3>Job History</h3>
	</div>
	<div class="panel-body">
		<aui:button name="deleteJobHistory" id="deleteJobHistory"
			cssClass="button btn-danger" value="Delete"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpJob"
			deltaConfigurable="true"
			rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpJob> empJobHistory = empJob;
							results = empJobHistory;
							total = empJobHistory.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpJob" modelVar="id">
				<liferay-ui:search-container-column-text name="Effective Date" property="effectiveDate"/>
				<liferay-ui:search-container-column-text name="End Date" property="probationEndDate" />
				<liferay-ui:search-container-column-text name="Job Title" />
				<liferay-ui:search-container-column-text name="Employment Status" />
				<liferay-ui:search-container-column-text name="Job Category" />
				<liferay-ui:search-container-column-text name="Sub Unit" />
				<liferay-ui:search-container-column-text name="Location" />
				<liferay-ui:search-container-column-text name="Comment" />
				<liferay-ui:search-container-column-text name="Contract Start Date" />
				<liferay-ui:search-container-column-text name="Contract End Date" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>