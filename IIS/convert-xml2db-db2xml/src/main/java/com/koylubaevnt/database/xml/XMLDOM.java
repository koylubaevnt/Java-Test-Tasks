package com.koylubaevnt.database.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.koylubaevnt.database.datasets.StaffingStructureDataSet;

/**
 * Класс для чтения\записи XML файла
 * Использует технологию DOM XML
 *  
 * @author KojlubaevNT
 *
 */
public class XMLDOM  {

	private final static Logger logger = Logger.getLogger(XMLDOM.class);
	
	/**
	 * Метод для чтения XML файла и формирования списка "Штатная структура" (<code>List<StaffingStructureDataSet></code>)
	 * 
	 * @param fileName файл, содержащий данные по штатной структуре для обработки
	 * @return список "Штатная структура"
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static List<StaffingStructureDataSet> read(String fileName) throws ParserConfigurationException, SAXException, IOException {
		logger.debug("Начало чтения XML файла: \"" + fileName + "\"");		
		List<StaffingStructureDataSet> list = new ArrayList<StaffingStructureDataSet>();
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = documentBuilder.parse(fileName);
		Node root = document.getDocumentElement();
		NodeList entities = root.getChildNodes();
		for (int i = 0; i < entities.getLength(); i++) {
            Node entity = entities.item(i);
            if (entity.getNodeType() == Node.ELEMENT_NODE && entity.getNodeName().equals("StaffingStructureDataSet")) {
	            NamedNodeMap attrributes = entity.getAttributes();
	            if(attrributes != null &&
	            		attrributes.getNamedItem("depCode") != null
	            		&& attrributes.getNamedItem("depJob") != null
	            		) {
	            	Node AttrDesc = attrributes.getNamedItem("description");
		            list.add(new StaffingStructureDataSet(
		            		attrributes.getNamedItem("depCode").getNodeValue(),
		            		attrributes.getNamedItem("depJob").getNodeValue(),
		            		(AttrDesc == null ? "" : AttrDesc.getNodeValue())));
		            logger.debug("Элемент: \"" + list.get(list.size() - 1) + "\" прочитан");
	            }
            }
        }
        logger.debug("Окончание чтения XML файла: \"" + fileName + "\"");		
		
		return list;	
	}

	/**
	 * Метод для записи данных "Штатная структура" (<code>StaffingStructureDataSet</code>) в XML файл
	 * 
	 * @param list список "Штатная структцура" для записи в XML
	 * @param fileName файл для записи данных
	 *  
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
	public static void write(List<StaffingStructureDataSet> list, String fileName) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		logger.debug("Начало записи данных \"" + list.stream().map(Object::toString).collect(Collectors.joining(",")) + "\" в XML файл: \"" + fileName + "\"");		
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("list");
		doc.appendChild(rootElement);
		for(StaffingStructureDataSet entity : list) {
			Element staff = doc.createElement("StaffingStructureDataSet");
			rootElement.appendChild(staff);
			Attr attr = doc.createAttribute("depCode");
			attr.setValue(entity.getDepCode());
			staff.setAttributeNode(attr);
			attr = doc.createAttribute("depJob");
			attr.setValue(entity.getDepJob());
			staff.setAttributeNode(attr);
			attr = doc.createAttribute("description");
			attr.setValue(entity.getDescription());
			staff.setAttributeNode(attr);
			logger.debug("Элемент \"" + entity + "\" записан");
			
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(fileName));
		transformer.transform(source, result);
		logger.debug("Конец записи данных в XML файл: \"" + fileName + "\"");		
	}


	
}
