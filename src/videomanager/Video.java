/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthew Wolff
 */
public class Video {
    public URI location;
    public Time length;
    public String title;
    public HashSet<Tag> tags;
    public int hash;
    
    /**
     * Creates a new Video object representing an entry in the Library
     * @param location the path, local or remote, to the file
     * @param title Name of video
     * @param tags the tags associated with this video
     */
    public Video(URI location, String title, HashSet<Tag> tags)
    {
        this.location = location;
        this.tags = tags;
        this.title = title;
    }
    
    /**
     * Returns true if this video points to the same location as another.
     * Possibly check for URI's .equals()
     * This method only takes the location (a URI) into account.
     * @param o the object to compare
     * @return true (possibly) if both locations are the same, false if they are different or o is not a Video.
     */
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Video)
            return ((Video)o).location.equals(this.location);
        else return false;
    }

    /**
     * Auto generated hash code by Netbeans taking only location into account
     * @return the hash code of this object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.location);
        return hash;
    }
    
    public void watch()
    {
        try {
            Desktop.getDesktop().browse(location);
        } catch (IOException ex) {
            Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
