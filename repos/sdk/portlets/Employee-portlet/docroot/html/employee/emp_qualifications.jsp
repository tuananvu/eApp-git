<%@page import="com.liferay.portal.PortalException"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addQualifications" var="addWorkExp">
	<portlet:param name="<%=Constants.CMD%>" value="empExperience" />
</portlet:actionURL>
<portlet:actionURL name="addQualifications" var="addEducation">
	<portlet:param name="<%=Constants.CMD%>" value="empEducation" />
</portlet:actionURL>
<portlet:actionURL name="addQualifications" var="addSkills">
	<portlet:param name="<%=Constants.CMD%>" value="empSkills" />
</portlet:actionURL>
<portlet:actionURL name="addQualifications" var="addLanguage">
	<portlet:param name="<%=Constants.CMD%>" value="empLanguage" />
</portlet:actionURL>
<portlet:actionURL name="addQualifications" var="addLicense">
	<portlet:param name="<%=Constants.CMD%>" value="empLicense" />
</portlet:actionURL>
<%String skillValue,eduValue,licenseValue,lanValue=""; %>
<%!public String getSkillName(long skiId) {
	if(skiId!=0)
	{
		Skill skil = null;
		try {
			skil = SkillLocalServiceUtil.getSkill(skiId);
		} catch (Exception p) {
		}
		return skil.getSkillName();
	}
	else
	{
		return "";	}
	}
	public String getEduLevel(long eduId)
	{
		if(eduId!=0)
		{
		Education eduLvl = null;
		try {
			eduLvl = EducationLocalServiceUtil.getEducation(eduId);
		} catch (Exception p) {
		}
		return eduLvl.getEduLevel();
		}
		else
		{
			return "";		}
	}
	public String getLicnse(long licId)
	{	
		if(licId!=0)
		{
		License licType = null;
		try {
			licType = LicenseLocalServiceUtil.getLicense(licId);
		} catch (Exception p) {
		}
		return licType.getLicenseName();
		}
		else
		{
			return "";
		}
	}
	public String getLnguage(long lanId)
	{	if(lanId!=0)
		{
		Language lan = null;
		try {
			lan = LanguageLocalServiceUtil.getLanguage(lanId);
		} catch (Exception p) {
		}
		return lan.getLanguageName();
		}
	else
	{
		return "";	}
	}
	
	%>
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
	long fileEntryId=(Long)empId.get("fileId");
	DynamicQuery empWrkExpDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpWorkExp.class,
					PortletClassLoaderUtil.getClassLoader());
	empWrkExpDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpWorkExp> empWrkExpDetails = EmpWorkExpLocalServiceUtil
			.dynamicQuery(empWrkExpDynamicQuery);
	DynamicQuery empEducationDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpEducation.class,
					PortletClassLoaderUtil.getClassLoader());
	empEducationDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpEducation> empEducationDetails = EmpEducationLocalServiceUtil
			.dynamicQuery(empEducationDynamicQuery);
	DynamicQuery empSkillDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpSkill.class,
					PortletClassLoaderUtil.getClassLoader());
	empSkillDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpSkill> empSkillDetails = EmpSkillLocalServiceUtil
			.dynamicQuery(empSkillDynamicQuery);
	DynamicQuery empLanguageDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpLanguage.class,
					PortletClassLoaderUtil.getClassLoader());
	empLanguageDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpLanguage> empLanguageDetails = EmpLanguageLocalServiceUtil
			.dynamicQuery(empLanguageDynamicQuery);
	DynamicQuery empLicenseDynamicQuery = DynamicQueryFactoryUtil
			.forClass(EmpLicense.class,
					PortletClassLoaderUtil.getClassLoader());
	empLicenseDynamicQuery.add(PropertyFactoryUtil.forName("employeeId")
			.eq(employeeId));
	List<EmpLicense> empLicenseDetails = EmpLicenseLocalServiceUtil
			.dynamicQuery(empLicenseDynamicQuery);
