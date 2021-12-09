package Model;
//WORKS
/**
 * A class for the timeslot object
 * @author Sid
 * @version 1.1
 */
public class TimeSlot {

    private int hourStart;
    private int minuteStart;
    private int hourEnd;
    private int minuteEnd;
    private char day;

    /**
     * 3 argument constructor initializing the timeslot
     * @param hourStart the starting hour
     * @param minuteStart the starting minute
     * @param hourEnd the ending hour
     * @param minuteEnd the ending minute
     * @param day indicates the day of the week using 0, 1, 2, 3, 4, 5, 6 (0 is sunday)
     */
    public TimeSlot(int hourStart, int minuteStart, int hourEnd, int minuteEnd, char day)
    {
        this.hourStart=hourStart;
        this.minuteStart=minuteStart;
        this.hourEnd=hourEnd;
        this.minuteEnd=minuteEnd;
        this.day=day;

    }

    /**
     * returns the starting hour
     * @return the starting hour
     */
    public int getHourStart()
    {
        return hourStart;
    }

    /**
     * returns the starting minute
     * @return the starting minute
     */
    public int getMinutStarte()
    {
        return minuteStart;
    }

    /**
     * returns the ending hour
     * @return the ending hour
     */

    public int getHourEnd()
    {
        return hourEnd;
    }

    /**
     * returns the ending minute
     * @return the ending minute
     */
    public int getMinuteEnd()
    {
        return hourEnd;
    }

    /**
     * returns the day of the lesson
     * @return the day of the lesson
     */
    public char getDay()
    {
        return day;
    }

    /**
     * compares two different timeslots and checks if they overlap or not
     * @param newTimeSlot a new timeslot to ompare the other one to
     * @return true or false, depending on if it overlaps or not
     */
    public boolean overLap(TimeSlot newTimeSlot)
    {
        if (day!= newTimeSlot.day)
        {
            return false;
        }
        else if (hourStart > newTimeSlot.hourEnd)
        {
            return false;
        }
        else if (hourEnd < newTimeSlot.hourStart)
        {
            return false;
        }
        else if (hourStart==newTimeSlot.hourEnd && minuteStart>=newTimeSlot.minuteEnd)
        {
            return false;
        }
        else if (hourEnd==newTimeSlot.hourStart && minuteEnd >=newTimeSlot.minuteStart)
        {
            return false;
        }
        return true;

    }
    /**
     * equals() method to check if an object is the same as a teacher object
     * @param obj object to be compared
     * @return true if the two objects are equal and false otherwise
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof TimeSlot))
        {
            return false;
        }
        TimeSlot other = (TimeSlot) obj;
        return hourStart==other.hourStart && hourEnd==other.hourEnd && minuteStart==other.minuteEnd && day==other.day;

    }


}
