<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/language/init.jsp"%>

<portlet:actionURL var="saveLanguages" name="saveLanguage">
</portlet:actionURL>
<portlet:resourceURL var="deleteLanguages" id="deleteLanguage"/>
<portlet:renderURL var="listview">
	<portlet:param name="mvcPath" value="/html/language/add.jsp" />
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
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#delete');
    node.on(
      'click',
      function() {
     var idArray = [];
      A.all('input[type=checkbox]:checked').each(function(object) {
      idArray.push(object.get("value"));
    alert(idArray.length);
        });
       if(idArray==""){
			  alert("Please select records!");
		  }else{
			  var d = confirm("Are you sure you want to delete the selected language ?");
		  if(d){
		   var url = '<%=deleteLanguages%>';
          A.io.request(url,
         {
          data: {  
                <portlet:namespace />languageIds: idArray,  
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
</aui:script>
<aui:script>
AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#add');
    node.on(
      'click',
      function() {
         A.one('#languageAddDelete').hide();
         A.one('#addLanguageForm').show();
                     
      }
    );
  }
);

 AUI().ready('event', 'node', function(A){

  A.one('#addLanguageForm').hide();
 });

AUI().use(
  'aui-node',
  function(A) {
    var node = A.one('#cancel');
    node.on(
      'click',
      function() {
         A.one('#languageAddDelete').show();
         A.one('#addLanguageForm').hide();
                     
      }
    );
  }
);

</aui:script>
</head>

<body>
	<div id="languageAddDelete" class="span12">
		<a href="#" id="add">Add</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" id="delete">Delete</a>

	</div>
	<div  id="addLanguageForm">
	<aui:form name="myForm" action="<%=saveLanguages.toString()%>" >
		<aui:input name="languageId" type="hidden" id="languageId" />
	
		<div class="span12">
			<div class="span2">
				<label>Name</label>
		</div>
		<div class="span3">		
		 <input name="<portlet:namespace/>language_name" type="text" required = "required">
			</div>
		</div>
		<aui:button type="submit" value="Submit" />
		<aui:button  type="reset" value="Cancel" id ="cancel"/>
		
	</aui:form>
	</div>
	
	 <div><label style="color: white" >.</label></div>
	
</body>

<%

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("mvcPath", "/html/language/add.jsp");
RowChecker rowChecker = new RowChecker(renderResponse);

PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request); 
String sortByCol = ParamUtil.getString(request, "orderByCol"); 
String sortByType = ParamUtil.getString(request, "orderByType"); 

if (Validator.isNotNull(sortByCol ) && Validator.isNotNull(sortByType )) { 
	
 
portalPrefs.setValue("NAME_SPACE", "sort-by-col", sortByCol); 
portalPrefs.setValue("NAME_SPACE", "sort-by-type", sortByCol); 
 
} else { 
 
	
	sortByType = portalPrefs.getValue("NAME_SPACE", "sort-by-type ", "asc");   
}

%>
<%!
  com.liferay.portal.kernel.dao.search.SearchContainer<Language> searchContainer;
%>
<div>
<liferay-ui:search-container orderByCol="<%=sortByCol %>"
	orderByType="<%=sortByType %>"
	rowChecker="<%= new RowChecker(renderResponse) %>" delta="5"
	emptyResultsMessage="No records are available for Languages"
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>

		<%
            List<Language> languageList = LanguageLocalServiceUtil.getLanguages(searchContainer.getStart(), searchContainer.getEnd());
		OrderByComparator orderByComparator =  CustomComparatorUtil.getLanguagesOrderByComparator(sortByCol, sortByType);
   
               //Collections.sort(languageList,orderByComparator);
               ListUtil.sort(languageList,orderByComparator);
               results = languageList;
               total = LanguageLocalServiceUtil.getLanguagesCount();
               pageContext.setAttribute("results", results);
               pageContext.setAttribute("total", total);

 %>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Language"
		keyProperty="languageId" modelVar="languageId" rowVar="curRow"
		escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text orderable="<%=true %>"
			name="name" property="languageName"
			orderableProperty="languageName" />
		<liferay-ui:search-container-column-jsp name="Edit"
			path="/html/language/editClick.jsp" />

	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</div>