%>
<aui:script use="aui-base,aui-node,aui-io-request-deprecated">
var A=new AUI();
A.ready(function()
  {
  A.one('#addEmpWorkExp').hide();
  A.one('#addEmployeeEducation').hide();
  A.one('#addEmpSkills').hide();
  A.one('#addEmpLanguage').hide();
  A.one('#addEmpLicense').hide();
  });
   var addExpButton=A.one('#<portlet:namespace />empWorkExpAdd');
   var addEduButton=A.one('#<portlet:namespace />empEducationAdd');
   var addSkillsButton=A.one('#<portlet:namespace />empSkillsAdd');
   var addLanguageButton=A.one('#<portlet:namespace />empLanguageAdd');
   var addLicenseButton=A.one('#<portlet:namespace />empLicenseAdd');
   var cancelExp=A.one('#<portlet:namespace />cancelWorkExp');
   var cancelEdu=A.one('#<portlet:namespace />cancelEducation');
   var cancelSki=A.one('#<portlet:namespace />cancelSkill');
   var cancelLan=A.one('#<portlet:namespace />cancelLanguage');
   var cancelLic=A.one('#<portlet:namespace />cancelLicense');
   addExpButton.on('click',
	   function()
	   {
	    A.one('#<portlet:namespace />empLicenseAdd').hide();
	    A.one('#<portlet:namespace />empLanguageAdd').hide();
	    A.one('#<portlet:namespace />empSkillsAdd').hide();
	    A.one('#<portlet:namespace />empWorkExpAdd').hide();
	    A.one('#<portlet:namespace />empEducationAdd').hide();
	    A.one('#<portlet:namespace />empLicenseDelete').hide();
	    A.one('#<portlet:namespace />empLanguageDelete').hide();
	    A.one('#<portlet:namespace />empSkillsDelete').hide();
	    A.one('#<portlet:namespace />empWorkExpDelete').hide();
	    A.one('#<portlet:namespace />empEducationDelete').hide();
	    A.one('#addEmpWorkExp').show();
	   });
   addEduButton.on('click',
   function()
	   {
	    A.one('#<portlet:namespace />empLicenseAdd').hide();
	    A.one('#<portlet:namespace />empLanguageAdd').hide();
	    A.one('#<portlet:namespace />empSkillsAdd').hide();
	    A.one('#<portlet:namespace />empWorkExpAdd').hide();
	    A.one('#<portlet:namespace />empEducationAdd').hide();
	    A.one('#<portlet:namespace />empLicenseDelete').hide();
	    A.one('#<portlet:namespace />empLanguageDelete').hide();
	    A.one('#<portlet:namespace />empSkillsDelete').hide();
	    A.one('#<portlet:namespace />empWorkExpDelete').hide();
	    A.one('#<portlet:namespace />empEducationDelete').hide();
	    A.one('#addEmployeeEducation').show();
	   });
   addSkillsButton.on('click',
   function()
	   {
	    A.one('#<portlet:namespace />empLicenseAdd').hide();
	    A.one('#<portlet:namespace />empLanguageAdd').hide();
	    A.one('#<portlet:namespace />empSkillsAdd').hide();
	    A.one('#<portlet:namespace />empWorkExpAdd').hide();
	    A.one('#<portlet:namespace />empEducationAdd').hide();
	    A.one('#<portlet:namespace />empLicenseDelete').hide();
	    A.one('#<portlet:namespace />empLanguageDelete').hide();
	    A.one('#<portlet:namespace />empSkillsDelete').hide();
	    A.one('#<portlet:namespace />empWorkExpDelete').hide();
	    A.one('#<portlet:namespace />empEducationDelete').hide();
	    A.one('#addEmpSkills').show();
	   });
   addLanguageButton.on('click',
   function()
	   {
	    A.one('#<portlet:namespace />empLicenseAdd').hide();
	    A.one('#<portlet:namespace />empLanguageAdd').hide();
	    A.one('#<portlet:namespace />empSkillsAdd').hide();
	    A.one('#<portlet:namespace />empWorkExpAdd').hide();
	    A.one('#<portlet:namespace />empEducationAdd').hide();
	    A.one('#<portlet:namespace />empLicenseDelete').hide();
	    A.one('#<portlet:namespace />empLanguageDelete').hide();
	    A.one('#<portlet:namespace />empSkillsDelete').hide();
	    A.one('#<portlet:namespace />empWorkExpDelete').hide();
	    A.one('#<portlet:namespace />empEducationDelete').hide();
	    A.one('#addEmpLanguage').show();
	   });
   addLicenseButton.on('click',
   function()
	   {
	   A.one('#<portlet:namespace />empLicenseAdd').hide();
	   A.one('#<portlet:namespace />empLanguageAdd').hide();
	   A.one('#<portlet:namespace />empSkillsAdd').hide();
	   A.one('#<portlet:namespace />empWorkExpAdd').hide();
	   A.one('#<portlet:namespace />empEducationAdd').hide();
	   A.one('#<portlet:namespace />empLicenseDelete').hide();
	   A.one('#<portlet:namespace />empLanguageDelete').hide();
	   A.one('#<portlet:namespace />empSkillsDelete').hide();
	   A.one('#<portlet:namespace />empWorkExpDelete').hide();
	   A.one('#<portlet:namespace />empEducationDelete').hide();
	   A.one('#addEmpLicense').show();
	   });
   cancelExp.on('click',
   function()
	   {
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
   cancelEdu.on('click',
   function()
	   {
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
   cancelSki.on('click',
   function()
	   { 
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
   cancelLan.on('click',
   function()
	   {
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
   cancelLic.on('click',
   function()
	   {
	    A.one('#addEmpWorkExp').hide();
  		A.one('#addEmployeeEducation').hide();
  		A.one('#addEmpSkills').hide();
  		A.one('#addEmpLanguage').hide();
  		A.one('#addEmpLicense').hide();
  		A.one('#<portlet:namespace />empLicenseAdd').show();
	   A.one('#<portlet:namespace />empLanguageAdd').show();
	   A.one('#<portlet:namespace />empSkillsAdd').show();
	   A.one('#<portlet:namespace />empWorkExpAdd').show();
	   A.one('#<portlet:namespace />empEducationAdd').show();
	   A.one('#<portlet:namespace />empLicenseDelete').show();
	   A.one('#<portlet:namespace />empLanguageDelete').show();
	   A.one('#<portlet:namespace />empSkillsDelete').show();
	   A.one('#<portlet:namespace />empWorkExpDelete').show();
	   A.one('#<portlet:namespace />empEducationDelete').show();
	   });
</aui:script>
<div id="addEmpWorkExp" class="panel">
	<div class="panel-heading">
		<h3>Add Work Experience</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addWorkExperience" id="addWorkExperience"
			action="<%=addWorkExp%>" method="post">
			<aui:input name="empWrkExpId" value="<%=employeeId%>" type="hidden"></aui:input>
			<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="exp_company" label="Company" inlineLabel="left"
						showRequiredLabel="false">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="exp_jobtitle" label="Job Title" inlineLabel="left"
						showRequiredLabel="false">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="exp_from_date" label="From" inlineLabel="left"
						cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="exp_to_date" label="To" inlineLabel="left"
						cssClass="dateEmployee">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="exp_comments" type="textarea" label="comments"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitExpDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
				id="cancelWorkExp" name="cancelWorkExp"></aui:button>
		</aui:form>
	</div>
</div>
<div id="empWorkExpAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Work Experience</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empWorkExpAdd" name="empWorkExpAdd" value="Add"
			cssClass="button btn-primary"></aui:button>
		<aui:button id="empWorkExpDelete" value="Delete"
			name="empWorkExpDelete" cssClass="button btn-danger"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpWorkExp"
			deltaConfigurable="true"
			rowChecker="<%=new RowChecker(renderResponse)%>">
			<liferay-ui:search-container-results>
				<%
					List<EmpWorkExp> workExpList = empWrkExpDetails;
							results = workExpList;
							total = workExpList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpWorkExp"
				modelVar="id">
				<liferay-ui:search-container-column-text name="Company" property="company"/>
				<liferay-ui:search-container-column-text name="Job Title" property="jobTitle" />
				<liferay-ui:search-container-column-text name="From" property="fromDate"/>
				<liferay-ui:search-container-column-text name="To" property="toDate"/>
				<liferay-ui:search-container-column-text name="Comment" property="comment"/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="addEmployeeEducation" class="panel">
	<div class="panel-heading">
		<h3>Add Education</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpEducation" id="addEmpEducation"
			action="<%=addEducation%>" method="post">
			<aui:input name="empEduId" value="<%=employeeId%>" type="hidden"></aui:input>
			<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="edu_level" label="Level" inlineLabel="left"
						showRequiredLabel="false">
						<aui:option value="-1">--Select--</aui:option>
							<%
								List<Education> eduList = EducationLocalServiceUtil.getEducations(-1, -1);
										Iterator eduLevels = eduList.iterator();
										while (eduLevels.hasNext()) {
											Education educationLevel = (Education) eduLevels.next();
							%>
							<aui:option value="<%=educationLevel.getEducationId()%>">
							<%=educationLevel.getEduLevel()%></aui:option>
							<%
								}
							%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="edu_institute" label="Institute"
						inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="edu_major" label="Specialization"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="edu_year" label="Year" inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="edu_score" label="GPA/Score" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="edu_from_date" label="From" inlineLabel="left"
						cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="edu_to_date" label="To" inlineLabel="left"
						cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitEduDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
				id="cancelEducation" name="cancelEducation"></aui:button>
		</aui:form>
	</div>
</div>
<div id="empEducationAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Education</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empEducationAdd" name="empEducationAdd" value="Add"
			cssClass="button btn-primary"></aui:button>
		<aui:button id="empEducationDelete" value="Delete"
			name="empEducationDelete" cssClass="button btn-danger"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpEducation"
			deltaConfigurable="true"
			rowChecker="<%=new RowChecker(renderResponse)%>">
			<liferay-ui:search-container-results>
				<%
					List<EmpEducation> educationList = empEducationDetails;
							results = educationList;
							total = educationList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpEducation"
				modelVar="id">
				<% eduValue=getEduLevel(id.getEducationId())!=null?getEduLevel(id.getEducationId()):""; %>
				<liferay-ui:search-container-column-text name="Level" 
				value='<%= eduValue %>' />
				<liferay-ui:search-container-column-text name="Year" property="year"/>
				<liferay-ui:search-container-column-text name="GPA/Score" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="addEmpSkills" class="panel">
	<div class="panel-heading">
		<h3>Add Skill</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpSkill" id="addEmpSkill" action="<%=addSkills%>"
			method="post">
			<aui:input name="empSkillId" value="<%=employeeId%>" type="hidden"></aui:input>
			<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="emp_skill" label="Level" inlineLabel="left"
						showRequiredLabel="false">
						<%
							List<Skill> skillList = SkillLocalServiceUtil.getSkills(-1,
											-1);
									Iterator skillList2 = skillList.iterator();
									while (skillList2.hasNext()) {
										Skill skill = (Skill) skillList2.next();
						%>
						<aui:option value="<%=skill.getSkillId()%>"
							><%=skill.getSkillName()%></aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="skill_exp" label="Years of Experience"
						inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input type="textarea" name="skill_comments" label="Comments"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitEmpSkills"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
				id="cancelSkill" name="cancelSkill"></aui:button>
		</aui:form>
	</div>
</div>
<div id="empSkillsAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Skills</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empSkillsAdd" name="empSkillsAdd" value="Add"
			cssClass="button btn-primary"></aui:button>
		<aui:button id="empSkillsDelete" value="Delete" name="empSkillsDelete"
			cssClass="button btn-danger"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpSkill"
			deltaConfigurable="true"
			rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpSkill> skillList = empSkillDetails;
							results = skillList;
							total = skillList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpSkill"
				modelVar="id">
				<%skillValue=getSkillName(id.getSkillId())!=null?getSkillName(id.getSkillId()):"" ; %>
				<liferay-ui:search-container-column-text name="Skill" 
				value='<%= skillValue %>'/>
				<liferay-ui:search-container-column-text name="Years of Experience" property="years"/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="addEmpLanguage" class="panel">
	<div class="panel-heading">
		<h3>Add Language</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpLan" id="addEmpLan" action="<%=addLanguage%>"
			method="post">
			<aui:input name="empLanId" value="<%=employeeId%>" type="hidden"></aui:input>
			<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="emp_language" label="Language" inlineLabel="left"
						showRequiredLabel="false">
						<%
							List<Language> languageList = LanguageLocalServiceUtil
											.getLanguages(-1, -1);
									Iterator languageList2 = languageList.iterator();
									while (languageList2.hasNext()) {
										Language language = (Language) languageList2.next();
						%>
						<aui:option value="<%=language.getLanguageId()%>"
							><%=language.getLanguageName()%></aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="lan_skill" label="Skill" inlineLabel="left"
						showRequiredLabel="false">
						<aui:option>Writing</aui:option>
						<aui:option>Reading</aui:option>
						<aui:option>Speaking</aui:option>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="lan_fluency" label="Fluency Level"
						inlineLabel="left" showRequiredLabel="false">
						<aui:option>Poor</aui:option>
						<aui:option>Basic</aui:option>
						<aui:option>Good</aui:option>
						<aui:option>Mother Toungue</aui:option>
					</aui:select>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitLanguage"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
				id="cancelLanguage" name="cancelLanguage"></aui:button>
		</aui:form>
	</div>
</div>
<div id="empLanguageAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Language</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empLanguageAdd" name="empLanguageAdd" value="Add"
			cssClass="button btn-primary"></aui:button>
		<aui:button id="empLanguageDelete" value="Delete"
			name="empLanguageDelete" cssClass="button btn-danger"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpLanguage"
			deltaConfigurable="true"
			rowChecker="<%=new RowChecker(renderResponse)%>">
			<liferay-ui:search-container-results>
				<%
					List<EmpLanguage> languageList = empLanguageDetails;
							results = languageList;
							total = languageList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpLanguage"
				modelVar="id">
				<%lanValue=getLnguage(id.getLanguageId())!=null?getLnguage(id.getLanguageId()):"" ; %>
				<liferay-ui:search-container-column-text name="Language" 
				value='<%=lanValue %>'/>
				<liferay-ui:search-container-column-text name="Skill" property="languageSkill" />
				<liferay-ui:search-container-column-text name="Fluency Level" property="languageFluency"/>
				<liferay-ui:search-container-column-text name="Comments" property="comments" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>
<div id="addEmpLicense" class="panel">
	<div class="panel-heading">
		<h3>Add License</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpLicen" id="addEmpLicen" action="<%=addLicense%>"
			method="post">
			<aui:input name="empLicId" value="<%=employeeId%>" type="hidden"></aui:input>
			<aui:input name="QualFileId" value="<%=fileEntryId%>" type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="emp_license_type" label="License Type"
						inlineLabel="left" showRequiredLabel="false">
						<%
							List<License> licenseList = LicenseLocalServiceUtil
											.getLicenses(-1, -1);
									Iterator licenseList2 = licenseList.iterator();
									while (licenseList2.hasNext()) {
										License license = (License) licenseList2.next();
						%>
						<aui:option value="<%=license.getLicenseId()%>"
							><%=license.getLicenseName()%></aui:option>
						<%
							}
						%>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="emp_license_no" label="License Number"
						inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="license_issue_date" label="License Issue Date"
						inlineLabel="left" cssClass="dateEmployee"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span8">
					<aui:input name="license_exp_date" label="License Expiry Date"
						inlineLabel="left" cssClass="dateEmployee">
					</aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitLicenseDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-danger"
				id="cancelLicense" name="cancelLicense"></aui:button>
		</aui:form>
	</div>
</div>
<div id="empLicenseAddDelete" class="panel">
	<div class="panel-heading">
		<h3>License</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empLicenseAdd" name="empLicenseAdd" value="Add"
			cssClass="button btn-primary"></aui:button>
		<aui:button id="empLicenseDelete" value="Delete"
			name="empLicenseDelete" cssClass="button btn-danger"></aui:button>
		<liferay-ui:search-container delta="5"
			emptyResultsMessage="No records are available for EmpLicense"
			deltaConfigurable="true"
			rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results>
				<%
					List<EmpLicense> licenseList = empLicenseDetails;
							results = licenseList;
							total = licenseList.size();
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="EmpLicense"
				modelVar="id">
				<%licenseValue=getLicnse(id.getLicenseId())!=null?getLicnse(id.getLicenseId()):""; %>
				<liferay-ui:search-container-column-text name="License Type" 
				value='<%=licenseValue  %>'/>
				<liferay-ui:search-container-column-text name="Issued Date" property="issuedDate"/>
				<liferay-ui:search-container-column-text name="Expiry Date" property="expiryDate" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</div>