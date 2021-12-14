package View;

import Model.ScheduleModelManager;
import Model.Student;
import Model.StudentList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentsController implements Initializable
{
  @FXML private Button btnHome, btnSave;
  @FXML private Hyperlink websiteLink;
  @FXML private ListView<Student> allStudentsList;
  @FXML
  private TableView<Student> students;
  @FXML private TableColumn<Student,String> name;
  @FXML private TableColumn<Student,Integer> number;
  @FXML private TableColumn<Student,Integer> semester;
  @FXML private TableColumn<Student,String> className;
  private Student student;
  private StudentList studentList;
  private StudentList tempList;
  private ObservableList<StudentList> allStudents;
  private StudentList removedStudents;
  private int numberOfRemovedStudents = 0;
  private ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
      "src/Files/teachers.bin", "src/Files/classes.bin", "src/Files/courses.bin",
      "src/Files/rooms.bin", "src/Files/lessons.bin");
  @FXML private TextField nameField;
  @FXML private TextField studentNumberField;
  @FXML private TextField semesterField;
  @FXML private TextField classField;
  @FXML private ComboBox studentBox;



  public void switchToSceneHome(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource("Home.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Stage window = (Stage) btnHome.getScene().getWindow();
    window.setScene(new Scene(root, 950, 950));
    window.show();

  }



  public void initialize(URL url, ResourceBundle rb)
  {
    studentList = new StudentList();
    removedStudents = new StudentList();
    studentList = scheduleManager.getAllStudents();
    /*allStudents = FXCollections.observableArrayList();
    for (int i = 0; i < studentList.size(); i++)
    {
      allStudents.add(i, studentList);
    }*/
    initializeTable();
    initializeComboBox();

  }

  private void initializeTable() {
    TableSelectionModel<Student> selectionModel = students.getSelectionModel();
    selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
    name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
    number.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentNumber"));
    semester.setCellValueFactory(new PropertyValueFactory<Student,Integer>("semester"));
    className.setCellValueFactory(new PropertyValueFactory<Student,String>("className"));
//      students.getItems().addAll(allStudents);
    for (int i = 0; i < studentList.size(); i++)
    {
      students.getItems().add(studentList.get(i));
      removedStudents.addStudent(studentList.get(i));
    }
  }

  @FXML private void removeButton(ActionEvent event){
    Student selected = students.getSelectionModel().getSelectedItem();
    this.student = selected;
    removedStudents.addStudent(selected);
    studentList.removeStudent(selected);
    students.getItems().remove(selected);
    initializeTable();
    numberOfRemovedStudents++;
  }

  private void initializeComboBox()
  {
    for (int i = 0; i < studentList.size(); i++)
    {
     studentBox.getItems().add(studentList.get(i).toString());
    }

  }

  @FXML private void btnSave(ActionEvent event)
  {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove " +
        numberOfRemovedStudents + " students?", ButtonType.YES, ButtonType.CANCEL);
    alert.setHeaderText("Are you sure you want to continue?");
    alert.setTitle(null);

    alert.showAndWait();

    if (alert.getResult() == ButtonType.YES)
    {
      for (int i = 0; i < removedStudents.size(); i++)
      {
        scheduleManager.removeStudent(removedStudents.get(i));
      }
      for (int i = 0; i < numberOfRemovedStudents; i++)
      {
        removedStudents.removeStudent(tempList.get(i));
      }
      this.numberOfRemovedStudents = 0;
    }
  }
}
