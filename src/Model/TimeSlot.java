package Model;

public class TimeSlot {

    private int time;
    private int length;
    private char day;


    public TimeSlot(int time, int length, char day)
    {
        this.time=time;
        this.length=length;
        this.day=day;

    }
    public int getStart()
    {
        return time;
    }
    public int getEnd()
    {
        return time+length;
    }
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
