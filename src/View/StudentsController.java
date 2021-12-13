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
  @FXML private TableColumn<Student,Integer> number;
  @FXML private TableColumn<Student,String> name;
  private StudentList studentList;
  private ObservableList<Student> allStudents;



  public void switchToSceneHome(ActionEvent event) throws IOException
  {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource("Home.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Stage window = (Stage) btnHome.getScene().getWindow();
    window.setScene(new Scene(root, 645, 720));
    window.show();

  }



  public void initialize(URL url, ResourceBundle rb)
  {
    studentList = new StudentList();
    studentList.addStudent(new Student("Bhupas",11,2,"b02"));
    studentList.addStudent(new Student("Bhupas1",11,2,"b02"));
    studentList.addStudent(new Student("Bhupas2",11,2,"b02"));
    studentList.addStudent(new Student("Bhupas3",11,2,"b02"));
    allStudents = FXCollections.observableList(studentList.getStudents());
    intitializeTable();

  }

  private void intitializeTable() {
    name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
    number.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentNumber"));

    students.setItems(allStudents);
  }

  @FXML
  private void removeButton(ActionEvent event){
    Student selected =students.getSelectionModel().getSelectedItem();
    System.out.println(selected);
    studentList.removeStudent(selected);
    allStudents.remove(selected);
    

  }
}
