package org.mql.om.dao.cm;

import java.util.List;

import org.mql.om.models.cm.Contact;

public interface ContactDao {
	public int insert(Contact contact);
	public int update(String contactId);
	public int delete(String contactId);
	public Contact find(String keyword);
	public List<Contact> selectAll();
}
