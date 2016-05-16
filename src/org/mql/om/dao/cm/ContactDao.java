package org.mql.om.dao.cm;

import java.util.Hashtable;
import java.util.List;
import org.mql.om.models.cm.Contact;

/**
 * @author SAAD MOUMEN
 *
 */
public interface ContactDao {
	
	public int insert(Contact contact);
	public int update(Contact contact);
	public int delete(String contactId);
	public List<Contact> find(Hashtable<String, String> traits);
	public Contact select(String contactId);
	public List<Contact> selectAll();
	
}
