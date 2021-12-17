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
    String lessonsFile = "src/Files/lessons.bin";

    ScheduleModelManager scheduleManager = new ScheduleModelManager(studentFile, teacherFile, courseFile, roomFile, lessonsFile);
    TimeSlot time1 = new TimeSlot(8, 20, 9, 20, 2, 2021, 12, 14);
    TimeSlot time2= new TimeSlot(9, 20, 10, 20, 2021, 12, 14);
    TimeSlot time3= new TimeSlot(10, 20, 11, 20, 2021, 12, 14);
    TimeSlot time4= new TimeSlot(11, 20, 12, 20, 2021, 12, 14);
    TimeSlot time5= new TimeSlot(12, 20, 13, 20, 2021, 12, 14);
    TimeSlot time6= new TimeSlot(13, 20, 14, 20, 2021, 12, 14);
    TimeSlot time7= new TimeSlot(14, 20, 15, 20, 2021, 12, 14);

    Student testStudent1 = new Student("Test Student1", 999999, 2, "T");
    scheduleManager.addStudent(testStudent1);
    Teacher testTeacher1 = new Teacher("TTT1", "TTT");
    Course testCourse1 = new Course(scheduleManager.getAllStudents(), "TTT", 1, testTeacher1, 2, "T");
    Course testCourse2 = new Course(scheduleManager.getAllStudents(), "TXX", 1, testTeacher1, 2, "X");


    Lesson lesson1 = new Lesson(time1, scheduleManager.getAllCourses().get(2), scheduleManager.getAllRooms().get(2));
    Lesson lesson2 = new Lesson(time2, scheduleManager.getAllCourses().get(4), scheduleManager.getAllRooms().get(0));
    Lesson lesson3 = new Lesson(time3, scheduleManager.getAllCourses().get(6), scheduleManager.getAllRooms().get(4));
    Lesson lesson4 = new Lesson(time4, scheduleManager.getAllCourses().get(5), scheduleManager.getAllRooms().get(1));
    Lesson lesson5 = new Lesson(time5, scheduleManager.getAllCourses().get(1), scheduleManager.getAllRooms().get(2));
    Lesson lesson6 = new Lesson(time6, testCourse1, scheduleManager.getAllRooms().get(2));
    Lesson lesson7 = new Lesson(time7, testCourse2, scheduleManager.getAllRooms().get(2));


    ScheduleSystem schedule = new ScheduleSystem();
    schedule.addLesson(lesson1);
    schedule.addLesson(lesson2);
    schedule.addLesson(lesson3);
    schedule.addLesson(lesson4);
    schedule.addLesson(lesson5);
    schedule.addLesson(lesson6);
    schedule.addLesson(lesson7);


    scheduleManager.saveLessons(schedule);
  }
}
