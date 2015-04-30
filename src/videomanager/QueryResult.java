package videomanager;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.DefaultListModel;

/**
 * Stores the results of a query to the Video Library
 * @author Matthew Wolff
 */
public class QueryResult 
{
    private final DefaultListModel<Video> result;
    
    /**
     * Execute the Search on the given set of videos
     * @param videos the set of all videos
     * @param tags set of tags to search for
     */
    public QueryResult(Library videos, HashSet<Tag> tags)
    {
        result = new DefaultListModel<>();
        int index = 0;
        for(Video i : videos)
        {
            if(i.tags.containsAll(tags))
                result.add(index++,i);
        }
    }
    /**
     * Returns the result of the query as an ArrayList of Videos
     * @return the result of the query
     */
    public DefaultListModel<Video> getResult()
    {
        return result;
    }
}
