package com.rknowsys.eapp.hrm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String DATE_FORMAT_HRM = "dd/MM/yyyy";

	public static String format(Date date) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = "";
		if (date != null)
			formatter.format(date);
		return dateStr;
	}

	public static void main(String args[]) {
		System.out.println(format(new Date()));

	}

	public static Date parse(String strDate, String dateFormat) {
		DateFormat formatter = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			if (strDate != null && !strDate.isEmpty())
				date = formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public static Date parse(String strDate) {
		return parse(strDate, DATE_FORMAT_HRM);
	}
}
