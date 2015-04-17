package videomanager;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Models a remotely-hosted video tagged with content-related tags.
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
     * Combines the tags of two identical videos, implemented statically.
     * I have no idea why anyone would want this, but it was easy, so why not.
     * Refer to documentation for other combineTags method for serious javadoc.
     * @param first the first video
     * @param second the second video
     * @return the first video with second video's tags added to it.
     */
    public static Video combineTags(Video first, Video second)
    {
        first.combineTags(second);
        return first;
    }
    
    /**
     * Combines the tags of two identical videos. Does not create duplicates.
     * Note: this method does nothing if the videos are not identical.
     * @param other The video whose tags are to be added to this video.
     */
    public void combineTags(Video other)
    {
        if(other.equals(this))
        {
            for(Tag otherTag : other.tags)
                tags.add(otherTag);
        }
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
    
    /**
     * Launches the user's default browser to open the remotely-hosted video.
     */
    public void watch()
    {
        try {
            Desktop.getDesktop().browse(location);
        } catch (IOException ex) {
            Logger.getLogger(Video.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
