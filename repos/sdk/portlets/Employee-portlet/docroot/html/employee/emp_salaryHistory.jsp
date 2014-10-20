<%@ include file="/html/employee/init.jsp"%>
<portlet:resourceURL var="dependencyDropdown" id="dependencyDropdown"></portlet:resourceURL>
<portlet:actionURL var="updateEmpSalaryDetails" name="updateEmpSalaryDetails" />
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
%>
<aui:script>
var A=new AUI();
A.ready(function()
	{
    window.dropdowns= function(nodeValue)
    {
		var currencyDropDown=nodeValue;
		var targetElement = A.one("#<portlet:namespace />emp_paygrade_currency");
		alert("selected value is"+currencyDropDown);
		var url = '<%=dependencyDropdown%>';
         A.io.request(url,
         {
         data: {  
               <portlet:namespace />dropDownValue: currencyDropDown,  
               },
         dataType:'json',
         on: {
               success: function() { 
                  var currencyArray=this.get('responseData');
                  targetElement.html("");
                  for (var j=0; j < currencyArray.length; j++) {
                   targetElement.append("<option value='" + currencyArray[j] + "'>" + currencyArray[j] + "</option>");
                            }
                   alert('submitted successfully');
                  },
                failure: function() {
                    alert("cannot submit");
                  }
               }
                });
    };
});
</aui:script>
<aui:form name="saveSalaryPaymentDetails" id="saveSalaryPaymentDetails"
	method="post" action="<%=updateEmpSalaryDetails %>">
	<aui:input name="empSalId" value="<%=employeeId %>" type="hidden"></aui:input>
	<div id="salaryComponents" class="panel">
		<div class="panel-heading">
			<h3>Salary-Payment Details</h3>
		</div>
		<div class="panel-body">
			<div class="row-fluid">
				<div class="span10">
					<aui:select name="emp_paygrade" label="Pay Grade"
						onChange="javascript:dropdowns(this.value);">
						<%
							List<PayGrade> payGrades = PayGradeLocalServiceUtil
											.getPayGrades(-1, -1);
									Iterator<PayGrade> payGrade = payGrades.iterator();
									while (payGrade.hasNext()) {
										PayGrade payGrade9 = payGrade.next();
						%>
						<aui:option value="<%=payGrade9.getPayGradeId()%>"
							label="<%=payGrade9.getPayGradeName()%>">
						</aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:select name="emp_paygrade_currency" label="Paygrade Currency">
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10">
					<aui:input name="sal_comments"  label="comments" type="textarea"></aui:input>
				</div>
			</div>
		</div>
	</div>
	<div id="empEarnings" class="panel">
		<div class="panel-heading">
			<h3>All Earnings</h3>
		</div>
		<div class="panel-body">
			<div class="row-fluid">
				<div class="span1">
					<aui:input name="check_annual_pay" type="checkbox" label=""></aui:input>
				</div>
				<div class="span6">
					<aui:input name="annual_basic_pay" label="Annual Basic Payment"></aui:input>
				</div>
				<div class="span5">
					<aui:input name="basic_pay_date" label="Effective Date"
					cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span1">
					<aui:input name="check_car_alwnce" type="checkbox" label=""></aui:input>
				</div>
				<div class="span6">
					<aui:input name="car_allowance" label="Car Allowance"></aui:input>
				</div>
				<div class="span5">
					<aui:input name="car_pay_date" label="Effective Date"
					cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span1">
					<aui:input name="check_living_alwnce" label="" type="checkbox"></aui:input>
				</div>
				<div class="span6">
					<aui:input name="living_allowance" label="Cost of Living Allowance"></aui:input>
				</div>
				<div class="span5">
					<aui:input name="cost_living_date" label="Effective Date"
					cssClass="dateEmployee"></aui:input>
				</div>
			</div>
		</div>
	</div>
	<div id="empDeductions" class="panel">
		<div class="panel-heading">
			<h3>All Deductions</h3>
		</div>
		<div class="panel-body">
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="pension_fund" label="Pension Fund"></aui:input>
				</div>
				<div class="span6">
					<aui:input name="pension_date" label="Effective Date"
					cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="epf_percentage" label="EPF (Percentage)"></aui:input>
				</div>
				<div class="span6">
					<aui:input name="epf_date" label="Effective Date"
					cssClass="dateEmployee"></aui:input>
				</div>
			</div>
		</div>
	</div>
	<div id="empSalSummary" class="panel">
		<div class="panel-heading">
			<h3>Salary Summary</h3>
		</div>
		<div class="panel-body">
			<div class="row-fluid">
				<div class="span6">
					<label>Total Deductions :</label>
				</div>
				<div class="span6"></div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<label>Total Payable :</label>
				</div>
				<div class="span6"></div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<label> Cost to the Company :</label>
				</div>
			</div>
			<aui:button type="submit" value="Save" id="submitSalaryDetails"></aui:button>
		</div>
	</div>
</aui:form>
