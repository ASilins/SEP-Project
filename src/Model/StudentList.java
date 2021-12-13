package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Model.ScheduleModelManager;

/**
 * A class containing list of student objects.
 * @author Arturs Silins
 * @version 1.2
 */
public class StudentList implements Serializable
{
  private ArrayList<Student> students;

  /**
   * No-argument constructor initializing student list.
   */
  public StudentList() {
    students = new ArrayList<Student>();
  }

  public ArrayList<Student> getStudents() {
    return students;
  }

  /**
   * Adds the student to the list.
   * @param student the student to add to the list
   */
  public void addStudent(Student student) {
    students.add(student);
  }

  /**
   * Gets student object from list of students with index.
   * @param index the index of student in array
   * @return the student object from list
   */
  public Student get(int index) {
    if (index <= students.size()) {
      return students.get(index);
    }
    return null;
  }

  /**
   * Remove the student form the list.
   * @param student the student to remove from the list
   */
  public void removeStudent(Student student) {
    students.remove(student);
  }

  /**
   * Gets the lists size
   * @return the size of the list
   */
  public int size() {
    return students.size();
  }

  /**
   * Check if the object is in the obejct list.
   * @param student an object that will be checked
   * @return true if the object is in the list
   */
  public boolean check(Student student) {
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).equals(student)) {
        return true;
      }
    }

    return false;
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
