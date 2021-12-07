package Model;

import java.util.ArrayList;

/**
 * A class containing class information.
 * @author Bhupas
 * @version 1.1
 */

public class Course {

    private String courseName;
    private int ectsPoints;
    private StudentList students;
    private TeacherList teachers;
    private int semester;
    private String className;

    /**
     * 1 argugment constructor initializing Course
     * @param studentList the student that are part of the course
     */

    public Course(StudentList studentList)
    {
        students=studentList;
    }

    /**
     *Returns the students
     * @return returns the student.
     */


    public StudentList getStudents() {
        return students;
    }

    /**
     * adds the students to the list of student in the course
     * @param student adds the students to the course
     */

    public void addStudent(Student student){
        students.addStudent(student);

    }

    /**
     * removes the students from the list of student in the course
     * @param student removes the students from the course
     */
    public void removeStudent(Student student) {
        students.removeStudent(student);
    }

    /**
     * Adds the teacher from the list to the course
     * @return a teacher going to be added to the course
     */

    public TeacherList getTeachers() {
        return teachers;
    }

    /**
     * Adds ECTS points to the Course
     * @return ECTS point that is goint to be added from the list
     */
    public int getECTSPoint() {
        return ectsPoints;
    }

    /**
     * Returns the CourseName
     * @return return the name of the course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Returns the Semester Name
     * @return returns the semester name
     */
    public int getSemester(){
        return semester;
    }

    /**
     * returns the class name
     * @return returns the class name
     */

    public String getClassName()
    {
        return className;
    }


    /**
     * Compares the name, teacherList and studenList of the object of two cources.
     * @param obj object to be compared
     * @return true if the two objects are equal and false otherwise
     */


    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Course))
        {
            return false;
        }
        Course other = (Course) obj;
        return courseName.equals(other.courseName);
    }

    /**
     * Returns a string representation of the course
     * @return a string representation of the course in format: "Course name, Teacher, ectsPoints and students"
     */
    public String toString()
    {
        return courseName + "\n" + teachers + "\n" +ectsPoints + "\n" + students  ;
    }


}
