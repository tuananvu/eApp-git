<%@page
	import="com.rknowsys.eapp.hrm.service.MembershipLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.Membership"%>
<%@ include file="/html/employee/init.jsp"%>
<div id="empMembershipAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Membership</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empMembershipAdd" name="empMembershipAdd" value="Add"></aui:button>
		<aui:button id="empMembershipDelete" value="Delete"
			name="empMembershipDelete"></aui:button>
	</div>
</div>
<div id="addEmpMembership" class="panel">
	<div class="panel-heading">
		<h3>Add Membership</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmployeeMembership" id="addEmployeeMembership"
			action="<portlet:actionURL/>" method="post">
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="emp_membership" label="Membership"
						inlineLabel="left" showRequiredLabel="false">
						<%
							List<Membership> membershipList = MembershipLocalServiceUtil
											.getMemberships(-1, -1);
									Iterator membershipList2 = membershipList.iterator();
									while (membershipList2.hasNext()) {
										Membership membership = (Membership) membershipList2
												.next();
						%>

						<aui:option value="<%=membership.getMembershipName()%>"
							label="<%=membership.getMembershipName()%>"></aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="sub_paid_by" label="Subscription Paid By">
						<aui:option>Individual</aui:option>
						<aui:option>Company</aui:option>
					</aui:select>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitMembershipDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>