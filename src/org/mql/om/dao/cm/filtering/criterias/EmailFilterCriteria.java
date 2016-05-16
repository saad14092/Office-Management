package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Contact;
import org.mql.om.models.cm.Email;

public class EmailFilterCriteria implements ContactFilterCriteria {
	private String email;

	public EmailFilterCriteria(String email) {
		super();
		this.email = email;
	}

	public boolean passes(Contact c) {
		int i = 0;
		for (Email email : c.getEmails()) {
			if (email.getEmail().equals(this.email)) i++;
		}
		return (i != 0);
	}
	
	

}
