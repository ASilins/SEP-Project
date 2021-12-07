package Model;

import java.util.ArrayList;

/**
 * A class containing teacher objects
 * @author Ondrej Klimek
 * @version 1.0
 */
public class TeacherList
{
  private ArrayList<Teacher> teachers;

  /**
   * A constructor to initialize the teacher list
   */
  public TeacherList()
  {
    teachers = new ArrayList<>();
  }

  /**
   * A method to add a teacher to the list
   * @param teacher teacher to be added
   */
  public void addTeacher(Teacher teacher)
  {
    teachers.add(teacher);
  }

  /**
   * A method to remove a teacher from the teacher list
   * @param teacher teacher to be removed
   */
  public void removeTeacher(Teacher teacher)
  {
    teachers.remove(teacher);
  }

  public int size() {
    return teachers.size();
  }
  /**
   * toString method
   * @return a string with all the teachers
   */
  public String toString()
  {
    String returnString = "";

    for (int i = 0; i < teachers.size(); i++)
    {
      returnString += teachers.get(i);
      returnString += "\n";
    }

    return returnString;
  }
}
