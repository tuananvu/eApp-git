<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="saveEmpDetails" var="saveEmpDetails"></portlet:actionURL>
<aui:script use="aui-base,aui-node">
var A=new AUI();
A.ready(function()
{
 A.one("#createLoginDetailsDiv").hide();
});
	  var checkbox_obj= A.one('input[name=<portlet:namespace/>createLoginDetailsCheckbox]')
	  checkbox_obj.on('click',function()
	  {
	  
	   if(A.one('input[name=<portlet:namespace/>createLoginDetailsCheckbox]:checked'))
	   {
	  A.one("#createLoginDetailsDiv").show();
	  }
	  else
	  {
	   A.one("#createLoginDetailsDiv").hide();
	  }
	  });
</aui:script>
<div id="search_form" class="panel">
	<div class="panel-heading">
		<h3>Add Employee</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmployeeForm" id="addEmployeeForm"
			action="<%=saveEmpDetails%>" method="post">
			<div class="container-fluid">
				<aui:input name="employeeId" type="hidden" />
				<div class="row-fluid">
					<div class="span12">
						<label><b>Full Name</b></label>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="firstName" type="text" showRequiredLabel="false"
							inlineLabel="left" label="First Name">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="middleName" type="text" label="Middle Name">
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="lastName" type="text" showRequiredLabel="false"
							inlineLabel="left" label="Last Name">
							<aui:validator name="required"></aui:validator>
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="employee_no" label="Employee No"
							inlineLabel="left">
						</aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:input name="photograph" label="Photograph" type="file"
							inlineLabel="left"></aui:input>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span1">
						<aui:input name="createLoginDetails" id="createLoginDetails"
							label="" type="checkbox" 
							/>
					</div>
					<div class="span1"></div>
					<div class="span10">
						<label><b>Create Login Details</b></label>
					</div>
				</div>
				<div id="createLoginDetailsDiv">
					<div class="row-fluid">
						<div class="span6">
							<aui:input name="user_name" label="User Name"></aui:input>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<aui:input name="password" label="Password" type="password"></aui:input>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<aui:input name="confirm_password" label="Confirm Password"
							 type="password"></aui:input>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span6">
						<aui:select name="location" label="Location" inlineLabel="left">
						<aui:option value="-1">--Select--</aui:option>
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
					cssClass="button btn-primary" id="submitEmployee" />
				<aui:button type="reset" value="Cancel" id="cancel"
					cssClass="button btn-danger" />
			</div>
		</aui:form>
	</div>
</div>

