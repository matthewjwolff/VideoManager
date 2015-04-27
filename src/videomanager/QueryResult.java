package videomanager;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Stores the results of a query to the Video Library
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
    public QueryResult(Library videos, HashSet<Tag> tags)
    {
        result = new ArrayList<>();
        for(Video i : videos)
        {
            if(i.tags.containsAll(tags))
                result.add(i);
        }
    }
    /**
     * Returns the result of the query as an ArrayList of Videos
     * @return the result of the query
     */
    public ArrayList<Video> getResult()
    {
        return result;
    }
}
