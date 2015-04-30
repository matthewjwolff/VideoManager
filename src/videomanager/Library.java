package videomanager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Models a set of videos marked with content-specific tags.
 * Extends the Java HashSet definition, restricted to the Video class.
 * NOTE: always check if the video is contained in the HashSet before adding:
 * A video is considered equal to another only if they point to the same file.
 * Tags are not taken into account when considering equality; therefore, adding
 * an identical video will not add its tags to the video already in the set.
 * @author Matthew Wolff
 */
public class Library extends HashSet<Video> {
    
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
                Element locationNode = doc.createElement("location");
                locationNode.setTextContent(v.location);
                currentNode.appendChild(locationNode);
                Element titleNode = doc.createElement("title");
                titleNode.setTextContent(v.title);
                currentNode.appendChild(titleNode);
                for(Tag t : v.tags)
                {
                    Element tagNode = doc.createElement(t.type);
                    tagNode.setTextContent(t.value);
                    currentNode.appendChild(tagNode);
                }
                currentNode = currentNode.getParentNode();
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
    
    /**
     * Searches through this HashSet for a video identical to the parameter.
     * Their tags are not guaranteed to be identical; rather, this method should
     * be used to get a video with different tags.
     * @param v the video to find
     * @return the video in this HashSet identical to the parameter
     */
    public Video getIdentical(Video v)
    {
        for(Video i : this)
        {
            if(i.equals(v)) return i;
        }
        return null;
    }

    /**
     * Loads the previous run's library. If the file cannot be found, defaults to an empty library and falls back to the superclass's constructor.
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
                String location = XMLTags.item(0).getTextContent();
                String title = XMLTags.item(1).getTextContent();
                HashSet<Tag> tags = new HashSet<>();
                for(int j=2; j<XMLTags.getLength(); j++)
                {
                    tags.add(new Tag(XMLTags.item(j).getNodeName(),XMLTags.item(j).getTextContent()));
                }
                this.add(new Video(location,title,tags));
            }
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Could not find library file. Assuming this is first run and initializing with empty library.");
        }
    }
}
