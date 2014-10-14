<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateEmpContactDetails" var="updateEmpContactDetails"  
windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>" >
</portlet:actionURL>
<aui:script use="aui-io-request,aui-node">
var A=new AUI();
A.ready(function()
{
A.one('#<portlet:namespace />saveContactDetails').hide();
A.all('input[type=text]').set('disabled',true);
	A.all('input[type=select]').set('disabled',true);
	A.all('input[type=radio]').set('disabled',true);
});
AUI().use(
    'aui-node',
    function(A) { 
	var node=A.one('#<portlet:namespace />editContactDetails');
	node.on('click',function()
	{
	A.one('#<portlet:namespace />editContactDetails').hide();
	alert(A.all('input[type=text]'));
	A.all('input[type=text]').set('disabled',false);
	A.all('input[type=select]').set('disabled',false);
	A.all('input[type=radio]').set('disabled',false);
	A.one('#<portlet:namespace />saveContactDetails').show();
	});
});

 Liferay.provide(
     window,'submitForm',
   function() {
   var A = AUI();
   A.io.request('<%=updateEmpContactDetails%>',{
   method: 'POST',
   form: { id: '<portlet:namespace />empConatactDetailsEdit' },
   on: {
       success: function(){
       A.one('#<portlet:namespace/>saveContactDetails').hide();
       	 A.one('#<portlet:namespace/>editContactDetails').show();
       	 A.all('input[type=text]').set('disabled',true);
	    A.all('select').set('disabled',true);
	    A.all('input[type=radio]').set('disabled',true);
       }
       }
    });
  });
	
</aui:script>
<%
	String empId = (String) request.getSession(false).getAttribute(
			"empId");
	long employeeId = Long.parseLong(empId);
%>
<portlet:actionURL var="editEmpContactDetailsURL"
	name="updateEmpContactDetails">
	<portlet:param name="empId" value="<%=empId%>" />
	<portlet:param name="redirectTo"
		value="<%=PortalUtil.getCurrentURL(request)%>" />
</portlet:actionURL>
<%
	String adressStreet1,addressStreet2,city,state,zip,country,homeTel,workTel,mobile,workEmail,otherEmail;
    Long contactDetailsId;
	DynamicQuery contactDetailsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpContactDetails.class,
					PortletClassLoaderUtil.getClassLoader());
	contactDetailsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpContactDetails> contactDetailsList = EmpContactDetailsLocalServiceUtil
			.dynamicQuery(contactDetailsDynamicQuery);
	if (contactDetailsList.size() != 0) {
		EmpContactDetails empContactDetails = contactDetailsList.get(0);
		contactDetailsId=empContactDetails.getEmpContactDetailsId();
		addressStreet2=empContactDetails.getAddressStreet2()!=null?
				empContactDetails.getAddressStreet2():"";
		adressStreet1=empContactDetails.getAddressStreet1()!=null?
				empContactDetails.getAddressStreet1():"";
		city=empContactDetails.getCity()!=null?empContactDetails.getCity():"";
		state=empContactDetails.getState()!=null?empContactDetails.getState():"";
		zip=empContactDetails.getPostalCode()!=null?empContactDetails.getPostalCode():"";
		country=empContactDetails.getCountry()!=null?empContactDetails.getCountry():"";
		homeTel=empContactDetails.getHomeTelephone()!=null?empContactDetails.getHomeTelephone():"";
		workTel=empContactDetails.getWorkTelephone()!=null?empContactDetails.getWorkTelephone():"";
		workEmail=empContactDetails.getWorkEmail()!=null?empContactDetails.getWorkEmail():"";
		mobile=empContactDetails.getMobile()!=null?empContactDetails.getMobile():"";
		otherEmail=empContactDetails.getOtherEmail()!=null?empContactDetails.getOtherEmail():"";
	}
	else
	{
		adressStreet1="";addressStreet2="";city="";
		state="";zip="";country="";homeTel="";workTel="";
		mobile="";workEmail="";otherEmail="";
	}
%>

<div id="emp_contact_details" class="panel">
	<div class="panel-heading">
		<h3>Contact Details</h3>
	</div>
	<div class="panel-body">
		<aui:form name="empConatactDetailsEdit"
			id="empConatactDetailsEdit"
			action="<%=editEmpContactDetailsURL%>">
			<aui:input name="empId" type="hidden" value="<%=empId %>"></aui:input>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="address_street1" label="Address Street 1"
						inlineLabel="left"
						value="<%=adressStreet1%>"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="address_street2" label="Address Street 2"
						inlineLabel="left" value="<%=addressStreet2 %>"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="city" label="City" inlineLabel="left" value="<%=city %>"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="state" label=" State/Province" inlineLabel="left" value="<%=state %>"
					></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="zip" label="Postal Code" value="<%= zip%>" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="country" label="Country" inlineLabel="left" value="<%=country %>">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="home_telephone" label="Home Telephone"
						inlineLabel="left" value="<%=homeTel %>"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="work_telephone" label="Work Telephone"
						inlineLabel="left" value="<%=workTel %>"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="mobile" label=" Mobile" inlineLabel="left"
					value="<%=mobile %>"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="work_email" label="Work Email" inlineLabel="left"
					value="<%=workEmail %>"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<aui:input name="other_email" label="Other Email"
						inlineLabel="left" value="<%=otherEmail %>"></aui:input>
				</div>
			</div>
			<aui:button name="editContactDetails" id="editContactDetails"
				value="Edit" />
			<aui:button type="submit" id="saveContactDetails" name="saveContactDetails" value="Save" />
		</aui:form>

	</div>
</div>
