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
import com.rknowsys.eapp.hrm.model.Language;
import com.rknowsys.eapp.hrm.service.LanguageLocalServiceUtil;

/**
 * Portlet implementation class LanguageAction
 */
public class LanguageAction extends MVCPortlet {
		Date date=new Date();
		public void saveLanguage(ActionRequest actionRequest,
				ActionResponse actionResponse) throws IOException,
				PortletException, SystemException {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				Language languages = LanguageLocalServiceUtil
						.createLanguage(CounterLocalServiceUtil.increment());
				String id = ParamUtil.getString(actionRequest, "languageId");
				String name=ParamUtil.getString(actionRequest, "language_name");
				System.out.println("id == " + id);
				if (id == "" || id == null) {
					languages.setLanguageName(ParamUtil.getString(actionRequest,
							"name"));
					languages.setCreateDate(date);
					languages.setModifiedDate(date);
					languages.setCompanyId(themeDisplay.getCompanyId());
					languages.setGroupId(themeDisplay.getCompanyGroupId());
					languages.setUserId(themeDisplay.getUserId());
					languages.setLanguageName(name);
					languages = LanguageLocalServiceUtil.addLanguage(languages);
				} 		} catch (SystemException e) {
				
				e.printStackTrace();
			}

		}
		public void updateLanguage(ActionRequest actionRequest,
				ActionResponse actionResponse) throws IOException,
				PortletException, SystemException {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
				String id = ParamUtil.getString(actionRequest, "languageId");
				String name=ParamUtil.getString(actionRequest, "language_name");
				System.out.println("id == " + id);
					Language languages;
					try {
						languages = LanguageLocalServiceUtil.getLanguage(Long.parseLong(id));
						languages.setCreateDate(date);
						languages.setModifiedDate(date);
						languages.setCompanyId(themeDisplay.getCompanyId());
						languages.setGroupId(themeDisplay.getCompanyGroupId());
						languages.setUserId(themeDisplay.getUserId());
						languages.setLanguageName(name);
						languages = LanguageLocalServiceUtil.updateLanguage(languages);

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
		 * This method deletes the languages record from database based on
		 * languages record Id
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
			if (resourceRequest.getResourceID().equals("deleteLanguage")) {
	System.out.println("deleting thes languages");
		
		String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
						"languageIds");
							System.out.println(idsArray.length);
							
							for (int i = 0; i <= idsArray.length-1; i++) {
					
						
								try
								 {
							 try {
								LanguageLocalServiceUtil.deleteLanguage(Long.parseLong(idsArray[i]));
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
					
				
				
			

		
		public void editLanguage(ActionRequest actionRequest,
				ActionResponse actionResponse) throws IOException,
				PortletException, NumberFormatException, PortalException,
				SystemException {
			Long languageId = ParamUtil.getLong(actionRequest, "languageId");
			Language languages = LanguageLocalServiceUtil.getLanguage(languageId);

			actionRequest.setAttribute("editLanguage", languages);
			actionResponse.setRenderParameter("jspPage",
					"/html/language/edit.jsp");
		}

	 

 

	}

