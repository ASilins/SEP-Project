package View;

import Model.Course;
import Model.CourseList;
import Model.ScheduleModelManager;
import Model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CoursesController implements Initializable
{
  private CourseList courseList;
  private CourseList removedCourses;
  private ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
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

  public void initialize (URL url, ResourceBundle rb){
    courseList = new CourseList();
    removedCourses = new CourseList();

    initializeList();
    initializeTable();

  }

  public void initializeList(){
    courseList = scheduleManager.getAllCourses();
  }

  public void initializeTable(){
    semesterCourse.setCellValueFactory(new PropertyValueFactory<Course, Integer>("semester"));
    courseNameCourse.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
    teacher1Course.setCellValueFactory(new PropertyValueFactory<Course, String>("teacher1Name"));
    teacher2Course.setCellValueFactory(new PropertyValueFactory<Course, String>("teacher2Name"));
    classCourse.setCellValueFactory(new PropertyValueFactory<Course, String>("className"));
    ectsPointsCourse.setCellValueFactory(new PropertyValueFactory<Course, Integer>("ECTSPoints"));

    coursesTable.getItems().clear();
    for (int i = 0; i < courseList.size(); i++)
    {
      coursesTable.getItems().add(courseList.get(i));
    }
  }

  public void switchToSceneHome(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource("Home.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Stage window = (Stage) btnHome.getScene().getWindow();
    window.setScene(new Scene(root, 950, 950));
    window.show();

  }

}
