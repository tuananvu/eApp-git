package com.rknowsys.eapp.ui;

import java.util.List;

import com.rknowsys.eapp.hrm.util.ApplicationConstants;
import com.rknowsys.eapp.hrm.util.IdNamePair;

public class WorkWeek {

	private String workWeekId;
	private String nationalityId;
	private List<IdNamePair> nationalities;

	private List<IdNamePair> workSchedules = ApplicationConstants.workSchedules;

	private String mondayWorkSchedule;
	private String tuesdayWorkSchedule;
	private String wednesdayWorkSchedule;
	private String thursdayWorkSchedule;
	private String fridayWorkSchedule;
	private String saturdayWorkSchedule;
	private String sundayWorkSchedule;

	public String getWorkWeekId() {
		return workWeekId;
	}

	public void setWorkWeekId(String workWeekId) {
		this.workWeekId = workWeekId;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	public List<IdNamePair> getNationalities() {
		return nationalities;
	}

	public void setNationalities(List<IdNamePair> nationalities) {
		this.nationalities = nationalities;
	}

	public List<IdNamePair> getWorkSchedules() {
		return workSchedules;
	}

	public void setWorkSchedules(List<IdNamePair> workSchedules) {
		this.workSchedules = workSchedules;
	}

	public String getMondayWorkSchedule() {
		return mondayWorkSchedule;
	}

	public void setMondayWorkSchedule(String mondayWorkSchedule) {
		this.mondayWorkSchedule = mondayWorkSchedule;
	}

	public String getTuesdayWorkSchedule() {
		return tuesdayWorkSchedule;
	}

	public void setTuesdayWorkSchedule(String tuesdayWorkSchedule) {
		this.tuesdayWorkSchedule = tuesdayWorkSchedule;
	}

	public String getWednesdayWorkSchedule() {
		return wednesdayWorkSchedule;
	}

	public void setWednesdayWorkSchedule(String wednesdayWorkSchedule) {
		this.wednesdayWorkSchedule = wednesdayWorkSchedule;
	}

	public String getThursdayWorkSchedule() {
		return thursdayWorkSchedule;
	}

	public void setThursdayWorkSchedule(String thursdayWorkSchedule) {
		this.thursdayWorkSchedule = thursdayWorkSchedule;
	}

	public String getFridayWorkSchedule() {
		return fridayWorkSchedule;
	}

	public void setFridayWorkSchedule(String fridayWorkSchedule) {
		this.fridayWorkSchedule = fridayWorkSchedule;
	}

	public String getSaturdayWorkSchedule() {
		return saturdayWorkSchedule;
	}

	public void setSaturdayWorkSchedule(String saturdayWorkSchedule) {
		this.saturdayWorkSchedule = saturdayWorkSchedule;
	}

	public String getSundayWorkSchedule() {
		return sundayWorkSchedule;
	}

	public void setSundayWorkSchedule(String sundayWorkSchedule) {
		this.sundayWorkSchedule = sundayWorkSchedule;
	}

	@Override
	public String toString() {
		return "WorkWeek [workWeekId=" + workWeekId + ", nationalityId="
				+ nationalityId + ", nationalities=" + nationalities
				+ ", workSchedules=" + workSchedules + ", mondayWorkSchedule="
				+ mondayWorkSchedule + ", tuesdayWorkSchedule="
				+ tuesdayWorkSchedule + ", wednesdayWorkSchedule="
				+ wednesdayWorkSchedule + ", thursdayWorkSchedule="
				+ thursdayWorkSchedule + ", fridayWorkSchedule="
				+ fridayWorkSchedule + ", saturdayWorkSchedule="
				+ saturdayWorkSchedule + ", sundayWorkSchedule="
				+ sundayWorkSchedule + "]";
	}

}
