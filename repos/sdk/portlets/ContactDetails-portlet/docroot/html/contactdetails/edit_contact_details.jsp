<%@page import="com.rknowsys.eapp.hrm.service.ContactDetailsLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.ContactDetails"%>
<%@page import="com.rknowsys.eapp.hrm.model.Employee"%>
<%@page import="com.rknowsys.eapp.hrm.util.DateUtils"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/html/contactdetails/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Details</title>
<portlet:actionURL var="saveContactDetails" name="saveContactDetails">
</portlet:actionURL>

<%-- 
<portlet:resourceURL var="deleteemergencycontact" id="deleteEmergencyContact"/>
 --%>
 
<portlet:renderURL var="initialView">
	<%-- 	<portlet:param name="mvcPath" value="/html/contactdetails/edit_contact_details.jsp" /> --%>
 </portlet:renderURL>


 <style type="text/css">	
.table-first-header{
width: 10%;
}
.table-last-header{
width: 15%;
}
</style>

<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#edit');
    node.on(
      'click',
      function() {
         A.one('#editContactDetailsReadOnly').hide();
         A.one('#editContactDetailsForm').show();
                     
      }
    );
  }
);

AUI().ready('event', 'node', function(A){

  A.one('#editContactDetailsForm').hide();
 
 });

</aui:script>
</head>

<body>

 <jsp:useBean id="editContactDetails" type="com.rknowsys.eapp.hrm.model.ContactDetails" scope="request" />
 
 <div id="editContactDetailsReadOnly">
 
		<aui:input name="contactDetailsId" type="hidden" value="<%=editContactDetails.getContactDetailsId() %>"/>

		<div class="span12">
			<div class="span2">
				<label>Address Street 1</label>
		</div>
		<div class="span3">		
		 <aui:input name="addressStreet1" type="text" label="" disabled="true" value="<%=editContactDetails.getAddressStreet1() %>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Address Street 2</label>
			</div>
			<div class="span3">		
		 		<aui:input name="addressStreet2" type="text" label="" disabled="true" value="<%=editContactDetails.getAddressStreet2()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>City</label>
		</div>
		<div class="span3">		
		 <aui:input name="city" type="text" label="" disabled="true" value="<%=editContactDetails.getCity()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>State/Province</label>
		</div>
		<div class="span3">		
		 <aui:input name="state" type="text" label="" disabled="true" value="<%=editContactDetails.getState()%>"/>
			</div>
		</div>
		<div class="span12">
			<div class="span2">
				<label>Zip/Postal Code</label>
		</div>
		<div class="span3">		
		 <aui:input name="postalCode" type="text" label="" disabled="true" value="<%=editContactDetails.getPostalCode()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Country</label>
		</div>
		<div class="span3">		
		 <aui:input name="country" type="text" label="" disabled="true" value="<%=editContactDetails.getCountry()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Home Telephone</label>
		</div>
		<div class="span3">		
		 <aui:input name="homeTelephone" type="text" label="" disabled="true" value="<%=editContactDetails.getHomeTelephone()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Mobile</label>
		</div>
		<div class="span3">		
		 <aui:input name="mobile" type="text" label="" disabled="true" value="<%=editContactDetails.getMobile()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Work Telephone</label>
		</div>
		<div class="span3">		
		 <aui:input name="workTelephone" type="text" label="" disabled="true" value="<%=editContactDetails.getWorkTelephone()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Work Email</label>
		</div>
		<div class="span3">		
		 <aui:input name="workEmail" type="text" label="" disabled="true" value="<%=editContactDetails.getWorkEmail()%>"/>
			</div>
		</div>
		<div class="span12">
			<div class="span2">
				<label>Other Email</label>
		</div>
		<div class="span3">		
		 	<aui:input name="otherEmail" type="text" label="" disabled="true" value="<%=editContactDetails.getOtherEmail()%>"/>
		</div>
		</div>

		<div class="span12">
			<aui:button type="button" id="edit" value="Edit" />
		</div>

</div>



