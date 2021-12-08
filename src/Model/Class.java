package Model;
import java.util.ArrayList;
//WORKS
/**
 * A class containing class information.
 * @author Sid
 * @version 1.3
 */
public class Class {
    private String className;
    private StudentList studentClassList;
    private CourseList courseClassList;
    private int semester;

    /**
     * 3 argument constructor initializing class
     * @param name the name of the class
     * @param studentList the students that are part of the class
     * @param courseList the courses that are part of the class
     * @param semester the semester the class takes place in
     */
    public Class(String name, StudentList studentList, CourseList courseList, int semester) {
        className=name;
        this.semester=semester;
        studentClassList = new StudentList();
        courseClassList = new CourseList();


        for (int i =0; i< studentList.size();i++) {
            Student temp = studentList.get(i);

            if (temp.getSemester()==semester && temp.getClassName().equals(className)) {
                studentClassList.addStudent(temp);
            }
        }

        for (int i =0; i< courseList.size();i++) {
            Course temp = courseList.get(i);

            if (temp.getSemester()==semester && temp.getClassName().equals(className))
            {
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
     * Sets the semester number.
     * @param semester what the semester will be set to
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Gets the semester number for class.
     * @return the semester number
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Get the list of student objects in class.
     * @return the list of student objects in class
     */
    public StudentList getStudents() {
        return studentClassList;
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
