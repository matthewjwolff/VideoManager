/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videomanager;

import java.io.File;
import java.util.HashSet;
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
        
        final File libraryFile = new File("library.xml");
        
        Library videoLib = new Library(libraryFile);
        
        HashSet<Tag> testTags = new HashSet<>();
        Random r = new Random();
        r.setSeed(12);
        
        //Get random character:
        int charIdx = r.nextInt(charArray.length);
        testTags.add(new Tag("character",charArray[charIdx]));
        
        //Get random stage:
        int stageIdx = r.nextInt(stageArray.length);
        testTags.add(new Tag("stage",stageArray[stageIdx]));
        
        Video test = new Video("https://youtu.be/7hbpsmTd4PY?t=7m48s","testVideo",testTags);
        videoLib.add(test);
        
        //ArrayList<Video> resultVideos = new QueryResult(videoLib, testTags).getResult();
        Video identical = videoLib.getIdentical(test);
        videoLib.saveTo(libraryFile);
        
        identical.watch();
        
    }
    
}
