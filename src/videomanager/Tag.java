package videomanager;

import java.util.Objects;

/**
 * Represents a two-string Tag of type and value.
 * Note the attributes, methods, and parameters of this class are case sensitive.
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
    
    /**
     * Simple constructor
     * @param type the type of tag (e.g. "character")
     * @param value the value of the tag (e.g. "fox")
     */
    public Tag(String type, String value)
    {
        this.type = type;
        this.value = value;
    }
    
    /**
     * Formats this class as a String
     * @return "type: value"
     */
    @Override
    public String toString()
    {
        return this.type + ": "+this.value;
    }
    
    /**
     * Tests for equality with another Tag object.
     * @param o the object to which this object will be compared
     * @return true if the tag and value are equal, false otherwise
     */
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Tag)
        {
            Tag other = (Tag)o;
            return type.equals(other.type)&&(value.equals(other.value));
        }
        return false;
    }

    /**
     * As per contract, the hashcode must be overrode since equals was overrode.
     * @return a hash code taking into account only type and value
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.value);
        return hash;
    }
}
