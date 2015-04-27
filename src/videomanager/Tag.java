/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.util.Objects;

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
    
    @Override
    public String toString()
    {
        return this.value;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Tag)
            return false;
        Tag other = (Tag)o;
        return (type.equals(other.type))&&(value.equals(other.value));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.value);
        return hash;
    }
}
