package videomanager;

import java.io.File;
import java.util.HashSet;
import java.util.Random;
import javax.swing.DefaultListModel;

/**
 * This application allows the user to efficiently navigate through videos based on content-specific tags.
 * The application was developed with the intended use of storing Super Smash Bros. Melee videos, but it is not limited to just those videos.
 * Code logic was developed by Matthew Wolff.
 * GUI logic and design was developed by Quin Mese.
 * Testing was conducted by Xin Shu.
 * @author Matthew Wolff, Xin Shu, Quin Mese
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
    public static String[] urlArray = {"https://youtu.be/7hbpsmTd4PY?t=7m48s",
        "https://www.youtube.com/watch?v=Gv74JXJBFwk",
        "https://youtu.be/A60AjGrwEyo?t=3m10s"};
    public static String[] titleArray = {"Grudge of Louisiana Melee - Noge "
            + "(Fox) vs MH | Dom (Peach)","Apex 2015 - Leffen (Fox) Vs. "
            + "EG | PPMD (Marth) SSBM Winners Finals - Smash Melee",
            "SS/Tang(Green) vs Zhu/Lucky(Blue)2"};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //For Quin: to launch gui, uncomment following line.
        videomanager.gui.VideoManagerClient.main(args);
        
//        final File libraryFile = new File("library.xml");
//        
//        Library videoLib = new Library(libraryFile);
//        
//        HashSet<Tag> testTags = new HashSet<>();
//        Random r = new Random();
//        //r.setSeed(12);
//        
//        //Get random character:
//        int charIdx = r.nextInt(charArray.length);
//        String testChar = charArray[charIdx];
//        testTags.add(new Tag("character",testChar));
//        
//        //Get random stage:
//        int stageIdx = r.nextInt(stageArray.length);
//        String testStage = stageArray[stageIdx];
//        testTags.add(new Tag("stage",testStage));
//        
//        //Get random URL and its corresponding title:
//        int urlIdx = r.nextInt(urlArray.length);
//        String testURL = urlArray[urlIdx];
//        String testTitle = titleArray[urlIdx];
//        
//        System.out.println("Random test video to add:");
//        System.out.println("Title: " + testTitle);
//        System.out.println("URL: " + testURL);
//        System.out.println("Tags: " + testTags.toString());
//        System.out.println("");
//        
//        System.out.println("Adding video...");
//        Video test = new Video(testURL,testTitle,testTags);
//        System.out.println("Video added = "+videoLib.add(test));
//        
//        System.out.println("The library now includes the following videos:");
//        System.out.println("");
//        for(Video j : videoLib)
//        {
//            System.out.println("Title: " + j.toString());
//            System.out.println("URL: " + j.location);
//            System.out.println("Tags: " + j.tags);
//            System.out.println("");
//        }
//
//        
//        DefaultListModel<Video> resultVideos = new QueryResult(videoLib, testTags).getResult();
//
//        videoLib.saveTo(libraryFile);
//        
//        System.out.println(resultVideos);

        
    }
    
}
