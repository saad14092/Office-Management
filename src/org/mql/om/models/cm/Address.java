package org.mql.om.models.cm;

public class Address {
	private String address;
	private String type;
	
	public Address() {
		
	}

	public Address(String address) {
		super();
		this.address = address;
	}

	public Address(String address, String type) {
		super();
		this.address = address;
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", type=" + type + "]";
	}
	
	
	
}
