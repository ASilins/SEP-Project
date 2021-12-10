package Model;

import java.io.Serializable;

/**
 * A class containing Student information.
 * @author Arturs Silins
 * @version 1.0
 */
public class Student implements Serializable {
  private String name;
  private int studentNumber;
  private int semester;
  private String className;

  /**
   * 4 argument constructor initializing student.
   * @param name the students name
   * @param studentNumber the student number
   * @param semester the semester the student is in
   * @param className the name of the class he is in
   */
  public Student(String name, int studentNumber, int semester, String className) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.semester = semester;
    this.className = className;
  }

  /**
   * Sets the students name.
   * @param name what the students name will be set to
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the students number.
   * @param studentNumber what the student number will be set to
   */
  public void setStudentNumber(int studentNumber) {
    this.studentNumber = studentNumber;
  }

  /**
   * Sets the students semester.
   * @param semester what the students semester number will be set to
   */
  public void setSemester(int semester) {
    this.semester = semester;
  }

  /**
   * Sets the classes name.
   * @param className what the students class will be set to
   */
  public void setClassName(String className) {
    this.className = className;
  }

  /**
   * Gets the students name.
   * @return the students name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the student number.
   * @return the students number
   */
  public int getStudentNumber() {
    return studentNumber;
  }

  /**
   * Gets the student semester.
   * @return the semester number
   */
  public int getSemester() {
    return semester;
  }

  /**
   * Gets the class name.
   * @return the class name
   */
  public String getClassName() {
    return className;
  }

  /**
   * Compares name, student number, semester and class name of two students.
   * @param obj the object to compare with
   * @return true if the given object is equal to this student
   */
  public boolean equals(Object obj) {
    if (!(obj instanceof Student)) {
      return false;
    }

    Student other = (Student)obj;

    return (name.equals(other.name) && studentNumber == other.studentNumber && semester == other.semester && className.equals(other.className));
  }

  /**
   * Returns a string representation of the student.
   * @return a string representation of the student in format: "semester,className,studentNumber,name"
   */
  public String toString() {
    return semester + "," + className + "," + studentNumber + "," + name + "\n" ;
  }
}
