<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateAssignedDependents"
	var="updateAssignedDependents"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<aui:script use="aui-base,aui-node,aui-io-request">
var A=new AUI();
A.ready(function()
  {
  A.one('#assignedDependentAdd').hide();
  });
   var addButton=A.one('#<portlet:namespace />dependentAdd');
   addButton.on('click',
   function()
   {
   alert("adding dependent details");
   A.one('#assignedDependentAddDelete').hide();
   A.one('#assignedDependentAdd').show();
   A.all('input[type=text]').set('disabled',false);
   A.all('select').set('disabled',false);
   A.all('input[type=radio]').set('disabled',false);
   });
   Liferay.provide(
     window,'submitForm',
   function() {
   var A = AUI();
   A.io.request('<%=updateAssignedDependents%>',{
   method: 'POST',
   form: { id: '<portlet:namespace />addDependent' },
   on: {
       success: function(){
       A.one('#assignedDependentAdd').hide();
       A.one('#assignedDependentAddDelete').show();
       }
       }
    });
  });
</aui:script>
<%
	String empId = (String) request.getSession(false).getAttribute(
			"empId");
	String dependentName, dependentRelation, dependentDOB;
	long employeeId = Long.parseLong(empId);
	DynamicQuery dependentDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpDependent.class,
					PortletClassLoaderUtil.getClassLoader());
	dependentDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpDependent> empDependentDetails = EmpDependentLocalServiceUtil
			.dynamicQuery(dependentDynamicQuery);
	EmpDependent empDependent = null;
	if (empDependentDetails.size() != 0) {
		empDependent = empDependentDetails.get(0);
		dependentRelation = empDependent.getRelationship() != null ? empDependent
				.getRelationship() : "";
		dependentName = empDependent.getName() != null ? empDependent
				.getName() : "";
		dependentDOB = empDependent.getDateOfBirth() != null ? empDependent
				.getDateOfBirth().toString() : "";
	} else {
		dependentRelation = "";
		dependentDOB = "";
		dependentName = "";
	}
%>
<div id="assignedDependentAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Dependents</h3>
	</div>
	<div class="panel-body">
		<aui:button id="dependentAdd" name="dependentAdd" value="Add"></aui:button>
		<aui:button id="dependentDelete" value="Delete" name="dependentDelete"></aui:button>
	</div>
</div>
<div id="assignedDependentAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Dependent</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addDependent" id="addDependent"
			action="<%=updateAssignedDependents%>" method="post">
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="dependent_name" label="Name"
						value="<%=dependentName%>" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="dependent_relationship" label="Relationship"
						value="<%=dependentRelation%>" inlineLabel="left"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitDependentDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>