package org.mql.om.models.cm;

import java.util.StringTokenizer;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {

	}
	
	public Date(String date) {
		StringTokenizer st = new StringTokenizer(date, "-");
		year = Integer.parseInt(st.nextToken());
		month = Integer.parseInt(st.nextToken());
		day = Integer.parseInt(st.nextToken());
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return year + "-" + month + "-" + day;
	}
}
