<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addSupervisor" var="addSupervisor"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<portlet:actionURL name="addSubordinate" var="addSubordinate"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<aui:script use="aui-base,aui-node,aui-io-request">
</aui:script>
<div id="supervisorAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Supervisors</h3>
	</div>
	<div class="panel-body">
		<aui:button id="supervisorAdd" name="supervisorAdd" value="Add"></aui:button>
		<aui:button id="supervisorDelete" value="Delete"
			name="supervisorDelete"></aui:button>
	</div>
</div>
<div id="subordinateAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Subordinates</h3>
	</div>
	<div class="panel-body">
		<aui:button id="subordinateAdd" name="subordinateAdd" value="Add"></aui:button>
		<aui:button id="subordinateDelete" value="Delete"
			name="subordinateDelete"></aui:button>
	</div>
</div>
<div id="assignedSupervisorAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Supervisor</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addSupervisor" id="addSupervisor"
			action="<portlet:actionURL/>" method="post">
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="report_sup_name" label="Name" inlineLabel="left"
						showRequiredLabel="false">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="reporting_sup_method" label="Reporting Method"
						inlineLabel="left" showRequiredLabel="false">
						<aui:option name="direct">Direct</aui:option>
						<aui:option name="direct">Indirect</aui:option>
						<aui:option name="direct">Other</aui:option>
					</aui:select>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitReportingDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>
<div id="assignedSubordinateAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Subordinate</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addSubordinate" id="addSubordinate"
			action="<portlet:actionURL/>" method="post">
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="report_sub_name" label="Name" inlineLabel="left"
						showRequiredLabel="false">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="reporting_sub_method" label="Reporting Method"
						inlineLabel="left" showRequiredLabel="false">
						<aui:option name="direct">Direct</aui:option>
						<aui:option name="direct">Indirect</aui:option>
						<aui:option name="direct">Other</aui:option>
					</aui:select>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="subReportingDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>