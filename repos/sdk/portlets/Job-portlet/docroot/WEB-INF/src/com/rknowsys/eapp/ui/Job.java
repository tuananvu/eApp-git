package com.rknowsys.eapp.ui;

import java.util.List;

import com.rknowsys.eapp.hrm.util.IdNamePair;

public class Job {
	
	private String jobId;

	private String jobTitleId;
	
	private List<IdNamePair> jobTitles;
	
	private String jobSpecification;
	
	private String employmentStatusId;
	
	private List<IdNamePair> employmentStatuses;
	
	private String jobCategoryId;
	
	private List<IdNamePair> jobCategories;
	
	private String joinedDate;
	
	private String subUnitId;
	
	private List<IdNamePair> subUnits;
	
	private String locationId;
	
	private List<IdNamePair> locations;
	
	private String startDate;

	private String endDate;
	
	private String contractDetails;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	public List<IdNamePair> getJobTitles() {
		return jobTitles;
	}

	public void setJobTitles(List<IdNamePair> jobTitles) {
		this.jobTitles = jobTitles;
	}

	public String getJobSpecification() {
		return jobSpecification;
	}

	public void setJobSpecification(String jobSpecification) {
		this.jobSpecification = jobSpecification;
	}


	public List<IdNamePair> getEmploymentStatuses() {
		return employmentStatuses;
	}

	public void setEmploymentStatuses(List<IdNamePair> employmentStatuses) {
		this.employmentStatuses = employmentStatuses;
	}


	public List<IdNamePair> getJobCategories() {
		return jobCategories;
	}

	public void setJobCategories(List<IdNamePair> jobCategories) {
		this.jobCategories = jobCategories;
	}

	public String getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}


	public List<IdNamePair> getSubUnits() {
		return subUnits;
	}

	public void setSubUnits(List<IdNamePair> subUnits) {
		this.subUnits = subUnits;
	}


	public List<IdNamePair> getLocations() {
		return locations;
	}

	public void setLocations(List<IdNamePair> locations) {
		this.locations = locations;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getContractDetails() {
		return contractDetails;
	}

	public String getEmploymentStatusId() {
		return employmentStatusId;
	}

	public void setEmploymentStatusId(String employmentStatusId) {
		this.employmentStatusId = employmentStatusId;
	}

	public String getJobCategoryId() {
		return jobCategoryId;
	}

	public void setJobCategoryId(String jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}

	public String getSubUnitId() {
		return subUnitId;
	}

	public void setSubUnitId(String subUnitId) {
		this.subUnitId = subUnitId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public void setContractDetails(String contractDetails) {
		this.contractDetails = contractDetails;
	}

	public String getJobTitleId() {
		return jobTitleId;
	}

	public void setJobTitleId(String jobTitleId) {
		this.jobTitleId = jobTitleId;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobTitleId=" + jobTitleId
				+ ", jobTitles=" + jobTitles + ", jobSpecification="
				+ jobSpecification + ", employmentStatusId="
				+ employmentStatusId + ", employmentStatuses="
				+ employmentStatuses + ", jobCategoryId=" + jobCategoryId
				+ ", jobCategories=" + jobCategories + ", joinedDate="
				+ joinedDate + ", subUnitId=" + subUnitId + ", subUnits="
				+ subUnits + ", locationId=" + locationId + ", locations="
				+ locations + ", startDate=" + startDate + ", endDate="
				+ endDate + ", contractDetails=" + contractDetails + "]";
	}

}
