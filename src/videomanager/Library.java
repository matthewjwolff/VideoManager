/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
    public Library(File location)
    {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder builder = factory.newDocumentBuilder();
        //Document doc = builder.parse(location);
    }
}
