package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Contact;

public class FirstNameFilterCriteria implements ContactFilterCriteria {
	private String firstName;
	
	public FirstNameFilterCriteria(String firstName) {
		super();
		this.firstName = firstName;
	}
	
	public boolean passes(Contact c) {
		return (c.getFname().equalsIgnoreCase(firstName));
	}

	

}
