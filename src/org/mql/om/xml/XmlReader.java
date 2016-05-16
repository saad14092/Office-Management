package org.mql.om.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface XmlReader {

	Document open(String source);

	Node getRoot(Document document);

	Node[] getElementChildren(Node n);

	Node[] getElementChildren(Node n, String name);
	
	Element getLastChildElement(Node parent);

	String getAttribute(Node n, String name);

	int getIntAttribute(Node n, String name);

	double getDoubleAttribute(Node n, String name);

	Node getElementChild(Node n, String name);
	
	Node getElementChild(Node n, String name, String attName, String attValue);

	String getValue(Node n);

	int getIntValue(Node n);

	double getDoubleValue(Node n);

}