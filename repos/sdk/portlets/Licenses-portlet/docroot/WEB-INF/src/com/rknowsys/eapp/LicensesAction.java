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
import com.rknowsys.eapp.hrm.model.License;
import com.rknowsys.eapp.hrm.service.LicenseLocalServiceUtil;

/**
 * Portlet implementation class LicensesAction
 */
public class LicensesAction extends MVCPortlet {
	Date date=new Date();
	public void saveLicense(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			License licenses = LicenseLocalServiceUtil
					.createLicense(CounterLocalServiceUtil.increment());
			String id = ParamUtil.getString(actionRequest, "LicenseId");
			String name=ParamUtil.getString(actionRequest, "license_name");
			System.out.println("id == " + id);
			if (id == "" || id == null) {
				licenses.setLicenseName(ParamUtil.getString(actionRequest,
						"name"));
				licenses.setCreateDate(date);
				licenses.setModifiedDate(date);
				licenses.setCompanyId(themeDisplay.getCompanyId());
				licenses.setGroupId(themeDisplay.getCompanyGroupId());
				licenses.setUserId(themeDisplay.getUserId());
				licenses.setLicenseName(name);
				licenses = LicenseLocalServiceUtil.addLicense(licenses);
			} 		} catch (SystemException e) {
			
			e.printStackTrace();
		}

	}
	public void updateLicense(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
			String id = ParamUtil.getString(actionRequest, "licenseId");
			String name=ParamUtil.getString(actionRequest, "license_name");
			System.out.println("id == " + id);
				License licenses;
				try {
					licenses = LicenseLocalServiceUtil.getLicense(Long.parseLong(id));
					licenses.setCreateDate(date);
					licenses.setModifiedDate(date);
					licenses.setCompanyId(themeDisplay.getCompanyId());
					licenses.setGroupId(themeDisplay.getCompanyGroupId());
					licenses.setUserId(themeDisplay.getUserId());
					licenses.setLicenseName(name);
					licenses = LicenseLocalServiceUtil.updateLicense(licenses);

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
	 * This method deletes the licenses record from database based on
	 * licenses record Id
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
			ResourceResponse resourceResponse) throws IOException
           {
		if (resourceRequest.getResourceID().equals("deleteLicense")) {
System.out.println("deleting thes licenses");
	
	String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"licenseIds");
						System.out.println(idsArray.length);
						
						for (int i = 0; i <= idsArray.length-1; i++) {
				
					
							try
							 {
						 try {
							LicenseLocalServiceUtil.deleteLicense(Long.parseLong(idsArray[i]));
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SystemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							 }
							 catch(NumberFormatException e)
							 {
							 }
						 }

								} 
						
				
						
				}
				
			
			
		

	
	public void editLicense(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		Long licenseId = ParamUtil.getLong(actionRequest, "licenseId");
		License licenses = LicenseLocalServiceUtil.getLicense(licenseId);

		actionRequest.setAttribute("editLicense", licenses);
		actionResponse.setRenderParameter("jspPage",
				"/html/licensesaction/editLicense.jsp");
	}

 



 

}
