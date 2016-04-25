package org.mql.om.models.cm;

public class Phone {
	private String id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Phone [id=" + id + ", countryCode=" + countryCode + ", phoneNumber=" + phoneNumber + ", type=" + type
				+ "]";
	}
	
	
	
}
