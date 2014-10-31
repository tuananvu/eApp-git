<%@page import="com.rknowsys.eapp.hrm.service.PayGradeLocalServiceUtil"%>
<%@page import="com.rknowsys.eapp.hrm.model.PayGrade"%>
<%@ include file="/html/paygrade/init.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayGrade</title>
<portlet:actionURL var="savepaygrade" name="savePayGrade">
</portlet:actionURL>
<portlet:resourceURL var="deletepaygrade" id="deletePayGrade"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/paygrade/addpaygrade.jsp" />
</portlet:renderURL>
<portlet:renderURL var="paygradelist">
	<portlet:param name="mvcPath" value="/html/paygrade/paygradelist.jsp" />
</portlet:renderURL>
<style type="text/css">
em {
	color: red;
}

</style>
<aui:script>

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delete');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[name=<portlet:namespace/>rowIds]:checked').each(function(object) {
      idArray.push(object.get("value"));
    
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected records ?");
		  if(d){
		   var url = '<%=deletepaygrade%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />paygradeIds: idArray,  
                 },
          on: {
               success: function() { 
                   alert('deleted successfully');
                   window.location='<%=listview%>';
              },
               failure: function() {
                  
                 }
                }
                 }
                );
		  																		
		  console.log(idArray);
	  
      return true;
  }
  else
    return false;
}             
      }
    );
  }
);

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancel');
    node.on(
      'click',
      function() {
        A.one("#paygradeId").set("value","");
         A.one("#paygrade").set("value","");
      	
          
      }
    );																																
  }
);


</aui:script>

</head>
<body>
<%

PayGrade editpaygrade =(PayGrade) portletSession.getAttribute("editpaygrade");

%>

<aui:form name="myForm" action="<%=savepaygrade.toString()%>">
		<aui:input name="paygradeId" type="hidden" id="paygradeId" value="<%=editpaygrade.getPayGradeId()%>" />
		<div class="span12">
			<div class="span2">
				<label>Name<em>*</em> </label>
		</div>
		<div class="span3">		
		 <input name="<portlet:namespace/>paygradeName" id="paygrade" type="text" required = "required" value="<%=editpaygrade.getPayGradeName()%>">
			</div>
		</div>
		
		<aui:button type="submit" value="Submit" />
		<aui:button  type="reset" value="Cancel" href="<%=paygradelist.toString()%>" id ="cancel"/>
			
	</aui:form>


</body><br/><br/>


</html>