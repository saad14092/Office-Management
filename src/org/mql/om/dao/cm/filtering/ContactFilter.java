package org.mql.om.dao.cm.filtering;

import java.util.Vector;

import org.mql.om.dao.cm.filtering.criterias.ContactFilterCriteria;
import org.mql.om.models.cm.Contact;

/**
 * @author SAAD MOUMEN
 *
 */
public class ContactFilter {
	private Vector<ContactFilterCriteria> criterias;
	
	public ContactFilter() {
		criterias = new Vector<>();
	}
	
	public void add(ContactFilterCriteria criteria) {
		criterias.add(criteria);
	}
	
	public boolean filter(Contact contact) {
		for (ContactFilterCriteria criteria : criterias) {
			if(!criteria.passes(contact)) return false;
		}
		return true;
	}
}
