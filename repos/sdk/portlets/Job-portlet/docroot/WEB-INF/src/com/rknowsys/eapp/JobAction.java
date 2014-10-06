package com.rknowsys.eapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
//import com.rknowsys.eapp.hrm.model.ContactDetails;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.model.EmploymentStatus;
import com.rknowsys.eapp.hrm.model.Job;
import com.rknowsys.eapp.hrm.model.JobCategory;
import com.rknowsys.eapp.hrm.model.JobTitle;
import com.rknowsys.eapp.hrm.model.Location;
import com.rknowsys.eapp.hrm.model.SubUnit;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmploymentStatusLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobCategoryLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.JobTitleLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.SubUnitLocalServiceUtil;
import com.rknowsys.eapp.hrm.util.DateUtils;
import com.rknowsys.eapp.hrm.util.IdNamePair;

public class JobAction extends MVCPortlet {

	// public static final String CONTACT_DETAILS_JOB_ID = "jobId";
	// public static final String CONTACT_DETAILS_JOB_TITLE_ID = "jobTitleId";
	// public static final String CONTACT_DETAILS_ADDRESS_STREET_2 =
	// "addressStreet2";
	// public static final String CONTACT_DETAILS_CITY = "city";
	// public static final String CONTACT_DETAILS_STATE = "state";
	// public static final String CONTACT_DETAILS_POSTAL_CODE = "postalCode";
	// public static final String CONTACT_DETAILS_COUNTRY = "country";
	// public static final String CONTACT_DETAILS_HOME_TELEPHONE =
	// "homeTelephone";
	// public static final String CONTACT_DETAILS_MOBILE = "mobile";
	// public static final String CONTACT_DETAILS_WORK_TELEPHONE =
	// "workTelephone";
	// public static final String CONTACT_DETAILS_WORK_EMAIL = "workEmail";
	// public static final String CONTACT_DETAILS_OTHER_EMAIL = "otherEmail";

	private static final String EMPLOYMENT_CONTRACT_END_DATE = "employmentContractEndDate";
	private static final String EMPLOYMENT_CONTRACT_START_DATE = "employmentContractStartDate";
	private static final String LOCATION_ID = "locationId";
	private static final String SUB_UNIT_ID = "subUnitId";
	private static final String JOINED_DATE = "joinedDate";
	private static final String JOB_CATEGORY_ID = "jobCategoryId";
	private static final String EMPLOYMENT_STATUS_ID = "employmentStatusId";
	private static final String JOB_SPECIFICATION = "jobSpecification";
	private static final String JOB_TITLE_ID = "jobTitleId";
	private static final String JOB_ID = "jobId";
	private static Logger log = Logger.getLogger(JobAction.class);

