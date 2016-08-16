<%@ include file="/html/employee/init.jsp"%>
<%
Map empId = (Map) request.getSession(false).getAttribute(
		"empId");
long employeeId = (Long)empId.get("empId");
String jsp=(String)empId.get("jsp");
long fileEntryId=(Long)empId.get("fileId");
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
<portlet:resourceURL var="displayImage" id="displayImage">
<portlet:param name="imageId" value="<%=String.valueOf(fileEntryId) %>"></portlet:param>
</portlet:resourceURL>
<portlet:renderURL var="updateImage" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcPath" value="/html/employee/updateImage.jsp" />
	<portlet:param name="imageId2" value="<%=String.valueOf(fileEntryId) %>"/>
	</portlet:renderURL>
<aui:script>
function updateImage()
{
  AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',
             'aui-dialog-iframe-deprecated',
    function(A) {
	var popUpWindow=Liferay.Util.Window.getWindow(
	{
		dialog: {
			destroyOnClose:true,
			centered: true,
			constrain2view: true,
			modal: true,
			resizable: false,
			height:300,
			width: 700
		   }
		}).plug(A.Plugin.DialogIframe,
		   {
				autoLoad: true,
				iframeCssClass: 'dialog-iframe',
				uri:'<%=updateImage.toString()%>'
			}).render();
			popUpWindow.show();
			popUpWindow.titleNode.html("Select an Image to Update");
			popUpWindow.io.start();
     });       
}    
 </aui:script>

<aui:script>
YUI().use(
  'aui-tabview',
  function(Y) {
    var tabView=new Y.TabView(
      {
        srcNode: '#employeeDetails',
        stacked:true
      }
    ).render();
    tabView.after ('tab:selectedChange', function (e) {
    A.all('#<portlet:namespace/>empContactDetailsEdit input[type=text]').set('disabled',true);
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=select]').set('disabled',true);
	A.all('#<portlet:namespace/>empContactDetailsEdit input[type=radio]').set('disabled',true);
    A.all('#<portlet:namespace/>empPersonalDetailsSave input[type=text]').set('disabled',true);
	A.all('#<portlet:namespace/>empPersonalDetailsSave select').set('disabled',true);
	A.all('#<portlet:namespace/>empPersonalDetailsSave input[type=radio]').set('disabled',true);
	A.one('#<portlet:namespace />editContactDetails').show();
	A.one('#<portlet:namespace />saveContactDetails').hide();
	A.one('#<portlet:namespace />editPersonalDetails').show();
	A.one('#<portlet:namespace />savePersonalDetails').hide();
    });
  }
);
</aui:script>
<aui:script use="aui-base,aui-date-picker,aui-node,aui-tabview">
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
<ul class="span3" id="test">
		<div id="employeeImage" class="panel">
			<div class="panel-heading">
				<h3><%=empPersonalDetails.getFirstName()%></h3>
			</div>
			<div class="panel-body">
			 <img alt="upload an Image" src="<%=displayImage%>" >
			 <a href="#" onclick="updateImage()">Change Photo</a>
			</div>
		</div>
	<c:choose>
		<c:when test='<%= jsp.equals("jsp0") || jsp.equals("jsp1") %>'>
		<li class="active" ><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2" ><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp2") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li class="active" ><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp3") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp4") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp5") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp6") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp7") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp8") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp9") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp10") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp11") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		<c:when test='<%=jsp.equals("jsp12") %>' >
		<li><a href="#tab-1" ><liferay-ui:message key="01_emp-personal-details"></liferay-ui:message></a></li>
		<li><a href="#tab-2"><liferay-ui:message key="01_emp-contact-details"></liferay-ui:message></a></li>
		<li><a href="#tab-3" ><liferay-ui:message key="01_emp-emergency-contacts"></liferay-ui:message></a></li>
		<li><a href="#tab-4"><liferay-ui:message key="01_emp-dependents"></liferay-ui:message></a></li>
		<li><a href="#tab-5"><liferay-ui:message key="01_emp-immigration"></liferay-ui:message></a></li>
		<li><a href="#tab-6"><liferay-ui:message key="01_emp-report-to"></liferay-ui:message></a></li>
		<li><a href="#tab-7"><liferay-ui:message key="01_emp-qualifications"></liferay-ui:message></a></li>
		<li><a href="#tab-8"><liferay-ui:message key="01_emp-membership"></liferay-ui:message></a></li>
		<li><a href="#tab-9" ><liferay-ui:message key="01_emp-job-history"></liferay-ui:message></a></li>
		<li><a href="#tab-10"><liferay-ui:message key="01_emp-salary-history"></liferay-ui:message></a></li>
		<li><a href="#tab-11"><liferay-ui:message key="01_emp-direct-deposits"></liferay-ui:message></a></li>
		<li class="active"><a href="#tab-12"><liferay-ui:message key="01_add-documents"></liferay-ui:message></a></li>
		</c:when>
		</c:choose>
		</ul>
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
		<div id="tab-12" class="tab-pane">
			<jsp:include page="/html/employee/emp_documents.jsp" />
		</div>
	</div>
</div>
