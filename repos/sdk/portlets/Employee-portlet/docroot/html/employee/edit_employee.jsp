<%@ include file="/html/employee/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>employee</title>
<portlet:actionURL var="saveemployee" name="saveEmployee">
</portlet:actionURL>
<portlet:resourceURL var="deleteemployee" id="deleteEmployee" />
<portlet:renderURL var="editview">
	<portlet:param name="mvcPath" value="/html/employee/edit_employee.jsp" />
</portlet:renderURL>
<style type="text/css">
.table-first-header {
	width: 10%;
}

.table-last-header {
	width: 15%;
}
</style>
<aui:script>
AUI().ready('event', 'node', function(A){

  A.one('#editEmployeePersonalDetailsDiv').hide();
 });

 
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#editcancel');
    node.on(
      'click',
      function() {
      alert("edit cancel");
        <%-- window.location='<%=editview%>'; --%>
      }
    );																																
  }
);
 
 
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#Edit');
    node.on(
      'click',
      function() {
        A.one('#viewEmployeePersonalDetailsDiv').hide();
        A.one('#editEmployeePersonalDetailsDiv').show();
      }
    );																																
  }
);

AUI().use(
  'aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: '#<portlet:namespace/>licenseExpiryDate',
        mask: '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
            console.log(event.newSelection);
          }
        }
      }
    );
  }
);

AUI().use(
  'aui-datepicker',
  function(Y) {
    new Y.DatePicker(
      {
        trigger: '#<portlet:namespace />dateOfBirth',
        mask: '%d/%m/%Y',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
            console.log(event.newSelection);
          }
        }
      }
    );
  }
);
</aui:script>

