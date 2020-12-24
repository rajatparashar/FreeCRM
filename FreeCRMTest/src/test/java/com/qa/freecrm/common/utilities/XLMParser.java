package com.qa.freecrm.common.utilities;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XLMParser {

	public static String readXML(String prop) throws Exception {
		String output = "";
		try {
			File xmlFile = new File(System.getProperty("user.dir") + "//TestData//loginData.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("login");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					if (prop.equalsIgnoreCase("url")) {
						output = eElement.getElementsByTagName("url").item(0).getTextContent();
					} else if (prop.equalsIgnoreCase("username")) {
						output = eElement.getElementsByTagName("username").item(0).getTextContent();
					} else if (prop.equalsIgnoreCase("password")) {
						output = eElement.getElementsByTagName("password").item(0).getTextContent();
					} else if (prop.equalsIgnoreCase("browser")) {
						output = eElement.getElementsByTagName("browser").item(0).getTextContent();
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return output.trim();
	}

	public static String geturl() throws Exception {
		System.out.println(readXML("url"));
		return readXML("url");
	}

	public static String getusername() throws Exception {
		System.out.println(readXML("username"));
		return readXML("username");
	}

	public static String getpassword() throws Exception {
		System.out.println(readXML("password"));
		return readXML("password");
	}
	
	public static String getbrowser() throws Exception {
		System.out.println(readXML("browser"));
		return readXML("browser");
	}

	public static void main(String[] args) throws Exception {
		geturl();
		getusername();
		getpassword();
		getbrowser();
	}
}