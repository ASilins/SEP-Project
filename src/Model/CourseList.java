package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing list of student objects.
 * @author Bhupas
 * @version 1.2
 */
public class CourseList implements Serializable {
    private ArrayList<Course> courses;

    /**
     * No-argument constructor initializing course list.
     */
    public CourseList()
    {
        courses = new ArrayList<Course>();
    }

    /**
     * Adds the Course to the list.
     *
     * @param course the student to add to the list
     */
    public void addCourse(Course course) {

        if (!check(course))
        {
            courses.add(course);
        }
    }

    /**
     * Get the course object with index from course list
     *
     * @param index the index of the course object in list
     * @return the course object from list
     */
    public Course get(int index)
    {
        return courses.get(index);
    }

    /**
     * Remove the course  form the list.
     *
     * @param course the course to remove from the list
     */
    public void removeCourse(Course course)
    {
        courses.remove(course);
    }

    /**
     * Get the size of the course object list.
     * @return the size of the list
     */
    public int size()
    {
        return courses.size();
    }

    /**
     * Check if the course is in the course object list.
     * @param course an object that will be checked in the list
     * @return true if the object is in the list
     */
    public boolean check(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals(course)) {
                return true;
            }
        }

        return false;
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

