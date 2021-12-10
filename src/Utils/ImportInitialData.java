package Utils;

import Model.*;
import Model.Class;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Small program that is used to import data using .txt file and writes to binary file
 *
 * @author Arturs Silins
 * @version 1.0
 */
public class ImportInitialData {
  public static void main(String[] args) {
    StudentList students = new StudentList();
    TeacherList teachers = new TeacherList();
    RoomList rooms = new RoomList();
    CourseList courses = new CourseList();
    ClassList classes = new ClassList();
    ScheduleSystem lessons = new ScheduleSystem();
    String[] studentArray = null;
    String[] coursesArray = null;
    String[] roomArray = null;

    try {
      studentArray = MyFileHandler.readArrayFromTextFile("src/Files/students.txt");
      coursesArray = MyFileHandler.readArrayFromTextFile("src/Files/courses.txt");
      roomArray = MyFileHandler.readArrayFromTextFile("src/Files/rooms.txt");

      for (int i = 0; i < studentArray.length; i++) {
        String temp = studentArray[i];
        String[] tempArray = temp.split(",");
        String tempSemester = tempArray[0];
        int semester = Integer.parseInt(tempSemester);
        String className = tempArray[1];
        String tempStudentNumber = tempArray[2];
        int studentNumber = Integer.parseInt(tempStudentNumber);
        String name = tempArray[3];

        Student student = new Student(name, studentNumber, semester, className);
        students.addStudent(student);
      }

      for (int i = 0; i < coursesArray.length; i++) {
        String temp = coursesArray[i];
        String[] tempArray = temp.split(",");
        String initials = tempArray[3];
        int points = Integer.parseInt(tempArray[4]);
        String teacherCourseName = tempArray[2] + Integer.parseInt(tempArray[0]) + tempArray[1];

        Teacher t = null;
        boolean made = false;

        if (teachers.size() == 0) {
          t = new Teacher(initials, teacherCourseName);
          teachers.addTeacher(t);
        }
        else {
          for (int j = 0; j < teachers.size(); j++) {
            if (teachers.get(j).getInitials().equals(initials)) {
              teachers.get(j).addCourse(teacherCourseName);
              t = teachers.get(j);
              made = true;
            }
          }

          if (!made) {
            t = new Teacher(initials, teacherCourseName);
            teachers.addTeacher(t);
          }
        }

        Course c = null;
        boolean found = false;

        if (courses.size() == 0) {
          c = new Course(students, tempArray[2], points, t, Integer.parseInt(tempArray[0]), tempArray[1]);
          courses.addCourse(c);
        } else {
          for (int j = 0; j < courses.size(); j++) {
            String coursesName = courses.get(j).getCourseName() + courses.get(j).getSemester() + courses.get(j).getClassName();

            if (coursesName.equals(teacherCourseName)) {
              courses.get(j).addTeacher2(t);
              found = true;
            }
          }

          if (!found) {
            c = new Course(students, tempArray[2], points, t, Integer.parseInt(tempArray[0]), tempArray[1]);
            courses.addCourse(c);
          }
        }
      }

      for (int i = 0; i < roomArray.length; i++) {
        String temp = roomArray[i];
        String[] tempArray = temp.split(",");
        String blockFloor = tempArray[0].split("\\.")[0];
        String roomNumber = tempArray[0].split("\\.")[1];
        char block = blockFloor.charAt(0);
        String tempFloor = blockFloor.substring(1);
        int floor = Integer.parseInt(tempFloor);
        String tempCapacity = tempArray[1];
        int capacity = Integer.parseInt(tempCapacity);

        Room r = new Room(roomNumber, capacity, block, floor);
        rooms.addRoom(r);
      }
    } catch (FileNotFoundException e) {
      System.err.println("File was not found, or could not be opened");
    }

    for (int i = 0; i < students.size(); i++) {
      Class c = null;
      if (classes.size() == 0) {
        Student temp = students.get(i);
        StudentList tempList = new StudentList();
        tempList.addStudent(temp);
        c = new Class(temp.getClassName(), tempList, courses, temp.getSemester());
        classes.addClass(c);
      } else {
        for (int j = 0; j < classes.size(); j++) {
          if (students.get(i).getClassName().equals(classes.get(j).getName()) &&
              students.get(i).getSemester() == classes.get(j).getSemester()) {
            classes.get(j).addStudent(students.get(i));
            break;
          }
        }
      }
    }

    try {
      MyFileHandler.writeToBinaryFile("src/Files/students.bin", students);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Students added");
    }

    try {
      MyFileHandler.writeToBinaryFile("src/Files/teachers.bin", teachers);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Teachers added");
    }

    try {
      MyFileHandler.writeToBinaryFile("src/Files/rooms.bin", rooms);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Rooms added");
    }

    try {
      MyFileHandler.writeToBinaryFile("src/Files/courses.bin", courses);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Courses added");
    }

    try {
      MyFileHandler.writeToBinaryFile("src/Files/classes.bin", classes);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Classes added");
    }

    try {
      MyFileHandler.writeToBinaryFile("src/Files/lessons.bin", lessons);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Lessons added");
    }

    System.out.println("\n" + "\n");
    System.out.println("Program successfully executed!");
  }
}
