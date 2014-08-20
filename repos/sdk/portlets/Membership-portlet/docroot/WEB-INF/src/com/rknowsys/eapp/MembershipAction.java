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
import com.rknowsys.eapp.hrm.model.Membership;
import com.rknowsys.eapp.hrm.service.MembershipLocalServiceUtil;

/**
 * Portlet implementation class MembershipAction
 */
public class MembershipAction extends MVCPortlet {
	Date date=new Date();
	public void saveMembership(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			Membership membership = MembershipLocalServiceUtil
					.createMembership(CounterLocalServiceUtil.increment());
			String id = ParamUtil.getString(actionRequest, "MembershipId");
			String name=ParamUtil.getString(actionRequest, "membership_name");
			System.out.println("id == " + id);
			if (id == "" || id == null) {
				
				membership.setCreateDate(date);
				membership.setModifiedDate(date);
				membership.setCompanyId(themeDisplay.getCompanyId());
				membership.setGroupId(themeDisplay.getCompanyGroupId());
				membership.setUserId(themeDisplay.getUserId());
				membership.setMembershipName(name);
				membership = MembershipLocalServiceUtil.addMembership(membership);
			} 		} catch (SystemException e) {
			
			e.printStackTrace();
		}

	}
	public void updateMembership(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
			Long id = ParamUtil.getLong(actionRequest, "membershipId");
			String name=ParamUtil.getString(actionRequest, "membership_name");
			System.out.println("id == " + id);
				Membership membership;
				try {
					membership = MembershipLocalServiceUtil.getMembership(id);
					membership.setCreateDate(date);
					membership.setModifiedDate(date);
					membership.setCompanyId(themeDisplay.getCompanyId());
					membership.setGroupId(themeDisplay.getCompanyGroupId());
					membership.setUserId(themeDisplay.getUserId());
					membership.setMembershipName(name);
					membership = MembershipLocalServiceUtil.updateMembership(membership);

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
	 * This method deletes the Memberships record from database based on
	 * Memberships record Id
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
		if (resourceRequest.getResourceID().equals("deleteMembership")) {
System.out.println("deleting thes membership");
	
	String[] idsArray = ParamUtil.getParameterValues(resourceRequest,
					"membershipIds");
						System.out.println(idsArray.length);
						
						for (int i = 0; i <= idsArray.length-1; i++) {
				
					
							try
							 {
						 try {
							MembershipLocalServiceUtil.deleteMembership(Long.parseLong(idsArray[i]));
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
				
			
			
		

	
	public void editMembership(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {
		Long membershipId = ParamUtil.getLong(actionRequest, "membershipId");
		Membership membership = MembershipLocalServiceUtil.getMembership(membershipId);

		actionRequest.setAttribute("editMembership", membership);
		actionResponse.setRenderParameter("jspPage",
				"/html/membershipaction/editMembership.jsp");
	}

 

 

}
