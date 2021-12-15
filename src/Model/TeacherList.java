package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing teacher objects
 * @author Ondrej Klimek
 * @version 1.2
 */
public class TeacherList implements Serializable {
  private ArrayList<Teacher> teachers;

  /**
   * A constructor to initialize the teacher list
   */
  public TeacherList() {
    teachers = new ArrayList<>();
  }

  /**
   * A method to add a teacher to the list
   * @param teacher teacher to be added
   */
  public void addTeacher(Teacher teacher) {
    teachers.add(teacher);
  }

  /**
   * Get teacher object from teacher list with index.
   * @param index the index of the teacher in list
   * @return the teacher object from teacher list
   */
  public Teacher get(int index) {
    return teachers.get(index);
  }

  /**
   * A method to remove a teacher from the teacher list
   * @param teacher teacher to be removed
   */
  public void removeTeacher(Teacher teacher) {
    teachers.remove(teacher);
  }

  /**
   * Get the size of the object list.
   * @return the size of the list
   */
  public int size() {
    return teachers.size();
  }

  /**
   * Check if the Teacher object already exists in the TeacherList
   * @param teacher the object that will be checked
   * @return true if the object is in the list
   */
  public boolean check(Teacher teacher) {
    for (int i = 0; i < teachers.size(); i++) {
      if (teachers.get(i).equals(teacher)) {
        return true;
      }
    }

    return false;
  }

  /**
   * toString method
   * @return a string with all the teachers
   */
  public String toString() {
    String returnString = "";

    for (int i = 0; i < teachers.size(); i++) {
      returnString += teachers.get(i);
      returnString += "\n";
    }

    return returnString;
  }
}
