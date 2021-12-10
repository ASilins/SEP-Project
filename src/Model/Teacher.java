package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class for Teacher objects
 * @author Ondrej Klimek
 * @version 1.1
 */
public class Teacher implements Serializable {
  private String initials;
  private ArrayList<String> courses;

  /**
   * Constructor initializing the Teacher object
   * @param initials initials of the teacher
   */
  public Teacher(String initials, String course) {
    courses = new ArrayList<String>();
    this.initials = initials;
    courses.add(course);
  }

  /**
   * Set method to change the initials
   * @param initials new initials
   */
  public void setInitials(String initials)
  {
    this.initials = initials;
  }

  /**
   * Adds a course to the course list
   * @param course course to be added
   */
  public void addCourse(String course)
  {
    this.courses.add(course);
  }

  /**
   * Gets the teachers initials
   * @return the initials of the teacher
   */
  public String getInitials()
  {
    return initials;
  }

  /**
   * Gets all the courses the teacher has
   * @return course list
   */
  public ArrayList<String> getCourses()
  {
    return courses;
  }

  /**
   * Get course name by index.
   * @param index the index of the position in list
   * @return the course from course list from teacher
   */
  public String getCourseByIndex(int index) {
    return courses.get(index);
  }

  /**
   * Get the course list size for teacher.
   * @return the size of course list for teacher
   */
  public int courseSize() {
    return courses.size();
  }

  /**
   * equals() method to check if an object is the same as a teacher object
   * @param obj object to be compared
   * @return true if the two objects are equal and false otherwise
   */
  public boolean equals(Object obj) {
    if (!(obj instanceof Teacher)) {
      return false;
    }
    Teacher other = (Teacher) obj;

    return initials.equals(other.initials) && courses.equals(other.courses);
  }

  /**
   * toString method to output all the data about a teacher in a string
   * @return string with initials and courses
   */
  public String toString()
  {
    return initials + "\n" + courses;
  }
}
