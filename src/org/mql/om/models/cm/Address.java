package org.mql.om.models.cm;

public class Address {
	private String id;
	private String postalBox;
	private String houseNumber;
	private String street;
	private String city;
	private int zipCode;
	private String country;
	private String type;
	
	public Address() {
		
	}

	public Address(String postalBox, String houseNumber, String street, String city, int zipCode, String country,
			String type) {
		super();
		this.postalBox = postalBox;
		this.houseNumber = houseNumber;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostalBox() {
		return postalBox;
	}

	public void setPostalBox(String postalBox) {
		this.postalBox = postalBox;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return "Address [id=" + id + ", P.B" + postalBox + ", " + houseNumber + ", " + street
				+ ", " + city + ", " + zipCode + ", " + country + ", type=" + type + "]";
	}
	
	
	
}
