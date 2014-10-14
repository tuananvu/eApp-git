<%@ include file="/html/employee/init.jsp"%>
<portlet:actionURL name="addWorkExp" var="addWorkExp"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<portlet:actionURL name="addEducation" var="addEducation"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<portlet:actionURL name="addSkills" var="addSkills"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<portlet:actionURL name="addLanguage" var="addLanguage"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>
<portlet:actionURL name="addLicense" var="addLicense"
	windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>"></portlet:actionURL>

<aui:script use="aui-base,aui-node,aui-io-request">
</aui:script>
<div id="empWorkExpAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Work Experience</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empWorkExpAdd" name="empWorkExpAdd" value="Add"></aui:button>
		<aui:button id="empWorkExpDelete" value="Delete"
			name="empWorkExpDelete"></aui:button>
	</div>
</div>
<div id="empEducationAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Education</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empEducationAdd" name="empEducationAdd" value="Add"></aui:button>
		<aui:button id="empEducationDelete" value="Delete"
			name="empEducationDelete"></aui:button>
	</div>
</div>
<div id="empSkillsAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Skills</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empSkillsAdd" name="empSkillsAdd" value="Add"></aui:button>
		<aui:button id="empSkillsDelete" value="Delete" name="empSkillsDelete"></aui:button>
	</div>
</div>
<div id="empLanguageAddDelete" class="panel">
	<div class="panel-heading">
		<h3>Language</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empLanguageAdd" name="empLanguageAdd" value="Add"></aui:button>
		<aui:button id="empLanguageDelete" value="Delete"
			name="empLanguageDelete"></aui:button>
	</div>
</div>
<div id="empLicenseAddDelete" class="panel">
	<div class="panel-heading">
		<h3>License</h3>
	</div>
	<div class="panel-body">
		<aui:button id="empLicenseAdd" name="empLicenseAdd" value="Add"></aui:button>
		<aui:button id="empLicenseDelete" value="Delete"
			name="empLicenseDelete"></aui:button>
	</div>
</div>
<div id="addEmpWorkExp" class="panel">
	<div class="panel-heading">
		<h3>Add Work Experience</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addWorkExperience" id="addWorkExperience"
			action="<portlet:actionURL/>" method="post">
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="exp_company" label="Company" inlineLabel="left"
						showRequiredLabel="false">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="exp_jobtitle" label="Job Title" inlineLabel="left"
						showRequiredLabel="false">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="exp_from_date" label="From" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="exp_to_date" label="To" inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="exp_comments" type="textarea" label="comments"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitExpDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>
<div id="addEmployeeEducation" class="panel">
	<div class="panel-heading">
		<h3>Add Education</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpEducation" id="addEmpEducation"
			action="<portlet:actionURL/>" method="post">
			<div class="row-fluid">
				<div class="span6">
					<aui:select name="edu_level" label="Level" inlineLabel="left"
						showRequiredLabel="false">
						<aui:option>Masters</aui:option>
						<aui:option>Bachelors</aui:option>
						<aui:option>UnderGraduate</aui:option>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="edu_institute" label="Institute"
						inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="edu_major" label="Major/Specialization"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="edu_year" label="Year" inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="edu_score" label="GPA/Score" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="edu_from_date" label="From" inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="edu_to_date" label="To" inlineLabel="left"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitEduDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>
<div id="addEmpSkills" class="panel">
	<div class="panel-heading">
		<h3>Add Skill</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmpSkill" id="addEmpSkill"
			action="<portlet:actionURL/>" method="post">
			<div class="row-fluid">
				<div class="span6">
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
				<div class="span6">
					<aui:input name="skill_exp" label="Years of Experience"
						inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input type="textarea" name="skill_comments" label="Comments"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitEmpSkills"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>
<div id="addEmpLicense" class="panel">
	<div class="panel-heading">
		<h3>Add License</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmp" id="addEmp" action="<portlet:actionURL/>"
			method="post">
			<div class="row-fluid">
				<div class="span6">
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
				<div class="span6">
					<aui:input name="emp_license_no" label="License Number"
						inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="license_issue_date" label="License Issue Date"
						inlineLabel="left"></aui:input>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<aui:input name="license_exp_date" label="License Expiry Date"
						inlineLabel="left">
					</aui:input>
				</div>
			</div>
			<aui:button type="submit" cssClass="button btn-primary" value="save"
				id="submitLicenseDetails"></aui:button>
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>
<div id="addEmpLanguage" class="panel">
	<div class="panel-heading">
		<h3>Add Language</h3>
	</div>
	<div class="panel-body">
		<aui:form name="addEmp" id="addEmp" action="<portlet:actionURL/>"
			method="post">
			<div class="row-fluid">
				<div class="span6">
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
				<div class="span6">
					<aui:select name="lan_skill" label="Skill" inlineLabel="left"
						showRequiredLabel="false">
						<aui:option>Writing</aui:option>
						<aui:option>Reading</aui:option>
						<aui:option>Speaking</aui:option>
					</aui:select>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
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
			<aui:button type="reset" value="Cancel" cssClass="button btn-warning"></aui:button>
		</aui:form>
	</div>
</div>