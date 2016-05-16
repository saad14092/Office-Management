package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Contact;

public class WebsiteFilterCriteria implements ContactFilterCriteria {
	private String url;
	
	public WebsiteFilterCriteria(String url) {
		super();
		this.url = url;
	}

	public boolean passes(Contact c) {
		return (c.getWebsite().equalsIgnoreCase(url));
	}

}
