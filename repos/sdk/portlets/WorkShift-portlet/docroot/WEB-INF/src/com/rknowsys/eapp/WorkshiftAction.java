package com.rknowsys.eapp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
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
import com.rknowsys.eapp.hrm.model.Workshift;
import com.rknowsys.eapp.hrm.service.EmployeeLocalServiceUtil;
import com.rknowsys.eapp.hrm.service.WorkshiftLocalServiceUtil;

public class WorkshiftAction extends MVCPortlet {

	public static final String WORKSHIFT_ID = "shiftId";

	private static Logger log = Logger.getLogger(WorkshiftAction.class);
	

	/**
	 * <p>
	 * This method inserts new Workshift record in database if the id is not
	 * existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveWorkshift(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		
		
		log.info("inside saveWorkshift...");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
		Workshift workshift =null;
		try {
			log.info("workshift = "
					+ ParamUtil.getString(actionRequest,
							CustomComparatorUtil.WORKSHIFT_COL_NAME));
			String id = ParamUtil.getString(actionRequest, WORKSHIFT_ID);
			log.info("id == " + id);
            ParamUtil.print(actionRequest);
            String[] availableEmpsIds = ParamUtil.getParameterValues(actionRequest,"lstBox1");	
            String[] assignedEmpsIds = ParamUtil.getParameterValues(actionRequest,"lstBox2");					
            log.info("availableEmpsIds ====" + Arrays.toString(availableEmpsIds));
            log.info("assignedEmpsIds ====" + Arrays.toString(assignedEmpsIds));
			
			
			Date date = new Date();
			if (id == null|| id.isEmpty() ) {
				log.info("inside if loop...");

				workshift = WorkshiftLocalServiceUtil
						.createWorkshift(CounterLocalServiceUtil.increment());
				
				setWorkShift(actionRequest, themeDisplay, formater, workshift,
						date);
				workshift = WorkshiftLocalServiceUtil.addWorkshift(workshift);

				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long shiftid = Long.parseLong(id);

				workshift = WorkshiftLocalServiceUtil
						.getWorkshift(shiftid);

				setWorkShift(actionRequest, themeDisplay, formater, workshift,
						date);
				
				workshift = WorkshiftLocalServiceUtil
						.updateWorkshift(workshift);
				
				//To handle move from Assigned emps to Available emps select items
				if (availableEmpsIds != null && availableEmpsIds.length>0){
					log.info("availableEmpsIds.length == " + availableEmpsIds.length);
					for (String employeeId:availableEmpsIds) {
						log.info(employeeId);
						if (employeeId != null && !employeeId.isEmpty()) {
							Employee employee = EmployeeLocalServiceUtil
									.getEmployee(Long.parseLong(employeeId));
							log.info("employee ===== " + employee);
							if (employee !=null){
								log.info("employee to update = " + employee);
								employee.setShiftId(0);
							    EmployeeLocalServiceUtil.updateEmployee(employee);
							}
						}
					}
				}
				log.info("end of else block");

			}

			if (assignedEmpsIds != null && assignedEmpsIds.length>0){
				log.info("assignedEmpsIds.length == " + assignedEmpsIds.length);
				for (String empId: assignedEmpsIds) {
					log.info(empId);
					if (empId != null && !empId.isEmpty()) {
						Employee employee = EmployeeLocalServiceUtil
								.getEmployee(Long.parseLong(empId));
						log.info("employee ===== " + employee);
						if (employee !=null){
							log.info("employee to update = " + employee);
							employee.setShiftId(workshift.getShiftId());
						    EmployeeLocalServiceUtil.updateEmployee(employee);
						}
					}
				}
			}
			

		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
/*//		actionResponse.setRenderParameter("mvcPath",
//				"/html/workshift/addworkshift.jsp");
		
		actionResponse.setRenderParameter("jspPage",
				"/html/workshift/addworkshift.jsp");*/

		log.info("end of the saveWorkshift method");
	}

