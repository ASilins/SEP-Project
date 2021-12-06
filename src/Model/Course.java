package Model;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private int ectsPoints;
    private StudentList students;
    private TeacherList teachers;
    private int semester;

    public Course(StudentList studentList)
    {
        students=studentList;
    }

    public StudentList getStudents() {
        return students;
    }

    public TeacherList getTeachers() {
        return teachers;
    }

    public int getECTSPoint() {
        return ectsPoints;
    }

    public String getCourseNames() {
        return courseName;
    }

    public int getSemester(){
        return semester;
    }

    public void addStudent(Student student){
        students.addStudent(student);

    }
    public void removeStudent(Student student) {
        students.removeStudent(student);
    }


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
    public String toString()
    {
        return courseName + "\n" + teachers + "\n" +ectsPoints + "\n" + students  ;
    }


}
