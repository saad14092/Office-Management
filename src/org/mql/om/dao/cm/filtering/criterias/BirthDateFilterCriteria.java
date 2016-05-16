package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Contact;
import org.mql.om.models.cm.Date;

public class BirthDateFilterCriteria implements ContactFilterCriteria {
	private String date;
	
	public BirthDateFilterCriteria(String date) {
		super();
		this.date = date;
	}

	public boolean passes(Contact c) {
		return (c.getBdate().toString().equals(date));
	}

}
