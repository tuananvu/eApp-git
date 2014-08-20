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
import com.rknowsys.eapp.hrm.model.Skill;
import com.rknowsys.eapp.hrm.service.SkillLocalServiceUtil;

/**
 * Portlet implementation class SkillsAction
 */
public class SkillsAction extends MVCPortlet {
	Date date=new Date();
	public void saveSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			Skill skills = SkillLocalServiceUtil
					.createSkill(CounterLocalServiceUtil.increment());
			String id = ParamUtil.getString(actionRequest, "SkillId");
			String name=ParamUtil.getString(actionRequest, "skill_name");
			String description=ParamUtil.getString(actionRequest, "skill_description");
			System.out.println("id == " + id);
			if (id == "" || id == null) {
				skills.setSkillName(ParamUtil.getString(actionRequest,
						"name"));
				skills.setCreateDate(date);
				skills.setModifiedDate(date);
				skills.setCompanyId(themeDisplay.getCompanyId());
				skills.setGroupId(themeDisplay.getCompanyGroupId());
				skills.setUserId(themeDisplay.getUserId());
				skills.setSkillName(name);
				skills.setDescription(description);
				skills = SkillLocalServiceUtil.addSkill(skills);
			} 		} catch (SystemException e) {
			
			e.printStackTrace();
		}

	}
	public void updateSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
			String id = ParamUtil.getString(actionRequest, "skillId");
			String name=ParamUtil.getString(actionRequest, "skill_name");
			String description=ParamUtil.getString(actionRequest, "skill_description");
			System.out.println("id == " + id);
				Skill skills;
				try {
					skills = SkillLocalServiceUtil.getSkill(Long.parseLong(id));
					skills.setCreateDate(date);
					skills.setModifiedDate(date);
					skills.setCompanyId(themeDisplay.getCompanyId());
					skills.setGroupId(themeDisplay.getCompanyGroupId());
					skills.setUserId(themeDisplay.getUserId());
					skills.setSkillName(name);
					skills.setDescription(description);
					skills = SkillLocalServiceUtil.updateSkill(skills);

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
	 * This method deletes the Skills record from database based on
	 * Skills record Id
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
		if (resourceRequest.getResourceID().equals("deleteSkill")) {
System.out.println("deleting thes skills");
	
	String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"skillIds");
						System.out.println(idsArray.length);
						
						for (int i = 0; i <= idsArray.length-1; i++) {
				
					
							try
							 {
						 try {
							SkillLocalServiceUtil.deleteSkill(Long.parseLong(idsArray[i]));
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
				
			
			
		

	
	public void editSkill(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		String skillId = ParamUtil.getString(actionRequest, "skillId");
		Skill skills = SkillLocalServiceUtil.getSkill(Long
				.parseLong(skillId));

		actionRequest.setAttribute("editSkill", skills);
		actionResponse.setRenderParameter("jspPage",
				"/html/skillsaction/editSkill.jsp");
	}

 

}