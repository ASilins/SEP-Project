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
    // We initialise an output for students as a student object list.
    StudentList students = new StudentList(); // This takes 1.
    // We initialise an output for teachers as a teacher object list.
    TeacherList teachers = new TeacherList(); //This takes 1.
    // We initialise an output for rooms as a room object list.
    RoomList rooms = new RoomList(); // This takes 1.
    // We initialise an output for courses as a course object list.
    CourseList courses = new CourseList(); // This takes 1.
    // We initialise an output for classes as a class object list.
    ClassList classes = new ClassList(); // This takes 1.
    // We initialise an output for lessons as a lesson object list.
    ScheduleSystem lessons = new ScheduleSystem(); // This takes 1
    // We initialise a String array for input from file.
    String[] studentArray = null; // This takes 1.
    // We initialise a String array for input from file.
    String[] coursesArray = null; // This takes 1.
    // We initialise a String array for input from file.
    String[] roomArray = null; // This takes 1.

    // We try to read files from .txt file and insert the information into corresponding object lists.
    try { // This will run only once.

      // We set String array with information from the .txt file.
      studentArray = MyFileHandler.readArrayFromTextFile("src/Files/students.txt"); // This takes 1. This can throw file not
      // found exception that needs to be cached.

      // We set String array with information from the .txt file.
      coursesArray = MyFileHandler.readArrayFromTextFile("src/Files/courses.txt"); // This takes 1. This can throw file not
      // found exception that needs to be cached.

      // We set String array with information from the .txt file.
      roomArray = MyFileHandler.readArrayFromTextFile("src/Files/rooms.txt"); // This takes 1 This can throw file not
      // found exception that needs to be cached.

      // We read threw the student string array and create each student and place it in student object array.
      for (int i = 0; i < studentArray.length; i++) { // This will loop n times

        // We initialise a temporary variable to store information from array.
        String temp = studentArray[i]; // For each iteration this takes 1
        // We initialise a temporary string array to split at store information from "temp"
        String[] tempArray = temp.split(","); // For each iteration this takes 1.
        // We initialise a temporary string to store a string from array.
        String tempSemester = tempArray[0]; // For each iteration this takes 1.
        // We initialise an integer and parse a string to an integer.
        int semester = Integer.parseInt(tempSemester); // For each iteration this takes 1.
        // We initialise a string and set the information from the array.
        String className = tempArray[1]; // For each iteration this takes 1.
        // We initialise a temporary string and set the information from the array.
        String tempStudentNumber = tempArray[2]; // For each iteration this takes 1.
        // We initialise an integer and parse the information from a string.
        int studentNumber = Integer.parseInt(tempStudentNumber); // For each iteration this takes 1.
        // We initialise a string and set the information from an array
        String name = tempArray[3]; // For each iteration this takes 1.

        // We initialise a student object and set the information
        Student student = new Student(name, studentNumber, semester, className); // For each iteration this takes 1
        // We add the student object to the student object list.
        students.addStudent(student); // For each iteration this takes 1.
      }

      // We read through the course array and create each teacher and course object and insert them in corresponding arrays.
      for (int i = 0; i < coursesArray.length; i++) { // This will loop n times.
        // We initialise a temporary string and set the information from the array
        String temp = coursesArray[i]; // For each iteration this takes 1.
        // We initialise a string array and split a string and set it into the array.
        String[] tempArray = temp.split(","); // For each iteration this takes 1.
        // We initialise a string and set it from the array.
        String initials = tempArray[3]; // For each iteration this takes 1.
        // We initialise an integer and parse a string from the array.
        int points = Integer.parseInt(tempArray[4]); // For each iteration this takes 1.

        // We initialise a string and set the information from array and parse a string from the array.
        String teacherCourseName = tempArray[2] + Integer.parseInt(tempArray[0]) + tempArray[1]; // For each iteration we have 1 '=' and 2 '+'.

        // We create an empty teacher object
        Teacher t = null; // This takes 1
        // We initialise a boolean and set it to false.
        boolean made = false; // For each iteration this takes 1.


        // This will set the object and add it to teacher object list.
        if (teachers.size() == 0) { // This runs only once.
          // We set the object with the information.
          t = new Teacher(initials, teacherCourseName); // This takes 1
          // We add the object to the list.
          teachers.addTeacher(t); // This takes 1
        } else { // For each iteration this runs only once.
          // We add string of information to a teacher object if the object exists.
          for (int j = 0; j < teachers.size(); j++) { // This runs n times for each iteration.
            // We check if the teacher object exists
            if (teachers.get(j).getInitials().equals(initials)) { // This comparison will run n times.
              // We add string of information to teacher object.
              teachers.get(j).addCourse(teacherCourseName); // This takes 1 per true comparison.
              t = teachers.get(j); // Per true comparison the object is set to the object in the list.
              made = true; // This takes 1 per true comparison.
            }
          }

          // This will set the teacher object if the boolean is false
          if (!made) { // For each iteration this runs only once.
            t = new Teacher(initials, teacherCourseName); // Per true comparison this takes 1.
            teachers.addTeacher(t); // We add the teacher object to the list of object per true comparison.
          }
        }

        // We create an empty course object
        Course c = null; // For each iteration this takes 1.
        // We initialise a boolean and set it to false.
        boolean found = false; // For each iteration this takes 1.

        // This will set the course object and add it to the course list.
        if (courses.size() == 0) { // This will run once.
          // We initialise the course object.
          c = new Course(students, tempArray[2], points, t, Integer.parseInt(tempArray[0]), tempArray[1]); // Per true comparison this takes 1
          // We add the course object to the course object list.
          courses.addCourse(c); // This takes 1 per true comparison.
        } else { // For each iteration this runs only once.
          for (int j = 0; j < courses.size(); j++) { // This runs n times for each iteration.
            // We initialise a string and set the information from array
            String coursesName = courses.get(j).getCourseName() + courses.get(j).getSemester() + courses.get(j).getClassName(); // For each iteration we have 3 '+' = 3

             // We add teacher object to course if the names ar equal.
            if (coursesName.equals(teacherCourseName)) { // This takes 1 per iteration.
              // We add teacher object to the course.
              courses.get(j).addTeacher2(t); // Per true comparison this takes 1.
              // We set the boolean to true
              found = true; // This takes 1 per true comparison.
            }
          }

          // We create the course if "found" boolean is false.
          if (!found) { // This runs once per iteration.
            // We initialise course object.
            c = new Course(students, tempArray[2], points, t, Integer.parseInt(tempArray[0]), tempArray[1]); // This initialises the object
            // We add course object to the course object list.
            courses.addCourse(c); // This takes 1.
          }
        }
      }

      // We read through room list and create room objects and add them to room object list.
      for (int i = 0; i < roomArray.length; i++) { // This will run n times
        // We initialise a temporary string and set the information from the array
        String temp = roomArray[i]; // For each iteration this takes 1.
        // We initialise a string array and split a string and set it into the array.
        String[] tempArray = temp.split(","); // For each iteration this takes 1.
        // We initialise a string and set it from the array.
        String blockFloor = tempArray[0].split("\\.")[0]; // For each iteration this takes 1.
        // We initialise a string and set it from the array.
        String roomNumber = tempArray[0].split("\\.")[1]; // For each iteration this takes 1.
        // We initialise a char at set it from the array.
        char block = blockFloor.charAt(0); // For each iteration this takes 1.
        // We initialize an integer and parse a string from a substring
        int floor = Integer.parseInt(blockFloor.substring(1)); // For each iteration this takes 1.
        // We initialise an integer and parse a string from the array
        int capacity = Integer.parseInt(tempArray[1]); // For each iteration it takes 1.

        // We initialise a room object and set the parameters.
        Room r = new Room(roomNumber, capacity, block, floor); // For each iteration it takes 1.
        // We add the object to the list
        rooms.addRoom(r); // For each iteration it takes 1.
      }
      // We catch exception if the file was not found
    } catch (FileNotFoundException e) {
      System.err.println("File was not found, or could not be opened"); // This takes 1 if an exception was thrown.
    }

    // We read through student object list and make class object list with students in them.
    for (int i = 0; i < students.size(); i++) { // This runs n times.
      // We create class object and set it to null.
      Class c = null; // For each iteration this is 1.
      // This checks if the object list is empty.
      if (classes.size() == 0) { // This comparison will be done once.
        // We initialise a temporary student object from the student object list.
        Student temp = students.get(i); // This is 1.
        // We initialise a temporary student object list.
        StudentList tempList = new StudentList(); // This is 1.
        // We add student object to student object list.
        tempList.addStudent(temp); // This is 1.
        // We initialise class object with set parameters.
        c = new Class(temp.getClassName(), tempList, courses, temp.getSemester()); // This is 1.
        // We add the class to the class object list.
        classes.addClass(c); // This is 1.
      } else {
        // We search through class object list.
        for (int j = 0; j < classes.size(); j++) { // This runs n times.
          // We compare student object class name with class object name.
          if (students.get(i).getClassName().equals(classes.get(j).getName()) &&
              students.get(i).getSemester() == classes.get(j).getSemester()) { // This runs once per iteration
            // We add student object to the class.
            classes.get(j).addStudent(students.get(i)); // For each iteration this is 1.
            break;
          }
        }
      }
    }

    // We try to write student object list to file. Catches file not found and IO exception.
    try {
      // We use static method to write to file.
      MyFileHandler.writeToBinaryFile("src/Files/students.bin", students); // This takes 1
      // Outputs if successful.
      System.out.println("Students added"); // This takes 1.
    } catch (FileNotFoundException e) {
      // Error output if exception.
      System.err.println("File not found"); // This takes 1.
    } catch (IOException e) {
      // Error output if exception.
      e.printStackTrace(); // This takes 1.
    }

    // We try to write teacher object list to file. Catches file not found and IO exception.
    try {
      // We use static method to write to file.
      MyFileHandler.writeToBinaryFile("src/Files/teachers.bin", teachers); // This takes 1
      // Outputs if successful.
      System.out.println("Teachers added"); // This takes 1.
    } catch (FileNotFoundException e) {
      // Error output if exception.
      System.err.println("File not found"); // This takes 1.
    } catch (IOException e) {
      // Error output if exception.
      e.printStackTrace(); // This takes 1.
    }

    // We try to write room object list to file. Catches file not found and IO exception.
    try {
      // We use static method to write to file.
      MyFileHandler.writeToBinaryFile("src/Files/rooms.bin", rooms); // This takes 1.
      // Outputs if successful.
      System.out.println("Rooms added"); // This takes 1.
    } catch (FileNotFoundException e) {
      // Error output if exception.
      System.err.println("File not found"); // This takes 1.
    } catch (IOException e) {
      // Error output if exception.
      e.printStackTrace(); // This takes 1.
    }

    // We try to write course object list to file. Catches file not found and IO exception.
    try {
      // We use static method to write to file.
      MyFileHandler.writeToBinaryFile("src/Files/courses.bin", courses); // This takes 1
      // Outputs if successful.
      System.out.println("Courses added"); // This takes 1.
    } catch (FileNotFoundException e) {
      // Error output if exception.
      System.err.println("File not found"); // This takes 1.
    } catch (IOException e) {
      // Error output if exception.
      e.printStackTrace(); // This takes 1.
    }

    // We try to write class object list to file. Catches file not found and IO exception.
    try {
      // We use static method to write to file.
      MyFileHandler.writeToBinaryFile("src/Files/classes.bin", classes); // This takes 1
      // Outputs if successful
      System.out.println("Classes added"); // This takes 1.
    } catch (FileNotFoundException e) {
      // Error output if exception.
      System.err.println("File not found"); // This takes 1.
    } catch (IOException e) {
      // Error output if exception.
      e.printStackTrace(); // This takes 1.
    }

    // We try to write lesson object list to file. Catches file not found and IO exception.
    try {
      // We use static method to write to file.
      MyFileHandler.writeToBinaryFile("src/Files/lessons.bin", lessons); // This takes 1
      // Outputs if successful.
      System.out.println("Lessons added"); // This takes 1.
    } catch (FileNotFoundException e) {
      // Error output if exception
      System.err.println("File not found"); // This takes 1.
    } catch (IOException e) {
      // Error output if exception.
      e.printStackTrace(); // This takes 1.
    }

    // Outputs when program has finished running.
    System.out.println("\n" + "\n"); // This takes 1.
    // Outputs when program has finished running.
    System.out.println("Program successfully executed!"); // This takes 1.
  }
}
// We have no recursion, so we don't need to have a base case.
// We loop n times in for loop because that is the length of 'studentArray'.
// We loop a(b+c) times in for loop because a is the first loop that has a length of 'courseArray'
// b is the second loop in a that has a size of 'teachers' and c is the third loop in a that
// has a size of 'courses.
// We loop d times in for loop because that is the length of 'roomArray'.
// We loop e*f time in for loop because e has a size of 'students' and
// f has size of 'classes'.
// T(n, a, b, c, e ,f) = 1*38 + 10n + 18a(2b+4c) + 9d + 6e*f, so ignoring constants
// and coefficients, we get
// T(n, a, b, c, e ,f) = n + ab + ac + ef
// We chose this algorithm because of the time complexity difference in
// for loops and the overall size of the class. Also, because we
// have two for loop in a for loop making the time complexity
// different overall.
