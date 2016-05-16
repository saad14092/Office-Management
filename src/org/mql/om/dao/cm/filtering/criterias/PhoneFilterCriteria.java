package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Contact;
import org.mql.om.models.cm.Phone;

public class PhoneFilterCriteria implements ContactFilterCriteria {
	private String phone;
	
	public PhoneFilterCriteria(String phone) {
		super();
		this.phone = phone;
	}

	public boolean passes(Contact c) {
		Phone p  = new Phone(phone);
		int i = 0;
		for (Phone phone : c.getPhones()) {
			if (phone.equals(p)) i++;
		}
		return (i != 0);
	}

}
