/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.util.ArrayList;

/**
 *
 * @author Matthew Wolff
 */
public class Video {
    public String location;
    public Time length;
    public String title;
    public ArrayList<Tag> tags;
    public int hash;
    
    /**
     * Creates a new Video object representing an entry in the Library
     * @param location the path, local or remote, to the file
     * @param title Name of video
     * @param tags the tags associated with this video
     */
    public Video(String location, String title, ArrayList<Tag> tags)
    {
        this.location = location;
        this.tags = tags;
        this.title = title;
    }
    
}
