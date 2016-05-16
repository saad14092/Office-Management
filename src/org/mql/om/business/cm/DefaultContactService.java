package org.mql.om.business.cm;

import java.util.Hashtable;
import java.util.List;

import org.mql.om.dao.cm.ContactDao;
import org.mql.om.models.cm.Contact;

/**
 * @author SAAD MOUMEN
 *
 */
public class DefaultContactService implements ContactService {
	private ContactDao contactDao;
	
	public DefaultContactService() {
		super();
	}

	public DefaultContactService(ContactDao contactDao) {
		super();
		this.contactDao = contactDao;
	}

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public int addContact(Contact contact) {
		return contactDao.insert(contact);
	}

	public int editContact(Contact contact) {
		return contactDao.update(contact);
	}

	public int removeContact(String contactId) {
		return contactDao.delete(contactId);
	}

	public Contact getContact(String contactId) {
		return contactDao.select(contactId);
	}

	public List<Contact> contactList() {
		return contactDao.selectAll();
	}

	public List<Contact> contactList(Hashtable<String, String> traits) {
		return contactDao.find(traits);
	}

}
