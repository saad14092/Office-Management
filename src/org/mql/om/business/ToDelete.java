package org.mql.om.business;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ToDelete {
	private static GregorianCalendar date = new GregorianCalendar();
	
	public static void main(String[] args) {
		date.set(2014, 11, 11);
		System.out.println(date.get(Calendar.DATE));
	}
}
