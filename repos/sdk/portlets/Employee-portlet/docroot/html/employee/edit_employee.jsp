<%@ include file="/html/employee/init.jsp"%>
<%
Map empId = (Map) request.getSession(false).getAttribute(
		"empId");
long employeeId = (Long)empId.get("empId");
String jsp=(String)empId.get("jsp");
	DynamicQuery personalDetailsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpPersonalDetails.class,
					PortletClassLoaderUtil.getClassLoader());
	personalDetailsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpPersonalDetails> l = EmpPersonalDetailsLocalServiceUtil
			.dynamicQuery(personalDetailsDynamicQuery);
	EmpPersonalDetails empPersonalDetails=null;
	if(l.size()!=0)
	{
	empPersonalDetails = l.get(0);
	}
%>
<aui:script>
YUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#employeeDetails',
        stacked:true
      }
    ).render();
  }
);
</aui:script>
<aui:script use="aui-base,aui-date-picker,aui-node">
var A=new AUI();
AUI().use(
  'aui-datepicker',
  function(A) {
    new A.DatePicker(
      {
        trigger: '.dateEmployee',
        popover: {
          zIndex: 1
        },
        on: {
          selectionChange: function(event) {
            console.log(event.newSelection)
          }
        }
      }
    );
  }
);
</aui:script>
<div id="employeeDetails">
	<c:choose>
		<c:when test='<%= jsp.equals("jsp0") || jsp.equals("jsp1") %>'>
	<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li class="active" ><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2" >Contact Details</a></li>
		<li><a href="#tab-3" >Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li><a href="#tab-7">Qualifications</a></li>
		<li><a href="#tab-8">Memberships</a></li>
		<li><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		<c:when test='<%=jsp.equals("jsp2") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li class="active" ><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li><a href="#tab-7">Qualifications</a></li>
		<li><a href="#tab-8">Memberships</a></li>
		<li><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		<c:when test='<%=jsp.equals("jsp3") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li class="active"><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li><a href="#tab-7">Qualifications</a></li>
		<li><a href="#tab-8">Memberships</a></li>
		<li><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		<c:when test='<%=jsp.equals("jsp4") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li class="active"><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li><a href="#tab-7">Qualifications</a></li>
		<li><a href="#tab-8">Memberships</a></li>
		<li><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
				<c:when test='<%=jsp.equals("jsp5") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li class="active"><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li><a href="#tab-7">Qualifications</a></li>
		<li><a href="#tab-8">Memberships</a></li>
		<li><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
			<c:when test='<%=jsp.equals("jsp6") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li class="active"><a href="#tab-6">Report-to</a></li>
		<li><a href="#tab-7">Qualifications</a></li>
		<li><a href="#tab-8">Memberships</a></li>
		<li><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		<c:when test='<%=jsp.equals("jsp7") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li class="active" ><a href="#tab-7">Qualifications</a></li>
		<li><a href="#tab-8">Memberships</a></li>
		<li><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		<c:when test='<%=jsp.equals("jsp8") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li ><a href="#tab-7">Qualifications</a></li>
		<li class="active" ><a href="#tab-8">Memberships</a></li>
		<li><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		<c:when test='<%=jsp.equals("jsp9") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li ><a href="#tab-7">Qualifications</a></li>
		<li ><a href="#tab-8">Memberships</a></li>
		<li class="active"><a href="#tab-9" >Job History</a></li>
		<li><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		<c:when test='<%=jsp.equals("jsp10") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li ><a href="#tab-7">Qualifications</a></li>
		<li ><a href="#tab-8">Memberships</a></li>
		<li ><a href="#tab-9" >Job History</a></li>
		<li class="active"><a href="#tab-10">Salary History</a></li>
		<li><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		<c:when test='<%=jsp.equals("jsp11") %>' >
		<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body"></div>
		</div>
		<li><a href="#tab-1" >Personal Details</a></li>
		<li><a href="#tab-2">Contact Details</a></li>
		<li><a href="#tab-3">Emergency Contacts</a></li>
		<li><a href="#tab-4">Dependents</a></li>
		<li><a href="#tab-5">Immigration</a></li>
		<li><a href="#tab-6">Report-to</a></li>
		<li ><a href="#tab-7">Qualifications</a></li>
		<li ><a href="#tab-8">Memberships</a></li>
		<li ><a href="#tab-9" >Job History</a></li>
		<li ><a href="#tab-10">Salary History</a></li>
		<li class="active"><a href="#tab-11">Direct Deposit</a></li>
		</ul>
		</c:when>
		</c:choose>
	<div class="tab-content">
		<div id="tab-1" class="tab-pane">
			<jsp:include page="/html/employee/emp_personalDetails.jsp" />
		</div>
		<div id="tab-2" class="tab-pane">
			<jsp:include page="/html/employee/emp_contactDetails.jsp" />
		</div>
		<div id="tab-3" class="tab-pane">
			<jsp:include page="/html/employee/emp_emergencyContacts.jsp" />
		</div>
		<div id="tab-4" class="tab-pane">
			<jsp:include page="/html/employee/emp_dependents.jsp" />
		</div>
		<div id="tab-5" class="tab-pane">
			<jsp:include page="/html/employee/emp_immigration.jsp" />
		</div>
		<div id="tab-6" class="tab-pane">
			<jsp:include page="/html/employee/emp_reportTo.jsp" />
		</div>
		<div id="tab-7" class="tab-pane">
			<jsp:include page="/html/employee/emp_qualifications.jsp" />
		</div>
		<div id="tab-8" class="tab-pane">
			<jsp:include page="/html/employee/emp_memberships.jsp" />
		</div>
		<div id="tab-9" class="tab-pane">
			<jsp:include page="/html/employee/emp_jobHistory.jsp" />
		</div>
		<div id="tab-10" class="tab-pane">
			<jsp:include page="/html/employee/emp_salaryHistory.jsp" />
		</div>
		<div id="tab-11" class="tab-pane">
			<jsp:include page="/html/employee/emp_directDeposits.jsp" />
		</div>
	</div>
</div>
