package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Contact;

public class LastNameFilterCriteria implements ContactFilterCriteria {
	private String lastName;
	
	public LastNameFilterCriteria(String lastName) {
		super();
		this.lastName = lastName;
	}
	
	public boolean passes(Contact c) {
		return (c.getLname().equalsIgnoreCase(lastName));
	}

}
