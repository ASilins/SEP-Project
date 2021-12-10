package View;
import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class HomeController
{
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
    @FXML
    Button btnStudents, btnClasses, btnTeachers, btnRooms, btnCourses, btnLessons;

    public void switchToSceneHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Home.fxml"))
        );
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage window = (Stage) btnHome.getScene().getWindow();
        window.setScene(new Scene(root, 645, 720));

        window.show();

    }

    public void switchToSceneStudent() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Students.fxml"))
        );
        Stage window = (Stage) btnStudents.getScene().getWindow();
        window.setScene(new Scene(root, 645, 720));

        window.show();

    }

    public void switchToSceneClass() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Classes.fxml"))
        );
        Stage window = (Stage) btnClasses.getScene().getWindow();
        window.setScene(new Scene(root, 645, 720));

        window.show();

    }

    public void switchToSceneTeacher() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Teachers.fxml"))
        );
        Stage window = (Stage) btnTeachers.getScene().getWindow();
        window.setScene(new Scene(root, 645, 720));

        window.show();

    }

    public void switchToSceneRoom() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Rooms.fxml"))
        );
        Stage window = (Stage) btnRooms.getScene().getWindow();
        window.setScene(new Scene(root, 645, 720));

        window.show();

    }

    public void switchToSceneCourses() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Courses.fxml"))
        );
        Stage window = (Stage) btnCourses.getScene().getWindow();
        window.setScene(new Scene(root, 645, 720));

        window.show();

    }

    public void switchToSceneLessons() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Lessons.fxml"))
        );
        Stage window = (Stage) btnLessons.getScene().getWindow();
        window.setScene(new Scene(root, 645, 720));

        window.show();

    }

}
