/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Matthew Wolff
 */
public class Library extends ArrayList<Video> {
    
    //Make an XML and save the library
    public void saveTo(File location) throws ParserConfigurationException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
    }
    
    //load from xml
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
