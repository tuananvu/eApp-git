<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL var="updateEmpDirectDeposits"
	name="updateEmpDirectDeposits" />
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
%>
<aui:form name="empDirectDeposits" id="empDirectDeposits" method="post"
	action="<%=updateEmpDirectDeposits %>">
	<aui:input name="empDirId" value="<%=employeeId %>" type="hidden"></aui:input>
	<aui:input name="directFileId" value="<%=fileEntryId %>" type="hidden"></aui:input>
	<div id="empSalSummary" class="panel">
		<div class="panel-heading">
			<h3>Salary Summary</h3>
		</div>
		<div class="panel-body">
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="deposit_amount" label="Amount"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="deposit_acnt_number" label="Account Number"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="fin_institute"
						label="Name of the Financial Institute"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:select name="acnt_type" label="Account Type">
					<aui:option value="check" label="Check"></aui:option>
					<aui:option value="saving" label="Saving"></aui:option>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="branch_location" label="Branch Location"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="routing_number" label="Routing Number"></aui:input>
				</div>
			</div>
			<aui:button type="submit" value="Save" id="submitDirectDeposits"></aui:button>
		</div>
	</div>
</aui:form>