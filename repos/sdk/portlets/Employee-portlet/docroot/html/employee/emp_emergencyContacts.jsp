<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="updateContactDetails"
	var="updateContactDetails"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<aui:script use="aui-base,aui-node,aui-io-request">
var A=new AUI();
A.ready(function()
  {
  A.one('#emergencyContactAdd').hide();
  });
   var addButton=A.one('#<portlet:namespace />emgContactAdd');
   addButton.on('click',
   function()
   {
   alert("adding contact details");
   A.one('#assignedEmergencyContactsAddDelete').hide();
   A.one('#emergencyContactAdd').show();
   A.all('input[type=text]').set('disabled',false);
   A.all('input[type=select]').set('disabled',false);
   A.all('input[type=radio]').set('disabled',false);
   });
   Liferay.provide(
     window,'submitForm',
   function() {
   var A = AUI();
   A.io.request('<%=updateContactDetails%>',{
   method: 'POST',
   form: { id: '<portlet:namespace />addEmergencyContact' },
   on: {
       success: function(){
       A.one('#emergencyContactAdd').hide();
       A.one('#assignedEmergencyContactsAddDelete').show();
       }
       }
    });
  });
</aui:script>
<%
	String empId = (String) request.getSession(false).getAttribute(
			"empId");
	String emgName, emgRelation, homeTelephone, workTelephone, emgMobile;
	long employeeId = Long.parseLong(empId);
	DynamicQuery emergencyContactsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpEmergencyContact.class,
					PortletClassLoaderUtil.getClassLoader());
	emergencyContactsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpEmergencyContact> emergencyDetails = EmpPersonalDetailsLocalServiceUtil
			.dynamicQuery(emergencyContactsDynamicQuery);
	EmpEmergencyContact empEmergencyContact = null;
%>
<div id="assignedEmergencyContactsAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Assigned Emergency Contacts</h3>
	</div>
	<div class="panel-body">
		<aui:button id="emgContactAdd" name="emgContactAdd" value="Add"></aui:button>
		<aui:button id="emgContactDelete" value="Delete"
			name="emgContactDelete"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for Emergency Contaccts"
			deltaConfigurable="true">
			<liferay-ui:search-container-results>
				<%
					List<EmpEmergencyContact> emergencyContactDetails = emergencyDetails;
							results = emergencyContactDetails;
							total = emergencyContactDetails.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpEmergencyContact"
				modelVar="id">
				<liferay-ui:search-container-column-text name="Name" property="name" />
				<liferay-ui:search-container-column-text name="Relation"
					property="relationship" />
				<liferay-ui:search-container-column-text name="Home Telephone"
					property="homeTelephone" />
				<liferay-ui:search-container-column-text name="Mobile"
					property="mobile" />
				<liferay-ui:search-container-column-text name="Work Telephone"
					property="workTelephone" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="emergencyContactAdd" class="panel">
	<div class="panel-heading">
		<h3>Add Emergency Contact</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmergencyContact" id="addEmergencyContact"
			action="<%=updateContactDetails%>" method="post">
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="emg_name" label="Name" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="emg_relationship" label="Relationship"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="emg_hm_telephone" label="Home Telephone"
						inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="emg_mobile" label="Mobile" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="emg_work_telephone" label="Work Telephone"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitEmgDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>