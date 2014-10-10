package com.rknowsys.eapp;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

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
import com.rknowsys.eapp.hrm.model.Dependent;
import com.rknowsys.eapp.hrm.service.DependentLocalServiceUtil;
import com.rknowsys.eapp.hrm.util.DateUtils;

public class DependentsAction extends MVCPortlet {

	public static final String DEPENDENT_ID = "dependentId";
	public static final String DEPENDENT_NAME = "name";
	public static final String DEPENDENT_RELATIONSHIP = "relationship";
	public static final String DEPENDENT_DOB = "dateOfBirth";
//	public static final String DEPENDENT_COMPANY = "company";
//	public static final String WORK_EXP_JOB_TITLE = "jobTitle";
//	public static final String WORK_EXP_COMPANY_FROM_DATE = "fromDate";
//	public static final String WORK_EXP_COMPANY_TO_DATE = "toDate";
//	public static final String WORK_EXP_COMPANY_COMMENT = "comment";
	
	private static Logger log = Logger.getLogger(DependentsAction.class);
	
	/**
	 * <p>
	 * This method inserts new Dependent record in database if the id is not
	 * existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveDependent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("inside saveDependent...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		try {
			Dependent dependent = DependentLocalServiceUtil
					.createDependent(CounterLocalServiceUtil.increment());
			log.info("dependent = " 
					+ ParamUtil.getString(actionRequest, CustomComparatorUtil .DEPENDENTS_COL_NAME));
			
			String id = ParamUtil.getString(actionRequest, DEPENDENT_ID);
			log.info("id == " + id);
			
			Date date = new Date();
			if (id == null || id.isEmpty()) {
				log.info("inside if loop...");
				dependent.setCreateDate(date);
				dependent.setModifiedDate(date);
				dependent.setCompanyId(themeDisplay.getCompanyId());
				dependent.setGroupId(themeDisplay.getCompanyGroupId());
				dependent.setUserId(themeDisplay.getUserId());
				
				System.out.println(actionRequest.getContentType());
				Enumeration<String> reqAttribs = actionRequest.getAttributeNames();
				while (reqAttribs.hasMoreElements()) {
					System.out.println((String)reqAttribs.nextElement());
				}
				System.out.println(actionRequest);
				System.out.println(actionRequest.getAttributeNames());

				dependent.setName(ParamUtil.getString(actionRequest, DEPENDENT_NAME));
				dependent.setRelationship(ParamUtil.getString(actionRequest, DEPENDENT_RELATIONSHIP));
				dependent.setDateOfBirth(DateUtils.parse(ParamUtil.getString(actionRequest, DEPENDENT_DOB)));
				
				dependent = DependentLocalServiceUtil
						.addDependent(dependent);
				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long dependentId = Long.parseLong(id);

				Dependent dependent1 = DependentLocalServiceUtil
						.getDependent(dependentId);

				dependent1.setDependentId(ParamUtil.getLong(actionRequest,
						DEPENDENT_ID));

				dependent1.setModifiedDate(date);
				dependent1.setCompanyId(themeDisplay.getCompanyId());
				dependent1.setGroupId(themeDisplay.getCompanyGroupId());
				dependent1.setUserId(themeDisplay.getUserId());

//				dependent1.setCompany(ParamUtil.getString(actionRequest, WORK_EXP_COMPANY));
//				dependent1.setJobTitle(ParamUtil.getString(actionRequest, WORK_EXP_JOB_TITLE));
//				dependent1.setFromDate(DateUtils.parse(ParamUtil.getString(actionRequest, WORK_EXP_COMPANY_FROM_DATE)));
//				dependent1.setToDate(DateUtils.parse(ParamUtil.getString(actionRequest, WORK_EXP_COMPANY_TO_DATE)));
//				dependent1.setComment(ParamUtil.getString(actionRequest, WORK_EXP_COMPANY_COMMENT));
				dependent1.setName(ParamUtil.getString(actionRequest, DEPENDENT_NAME));
				dependent1.setRelationship(ParamUtil.getString(actionRequest, DEPENDENT_RELATIONSHIP));
				dependent1.setDateOfBirth(DateUtils.parse(ParamUtil.getString(actionRequest, DEPENDENT_DOB)));

				dependent1 = DependentLocalServiceUtil
						.updateDependent(dependent1);
				log.info("end of else block");

			}
		} catch (SystemException e) {
			
			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		log.info("end of the saveDependent method");

	}

	/**
	 * <p>
	 * This method deletes the Dependent record from database based on
	 * Dependent record Id
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
			ResourceResponse resourceResponse) throws IOException,NumberFormatException
           {
		if (resourceRequest.getResourceID().equals("deleteDependent")) {

			log.info("inside deleteDependent... serveResource");
			Dependent dependent;
			try {
				dependent = DependentLocalServiceUtil
						.createDependent(CounterLocalServiceUtil.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"dependentIds");

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
						dependent = DependentLocalServiceUtil
								.deleteDependent(Long.parseLong(idsArray[i]));
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
		log.info("end of deleteDependent method...");

	}

	/**
	 * <p>
	 * This method gets the single Dependent record from database based on the
	 * given Dependent Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single Dependent record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editDependent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {

		log.info("inside editDependent...");
		String s = ParamUtil.getString(actionRequest, "dependentId");
		log.info("dependentId == " + s);
		Dependent d = DependentLocalServiceUtil.getDependent(Long
				.parseLong(s));

		log.info(d.getDependentId());
		actionRequest.setAttribute("editdependent", d);
		actionResponse.setRenderParameter("jspPage",
				"/html/dependent/editdependent.jsp");
	}
}
