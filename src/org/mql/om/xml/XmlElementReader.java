package org.mql.om.xml;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlElementReader implements XmlReader {

	public XmlElementReader() {
		
	}

	@Override
	public Document open(String source) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //factory Bean
			DocumentBuilder builder = factory.newDocumentBuilder(); //factory method
			Document doc = builder.parse(source);
			
			return doc;
			
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

	@Override
	public Element getRoot(Document document) {
		try {
			return document.getDocumentElement();
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

	@Override
	public Element[] getElementChildren(Node n) {
		Vector<Element> children = new Vector<>();
		NodeList list = n.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node f = list.item(i);
			if(f.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element)f;
				children.add(e);
			}
		}
		Element t[] = new Element[children.size()];
		children.toArray(t);
		return t;
	}

	@Override
	public Element[] getElementChildren(Node n, String name) {
		Vector<Element> children = new Vector<>();
		NodeList list = n.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node f = list.item(i);
			if(f.getNodeType() == Node.ELEMENT_NODE && f.getNodeName().equals(name)) {
				Element e = (Element)f;
				children.add(e);
			}
		}
		Element t[] = new Element[children.size()];
		children.toArray(t);
		return t;
	}

	@Override
	public String getAttribute(Node n, String name) {
		Element e = (Element)n;
		return e.getAttributeNode(name).getValue();
	}

	@Override
	public int getIntAttribute(Node n, String name) {
		String a = getAttribute(n, name);
		try {
			return Integer.parseInt(a);
		}
		catch(Exception e) {
			return -1;
		}
	}

	@Override
	public double getDoubleAttribute(Node n, String name) {
		String a = getAttribute(n, name);
		try {
			return Double.parseDouble(a);
		}
		catch(Exception e) {
			return -1;
		}
	}

	@Override
	public Element getElementChild(Node n, String name) {
		NodeList list = n.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if(list.item(i).getNodeType() == Node.ELEMENT_NODE && list.item(i).getNodeName().equals(name)) return (Element) list.item(i);
		}
		return null;
	}

	@Override
	public String getValue(Node n) {
		Element e = (Element)n;
		return e.getTextContent();
	}

	@Override
	public int getIntValue(Node n) {
		String v = getValue(n);
		try {
			return Integer.parseInt(v);
		}
		catch(Exception e) {
			return -1;
		}
	}

	@Override
	public double getDoubleValue(Node n) {
		String v = getValue(n);
		try {
			return Double.parseDouble(v);
		}
		catch(Exception e) {
			return -1;
		}
	}

	@Override
	public Element getLastChildElement(Node parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getElementChild(Node n, String name, String attName, String attValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
