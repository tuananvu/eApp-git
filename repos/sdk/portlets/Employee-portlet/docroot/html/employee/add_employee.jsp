<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="saveEmpDetails" var="saveEmpDetails"></portlet:actionURL>
<div id="search_form" class="panel">
	<div class="panel-heading">
		<h3>Add Employee</h3>
	</div>
	<div class="panel-body">
		<div id="addEmployeeForm">
			<aui:form name="myForm" id="addEmployeeForm"
				action="<%=saveEmpDetails.toString()%>">
				<aui:input name="employeeId" type="hidden" />
				<div class="row-fluid">
					<div class="span2">
						<label><b>Full Name</b></label>
					</div>
					<div class="span3">
						<aui:input name="firstName" type="text" showRequiredLabel="false">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					</div>
					<div class="span3">
						<aui:input name="middleName" type="text">
						</aui:input>
					</div>
					<div class="span4">
						<aui:input name="lastName" type="text" showRequiredLabel="false">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="employee_id" label="Employee Id" 
						inlineLabel="left"></aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="photograph" label="Photograph" type="file" 
						inlineLabel="left"></aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="createLoginDetails" label="Create Login Details"
							type="checkbox" value="1"  inlineField="right"/>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:select name="location" label="Location" inlineLabel="left">
							<%
								List l = LocationLocalServiceUtil.getLocations(-1, -1);
										Iterator locations = l.iterator();
										while (locations.hasNext()) {
											Location locations2 = (Location) locations.next();
							%>
							<aui:option value="<%=locations2.getName()%>"><%=locations2.getName()%></aui:option>
							<%
								}
							%>
						</aui:select>
					</div>
				</div>
				<aui:button type="submit" value="Submit"
					cssClass="button btn-primary" />
				<aui:button type="reset" value="Cancel" id="cancel"
					cssClass="button btn-danger" />

			</aui:form>
		</div>
	</div>
</div>