	/**
	 * <p>
	 * This method inserts new ContactDetails record in database if the id is
	 * not existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveJob(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {

		log.info("inside saveJob...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());

		try {
			String id = ParamUtil.getString(actionRequest, JOB_ID);
			log.info("id == " + id);
			Job job = null;
			if (id == null || id.isEmpty()) {

				log.info("inside if loop...");

				job = JobLocalServiceUtil.createJob(CounterLocalServiceUtil
						.increment());

				job.setCreateDate(new Date());
				setThemeParams(themeDisplay, job);
				setJob(actionRequest, job);

				job = JobLocalServiceUtil.addJob(job);
				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long jobId = Long.parseLong(id);
				job = JobLocalServiceUtil.getJob(jobId);

				setThemeParams(themeDisplay, job);
				setJob(actionRequest, job);
				
				job = JobLocalServiceUtil.updateJob(job);
				log.info("end of else block");

			}
			actionRequest.setAttribute("editJob", job);
//			actionResponse.setRenderParameter("jspPage",
//					"/html/job/edit_job.jsp");

		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		log.info("end of the saveContactDetails method");

	}

	private void setThemeParams(ThemeDisplay themeDisplay, Job job) {
		job.setCompanyId(themeDisplay.getCompanyId());
		job.setGroupId(themeDisplay.getCompanyGroupId());
		job.setUserId(themeDisplay.getUserId());
	}

	private void setJob(ActionRequest actionRequest, Job job) throws NumberFormatException, PortalException, SystemException {

		job.setModifiedDate(new Date());
		job.setJobTitleId(Long.parseLong(ParamUtil.getString(actionRequest,JOB_TITLE_ID)));
		job.getJobTitle().setSpecification(ParamUtil.getString(actionRequest,JOB_SPECIFICATION));
		job.setEmploymentStatusId(Long.parseLong(ParamUtil.getString(actionRequest,EMPLOYMENT_STATUS_ID)));
		job.setJobCategoryId(Long.parseLong(ParamUtil.getString(actionRequest,JOB_CATEGORY_ID)));
		job.setJoinedDate(DateUtils.parse(ParamUtil.getString(actionRequest,JOINED_DATE)));
		job.setSubUnitId(Long.parseLong(ParamUtil.getString(actionRequest,SUB_UNIT_ID)));
		job.setLocationId(Long.parseLong(ParamUtil.getString(actionRequest,LOCATION_ID)));
		job.setEmploymentContractStartDate(DateUtils.parse(ParamUtil.getString(actionRequest,EMPLOYMENT_CONTRACT_START_DATE)));
		job.setEmploymentContractEndDate(DateUtils.parse(ParamUtil.getString(actionRequest,EMPLOYMENT_CONTRACT_END_DATE)));
	}

	/**
	 * <p>
	 * This method deletes the ContactDetails record from database based on
	 * ContactDetails record Id
	 * </p>
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			NumberFormatException {

		/*
		 * if (resourceRequest.getResourceID().equals("deleteContactDetails")) {
		 * 
		 * log.info("inside deleteContactDetails... serveResource"); try {
		 * ContactDetailsLocalServiceUtil
		 * .createContactDetails(CounterLocalServiceUtil .increment()); } catch
		 * (SystemException e1) {
		 * 
		 * e1.printStackTrace(); } String[] idsArray =
		 * ParamUtil.getParameterValues(resourceRequest, "contactDetailsIds");
		 * 
		 * log.info("idsArray== " + idsArray.length); for (int i = 0; i <=
		 * idsArray.length - 1; i++) { log.info(idsArray[i]);
		 * 
		 * } for (int i = 0; i <= idsArray.length - 1; i++) {
		 * log.info(idsArray[i]); if (idsArray[i].equals("on")) {
		 * log.info("All records selected..."); } else { try {
		 * ContactDetailsLocalServiceUtil .deleteContactDetails(Long
		 * .parseLong(idsArray[i])); log.info("end of try block in delete...");
		 * } catch (PortalException e) {
		 * 
		 * e.printStackTrace(); log.info("portal exception..."); } catch
		 * (SystemException e) {
		 * 
		 * e.printStackTrace(); log.info("system exception..."); } }
		 * 
		 * } log.info("end of for loop..");
		 * 
		 * } log.info("end of deleteContactDetails method...");
		 */
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		log.info("in doView method");
		// Employee
		// employee=(Employee)renderRequest.getPortletSession().getAttribute("employee");
		com.rknowsys.eapp.ui.Job jobUI;
		Job job;
		try {
			Employee employee = EmployeeLocalServiceUtil.getEmployee(1000);
			job = employee.getJob();
			// JobTitle jobTitle=job.getJobTitle();
			// JobCategory jobCategory = job.getJobCategory();
			// EmploymentStatus employmentStatus = job.getEmploymentStatus();
			// SubUnit subUnit = job.getSubUnit();
			// Location location = job.getLocation();

			log.info("job from service= " + job);
			jobUI = new com.rknowsys.eapp.ui.Job();
			jobUI.setJobId(String.valueOf(job.getJobId()));
			jobUI.setJobTitleId(String.valueOf(job.getJobTitleId()));
			List<JobTitle> jobTitles = JobTitleLocalServiceUtil.getJobTitles(0,
					JobTitleLocalServiceUtil.getJobTitlesCount());
			List<IdNamePair> jobTitleIdNameList = new ArrayList<IdNamePair>();
			for (JobTitle tJobTitle : jobTitles) {
				jobTitleIdNameList.add(new IdNamePair(String.valueOf(tJobTitle
						.getJobTitleId()), tJobTitle.getTitle()));
			}
			jobUI.setJobTitles(jobTitleIdNameList);

			jobUI.setJobSpecification(job.getJobTitle().getSpecification());

			jobUI.setEmploymentStatusId(String.valueOf(job
					.getEmploymentStatusId()));
			List<EmploymentStatus> employmentStatuses = EmploymentStatusLocalServiceUtil
					.getEmploymentStatuses(0, EmploymentStatusLocalServiceUtil
							.getEmploymentStatusesCount());
			List<IdNamePair> employmentStatusIdNameList = new ArrayList<IdNamePair>();
			for (EmploymentStatus tEmploymentStatus : employmentStatuses) {
				employmentStatusIdNameList.add(new IdNamePair(String
						.valueOf(tEmploymentStatus.getEmploymentStatusId()),
						tEmploymentStatus.getEmploymentstatus()));
			}
			jobUI.setEmploymentStatuses(employmentStatusIdNameList);

			jobUI.setJobCategoryId(String.valueOf(job.getJobCategoryId()));
			List<JobCategory> jobCategories = JobCategoryLocalServiceUtil
					.getJobCategories(0,
							JobCategoryLocalServiceUtil.getJobCategoriesCount());
			List<IdNamePair> jobCategoryIdNameList = new ArrayList<IdNamePair>();
			for (JobCategory tJobCategory : jobCategories) {
				jobCategoryIdNameList.add(new IdNamePair(String
						.valueOf(tJobCategory.getJobCategoryId()), tJobCategory
						.getJobcategory()));
			}
			jobUI.setJobCategories(jobCategoryIdNameList);

			jobUI.setJoinedDate(DateUtils.format(job.getJoinedDate()));

			jobUI.setSubUnitId(String.valueOf(job.getSubUnitId()));
			List<SubUnit> subUnits = SubUnitLocalServiceUtil.getSubUnits(0,
					SubUnitLocalServiceUtil.getSubUnitsCount());
			List<IdNamePair> subUnitIdNameList = new ArrayList<IdNamePair>();
			for (SubUnit tSubUnit : subUnits) {
				subUnitIdNameList.add(new IdNamePair(String.valueOf(tSubUnit
						.getSubUnitId()), tSubUnit.getName()));
			}
			jobUI.setSubUnits(subUnitIdNameList);

			jobUI.setLocationId(String.valueOf(job.getLocationId()));
			List<Location> locations = LocationLocalServiceUtil.getLocations(0,
					LocationLocalServiceUtil.getLocationsCount());
			List<IdNamePair> locationIdNameList = new ArrayList<IdNamePair>();
			for (Location tLocation : locations) {
				locationIdNameList.add(new IdNamePair(String.valueOf(tLocation
						.getLocationId()), tLocation.getName()));
			}
			jobUI.setLocations(locationIdNameList);

			jobUI.setStartDate(DateUtils.format(job
					.getEmploymentContractStartDate()));
			jobUI.setEndDate(DateUtils.format(job
					.getEmploymentContractEndDate()));

			renderRequest.setAttribute("editJob", jobUI);
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * <p>
	 * This method gets the single ContactDetails record from database based on
	 * the given ContactDetails Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single ContactDetails record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */

	/*
	 * 
	 * public void editJob(ActionRequest actionRequest, ActionResponse
	 * actionResponse) throws IOException, PortletException,
	 * NumberFormatException, PortalException, SystemException {
	 * 
	 * log.info("inside editJob..."); String s =
	 * ParamUtil.getString(actionRequest,JOB_ID); log.info("jobId == " + s); Job
	 * job = JobLocalServiceUtil.getJob(Long.parseLong(s));
	 * 
	 * log.info(job.getJobId()); actionRequest.setAttribute("editJob", job);
	 * actionResponse.setRenderParameter("jspPage",
	 * "/html/contactdetails/edit_contact_details.jsp"); }
	 */
}
