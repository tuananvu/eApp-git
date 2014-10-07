<%@ include file="/html/employee/init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>employee</title>


<aui:script>

AUI().use(
  'aui-node',
  function(A) {
  alert("11111");
    var node = A.one('#editcancel');
    alert("3333!! node = " + node)
    node.on(
      'click',
      function() {
        alert("3333!!");
        //window.location='';
      }
    );																																
  }
);
</aui:script>
<portlet:defineObjects />
</head>
<body>
<aui:form>
<aui:input name="firstName" type="text" value="geeta"></aui:input>
<aui:button  type="button" value="Cancel" id ="editcancel"></aui:button>
</aui:form>
</body>
</html>