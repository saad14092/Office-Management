package org.mql.om.xml;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlNodeReader implements XmlReader {

	public XmlNodeReader() {
	}

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
	
	public Node getRoot(Document document) {
		try {
			return document.getDocumentElement();
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	
	public Node[]getElementChildren(Node n) {
		Vector<Node> children = new Vector<>();
		NodeList list = n.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node f = list.item(i);
			if (f.getNodeType() == Node.ELEMENT_NODE) {
				children.add(f);	
			}
		}
		Node t[] = new Node[children.size()];
		children.toArray(t);
		return t;
	}
	
	public Node[]getElementChildren(Node n, String name) {
		Vector<Node> children = new Vector<>();
		NodeList list = n.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node f = list.item(i);
			if (f.getNodeName().equals(name)) {
				children.add(f);	
			}
		}
		Node t[] = new Node[children.size()];
		children.toArray(t);
		return t;
	}
	
	public String getAttribute(Node n, String name) {
		Node a = n.getAttributes().getNamedItem(name);
		return a.getNodeValue();
		
	}
	
	public int getIntAttribute(Node n, String name) {
		String a = getAttribute(n, name);
		try {
			return Integer.parseInt(a);
		}
		catch(Exception e) {
			return -1;
		}
	}
	
	public double getDoubleAttribute(Node n, String name) {
		String a = getAttribute(n, name);
		try {
			return Double.parseDouble(a);
		}
		catch(Exception e) {
			return -1;
		}
	}
	
	public Node getElementChild(Node n, String name) {
		NodeList list = n.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if(list.item(i).getNodeName().equals(name)) return list.item(i);
		}
		return null;
	}
	
	public Node getElementChild(Node n, String name, String attName, String attValue) {
		Node[] list = getElementChildren(n, name);
		for (int i = 0; i < list.length; i++) {
			if(getAttribute(list[i], attName).equals(attValue)) {
				return list[i];
			}
		}
		return null;
	}
	
	public Element getLastChildElement(Node parent) {      
	      Node child = parent.getLastChild();
	      while (child != null) {
	          if (child.getNodeType() == Node.ELEMENT_NODE) {
	              return (Element)child;
	          }
	          child = child.getPreviousSibling();
	      }
	      
	      return null;
	      
	  }
	
	public String getValue(Node n) {
		return n.getFirstChild().getNodeValue();
		
	}
	
	public int getIntValue(Node n) {
		String v = getValue(n);
		try {
			return Integer.parseInt(v);
		}
		catch(Exception e) {
			return -1;
		}
	}
	
	public double getDoubleValue(Node n) {
		String v = getValue(n);
		try {
			return Double.parseDouble(v);
		}
		catch(Exception e) {
			return -1;
		}
	}
}
