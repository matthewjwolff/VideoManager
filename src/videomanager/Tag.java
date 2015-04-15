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
public class Tag extends ArrayList<Video>{
    public String type;
    public String value;
    
    public Tag(String type, String value)
    {
        this.type = type;
        this.value = value;
    }
}
