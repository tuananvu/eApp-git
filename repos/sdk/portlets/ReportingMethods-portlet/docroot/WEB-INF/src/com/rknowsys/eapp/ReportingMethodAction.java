package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.ReportingMethods;
import com.rknowsys.eapp.hrm.service.ReportingMethodsLocalServiceUtil;

/**
 * @author Laxminarayana 10th october 2014 6:49:58 PM
 */
public class ReportingMethodAction extends MVCPortlet {
	Date date = new Date();

	/**
	 * <p>
	 * This method inserts new ReportingMethod record into the database table.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveReportingMethod(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {

			ReportingMethods reportingMethods = ReportingMethodsLocalServiceUtil
					.createReportingMethods(CounterLocalServiceUtil.increment());

			String id = ParamUtil.getString(actionRequest, "reportingmethodId");
			String name = ParamUtil.getString(actionRequest,
					"reportingmethodName");
			System.out.println("id == " + id + " Name = " + name);
			if (id == "" || id == null) {
				reportingMethods.setReportingmethodName(ParamUtil.getString(
						actionRequest, "reportingmethodName"));
				reportingMethods.setCreateDate(date);
				reportingMethods.setModifiedDate(date);
				reportingMethods.setCompanyId(themeDisplay.getCompanyId());
				reportingMethods.setGroupId(themeDisplay.getCompanyGroupId());
				reportingMethods.setUserId(themeDisplay.getUserId());
				reportingMethods = ReportingMethodsLocalServiceUtil
						.addReportingMethods(reportingMethods);
			}
		} catch (SystemException e) {

			e.printStackTrace();
		}

	}

	/**
	 * <p>
	 * This method updates the ReportingMethod record in the database table
	 * based on the given ReportingMethod recordId.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void updateReportingMethod(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String id = ParamUtil.getString(actionRequest, "reportingmethodId");
		String name = ParamUtil.getString(actionRequest, "reportingmethodName");
		System.out.println("id == " + id);
		ReportingMethods reportingMethods;

		try {
			reportingMethods = ReportingMethodsLocalServiceUtil
					.getReportingMethods(Long.parseLong(id));
			reportingMethods.setCreateDate(date);
			reportingMethods.setModifiedDate(date);
			reportingMethods.setCompanyId(themeDisplay.getCompanyId());
			reportingMethods.setGroupId(themeDisplay.getCompanyGroupId());
			reportingMethods.setUserId(themeDisplay.getUserId());
			reportingMethods.setReportingmethodName(name);
			reportingMethods = ReportingMethodsLocalServiceUtil
					.updateReportingMethods(reportingMethods);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * This method deletes the ReportingMethod record from database based on
	 * ReportingMethod record Id
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
			ResourceResponse resourceResponse) throws IOException {
		if (resourceRequest.getResourceID().equals("deleteReportingMethod")) {
			System.out.println("deleting thes ReportingMethods");

			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"reportingmethodIds");
			System.out.println(idsArray.length);

			for (int i = 0; i <= idsArray.length - 1; i++) {

				try {
					try {
						ReportingMethodsLocalServiceUtil
								.deleteReportingMethods(Long
										.parseLong(idsArray[i]));
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NumberFormatException e) {
				}
			}

		}

	}

	/**
	 * <p>
	 * This method gets a single ReportingMethod record from database based on
	 * given ReportingMethod recordId
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void editReportingMethod(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		Long reportingmethodId = ParamUtil.getLong(actionRequest,
				"reportingmethodId");
		ReportingMethods reportingMethods = ReportingMethodsLocalServiceUtil
				.getReportingMethods(reportingmethodId);

		actionRequest.setAttribute("editReportingMethod", reportingMethods);
		actionResponse.setRenderParameter("jspPage",
				"/html/reportingmethods/edit.jsp");
	}

}
