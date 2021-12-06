package Model;

import java.util.ArrayList;

/**
 * A class containing list of student objects.
 * @author Arturs Silins
 * @version 1.0
 */
public class StudentList
{
  private ArrayList<Student> students;

  /**
   * No-argument constructor initializing student list.
   */
  public StudentList() {
    students = new ArrayList<Student>();
  }

  /**
   * Adds the student to the list.
   * @param student the student to add to the list
   */
  public void addStudent(Student student) {
    students.add(student);
  }

  /**
   * Remove the student form the list.
   * @param student the student to remove from the list
   */
  public void removeStudent(Student student) {
    students.remove(student);
  }

  /**
   * Returns a string representation of the student list.
   * @return a string representation of the student list in format: "Student"
   */
  public String toString() {
    String returnString = "";

    for (int i = 0; i < students.size(); i++) {
      returnString += students.get(i);
      returnString += "\n";
    }

    return returnString;
  }
}
