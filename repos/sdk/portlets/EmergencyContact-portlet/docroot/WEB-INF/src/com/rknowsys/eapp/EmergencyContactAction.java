package com.rknowsys.eapp;

import java.io.IOException;
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
import com.rknowsys.eapp.hrm.model.EmergencyContact;
import com.rknowsys.eapp.hrm.service.EmergencyContactLocalServiceUtil;

public class EmergencyContactAction extends MVCPortlet {

	public static final String EMERGENCY_CONTACT_ID = "emergencycontactId";
	public static final String EMERGENCY_CONTACT_NAME = "name";
	public static final String EMERGENCY_CONTACT_RELATIONSHIP = "relationship";
	public static final String EMERGENCY_CONTACT_HOME_TELEPHONE = "homeTelephone";
	public static final String EMERGENCY_CONTACT_WORK_TELEPHONE = "workTelephone";
	public static final String EMERGENCY_CONTACT_MOBILE = "mobile";

	private static Logger log = Logger.getLogger(EmergencyContactAction.class);

	/**
	 * <p>
	 * This method inserts new EmergencyContact record in database if the id is
	 * not existing, otherwise updates the record based on the record id.
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 */
	public void saveEmergencyContact(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		log.info("inside saveEmergencyContact...");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		log.info("company Id == " + themeDisplay.getCompanyId());
		log.info("userId = " + themeDisplay.getUserId());
		log.info("groupId = " + themeDisplay.getCompanyGroupId());
		try {
			EmergencyContact emergencyContact = EmergencyContactLocalServiceUtil
					.createEmergencyContact(CounterLocalServiceUtil.increment());
			log.info("emergencyContact = "
					+ ParamUtil.getString(actionRequest,
							CustomComparatorUtil.EMERGENCY_CONTACT_COL_NAME));

			String id = ParamUtil
					.getString(actionRequest, EMERGENCY_CONTACT_ID);
			log.info("id == " + id);

			Date date = new Date();
			if (id == null || id.isEmpty()) {
				log.info("inside if loop...");
				emergencyContact.setCreateDate(date);
				emergencyContact.setModifiedDate(date);
				emergencyContact.setCompanyId(themeDisplay.getCompanyId());
				emergencyContact.setGroupId(themeDisplay.getCompanyGroupId());
				emergencyContact.setUserId(themeDisplay.getUserId());

				emergencyContact.setName(ParamUtil.getString(actionRequest,
						EMERGENCY_CONTACT_NAME));
				emergencyContact.setRelationship(ParamUtil.getString(
						actionRequest, EMERGENCY_CONTACT_RELATIONSHIP));
				emergencyContact.setHomeTelephone(ParamUtil.getString(
						actionRequest, EMERGENCY_CONTACT_HOME_TELEPHONE));
				emergencyContact.setWorkTelephone(ParamUtil.getString(
						actionRequest, EMERGENCY_CONTACT_WORK_TELEPHONE));
				emergencyContact.setMobile(ParamUtil.getString(actionRequest,
						EMERGENCY_CONTACT_MOBILE));
				emergencyContact = EmergencyContactLocalServiceUtil
						.addEmergencyContact(emergencyContact);
				log.info("end of if block");
			} else {
				log.info("else block to update...");

				long emergencyContactId = Long.parseLong(id);

				EmergencyContact emergencyContact1 = EmergencyContactLocalServiceUtil
						.getEmergencyContact(emergencyContactId);

				emergencyContact1.setEmergencyContactId(ParamUtil.getLong(
						actionRequest, EMERGENCY_CONTACT_ID));

				emergencyContact1.setModifiedDate(date);
				emergencyContact1.setCompanyId(themeDisplay.getCompanyId());
				emergencyContact1.setGroupId(themeDisplay.getCompanyGroupId());
				emergencyContact1.setUserId(themeDisplay.getUserId());

				emergencyContact1.setName(ParamUtil.getString(actionRequest,
						EMERGENCY_CONTACT_NAME));
				emergencyContact1.setRelationship(ParamUtil.getString(
						actionRequest, EMERGENCY_CONTACT_RELATIONSHIP));
				emergencyContact1.setHomeTelephone(ParamUtil.getString(
						actionRequest, EMERGENCY_CONTACT_HOME_TELEPHONE));
				emergencyContact1.setWorkTelephone(ParamUtil.getString(
						actionRequest, EMERGENCY_CONTACT_WORK_TELEPHONE));
				emergencyContact1.setMobile(ParamUtil.getString(actionRequest,
						EMERGENCY_CONTACT_MOBILE));

				emergencyContact1 = EmergencyContactLocalServiceUtil
						.updateEmergencyContact(emergencyContact1);
				log.info("end of else block");

			}
		} catch (SystemException e) {

			e.printStackTrace();
			log.info("system exception");
		} catch (PortalException e) {

			e.printStackTrace();
			log.info("portalexception");
		}
		log.info("end of the saveEmergencyContact method");

	}

	/**
	 * <p>
	 * This method deletes the EmergencyContact record from database based on
	 * EmergencyContact record Id
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
		if (resourceRequest.getResourceID().equals("deleteEmergencyContact")) {

			log.info("inside deleteEmergencyContact... serveResource");
			try {
				EmergencyContactLocalServiceUtil
						.createEmergencyContact(CounterLocalServiceUtil
								.increment());
			} catch (SystemException e1) {

				e1.printStackTrace();
			}
			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"emergencyContactIds");

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
						EmergencyContactLocalServiceUtil
								.deleteEmergencyContact(Long
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
		log.info("end of deleteEmergencyContact method...");

	}

	/**
	 * <p>
	 * This method gets the single EmergencyContact record from database based
	 * on the given EmergencyContact Id
	 * </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @return Single EmergencyContact record
	 * @throws SystemException
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public void editEmergencyContact(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {

		log.info("inside editEmergencyContact...");
		String s = ParamUtil.getString(actionRequest, EMERGENCY_CONTACT_ID);
		log.info("emergencycontactId == " + s);
		EmergencyContact ec = EmergencyContactLocalServiceUtil
				.getEmergencyContact(Long.parseLong(s));

		log.info(ec.getEmergencyContactId());
		actionRequest.setAttribute("editemergencycontact", ec);
		actionResponse.setRenderParameter("jspPage",
				"/html/emergencycontact/editemergencycontact.jsp");
	}
}
