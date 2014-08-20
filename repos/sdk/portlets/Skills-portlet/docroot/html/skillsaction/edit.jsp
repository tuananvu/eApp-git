
<%@ include file="/html/skillsaction/init.jsp" %>

<%ResultRow rslt=(ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Skill skills= (Skill)rslt.getObject();

String prk=String.valueOf(skills.getPrimaryKey());
%>
<liferay-ui:icon-menu>
<portlet:actionURL var="editSkills" name="editSkill">
<portlet:param name="skillId" value="<%=prk %>"/>
</portlet:actionURL>


<a href="#" onclick="window.location='<%=editSkills.toString()%>'"><img
					width="18px" height="18px" alt="loading..." 
					src="<%=request.getContextPath() %>/images/pencil.jpg"></a> 
</liferay-ui:icon-menu>
