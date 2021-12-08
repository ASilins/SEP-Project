package Model;
//WORKS
/**
 * A class for the timeslot object
 * @author Sid and Bhupas
 * @version 1.0
 */
public class TimeSlot {

    private int time;
    private int length;
    private char day;

    /**
     * 3 argument constructor initializing the timeslot
     * @param time the starting time in format 0000
     * @param length the length of the time in minutes
     * @param day indicates the day of the week using 0, 1, 2, 3, 4, 5, 6 (0 is sunday)
     */
    public TimeSlot(int time, int length, char day)
    {
        this.time=time;
        this.length=length;
        this.day=day;

    }

    /**
     * returns the starting time in format 0000
     * @return the starting time in format 0000
     */
    public int getStart()
    {
        return time;
    }

    /**
     * returns the ending time in format 0000
     * @return the starting time plus the length
     */
    public int getEnd()
    {
        return time+length;
    }

    /**
     * compares two different timeslots and checks if they overlap or not
     * @param newTimeSlot a new timeslot to ompare the other one to
     * @return true or false, depending on if it overlaps or not
     */
    public boolean overLap(TimeSlot newTimeSlot)
    {
        if (this.day!= newTimeSlot.day)
        {
            return false;
        }
        if (this.time >= newTimeSlot.getEnd())
        {
            return false;
        }
        if (this.getEnd() <= newTimeSlot.time)
        {
            return false;
        }
        return true;

    }

}
