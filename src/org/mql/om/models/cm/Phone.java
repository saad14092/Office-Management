package org.mql.om.models.cm;

import java.util.StringTokenizer;

public class Phone {
	private String countryCode;
	private String phoneNumber;
	private String type;
	
	public Phone() {
		
	}

	public Phone(String countryCode, String phoneNumber, String type) {
		super();
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.type = type;
	}
	
	public Phone(String source) {
		StringTokenizer st = new StringTokenizer(source, " ");
		if (source.startsWith("+") || source.startsWith("00")) {
			String originalCountryCode = st.nextToken();
			if(originalCountryCode.startsWith("00")) {
				countryCode = originalCountryCode.replace("00", "+");
			}
			else {
				countryCode = originalCountryCode;
			}
			phoneNumber = source.substring(originalCountryCode.length() + 1);
			
		}
		else {
			countryCode = "";
			phoneNumber = source;
		}
	}	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return "Phone [countryCode=" + countryCode + ", phoneNumber=" + phoneNumber + ", type=" + type
				+ "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Phone) {
			Phone p = (Phone) obj;
			if (countryCode.equals(p.getCountryCode()) && phoneNumber.equals(p.getPhoneNumber())) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
