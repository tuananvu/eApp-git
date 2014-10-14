package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmpContactDetails;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.model.License;
import com.rknowsys.eapp.hrm.model.Location;
import com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;

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
	public void saveEmpDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("saveEmployeeDetails method");
		String location = ParamUtil.getString(actionRequest, "location");
		String firstName = ParamUtil.getString(actionRequest,
				EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(actionRequest,
				EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(actionRequest,
				EMPLOYEE_LAST_NAME_COL_NAME);
		DynamicQuery locationDynamicQuery = DynamicQueryFactoryUtil.forClass(
				Location.class, PortletClassLoaderUtil.getClassLoader());
		locationDynamicQuery.add(PropertyFactoryUtil.forName("name").eq(
				location));
		List<Location> l = LocationLocalServiceUtil
				.dynamicQuery(locationDynamicQuery);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		Employee employee = null;
		EmpPersonalDetails empPersonalDetails = null;
		employee = EmployeeLocalServiceUtil
				.createEmployee(CounterLocalServiceUtil.increment());
		employee.setLocationId(l.get(0).getLocationId());
		employee.setUserId(themeDisplay.getUserId());
		employee.setCompanyId(themeDisplay.getCompanyId());
		employee.setCreateDate(date);
		employee.setModifiedDate(date);
		EmployeeLocalServiceUtil.addEmployee(employee);
		empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
				.createEmpPersonalDetails(CounterLocalServiceUtil.increment());
		empPersonalDetails.setEmployeeId(employee.getPrimaryKey());
		empPersonalDetails.setFirstName(firstName);
		empPersonalDetails.setMiddleName(middleName);
		empPersonalDetails.setLastName(lastName);
		empPersonalDetails.setUserId(themeDisplay.getUserId());
		empPersonalDetails.setCompanyId(themeDisplay.getCompanyId());
		empPersonalDetails.setCreateDate(date);
		empPersonalDetails.setModifiedDate(date);
		EmpPersonalDetailsLocalServiceUtil
				.addEmpPersonalDetails(empPersonalDetails);
		actionRequest.getPortletSession().setAttribute("empId",
				String.valueOf(employee.getEmployeeId()),
				PortletSession.APPLICATION_SCOPE);
		// actionRequest.setAttribute("empId",
		// String.valueOf(employee.getEmployeeId()));
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");
	}

	public void updateEmpPersonalDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		String firstName = ParamUtil.getString(actionRequest,
				EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(actionRequest,
				EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(actionRequest,
				EMPLOYEE_LAST_NAME_COL_NAME);
		long empId = ParamUtil.getLong(actionRequest, "personalDetailsId");
		EmpPersonalDetails empPersonalDetails = null;
		System.out.println("first name and last anme are" + " " + firstName
				+ " " + lastName + " " + empId);

		try {
			empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
					.getEmpPersonalDetails(empId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (empPersonalDetails != null) {
			empPersonalDetails.setFirstName(firstName);
			empPersonalDetails.setMiddleName(middleName);
			empPersonalDetails.setLastName(lastName);
			try {
				EmpPersonalDetailsLocalServiceUtil
						.updateEmpPersonalDetails(empPersonalDetails);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String jsp = "edit_employee";
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("LIFERAY_SHARED_jspPage", jsp,
				PortletSession.APPLICATION_SCOPE);
		/*actionResponse.setRenderParameter("jspPage",
				"/html/employee/edit_employee.jsp");*/
	}

	public void updateEmpContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException {
		String addressStreet1 = ParamUtil.getString(actionRequest,
				"address_stree1");
		String addressStreet2 = ParamUtil.getString(actionRequest,
				"address_stree2");
		Long empId = ParamUtil.getLong(actionRequest, "empId");
		DynamicQuery contactDetailsDynamicQuery = DynamicQueryFactoryUtil
				.forClass(EmpContactDetails.class,
						PortletClassLoaderUtil.getClassLoader());
		contactDetailsDynamicQuery.add(PropertyFactoryUtil
				.forName("employeeId").eq(empId));
		List<EmpContactDetails> l = null;
		try {
			l = EmpContactDetailsLocalServiceUtil
					.dynamicQuery(contactDetailsDynamicQuery);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmpContactDetails empContactDetails = null;
		if (l.size() == 0) {
			try {
				empContactDetails = EmpContactDetailsLocalServiceUtil
						.createEmpContactDetails(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empContactDetails.setAddressStreet1(addressStreet1);
			empContactDetails.setAddressStreet2(addressStreet2);
			try {
				EmpContactDetailsLocalServiceUtil
						.addEmpContactDetails(empContactDetails);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				empContactDetails = EmpContactDetailsLocalServiceUtil
						.getEmpContactDetails(empId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empContactDetails.setAddressStreet1(addressStreet1);
			empContactDetails.setAddressStreet2(addressStreet2);
			try {
				EmpContactDetailsLocalServiceUtil
						.updateEmpContactDetails(empContactDetails);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String jsp = "emp_contact_details";
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.setAttribute("LIFERAY_SHARED_jspPage", jsp,
				PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage",
				"/html/employee/emp_contact_details.jsp");
		//actionResponse.sendRedirect(redirectTo);
	}
	public void updateContactDetails(ActionRequest actionRequest,ActionResponse actionResponse)
	throws PortletException,IOException
	{
		String emergencyName=ParamUtil.getString(actionRequest, "emg_name");
		System.out.println("updating emegergency contact details:updateContactDetails method");
		System.out.println("emergency name is"+ParamUtil.getString(actionRequest, "emg_name"));
	}
	public void updateAssignedDependents(ActionRequest actionRequest,
			ActionResponse actioResponse)throws PortletException,IOException
			{
			System.out.println("updating dependents");
			System.out.println("dependent name is"+ParamUtil.getString(actionRequest, "dependent_name"));
			}
}
