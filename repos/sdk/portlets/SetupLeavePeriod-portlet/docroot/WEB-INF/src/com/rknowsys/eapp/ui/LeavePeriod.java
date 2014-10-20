package com.rknowsys.eapp.ui;

import java.util.List;

import com.rknowsys.eapp.hrm.util.ApplicationConstants;
import com.rknowsys.eapp.hrm.util.IdNamePair;

public class LeavePeriod {

	private String leavePeriodId;
	
	private int startDate;
	
	private List<IdNamePair> months = ApplicationConstants.months;
	
	private int startMonth;
	
	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	private String endDate;
	
	private String currentLeavePeriod;

	public String getLeavePeriodId() {
		return leavePeriodId;
	}

	public String getCurrentLeavePeriod() {
		return currentLeavePeriod;
	}

	public void setCurrentLeavePeriod(String currentLeavePeriod) {
		this.currentLeavePeriod = currentLeavePeriod;
	}

	public void setLeavePeriodId(String leavePeriodId) {
		this.leavePeriodId = leavePeriodId;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public List<IdNamePair> getMonths() {
		return months;
	}

	public void setMonths(List<IdNamePair> months) {
		this.months = months;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "LeavePeriod [leavePeriodId=" + leavePeriodId + ", startDate="
				+ startDate + ", months=" + months + ", startMonth="
				+ startMonth + ", endDate=" + endDate + ", currentLeavePeriod="
				+ currentLeavePeriod + "]";
	}
	
}
