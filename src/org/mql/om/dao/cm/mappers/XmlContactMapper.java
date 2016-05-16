package org.mql.om.dao.cm.mappers;

import java.util.Vector;

import org.mql.om.models.cm.Address;
import org.mql.om.models.cm.Contact;
import org.mql.om.models.cm.Date;
import org.mql.om.models.cm.Email;
import org.mql.om.models.cm.Phone;
import org.mql.om.xml.XmlReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlContactMapper {
	private XmlReader xmlReader;
	
	public XmlContactMapper() {
	}
	
	public XmlContactMapper(XmlReader xmlReader) {
		this.xmlReader = xmlReader;
	}
	
	public Contact toContact(Node node) {
		Contact contact = new Contact();
		Vector<Phone> phones = new Vector<>();
		Vector<Address> addresses = new Vector<>();
		Vector<Email> emails = new Vector<>();
		contact.setId(xmlReader.getAttribute(node, "id"));
		Node[] propList = xmlReader.getElementChildren(node, "property");
		for (int j = 0; j < propList.length; j++) {
			String key = xmlReader.getAttribute(propList[j], "name");
			switch (key) {
			case "title":
				contact.setTitle(xmlReader.getAttribute(propList[j], "value"));
				break;

			case "firstname":
				contact.setFname(xmlReader.getAttribute(propList[j], "value"));
				break;

			case "lastname":
				contact.setLname(xmlReader.getAttribute(propList[j], "value"));
				break;

			case "url":
				contact.setWebsite(xmlReader.getAttribute(propList[j], "value"));
				break;

			case "org":
				contact.setOrg(xmlReader.getAttribute(propList[j], "value"));
				break;

			case "note":
				contact.setNote(xmlReader.getAttribute(propList[j], "value"));
				break;

			case "bday":
				Date d = new Date(xmlReader.getAttribute(propList[j], "value"));
				contact.setBdate(d);
				break;

			case "cell":
				Phone p1 = new Phone(xmlReader.getAttribute(propList[j], "value"));
				p1.setType("cell");
				phones.add(p1);
				break;

			case "home":
				Phone p2 = new Phone(xmlReader.getAttribute(propList[j], "value"));
				p2.setType("home");
				phones.add(p2);
				break;

			case "work":
				Phone p3 = new Phone(xmlReader.getAttribute(propList[j], "value"));
				p3.setType("work");
				phones.add(p3);
				break;

			case "fax":
				Phone p4 = new Phone(xmlReader.getAttribute(propList[j], "value"));
				p4.setType("fax");
				phones.add(p4);
				break;

			case "iemail":
				Email e1 = new Email(xmlReader.getAttribute(propList[j], "value"));
				e1.setType("iemail");
				emails.add(e1);
				break;

			case "wemail":
				Email e2 = new Email(xmlReader.getAttribute(propList[j], "value"));
				e2.setType("wemail");
				emails.add(e2);
				break;

			case "hadr":
				Address a1 = new Address(xmlReader.getAttribute(propList[j], "value"));
				a1.setType("hadr");
				addresses.add(a1);
				break;

			case "wadr":
				Address a2 = new Address(xmlReader.getAttribute(propList[j], "value"));
				a2.setType("wadr");
				addresses.add(a2);
				break;

			default:
				break;
			}

		}
		contact.setAddresses(addresses);
		contact.setEmails(emails);
		contact.setPhones(phones);
		
		return contact;
	}
	
	public Node toNode(Contact contact, Document doc) {
		Element newContact = doc.createElement("contact");
		
		newContact.appendChild(createProperty(doc, "firstname", contact.getFname()));
		newContact.appendChild(createProperty(doc, "lastname", contact.getLname()));
		newContact.appendChild(createProperty(doc, "title", contact.getTitle()));
		for (Phone phone : contact.getPhones()) {
			newContact.appendChild(createProperty(doc, phone.getType(),
			phone.getCountryCode() + " " + phone.getPhoneNumber()));
		}
		
		for (Email email : contact.getEmails()) {
			newContact.appendChild(createProperty(doc, email.getType(),email.getEmail()));
		}
		
		newContact.appendChild(createProperty(doc, "url", contact.getWebsite()));
		
		for (Address address : contact.getAddresses()) {
			newContact.appendChild(createProperty(doc, address.getType(), address.getAddress()));
		}
		
		newContact.appendChild(createProperty(doc, "bday", contact.getBdate().getYear() 
				+ "-" + contact.getBdate().getMonth() + "-"
				+ contact.getBdate().getDay()));
		
		newContact.appendChild(createProperty(doc, "org", contact.getOrg()));
		newContact.appendChild(createProperty(doc, "note", contact.getNote()));

		return newContact;
	}
	
	private Node createProperty(Document doc, String name, String value) {
        Element node = doc.createElement("property");
        node.setAttribute("name", name);
        node.setAttribute("value", value);
        return node;
        
    }

	public void setXmlReader(XmlReader xmlReader) {
		this.xmlReader = xmlReader;
	}
	
	
}
