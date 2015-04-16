/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Matthew Wolff
 */
public class VideoManagerMain {
    
    public static String[] charArray = {"Captain Falcon", "Donkey Kong", "Fox", 
        "Jigglypuff", "Kirby", "Link", "Luigi", "Mario", "Ness", "Pikachu",
        "Samus", "Yoshi, Bowser", "Dr. Mario", "Falco", "Ganondorf", 
        "Ice Climbers", "Marth", "Mewtwo", "Mr. Game & Watch", "Peach", 
        "Pichu", "Roy", "Sheik", "Young Link", "Zelda"};
    public static String[] stageArray = {"Final Destination", "Battlefield",
        "Dreamland", "Yoshi's Story", "Fountain of Dreams", "Pokemon Stadium",
        "Kongo Jungle"};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //For Quin: to launch gui, uncomment following line.
        //videomanager.gui.VideoManagerClient.main(args);
        
        Library videoLib = new Library(fileLoc)
        
        ArrayList<Tag> testTags = new ArrayList<>();
        Random r = new Random();
        
        //Get random character:
        int charIdx = r.nextInt(charArray.length);
        testTags.add(new Tag("character",charArray[charIdx]));
        
        //Get random stage:
        int stageIdx = r.nextInt(stageArray.length);
        testTags.add(new Tag("stage",charArray[stageIdx]));
        
        ArrayList<Video> resultVideos = new QueryResult(videoLib, testTags).getResult();
        
    }
    
}
