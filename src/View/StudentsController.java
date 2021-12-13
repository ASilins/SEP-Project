package View;

import Model.ScheduleModelManager;
import Model.Student;
import Model.StudentList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
  private StudentList studentList;
  private ObservableList<StudentList> allStudents;
  private ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
      "src/Files/teachers.bin", "src/Files/classes.bin", "src/Files/courses.bin",
      "src/Files/rooms.bin", "src/Files/lessons.bin");



  public void switchToSceneHome(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource("Home.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Stage window = (Stage) btnHome.getScene().getWindow();
    window.setScene(new Scene(root, 700, 800));
    window.show();

  }



  public void initialize(URL url, ResourceBundle rb)
  {
    studentList = new StudentList();
    studentList = scheduleManager.getAllStudents();
    allStudents = FXCollections.observableArrayList();
    for (int i = 0; i < studentList.size(); i++)
    {
      allStudents.add(i, studentList);
    }
    intitializeTable();

  }

  private void intitializeTable() {
    name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
    number.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentNumber"));
    semester.setCellValueFactory(new PropertyValueFactory<Student,Integer>("semester"));
    className.setCellValueFactory(new PropertyValueFactory<Student,String>("className"));
    System.out.println(studentList.size());
      //students.setItems(allStudents);
    for (int i = 0; i < studentList.size(); i++)
    {
      students.getItems().add(studentList.get(i));
    }
  }

  //  FOR LOOP ADDING THE STUDENTS!!!!!

  private void removeButton(ActionEvent event){
    Student selected =students.getSelectionModel().getSelectedItem();
    System.out.println(selected);
    studentList.removeStudent(selected);
    allStudents.remove(selected);
    

  }
}
