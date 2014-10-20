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
<%
	Map empId = (Map) request.getSession(false).getAttribute("empId");
	long employeeId = (Long) empId.get("empId");
	String jsp = (String) empId.get("jsp");
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
   var cancelExp=A.one('#<portlet:namespace/>cancelWorkExp');
   var cancelEdu=A.one('#<portlet:namespace/>cancelEducation');
   var cancelSki=A.one('#<portlet:namespace/>cancelSkill');
   var cancelLan=A.one('#<portlet:namespace/>cancelLanguage');
   var cancelLic=A.one('#<portlet:namespace/>cancelLicense');
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
			name="empWorkExpDelete" cssClass="button btn-danger"
			></aui:button>
	</div>
</div>
<div id="addEmployeeEducation" class="panel">
	<div class="panel-heading">
		<h3>Add Education</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpEducation" id="addEmpEducation"
			action="<%=addEducation%>" method="post">
			<aui:input name="empEduId" value="<%=employeeId%>"
			type="hidden"></aui:input>
			<div class="row-fluid">
				<div class="span8">
					<aui:select name="edu_level" label="Level" inlineLabel="left"
						showRequiredLabel="false">
						<aui:option>Masters</aui:option>
						<aui:option>Bachelors</aui:option>
						<aui:option>UnderGraduate</aui:option>
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

						<aui:option value="<%=skill.getSkillName()%>"
							label="<%=skill.getSkillName()%>"></aui:option>
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

						<aui:option value="<%=language.getLanguageName()%>"
							label="<%=language.getLanguageName()%>"></aui:option>
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
	</div>
</div>
<div id="addEmpLicense" class="panel">
	<div class="panel-heading">
		<h3>Add License</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpLicen" id="addEmpLicen"
			action="<%=addLicense%>" method="post">
			<aui:input name="empLicId" value="<%=employeeId%>"
			type="hidden"></aui:input>
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

						<aui:option value="<%=license.getLicenseName()%>"
							label="<%=license.getLicenseName()%>"></aui:option>
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
			name="empLicenseDelete"  cssClass="button btn-danger"></aui:button>
	</div>
</div>
