package Model;
import java.util.ArrayList;

/**
 * A class containing class information.
 * @author Sid
 * @version 1.0
 */
public class Class {
    private String className;
    private StudentList studentClassList;
    private CourseList courseClassList;

    /**
     * 3 argument constructor initializing class
     * @param name the name of the class
     * @param studentList the students that are part of the class
     * @param courseList the courses that are part of the class
     */
    public Class(String name, ArrayList<Student> studentList, ArrayList<Course> courseList) {
        className=name;

        for (int i =0; i< studentList.size();i++) {
            Student temp = studentList.get(i);

            if (temp.getClassName().equals(className)) {
                studentClassList.addStudent(temp);
            }
        }

        for (int i =0; i< courseList.size();i++) {
            Course temp = courseList.get(i);

            if (temp.getCourseName().equals(courseName)) {
                courseClassList.addCourse(temp);
            }
        }
    }

    /**
     * Sets the class name
     * @param name what the class name will be set to
     */
    public void setName(String name) {
        className=name;
    }

    /**
     * Returns the class name
     * @return returns the name of the class
     */
    public String getName() {
        return className;
    }

    /**
     * Adds a student to the list of students inside the class
     * @param student a student that is going to be added to the student list
     */
    public void addStudent(Student student) {
        studentClassList.addStudent(student);
    }

    /**
     * Removes a student from the list of students inside the class
     * @param student a student that is going to be removed from the student list
     */
    public void removeStudent(Student student) {
        studentClassList.removeStudent(student);
    }

    /**
     * Adds a course to the course list of the class
     * @param course a course that is going to be added to the course list
     */
    public void addCourse(Course course) {
        courseClassList.addCourse(course);
    }
    /**
     * Removes a course from the list of courses inside the class
     * @param course a course that is going to be removed from the course list
     */
    public void removeCourse(Course course) {
        courseClassList.removeCourse(course);
    }

    /**
     * Compares the name, courseClassList and studentClassList of the class of two classes
     * @param obj the object to compare with
     * @return true if the given object is equal to this class
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Class)) {
            return false;
        }

        Class other = (Class)obj;

        return className.equals(other.className)&&courseClassList.equals(other.courseClassList)&&studentClassList.equals(other.studentClassList);
    }

    /**
     * returns a string representation of the class.
     * @return a string representation of the class in format. "className, courseClassList, studentClassList"
     */
    public String toString() {
        return className + courseClassList.toString() + studentClassList.toString();
    }
}
