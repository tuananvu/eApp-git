<%@ include file="/html/employee/init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>employee</title>
<portlet:actionURL var="saveemployee" name="saveEmployee">
</portlet:actionURL>
<portlet:renderURL var="addview">
	<portlet:param name="mvcPath" value="/html/employee/add_employee.jsp" />
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
    var node = A.one('#cancel');
    node.on(
      'click',
      function() {
          window.location='<%=addview%>';
      }
    );
  }
);

</aui:script>
</head>

<body>
	<div id="addEmployeeForm">
		<aui:form name="myForm" action="<%=saveemployee.toString()%>" >
			<aui:input name="employeeId" type="hidden"  />
			<div class="span12">
				<label>Add Employee</label>
			</div>
			<div class="span12">
				<div class="span3">
					<label>Full Name</label>
				</div>
				<div class="span3">
					<aui:input name="firstName" 
						type="text">
						<aui:validator name="required"></aui:validator>
						</aui:input>
				</div>
				<div class="span3">
					<aui:input name="middleName" 
						type="text">
						</aui:input>
				</div>
				<div class="span3">
					<aui:input name="lastName" 
						type="text" required="required">
						<aui:validator name="required"></aui:validator>
						</aui:input>
				</div>
			</div>		
 				<div class="span12">
				<div class="span6">
					<aui:input name="createLoginDetails" label="Create Login Details" type="checkbox" value="1" />
				</div>
			</div>
			<aui:button type="submit" value="Submit" />
			<aui:button type="reset" value="Cancel" id="cancel" />

		</aui:form>
	</div>

</body>
</html>