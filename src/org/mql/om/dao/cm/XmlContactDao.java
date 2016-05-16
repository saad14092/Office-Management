package org.mql.om.dao.cm;

import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.mql.om.dao.cm.filtering.ContactFilter;
import org.mql.om.dao.cm.filtering.criterias.AddressFilterCriteria;
import org.mql.om.dao.cm.filtering.criterias.BirthDateFilterCriteria;
import org.mql.om.dao.cm.filtering.criterias.EmailFilterCriteria;
import org.mql.om.dao.cm.filtering.criterias.FirstNameFilterCriteria;
import org.mql.om.dao.cm.filtering.criterias.LastNameFilterCriteria;
import org.mql.om.dao.cm.filtering.criterias.OrgFilterCriteria;
import org.mql.om.dao.cm.filtering.criterias.PhoneFilterCriteria;
import org.mql.om.dao.cm.filtering.criterias.WebsiteFilterCriteria;
import org.mql.om.dao.cm.mappers.XmlContactMapper;
import org.mql.om.models.cm.Address;
import org.mql.om.models.cm.Contact;
import org.mql.om.models.cm.Date;
import org.mql.om.models.cm.Email;
import org.mql.om.models.cm.Phone;
import org.mql.om.xml.XmlReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
/**
 * @author SAAD MOUMEN
 *
 */
public class XmlContactDao implements ContactDao {
	private static final String source = "database/contacts/contacts.xml";
	private XmlReader xmlReader;
	private XmlContactMapper mapper;

	public XmlContactDao() {
	}

	public XmlContactDao(XmlReader xmlReader) {
		this.xmlReader = xmlReader;
		mapper = new XmlContactMapper(xmlReader);
	}

	/* 
	 * inserts a Contact object into the XML file
	 */
	public int insert(Contact contact) {
		try {
			Document doc = xmlReader.open(source);
			Node root = xmlReader.getRoot(doc);
			Element newContact = (Element)mapper.toNode(contact, doc);
			String  lastId = xmlReader.getAttribute(xmlReader.getLastChildElement(doc.getDocumentElement()), "id");
			String newId = lastId.substring(lastId.length() - 2);
			newContact.setAttribute("id", "C0" + (Integer.parseInt(newId) + 1));
			root.appendChild(newContact);
			transform(doc);
			return 1;
		}
		catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
			return 0;
		}
	}
	
	/* 
	 * Updates an existing contact in the XML file
	 */
	public int update(Contact contact) {
		try {
			Document doc = xmlReader.open(source);
			Node root = xmlReader.getRoot(doc);
			Node oldNode =  xmlReader.getElementChild(root, "contact", "id", contact.getId());
			Element newNode = (Element)mapper.toNode(contact, doc);
			newNode.setAttribute("id", contact.getId());
			root.replaceChild(newNode, oldNode);
			transform(doc);

			
			return 1;
		}
		catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
			return 0;
		}
		
	}

	/* 
	 * Removes the contact Element with the specified id
	 */
	public int delete(String contactId) {
		try{
			Document doc = xmlReader.open(source);
			Node root = xmlReader.getRoot(doc);
			Node toRemove = xmlReader.getElementChild(root, "contact", "id", contactId);
			if (toRemove != null) {
				root.removeChild(toRemove);
				transform(doc);
			}
			return 1;
		}
		catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
			return 0;
		}
	}

	/* 
	 * Returns all contacts that match the traits given in the Hashtable
	 */
	public List<Contact> find(Hashtable<String, String> traits) {
		ContactFilter contactFilter = createFilter(traits);
		Vector<Contact> contacts = new Vector<>();
			for (Contact contact : selectAll()) {
				if(contactFilter.filter(contact))
					//System.out.println(contactFilter.filter(contact));
					contacts.add(contact);
			}
			return contacts;
	}
	
	public Contact select(String contactId) {
		Document doc = xmlReader.open(source);
		Node root = xmlReader.getRoot(doc);
		Contact c = mapper.toContact((xmlReader.getElementChild(root, "contact", "id", contactId)));
		return c;
	}

	/* 
	 * Returns all existing contacts in XML file
	 */
	public List<Contact> selectAll() {
		Vector<Contact> contacts = new Vector<>();
		try {
			Document doc = xmlReader.open(source);
			Node root = xmlReader.getRoot(doc);
			Node[] contactList = xmlReader.getElementChildren(root, "contact");
			
			for (int i = 0; i < contactList.length; i++) {
				contacts.add(mapper.toContact(contactList[i]));
			}

			return contacts;
		}
		catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
			return null;
		}
	}

	public void setXmlReader(XmlReader xmlReader) {
		this.xmlReader = xmlReader;
	}

	private void transform(Document doc) {

		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(new File(source));
			DOMSource domSource = new DOMSource(doc);
			transformer.transform(domSource, result);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		} 
	}
	
	private ContactFilter createFilter(Hashtable<String, String> traits) {
		ContactFilter cf = new ContactFilter();
		if (traits.containsKey("FirstName")) cf.add(new FirstNameFilterCriteria(traits.get("FirstName")));
		if (traits.containsKey("LastName")) cf.add(new LastNameFilterCriteria(traits.get("LastName")));
		if (traits.containsKey("Email")) cf.add(new EmailFilterCriteria(traits.get("Email")));
		if (traits.containsKey("Address")) cf.add(new AddressFilterCriteria(traits.get("Address")));
		if (traits.containsKey("Phone")) cf.add(new PhoneFilterCriteria(traits.get("Phone")));
		if (traits.containsKey("Website")) cf.add(new WebsiteFilterCriteria(traits.get("Website")));
		if (traits.containsKey("Org")) cf.add(new OrgFilterCriteria(traits.get("Org")));
		if (traits.containsKey("BirthDate")) cf.add(new BirthDateFilterCriteria(traits.get("BirthDate")));
		
		return cf;
	}


}