	private void setWorkShift(ActionRequest actionRequest,
			ThemeDisplay themeDisplay, SimpleDateFormat formater,
			Workshift workshift, Date date) {
		workshift.setWorkshiftName(ParamUtil.getString(actionRequest,
				CustomComparatorUtil.WORKSHIFT_COL_NAME));

		workshift.setFromWorkHours(ParamUtil.getDate(actionRequest,
				"fromWorkHours", formater));
		log.info("fromWorkHours  as str = "
				+ ParamUtil.getString(actionRequest, "fromWorkHours"));
		log.info("toWorkHours as str = "
				+ ParamUtil.getString(actionRequest, "toWorkHours"));
		workshift.setToWorkHours(ParamUtil.getDate(actionRequest,
				"toWorkHours", formater));
		log.info("toWorkHours = "
				+ ParamUtil.getDate(actionRequest, "toWorkHours",
						formater));

		workshift.setCreateDate(date);
		workshift.setModifiedDate(date);
		workshift.setCompanyId(themeDisplay.getCompanyId());
		workshift.setGroupId(themeDisplay.getCompanyGroupId());
		workshift.setUserId(themeDisplay.getUserId());
	}

	/**
	 * <p>
	 * This method deletes the Workshift record from database based on Workshift
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
		if (resourceRequest.getResourceID().equals("deleteWorkshift")) {

			log.info("inside deleteWorkshift... serveResource");
			Workshift workshift;
			try {
				workshift = WorkshiftLocalServiceUtil
						.createWorkshift(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			ParamUtil.print(resourceRequest);
			String[] assignedEmpsIds = ParamUtil.getParameterValues(resourceRequest,
					"workshiftIds");

			log.info("assignedEmpsIds== " + assignedEmpsIds.length);
			for (int i = 0; i <= assignedEmpsIds.length - 1; i++) {
				log.info(assignedEmpsIds[i]);

			}
			for (int i = 0; i <= assignedEmpsIds.length - 1; i++) {
				log.info(assignedEmpsIds[i]);
				if (assignedEmpsIds[i].equals("on")) {
					log.info("All records selected...");
				} else {
					try {
						workshift = WorkshiftLocalServiceUtil
								.deleteWorkshift(Long.parseLong(assignedEmpsIds[i]));
						List<Employee> employees = workshift.getEmployees();
						for (Employee e : employees){
							e.setShiftId(0);
						    EmployeeLocalServiceUtil.updateEmployee(e);
						}
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
		log.info("end of deleteWorkshift method...");

	}

	/**
	 * <p>
	 * This method gets the single Workshift record from database based on the
	 * given Workshift Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single Workshift record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editWorkshift(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		log.info("inside editWorkshift...");
		String s = ParamUtil.getString(actionRequest, WORKSHIFT_ID);
		log.info("shiftId == " + s);
		Workshift ws = WorkshiftLocalServiceUtil
				.getWorkshift(Long.parseLong(s));
		
//		List<Employee> allEmployees = EmployeeLocalServiceUtil.getEmployees(0, EmployeeLocalServiceUtil.getEmployeesCount());
		List<Employee> shiftEmployees = ws.getEmployees();
//		List<Employee> allocatedEmployees =new ArrayList<Employee>();
		
/*		
		List<Workshift> allWorkshifts = WorkshiftLocalServiceUtil.getWorkshifts(0, WorkshiftLocalServiceUtil.getWorkshiftsCount());
		for (Workshift workshift :allWorkshifts ) {
			allocatedEmployees.addAll(EmployeeLocalServiceUtil.getWorkshiftEmployees(workshift.getShiftId()));
//			for (Employee employee : allEmployees ) {
//				if (employee.getShiftId()==workshift.getShiftId()) {
//					allocatedEmployees.add(employee);
//				}
//			}
		}
		
*/		
//		allEmployees.removeAll(allocatedEmployees);
		List<Employee> unallocatedEmployees =EmployeeLocalServiceUtil.getWorkshiftEmployees(0);
		log.info(ws.getShiftId());
		log.info(ws.getWorkshiftName());
		actionRequest.setAttribute("unassignedemployees", unallocatedEmployees);
//		log.info("allocatedEmployees="+allocatedEmployees);
		log.info("unallocatedEmployees=="+unallocatedEmployees);
		log.info("shiftEmployees="+shiftEmployees);
		actionRequest.setAttribute("shiftemployees", shiftEmployees);
		actionRequest.setAttribute("editworkshift", ws);
		
		actionResponse.setRenderParameter("jspPage",
				"/html/workshift/editworkshift.jsp");
	}

}
