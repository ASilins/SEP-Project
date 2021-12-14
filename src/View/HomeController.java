package View;
import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class HomeController
{
    @FXML
    Button btnStudents1, btnClasses, btnTeachers, btnRooms, btnCourses, btnLessons,
        btnSchedule, btnHome;
    @FXML
    Hyperlink websiteLink;


    //********** METHOD TO BE DELETED WHEN ITS TIME COMES **********\\

    public void switchToSceneHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Home.fxml"))
        );
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage window = (Stage) btnHome.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneStudents(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Students.fxml"))
        );
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage window = (Stage) btnStudents1.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }


    public void switchToSceneClasses() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Classes.fxml"))
        );
        Stage window = (Stage) btnClasses.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneTeachers() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Teachers.fxml"))
        );
        Stage window = (Stage) btnTeachers.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneRooms() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Rooms.fxml"))
        );
        Stage window = (Stage) btnRooms.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneCourses() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Courses.fxml"))
        );
        Stage window = (Stage) btnCourses.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneLessons() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Lessons.fxml"))
        );
        Stage window = (Stage) btnLessons.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));

        window.show();

    }

    public void switchToSceneSchedule() throws IOException {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Schedule.fxml"))
        );
        Stage window = (Stage) btnSchedule.getScene().getWindow();
        window.setScene(new Scene(root, 950, 950));
        window.show();
    }

    //******* Hyperlink method!!! *******\\


}
