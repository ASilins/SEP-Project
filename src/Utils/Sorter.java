package Utils;

import Model.Student;
import Model.StudentList;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A class containing sorters methods
 * @author Arturs Silins
 * @version 0.1
 */
public class Sorter
{
  /**
   * Static method that sorts student list alphabetically.
   * @param unsorted a student object list that will be sorted
   * @return a sorted student object list
   */
  public static StudentList sortStudents(StudentList unsorted) {
    ArrayList<Student> unsortedList = new ArrayList<>();
    StudentList sorted = new StudentList();

    for (int i = 0; i < unsorted.size(); i++) {
      unsortedList.add(unsorted.get(i));
    }

    for (int i = 0; i < unsortedList.size(); i++) {
      for (int j = 0; j < unsortedList.size(); j++) {
        if (unsortedList.get(j).getName().compareTo(unsortedList.get(i).getName()) > 0) {
          Collections.swap(unsortedList, i, j);
        }
      }
    }

    for (int i = 0; i < unsortedList.size(); i++) {
      sorted.addStudent(unsortedList.get(i));
    }

    return sorted;
  }
}
