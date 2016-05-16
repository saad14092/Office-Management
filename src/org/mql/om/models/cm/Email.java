package org.mql.om.models.cm;

public class Email {
	private String email;
	private String type;
	
	public Email() {

	}

	public Email(String email) {
		super();
		this.email = email;
		type = "iemail";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return "Email [" + email + ", type=" + type + "]";
	}
	
	
}
