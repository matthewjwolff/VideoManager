/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Matthew Wolff
 */
public class Library extends ArrayList<Video> {
    
    //Make an XML and save the library
    /**
     * Saves the current Library as an XML File formatted thusly:
     * xml
     *      video
     *          location ... /location
     *          title ... /title
     *          tag1 ... /tag1
     *          ...
     *      /video
     * /xml
     * @param file to save to
     * @throws ParserConfigurationException
     * @throws TransformerConfigurationException
     * @throws TransformerException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveTo(File file) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, FileNotFoundException, IOException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Node currentNode = doc.appendChild(doc.createElement("xml"));
        for(Video v : this)
        {
            currentNode = currentNode.appendChild(doc.createElement("video"));
            currentNode.appendChild(doc.createElement("location").appendChild(doc.createTextNode(v.location)));
            currentNode.appendChild(doc.createElement("title").appendChild(doc.createTextNode(v.title)));
            for(Tag t : v.tags)
                currentNode.appendChild(doc.createElement(t.type).appendChild(doc.createTextNode(t.value)));
        }
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        try (FileOutputStream output = new FileOutputStream(file)) {
            StreamResult result = new StreamResult(output);
            transformer.transform(source, result);
        }
    }
    
    //load from xml
    /**
     * Loads the previous run's library
     * @param file file to load from
     * @throws SAXException
     * @throws ParserConfigurationException
     * @throws IOException 
     */
    public Library(File file) throws SAXException, ParserConfigurationException, IOException
    {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        NodeList videos = doc.getElementsByTagName("video");
        for(int i=0; i<videos.getLength(); i++)
        {
            NodeList XMLTags = videos.item(i).getChildNodes();
            String location = XMLTags.item(0).getTextContent();
            String title = XMLTags.item(1).getTextContent();
            ArrayList<Tag> tags = new ArrayList<>();
            for(int j=2; j<XMLTags.getLength(); j++)
                tags.add(new Tag(XMLTags.item(j).getNodeName(),XMLTags.item(j).getNodeValue()));
            this.add(new Video(location,title,tags));
        }
    }
}
