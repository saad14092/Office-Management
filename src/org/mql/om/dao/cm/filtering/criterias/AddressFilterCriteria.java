package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Address;
import org.mql.om.models.cm.Contact;
import org.mql.om.models.cm.Email;

public class AddressFilterCriteria implements ContactFilterCriteria {
	private String address;
	
	public AddressFilterCriteria(String address) {
		super();
		this.address = address;
	}

	public boolean passes(Contact c) {
		int i = 0;
		for (Address address : c.getAddresses()) {
			if (address.getAddress().equalsIgnoreCase(this.address)) i++;
		}
		return (i != 0);
	}

}
