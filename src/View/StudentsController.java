package View;

import Model.ScheduleModelManager;
import Model.Student;
import Model.StudentList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
  @FXML private Button btnHome;
  @FXML private TableView<Student> studentsTable;
  @FXML private TableColumn<Student,String> name;
  @FXML private TableColumn<Student,Integer> number;
  @FXML private TableColumn<Student,Integer> semester;
  @FXML private TableColumn<Student,String> className;
  private Student oldStudent;
  private Student updatedStudent;
  private Student newStudent;
  private StudentList studentList;
  private StudentList removedStudents;
  private int numberOfRemovedStudents = 0;
  private ScheduleModelManager scheduleManager = new ScheduleModelManager("src/Files/students.bin",
      "src/Files/teachers.bin", "src/Files/classes.bin", "src/Files/courses.bin",
      "src/Files/rooms.bin", "src/Files/lessons.bin");
  @FXML private TextField nameField;
  @FXML private TextField studentNumberField;
  @FXML private TextField semesterField;
  @FXML private TextField classField;
  @FXML private ComboBox<String> studentBox;
  @FXML private TextField addStudentNameField;
  @FXML private TextField addStudentStudentNumberField;
  @FXML private TextField addStudentSemesterField;
  @FXML private TextField addStudentClassField;
  private boolean isCorrectFormatEdit = true;
  private final int studentNumberSize = 6;
  private final int semesterSize = 1;
  private boolean noError = true;



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

    initializeList();
    initializeTable();
    initializeStudentBox();
    initializeNumericTextFields();

  }

  private void initializeList(){
    studentList = scheduleManager.getAllStudents();
  }

  private void initializeTable() {
    TableSelectionModel<Student> selectionModel = studentsTable.getSelectionModel();
    selectionModel.setSelectionMode(SelectionMode.SINGLE);
    name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
    number.setCellValueFactory(new PropertyValueFactory<Student,Integer>("studentNumber"));
    semester.setCellValueFactory(new PropertyValueFactory<Student,Integer>("semester"));
    className.setCellValueFactory(new PropertyValueFactory<Student,String>("className"));

    studentsTable.getItems().clear();
    for (int i = 0; i < studentList.size(); i++)
    {
      studentsTable.getItems().add(studentList.get(i));

    }
  }

  @FXML private void removeButton(ActionEvent event){
    Student selected = studentsTable.getSelectionModel().getSelectedItem();
//    this.student = selected;
    removedStudents.addStudent(selected);
    studentList.removeStudent(selected);
    studentsTable.getItems().remove(selected);
//    initializeTable();
    numberOfRemovedStudents++;
    initializeStudentBox();
  }

  private void removeStudent()
  {

    for (int i = 0; i < removedStudents.size(); i++)
    {
      scheduleManager.removeStudent(removedStudents.get(i));
    }
    for (int i = removedStudents.size() - 1; i >= 0; i--)
    {
      removedStudents.removeStudent(removedStudents.get(i));
    }
    this.numberOfRemovedStudents = 0;

  }

  private void initializeStudentBox()
  {
    studentBox.getItems().clear();
    for (int i = 0; i < studentList.size(); i++)
    {
     studentBox.getItems().add(studentList.get(i).toString());
    }

  }

  private void clearTextFields(){
    nameField.clear();
    studentNumberField.clear();
    semesterField.clear();
    classField.clear();
    addStudentNameField.clear();
    addStudentStudentNumberField.clear();
    addStudentSemesterField.clear();
    addStudentClassField.clear();
  }

  private void initializeNumericTextFields()
  {
    studentNumberField.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*")) {
          studentNumberField.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });

    semesterField.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*")) {
          semesterField.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });

    addStudentStudentNumberField.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*")) {
          addStudentStudentNumberField.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });

    addStudentSemesterField.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*")) {
          addStudentSemesterField.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });
  }

  private void editStudent(){
//    initializeNumericTextFields();

    this.oldStudent = getStudent((String)studentBox.getSelectionModel().getSelectedItem());
    this.updatedStudent = oldStudent;

    if (isNullOrEmpty(nameField.getText()))
    {
      this.updatedStudent.setName(oldStudent.getName());
    }
    else
    {
      this.updatedStudent.setName(nameField.getText());
    }

    if (isNullOrEmpty(studentNumberField.getText()))
    {
      this.updatedStudent.setStudentNumber(oldStudent.getStudentNumber());
    }
    else if (isNullOrZero(Integer.parseInt(studentNumberField.getText())))
    {
      this.updatedStudent.setStudentNumber(oldStudent.getStudentNumber());
    }
    else
    {
      isCorrectFormatEdit = checkLength(studentNumberField.getText(), studentNumberSize);
      this.updatedStudent.setStudentNumber(Integer.parseInt(studentNumberField.getText()));
    }

    if (isNullOrEmpty(semesterField.getText()))
    {
      this.updatedStudent.setSemester(oldStudent.getSemester());
    }
    else if (isNullOrZero(Integer.parseInt(semesterField.getText())))
    {
      this.updatedStudent.setSemester(oldStudent.getSemester());
    }
    else
    {
      isCorrectFormatEdit = checkLength(semesterField.getText(), semesterSize);
      this.updatedStudent.setSemester(Integer.parseInt(semesterField.getText()));
    }

    if (isNullOrEmpty(classField.getText()))
    {
      this.updatedStudent.setClassName(oldStudent.getClassName());
    }
    else
    {
      this.updatedStudent.setClassName(classField.getText());
    }

    Alert alertError = new Alert(Alert.AlertType.ERROR, "One or more fields contain data in an incorrect format. \n"
        + "Please check that \"Student number\" field(s) contain(s) 6 \n"
        + "digits and \"Semester\" field(s) contain(s) 1 digit",
        ButtonType.OK);
    alertError.setHeaderText("Incorrect data entered");
    alertError.setTitle(null);

    if (!isCorrectFormatEdit)
    {
      noError = false;
      alertError.showAndWait();
    }
    else
    {
      scheduleManager.editStudent(oldStudent, updatedStudent);
      noError = true;
      studentList.removeStudent(oldStudent);
    }

  }

  private void addStudent(){

    Alert alertEmptyField = new Alert(Alert.AlertType.ERROR, "Student cannot be added. One or more fields \n"
        + "are empty. Please provide all required information.", ButtonType.OK);
    alertEmptyField.setHeaderText("An error has occurred while trying to add a student");
    alertEmptyField.setTitle(null);

    if (isNullOrEmpty(addStudentNameField.getText())
        || isNullOrEmpty(addStudentStudentNumberField.getText())
        || isNullOrEmpty(addStudentSemesterField.getText())
        || isNullOrEmpty(addStudentClassField.getText()))
    {
      noError = false;
      alertEmptyField.showAndWait();
    }
    else
    {
      int studentNumber = Integer.parseInt(addStudentStudentNumberField.getText());
      int semester = Integer.parseInt(addStudentSemesterField.getText());

      newStudent = new Student(addStudentNameField.getText(), studentNumber,
          semester, addStudentClassField.getText());



      scheduleManager.addStudent(newStudent);
    }

  }

  @FXML private void btnSave(ActionEvent event)
  {
    Alert alertNoSelection = new Alert(Alert.AlertType.ERROR, "Please select a student to be edited.", ButtonType.OK);
    alertNoSelection.setHeaderText("No student selected!");
    alertNoSelection.setTitle(null);

    Alert alertEmptyField = new Alert(Alert.AlertType.ERROR, "Student cannot be added. One or more fields \n"
      + "are empty. Please provide all required information.", ButtonType.OK);
    alertEmptyField.setHeaderText("An error has occurred while trying to add a student");
    alertEmptyField.setTitle(null);

    Alert alertRemoving = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove " +
        numberOfRemovedStudents + " students?", ButtonType.YES, ButtonType.CANCEL);
    alertRemoving.setHeaderText("Are you sure you want to continue?");
    alertRemoving.setTitle(null);

    if (numberOfRemovedStudents != 0)
    {
      alertRemoving.showAndWait();

      if (alertRemoving.getResult() == ButtonType.YES)
      {
        removeStudent();
      }
    }

    if (isBeingEdited())
    {
      if (studentBox.getSelectionModel().getSelectedItem() == null)
      {
        alertNoSelection.showAndWait();
      }
      else
      {
        editStudent();
      }
    }

    if (isBeingAdded())
    {
      if (isNullOrEmpty(addStudentNameField.getText())
          || isNullOrEmpty(addStudentStudentNumberField.getText())
          || isNullOrEmpty(addStudentSemesterField.getText())
          || isNullOrEmpty(addStudentClassField.getText()))
      {
        noError = false;
        alertEmptyField.showAndWait();
      }
      else
      {
        addStudent();
        noError = true;
      }
    }

    if (noError)
    {
      initializeList();
      initializeTable();
      initializeStudentBox();
      clearTextFields();
      initializeNumericTextFields();
    }

  }

  public static boolean isNullOrEmpty(String string) {
    return string == null || string.length() == 0;
  }

  public static boolean isNullOrZero(Object integer) {
    return integer == null || integer.equals(0);
  }

  public static boolean checkLength(String field, int length){
    return field.length() == length;
  }

  public boolean isBeingEdited(){
    if (!isNullOrEmpty(nameField.getText()))
      return true;
    else if (!isNullOrEmpty(studentNumberField.getText()))
      return true;
    else if (!isNullOrEmpty(semesterField.getText()))
      return true;
    else if (!isNullOrEmpty(classField.getText()))
      return true;
    else
      return false;
  }

  public boolean isBeingAdded(){
    if (!isNullOrEmpty(addStudentStudentNumberField.getText()))
      return true;
    else if (!isNullOrEmpty(addStudentNameField.getText()))
      return true;
    else if (!isNullOrEmpty(addStudentSemesterField.getText()))
      return true;
    else if (!isNullOrEmpty(addStudentClassField.getText()))
      return true;
    else
      return false;
  }

  public Student getStudent(String string)
  {
    Student tempStudent = null;
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentList.get(i).toString().equals(string))
      {
        tempStudent = studentList.get(i);
        break;
      }
    }
    return tempStudent;
  }

}
