package Model;
/**
 * A class for the timeslot object
 * @author Sid
 * @version 1.2
 */
public class TimeSlot {

    private int hourStart;
    private int minuteStart;
    private int hourEnd;
    private int minuteEnd;
    private int dayOftheWeek;
    private String date;
    private int day;
    private int year;
    private int month;

    /**
     * 3 argument constructor initializing the timeslot
     * @param hourStart the starting hour
     * @param minuteStart the starting minute
     * @param hourEnd the ending hour
     * @param minuteEnd the ending minute
     * @param dayOftheWeek indicates the day of the week using 0, 1, 2, 3, 4, 5, 6 (0 is sunday)
     */
    public TimeSlot(int hourStart, int minuteStart, int hourEnd, int minuteEnd, int dayOftheWeek, int year, int month, int day)
    {
        this.hourStart=hourStart;
        this.minuteStart=minuteStart;
        this.hourEnd=hourEnd;
        this.minuteEnd=minuteEnd;
        this.dayOftheWeek=dayOftheWeek;
        this.date=year + "-"+ month +"-"+day;


    }

    public TimeSlot(int hourStart, int minuteStart, int hourEnd, int minuteEnd, int year, int month, int day)
    {
        this.hourStart=hourStart;
        this.minuteStart=minuteStart;
        this.hourEnd=hourEnd;
        this.minuteEnd=minuteEnd;
        dayOftheWeek=-1;
        this.date=year + "-"+ month +"-"+day;


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
     * returns the day of the week in format 0,1,2,3,4,5,6 (0=sunday)
     * @return the day of the week
     */
    public int getDayOftheWeek()
    {
        return dayOftheWeek;
    }

    /**
     * returns the year of the lesson
     * @return the year of the lesson
     */
    public int getYear()
    {
        return year;
    }

    /**
     * returns the month of the lesson
     * @return the month of the lesson
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * returns the day of the lesson
     * @return the day of the lesson
     */
    public int getDay()
    {
        return day;
    }

    /**
     * returns the date of the lesson
     * @return the date of the lesson
     */
    public String getDate()
    {
        return date;
    }

    /**
     * sets the starting hour of the lesson
     * @param hourStart the starting hour of the lesson
     */
    public void setHourStart(int hourStart)
    {
        this.hourStart=hourStart;
    }
    /**
     * sets the ending hour of the lesson
     * @param hourEnd the ending hour of the lesson
     */
    public void setHourEnd(int hourEnd)
    {
        this.hourEnd=hourEnd;
    }
    /**
     * sets the starting minute of the lesson
     * @param minuteStart the starting minute of the lesson
     */
    public void setMinuteStart(int minuteStart)
    {
        this.minuteStart=minuteStart;
    }
    /**
     * sets the ending minute of the lesson
     * @param minuteEnd the ending minute of the lesson
     */
    public void setMinuteEnd(int minuteEnd)
    {
        this.minuteEnd=minuteEnd;
    }
    /**
     * sets the day of the week of the lesson
     * @param dayOftheWeek the day of the week of the lesson
     */
    public void setDayOftheWeek(int dayOftheWeek)
    {
        this.dayOftheWeek=dayOftheWeek;
    }
    /**
     * sets the day of the lesson
     * @param day the day of the lesson
     */
    public void setDay(int day)
    {
        this.day=day;
    }
    /**
     * sets the month of the lesson
     * @param month the month of the lesson
     */
    public void setMonth(int month)
    {
        this.month=month;
    }
    /**
     * sets the year of the lesson
     * @param year the year of the lesson
     */
    public void setYear(int year)
    {
        this.year=year;
    }
    /**
     * sets the date of the lesson
     * @param day the day of the lesson
     * @param month the month of the lesson
     * @param year the year of the lesson
     */
    public void setDate(int day, int month, int year)
    {
        date=day+"-"+month+"-"+year;
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
        return hourStart==other.hourStart && hourEnd==other.hourEnd && minuteStart==other.minuteEnd && day==other.day && date==other.date;

    }

    /**
     * toString method to output all the data about a timeslot in a string
     *    * @return string with starting time, ending time and day
     */
    public String toString()
    {
        return "time start: " + hourStart + ":"+minuteStart + "; time end: " + hourEnd + ":"+ minuteEnd + "; day: " + day + "date: " + date;
    }


}
