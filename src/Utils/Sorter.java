package Utils;

import Model.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A class containing sorters methods
 * @author Arturs Silins
 * @version 1.0
 */
public class Sorter
{
  /**
   * Static method that sorts student list alphabetically by name.
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

  /**
   * Static method that sorts teacher list alphabetically by initials.
   * @param unsorted a teacher object list that will be sorted
   * @return a sorted teacher object list
   */
  public static TeacherList sortTeachers(TeacherList unsorted) {
    ArrayList<Teacher> unsortedList = new ArrayList<>();
    TeacherList sorted = new TeacherList();

    for (int i = 0; i < unsorted.size(); i++) {
      unsortedList.add(unsorted.get(i));
    }

    for (int i = 0; i < unsortedList.size(); i++) {
      for (int j = 0; j < unsortedList.size(); j++) {
        if (unsortedList.get(j).getInitials().compareTo(unsortedList.get(i).getInitials()) > 0) {
          Collections.swap(unsortedList, i, j);
        }
      }
    }

    for (int i = 0; i < unsortedList.size(); i++) {
      sorted.addTeacher(unsortedList.get(i));
    }

    return sorted;
  }
}
