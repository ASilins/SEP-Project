package Model;

import Utils.Sorter;

/**
 * CLass for random tests
 */
public class test
{
  public static void main(String[] args)
  {
    Student s1 = new Student("ABC", 123, 1, "ABC");
    Student s2 = new Student("ABB", 123, 1, "ABC");
    Student s3 = new Student("Bbb", 123, 1, "ABC");
    Student s4 = new Student("Zzz", 123, 1, "ABC");
    Student s5 = new Student("Ccc", 123, 1, "ABC");

    StudentList sl1 = new StudentList();

    sl1.addStudent(s1);
    sl1.addStudent(s2);
    sl1.addStudent(s3);
    sl1.addStudent(s4);
    sl1.addStudent(s5);


    System.out.println(Sorter.sortStudents(sl1));
  }
}
