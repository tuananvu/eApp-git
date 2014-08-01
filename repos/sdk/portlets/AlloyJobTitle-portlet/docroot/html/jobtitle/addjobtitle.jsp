<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<portlet:actionURL var="savejobtitle" name="saveJobtitle">
</portlet:actionURL>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/jobtitle/addjobtitle.jsp" />
</portlet:renderURL>
<html class=" js no-touch boxshadow textshadow cssanimations cssgradients csstransforms csstransforms3d csstransitions generatedcontent" xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<%--  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/preview.css"> --%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/screen_preview.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.7.0.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<style type="text/css">

em {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#button-set {
	margin-left: 40px;
}
</style>
<title>Add Jobtitle</title>

</head>
<body>
	<form onsubmit="savejobtitle()">

			<input type="hidden" id="jobtitleId"
				name='<portlet:namespace/>jobtitleId'>

		<label for="jobTitle_jobTitle">Job Title <em>*</em></label>&nbsp;&nbsp;
				<input type="text" name="<portlet:namespace/>name" maxlength="100" required = "required"
				id="jobtitlename" /><br/>

			<label for="jobTitle_jobDescription">Job
					Description</label> &nbsp;&nbsp;&nbsp;<textarea rows="4" cols="30"
					name="<portlet:namespace/>description" maxlength="400"
					id="description"></textarea><br/>




			<label for="jobTitle_note">Note</label>&nbsp;&nbsp;
				<textarea rows="4" cols="30" name="<portlet:namespace/>notes"
					id="notes"></textarea><br/>

			<em>*</em> Required field

		<br/>
		<hr/>


		<div class="span12" id="button-set">


				<input  onclick="" class="btn btn-primary" type="submit" id="submit" value="submit"> <input  class="btn btn-default" onclick="hideForm()" data-dismiss="modal"
					id="cancel" type="button" value="Cancel">
			</div>
			
		</form>
	



</body>

</html>