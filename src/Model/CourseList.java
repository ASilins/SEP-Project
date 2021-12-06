package Model;

import java.util.ArrayList;
/**
 * A class containing list of student objects.
 * @author Bhupas
 * @version 1.0
 */


public class CourseList {
    private ArrayList<Course> courses;

    /**
     * No-argument constructor initializing course list.
     */
    public CourseList() {
        courses = new ArrayList<Course>();
    }

    /**
     * Adds the Course to the list.
     * @param course the student to add to the list
     */

    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Remove the course  form the list.
     * @param course the course to remove from the list
     */
    public void removeCurse(Course course) {
        courses.remove(course);
    }
    /**
     * Returns a string representation of the course list.
     */


    public String toString() {
        String returnString = "";

        for (int i = 0; i < courses.size(); i++) {
            returnString += courses.get(i);
            returnString += "\n";
        }

        return returnString;
    }
}

