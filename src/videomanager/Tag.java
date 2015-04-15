/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

/**
 *
 * @author Matthew Wolff
 */
public class Tag {
    /**
     * Type of tag (like "character", "venue", "tournament", etc.)
     */
    public String type;
    /**
     * The actual tag (like "fox", "Armada", etc.)
     */
    public String value;
    
    public Tag(String type, String value)
    {
        this.type = type;
        this.value = value;
    }
}
