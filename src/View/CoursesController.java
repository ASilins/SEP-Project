package View;

import Model.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CoursesController implements Initializable
{
  private CourseList courseList;
  private CourseList removedCourses;
  private int numberOfRemovedCourses = 0;
  private TeacherList teacherList;
  private StudentList studentList;
  private StudentList courseStudentList;
  private boolean noError = true;
  private final ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
      "src/Files/teachers.bin", "src/Files/classes.bin", "src/Files/courses.bin",
      "src/Files/rooms.bin", "src/Files/lessons.bin");

  @FXML private Button btnHome;
  @FXML private TableView<Course> coursesTable;
  @FXML private TableColumn<Course, String> courseNameCourse;
  @FXML private TableColumn<Course, Integer> ectsPointsCourse;
  @FXML private TableColumn<Course, String> teacher1Course;
  @FXML private TableColumn<Course, String> teacher2Course;
  @FXML private TableColumn<Course, Integer> semesterCourse;
  @FXML private TableColumn<Course, String> classCourse;
  @FXML private ComboBox<String> coursesBox;
  @FXML private TextField courseNameFieldEdit;
  @FXML private TextField ectsPointsFieldEdit;
  @FXML private TextField semesterFieldEdit;
  @FXML private TextField classFieldEdit;
  @FXML private ComboBox<String> teacher1BoxEdit;
  @FXML private ComboBox<String> teacher2BoxEdit;
  @FXML private TableView<Student> allStudentsTableEdit;
  @FXML private TableColumn<Student, Integer> studentNumberEdit1;
  @FXML private TableColumn<Student, String> studentNameEdit1;
  @FXML private TableColumn<Student, Integer> studentSemesterEdit1;
  @FXML private TableColumn<Student, String> studentClassEdit1;
  @FXML private TableView<Student> courseStudentsTableEdit;
  @FXML private TableColumn<Student, Integer> studentNumberEdit2;
  @FXML private TableColumn<Student, String> studentNameEdit2;
  @FXML private TableColumn<Student, Integer> studentSemesterEdit2;
  @FXML private TableColumn<Student, String> studentClassEdit2;
  @FXML private Button addStudentEditButton;
  @FXML private Button removeStudentEditButton;
  @FXML private ComboBox<String> teacher1BoxAdd;
  @FXML private ComboBox<String> teacher2BoxAdd;

  public void switchToSceneHome(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource("Home.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Stage window = (Stage) btnHome.getScene().getWindow();
    window.setScene(new Scene(root, 950, 950));
    window.show();

  }

  public void initialize (URL url, ResourceBundle rb){
    courseList = new CourseList();
    removedCourses = new CourseList();
    teacherList = new TeacherList();
    courseStudentList = new StudentList();

    initializeLists();
    initializeTable();
    initializeCoursesBox();
    initializeTeacherBoxes();

  }

  public void initializeLists(){
    courseList = scheduleManager.getAllCourses();
    teacherList = scheduleManager.getAllTeachers();
    studentList = scheduleManager.getAllStudents();
  }

  public void initializeTable(){
    semesterCourse.setCellValueFactory(new PropertyValueFactory<Course, Integer>("semester"));
    courseNameCourse.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
    teacher1Course.setCellValueFactory(new PropertyValueFactory<Course, String>("teacher1Name"));
    teacher2Course.setCellValueFactory(new PropertyValueFactory<Course, String>("teacher2Name"));
    classCourse.setCellValueFactory(new PropertyValueFactory<Course, String>("className"));
    ectsPointsCourse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Course, Integer>, ObservableValue<Integer>>()
    {
      @Override public ObservableValue<Integer> call(
          TableColumn.CellDataFeatures<Course, Integer> course)
      {
        ObservableValue<Integer> observableECTS = new SimpleIntegerProperty(course.getValue().getECTSPoint()).asObject();
        return observableECTS;
      }
    });

    coursesTable.getItems().clear();
    for (int i = 0; i < courseList.size(); i++)
    {
      coursesTable.getItems().add(courseList.get(i));
    }
  }

  @FXML public void removeCoursesButton(ActionEvent event){
    Course selected = coursesTable.getSelectionModel().getSelectedItem();

    removedCourses.addCourse(selected);
    courseList.removeCourse(selected);
    coursesTable.getItems().remove(selected);
    numberOfRemovedCourses++;

    initializeCoursesBox();

  }

  private void removeCourses(){

    for (int i = 0; i < removedCourses.size(); i++)
    {
      scheduleManager.removeCourse(removedCourses.get(i));
    }
    for (int i = removedCourses.size() - 1; i >= 0; i--)
    {
      removedCourses.removeCourse(removedCourses.get(i));
    }
    this.numberOfRemovedCourses = 0;

  }

  private void initializeCoursesBox(){
    coursesBox.getItems().clear();
    for (int i = 0; i < courseList.size(); i++)
    {
      coursesBox.getItems().add(courseList.get(i).toString());
    }

  }

  private void initializeTeacherBoxes(){
    teacher1BoxEdit.getItems().clear();
    teacher2BoxEdit.getItems().clear();
    teacher1BoxAdd.getItems().clear();
    teacher2BoxAdd.getItems().clear();

    for (int i = 0; i < teacherList.size(); i++)
    {
      teacher1BoxEdit.getItems().add(teacherList.get(i).getInitials());
      teacher2BoxEdit.getItems().add(teacherList.get(i).getInitials());
      teacher1BoxAdd.getItems().add(teacherList.get(i).getInitials());
      teacher2BoxAdd.getItems().add(teacherList.get(i).getInitials());
    }
  }

  private void initializeAllStudentsTableEdit(){

    // allStudentTable in Edit Student
    studentNumberEdit1.setCellValueFactory(new PropertyValueFactory<Student, Integer>("studentNumber"));
    studentNameEdit1.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
    studentSemesterEdit1.setCellValueFactory(new PropertyValueFactory<Student, Integer>("semester"));
    studentClassEdit1.setCellValueFactory(new PropertyValueFactory<Student, String>("className"));

    allStudentsTableEdit.getItems().clear();
    for (int i = 0; i < studentList.size(); i++)
    {
      allStudentsTableEdit.getItems().add(studentList.get(i));
    }
  }

  private void initializeCourseStudentTables(StudentList courseStudents){

    courseStudentsTableEdit.getItems().clear();
    for (int i = 0; i < courseStudents.size(); i++)
    {
      courseStudentsTableEdit.getItems().add(courseStudents.get(i));
    }
  }

  private void initializeEdit(){
    String name = "";
    String points = "";
    String semester = "";
    String className = "";
    String teacher1 = "";
    String teacher2 = "";


    studentNumberEdit2.setCellValueFactory(new PropertyValueFactory<Student, Integer>("studentNumber"));
    studentNameEdit2.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
    studentSemesterEdit2.setCellValueFactory(new PropertyValueFactory<Student, Integer>("semester"));
    studentClassEdit2.setCellValueFactory(new PropertyValueFactory<Student, String>("className"));

    for (int i = 0; i < courseList.size(); i++)
    {
      points = "";
      semester = "";

      if (courseList.get(i).toString().equals(coursesBox.getSelectionModel().getSelectedItem()))
      {
        name = courseList.get(i).getCourseName();
        points += courseList.get(i).getECTSPoint();
        semester += courseList.get(i).getSemester();
        className = courseList.get(i).getClassName();
        teacher1 = courseList.get(i).getTeacher1Name();
        teacher2 = courseList.get(i).getTeacher2Name();
        courseStudentList = courseList.get(i).getStudents();

        break;
      }
    }
    courseNameFieldEdit.setText(name);
    ectsPointsFieldEdit.setText(points);
    semesterFieldEdit.setText(semester);
    classFieldEdit.setText(className);
    teacher1BoxEdit.getSelectionModel().select(teacher1);
    teacher2BoxEdit.getSelectionModel().select(teacher2);
    initializeCourseStudentTables(courseStudentList);
  }

  @FXML private void onCourseSelection(ActionEvent event){
    if (event.getSource() == coursesBox)
    {
      initializeEdit();
      initializeAllStudentsTableEdit();
    }
  }

  @FXML private void addStudentEdit(Student student){
    int i;
    for (i = 0; i < studentList.size(); i++)
    {
      courseStudentList.addStudent(studentList.get(i));
    }
  }

  @FXML public void saveCourses(){
    Alert alertRemoving = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove " +
        numberOfRemovedCourses + " courses?", ButtonType.YES, ButtonType.CANCEL);
    alertRemoving.setHeaderText("Are you sure you want to continue?");
    alertRemoving.setTitle(null);

    if (numberOfRemovedCourses != 0)
    {
      alertRemoving.showAndWait();

      if (alertRemoving.getResult() == ButtonType.OK)
      {
        removeCourses();
      }
    }

  }

}
