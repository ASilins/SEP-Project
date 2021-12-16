package View;

import Model.ScheduleModelManager;
import Model.Teacher;
import Model.TeacherList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TeacherController
{
  private TeacherList teacherList;
  private TeacherList removedTeachers;
  private final ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
      "src/Files/teachers.bin", "src/Files/classes.bin", "src/Files/courses.bin",
      "src/Files/rooms.bin", "src/Files/lessons.bin");

  @FXML private Button btnHome;
  @FXML private TableView<Teacher> teachers;
  @FXML private TableColumn<Teacher, String> initials;
  @FXML private TableColumn<Teacher, ArrayList<String>> courses;
  @FXML private TextField nameField;
  @FXML private ComboBox<String> teacherBox;
  @FXML private Button addCourseEdit;
  @FXML private Button removeCourseEdit;
  @FXML private ComboBox<String> allCoursesEdit;
  @FXML private ListView<String> teacherCoursesEdit;

  public void switchToSceneHome(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource("Home.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Stage window = (Stage) btnHome.getScene().getWindow();
    window.setScene(new Scene(root, 950, 950));
    window.show();

  }

  public void initialize(){
    teacherList = new TeacherList();
    removedTeachers = new TeacherList();

    initializeTeacherList();
    initializeTable();
  }

  private void initializeTeacherList(){
    teacherList = scheduleManager.getAllTeachers();
  }

  private void initializeTable(){
    TableSelectionModel<Teacher> selectionModel = teachers.getSelectionModel();
    selectionModel.setSelectionMode(SelectionMode.SINGLE);
    initials.setCellValueFactory(new PropertyValueFactory<>("initials"));
    courses.setCellValueFactory(new PropertyValueFactory<>("courses"));

    teachers.getItems().clear();
    for (int i = 0; i < teacherList.size(); i++)
    {
      teachers.getItems().add(teacherList.get(i));
    }
  }

  @FXML private void removeTeacher(){
    removedTeachers.addTeacher(teachers.getSelectionModel().getSelectedItem());
    teachers.getItems().remove(teachers.getSelectionModel().getSelectedItem());

  }

  private void initializeTeachersEdit(){
    teacherBox.getItems().addAll()
  }

  private void addCourseEdit(){

  }

  @FXML private void btnSave(){
    Alert alertRemoving = new Alert(Alert.AlertType.CONFIRMATION,
        "Are you sure you want to remove " + removedTeachers.size() + " teachers?", ButtonType.YES, ButtonType.CANCEL);
    alertRemoving.setHeaderText("Are you sure you want to continue?");
    alertRemoving.setTitle(null);

    if (removedTeachers.size() > 0)
    {
      alertRemoving.showAndWait();

      if (alertRemoving.getResult() == ButtonType.YES)
      {
        for (int i = 0; i < removedTeachers.size(); i++)
        {
          teacherList.removeTeacher(removedTeachers.get(i));
        }
        removedTeachers = null;
        scheduleManager.saveTeachers(teacherList);
        /*for (int i = removedTeachers.size(); i >= 0; i--)
        {
          removedTeachers.removeTeacher(removedTeachers.get(i));
        }*/
      }
    }


  }
}
