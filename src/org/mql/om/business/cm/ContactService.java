package org.mql.om.business.cm;

import java.util.Hashtable;
import java.util.List;

import org.mql.om.models.cm.Contact;

/**
 * @author SAAD MOUMEN
 *
 */
public interface ContactService {
	public int addContact(Contact contact);
	public int editContact(Contact contact);
	public int removeContact(String contactId);
	public Contact getContact(String contactId);
	public List<Contact> contactList();
	public List<Contact> contactList(Hashtable<String, String> traits);
}
