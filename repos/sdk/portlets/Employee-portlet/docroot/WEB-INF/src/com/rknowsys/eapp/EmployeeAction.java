package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
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
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.model.License;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.util.DateUtils;

public class EmployeeAction extends MVCPortlet {

	public static final String EMPLOYEE_ID = "employeeId";
	public static final String EMPLOYEE_FIRST_NAME_COL_NAME = "firstName";
	public static final String ORDER_TYPE_ASC = "asc";
	public static final String EMPLOYEE_MIDDLE_NAME_COL_NAME = "middleName";
	public static final String EMPLOYEE_LAST_NAME_COL_NAME = "lastName";
	public static final String EMPLOYEE_GENDER = "gender";
	public static final int EMPLOYEE_GENDER_MALE = 0;
	public static final int EMPLOYEE_GENDER_FEMALE = 1;
	public static final String EMPLOYEE_MARITAL_STATUS_COL_NAME = "maritalStatus";
	public static final String EMPLOYEE_NATIONALITY_COL_NAME = "nationality";
	public static final String EMPLOYEE_DATEOFBIRTH_COL_NAME = "dateOfBirth";
	public static final String EMPLOYEE_OTHERID_COL_NAME = "otherId";
	public static final String EMPLOYEE_LICENSE_NUMBER_COL_NAME = "licenseNumber";
	public static final String EMPLOYEE_LICENSE_EXP_DATE_COL_NAME = "licenseExpiryDate";

	private static Logger log = Logger.getLogger(EmployeeAction.class);

