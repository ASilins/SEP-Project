package Model;

import Utils.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A class that manages other classes
 * @author Arturs Silins
 * @version 1.0
 */
public class ScheduleModelManager
{
  private String studentFileName;
  private String teacherFileName;
  private String classFileName;
  private String courseFileName;
  private String roomFileName;
  private String lessonFileName;

  /**
   * 6 argument constructor setting file names.
   * @param studentFileName what the student file name will be
   * @param teacherFileName what the teacher file name will be
   * @param classFileName what the class file name will be
   * @param courseFileName what the course file name will be
   * @param roomFileName what the room file name will be
   * @param lessonFileName what the lesson file name will be
   */
  public ScheduleModelManager(String studentFileName, String teacherFileName, String classFileName, String courseFileName, String roomFileName, String lessonFileName) {
    this.studentFileName = studentFileName;
    this.teacherFileName = teacherFileName;
    this.classFileName = classFileName;
    this.courseFileName = courseFileName;
    this.roomFileName = roomFileName;
    this.lessonFileName = lessonFileName;
  }

  /**
   * Get a list of student objects from file.
   * @return a list of student objects
   */
  public StudentList getAllStudents() {
    StudentList allStudents = new StudentList();

    try {
      allStudents = (StudentList) MyFileHandler.readFromBinaryFile(studentFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allStudents;
  }

  /**
   * Get a list of teacher objects form file.
   * @return a list of teacher objects.
   */
  public TeacherList getAllTeachers() {
    TeacherList allTeachers = new TeacherList();

    try {
      allTeachers = (TeacherList) MyFileHandler.readFromBinaryFile(teacherFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allTeachers;
  }

  /**
   * Get a list of class objects from file.
   * @return a list of class objects
   */
  public ClassList getAllClasses() {
    ClassList allClasses = new ClassList();

    try {
      allClasses = (ClassList) MyFileHandler.readFromBinaryFile(classFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allClasses;
  }

  /**
   * Get a list of room objects from file.
   * @return a list of room objects
   */
  public RoomList getAllRooms() {
    RoomList allRooms = new RoomList();

    try {
      allRooms = (RoomList) MyFileHandler.readFromBinaryFile(roomFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allRooms;
  }

  /**
   * Get a list of course objects from file.
   * @return a list of course objects
   */
  public CourseList getAllCourses() {
    CourseList allCourses = new CourseList();

    try {
      allCourses = (CourseList) MyFileHandler.readFromBinaryFile(courseFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allCourses;
  }

  /**
   * Get a list of lesson objects from file.
   * @return a list of lesson objects
   */
  public ScheduleSystem getAllLessons() {
    ScheduleSystem allLessons = new ScheduleSystem();

    try {
      allLessons = (ScheduleSystem) MyFileHandler.readFromBinaryFile(lessonFileName);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error Reading file");
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found");
    }

    return allLessons;
  }

  /**
   * Add student object to student object list and save it using saveStudents method.
   * @param student an object that will be added to the list
   */
  public void addStudent(Student student) {
    StudentList allStudents = getAllStudents();

    if (!(allStudents.check(student))) {
      allStudents.addStudent(student);
      saveStudents(allStudents);
    }
  }

  /**
   * Replace object from student object list with a new object.
   * @param oldStudent an object that will be removed
   * @param newStudent an object that will be added
   */
  public void editStudent(Student oldStudent, Student newStudent) {
    StudentList allStudents = getAllStudents();
    allStudents.removeStudent(oldStudent);
    allStudents.addStudent(newStudent);
    saveStudents(allStudents);
  }

  /**
   * Remove student object from student object list.
   * @param student an object that will be removed
   */
  public void removeStudent(Student student) {
    StudentList allStudents = getAllStudents();

    if (allStudents.check(student)) {
      allStudents.removeStudent(student);
      saveStudents(allStudents);
    } else {
      System.err.println("Student is not in the list");
    }
  }

  /**
   * Save student object list to binary file.
   * @param allStudents an object list that will be written to file
   */
  public void saveStudents(StudentList allStudents) {
    try {
      MyFileHandler.writeToBinaryFile(studentFileName, Sorter.sortStudents(allStudents));
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error writing file");
    }
  }

  /**
   * Add teacher object to teacher object list and save it using saveTeacher method.
   * @param teacher an object that will be added to the list
   */
  public void addTeacher(Teacher teacher) {
    TeacherList allTeachers = getAllTeachers();

    if (!(allTeachers.check(teacher))) {
      allTeachers.addTeacher(teacher);
      saveTeachers(allTeachers);
    }
  }

  /**
   * Replace object from teacher object list with a new object and save it using saveTeacher method.
   * @param oldTeacher an object that will be removed
   * @param newTeacher and object that will be added
   */
  public void editTeacher(Teacher oldTeacher, Teacher newTeacher) {
    TeacherList allTeachers = getAllTeachers();
    allTeachers.removeTeacher(oldTeacher);
    allTeachers.addTeacher(newTeacher);
    saveTeachers(allTeachers);
  }

  /**
   * Remove teacher object from teacher object list and save it using saveTeacher method.
   * @param teacher an object that will be removed
   */
  public void removeTeacher(Teacher teacher) {
    TeacherList allTeachers = getAllTeachers();

    if (allTeachers.check(teacher)) {
      allTeachers.removeTeacher(teacher);
      saveTeachers(allTeachers);
    } else {
      System.err.println("Teacher is not in the list");
    }
  }

  /**
   * Save teacher object list to binary file using file handler class.
   * @param allTeachers an object list that will be saved
   */
  public void saveTeachers(TeacherList allTeachers) {
    try {
      MyFileHandler.writeToBinaryFile(teacherFileName, Sorter.sortTeachers(allTeachers));
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error writing file");
    }
  }

  /**
   * Add room object to room object list and save it using saveRooms method.
   * @param room an object that will be added to the list
   */
  public void addRoom(Room room) {
    RoomList allRooms = getAllRooms();

    if (!(allRooms.check(room))) {
      allRooms.addRoom(room);
      saveRooms(allRooms);
    }
  }

  /**
   * Replace room object from room object list with a new object and save it using saveRooms method.
   * @param oldRoom an object that will be removed
   * @param newRoom an object that will be added
   */
  public void editRoom(Room oldRoom, Room newRoom) {
    RoomList allRooms = getAllRooms();
    allRooms.removeRoom(oldRoom);
    allRooms.addRoom(newRoom);
    saveRooms(allRooms);
  }

  /**
   * Remove room object from room object list and save it using saveRooms method.
   * @param room an object that will be removed
   */
  public void removeRoom(Room room) {
    RoomList allRooms = getAllRooms();

    allRooms.removeRoom(room);
    saveRooms(allRooms);
  }

  /**
   * Save room object list to binary file using file handler class.
   * @param allRooms an object list of that will be saved
   */
  public void saveRooms(RoomList allRooms) {
    try {
      MyFileHandler.writeToBinaryFile(roomFileName, allRooms);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error writing file");
    }
  }

  /**
   * Add course object to course object list and save it using saveCourses method.
   * @param course an object that will be added to the list
   */
  public void addCourse(Course course) {
    CourseList allCourses = getAllCourses();

    if (!(allCourses.check(course))) {
      allCourses.addCourse(course);
      saveCourses(allCourses);
    }
  }

  /**
   * Replace course object from course object list with a new object and save it using saveCourses method.
   * @param oldCourse an object that will be removed
   * @param newCourse and object that will be added
   */
  public void editCourse(Course oldCourse, Course newCourse) {
    CourseList allCourses = getAllCourses();
    allCourses.removeCourse(oldCourse);
    allCourses.addCourse(newCourse);
    saveCourses(allCourses);
  }

  /**
   * Remove course object from course object list and save it using saveCourses method.
   * @param course an object that will be removed
   */
  public void removeCourse(Course course) {
    CourseList allCourses = getAllCourses();

    allCourses.removeCourse(course);
    saveCourses(allCourses);
  }

  /**
   * Save course object list to binary file using file handler class/
   * @param allCourses an object list that will be saved
   */
  public void saveCourses(CourseList allCourses) {
    try {
      MyFileHandler.writeToBinaryFile(courseFileName, allCourses);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("IO Error writing file");
    }
  }

  /**
   * Add lesson object to course object list and save it using saveLessons method.
   * @param lesson an object that will be added to the list
   */
  public void addLesson(Lesson lesson) {
    ScheduleSystem allLessons = getAllLessons();

    if (!(allLessons.check(lesson))) {
      allLessons.addLesson(lesson);
      saveLessons(allLessons);
    }
  }

  /**
   * Replace lesson object from lesson object list with a new object and save it using saveLessons method.
   * @param oldLesson an object that will be removed
   * @param newLesson an object that will be added
   */
  public void editLesson(Lesson oldLesson, Lesson newLesson) {
    ScheduleSystem allLessons = getAllLessons();
    allLessons.removeLesson(oldLesson);
    allLessons.addLesson(newLesson);
    saveLessons(allLessons);
  }

  /**
   * Remove lessons object from lesson object list and save it using saveLessons method.
   * @param lesson an object that will be removed
   */
  public void removeLesson(Lesson lesson) {
    ScheduleSystem allLessons = getAllLessons();
    allLessons.removeLesson(lesson);
    saveLessons(allLessons);
  }

  /**
   * Save lesson object list to binary file using file handler class.
   * @param allLessons an object list that will be saved
   */
  public void saveLessons(ScheduleSystem allLessons) {
    try {
      MyFileHandler.writeToBinaryFile(lessonFileName, allLessons);
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("Io Error writing file");
    }
  }

  /**
   * Get a student object by name.
   * @param name the name that will be compared
   * @return a student object with equal name with parameter
   */
  public Student getStudentByName(String name) {
    StudentList allStudents = getAllStudents();

    for (int i = 0; i < allStudents.size(); i++) {
      if (allStudents.get(i).getName().equals(name)) {
        return allStudents.get(i);
      }
    }

    return null;
  }

  /**
   * Get a student object by student number.
   * @param num the number that will be compared
   * @return a student object with equal student number with parameter
   */
  public Student getStudentByNum(int num) {
    StudentList allStudents = getAllStudents();

    for (int i = 0; i < allStudents.size(); i++) {
      if (allStudents.get(i).getStudentNumber() == num) {
        return allStudents.get(i);
      }
    }

    return null;
  }

  /**
   * Get a student object by semester.
   * @param semester the number that will be compared
   * @return a student object with equal semester number with parameter
   */
  public Student getStudentBySemester(int semester) {
    StudentList allStudents = getAllStudents();

    for (int i = 0; i < allStudents.size(); i++) {
      if (allStudents.get(i).getSemester() == semester) {
        return allStudents.get(i);
      }
    }

    return null;
  }

  /**
   * Get a student object by class name.
   * @param className the class name that will be compared
   * @return a student object with equal class name with parameter
   */
  public Student getStudentByClass(String className) {
    StudentList allStudents = getAllStudents();

    for (int i = 0; i < allStudents.size(); i++) {
      if (allStudents.get(i).getClassName().equals(className)) {
        return allStudents.get(i);
      }
    }

    return null;
  }

  /**
   * Get a teacher object by initials.
   * @param initial the string that will be compared
   * @return a teacher object with equal initials string with parameter
   */
  public Teacher getTeacherByInitials(String initial) {
    TeacherList allTeachers = getAllTeachers();

    for (int i = 0; i < allTeachers.size(); i++)
    {
      if (allTeachers.get(i).getInitials().equals(initial)) {
        return allTeachers.get(i);
      }
    }

    return null;
  }

  /**
   * Get a teacher object by course.
   * @param course the object that will be compared
   * @return a teacher object with equal course object with parameter
   */
  public Teacher getTeacherByCourse(String course) {
    TeacherList allTeachers = getAllTeachers();

    for (int i = 0; i < allTeachers.size(); i++) {
      for (int j = 0; j < allTeachers.get(i).courseSize(); j++) {
        if (allTeachers.get(i).getCourses().get(j).equals(course)) {
          return allTeachers.get(i);
        }
      }
    }

    return null;
  }

  /**
   * Get room object list by block.
   * @param block a char that will be compared
   * @return a room object list with equal block chars with parameter
   */
  public RoomList getRoomsByBlock(char block) {
    RoomList roomsFromBlock = new RoomList();
    RoomList allRooms = getAllRooms();

    for (int i = 0; i < allRooms.size(); i++) {
      if (allRooms.get(i).getBlock() == block) {
        roomsFromBlock.addRoom(allRooms.get(i));
      }
    }

    return roomsFromBlock;
  }

  /**
   * Get room object list by floor.
   * @param floor an int that will be compared
   * @return a room object list with equal floor ints with parameter
   */
  public RoomList getRoomsByFloor(int floor) {
    RoomList roomsFromFloor = new RoomList();
    RoomList allRooms = getAllRooms();

    for (int i = 0; i < allRooms.size(); i++) {
      if (allRooms.get(i).getFloor() == floor) {
        roomsFromFloor.addRoom(allRooms.get(i));
      }
    }

    return roomsFromFloor;
  }

  /**
   * Get a room object by room number.
   * @param number a string that wil be compared
   * @return a room object with equal room number with parameter
   */
  public Room getRoomByNumber(String number) {
    RoomList allRooms = getAllRooms();

    for (int i = 0; i < allRooms.size(); i++) {
      if (allRooms.get(i).getRoomNumber().equals(number)) {
        return allRooms.get(i);
      }
    }
    return null;
  }

  /**
   * Get room object list by room capacity.
   * @param capacity an int that will be compared
   * @return a room object list with equal capacity ints with parameter
   */
  public RoomList getRoomsByCapacity(int capacity) {
    RoomList roomByCapacity = new RoomList();
    RoomList allRooms = getAllRooms();

    for (int i = 0; i < allRooms.size(); i++) {
      if (allRooms.get(i).getCapacity() == capacity) {
        roomByCapacity.addRoom(allRooms.get(i));
      }
    }

    return roomByCapacity;
  }

  /**
   * Get course object list by semester.
   * @param semester an int that will be compared
   * @return a course object list with equal semester ints with parameter
   */
  public CourseList getCoursesBySemester(int semester) {
    CourseList coursesBySemester = new CourseList();
    CourseList allCourses = getAllCourses();

    for (int i = 0; i < allCourses.size(); i++) {
      if (allCourses.get(i).getSemester() == semester) {
        coursesBySemester.addCourse(allCourses.get(i));
      }
    }

    return coursesBySemester;
  }

  /**
   * Get course object list by student object.
   * @param student an object that will be compared
   * @return a course object list with equal student object with parameter
   */
  public CourseList getCoursesByStudent(Student student) {
    CourseList coursesForStudent = new CourseList();
    CourseList allCourses = getAllCourses();

    for (int i = 0; i < allCourses.size(); i++) {
      for (int j = 0; j < allCourses.get(i).getStudents().size(); j++) {
        if (allCourses.get(i).getStudents().get(j).equals(student)) {
          coursesForStudent.addCourse(allCourses.get(i));
        }
      }
    }

    return coursesForStudent;
  }

  /**
   * Get course object list by teacher object.
   * @param teacher an object that will be compared
   * @return a course object list with equal teacher objects with parameter
   */
  public CourseList getCoursesByTeacher(Teacher teacher) {
    CourseList coursesForTeacher = new CourseList();
    CourseList allCourses = getAllCourses();

    for (int i = 0; i < allCourses.size(); i++) {
        if (allCourses.get(i).getTeacher().equals(teacher)) {
          coursesForTeacher.addCourse(allCourses.get(i));
        }
    }

    return coursesForTeacher;
  }

  /**
   * Get course object list with ECTS points.
   * @param ects an int that will be compared
   * @return a course object list with equal ects ints with parameter
   */
  public CourseList getCoursesByECTS(int ects) {
    CourseList coursesByECTS = new CourseList();
    CourseList allCourses = getAllCourses();

    for (int i = 0; i < allCourses.size(); i++) {
      if (allCourses.get(i).getECTSPoint() == ects) {
        coursesByECTS.addCourse(allCourses.get(i));
      }
    }

    return coursesByECTS;
  }

  /**
   * Get lesson object list by class object.
   * @param classObject an object that will be compared
   * @return a lesson object list with equal class objects compared with parameter
   */
  public ScheduleSystem getLessonsByClass(Class classObject) {
    ScheduleSystem lessonsByClass = new ScheduleSystem();
    ScheduleSystem allLessons = getAllLessons();

    for (int i = 0; i < allLessons.size(); i++) {
      if (allLessons.getLesson(i).getCourse().getClassName().equals(classObject.getName())) {
        lessonsByClass.addLesson(allLessons.getLesson(i));
      }
    }

    return lessonsByClass;
  }

  /**
   * Get lesson object list by teacher object.
   * @param teacher an object that will be compared
   * @return a lesson object list with equal teacher objects compared with parameter
   */
  public ScheduleSystem getLessonsByTeacher(Teacher teacher) {
    ScheduleSystem lessonsByTeacher = new ScheduleSystem();
    ScheduleSystem allLessons = getAllLessons();

    for (int i = 0; i < allLessons.size(); i++) {
      if (allLessons.getLesson(i).getCourse().getTeacher().equals(teacher)) {
        lessonsByTeacher.addLesson(allLessons.getLesson(i));
      }
    }

    return lessonsByTeacher;
  }

  /**
   * Get a class object name by student object.
   * @param student an object that will be compared
   * @return a class object name with equal student object compared with parameter
   */
  public String getClassByStudent(Student student) {
    ClassList allClasses = getAllClasses();

    for (int i = 0; i < allClasses.size(); i++) {
      for (int j = 0; j < allClasses.get(i).getStudents().size(); j++) {
        if (allClasses.get(i).getStudents().get(j).equals(student)) {
          return allClasses.get(i).getName();
        }
      }
    }

    return null;
  }

  /**
   * Get a class object by class object name.
   * @param className a string that will be compared
   * @return a class object with equal class name compared with parameter
   */
  public Class getClassByName(String className) {
    ClassList allClasses = getAllClasses();

    for (int i = 0; i < allClasses.size(); i++) {
      if (allClasses.get(i).getName().equals(className)) {
        return allClasses.get(i);
      }
    }

    return null;
  }

  /**
   * Get a class object list by semester.
   * @param semester an int that will be compared
   * @return a class object list with equal semester ints compared with parameter
   */
  public ClassList getClassesBySemester(int semester) {
    ClassList classesBySemester = new ClassList();
    ClassList allClasses = getAllClasses();

    for (int i = 0; i < allClasses.size(); i++) {
      if (allClasses.get(i).getSemester() == semester) {
        classesBySemester.addClass(allClasses.get(i));
      }
    }

    return classesBySemester;
  }
}