</head>
<body>
    <% com.rknowsys.eapp.hrm.model.Employee employee =  (Employee)portletSession.getAttribute("employee", javax.portlet.PortletSession.APPLICATION_SCOPE);
       System.out.println("Employee retrieved from session = " + employee );
    %>
	<div id="editjobadddelete" class="span12">
		<a href="#" id="add">Add</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#"
			id="delete">Delete</a>
	</div>

	<div id="viewEmployeePersonalDetailsDiv">
		<aui:form name="viewEmployeePersonalDetailsForm" action="<%=saveemployee.toString()%>">
			<div class="span12">
				<div class="span3">
					<label>Full Name</label>
				</div>
				<div class="span3">
					<aui:input name="firstName" type="text" label=""
						value="<%=(employee.getFirstName() != null) ? employee
							.getFirstName() :\"\"%>"
						readonly="readonly">
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="span3">
					<aui:input name="middleName" type="text" label=""
						value="<%=(employee != null) ? employee
							.getMiddleName() :\"\"%>"
						readonly="readonly">
					</aui:input>
				</div>
				<div class="span3">
					<aui:input name="lastName" type="text" label=""
						value="<%=(employee.getLastName() != null) ? employee
							.getLastName() :\"\"%>"
						readonly="readonly">
						<aui:validator name="required" />
					</aui:input>
				</div>
			</div>
			<hr />
			<div class="span12">
				<div class="span3">
					<label>Employee Id</label>
				</div>
				<div class="span3">
					<aui:input name="employeeId" type="text" label=""
						value="<%=employee.getEmployeeId()%>"
						>
					</aui:input>
				</div>
				<div class="span3">
					<label>Other Id</label>
				</div>
				<div class="span3">
					<aui:input name="otherId" type="text" label=""
						value="<%=(employee.getOtherId() != null) ? employee
							.getOtherId() :\"\"%>"
						readonly="readonly">
					</aui:input>
				</div>
			</div>
			<hr />
			<div class="span12">
				<div class="span3">
					<label>Driver's License Number</label>
				</div>
				<div class="span3">
					<aui:input name="licenseNumber" type="text" label=""
						value="<%=(employee.getLicense() != null) ? employee
							.getLicense().getLicenseNumber()
							:\"\"%>"
						readonly="readonly">
					</aui:input>
				</div>
				<div class="span3">
					<label>License Expiry Date</label>
				</div>
				<div class="span3">
					<aui:input name="licenseExpiryDate" type="text" label=""
						value="<%=(employee.getLicense() != null) ? DateUtils
							.format(employee.getLicense()
									.getExpiryDate()) :\"\"%>"
						readonly="readonly">
					</aui:input>
				</div>
			</div>
			<hr />
			<div class="span12">
				<div class="span3">
					<label>Gender</label>
				</div>
				<div class="span3">
					<aui:select type="radio" name="gender" readonly="readonly" label="">
						<aui:option readonly="readonly" value="0"
							selected="<%=(employee.getGender() == 0) ? true
								: false%>">--Select--
					</aui:option>
						<aui:option readonly="readonly" value="1"
							selected="<%=(employee.getGender() == 1) ? true
								: false%>">Male
					</aui:option>
						<aui:option readonly="readonly" value="2"
							selected="<%=(employee.getGender() == 2) ? true
								: false%>">Female
					</aui:option>
					</aui:select>
				</div>
				<div class="span3">
					<label>Marital Status</label>
				</div>
				<div class="span3">
					<aui:select type="select" name="maritalStatus" readonly="readonly" label="">
						<aui:option readonly="readonly" value="0"
							selected="<%=(employee.getMaritalStatus() == 0) ? true
								: false%>">--Select--
					</aui:option>
						<aui:option readonly="readonly" value="1"
							selected="<%=(employee.getMaritalStatus() == 1) ? true
								: false%>">Single
								
					</aui:option>
						<aui:option readonly="readonly" value="2"
							selected="<%=(employee.getMaritalStatus() == 2) ? true
								: false%>">Married
					</aui:option>
						<aui:option readonly="readonly"
							selected="<%=(employee.getMaritalStatus() == 3) ? true
								: false%>">Other
					</aui:option>
					</aui:select>
				</div>
			</div>
			<div class="span12">
				<div class="span3">
					<label>Nationality</label>
				</div>
				<div class="span3">
					<aui:select type="select" name="nationality" readonly="readonly" label="">
						<aui:option
							selected="<%=(employee.getNationality() == null) ? true
								: false%>">--Select--
					</aui:option>
						<%
							String nationality = null;
									if (employee.getNationality() == null)
										nationality = "";
									for (Nationality n : NationalityLocalServiceUtil
											.getNationalities(0, NationalityLocalServiceUtil
													.getNationalitiesCount())) {
						%>
						<aui:option readonly="readonly" 
							selected="<%=(n.getNationalityId() == employee
									.getNationalityId()) ? true
									: false%>"><%=n.getName()%>
						</aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
				<div class="span3">
					<label>Date of Birth</label>
				</div>
				<div class="span3">
					<aui:input name="dateOfBirth" type="text" label=""
						value="<%=DateUtils.format(employee
							.getDateOfBirth())%>"
						readonly="readonly">
					</aui:input>
				</div>
			</div>
			<hr />
			<div class="span12">
				<aui:button  type="button" value="Edit" id ="Edit"></aui:button>
				<aui:button  type="button" value="Cancel" id ="editcancel"></aui:button>
			</div>
		</aui:form>
	</div>
	<div id="editEmployeePersonalDetailsDiv" >
		<aui:form name="editEmployeePersonalDetailsForm" action="<%=saveemployee.toString()%>">
			<div class="span12">
				<div class="span3">
					<label>Full Name</label>
				</div>
				<div class="span3">
					<aui:input name="firstName" type="text" label=""
						value="<%=(employee.getFirstName() != null) ? employee
							.getFirstName() :\"\"%>">
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="span3">
					<aui:input name="middleName" type="text" label=""
						value="<%=(employee != null) ? employee
							.getMiddleName() :\"\"%>">
					</aui:input>
				</div>
				<div class="span3">
					<aui:input name="lastName" type="text" label=""
						value="<%=(employee.getLastName() != null) ? employee
							.getLastName() :\"\"%>">
						<aui:validator name="required" />
					</aui:input>
				</div>
			</div>
			<hr />
			<div class="span12">
				<div class="span3">
					<label>Employee Id</label>
				</div>
				<div class="span3">
					<aui:input name="employeeId" type="text" label=""
						value="<%=employee.getEmployeeId()%>">
					</aui:input>
				</div>
				<div class="span3">
					<label>Other Id</label>
				</div>
				<div class="span3">
					<aui:input name="otherId" type="text" label=""
						value="<%=(employee.getOtherId() != null) ? employee
							.getOtherId() :\"\"%>">
					</aui:input>
				</div>
			</div>
			<hr />
			<div class="span12">
				<div class="span3">
					<label>Driver's License Number</label>
				</div>
				<div class="span3">
					<aui:input name="licenseNumber" type="text" label=""
						value="<%=(employee.getLicense() != null) ? employee
							.getLicense().getLicenseNumber()
							:\"\"%>">
					</aui:input>
				</div>
				<div class="span3">
					<label>License Expiry Date</label>
				</div>
				<div class="span3">
					<aui:input name="licenseExpiryDate" type="text" label=""
						value="<%=(employee.getLicense() != null) ? DateUtils
							.format(employee.getLicense()
									.getExpiryDate()) :\"\"%>">
					</aui:input>
				</div>
			</div>
			<hr />
			<div class="span12">
				<div class="span3">
					<label>Gender</label>
				</div>
				<div class="span3">
					<aui:select type="radio" name="gender" label="">
						<aui:option value="0"
							selected="<%=(employee.getGender() == 0) ? true
								: false%>">--Select--
					</aui:option>
						<aui:option value="1"
							selected="<%=(employee.getGender() == 1) ? true
								: false%>">Male
					</aui:option>
						<aui:option value="2"
							selected="<%=(employee.getGender() == 2) ? true
								: false%>">Female
					</aui:option>
					</aui:select>
				</div>
				<div class="span3">
					<label>Marital Status</label>
				</div>
				<div class="span3">
					<aui:select type="select" name="maritalStatus" label="">
						<aui:option value="0"
							selected="<%=(employee.getMaritalStatus() == 0) ? true
								: false%>">--Select--
					</aui:option>
						<aui:option value="1"
							selected="<%=(employee.getMaritalStatus() == 1) ? true
								: false%>">Single
					</aui:option>
						<aui:option value="2"
							selected="<%=(employee.getMaritalStatus() == 2) ? true
								: false%>">Married
					</aui:option>
						<aui:option
							selected="<%=(employee.getMaritalStatus() == 3) ? true
								: false%>">Other
					</aui:option>
					</aui:select>
				</div>
			</div>
			<div class="span12">
				<div class="span3">
					<label>Nationality</label>
				</div>
				<div class="span3">
					<aui:select type="select" name="nationality" label="">
						<aui:option value="0"
							selected="<%=(employee.getNationality() == null) ? true
								: false%>">--Select--
					</aui:option>
						<%
							String nationality = null;
									if (employee.getNationality() == null)
										nationality = "";
									for (Nationality n : NationalityLocalServiceUtil
											.getNationalities(0, NationalityLocalServiceUtil
													.getNationalitiesCount())) {
						%> 
						<aui:option readonly="readonly" value="<%=n.getNationalityId() %>"
							selected="<%=(n.getNationalityId() == employee
									.getNationalityId()) ? true
									: false%>"><%=n.getName()%>
						</aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
				<div class="span3">
					<label>Date of Birth</label>
				</div>
				<div class="span3">
					<aui:input name="dateOfBirth" type="text" label=""
						value="<%=DateUtils.format(employee.getDateOfBirth())%>">
					</aui:input>
				</div>
			</div>
			<hr />
			<div class="span12">
				<aui:button type="submit" value="Save" name="Save" />
				<aui:button  type="button" value="Cancel" id ="editcancel"></aui:button>
			</div>
		</aui:form>
	</div>
	<div>
		<label style="color: white">.</label>
	</div>
