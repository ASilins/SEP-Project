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
    // We initialise an array list.
    ArrayList<Student> unsortedList = new ArrayList<>(); // This takes 1.
    // We initialise a student object list.
    StudentList sorted = new StudentList(); // This takes 1.

    // This takes from student list and sets it in array list
    for (int i = 0; i < unsorted.size(); i++) { // This takes n times.
      unsortedList.add(unsorted.get(i)); // For each iteration this takes 1
    }

    // This is the main part that sorts the objects
    for (int i = 0; i < unsortedList.size(); i++) { // This runs n times
      // This check threw the array list
      for (int j = 0; j < unsortedList.size(); j++) { // This runs n times
        // This compares the objects in the list
        if (unsortedList.get(j).getName().compareTo(unsortedList.get(i).getName()) > 0) { // For each iteration this runs 1 time.
          // We swap the objects in the array
          Collections.swap(unsortedList, i, j); // This takes 1.
        }
      }
    }

    // This takes from the array list to student object list
    for (int i = 0; i < unsortedList.size(); i++) { // This runs n times.
      sorted.addStudent(unsortedList.get(i)); // For each iteration this takes 1.
    }

    return sorted; // 1 return
  }

  /**
   * Static method that sorts teacher list alphabetically by initials.
   * @param unsorted a teacher object list that will be sorted
   * @return a sorted teacher object list
   */
  public static TeacherList sortTeachers(TeacherList unsorted) {
    // We initialise an array list.
    ArrayList<Teacher> unsortedList = new ArrayList<>(); // This takes 1.
    // We initialise a student object list.
    TeacherList sorted = new TeacherList(); // This takes 1.

    // This takes from student list and sets it in array list
    for (int i = 0; i < unsorted.size(); i++) { // This takes n times.
      unsortedList.add(unsorted.get(i)); // For each iteration this takes 1
    }

    // This is the main part that sorts the objects
    for (int i = 0; i < unsortedList.size(); i++) { // This runs n times
      // This check threw the array list
      for (int j = 0; j < unsortedList.size(); j++) { // This runs n times
        // This compares the objects in the list
        if (unsortedList.get(j).getInitials().compareTo(unsortedList.get(i).getInitials()) > 0) { // For each iteration this runs 1 time.
          // We swap the objects in the array
          Collections.swap(unsortedList, i, j); // This takes 1.
        }
      }
    }

    // This takes from the array list to teacher object list
    for (int i = 0; i < unsortedList.size(); i++) { // This runs n times.
      sorted.addTeacher(unsortedList.get(i)); // For each iteration this takes 1.
    }

    return sorted; // 1 return
  }
}
// We have no recursion, so we do not need to have a base case.
// Both methods are the same but take different data and check different
// data, but the time complexity is the same for both methods.
// We loop n times in for loop because that is the size of 'unsorted'
// We loop n^2 times in nested for loop because that is the size of 'unsortedList' times two
// We loop n times in for loop because that is the size of 'unsortedList'
// T(n) = 1*3 + n + n^2 + n, so ignoring constants
// and coefficients, we get
// T(n) = n^2
// We chose this class because of the time complexity comparing to other classes.
// This class uses a sorter that takes small space but is slow