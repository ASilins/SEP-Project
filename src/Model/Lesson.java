package Model;

public class Lesson {
    private TimeSlot timeSlot;
    private Course course;
    private Room room;
    private Room room1;
    private Room room2;

    private RoomList rooms;
    private CourseList courses;

    public Lesson(TimeSlot timeSlot, Course course, Room room)
    {
        this.timeSlot=timeSlot;
        this.course=course;
        this.room=room;
        this.room1=null;
        this.room2=null;
    }
    public void setCourse(Course course)
    {
        this.course=course;
    }
    public void setTimeSlot(TimeSlot timeSlot)
    {
        this.timeSlot=timeSlot;
    }
    public void bookRoom(Room room)
    {
        this.room=room;
    }
    public void bookRooms(Room room1, Room room2)
    {
        this.room1=room1;
        this.room2=room2;
        this.room=null;
    }

    public Course getCourse() {
        return course;
    }




}
