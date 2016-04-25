package org.mql.om.models.cm;

public class Email {
	private String id;
	private String email;
	private String type;
	
	public Email() {

	}

	public Email(String email, String type) {
		super();
		this.email = email;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Email [id=" + id + ", " + email + ", type=" + type + "]";
	}
	
	
}
