package videomanager;

/**
 * Simple holder class for two ints representing a length of time.
 * @author Matthew Wolff
 */
public class Time {
    public int seconds;
    public int minutes;
    
    public Time(int minutes, int seconds)
    {
        this.seconds = seconds;
        this.minutes = minutes;
    }
}
