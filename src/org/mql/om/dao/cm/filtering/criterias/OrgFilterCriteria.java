package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Contact;

public class OrgFilterCriteria implements ContactFilterCriteria {
	private String org;
	
	public OrgFilterCriteria(String org) {
		super();
		this.org = org;
	}

	public boolean passes(Contact c) {
		return (c.getOrg().equalsIgnoreCase(org));
	}

}
