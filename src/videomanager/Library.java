/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Library extends HashSet<Video> {
    
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
     */
    public void saveTo(File file)
    {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Node currentNode = doc.appendChild(doc.createElement("xml"));
            for(Video v : this)
            {
                currentNode = currentNode.appendChild(doc.createElement("video"));
                currentNode.appendChild(doc.createElement("location").appendChild(doc.createTextNode(v.location.getPath())));
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
            } catch (IOException | TransformerException ex) {
                Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   catch (ParserConfigurationException | TransformerConfigurationException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //load from xml
    /**
     * Loads the previous run's library
     * @param file file to load from 
     */
    public Library(File file)
    {
        super();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            NodeList videos = doc.getElementsByTagName("video");
            for(int i=0; i<videos.getLength(); i++)
            {
                NodeList XMLTags = videos.item(i).getChildNodes();
                URI location = new URI(XMLTags.item(0).getTextContent());
                String title = XMLTags.item(1).getTextContent();
                HashSet<Tag> tags = new HashSet<>();
                for(int j=2; j<XMLTags.getLength(); j++)
                    tags.add(new Tag(XMLTags.item(j).getNodeName(),XMLTags.item(j).getNodeValue()));
                this.add(new Video(location,title,tags));
            }
        } catch (IOException | ParserConfigurationException | SAXException | URISyntaxException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Note about the following method:
     * 
     * I overrode add() to code for the possibility of adding a Video object that points to
     * the same video URL but has different tags. The tags would need to be combined.
     * This gets complicated because of how a HashSet works.
     * 
     * An alternative would be to not override the method and just leave it up to
     * someone coding a client to handle adding a video that has already been entered.
     * I'm leaning toward that option.
     */
    
    /**
     * Adds the video to the Library.
     * If the video is not in the library already, it is added as usual.
     * If it is in the library, the copy in the library is extracted. The copy's
     * tags are combined with v's tags and then v is inserted into the Library.
     * @param v the video to add.
     * @return true if the video was a valid addition (was not present already).
     */
    @Override
    public boolean add(Video v)
    {
        if(contains(v))
        {
            Video present = null;
            for(Video i : this)
            {
                if(i.equals(v))
                {
                    present = i;
                    break;
                }
            }
            if(present.tags.equals(v)) return false;
            this.remove(present);
            v.combineTags(present);
            this.add(v);
            return false;
        } else return super.add(v);
    }
}
