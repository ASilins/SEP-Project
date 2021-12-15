package Model;

import java.io.Serializable;

/**
 * A class containing class information.
 * @author Bhupas and Sid
 * @version 1.2
 */
public class Course implements Serializable
{

    private String courseName;
    private int ectsPoints;
    private StudentList students;
    private Teacher teacher1;
    private Teacher teacher2;
    private int semester;
    private String className;

    /**
     * 6 argugment constructor initializing Course
     * @param studentList a list of all students, from which the students that are part of the course can be selected
     * @param courseName the name of the course
     * @param ectsPoints the number of ects points the course will provide
     * @param teacher1 the teacher who will teach this course
     * @param semester the semester in which the course will take place
     * @param className the name of the class that has this course
     */
    public Course(StudentList studentList, String courseName, int ectsPoints, Teacher teacher1, int semester, String className) {
        students = new StudentList();
        for (int i=0; i<studentList.size(); i++)
        {
            if (studentList.get(i).getClassName().equals(className) && studentList.get(i).getSemester()==semester)
            {
                students.addStudent(studentList.get(i));
            }

        }
        this.courseName=courseName;
        this.ectsPoints=ectsPoints;
        this.teacher1=teacher1;
        this.semester=semester;
        this.className=className;
        teacher2=null;
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
     * adds teacher1 to the course
     * @param teacher1 the teacher who needs to be added to the course
     */
    public void addTeacher1(Teacher teacher1)
    {
        this.teacher1=teacher1;
    }

    /**
     * adds teacher2 to the course
     * @param teacher2 the teacher who needs to be added to the course
     */
    public void addTeacher2(Teacher teacher2) {
        this.teacher2=teacher2;


    }

    /**
     * Adds the teacher from the list to the course
     * @return a teacher going to be added to the course
     */
    public Teacher getTeacher1() {
        return teacher1;
    }

    /**
     * adds the teachers from the course to the course teacher list and returns them
     * @return both teachers from the course
     */
    public TeacherList getTeachers() {
        TeacherList teachers = new TeacherList();
        teachers.addTeacher(teacher1);
        teachers.addTeacher(teacher2);
        return teachers;
    }

    /**
     * necessary for the tableview in gui
     * @return initials of teacher1
     * @author Ondrej
     */
    public String getTeacher1Name(){
        return teacher1.getInitials();
    }

    /**
     * necessary for the tableview in gui
     * @return initials of teacher2
     * @author Ondrej
     */
    public String getTeacher2Name(){
        return teacher2.getInitials();
    }

    /**
     * removes teacher1 from the course
     * @param teacher1 the teacher who is gonna be removed
     */
    public void removeTeacher1(Teacher teacher1)
    {
        teacher1=null;
    }

    /**
     * removes teacher2 from the course
     * @param teacher2 the teacher who is gonna be removed
     */
    public void removeTeacher2(Teacher teacher2)
    {
        teacher2=null;
    }

    /**
     * sets the ects points of the course
     * @param ectsPoints the ects points the course will provide
     */
    public void setECTSPoint(int ectsPoints)
    {
        this.ectsPoints=ectsPoints;
    }

    /**
     * Adds ECTS points to the Course
     * @return ECTS point that is goint to be added from the list
     */
    public int getECTSPoint() {
        return ectsPoints;
    }

    /**
     * sets the name of the course
     * @param courseName the new name the course will have
     */
    public void setCourseName(String courseName)
    {
        this.courseName=courseName;
    }

    /**
     * Returns the CourseName
     * @return return the name of the course
     */

    public String getCourseName() {
        return courseName;
    }

    /**
     * sets the semester of the course
     * @param semester a new semester the course will take place in
     */
    public void setSemester(int semester)
    {
        this.semester=semester;
    }

    /**
     * Returns the Semester Name
     * @return returns the semester name
     */

    public int getSemester(){
        return semester;
    }

    /**
     * sets the name of the class that has this course
     * @param className the name of the class that has this course
     */
    public void setClassName(String className)
    {
        this.className=className;
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
    public boolean equals(Object obj) {
        boolean equal = false;

        if (!(obj instanceof Course)) {
            return equal;
        }
        else {


            Course other = (Course) obj;
            if (teacher2 != null && teacher1 != null) {
                if (courseName.equals(other.courseName) &&
                        teacher1.equals(other.teacher1) &&
                        teacher2.equals(other.teacher2) &&
                        students.equals(other.students) &&
                        ectsPoints == other.ectsPoints &&
                        semester == other.semester &&
                        className.equals(other.className)) {
                    equal = true;
                } else {
                    equal = false;
                }
            } else if (teacher1 != null) {
                if (courseName.equals(other.courseName) &&
                        teacher1.equals(other.teacher1) &&
                        students.equals(other.students) &&
                        ectsPoints == other.ectsPoints &&
                        semester == other.semester &&
                        className.equals(other.className)) {
                    equal = true;
                } else {
                    equal = false;
                }

            } else if (teacher2 != null) {
                if (courseName.equals(other.courseName) &&
                        teacher2.equals(other.teacher1) &&
                        students.equals(other.students) &&
                        ectsPoints == other.ectsPoints &&
                        semester == other.semester &&
                        className.equals(other.className)) {
                    equal = true;
                } else {
                    equal = false;

                }

            }
        }
        return equal;
    }

    /**
     * Returns a string representation of the course
     * @return a string representation of the course in format: "Course name, Teacher, ectsPoints and students"
     */
    public String toString() {
        if (teacher2==null) {
            return courseName + "\n" + teacher1.getInitials() + "\n" + ectsPoints  + "\n" + semester + "\n" + className + "\n";
        }
        else
        {
            return courseName + "\n" + teacher1.getInitials() + "\n" + teacher2.getInitials() + "\n" + ectsPoints + "\n"  + semester + "\n" + className + "\n";
        }
    }
}