<div id="editContactDetailsForm">
  <aui:form name="myForm" action="<%=saveContactDetails.toString()%>">
		<aui:input name="contactDetailsId" type="hidden" value="<%=editContactDetails.getContactDetailsId()%>"/>
		

		<div class="span12">
			<div class="span2">
				<label>Address Street 1</label>
		</div>
		<div class="span3">		
		 <aui:input name="addressStreet1" type="text" label="" value="<%=editContactDetails.getAddressStreet1()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Address Street 2</label>
		</div>
		<div class="span3">		
		 <aui:input name="addressStreet2" type="text" label="" value="<%=editContactDetails.getAddressStreet2()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>City</label>
		</div>
		<div class="span3">		
		 <aui:input name="city" type="text" label="" value="<%=editContactDetails.getCity()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>State/Province</label>
		</div>
		<div class="span3">		
		 <aui:input name="state" type="text" label="" value="<%=editContactDetails.getState()%>"/>
			</div>
		</div>
		<div class="span12">
			<div class="span2">
				<label>Zip/Postal Code</label>
		</div>
		<div class="span3">		
		 <aui:input name="postalCode" type="text" label="" value="<%=editContactDetails.getPostalCode()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Country</label>
		</div>
		<div class="span3">		
		 <aui:input name="country" type="text" label="" value="<%=editContactDetails.getCountry()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Home Telephone</label>
		</div>
		<div class="span3">		
		 <aui:input name="homeTelephone" type="text" label="" value="<%=editContactDetails.getHomeTelephone()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Mobile</label>
		</div>
		<div class="span3">		
		 <aui:input name="mobile" type="text" label="" value="<%=editContactDetails.getMobile()%>"/>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Work Telephone</label>
		</div>
		<div class="span3">		
		 <aui:input name="workTelephone" type="text" label="" value="<%=editContactDetails.getWorkTelephone()%>">
		 </aui:input>
			</div>
		</div>

		<div class="span12">
			<div class="span2">
				<label>Work Email</label>
		</div>
		<div class="span3">		
		 <aui:input name="workEmail" type="text" label="" value="<%=editContactDetails.getWorkEmail()%>">
		 	<aui:validator name="email" />
		 </aui:input>
			</div>
		</div>
		<div class="span12">
			<div class="span2">
				<label>Other Email</label>
		</div>
		<div class="span3">		
		 <aui:input name="otherEmail" type="text" label="" value="<%=editContactDetails.getOtherEmail()%>">
		 	<aui:validator name="email" />
		 </aui:input>
			</div>
		</div>

		<aui:button type="submit" id="save" value="Submit" />
		<%-- <aui:button  type="reset" value="Cancel" id ="cancel"/> --%>

	</aui:form>
</div>
	 <div><label style="color: white" >.</label>
</div>
</body>
<%-- 

<%
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/emergencycontact/editemergencycontact.jsp");
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
  com.liferay.portal.kernel.dao.search.SearchContainer<EmergencyContact> searchContainer;
%>



	<liferay-ui:search-container orderByCol="<%=sortByCol %>"
		orderByType="<%=sortByType %>"
		rowChecker="<%= new RowChecker(renderResponse) %>" delta="4"
		emptyResultsMessage="No records is available for Emergency Contacts."
		deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">

		<liferay-ui:search-container-results>
				
<%
	   List<EmergencyContact> emergencyContactList = EmergencyContactLocalServiceUtil.getEmergencyContacts(searchContainer.getStart(), searchContainer.getEnd());
	   System.out.println("list size == " +emergencyContactList.size());
	   OrderByComparator orderByComparator = CustomComparatorUtil.getEmergencyContactOrderByComparator(sortByCol, sortByType);         
	
	   Collections.sort(emergencyContactList,orderByComparator);
	
	   results = emergencyContactList;
	
	   System.out.println("results == " +results);
	 
	
	   total = EmergencyContactLocalServiceUtil.getEmergencyContactsCount();
	   System.out.println("total == " +total);
	   pageContext.setAttribute("results", results);
	   pageContext.setAttribute("total", total);
 %>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="EmergencyContact"
		keyProperty="emergencyContactId" modelVar="emergencyContact" rowVar="curRow"
		escapedModel="<%= true %>">

		<liferay-ui:search-container-column-text orderable="<%=false %>"
			name="Name" property="name" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Relationship"  property="relationship" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Home Telephone"  property="homeTelephone" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Mobile"  property="mobile" />
		<liferay-ui:search-container-column-text orderable="<%=false %>" 
			name="Work Telephone"  property="workTelephone" />

		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/emergencycontact/edit.jsp" />	

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator/>
	
</liferay-ui:search-container> 
--%>
</html>