</body>
<%-- <%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/employment/edit_employee.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 
System.out.println("sortByCol == " +sortByCol);
System.out.println("sortByType == " +sortByType);
if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	System.out.println("if block...");
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}
System.out.println("after....");
System.out.println("sortByCol == " +sortByCol);
System.out.println("sortByType == " +sortByType);
%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Employee> searchContainer;
%>
<liferay-ui:search-container orderByCol="<%=sortByCol %>" orderByType="<%=sortByType %>" rowChecker="<%= new RowChecker(renderResponse) %>"  delta="5" emptyResultsMessage="No records is available for Employees."   deltaConfigurable="true"   iteratorURL="<%=iteratorURL%>">
		<liferay-ui:search-container-results>
				
		<%
            List<Employee> employeesList = EmployeeLocalServiceUtil.getEmployees(searchContainer.getStart(), searchContainer.getEnd());
            System.out.println("list size == " + employeesList.size());
            OrderByComparator orderByComparator = CustomComparatorUtil.getEmployeeOrderByComparator(sortByCol, sortByType);         
  
           Collections.sort(employeesList,orderByComparator);
  
          results = employeesList;
          
            System.out.println("results == " +results);
           
     
               total = EmployeeLocalServiceUtil.getEmployeesCount();
               System.out.println("total == " +total);
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Employee" keyProperty="employeeId" modelVar="employeeVar"  rowVar="curRow" escapedModel="<%= true %>">
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="First Name" property="firstName" orderableProperty="firstName"/>
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Middle Name" property="middleName" orderableProperty="middleName"/>
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Last Name" property="lastName" orderableProperty="lastName"/>
	     <liferay-ui:search-container-column-text orderable="<%=true %>" name="Job Title" value="<%=((employeeVar.getJob() != null) && (employeeVar.getJob().getJobTitle() != null)) ? employeeVar.getJob().getJobTitle().getTitle(): \"\" %>" />
	     <liferay-ui:search-container-column-text orderable="false" name="Employment Status" value="<%=( (employeeVar.getJob() != null) && (employeeVar.getJob().getEmploymentStatus() != null)) ? employeeVar.getJob().getEmploymentStatus().getEmploymentstatus() : \"\"  %>" />
		 <liferay-ui:search-container-column-text orderable="false" name="Sub Unit" value="<%= ((employeeVar.getJob() != null) && (employeeVar.getJob().getSubUnit() != null)) ? employeeVar.getJob().getSubUnit().getName() : \"\"%>" />
		 <liferay-ui:search-container-column-text orderable="false" name="Supervisor" value="" />
		 <liferay-ui:search-container-column-jsp name="Edit"  path="/html/employee/edit.jsp"/>
		 
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container> --%>
</html>