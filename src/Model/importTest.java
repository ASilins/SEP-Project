package Model;

/**
 * Test class for importing files and testing model manager.
 */
public class importTest
{
  public static void main(String[] args) {
    String studentFile = "src/Files/students.bin";
    String teacherFile = "src/Files/teachers.bin";
    String roomFile = "src/Files/rooms.bin";
    String courseFile = "src/Files/courses.bin";
    String classesFile = "src/Files/classes.bin";
    String lessonsFile = "src/Files/lessons.bin";

    ScheduleModelManager schedule = new ScheduleModelManager(studentFile, teacherFile, classesFile, courseFile, roomFile, lessonsFile);

    System.out.println(schedule.getAllTeachers());
  }
}
