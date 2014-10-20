package com.rknowsys.eapp;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.EmpContactDetails;
import com.rknowsys.eapp.hrm.model.EmpDependent;
import com.rknowsys.eapp.hrm.model.EmpEmergencyContact;
import com.rknowsys.eapp.hrm.model.EmpImmigrationDocument;
import com.rknowsys.eapp.hrm.model.EmpPersonalDetails;
import com.rknowsys.eapp.hrm.model.EmpSupervisor;
import com.rknowsys.eapp.hrm.model.Employee;
import com.rknowsys.eapp.hrm.model.Location;
import com.rknowsys.eapp.hrm.model.PayGradeCurrency;
import com.rknowsys.eapp.hrm.service.EmpContactDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpDependentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpEmergencyContactLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpImmigrationDocumentLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpPersonalDetailsLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmpSupervisorLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.LocationLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.PayGradeCurrencyLocalServiceUtil;
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
	public void saveEmpDetails(ActionRequest actionRequest,ActionResponse actionResponse) 
			throws IOException,PortletException, SystemException {
		log.info("saveEmployeeDetails method");
		addEmployee(actionRequest,actionResponse);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void updateEmpPersonalDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		//updatePersonalDetails(actionRequest,actionResponse);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Long empId=ParamUtil.getLong(actionRequest, "perEmpId");
		String firstName = ParamUtil.getString(actionRequest,EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(actionRequest,EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(actionRequest,EMPLOYEE_LAST_NAME_COL_NAME);
		String empNo=ParamUtil.getString(actionRequest, "employee_no");
		String otherId=ParamUtil.getString(actionRequest, "other_id");
		String driverLicenseNo=ParamUtil.getString(actionRequest, "driver_license_no");
		Date expiryDate=ParamUtil.getDate(actionRequest, "expiry_date", dateFormat);
		String gender=ParamUtil.getString(actionRequest, "gender");
		String maritalStatus=ParamUtil.getString(actionRequest, "marital_status");
		String nationality=ParamUtil.getString(actionRequest, "emp_nationality");
		Date dateOfB=ParamUtil.getDate(actionRequest, "date_of_birth", dateFormat);
		long perEmpId = ParamUtil.getLong(actionRequest, "personalDetailsId");
		EmpPersonalDetails empPersonalDetails = null;
		log.info("first name and last anme are" + " " + firstName
				+ " " + lastName + " " + empId);
		try {
			empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
					.getEmpPersonalDetails(perEmpId);
		} catch (PortalException e) {
		
			e.printStackTrace();
		} catch (SystemException e) {
		
			e.printStackTrace();
		}
		if (empPersonalDetails != null) {
			empPersonalDetails.setFirstName(firstName);
			empPersonalDetails.setMiddleName(middleName);
			empPersonalDetails.setLastName(lastName);
			empPersonalDetails.setDateOfBirth(dateOfB);
			empPersonalDetails.setEmployeeId(empId);
			empPersonalDetails.setEmployeeNo(empNo);
			empPersonalDetails.setGender(Long.parseLong(gender));
			empPersonalDetails.setLicenseExpDate(expiryDate);
			empPersonalDetails.setLicenseNo(driverLicenseNo);
			empPersonalDetails.setOtherId(otherId);
			empPersonalDetails.setMaritalStatus(1);
			
			try {
				EmpPersonalDetailsLocalServiceUtil
						.updateEmpPersonalDetails(empPersonalDetails);
			} catch (SystemException e) {
			
				e.printStackTrace();
			}
		}
			Map map=new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp1");
			actionRequest.getPortletSession(true).setAttribute("empId",
					map,PortletSession.APPLICATION_SCOPE);
		log.info("updateEmpPersonalDetails method");
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void addOrUpdateEmpContactDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortletException, IOException,SystemException {
		log.info("update or add Employee contact details:in updateEmpContactDetails method");
		Long contactDetailsId=ParamUtil.getLong(actionRequest, "conDetailsId");
		String addressStreet1 = ParamUtil.getString(actionRequest,
				"address_street1");
		String addressStreet2 = ParamUtil.getString(actionRequest,
				"address_street2");
		String city=ParamUtil.getString(actionRequest, "city");
		String state=ParamUtil.getString(actionRequest, "state");
		String zip=ParamUtil.getString(actionRequest, "zip");
		String country=ParamUtil.getString(actionRequest, "country");
		String homeTele=ParamUtil.getString(actionRequest, "home_telephone");
		String workTele=ParamUtil.getString(actionRequest, "work_telephone");
		String mobile=ParamUtil.getString(actionRequest, "mobile");
		String workMail=ParamUtil.getString(actionRequest, "work_email");
		String otherMail=ParamUtil.getString(actionRequest, "other_email");
		Long empId = ParamUtil.getLong(actionRequest, "conEmpId");
		System.out.println(addressStreet1+addressStreet2+empId);
		DynamicQuery contactDetailsDynamicQuery = DynamicQueryFactoryUtil
				.forClass(EmpContactDetails.class,
						PortletClassLoaderUtil.getClassLoader());
		contactDetailsDynamicQuery.add(PropertyFactoryUtil
				.forName("employeeId").eq(empId));
		List<EmpContactDetails> l = null;
		try {
			l = EmpContactDetailsLocalServiceUtil.dynamicQuery(contactDetailsDynamicQuery);
		  } catch (SystemException e) {
			e.printStackTrace();
		    }
		EmpContactDetails empContactDetails = null;
		if (l.size() == 0) {
			try {
				empContactDetails = EmpContactDetailsLocalServiceUtil
						.createEmpContactDetails(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e) {
				e.printStackTrace();
			}
			empContactDetails.setAddressStreet1(addressStreet1);
			empContactDetails.setAddressStreet2(addressStreet2);
			empContactDetails.setCity(city);
			empContactDetails.setCountry(country);
			empContactDetails.setHomeTelephone(homeTele);
			empContactDetails.setMobile(mobile);
			empContactDetails.setOtherEmail(otherMail);
			empContactDetails.setState(state);
			empContactDetails.setOtherEmail(otherMail);
			empContactDetails.setPostalCode(zip);
			empContactDetails.setWorkEmail(workMail);
			empContactDetails.setWorkTelephone(workTele);
			empContactDetails.setEmployeeId(empId);
			try {
				EmpContactDetailsLocalServiceUtil
						.addEmpContactDetails(empContactDetails);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else {
			try {
				empContactDetails = EmpContactDetailsLocalServiceUtil
						.getEmpContactDetails(l.get(0).getEmpContactDetailsId());
			} catch (PortalException e) {
			
				e.printStackTrace();
			} catch (SystemException e) {
			
				e.printStackTrace();
			}
			empContactDetails.setAddressStreet1(addressStreet1);
			empContactDetails.setAddressStreet2(addressStreet2);
			empContactDetails.setCity(city);
			empContactDetails.setCountry(country);
			empContactDetails.setHomeTelephone(homeTele);
			empContactDetails.setMobile(mobile);
			empContactDetails.setOtherEmail(otherMail);
			empContactDetails.setState(state);
			empContactDetails.setOtherEmail(otherMail);
			empContactDetails.setPostalCode(zip);
			empContactDetails.setWorkEmail(workMail);
			empContactDetails.setWorkTelephone(workTele);
			try {
				EmpContactDetailsLocalServiceUtil
						.updateEmpContactDetails(empContactDetails);
			} catch (SystemException e) {
			
				e.printStackTrace();
			}
		}
		Map map=new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp2");
		actionRequest.getPortletSession(true).setAttribute("empId",
				map,PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void updateContactDetails(ActionRequest actionRequest,ActionResponse actionResponse)
	throws PortletException,IOException
		{
		System.out.println("updating emegergency contact details:updateContactDetails method");
		long empId=ParamUtil.getLong(actionRequest, "emgEmpId");
		String emergencyName=ParamUtil.getString(actionRequest, "emg_name");
		String relationship=ParamUtil.getString(actionRequest, "emg_relationship");
		String homeTele=ParamUtil.getString(actionRequest, "emg_hm_telephone");
		String mobile=ParamUtil.getString(actionRequest, "emg_mobile");
		String workTele=ParamUtil.getString(actionRequest, "emg_work_telephone");
		System.out.println("emergency name is"+ParamUtil.getString(actionRequest, "emg_name"));
		EmpEmergencyContact empEmergencyContact=null;
		try {
			empEmergencyContact=EmpEmergencyContactLocalServiceUtil.
					createEmpEmergencyContact(CounterLocalServiceUtil.increment());
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		empEmergencyContact.setEmployeeId(empId);
		empEmergencyContact.setHomeTelephone(homeTele);
		empEmergencyContact.setMobile(mobile);
		empEmergencyContact.setRelationship(relationship);
		empEmergencyContact.setName(emergencyName);
		empEmergencyContact.setWorkTelephone(workTele);
		try {
			EmpEmergencyContactLocalServiceUtil.addEmpEmergencyContact(empEmergencyContact);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map=new HashMap();
		map.put("empId", empEmergencyContact.getEmployeeId());
		map.put("jsp", "jsp3");
		actionRequest.getPortletSession(true).setAttribute("empId",
				 map,PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void updateAssignedDependents(ActionRequest actionRequest,
		ActionResponse actionResponse)throws PortletException,IOException
		{
		System.out.println("updating dependents");
		System.out.println("dependent name is"+ParamUtil.getString(actionRequest, "dependent_name"));
		String name=ParamUtil.getString(actionRequest, "dependent_name");
		String relation=ParamUtil.getString(actionRequest, "dependent_relationship");
		Long empId=ParamUtil.getLong(actionRequest, "empDependentId");
		EmpDependent empDependent=null;
		try {
				empDependent=EmpDependentLocalServiceUtil.createEmpDependent(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		empDependent.setEmployeeId(empId);
		empDependent.setName(name);
		empDependent.setRelationship(relation);
			try {
				EmpDependentLocalServiceUtil.addEmpDependent(empDependent);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map map=new HashMap();
			map.put("empId", empDependent.getEmployeeId());
			map.put("jsp", "jsp4");
			actionRequest.getPortletSession(true).setAttribute("empId",
					 map,PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		
		}
	public void addReportToEmp(ActionRequest actionRequest,ActionResponse actionResponse)throws PortletException,IOException
	{
		 String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		 System.out.println("Constants.CMD: " + cmd);
		 String reportTo="",reportingMethod="";
		 Long empId=0l;
		 
		 if (cmd.equals("sup_add")) {
	     empId=ParamUtil.getLong(actionRequest, "empSupId");
		 reportTo=ParamUtil.getString(actionRequest, "report_sup_name");
		 reportingMethod=ParamUtil.getString(actionRequest, "reporting_sup_method");
		 EmpSupervisor empSupervisor=null;
			 try {
				empSupervisor=EmpSupervisorLocalServiceUtil.createEmpSupervisor(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Map map=new HashMap();
				map.put("empId", empId);
				map.put("jsp", "jsp6");
				actionRequest.getPortletSession(true).setAttribute("empId",
						 map,PortletSession.APPLICATION_SCOPE);
				actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		 }
		 else
		 {   empId=ParamUtil.getLong(actionRequest, "empSubId");
			 reportTo=ParamUtil.getString(actionRequest, "report_sub_name");
			 reportingMethod=ParamUtil.getString(actionRequest, "reporting_sub_method");
			 Map map=new HashMap();
				map.put("empId", empId);
				map.put("jsp", "jsp6");
				actionRequest.getPortletSession(true).setAttribute("empId",
						 map,PortletSession.APPLICATION_SCOPE);
				actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
			 
		 }
	}
	public void addQualifications(ActionRequest actionRequest,ActionResponse actionResponse)
		throws PortletException,IOException
		{
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		Long empId=0l;
		 System.out.println("Constants.CMD: " + cmd);
		 if (cmd.equals("empExperience")) {
			 log.info("updating employee work experience");
			 empId=ParamUtil.getLong(actionRequest, "empWrkExpId");
		 }
		if (cmd.equals("empEducation")) {
			 log.info("updating employee education");
			 empId=ParamUtil.getLong(actionRequest, "empEduId");
		 }
		 if (cmd.equals("empSkills")) {
			 log.info("updating employee skills");
			 empId=ParamUtil.getLong(actionRequest, "empSkillId");
		 }
		 if (cmd.equals("empLanguage")) {
			 log.info("updating employee language");
			 empId=ParamUtil.getLong(actionRequest, "empLanId");
		 }
		if (cmd.equals("empLicense")) {
			 log.info("updating employee license");
			 empId=ParamUtil.getLong(actionRequest, "empLicId");
		 }
		 Map map=new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp7");
			actionRequest.getPortletSession(true).setAttribute("empId",
					 map,PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void updateEmpSalaryDetails(ActionRequest actionRequest,ActionResponse actionResponse)
		throws PortletException,IOException
		{
		System.out.println("in updateEmpSalaryDetails method");
		long empId=ParamUtil.getLong(actionRequest, "empSalId");
		 Map map=new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp10");
			actionRequest.getPortletSession(true).setAttribute("empId",
					 map,PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void updateEmpDirectDeposits(ActionRequest actionRequest,ActionResponse actionResponse)
		throws IOException,PortletException
		{
		System.out.println("in updateEmpDirectDeposits method ");
		long empId=ParamUtil.getLong(actionRequest, "empDirId");
		 Map map=new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp11");
			actionRequest.getPortletSession(true).setAttribute("empId",
					 map,PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void addImmigrationDetails(ActionRequest actionRequest,ActionResponse actionResponse)
		throws IOException,PortletException
		{
		System.out.println("in addImmigrationDetails method");
		long empId=ParamUtil.getLong(actionRequest, "empImgId");
		String number=ParamUtil.getString(actionRequest, "img_number");
		String issuedDate=ParamUtil.getString(actionRequest, "img_issued_date");
		String issuedBy=ParamUtil.getString(actionRequest, "img_exp_date");
		String eligibleStatus=ParamUtil.getString(actionRequest, "eligible_status");
		String reviewDate=ParamUtil.getString(actionRequest, "review_date");
		String comments=ParamUtil.getString(actionRequest, "img_comments");
		EmpImmigrationDocument empImmigrationDocument=null;
			try {
				empImmigrationDocument=
						EmpImmigrationDocumentLocalServiceUtil.createEmpImmigrationDocument(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		empImmigrationDocument.setEmployeeId(empId);
		empImmigrationDocument.setDocNumber(number);
		empImmigrationDocument.setIssuedBy(issuedBy);
		empImmigrationDocument.setIssuedDate(new Date());
		empImmigrationDocument.setComments(comments);
			try {
				EmpImmigrationDocumentLocalServiceUtil.addEmpImmigrationDocument(empImmigrationDocument);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map map=new HashMap();
			map.put("empId", empImmigrationDocument.getEmployeeId());
			map.put("jsp", "jsp5");
			actionRequest.getPortletSession(true).setAttribute("empId",
					 map,PortletSession.APPLICATION_SCOPE);
			actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void updateMembership(ActionRequest actionRequest,ActionResponse actionResponse)
		throws IOException,PortletException
		{
		System.out.println("in updateMembership method");
		long empId=ParamUtil.getLong(actionRequest, "empMemId");
		Map map=new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp8");
		actionRequest.getPortletSession(true).setAttribute("empId",
				 map,PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void updateEmpJobHistory(ActionRequest actionRequest,ActionResponse actionResponse)
		{
		System.out.println("in updateEmpJobHistory method");
		long empId=ParamUtil.getLong(actionRequest, "empJId");
		Map map=new HashMap();
		map.put("empId", empId);
		map.put("jsp", "jsp9");
		actionRequest.getPortletSession(true).setAttribute("empId",
				 map,PortletSession.APPLICATION_SCOPE);
		actionResponse.setRenderParameter("jspPage","/html/employee/edit_employee.jsp");
		}
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)
	       throws IOException,PortletException
	       {
		if (resourceRequest.getResourceID().equals("supervisorsAutoComplete"))
				{
			 List<EmpPersonalDetails> l=null;
				 try {
					l=EmpPersonalDetailsLocalServiceUtil.getEmpPersonalDetailses(-1, -1);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			String userEnteredText=ParamUtil.getString(resourceRequest, "userEnteredText");
			 JSONArray usersJSONArray = JSONFactoryUtil.createJSONArray();
			 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			 System.out.println("=====00000========" + userEnteredText);
			 DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(EmpPersonalDetails.class,
			 PortletClassLoaderUtil.getClassLoader());
			 Criterion criterion = RestrictionsFactoryUtil.like("firstName",
			 StringPool.PERCENT + userEnteredText + StringPool.PERCENT);
			 userQuery.add(criterion);
			 JSONObject userJSON = null;
			 System.out.println("=====1111========" + userQuery.toString());
			 try {
			 List<EmpPersonalDetails> userList = EmpPersonalDetailsLocalServiceUtil.dynamicQuery(userQuery);
			 System.out.println("=====222========" + userList.size());
			 for (EmpPersonalDetails personalDetails : userList) {
			 userJSON = JSONFactoryUtil.createJSONObject();
			 userJSON.put("firstName", personalDetails.getFirstName());
			 System.out.println(personalDetails.getFirstName());
			 usersJSONArray.put(userJSON);
			 }} catch (Exception e) {
			 }
			 PrintWriter out = resourceResponse.getWriter();
			 out.println(usersJSONArray.toString());
				}
		if (resourceRequest.getResourceID().equals("dependencyDropdown"))
		{
		System.out.println("dependencyDropDowns");
		String currency=ParamUtil.getString(resourceRequest,"dropDownValue");
		System.out.println(currency);
		DynamicQuery currencyDynamicQuery = DynamicQueryFactoryUtil
				.forClass(PayGradeCurrency.class,
						PortletClassLoaderUtil.getClassLoader());
		currencyDynamicQuery.add(PropertyFactoryUtil
				.forName("payGradeId").eq(Long.parseLong(currency)));
		List<PayGradeCurrency> list = null;
		try {
			list = PayGradeCurrencyLocalServiceUtil.dynamicQuery(currencyDynamicQuery);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		 JSONArray currencyJsonArray=null;
		if(list!=null)
		{
			 currencyJsonArray=JSONFactoryUtil.createJSONArray();
			 for(int i=0;i<list.size();i++)
			 {
				 PayGradeCurrency currencyObj=list.get(i);
			 currencyJsonArray.put(currencyObj.getCurrency());
			 }
		}
		 PrintWriter out=resourceResponse.getWriter();
		 System.out.println(currencyJsonArray.toString());
		 out.write(currencyJsonArray.toString());
		}
	       }
public void addEmployee(ActionRequest actionRequest,ActionResponse actionResponse) 
		throws IOException,PortletException, SystemException
		{
		String location = ParamUtil.getString(actionRequest, "location");
		String firstName = ParamUtil.getString(actionRequest,
				            EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(actionRequest,
				           EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(actionRequest,
				           EMPLOYEE_LAST_NAME_COL_NAME);
		String empNo=ParamUtil.getString(actionRequest, "employee_no");
		String username=ParamUtil.getString(actionRequest, "user_name");
		String password=ParamUtil.getString(actionRequest, "password");
		String email=ParamUtil.getString(actionRequest,"email");
		EmpContactDetails empContactDetails=null;
		DynamicQuery locationDynamicQuery = DynamicQueryFactoryUtil.forClass(Location.class,
				PortletClassLoaderUtil.getClassLoader());
		locationDynamicQuery.add(PropertyFactoryUtil.forName("name").eq(location));
		List<Location> l = LocationLocalServiceUtil.dynamicQuery(locationDynamicQuery);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		Employee employee = null;
		EmpPersonalDetails empPersonalDetails = null;
		
		employee = EmployeeLocalServiceUtil
				.createEmployee(CounterLocalServiceUtil.increment());
		if (l.size() != 0) {
			employee.setLocationId(l.get(0).getLocationId());
		}
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
		empPersonalDetails.setEmployeeNo(empNo);
		empPersonalDetails.setUserId(themeDisplay.getUserId());
		empPersonalDetails.setCompanyId(themeDisplay.getCompanyId());
		empPersonalDetails.setCreateDate(date);
		empPersonalDetails.setModifiedDate(date);
		EmpPersonalDetailsLocalServiceUtil
				.addEmpPersonalDetails(empPersonalDetails);
		if(username!=null || password!=null )
		{
			User user=null;
			try
			{
	    user=UserLocalServiceUtil.createUser(CounterLocalServiceUtil.increment());
		user.setFirstName(username);
		user.setScreenName(username);
		user.setEmailAddress(email);
		user.setPassword(password);
		UserLocalServiceUtil.addUser(user);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("user creation failed");
			}
			if(user!=null)
			{
		empContactDetails=
				EmpContactDetailsLocalServiceUtil.createEmpContactDetails(CounterLocalServiceUtil.increment());
		empContactDetails.setUserId(user.getUserId());
		empContactDetails.setUserName(user.getFirstName());
		empContactDetails.setCreateDate(new Date());
		empContactDetails.setEmployeeId(employee.getGroupId());
		EmpContactDetailsLocalServiceUtil.addEmpContactDetails(empContactDetails);
			}
		}	
		Map map=new HashMap();
		map.put("empId", employee.getEmployeeId());
		map.put("jsp", "jsp0");
		actionRequest.getPortletSession(true).setAttribute("empId",
				 map,PortletSession.APPLICATION_SCOPE);
		
      }
public void updatePersonalDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		Long empId=ParamUtil.getLong(actionRequest, "perEmpId");
		String firstName = ParamUtil.getString(actionRequest,EMPLOYEE_FIRST_NAME_COL_NAME);
		String middleName = ParamUtil.getString(actionRequest,EMPLOYEE_MIDDLE_NAME_COL_NAME);
		String lastName = ParamUtil.getString(actionRequest,EMPLOYEE_LAST_NAME_COL_NAME);
		String empNo=ParamUtil.getString(actionRequest, "employee_no");
		String otherId=ParamUtil.getString(actionRequest, "other_id");
		String driverLicenseNo=ParamUtil.getString(actionRequest, "driver_license_no");
		Date expiryDate=ParamUtil.getDate(actionRequest, "expiry_date", null);
		String gender=ParamUtil.getString(actionRequest, "gender");
		String maritalStatus=ParamUtil.getString(actionRequest, "marital_status");
		String nationality=ParamUtil.getString(actionRequest, "emp_nationality");
		Date dateOfB=ParamUtil.getDate(actionRequest, "date_of_birth", null);
		long perEmpId = ParamUtil.getLong(actionRequest, "personalDetailsId");
		EmpPersonalDetails empPersonalDetails = null;
		log.info("first name and last anme are" + " " + firstName
				+ " " + lastName + " " + empId);
		try {
			empPersonalDetails = EmpPersonalDetailsLocalServiceUtil
					.getEmpPersonalDetails(perEmpId);
		} catch (PortalException e) {
		
			e.printStackTrace();
		} catch (SystemException e) {
		
			e.printStackTrace();
		}
		if (empPersonalDetails != null) {
			empPersonalDetails.setFirstName(firstName);
			empPersonalDetails.setMiddleName(middleName);
			empPersonalDetails.setLastName(lastName);
			empPersonalDetails.setDateOfBirth(dateOfB);
			empPersonalDetails.setEmployeeNo(empNo);
			empPersonalDetails.setGender(Long.parseLong(gender));
			empPersonalDetails.setLicenseExpDate(expiryDate);
			empPersonalDetails.setLicenseNo(driverLicenseNo);
			empPersonalDetails.setOtherId(otherId);
			empPersonalDetails.setMaritalStatus(1);
			
			try {
				EmpPersonalDetailsLocalServiceUtil
						.updateEmpPersonalDetails(empPersonalDetails);
			} catch (SystemException e) {
			
				e.printStackTrace();
			}
			Map map=new HashMap();
			map.put("empId", empId);
			map.put("jsp", "jsp2");
			actionRequest.getPortletSession(true).setAttribute("empId",
					map,PortletSession.APPLICATION_SCOPE);
		}
      }
public void addContactDetails(ActionRequest actionRequest,ActionResponse actionResponse) 
		throws IOException,PortletException, SystemException
		{
		}
}