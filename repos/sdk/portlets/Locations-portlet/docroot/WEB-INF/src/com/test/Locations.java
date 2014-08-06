package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rknowsys.eapp.hrm.model.Locations;
import com.rknowsys.eapp.hrm.service.LocationsLocalServiceUtil;
/**
 * Portlet implementation class LocationsEapp
/**
 * Portlet implementation class Locations
 */
public class Locations extends MVCPortlet {

	 */
	public class LocationsEapp extends MVCPortlet {
		public void addLocations(ActionRequest actionRequest,ActionResponse actionResponse)throws
		PortletException,IOException, SystemException
		{
			System.out.println("Add locations method");
			String name=ParamUtil.getString(actionRequest, "name");
			String country=ParamUtil.getString(actionRequest, "country");
			String state=ParamUtil.getString(actionRequest, "state");
			String city=ParamUtil.getString(actionRequest, "city");
			String address=ParamUtil.getString(actionRequest, "address");
			String zip=ParamUtil.getString(actionRequest, "zip");
			String phone=ParamUtil.getString(actionRequest, "phone");
			String fax=ParamUtil.getString(actionRequest, "fax");
			String notes=ParamUtil.getString(actionRequest, "notes");
			long id=CounterLocalServiceUtil.increment();
			Locations locations=LocationsLocalServiceUtil.createLocations(id);
			if(locations!=null)
			{
				try
				{
				locations.setId(id);
				locations.setName(name);
				locations.setCountry(country);
				locations.setState(state);
				locations.setCity(city);
				locations.setAddress(address);
				locations.setPostalcode(zip);
				locations.setFax(fax);
				locations.setPhone(phone);
				locations.setNotes(notes);
				LocationsLocalServiceUtil.addLocations(locations);
				SessionMessages.add(actionRequest.getPortletSession(), "location-added-success");
				}
				catch(Exception e)
				{
					SessionErrors.add(actionRequest, "location-add-fail");
				}
			}
		}
		 public void editLocation(ActionRequest actionRequest,ActionResponse actionResponse)
				 throws PortalException,SystemException,IOException
			 {
				 long id=ParamUtil.getLong(actionRequest, "id");
				 Locations Locations=LocationsLocalServiceUtil.getLocations(id);
				 actionRequest.setAttribute("edit", Locations);
				 actionResponse.setRenderParameter("mvcPath", "/html/locations/editLocations.jsp" );
			 }
		 public void updateLocation(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException, SystemException
			 {	
				 String name=ParamUtil.getString(actionRequest, "name");
				 String country=ParamUtil.getString(actionRequest, "country");
				 String state=ParamUtil.getString(actionRequest, "state");
				 String phone=ParamUtil.getString(actionRequest, "phone");
				 long id=ParamUtil.getLong(actionRequest, "id");
				 Locations locations=LocationsLocalServiceUtil.getLocations(id);
				 locations.setId(id);
				 locations.setName(name);
				 locations.setCountry(country);
				 locations.setState(state);
				 locations.setPhone(phone);
				 locations=LocationsLocalServiceUtil.updateLocations(locations);
				 actionResponse.setRenderParameter("mvcPath", "/html/locations/view.jsp");
				 
			 }
		public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)
		{
			 String[] idArray=ParamUtil.getParameterValues(resourceRequest, "id9");
			 System.out.println(idArray.length);
			 for(int i=0;i<=idArray.length-1;i++)
			 {
				 try
				 {
			 try {
				LocationsLocalServiceUtil.deleteLocations(Long.parseLong(idArray[i]));
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
					 System.out.println("thnk u");
				 }
			 }
			
		}
		public void searchLocations(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException
		 {
			String lname=ParamUtil.getString(actionRequest, "locationName");
			String lcountry=ParamUtil.getString(actionRequest, "country");
			actionRequest.setAttribute("lname", lname);
			actionRequest.setAttribute("lcountry", lcountry);
			actionResponse.setRenderParameter("mvcPath", "/html/locations/search.jsp" );
		 }

	}

}