	/**
	 * <p>
	 * This method inserts new Employee record in database if the id is not
	 * existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("inside saveEmployee...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		Employee employee = null;
				
		try {

			log.info("employee first name = "
					+ ParamUtil.getString(actionRequest,
							EMPLOYEE_FIRST_NAME_COL_NAME));
			String id = ParamUtil.getString(actionRequest, EMPLOYEE_ID);
			log.info("employee id == " + id);

			Date date = new Date();

			log.info(" myid = " + id);
			if (id == null || id.isEmpty()) {
				log.info("inside if loop...");
				employee = EmployeeLocalServiceUtil
						.createEmployee(CounterLocalServiceUtil.increment());
				setEmployee(actionRequest, themeDisplay, employee, date);
				employee = EmployeeLocalServiceUtil.addEmployee(employee);

				log.info("new emp = " + employee.getEmployeeId());
				actionRequest.setAttribute("employee", employee);
				actionRequest.getPortletSession().setAttribute("LIFERAY_SHARED_employeeId", employee.getEmployeeId(), PortletSession.APPLICATION_SCOPE);
				actionResponse.setRenderParameter("jspPage",
						"/html/employee/edit_employee.jsp");
				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long Employeeid = Long.parseLong(id);

				employee = EmployeeLocalServiceUtil
						.getEmployee(Employeeid);

				setEmployeeForUpdate(actionRequest, themeDisplay, date,
						employee);
				

				employee = EmployeeLocalServiceUtil.updateEmployee(employee);

/*				Attachment attachment1 = AttachmentUtils
						.getEmployeePhotograph(employee1);
				if (f != null) {
					attachment1.setFile(blob);
					attachment1.setSize(uploadRequest.getSize("file"));
					attachment1
							.setAttachmentType(AttachmentUtils.ATTACHMENT_TYPE_EMPLOYEE);
					attachment1.setEmployeeId(employee.getEmployeeId());
					attachment1.setFileType(uploadRequest.getContentType());
					AttachmentLocalServiceUtil.addAttachment(attachment1);
				}

				attachment1 = AttachmentLocalServiceUtil
						.updateAttachment(attachment1);*/

			}
		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		//actionRequest.getPortletSession().setAttribute("LIFERAY_SHARED_employee", employee, PortletSession.APPLICATION_SCOPE);
		actionRequest.setAttribute("employee", employee);
		actionRequest.getPortletSession().setAttribute("LIFERAY_SHARED_employeeId", employee.getEmployeeId(), PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("mvcPath",
				"/html/employee/edit_employee.jsp");
		log.info("employee set in session - " + employee);
		log.info("end of the saveEmployee method");

	}


	private void setEmployeeForUpdate(ActionRequest actionRequest,
			ThemeDisplay themeDisplay, Date date, Employee employee1)
			throws PortalException, SystemException {
		log.info("Inside saveEmployeeForUpdate!");

		employee1.setEmployeeId(ParamUtil.getLong(actionRequest,
				EMPLOYEE_ID));

		employee1.setFirstName(ParamUtil.getString(actionRequest,
				EMPLOYEE_FIRST_NAME_COL_NAME));
		employee1.setMiddleName(ParamUtil.getString(actionRequest,
				EMPLOYEE_MIDDLE_NAME_COL_NAME));
		employee1.setLastName(ParamUtil.getString(actionRequest,
				EMPLOYEE_LAST_NAME_COL_NAME));

		String genderStr = ParamUtil.getString(actionRequest,
				EMPLOYEE_GENDER);
		int gender = 0;
		if (genderStr != null && !genderStr.isEmpty()) {
			gender = Integer.parseInt(genderStr);
		}
		log.info("gender = " + gender);
		if (genderStr != null && !genderStr.isEmpty()) {
			employee1.setGender(gender);
		}

		String maritalStatusStr = ParamUtil.getString(actionRequest,
				EMPLOYEE_MARITAL_STATUS_COL_NAME);
		log.info("Marital Status = " + ParamUtil.getString(actionRequest,
				EMPLOYEE_MARITAL_STATUS_COL_NAME));

		int maritalStatus = 0;
		if (maritalStatusStr !=null && !maritalStatusStr.isEmpty())
		    maritalStatus = Integer.parseInt(maritalStatusStr);
		employee1.setMaritalStatus(maritalStatus);

		String nationalityStr = ParamUtil.getString(actionRequest,
				EMPLOYEE_NATIONALITY_COL_NAME);
		long nation = 0;
		if (nationalityStr != null && !nationalityStr.isEmpty()) {
			nation = Long.parseLong(nationalityStr);
		}
		employee1.setNationalityId(nation);

		Date dob = DateUtils.parse(ParamUtil.getString(actionRequest,
				EMPLOYEE_DATEOFBIRTH_COL_NAME));
		employee1.setDateOfBirth(dob);
		
		employee1.setOtherId(ParamUtil.getString(actionRequest,
				EMPLOYEE_OTHERID_COL_NAME));
		
		log.info("DOB = " + ParamUtil.getString(actionRequest,
				EMPLOYEE_DATEOFBIRTH_COL_NAME));

		employee1.setModifiedDate(date);
		employee1.setCompanyId(themeDisplay.getCompanyId());
		employee1.setGroupId(themeDisplay.getCompanyGroupId());
		employee1.setUserId(themeDisplay.getUserId());
		
		String licenseStr = ParamUtil.getString(actionRequest, 
				EMPLOYEE_LICENSE_NUMBER_COL_NAME);
		log.info("lic number = " + licenseStr);
		License lic = employee1.getLicense();
	    log.info("lic exp date = = " + 
	    		ParamUtil.getString(actionRequest, 
	    				EMPLOYEE_LICENSE_EXP_DATE_COL_NAME));
		if (lic != null){
			log.info("License - if");
		    lic.setLicenseNumber(licenseStr);
		    lic.setExpiryDate(DateUtils.parse(ParamUtil.getString(actionRequest, EMPLOYEE_LICENSE_EXP_DATE_COL_NAME)));
		    LicenseLocalServiceUtil.updateLicense(lic);
		}else{
			log.info("License - else");
			lic = LicenseLocalServiceUtil.createLicense(
					CounterLocalServiceUtil.increment());
		    lic.setLicenseNumber(licenseStr);
		    lic.setExpiryDate(DateUtils.parse(ParamUtil.getString(actionRequest, 
    				EMPLOYEE_LICENSE_EXP_DATE_COL_NAME)));
		    employee1.setLicenseId(LicenseLocalServiceUtil.addLicense(lic).getLicenseId());
		}

	}

	private void setEmployee(ActionRequest actionRequest,
			ThemeDisplay themeDisplay, Employee employee, Date date) {
		employee.setFirstName(ParamUtil.getString(actionRequest,
				EMPLOYEE_FIRST_NAME_COL_NAME));
		log.info("First Name = " + ParamUtil.getString(actionRequest,
				EMPLOYEE_FIRST_NAME_COL_NAME));
		
		employee.setMiddleName(ParamUtil.getString(actionRequest,
				EMPLOYEE_MIDDLE_NAME_COL_NAME));
		log.info("Middle Name = " + ParamUtil.getString(actionRequest,
				EMPLOYEE_MIDDLE_NAME_COL_NAME));
		
		employee.setLastName(ParamUtil.getString(actionRequest,
				EMPLOYEE_LAST_NAME_COL_NAME));
		log.info("Last Name = " + ParamUtil.getString(actionRequest,
				EMPLOYEE_LAST_NAME_COL_NAME));
		employee.setCreateDate(date);
		employee.setModifiedDate(date);
		employee.setCompanyId(themeDisplay.getCompanyId());
		employee.setGroupId(themeDisplay.getCompanyGroupId());
		employee.setUserId(themeDisplay.getUserId());
	}

	/**
	 * <p>
	 * This method deletes the Employee record from database based on Employee
	 * record Id
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
		if (resourceRequest.getResourceID().equals("deleteEmployee")) {

			log.info("inside deleteEmployee... serveResource");
			Employee employee = null;
			try {
				employee = EmployeeLocalServiceUtil
						.createEmployee(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"employeeIds");

			log.info("idsArray== " + idsArray.length);
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info(idsArray[i]);

			}
			for (int i = 0; i <= idsArray.length - 1; i++) {
				log.info(idsArray[i]);
				if (idsArray[i].equals("on")) {
					log.info("All records selected...");
				} else {
					try {
						employee = EmployeeLocalServiceUtil.deleteEmployee(Long
								.parseLong(idsArray[i]));
						log.info("end of try block in delete...");
					} catch (PortalException e) {

						e.printStackTrace();
						log.info("portal exception...");
					} catch (SystemException e) {

						e.printStackTrace();
						log.info("system exception...");
					}
				}

			}
			log.info("end of for loop..");

		}
		log.info("end of deleteEmployee method...");

	}

	/**
	 * <p>
	 * This method gets the single Employee record from database based on the
	 * given Employee Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single Employee record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editEmployee(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("inside editEmployee...");
		String s = ParamUtil.getString(actionRequest, EMPLOYEE_ID);
		log.info("employeeId == " + s);
		Employee employee = EmployeeLocalServiceUtil.getEmployee(Long
				.parseLong(s));

		log.info(employee.getEmployeeId());
		log.info(employee.getFirstName());
		log.info(employee.getLicense().getExpiryDate());
		log.info(employee.getDateOfBirth());
		//actionRequest.getPortletSession().setAttribute("LIFERAY_SHARED_employee", employee, PortletSession.APPLICATION_SCOPE);
		actionRequest.setAttribute("employee", employee);
		actionRequest.getPortletSession().setAttribute("LIFERAY_SHARED_employeeId", employee.getEmployeeId(), PortletSession.APPLICATION_SCOPE);
		// actionResponse.setRenderParameter("jspPage",
		// "/html/employee/edit_employee.jsp");
	}

}
