package org.mql.om.models.cm;

import java.util.GregorianCalendar;
import java.util.List;

public class Contact {
	private String id;
	private String title;
	private String fname;
	private String lname;
	private GregorianCalendar bdate;
	private List<Phone> phones;
	private List<Address> addresses;
	private List<Email> emails;
	private String website;
	private String org;
	private String note;
	
	public Contact() {
		
	}

	public Contact(String fname, String lname, List<Phone> phones) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phones = phones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public GregorianCalendar getBdate() {
		return bdate;
	}

	public void setBdate(GregorianCalendar bdate) {
		this.bdate = bdate;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String toString() {
		return "Contact [id=" + id + ", title=" + title + ", fname=" + fname + ", lname=" + lname + ", bdate=" + bdate
				+ ", phones=" + phones + ", addresses=" + addresses + ", emails=" + emails + ", website=" + website
				+ ", org=" + org + ", note=" + note + "]";
	}
	
	
	
	
}
