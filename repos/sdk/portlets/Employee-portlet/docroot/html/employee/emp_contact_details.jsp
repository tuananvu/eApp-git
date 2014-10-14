<%-- <%@ include file="/html/employee/init.jsp"%>
<%
	String empId = (String) request.getSession(false).getAttribute(
			"empId");
	long employeeId = Long.parseLong(empId);
	DynamicQuery personalDetailsDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpPersonalDetails.class,
					PortletClassLoaderUtil.getClassLoader());
	personalDetailsDynamicQuery.add(PropertyFactoryUtil.forName(
			"employeeId").eq(employeeId));
	List<EmpPersonalDetails> l = EmpPersonalDetailsLocalServiceUtil
			.dynamicQuery(personalDetailsDynamicQuery);
	EmpPersonalDetails empPersonalDetails = l.get(0);
%>
<aui:script>
YUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#employeeContactDetails',
        stacked:true
      }
    ).render();
  }
);
</aui:script>
<div class="editEmp">
	<div id="employeeContactDetails">
		<ul class="span3 ">
			<div id="employeeImage" class="panel">
				<div class="panel-heading">
					<h3><%=empPersonalDetails.getFirstName()%></h3>
				</div>
				<div class="panel-body"></div>
			</div>
			<li><a href="#tab-4">Personal Details</a></li>
			<li  class="active"><a href="#tab-5">Contact Details</a></li>
		</ul>
		<div class="tab-content">
			<div id="tab-4" class="tab-pane">
				<p><jsp:include page="/html/employee/emp_personalDetails.jsp" /></p>
			</div>
			<div id="tab-5" class="tab-pane">
				<p><jsp:include page="/html/employee/emp_contactDetails.jsp" /></p>
			</div>
		</div>
	</div>
</div>
 --%>