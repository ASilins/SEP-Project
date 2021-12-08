package Model;

import Utils.Sorter;

/**
 * CLass for random tests
 */
public class test
{
  public static void main(String[] args)
  {

    StudentList s2 = new StudentList();
    Student s3 = new Student("Thomas", 9045, 1, "DK");
    s2.addStudent(s3);

    Teacher s4 = new Teacher("ALHE", "SDJ");
    Course s5 = new Course(s2, "SDJ", 10, s4, 1, "DK");
    Course s6 = new Course(s2, "DMA", 5, s4, 1, "DK");
    CourseList s7 = new CourseList();
    s7.addCourse(s5);
    s7.addCourse(s6);
    Class s1 = new Class("DK" ,s2, s7, 1);
    ClassList s8 = new ClassList();
    s8.addClass(s1);
    Teacher s9 = new Teacher("MWA", "SEP");
    Teacher s10 = new Teacher("RB", "DMA");
    s5.addTeacher2(s9);
    s5.addTeacher1(s4);
    s6.addTeacher1(s10);
    TeacherList s11 = new TeacherList();
    s11.addTeacher(s4);
    s11.addTeacher(s9);
    s11.addTeacher(s10);
  TeacherList s12 = new TeacherList();
  s12.addTeacher(s4);
  s12.addTeacher(s9);
  s12.addTeacher(s10);
  Room s13 = new Room("14", 30, 'A', 2);
  Room s14 = new Room("15a", 20, 'B', 3);
  Room s15 = new Room("15b", 20, 'B', 3);
  RoomList s16 = new RoomList();
  s16.addRoom(s13);
  s16.addRoom(s14);
  s16.addRoom(s15);
  TimeSlot s17 = new TimeSlot(820, 60, 'm');
  Lesson s18 = new Lesson(s17, s5, s14);
  s18.bookRooms(s14, s14);







    System.out.println(s18);
  }
}
