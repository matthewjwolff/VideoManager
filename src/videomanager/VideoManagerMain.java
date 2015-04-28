package videomanager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * This application allows the user to efficiently navigate through videos based on content-specific tags.
 * The application was developed with the intended use of storing Super Smash Bros. Melee videos, but it is not limited to just those videos.
 * Code logic was developed by Matthew Wolff.
 * GUI logic and design was developed by Quin Mese.
 * Testing was conducted by Xin Shu.
 * @author Matthew Wolff, Xin Shu, Qin Mese
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
        String testChar = charArray[charIdx];
        testTags.add(new Tag("character",testChar));
        
        //Get random stage:
        int stageIdx = r.nextInt(stageArray.length);
        String testStage = stageArray[stageIdx];
        testTags.add(new Tag("stage",testStage));
        
        Tag equalityTest = new Tag("stage","Final Destination");
        System.out.println("Equal = "+equalityTest.equals(equalityTest));
        
        System.out.println("Tags are:");
        System.out.println(testTags.toString());
        
        String testURL = "https://youtu.be/7hbpsmTd4PY?t=7m48s";
        Video test = new Video(testURL,"testVideo",testTags);
        System.out.println("Video added = "+videoLib.add(test));
        
        System.out.println("A video has successfully been saved with the following tags: ");
        System.out.println(((Video)videoLib.toArray()[0]).tags);
        
        ArrayList<Video> resultVideos = new QueryResult(videoLib, testTags).getResult();
        //Video identical = videoLib.getIdentical(test);
        videoLib.saveTo(libraryFile);
        
        System.out.println(resultVideos);
        
        //identical.watch();
        
    }
    
}
