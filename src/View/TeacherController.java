package View;

import Model.CourseList;
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
  private CourseList courseListEdit;
  private ArrayList<String> courseListAdd;
  private ArrayList<String> courseNames;
  private final ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
      "src/Files/teachers.bin", "src/Files/classes.bin", "src/Files/courses.bin",
      "src/Files/rooms.bin", "src/Files/lessons.bin");

  @FXML private Button btnHome;
  @FXML private TableView<Teacher> teachers;
  @FXML private TableColumn<Teacher, String> initials;
  @FXML private TableColumn<Teacher, ArrayList<String>> courses;
  @FXML private TextField nameFieldEdit;
  @FXML private ComboBox<String> teacherBox;
  @FXML private ComboBox<String> allCoursesEdit;
  @FXML private ListView<String> teacherCoursesEdit;
  @FXML private TextField nameFieldAdd;
  @FXML private ComboBox<String> courseBoxAdd;
  @FXML private ListView<String> teacherCoursesAdd;

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
    courseListEdit = new CourseList();
    courseListAdd = new ArrayList<>();
    courseNames = new ArrayList<>();

    initializeTeacherList();
    initializeCourseList();
    initializeTable();
    initializeTeachersEdit();
    getCourseNames();
    initializeAllCourses();
  }

  private void initializeTeacherList(){
    teacherList = scheduleManager.getAllTeachers();
  }

  private void initializeCourseList(){
    courseListEdit = scheduleManager.getAllCourses();
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
    for (int i = 0; i < teacherList.size(); i++)
    {
      teacherBox.getItems().add(teacherList.get(i).getInitials());
    }
  }

  private void getCourseNames(){
    for (int i = 0; i < courseListEdit.size(); i++)
    {
      courseNames.add(courseListEdit.get(i).getCourseName() + courseListEdit.get(i).getSemester()
          + courseListEdit.get(i).getClassName());
    }
  }

  private void initializeAllCourses(){
    for (int i = 0; i < courseNames.size(); i++)
    {
      allCoursesEdit.getItems().add(courseNames.get(i));
      courseBoxAdd.getItems().add(courseNames.get(i));
    }
  }

  @FXML private void initializeTeacherCoursesEdit(){
    Teacher teacher = null;
    for (int j = 0; j < teacherList.size(); j++)
    {
      if (teacherList.get(j).getInitials().equals(teacherBox.getSelectionModel().getSelectedItem()))
      {
        teacher = teacherList.get(j);
        break;
      }
    }
    if (teacher != null)
    {
      for (int i = 0; i < teacher.getCourses().size(); i++)
      {
        teacherCoursesEdit.getItems().add(teacher.getCourses().get(i));
      }
      nameFieldEdit.setText(teacher.getInitials());
    }
  }

  @FXML private void addCourseEdit(){
    teacherCoursesEdit.getItems().add(allCoursesEdit.getSelectionModel().getSelectedItem());
  }

  @FXML private void removeCourseEdit(){
    teacherCoursesEdit.getItems().remove(teacherCoursesEdit.getSelectionModel().getSelectedItem());
  }

  private Teacher getOldTeacher(){
    Teacher teacher = null;
    for (int i = 0; i < teacherList.size(); i++)
    {
      if (teacherList.get(i).getInitials().equals(teacherBox.getSelectionModel().getSelectedItem()))
      {
        teacher = teacherList.get(i);
        break;
      }
    }
    return teacher;
  }

  private void editTeacher(){
    ArrayList<String> courseList = new ArrayList<>(
        teacherCoursesEdit.getItems());
    Teacher newTeacher = new Teacher(nameFieldEdit.getText(), courseList);

    scheduleManager.editTeacher(getOldTeacher(), newTeacher);
  }

  @FXML private void addCourseAdd(){
    teacherCoursesAdd.getItems().add(courseBoxAdd.getSelectionModel().getSelectedItem());
  }

  @FXML private void removeCourseAdd(){
    teacherCoursesEdit.getItems().remove(teacherCoursesAdd.getSelectionModel().getSelectedItem());
  }

  private void addTeacher(){
    courseListAdd = new ArrayList<>(
        teacherCoursesAdd.getItems()
    );
    Teacher newTeacher = new Teacher(nameFieldAdd.getText(), courseListAdd);

    scheduleManager.addTeacher(newTeacher);
  }

  @FXML private void btnSave(){
    Alert alertRemoving = new Alert(Alert.AlertType.CONFIRMATION,
        "Are you sure you want to remove " + removedTeachers.size() + " teachers?", ButtonType.YES, ButtonType.CANCEL);
    alertRemoving.setHeaderText("Are you sure you want to continue?");
    alertRemoving.setTitle(null);

    Alert alertEditing = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to proceed?",
        ButtonType.YES, ButtonType.CANCEL);
    alertEditing.setHeaderText("You are about to edit a teacher");
    alertEditing.setTitle(null);

    Alert alertAdding = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to proceed?",
        ButtonType.YES, ButtonType.CANCEL);
    alertAdding.setHeaderText("You are about to add a teacher");
    alertAdding.setTitle(null);

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
      }
    }

    if (teacherBox.getSelectionModel().getSelectedItem() != null)
    {
      alertEditing.showAndWait();

      if (alertEditing.getResult() == ButtonType.YES)
      {
        editTeacher();
      }
    }

    if (!isNullOrEmpty(nameFieldAdd.getText()))
    {
      alertAdding.showAndWait();

      if (alertAdding.getResult() == ButtonType.YES)
      {
        addTeacher();
      }
    }

    initializeTable();
    initializeTeachersEdit();

  }

  private static boolean isNullOrEmpty(String string) {
    return string == null || string.length() == 0;
  }
}
