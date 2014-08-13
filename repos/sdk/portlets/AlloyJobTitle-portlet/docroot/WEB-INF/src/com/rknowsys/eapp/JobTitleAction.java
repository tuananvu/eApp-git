package com.rknowsys.eapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.JobTitles;
import com.rknowsys.eapp.hrm.service.JobTitlesLocalServiceUtil;

public class JobTitleAction extends MVCPortlet {
	
	private static Logger log = Logger.getLogger(JobTitleAction.class);
	JobTitles jobtitles;
	 Date date = new Date();
		
		public void serveResource(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws IOException,
				PortletException {
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			if (resourceRequest.getResourceID().equals("saveJobtitle")) {
				
				System.out.println("inside saveJobtitle...serveResource...");
				
				log.info("This is the first log message...!!!");
				
				try {
					JobTitles jobtitles =  JobTitlesLocalServiceUtil.createJobTitles(CounterLocalServiceUtil.increment());
				
				System.out.println("Name = " +ParamUtil.getString(resourceRequest,
						"jobtitlename"));
				System.out.println("country = " +ParamUtil.getString(resourceRequest,
						"description"));
				String id = ParamUtil.getString(resourceRequest,
						"jobtitleId");
				System.out.println("id == " +id);
				if(id=="" || id == null){
					System.out.println("inside if loop...");
				jobtitles.setTitle(ParamUtil.getString(resourceRequest,
						"jobtitlename")); 
				jobtitles.setDescription(ParamUtil.getString(resourceRequest,
						"description"));
				jobtitles.setNotes(ParamUtil.getString(resourceRequest,
						"notes"));
				jobtitles.setCreateDate(date);
				jobtitles.setModifiedDate(date);
				jobtitles.setCompanyId(themeDisplay.getCompanyId());
				jobtitles.setGroupId(themeDisplay.getCompanyGroupId());
				jobtitles.setUserId(themeDisplay.getUserId());

				
				jobtitles = JobTitlesLocalServiceUtil.addJobTitles(jobtitles);
								
				}
				else{
					System.out.println("else block to update...");
					
				
					long jobtitleid = Long.parseLong(id);
					JobTitles jobtitles1 = JobTitlesLocalServiceUtil.getJobTitles(jobtitleid);
					
									
					jobtitles1.setId(ParamUtil.getLong(resourceRequest,
							"jobtitleId"));
					jobtitles1.setTitle(ParamUtil.getString(resourceRequest,
							"jobtitlename"));
					jobtitles1.setDescription(ParamUtil.getString(resourceRequest,
							"description"));
					jobtitles1.setNotes(ParamUtil.getString(resourceRequest,
							"notes"));
					jobtitles1.setModifiedDate(date);
					
					jobtitles1.setCompanyId(themeDisplay.getCompanyId());
					jobtitles1.setGroupId(themeDisplay.getCompanyGroupId());
					jobtitles1.setUserId(themeDisplay.getUserId());
									
					jobtitles1 =  JobTitlesLocalServiceUtil.updateJobTitles(jobtitles1);
					
					
				}} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
				PrintWriter writer = resourceResponse.getWriter();

				writer.write(jsonArray.toString());
				
				
				
				}
               if (resourceRequest.getResourceID().equals("deleteJobtitle")) {
            	   
            	   
            	   System.out.println("inside deleteJobtitle...");
       			
       			String[] idsArray = ParamUtil.getParameterValues(resourceRequest,"jobtitleIds");
       			System.out.println("s===" +idsArray.length);
       			
       			System.out.println("length = " +idsArray.length);
       			for(int i = 0;i<=idsArray.length-1;i++)
       			{
       				System.out.println((idsArray[i]));
       			}
       			System.out.println("deleting.....");
       			for (int i = 0; i <=idsArray.length-1; i++) {
       				
       				if(idsArray[i].equals("on")){
       					System.out.println("All records selected... in Job Title...");
       				}
       				else{
       	 			
       				try {
						JobTitlesLocalServiceUtil.deleteJobTitles(Long.parseLong(idsArray[i]));
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					} catch (PortalException e) {
					
						e.printStackTrace();
					} catch (SystemException e) {
						
						e.printStackTrace();
					}
       			}
       			}
       			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
				PrintWriter writer = resourceResponse.getWriter();

				writer.write(jsonArray.toString());
				
			}
			
			
			}
		
		public JobTitles editJobtitleBean(long l) throws IOException, PortletException, PortalException, SystemException {
			System.out.println("inside editJobtitle...using servicebuilder");
			
			
			JobTitles jobtitles =  JobTitlesLocalServiceUtil.getJobTitles(l);
			System.out.println(jobtitles.getTitle());
			System.out.println(jobtitles.getDescription());
			
			
			
			
			return jobtitles;
			
		}
		
}
