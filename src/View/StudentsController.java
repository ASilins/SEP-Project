package View;

import Model.StudentList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentsController
{
  @FXML private Button btnHome, btnSave;
  @FXML private Hyperlink websiteLink;
  @FXML private ListView allStudentsList;
  private StudentList students;

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
    for (int i = 0; i < students.size(); i++)
    {
      allStudentsList.getItems().add(students.get(i));
    }
    allStudentsList.getItems().addAll("Hello", "Hi", "Bye");
  }

}
