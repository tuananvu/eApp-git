<%@page import="java.util.Date"%>
<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL var="updateEmpPersonalDetails"
	name="updateEmpPersonalDetails" />
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
{
A.one('#<portlet:namespace />savePersonalDetails').hide();
});
	var node=A.one('#<portlet:namespace />editPersonalDetails');
	node.on('click',function()
	{
	A.one('#<portlet:namespace />editPersonalDetails').hide();
	A.one('#<portlet:namespace />savePersonalDetails').show();
	A.all('input[type=text]').set('disabled',false);
	A.all('select').set('disabled',false);
	A.all('input[type=radio]').set('disabled',false);
	});
</aui:script>
<%
	/* String empId = (String) request.getSession(false).getAttribute(
			"empId"); */
Map empId = (Map) request.getSession(false).getAttribute(
		"empId");
long employeeId = (Long)empId.get("empId");
String jsp=(String)empId.get("jsp");
	String firstName, middleName, lastName, empNo, otherId, licenseNumber, licenseExpDate, gender, nationality, maritslStatus;
	Long personalDetailsId;
	Date dateOfB;
	Date k = new Date();
	//long employeeId = Long.parseLong(empId);
	DynamicQuery personalDetailsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpPersonalDetails.class,
					PortletClassLoaderUtil.getClassLoader());
	personalDetailsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpPersonalDetails> l = EmpPersonalDetailsLocalServiceUtil
			.dynamicQuery(personalDetailsDynamicQuery);
	if (l.size() != 0) {
		EmpPersonalDetails empPersonalDetails = l.get(0);
		personalDetailsId=empPersonalDetails.getEmpPersonalDetailsId();
		firstName = empPersonalDetails.getFirstName();
		middleName = empPersonalDetails.getMiddleName() != null ? empPersonalDetails
				.getMiddleName() : "";
		lastName = empPersonalDetails.getLastName();
		empNo = empPersonalDetails.getEmployeeNo() != null ? empPersonalDetails
				.getEmployeeNo() : "";
		otherId = empPersonalDetails.getOtherId() != null ? empPersonalDetails
				.getOtherId() : "";
		licenseNumber = empPersonalDetails.getLicenseNo() != null ? empPersonalDetails
				.getLicenseNo() : "";
		licenseExpDate = empPersonalDetails.getLicenseExpDate() != null ? empPersonalDetails
				.getLicenseExpDate().toString() : "";
		gender = String.valueOf(empPersonalDetails.getGender()) != null ? String
				.valueOf(empPersonalDetails.getGender()) : "";
		Nationality empNationality2 = null;
		if ((Long) empPersonalDetails.getNationalityId() != null) {
			DynamicQuery nationalityDynamicQuery = DynamicQueryFactoryUtil
					.forClass(Nationality.class,
							PortletClassLoaderUtil.getClassLoader());
			nationalityDynamicQuery.add(PropertyFactoryUtil.forName(
					"nationalityId").eq(
					empPersonalDetails.getNationalityId()));
			List<Nationality> nationalities = NationalityLocalServiceUtil
					.dynamicQuery(nationalityDynamicQuery);
			if (nationalities.size() != 0) {
				empNationality2 = nationalities.get(0);
				nationality = empNationality2.getName() != null ? empNationality2
						.getName() : "";
			}
		}
		maritslStatus = String.valueOf(empPersonalDetails
				.getMaritalStatus()) != null ? String
				.valueOf(empPersonalDetails.getMaritalStatus()) : "";
		dateOfB = empPersonalDetails.getDateOfBirth() != null ? empPersonalDetails
				.getDateOfBirth() : k;
	} else {
		personalDetailsId=0l;
		firstName = "";
		middleName = "";
		lastName = "";
		empNo = "";
		otherId = "";
		licenseNumber = "";
		licenseExpDate = "";
		gender = "";
		nationality = "";
		maritslStatus = "";
		dateOfB = k;
	}
%>
<div id="search_form" class="panel">
	<div class="panel-heading">
		<h3>Personal Details</h3>
	</div>
	<div class="panel-body">
		<aui:form name="empPersonalDetailsSave" id="empPersonalDetailsSave"
			method="post" action="<%=updateEmpPersonalDetails %>" >
			<aui:input name="personalDetailsId" type="hidden"
				value="<%=personalDetailsId %>"></aui:input>
				<aui:input name="perEmpId" type="hidden"
				value="<%=employeeId%>"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<label>Full Name</label>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="firstName" label="First Name"
						showRequiredLabel="false" disabled="true" value="<%=firstName%>">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:input name="middleName" label="Middle Name"
						showRequiredLabel="false" disabled="true" value="<%=middleName%>"></aui:input>
				</div>
				</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:input name="lastName" label="Last Name"
						showRequiredLabel="false" disabled="true" value="<%=lastName%>">
						<aui:validator name="required"></aui:validator>
					</aui:input>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="employee_no" label="EmployeeNo" disabled="true"
						inlineLabel="left" value="<%=empNo%>"></aui:input>
				</div>
				</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:input name="other_id" label="Other Id" inlineLabel="left"
						disabled="true" value="<%=otherId%>">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="driver_license_no" label="Driver License No"
						inlineLabel="left" disabled="true" value="<%=licenseNumber%>"></aui:input>
				</div>
				</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:input name="expiry_date" label="Expiry Date"
						inlineLabel="left" disabled="true" value="<%=licenseExpDate%>"
						class="dateTrigger"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span7">
					<div class="span3">
						<label>Gender</label>
					</div>
					<div class="span2">
						<aui:input inlineLabel="right" name="gender" type="radio"
							value="1" label="male" disabled="true" />
					</div>
					<div class="span2">
						<aui:input checked="<%=true%>" inlineLabel="right" name="gender"
							type="radio" value="2" label="female" disabled="true" />
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="marital_status" label="Marital Status"
						inlineLabel="left" disabled="true">
						<aui:option selected="selected" value="Select" label="select"></aui:option>
						<aui:option value="single" label="Single"></aui:option>
						<aui:option value="married" label="Married"></aui:option>
						<aui:option value="other" label="Other"></aui:option>
					</aui:select>
				</div>
					</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:select name="emp_nationality" label="Nationality"
						disabled="true">
						<%
							List l2 = NationalityLocalServiceUtil.getNationalities(-1,
											-1);
									Iterator nationalities = l2.iterator();
									while (nationalities.hasNext()) {
										Nationality nationalities2 = (Nationality) nationalities
												.next();
						%>
						<aui:option value="<%=nationalities2.getName()%>"><%=nationalities2.getName()%></aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
				</div>
				<div class="row-fluid">
				<div class="span8">
				<aui:input name="date_of_birth" label="Date of Birth" inlineLabel="left" value="<%=k %>"> </aui:input>
				</div>
			</div>
			<aui:button id="editPersonalDetails" name="editPersonalDetails"
				value="Edit" cssClass="button btn-success"></aui:button>
			<aui:button id="savePersonalDetails" name="savePersonalDetails"
				value="Save" type="submit" cssClass="button btn-primary"></aui:button>
		</aui:form>
	</div>
</div>