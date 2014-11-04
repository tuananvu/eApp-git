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
Map empId = (Map) request.getSession(false).getAttribute(
		"empId");
long employeeId = (Long)empId.get("empId");
String jsp=(String)empId.get("jsp");
long fileEntryId=(Long)empId.get("fileId");
	String firstName, middleName, lastName, empNo, otherId, licenseNumber,  gender, nationality, maritslStatus;
	Long personalDetailsId;
	Date dateOfB,licenseExpDate;
	//Date k = new Date();
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
		licenseExpDate = empPersonalDetails.getLicenseExpDate()!= null ? empPersonalDetails.getLicenseExpDate() : new Date();
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
		dateOfB = empPersonalDetails.getDateOfBirth()!= null ? empPersonalDetails.getDateOfBirth() :new Date() ;
	} else {
		personalDetailsId=0l;
		firstName = "";
		middleName = "";
		lastName = "";
		empNo = "";
		otherId = "";
		licenseNumber = "";
		licenseExpDate = new Date();
		gender = "";
		nationality = "";
		maritslStatus = "";
		dateOfB = new Date();
	}
%>
<div id="search_form" class="panel">
	<div class="panel-heading">
		<h3><liferay-ui:message key="01_emp-personal-details"/></h3>
	</div>
	<div class="panel-body">
		<aui:form name="empPersonalDetailsSave" id="empPersonalDetailsSave"
			method="post" action="<%=updateEmpPersonalDetails %>" >
			<aui:input name="personalDetailsId" type="hidden"
				value="<%=personalDetailsId %>"></aui:input>
				<aui:input name="perEmpId" type="hidden"
				value="<%=employeeId%>"></aui:input>
				<aui:input name="fileIdemp" type="hidden"
				value="<%=fileEntryId%>"></aui:input>
						<div class="row-fluid">
				<div class="span8">
					<aui:input name="firstName" label="01_firstName"
						showRequiredLabel="false" disabled="true" value="<%=firstName%>">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:input name="middleName" label="01_middleName"
						showRequiredLabel="false" disabled="true" value="<%=middleName%>"></aui:input>
				</div>
				</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:input name="lastName" label="01_lastName"
						showRequiredLabel="false" disabled="true" value="<%=lastName%>">
						<aui:validator name="required"></aui:validator>
					</aui:input>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="employee_no" label="01_emp-no" disabled="true"
						inlineLabel="left" value="<%=empNo%>"></aui:input>
				</div>
				</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:input name="other_id" label="01_other-id" inlineLabel="left"
						disabled="true" value="<%=otherId%>">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="driver_license_no" label="01_driver-license-no"
						inlineLabel="left" disabled="true" value="<%=licenseNumber%>"></aui:input>
				</div>
				</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:input name="expiry_date" label="01_expiry-date"
						inlineLabel="left" disabled="true" value='<%=licenseExpDate%>'
						cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span7">
					<div class="span3">
						<label><liferay-ui:message key="01_gender"/></label>
					</div>
					<div class="span2">
						<aui:input inlineLabel="right" name="gender" type="radio"
							value="1" label="01_male" disabled="true" />
					</div>
					<div class="span2">
						<aui:input checked="<%=true%>" inlineLabel="right" name="gender"
							type="radio" value="2" label="01_female" disabled="true" />
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="marital_status" label="01_marital-status"
						inlineLabel="left" disabled="true">
						<aui:option selected="selected" value="Select" label="01_select"></aui:option>
						<aui:option value="single" label="01_single"></aui:option>
						<aui:option value="married" label="01_married"></aui:option>
						<aui:option value="other" label="01_other"></aui:option>
					</aui:select>
				</div>
					</div>
				<div class="row-fluid">
				<div class="span8">
					<aui:select name="emp_nationality" label="01_nationality"
						disabled="true">
						<aui:option value="-1">--Select--</aui:option>
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
				<aui:input name="date_of_birth" label="01_date-of-birth" inlineLabel="left" cssClass="dateEmployee"
				 value='<%=dateOfB %>'> </aui:input>
				</div>
			</div>
			<aui:button id="editPersonalDetails" name="editPersonalDetails"
				value="Edit" cssClass="button btn-success"></aui:button>
			<aui:button id="savePersonalDetails" name="savePersonalDetails"
				value="Save" type="submit" cssClass="button btn-primary"></aui:button>
		</aui:form>
	</div>
</div>