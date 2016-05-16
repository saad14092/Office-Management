package org.mql.om.dao.cm.filtering.criterias;

import org.mql.om.models.cm.Contact;

public interface ContactFilterCriteria {
	public boolean passes(Contact c);
}
