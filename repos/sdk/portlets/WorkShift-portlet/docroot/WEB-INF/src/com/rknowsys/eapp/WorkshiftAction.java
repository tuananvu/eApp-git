package com.rknowsys.eapp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		try {
			Workshift workshift = WorkshiftLocalServiceUtil
					.createWorkshift(CounterLocalServiceUtil.increment());

			log.info("workshift = "
					+ ParamUtil.getString(actionRequest,
							CustomComparatorUtil.WORKSHIFT_COL_NAME));
			String id = ParamUtil.getString(actionRequest, WORKSHIFT_ID);
			log.info("id == " + id);
			Date date = new Date();
			if (id == "" || id == null) {
				log.info("inside if loop...");
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
				workshift = WorkshiftLocalServiceUtil.addWorkshift(workshift);
				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long shiftid = Long.parseLong(id);

				Workshift workshift1 = WorkshiftLocalServiceUtil
						.getWorkshift(shiftid);

				workshift1.setShiftId(ParamUtil.getLong(actionRequest,
						WORKSHIFT_ID));

				workshift1.setWorkshiftName(ParamUtil.getString(actionRequest,
						CustomComparatorUtil.WORKSHIFT_COL_NAME));
				workshift1.setFromWorkHours(ParamUtil.getDate(actionRequest,
						"fromWorkHours", formater));
				log.info("fromWorkHours = "
						+ ParamUtil.getDate(actionRequest, "fromWorkHours",
								formater));
				log.info("fromWorkHours in string = " + ParamUtil.getString(actionRequest, "fromWorkHours"));
				workshift1.setToWorkHours(ParamUtil.getDate(actionRequest,
						"toWorkHours", formater));

				workshift1.setModifiedDate(date);
				workshift1.setCompanyId(themeDisplay.getCompanyId());
				workshift1.setGroupId(themeDisplay.getCompanyGroupId());
				workshift1.setUserId(themeDisplay.getUserId());
				
				String[] idsArray = ParamUtil.getParameterValues(actionRequest,
						"arr");
				Employee employee = null;
				for (int i = 0; i <= idsArray.length - 1; i++) {
					log.info(idsArray[i]);
					
							employee = EmployeeLocalServiceUtil
									.getEmployee(Long.parseLong(idsArray[i]));
							employee.setShiftId(workshift1.getShiftId());
				}

				workshift1 = WorkshiftLocalServiceUtil
						.updateWorkshift(workshift1);
				log.info("end of else block");

			}
		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		log.info("end of the saveWorkshift method");

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
			Workshift Workshift;
			try {
				Workshift = WorkshiftLocalServiceUtil
						.createWorkshift(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"workshiftIds");

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
						Workshift = WorkshiftLocalServiceUtil
								.deleteWorkshift(Long.parseLong(idsArray[i]));
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
		Workshift es = WorkshiftLocalServiceUtil
				.getWorkshift(Long.parseLong(s));

		log.info(es.getShiftId());
		log.info(es.getWorkshiftName());
		actionRequest.setAttribute("editworkshift", es);
		actionResponse.setRenderParameter("jspPage",
				"/html/workshift/editworkshift.jsp");
	}

}
