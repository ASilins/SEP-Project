package Model;

import Utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

public class ScheduleModelManager
{
  private String studentFileName;
  private String teacherFileName;
  private String classFileName;
  private String courseFileName;
  private String roomFileName;
  private String lessonFileName;

  public ScheduleModelManager(String studentFileName, String teacherFileName, String classFileName, String courseFileName, String roomFileName, String lessonFileName) {
    this.studentFileName = studentFileName;
    this.teacherFileName = teacherFileName;
    this.classFileName = classFileName;
    this.courseFileName = courseFileName;
    this.roomFileName = roomFileName;
    this.lessonFileName = lessonFileName;
  }

  public StudentList getAllStudents() {
    StudentList allStudents = new StudentList();

    try {
      allStudents = (StudentList) MyFileHandler.readFromBinaryFile(studentFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allStudents;
  }

  public TeacherList getAllTeachers() {
    TeacherList allTeachers = new TeacherList();

    try {
      allTeachers = (TeacherList) MyFileHandler.readFromBinaryFile(teacherFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allTeachers;
  }

  public ClassList getAllClasses() {
    ClassList allClasses = new ClassList();

    try {
      allClasses = (ClassList) MyFileHandler.readFromBinaryFile(classFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allClasses;
  }

  public RoomList getAllRooms() {
    RoomList allRooms = new RoomList();

    try {
      allRooms = (RoomList) MyFileHandler.readFromBinaryFile(roomFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allRooms;
  }

  public ScheduleSystem getAllLessons() {
    ScheduleSystem allLessons = new ScheduleSystem();

    try {
      allLessons = (ScheduleSystem) MyFileHandler.readFromBinaryFile(lessonFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allLessons;
  }

  public void saveStudent(Student student) {
  }

  public void saveTeacher(Teacher teacher) {

  }

  public void saveRoom(Room room) {

  }

  public void saveCourse(Course course) {

  }

  public void saveLesson(Lesson lesson) {

  }

  public ScheduleSystem viewSchedule() {
    return null;
  }

  public Student getStudentByName(String name) {
    StudentList allStudents = getAllStudents();

    for (int i = 0; i < allStudents.size(); i++) {
      if (allStudents.getByIndex(i).getName().equals(name)) {
        return allStudents.getByIndex(i);
      }
    }

    return null;
  }

  public Student getStudentByNum(int num) {
    StudentList allStudents = getAllStudents();

    for (int i = 0; i < allStudents.size(); i++) {
      if (allStudents.getByIndex(i).getStudentNumber() == num) {
        return allStudents.getByIndex(i);
      }
    }

    return null;
  }

  public Student getStudentBySemester(int semester) {
    StudentList allStudents = getAllStudents();

    for (int i = 0; i < allStudents.size(); i++) {
      if (allStudents.getByIndex(i).getSemester() == semester) {
        return allStudents.getByIndex(i);
      }
    }

    return null;
  }

  public Student getStudentByClass(String className) {
    StudentList allStudents = getAllStudents();

    for (int i = 0; i < allStudents.size(); i++) {
      if (allStudents.getByIndex(i).getClassName().equals(className)) {
        return allStudents.getByIndex(i);
      }
    }

    return null;
  }

  public Teacher getTeacherByInitials(String initial) {
    TeacherList allTeachers = getAllTeachers();

    for (int i = 0; i < allTeachers.size(); i++)
    {
      if ()
    }
  }
}
