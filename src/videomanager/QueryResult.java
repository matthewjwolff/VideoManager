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
public class QueryResult 
{
    private final ArrayList<Video> result;
    
    /**
     * Execute the Search on the given set of videos
     * @param videos the set of all videos
     * @param tags set of tags to search for
     */
    public QueryResult(Library videos, ArrayList<Tag> tags)
    {
        result = new ArrayList<>();
        for(Video i : videos)
        {
            if(i.tags.containsAll(tags))
                result.add(i);
        }
    }
    public ArrayList<Video> getResult()
    {
        return result;
    }
}
