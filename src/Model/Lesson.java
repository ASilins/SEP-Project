package Model;

/**
 * A class containing Lesson information
 * @author Sid and Bhupas
 * @version 1.0
 */

public class Lesson {
    private TimeSlot timeSlot;
    private Course course;
    private Room room;
    private Room room1;
    private Room room2;

    private RoomList rooms;
    private CourseList courses;

    /**
     * 3 argument constructor initializing lesson.
     * @param timeSlot the time in which the lesson takes place
     * @param course the course that will be taught
     * @param room the room the lesson will take place in
     */
    public Lesson(TimeSlot timeSlot, Course course, Room room)
    {
        this.timeSlot=timeSlot;
        this.course=course;
        this.room=room;
        this.room1=null;
        this.room2=null;
    }

    /**
     * sets the course that will be taught in the lesson
     * @param course the course that will be taught
     */
    public void setCourse(Course course)
    {
        this.course=course;
    }

    /**
     * returns the course that will be taught in the lesson
     * @return the course that will be taught in the lesson
     */
    public Course getCourse()
    {
        return course;
    }

    /**
     * sets the time the lesson will take place in
     * @param timeSlot the time in which the lesson will take place in
     */
    public void setTimeSlot(TimeSlot timeSlot)
    {
        this.timeSlot=timeSlot;
    }

    /**
     * returns the time the lesosn will take place in
     * @return the time in which the lesson will take place in
     */
    public TimeSlot getTimeSlot()
    {
        return timeSlot;
    }

    /**
     * books the room the lesson will take place in
     * @param room the room the lesson will take place in
     */
    public void bookRoom(Room room)
    {
        this.room=room;
    }

    /**
     * returns the room the lesson will take place in
     * @return the room the lesson will take place in
     */
    public Room getRoom()
    {
        return room;
    }

    /**
     * books the rooms the lesson will take place in if multiple rooms are chosen, if they are double rooms
     * @param room1 the first of the double room
     * @param room2 the second of the double room
     */
    public void bookRooms(Room room1, Room room2)
    {
        if (room1.getRoomNumber().charAt(1)==room2.getRoomNumber().charAt(1) && room1.getRoomNumber().charAt(0)==room2.getRoomNumber().charAt(0) && room1.getRoomNumber().charAt(2)!=room2.getRoomNumber().charAt(2)){
            this.room1 = room1;
            this.room2 = room2;
            this.room = null;
        }
    }

    /**
     * returns the double room the lesson will take place in
     * @return the double room the lesson will take place in
     */
    public RoomList getRooms()
    {
        RoomList rooms = new RoomList();
        rooms.addRoom(room1);
        rooms.addRoom(room2);
        return rooms;
    }

    /**
     * compares two lessons and checks if they take place in a similar time and space
     * @param lesson2 the second lesson that needs to be added
     * @return true if the lessons take place in a similar space and time and are thus incopatible
     */
    public boolean isUnavailable(Lesson lesson2)
    {
        return this.room.equals(lesson2.room) && ((this.timeSlot.equals(lesson2.timeSlot) || (this.timeSlot.overLap(lesson2.timeSlot))));

    }

    /**
     * compares timeslot, course, room or rooms of two lessons
     * @param obj the lesson to compare with
     * @return true if the given object is equal to this lesson
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Lesson))
        {
            return false;
        }
        Lesson other = (Lesson) obj;
        return this.timeSlot.equals(other.timeSlot) && this.course.equals(other.course) && this.room.equals(other.room) && this.room1.equals(other.room1) && this.room2.equals(other.room2);
    }

    /**
     * returns a string representation of the lesson
     * @return a string representation of the lesson in format "timeslot, course, room/room1+room2"
     */
    public String toString()
    {
        if (room==null)
        {
            return timeSlot+""+course+room1+room2;
        }
        else
        {
            return timeSlot+""+course+room;
        }
    }




}
