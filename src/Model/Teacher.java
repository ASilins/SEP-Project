package Model;

import java.util.ArrayList;

/**
 * A class for Teacher objects
 * @author Ondrej Klimek
 * @version 1.0
 */

public class Teacher
{
  private String initials;
  private ArrayList<String> courses;

  /**
   * Constructor initializing the Teacher object
   * @param initials initials of the teacher
   */

  public Teacher(String initials)
  {
    this.initials = initials;
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
    this.courses.add(courses.size(), course);
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
   * equals() method to check if an object is the same as a teacher object
   * @param obj object to be compared
   * @return true if the two objects are equal and false otherwise
   */

  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (!(obj instanceof Teacher))
    {
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
