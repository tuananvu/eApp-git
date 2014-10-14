<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addImmigrationDetails"
	var="addImmigrationDetails"
	windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<aui:script use="aui-base,aui-node,aui-io-request">
</aui:script>
<div id="empImmigrationAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Immigration Records</h3>
	</div>
	<div class="panel-body">
		<aui:button id="immigrationAdd" name="immigrationAdd" value="Add"></aui:button>
		<aui:button id="immigrationDelete" value="Delete"
			name="immigrationDelete"></aui:button>
	</div>
</div>
<div id="empImmigrationAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Immigration</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addImmigration" id="addImmigration"
			action="<portlet:actionURL/>" method="post">
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="img_number" label="Number"
						showRequiredLabel="false" inlineLabel="left">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="img_issued_date" id="imgIssueDate"
						label="Issued Date" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="img_exp_date" id="imgExpDate" label="Expiry Date"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="eligible_status" label="Eligible Status"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="issued_by" label="Issued By">
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="review_date" id="reviewDate" label="Review Date"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="img_comments" type="textarea" label="Comments"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitImmigrationDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>