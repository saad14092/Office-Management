package org.mql.om.web;

import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import org.mql.om.dao.cm.ContactDao;
import org.mql.om.dao.cm.XmlContactDao;
import org.mql.om.models.cm.Address;
import org.mql.om.models.cm.Contact;
import org.mql.om.models.cm.Date;
import org.mql.om.models.cm.Email;
import org.mql.om.models.cm.Phone;
import org.mql.om.xml.XmlNodeReader;


/**
 * @author SAAD MOUMEN
 *
 */
public class ToDelete {

	public ToDelete() {
		exp04();
	}
	
	void exp01() {
		ContactDao cd = new XmlContactDao(new XmlNodeReader());
		List<Contact> contacts =  cd.selectAll();
		System.out.println(contacts);
	}

	void exp02() {
		ContactDao dao = new XmlContactDao(new XmlNodeReader());
		Contact contact = new Contact();
		contact.setFname("John");
		contact.setLname("Doe");
		contact.setTitle("Mr");
		contact.setBdate(new Date("1984-10-15"));
		Vector<Phone> phones = new Vector<>();
		Vector<Address> adresses = new Vector<>();
		Vector<Email> emails = new Vector<>();
		Phone p1 = new Phone("06 01 04 90 02");
		p1.setType("cell");
		phones.add(p1);
		Phone p2 = new Phone("+33 535 16 18 57");
		p2.setType("fax");
		phones.add(p2);
		Address a1 = new Address("21 av des FARs Fes 30000", "wadr");
		Address a2 = new Address("54 quartier Rfaif Sefrou 31000", "hadr");
		adresses.add(a1);
		adresses.add(a2);
		Email e1 = new Email("doe.john@mymail.com");
		Email e2 = new Email("doe.john75@corps.com");
		e2.setType("wemail");
		emails.add(e1);
		emails.add(e2);
		contact.setAddresses(adresses);
		contact.setEmails(emails);
		contact.setPhones(phones);
		int i = dao.insert(contact);
		System.out.println(i);
	}
	
	void exp03() {
//		String s = "00212";
//		s = s.replace("00", "+");
//		System.out.println(s);
//		ContactDao dao = new XmlContactDao(new XmlNodeReader());
//		int i = dao.delete(s);
		GregorianCalendar g = new GregorianCalendar(2012, 1, 12);
		System.out.println(g.get(GregorianCalendar.DAY_OF_MONTH) + "-" + g.get(GregorianCalendar.MONTH) + "-" + g.get(GregorianCalendar.YEAR));
		
	}
	
	void exp04() {
		ContactDao dao = new XmlContactDao(new XmlNodeReader());
		Hashtable<String, String> traits = new Hashtable<>();
		traits.put("Email", "saad14092@gmail.com");
		traits.put("Phone", "00212 660 29 45 96");
		traits.put("Website", "https://www.linkedin.com/IN/saadmoumen");
		List<Contact> contacts = dao.find(traits);
		System.out.println(contacts);
	}
	
	public static void main(String[] args) {
		new ToDelete();
	}
}
