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
public class VideoList {
    public Tag[] tags;
    public ArrayList<Video> videos;
    
    void getVideosFromTags()
    {
        //go through each tag, get all videos, check for duplicates.
    }
    
    boolean equals(VideoList other)
    {
        //If same videos are in each list and they have the same number of videos.
        return videos.containsAll(other.videos)&&videos.size()==other.videos.size();
    }
}
