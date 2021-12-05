package Model;

public class Student
{
  private String name;
  private int studentNumber;
  private int semester;
  private String className;

  public Student(String name, int studentNumber, int semester, String className) {
    this.name = name;
    this.studentNumber = studentNumber;
    this.semester = semester;
    this.className = className;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
